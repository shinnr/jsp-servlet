package kr.or.ddit.buyer.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.BuyerVO;

public interface IBuyerService {
	public List<BuyerVO> buyerList(Map<String,String> params);
	public List<Map<String, String>> buyerListAll(Map<String,String> params);
	public BuyerVO buyerInfo(String params);
	public void deleteBuyerInfo(String buyer_id);
	public void updateBuyerInfo(BuyerVO buyerInfo);
	public void insertBuyerInfo(BuyerVO buyerInfo);
	public String selectBuyerId(String buyer_lgu);
	public String totalCount(Map<String, String> params);
}
