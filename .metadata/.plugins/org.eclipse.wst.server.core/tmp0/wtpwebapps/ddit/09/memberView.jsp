<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="kr.or.ddit.member.service.IMemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:url var="deleteMemberInfoURI" value="/09/deleteMemberInfo.jsp"></c:url>
<c:url var="mainURI" value="/09/main.jsp"></c:url>
<c:url var="updateMemberURI" value="/09/updateMember.jsp"></c:url>
<%
	String mem_id = request.getParameter("mem_id");

	Map<String, String> params = new HashMap<String, String>();
	params.put("mem_id", mem_id);
	
	IMemberService service = IMemberServiceImpl.getInstance();
	MemberVO memberInfo = service.memberInfo(params);
	
	request.setAttribute("memberInfo", memberInfo);
	
	// hometell
	String hometel = memberInfo.getMem_hometel();
	String ht[] = hometel.split("-");
	request.setAttribute("ht", ht);
	
	// hp
	String phone = memberInfo.getMem_hp();
	String hp[] = phone.split("-");
	request.setAttribute("hp", hp);
	
	// email
	String email = memberInfo.getMem_mail();
	String mail[] = email.split("@");
	request.setAttribute("mail", mail);
	
	// add
	String zip = memberInfo.getMem_zip();
	String zip1[] = zip.split("-");
	request.setAttribute("zip1", zip1);
	
	

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type='text/javascript' src='http://code.jquery.com/jquery-latest.js'></script>
<script type="text/javascript">
	$(function(){
		/* $("#mem_hometel1 > option:selected").val(ht[0]);
		$("#mem_hometel1 option:selected").text(ht[0]);
		$("#mem_hometel1>option[@value=ht[0]]").attr("selected","true"); */
		$('form').submit(function(){
	         $('input[name=mem_bir]').val($('input[name=mem_bir1]').val()+'-'+$('input[name=mem_bir2]').val()+'-'+$('input[name=mem_bir3]').val());
	         $('input[name=mem_zip]').val($('input[name=mem_zip1]').val()+'-'+$('input[name=mem_zip2]').val());
	         $('input[name=mem_hometel]').val($('select[name=mem_hometel1]').val()+'-'+$('input[name=mem_hometel2]').val()+'-'+$('input[name=mem_hometel3]').val());
	         $('input[name=mem_mail]').val($('input[name=mem_mail1]').val()+'@'+$('select[name=mem_mail2]').val());
	         $('input[name=mem_comtel]').val($('select[name=mem_comtel1]').val()+'-'+$('input[name=mem_comtel2]').val()+'-'+$('input[name=mem_comtel3]').val());
	         $('input[name=mem_hp]').val($('select[name=mem_hp1]').val()+'-'+$('input[name=mem_hp2]').val()+'-'+$('input[name=mem_hp3]').val());
	      });
		
		$('#btn3').on('click', function() {
			location.replace('${deleteMemberInfoURI}?mem_id=${memberInfo.mem_id}');
		});
		
		$('#btn4').on('click', function() {
			location.replace('${mainURI}');
		})
	});
</script>
</head>
<style>
.fieldName {text-align: center; background-color: #f4f4f4;}
.tLine {background-color: #d2d2d2; height: 1px;}
.btnGroup { text-align: right; }
td {text-align: left; }
</style>
<body>
<form name="memberForm" action="${updateMemberURI}" method="post">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<input type="hidden" name="mem_id" value="${memberInfo.mem_id }">
	<tr><td class="tLine" colspan="2"></td></tr>
	<tr><td rowspan="13" class="pic" colspan="2" style="vertical-align: bottom; width: 150px; text-align: center;">
			<img src="${pageContext.request.contextPath }/image/btn_pic.gif" alt="사진올리기" class="btn" title="인적사항에 올릴 증명	을 검색합니다." 
				style="cursor: pointer;"/><br/>
			<div style="width: 100%" align="center">
				size : 235x315 이하
			</div>
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	<tr>
		<td class="fieldName" width="100px" height="25">성 명</td>
		<td>
			<input type="text" name="mem_name" value="${memberInfo.mem_name }" disabled="disabled"/>
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	<tr>
		<td class="fieldName" width="100px" height="25">주민등록번호</td>
		<td>
			<input type="text" name="mem_regno1" size="6" value="${memberInfo.mem_regno1 }" disabled="disabled"/>
  			<input type="text" name="mem_regno2" size="7" value="${memberInfo.mem_regno1 }" disabled="disabled"/>
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr>
		<td class="fieldName" width="100px" height="25">생년월일</td>
		<td>
			<input type="hidden" name="mem_bir" />
			<%-- <input type="text" name="mem_bir1" size="4" value="<%=memberInfo.getMem_bir().substring(0,4)%>" disabled="disabled"/>년
            <input type="text" name="mem_bir3" size="2" value="<%=memberInfo.getMem_bir().substring(8,11)%>" disabled="disabled"/>일
            <input type="text" name="mem_bir2" size="2" value="<%=memberInfo.getMem_bir().substring(5,7)%>" disabled="disabled"/>월 --%>
			<input type="text" name="mem_bir1" size="4" value="${fn:substring(memberInfo.mem_bir, 0, 4)}" disabled="disabled"/>년
			<input type="text" name="mem_bir1" size="4" value="${fn:substring(memberInfo.mem_bir, 5, 7)}" disabled="disabled"/>월
			<input type="text" name="mem_bir1" size="4" value="${fn:substring(memberInfo.mem_bir, 8, 11)}" disabled="disabled"/>일
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr>
		<td class="fieldName" width="100px" height="25">아이디</td>
		<td>
			<input type="text" name="mem_id" value="${memberInfo.mem_id }" disabled="disabled">
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr>
		<td class="fieldName" width="100px" height="25">비밀번호</td>
		<td>
			<input type="text" name="mem_pass" value="${memberInfo.mem_pass }" /> 8 ~ 20 자리 영문자 및 숫자 사용
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr>
		<td class="fieldName" width="100px" height="25">비밀번호확인</td>
		<td>
			<input type="text" name="mem_pass_confirm" value="${memberInfo.mem_pass }" /> 8 ~ 20 자리 영문자 및 숫자 사용
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="margin-top: 10px;">
	<tr>
		<td class="fieldName" width="100px" height="25">전화번호</td>
		<td>
			<div>
			<input type="hidden" name="mem_hometel" id="mem_hometel1"/>
			<select name="mem_hometel1">
				<option value="02">02</option>
				<option value="031">031</option>
				<option value="032">032</option>								        	
				<option value="033">033</option>				        	
				<option value="041">041</option>
				<option value="042">042</option>				        	
				<option value="043">043</option>				        	
				<option value="051">051</option>				        	
				<option value="052">052</option>
				<option value="053">053</option>				        					        	
				<option value="061">061</option>
				<option value="062">062</option>
				<option value="063">063</option>				        					        					        	
				<option value="064">064</option>				        					        					        	
				<option value="070">070</option>				        					        					        	
			</select>	- 	
			<%-- <input type="text" name="mem_hometel2" size="4" value="<%=ht[1] %>" />
			<input type="text" name="mem_hometel3" size="4" value="<%=ht[2] %>" /> --%>
			<input type="text" name="mem_hometel2" size="4" value="${ht[1]}" /> - 
			<input type="text" name="mem_hometel2" size="4" value="${ht[2]}" />
			</div>
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr>
		<td class="fieldName" width="100px" height="25">핸드폰</td>
		<td>
			<input type="hidden" name="mem_hp"/>
			<select name="mem_hp1">
				<option value="010">010</option>
				<option value="016">016</option>				        	
				<option value="017">017</option>				        	
				<option value="019">019</option>				        	
			</select>	-
			<%-- <input type="text" name="mem_hp2" size="4" value="<%=hp[1] %>" /> - 
			<input type="text" name="mem_hp3" size="4" value="<%=hp[2] %>" /> --%>
			<input type="text" name="mem_hp3" size="4" value="${hp[1] }" />-
			<input type="text" name="mem_hp3" size="4" value="${hp[2] }" />
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
	
	<tr>
		<td class="fieldName" width="100px" height="25">이메일</td>
		<td>
			<input type="hidden" name="mem_mail" />
			<%-- <input type="text" name="mem_mail1" value="<%=mail[0] %>" /> @ --%>
			<input type="text" name="mem_mail1" value="${mail[0] }" /> @
			<select name="mem_mail2">
				<option value="naver.com">naver.com</option>
				<option value="daum.net">daum.net</option>
				<option value="hanmail.net">hanmail.net</option>
				<option value="nate.com">nate.com</option>
				<option value="gmail.com">gmail.com</option>				
			</select>
		</td>
	</tr>
	<tr><td class="tLine" colspan="2"></td></tr>
		
	<tr>
      <td class="fieldName" width="100px" height="25">주소</td>
      <td>
         <input type="hidden" name="mem_zip" />
         <input type="text" name="mem_zip1" id="mem_zip1" size="3" value="${zip1[0]}" /> - 
         <input type="text" name="mem_zip2" id="mem_zip2" size="3" value="${zip1[1]}" />
         <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent">우편번호검색</button><br>
         <input type="text" name="mem_add1" id="mem_add1" value="${memberInfo.mem_add1 }" />
         <input type="text" name="mem_add2" id="mem_add2" value="${memberInfo.mem_add2 }" />
      </td>
   </tr>
   <tr><td class="tLine" colspan="2"></td></tr>
   <tr>
      <td class="fieldName" width="100px" height="25">직 업</td>
      <td>
         <input type="text" name="mem_job" value="${memberInfo.mem_job }"/>
      </td>
   </tr>
   <tr><td class="tLine" colspan="2"></td></tr>
   <tr>
      <td class="fieldName" width="100px" height="25">취 미</td>
      <td>
         <input type="text" name="mem_like" value="${memberInfo.mem_like }"/>
      </td>
   </tr>
   <tr><td class="tLine" colspan="2"></td></tr>
   
   <tr><td colspan="2" height="20"></td></tr>
   
   <tr>
      <td class="btnGroup" colspan="2" >
         <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="btn1" type="submit">수정하기</button>
         <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="btn2" type="reset">취소</button>
         <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="btn3" type="button">삭제</button>
         <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="btn4" type="button">목록</button>
      </td>
   </tr>
</table>
</form>
</body>
</html>









