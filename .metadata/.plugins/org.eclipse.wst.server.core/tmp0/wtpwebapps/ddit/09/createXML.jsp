<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.service.IMemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   // xml 데이터 응답객체를 통해 브라우저에 전송.
   IMemberService service = IMemberServiceImpl.getInstance();
   List<MemberVO> memberList = service.memberList();
   
   out.println("<members>");
   for(MemberVO memberInfo : memberList) {
      out.println("<member id='" + memberInfo.getMem_id() + "'>");
         out.println("<mem_pass>" + memberInfo.getMem_pass() + "</mem_pass>");
         out.println("<mem_name>" + memberInfo.getMem_name() + "</mem_name>");
         out.println("<mem_regno1>" + memberInfo.getMem_regno1() + "</mem_regno1>");
         out.println("<mem_regno2>" + memberInfo.getMem_regno2() + "</mem_regno2>");
         out.println("<mem_bir>" + memberInfo.getMem_bir() + "</mem_bir>");
         out.println("<mem_zip>" + memberInfo.getMem_zip() + "</mem_zip>");
         out.println("<mem_add1>" + memberInfo.getMem_add1() + "</mem_add1>");
         out.println("<mem_add2>" + memberInfo.getMem_add2() + "</mem_add2>");
         out.println("<mem_hometel>" + memberInfo.getMem_hometel() + "</mem_hometel>");
         out.println("<mem_comtel>" + memberInfo.getMem_comtel() + "</mem_comtel>");
         out.println("<mem_hp>" + memberInfo.getMem_hp() + "</mem_hp>");
         out.println("<mem_mail>" + memberInfo.getMem_mail() + "</mem_mail>");
         out.println("<mem_job>" + memberInfo.getMem_job() + "</mem_job>");
         out.println("<mem_like>" + memberInfo.getMem_like() + "</mem_like>");
         out.println("<mem_memorial>" + memberInfo.getMem_memorial() + "</mem_memorial>");
         out.println("<mem_memorialday>" + memberInfo.getMem_memorialday() + "</mem_memorialday>");
         out.println("<mem_mileage>" + memberInfo.getMem_mileage() + "</mem_mileage>");
      out.println("</member>");
   }
   out.println("</members>");
%>