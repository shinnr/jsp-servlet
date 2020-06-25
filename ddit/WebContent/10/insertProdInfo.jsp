<%@page import="kr.or.ddit.prod.service.ProdServiceImpl"%>
<%@page import="kr.or.ddit.prod.service.IProdService"%>
<%@page import="kr.or.ddit.vo.ProdVO"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.member.service.IMemberServiceImpl"%>
<%@page import="java.lang.reflect.InvocationTargetException"%>
<%@page import="org.apache.commons.beanutils.BeanUtils"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//request.setCharacterEncoding("UTF-8");
	
	ProdVO prodInfo = new ProdVO();
	
	try {
	
		BeanUtils.populate(prodInfo, request.getParameterMap());
	} catch (IllegalAccessException e) {
		e.printStackTrace(); 
	} catch (InvocationTargetException e) {
		e.printStackTrace();
	}
	
	IProdService service = ProdServiceImpl.getInstance();
	service.insertProdInfo(prodInfo);
	
	response.sendRedirect(request.getContextPath() + "/10/main.jsp");
%>