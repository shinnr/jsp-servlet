package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

import org.apache.commons.beanutils.BeanUtils;

public class InsertMemberController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
				request.setCharacterEncoding("UTF-8");

				MemberVO memberInfo = new MemberVO();
				
				try {

					BeanUtils.populate(memberInfo, request.getParameterMap());
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				IMemberService service = IMemberServiceImpl.getInstance();
				service.insertMember(memberInfo);
				
				response.sendRedirect("/ServletToddler/member/memberList");
	}

	
}
