package kr.or.ddit.prod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.prod.dao.IProdDAO;
import kr.or.ddit.prod.dao.ProdDAOImpl;
import kr.or.ddit.vo.LProdVO;
import kr.or.ddit.vo.ProdVO;

public class ProdServiceImpl implements IProdService{
	private static IProdService service = new ProdServiceImpl();
	private IProdDAO dao;
	
	private ProdServiceImpl(){
		dao = ProdDAOImpl.getInstance();
	}
	
	public static IProdService getInstance(){
		return (service == null) ? service = new ProdServiceImpl(): service;
	}
	
	
	@Override
	public List<ProdVO> prodList(Map<String, String> params) {
		List<ProdVO> list = null;
		try {
			list = dao.prodList(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ProdVO prodInfo(Map<String, String> params) {
		ProdVO prodInfo = null;
		try {
			prodInfo = dao.prodInfo(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prodInfo;
		
	}

	@Override
	public void insertProdInfo(ProdVO prodVO) {
		try {
			dao.insertProdInfo(prodVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateProdInfo(ProdVO prodVO) {
		try {
			dao.updateProdInfo(prodVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProdInfo(Map<String, String> params) {
		try {
			dao.deleteProdInfo(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<LProdVO> lprodList() {
		List<LProdVO> lprodList = null;
		try {
			lprodList = dao.lprodList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lprodList;
	}

	@Override
	public String totalCount(Map<String, String> params) {
		String totalCount = null;
		try{
			totalCount = dao.totalCount(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return totalCount;
	}

}
