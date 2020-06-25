<%@page import="java.net.URLEncoder"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="kr.or.ddit.member.service.IMemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mem_id = request.getParameter("mem_id");
	String mem_pass = request.getParameter("mem_pass");
	
	Map<String, String> params = new HashMap<String, String>();
	params.put("mem_id", mem_id);
	params.put("mem_pass", mem_pass);
	
	IMemberService service = IMemberServiceImpl.getInstance();
	MemberVO memberInfo = service.memberInfo(params);
	
	System.out.println(memberInfo.getMem_id());
	
	if(memberInfo == null){
		String message = URLEncoder.encode("회원이 아닙니다." , "UTF-8");
		response.sendRedirect(request.getContextPath() + "/06/loginForm.jsp?message=" + message);
		
		
	}else{
		//인증된 회원
		session.setAttribute("LOGINMEMBERINFO", memberInfo);
		response.sendRedirect(request.getContextPath() + "/06/memberList.jsp");
		
	}
%>
