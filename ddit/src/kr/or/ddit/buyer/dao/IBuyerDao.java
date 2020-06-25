package kr.or.ddit.buyer.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.BuyerVO;

public interface IBuyerDao {
	public List<BuyerVO> buyerList(Map<String,String> params) throws Exception;
	public List<Map<String, String>> buyerListAll(Map<String,String> params) throws Exception;
	public BuyerVO buyerInfo(String params) throws Exception;
	public void deleteBuyerInfo(String buyer_id) throws Exception;
	public void updateBuyerInfo(BuyerVO buyerInfo) throws Exception;
	public void insertBuyerInfo(BuyerVO buyerInfo) throws Exception;
	public String selectBuyerId(String buyer_lgu) throws Exception;
}
