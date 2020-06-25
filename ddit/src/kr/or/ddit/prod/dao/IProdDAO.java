package kr.or.ddit.prod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.LProdVO;
import kr.or.ddit.vo.ProdVO;

public interface IProdDAO {
	public List<ProdVO> prodList(Map<String, String> params) throws Exception;
	public ProdVO prodInfo(Map<String, String> params) throws Exception;
	public void insertProdInfo(ProdVO prodVO) throws Exception;
	public void updateProdInfo(ProdVO prodVO) throws Exception;
	public void deleteProdInfo(Map<String, String> params) throws Exception;
	public List<LProdVO> lprodList() throws Exception;
	
}
