<%@page import="kr.or.ddit.vo.BuyerVO"%>
<%@page import="kr.or.ddit.buyer.service.BuyerServiceImpl"%>
<%@page import="kr.or.ddit.buyer.service.IBuyerService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="mainURI" value="/12/main.jsp"></c:url>
<c:url var="deleteBuyerInfoURI" value="/12/deleteBuyerInfo.jsp"></c:url>
<c:url var="updateBuyerInfoURI" value="/12/updateBuyerInfo.jsp"></c:url>
<%
	String buyer_id = request.getParameter("buyer_id");

	IBuyerService service = BuyerServiceImpl.getInstance();
	BuyerVO buyerInfo = service.buyerInfo(buyer_id);
	
	request.setAttribute("buyerInfo", buyerInfo);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type='text/javascript' src='http://code.jquery.com/jquery-latest.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/common/validation.js'></script> 
<script type="text/javascript">
	$(function() {
		$('#btn2').on('click', function() {
			location.replace("${deleteBuyerInfoURI}?buyer_id=${buyerInfo.buyer_id}");			
		});
		$('#btn4').on('click', function() {
			location.replace("${mainURI}");
		});
	})
</script>
</head>
<style>
.fieldName {text-align: center; background-color: #f4f4f4;}
.tLine {background-color: #d2d2d2; height: 1px;}
.btnGroup { text-align: right; }
td {text-align: left; }
</style>
<body>
<form name="buyerForm" action="${updateBuyerInfoURI }" method="post">
<table width="600" border="0" cellpadding="0" cellspacing="0">

	<tr>
		<td class="fieldName" width="100px" height="25">거래처코드</td>
		<td>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input class="mdl-textfield__input" type="hidden" id="buyer_id" name="buyer_id" value="${buyerInfo.buyer_id }">
				<input class="mdl-textfield__input" type="text" id="buyer_id" name="buyer_id" value="${buyerInfo.buyer_id }" disabled="disabled">
				<label class="mdl-textfield__label" for="buyer_id">거래처코드</label>
			</div>
		</td>
	</tr>
	<tr>
		<td class="fieldName" width="100px" height="25">거래처명</td>
		<td>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input class="mdl-textfield__input" type="text" id="buyer_name" name="buyer_name" value="${buyerInfo.buyer_name }">
				<label class="mdl-textfield__label" for="buyer_name">거래처명</label>
			</div>
		</td>
	</tr>
	<tr>
		<td class="fieldName" width="100px" height="25">담당자</td>
		<td>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input class="mdl-textfield__input" type="text" id="buyer_charger" name="buyer_charger" value="${buyerInfo.buyer_charger }">
				<label class="mdl-textfield__label" for="buyer_charger">담당자명</label>
			</div>			
		</td>
	</tr>
	
	<tr>
		<td class="fieldName" width="100px" height="25">거래은행</td>
		<td>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input class="mdl-textfield__input" type="text" id="buyer_bank" name="buyer_bank" value="${buyerInfo.buyer_bank }">
				<label class="mdl-textfield__label" for="buyer_bank">거래은행</label>
			</div>			
		</td>
	</tr>
	
	<tr>
		<td class="fieldName" width="100px" height="25">거래처주소1</td>
		<td>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input class="mdl-textfield__input" type="text" id="buyer_add1" name="buyer_add1" value="${buyerInfo.buyer_add1 }">
				<label class="mdl-textfield__label" for="buyer_add1">거래처주소1</label>
			</div>			
		</td>
	</tr>
	
	<tr>
		<td class="fieldName" width="100px" height="25">거래처주소2</td>
		<td>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input class="mdl-textfield__input" type="text" id="buyer_add2" name="buyer_add2" value="${buyerInfo.buyer_add2 }">
				<label class="mdl-textfield__label" for="buyer_add2">거래처주소2</label>
			</div>
		</td>
	</tr>
</table>
<table width="600" border="0" cellpadding="0" cellspacing="0" style="margin-top: 10px;">
	<tr>
		<td class="fieldName" width="100px" height="25">전화번호</td>
		<td>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input class="mdl-textfield__input" type="text" id="buyer_comtel" name="buyer_comtel" value="${buyerInfo.buyer_comtel }">
				<label class="mdl-textfield__label" for="buyer_comtel">전화번호</label>
			</div>		
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr>
		<td class="fieldName" width="100px" height="25">팩스번호</td>
		<td>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input class="mdl-textfield__input" type="text" id="buyer_fax" name="buyer_fax" value="${buyerInfo.buyer_fax }">
				<label class="mdl-textfield__label" for="buyer_fax">팩스번호</label>
			</div>
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr>
		<td class="fieldName" width="300px" height="25">거래처메일</td>
		<td>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input class="mdl-textfield__input" type="text" id="buyer_mail" name="buyer_mail" value="${buyerInfo.buyer_mail }">
				<label class="mdl-textfield__label" for="buyer_mail">거래처메일</label>
			</div>
		</td>
	</tr>
	
	<tr><td colspan="2" height="20"></td></tr>
	
	<tr>
		<td class="btnGroup" colspan="2" >
			<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="btn1" type="submit">거래처정보 수정</button>
			<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="btn2" type="button">거래처정보 삭제</button>
			<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="btn3" type="button">취소</button>
			<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="btn4" type="button">목록</button>
		</td>
	</tr>
</table>
</form>
</body>
</html>








