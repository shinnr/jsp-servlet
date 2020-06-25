<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.service.IMemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="mainURI" value="/09/main.jsp">
	<c:param name="contentPage" value="/09/memberView.jsp"></c:param>
</c:url>
    
<%
	String serach_keyword = request.getParameter("search_keyword");
	String serach_keycode = request.getParameter("search_keycode");
	
	Map<String, String> params = new HashMap<String, String>();
	params.put("search_keyword", serach_keyword);
	params.put("search_keycode", serach_keycode);
	
	
	IMemberService service = IMemberServiceImpl.getInstance();
	List<MemberVO> memberList = service.memberList(params);
	
	request.setAttribute("memberList", memberList);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type='text/javascript' src='http://code.jquery.com/jquery-latest.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/common/validation.js'></script> 
<script type="text/javascript">
	$(function(){
		$('table tr:gt(0)').click(function(){
			var mem_id = $(this).find('td:eq(0)').text();
			//location.href = '/ddit/06/memberView.jsp?mem_id='+ mem_id;
			location.replace('${mainURI}?mem_id=' + mem_id);
		});
	});		
</script>

</head>
<body>
<div id="list">
	<table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp" style="width: 100%;">
		<thead>
			<tr>
				<th class="mdl-data-table__cell--non-numeric">아이디</th>
				<th class="mdl-data-table__cell--non-numeric">패스워드</th>
				<th class="mdl-data-table__cell--non-numeric">이름</th>
				<th class="mdl-data-table__cell--non-numeric">직업</th>
				<th class="mdl-data-table__cell--non-numeric">취미</th>
			</tr>
		</thead>
		<tbody>
		<%-- <%
			for(int i=0; i<memberList.size(); i++){
		%>
			<tr>                                                      
				<td><%=memberList.get(i).getMem_id() %></td>                  
				<td><%=memberList.get(i).getMem_name() %></td>                  
				<td><%=memberList.get(i).getMem_regno1() %></td>                  
				<td><%=memberList.get(i).getMem_job() %></td>                  
				<td><%=memberList.get(i).getMem_like() %></td>                  
			</tr>                                                     
		<%		
			}
		%> --%>
		<c:forEach items="${memberList }" var="memberInfo">
			<tr>
				<td>${memberInfo.mem_id }</td>
				<td>${memberInfo.mem_name }</td>
				<td>${memberInfo.mem_regno1 }</td>
				<td>${memberInfo.mem_job }</td>
				<td>${memberInfo.mem_like }</td>
			</tr>
		</c:forEach>
	       
		</tbody>
	</table>
</div>
<div class="searchForm" align="right" style="margin-top: 10px;">
	<form method="post" action="${pageContext.request.contextPath }/09/main.jsp">
		<input type="text" id="search_keyword" name="search_keyword">
		<select name="search_keycode">
			<option value="ALL">전체</option>
			<option value="MEMID">아이디</option>
			<option value="MEMNAME">성명</option>
			<option value="MEMADDR">주소(동)</option>
		</select>
		<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent" type="submit">검색</button>
		<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent" type="button">글쓰기</button>
	</form>
</div>
</body>
</html>








