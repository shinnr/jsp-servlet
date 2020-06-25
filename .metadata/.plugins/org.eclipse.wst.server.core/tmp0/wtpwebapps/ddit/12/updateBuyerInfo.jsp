<%@page import="org.apache.commons.beanutils.BeanUtils"%>
<%@page import="kr.or.ddit.vo.BuyerVO"%>
<%@page import="kr.or.ddit.buyer.service.IBuyerService"%>
<%@page import="kr.or.ddit.buyer.service.BuyerServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//request.setCharacterEncoding("UTF-8");
	BuyerVO buyerInfo = new BuyerVO();
	
	BeanUtils.populate(buyerInfo, request.getParameterMap());
	
	IBuyerService service = BuyerServiceImpl.getInstance();
	service.updateBuyerInfo(buyerInfo);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/12/main.jsp");
	dispatcher.forward(request, response);
%>
