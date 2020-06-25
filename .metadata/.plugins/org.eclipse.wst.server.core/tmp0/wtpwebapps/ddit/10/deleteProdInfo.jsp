<%@page import="kr.or.ddit.prod.service.ProdServiceImpl"%>
<%@page import="kr.or.ddit.prod.service.IProdService"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String prod_id = request.getParameter("prod_id");
	
	Map<String, String> params = new HashMap<String, String>();
	params.put("prod_id", prod_id);
	
	IProdService service = ProdServiceImpl.getInstance();
	service.deleteProdInfo(params);
 
	RequestDispatcher dispatcher = request.getRequestDispatcher("/10/main.jsp");
	dispatcher.forward(request, response);

%>