package zero33.easybatch.ctrl4.transaction;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.easybatch.core.api.RecordProcessor;
import org.easybatch.core.api.event.step.RecordProcessorEventListener;
import org.easybatch.core.filter.HeaderRecordFilter;
import org.easybatch.core.impl.Engine;
import org.easybatch.core.impl.EngineBuilder;
import org.easybatch.flatfile.FlatFileRecordReader;
import org.easybatch.flatfile.dsv.DelimitedRecordMapper;
import zero16_ibatis.build.BuildedSqlMapClient;
import zero33.easybatch.MemberBean;
import com.ibatis.sqlmap.client.SqlMapClient;

public class TestMain_RecordBaseEventListener {

	private static SqlMapClient client = null;
	
	public static void main(String[] args) {
		EngineBuilder engineBuilder = new EngineBuilder();
		File members;
		try {
			members = new File(TestMain_RecordBaseEventListener.class.getResource("/zero33/easybatch/member.csv").toURI());
			
			// 첨부된 easyBatch_pic04.jpg와 easyBatch_pic06.jpg, easyBatch_pic07.jpg 참조
			// FlatFileRecordReader : CSV(Comma Separated Value) 전용 Reader
			engineBuilder.reader(new FlatFileRecordReader(members));
			
			// CSV 파일내 선언된 Header와 DelimitedRecordMapper에 선언된 String 배열 형식의 헤더와의 맵핑 여부 검증 및
			// 개별 레코드의 MemberBean객체 맵핑(setter를 활용한 레코드내 컬럼값의 MemberBean 셋팅) 
			engineBuilder.filter(new HeaderRecordFilter());
			engineBuilder.mapper(new DelimitedRecordMapper<MemberBean>(MemberBean.class, 
					new String[]{"mem_id","mem_pass","mem_name","mem_regno1",
				"mem_regno2","mem_bir","mem_zip","mem_add1",
				"mem_add2","mem_hometel","mem_comtel","mem_hp",
				"mem_mail","mem_job","mem_like","mem_memorial",
				"mem_memorialday","mem_mileage"}));
			
			engineBuilder.processor(new TestMain_RecordBaseEventListener().new MemberInfoLoader());
			
			// 레코드 단위 프로세싱 대상 이벤트 리스너 등록
			engineBuilder.recordProcessorEventListener(new TransactionProcessingEventListener());
			
			Engine engine = engineBuilder.build();
			
			engine.call();                                                                  // 정상 : 3        비정상 : 3
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static SqlMapClient getIBatisClient(){
		return BuildedSqlMapClient.getSqlMapClient();
	}

	class MemberInfoLoader implements RecordProcessor<MemberBean, MemberBean>{
		
		public MemberInfoLoader() {                                                          // 정상 : 1            비정상 : 1
			client = getIBatisClient();
		}

		// 익셉션 발생시 
		@Override
		public MemberBean processRecord(MemberBean memberInfo) throws Exception {            // 정상 : 5,8         비정상 : 5,9
			// members.csv 파일 내 개별 레코드를 구성하는 각 컬럼의 setter를통한 MemberBean 객체 맵핑 후 input
			// zero16_ibatis/mapper/member.xml내 updateMileage
			String mem_id = String.valueOf(memberInfo.getMem_id().charAt(0));
			String targetId = "abcd";
			if(targetId.contains(mem_id)){
				memberInfo.setMem_mileage(String.valueOf(Integer.parseInt(memberInfo.getMem_mileage())+ 100));
				client.update("member.updateMileageBatchProcessing", memberInfo);
			}
			return memberInfo;
		}
	}
	
	static class TransactionProcessingEventListener implements RecordProcessorEventListener{
		private boolean commitFlag = true;
		
		public TransactionProcessingEventListener() {                                        // 정상 : 2            비정상 : 2
			System.out.println("트랜잭션 시작");
		}

		@Override
		public void beforeProcessingRecord(Object record) {                                  // 정상 : 4,7          비정상 : 4,8
			System.out.println("member.csv로부터 레코드 단위로 Reading 시작시 매번 콜백");
			try {
				client.startTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
		@Override
		public void afterProcessingRecord(Object record, final Object result) {              // 정상 : 6,9          비정상 : 7,11
			if(commitFlag){
				System.out.println("정상적인 Record Processing 처리 완료 후 콜백");
				try {
					client.commitTransaction();
					client.endTransaction();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else{
				System.out.println("또는 비정상적인 Record Processing 처리로 onRecordProcessingException() 콜백 후 콜백");
				try {
					client.endTransaction();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		@Override
		public void onRecordProcessingException(Object record, Throwable throwable) {        //                비정상 : 6,10
			System.out.println("비정상적인 Record Processing 처리로 Exception 발생시 콜백");
			commitFlag = false;
		}
	}
}











