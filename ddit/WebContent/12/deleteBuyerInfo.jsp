<%@page import="kr.or.ddit.buyer.service.BuyerServiceImpl"%>
<%@page import="kr.or.ddit.buyer.service.IBuyerService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String buyer_id = request.getParameter("buyer_id");
	
	IBuyerService service = BuyerServiceImpl.getInstance();
	service.deleteBuyerInfo(buyer_id);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/12/main.jsp");
	dispatcher.forward(request, response);
%>