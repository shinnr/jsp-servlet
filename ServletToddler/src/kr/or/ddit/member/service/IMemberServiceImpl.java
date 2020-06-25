package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.dao.IMemberDAO;
import kr.or.ddit.member.dao.IMemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class IMemberServiceImpl implements IMemberService{
	//싱글톤 패턴
	private static IMemberService service = new IMemberServiceImpl();
	private IMemberDAO dao;
	
	private IMemberServiceImpl(){
		dao = IMemberDAOImpl.getInstance();
	}
	
	public static IMemberService getInstance(){
		return (service == null) ? service = new IMemberServiceImpl(): service;
	}
	
	
	@Override
	public MemberVO memberInfo(Map<String, String> params) {
		MemberVO memberInfo = null;
		try {
			memberInfo = dao.memberInfo(params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberInfo;
	}

	@Override
	public List<MemberVO> memberList() {
		List<MemberVO> memberList = null;
		try{
			memberList = dao.memberList();			
		}catch(Exception e1){
			e1.printStackTrace();
		}
		return memberList;
	}

	@Override
	public void deleteMemberInfo(Map<String, String> params) {
		try{
			dao.deleteMemberInfo(params);
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}

	@Override
	public void updateMemberInfo(MemberVO memberInfo) {
		try{
			dao.updateMemberInfo(memberInfo);
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}

	@Override
	public void insertMember(MemberVO memberInfo) {
		try {
			dao.insertMember(memberInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}