package kr.or.ddit.freeboard.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.FreeboardVO;

public class IFreeboardDAOImpl implements IFreeboardDAO {
	private static IFreeboardDAO dao = new IFreeboardDAOImpl();
	private SqlMapClient client;
	
	private IFreeboardDAOImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IFreeboardDAO getInstance(){
		return (dao == null) ? dao = new IFreeboardDAOImpl() : dao;
	}
	
	@Override
	public List<FreeboardVO> freeboardList(Map<String, String> params) throws Exception {
		return client.queryForList("freeboard.freeboardList", params);
	}

	@Override
	public String insertFreeboard(FreeboardVO freeboardInfo) throws Exception {
		return (String) client.insert("freeboard.insertFreeboard", freeboardInfo);
	}

	@Override
	public FreeboardVO freeboardInfo(Map<String, String> params)
			throws Exception {
		return (FreeboardVO) client.queryForObject("freeboard.freeboardInfo", params);
	}

	@Override
	public void deleteFreeboard(Map<String, String> params) throws Exception {
		client.update("freeboard.deleteFreeboard", params);
	}

	@Override
	public void updateFreeboard(FreeboardVO freeboardInfo) throws Exception {
		client.update("freeboard.updateFreeboard", freeboardInfo);
	}

	@Override
	public String insertFreeboardReply(FreeboardVO freeboardInfo)
			throws Exception {
		//freeboardInfo : 댓글정보(bo_title, bo_nickname, bo_pwd, bo_mail, bo_content, bo_writer, bo_ip)
		//				 부모 게시글 정보 (bo_group, bo_seq, bo_depth)
		String bo_no = "";
		try{
			client.startTransaction();
			
			String bo_seq;
			if("0".intern() == freeboardInfo.getBo_seq().intern()){
				bo_seq = (String) client.queryForObject("freeboard.incrementSeq", freeboardInfo);
			}else{
				client.update("freeboard.updateSeq", freeboardInfo);
				bo_seq = String.valueOf(Integer.parseInt(freeboardInfo.getBo_seq()) + 1);
			}
			freeboardInfo.setBo_seq(bo_seq);
			
			String bo_depth = String.valueOf(Integer.parseInt(freeboardInfo.getBo_depth()) + 1);
			freeboardInfo.setBo_depth(bo_depth);

			bo_no = (String) client.insert("freeboard.insertFreeboardReply", freeboardInfo);
			
			client.commitTransaction();
		}finally{
			client.endTransaction();
		}
		return bo_no;
	}

	@Override
	public String totalCount(Map<String, String> params) throws Exception {
		return (String) client.queryForObject("freeboard.totalCount", params);
	}

}
