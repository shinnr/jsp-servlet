package kr.or.ddit.prod.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.member.dao.IMemberDAO;
import kr.or.ddit.member.dao.IMemberDAOImpl;
import kr.or.ddit.vo.LProdVO;
import kr.or.ddit.vo.ProdVO;

public class ProdDAOImpl implements IProdDAO{
	private static IProdDAO dao = new ProdDAOImpl();
	private SqlMapClient client;
	
	private ProdDAOImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IProdDAO getInstance(){
		return (dao == null) ? dao = new ProdDAOImpl() : dao;
	}
	
	
	@Override
	public List<ProdVO> prodList(Map<String, String> params) throws Exception {
		return client.queryForList("prod.prodList", params);
	}

	@Override
	public ProdVO prodInfo(Map<String, String> params) throws Exception {
		return (ProdVO) client.queryForObject("prod.prodInfo",params);
	}

	@Override
	public void insertProdInfo(ProdVO prodVO) throws Exception {
		client.insert("prod.insertProdInfo", prodVO);
		
	}

	@Override
	public void updateProdInfo(ProdVO prodVO) throws Exception {
		client.update("prod.updateProdInfo", prodVO);
	}

	@Override
	public void deleteProdInfo(Map<String, String> params) throws Exception {
		client.delete("prod.deleteProdInfo", params);
	}

	@Override
	public List<LProdVO> lprodList() throws Exception {
		return client.queryForList("prod.lprodList");
	}

}
