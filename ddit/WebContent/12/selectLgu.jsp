<%@page import="org.codehaus.jackson.map.ObjectMapper"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.buyer.service.BuyerServiceImpl"%>
<%@page import="kr.or.ddit.buyer.service.IBuyerService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String lgu = request.getParameter("lgu");   
   String lgu1 = "";
   String lgu2 = "";
   Map<String,String> params = new HashMap<String,String>();

   IBuyerService service = BuyerServiceImpl.getInstance();
   String buyer_lgu = service.selectBuyerId(lgu);
   //P10103
   if(buyer_lgu==null){
      lgu1 = lgu+"01";
      params.put("lgu", lgu1);
   }else{
      lgu1 = buyer_lgu.substring(0,1);
      lgu2 = buyer_lgu.substring(1,buyer_lgu.length());
      int num = Integer.parseInt(lgu2)+1;
      lgu = lgu1.concat(Integer.toString(num));
      params.put("lgu", lgu);
   }

   ObjectMapper jsonDataConvertor = new ObjectMapper();
   String jsonData = jsonDataConvertor.writeValueAsString(params);
   out.print(jsonData);
   
%>