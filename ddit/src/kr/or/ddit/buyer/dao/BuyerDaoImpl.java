package kr.or.ddit.buyer.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.zipcode.dao.IZipcodeDAOImpl;

public class BuyerDaoImpl implements IBuyerDao {
	private static IBuyerDao dao = new BuyerDaoImpl();
	private SqlMapClient client;
	
	private BuyerDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IBuyerDao getInstance(){
		return (dao == null) ? dao = new BuyerDaoImpl() : dao;
	}
	
	
	@Override
	public List<BuyerVO> buyerList(Map<String, String> params) throws Exception {
		return client.queryForList("buyer.buyerList", params);
	}

	@Override
	public List<Map<String, String>> buyerListAll(Map<String,String> params) throws Exception {
		return client.queryForList("buyer.buyerListAll", params);
	}

	@Override
	public BuyerVO buyerInfo(String params) throws Exception {
		return (BuyerVO) client.queryForObject("buyer.buyerInfo", params);
	}

	@Override
	public void deleteBuyerInfo(String buyer_id) throws Exception {
		client.update("buyer.deleteBuyerInfo", buyer_id);
	}

	@Override
	public void updateBuyerInfo(BuyerVO buyerInfo) throws Exception {
		client.update("buyer.updateBuyerInfo", buyerInfo);
	}

	@Override
	public void insertBuyerInfo(BuyerVO buyerInfo) throws Exception {
		client.insert("buyer.insertBuyerInfo", buyerInfo);
	}

	@Override
	   public String selectBuyerId(String buyer_lgu) throws Exception {
	      return (String)client.queryForObject("buyer.selectBuyerId",buyer_lgu);
	   }


}
