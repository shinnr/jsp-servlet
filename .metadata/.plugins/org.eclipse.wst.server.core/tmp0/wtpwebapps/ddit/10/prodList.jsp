<%@page import="kr.or.ddit.utiles.RolePaginationUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.prod.service.ProdServiceImpl"%>
<%@page import="kr.or.ddit.prod.service.IProdService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%
	String currentPage = request.getParameter("currentPage");
	
	if(currentPage == null){
		currentPage = "1";
	}

	String serach_keyword = request.getParameter("search_keyword");
	String serach_keycode = request.getParameter("search_keycode");
	
	Map<String, String> params = new HashMap<String, String>();
	params.put("search_keyword", serach_keyword);
	params.put("search_keycode", serach_keycode);
	
	IProdService service = ProdServiceImpl.getInstance();
	
	String totalCount = service.totalCount(params);
	
	RolePaginationUtil pagination = new RolePaginationUtil(request, Integer.parseInt(currentPage), Integer.parseInt(totalCount));
	
	params.put("startCount", String.valueOf(pagination.getStartCount()));
	params.put("endCount", String.valueOf(pagination.getEndCount()));
	
	List<ProdVO> prodList = service.prodList(params);
%>
<c:set var="paginationMenu" value="<%=pagination.getPagingHtmls() %>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type='text/javascript' src='http://code.jquery.com/jquery-latest.js'></script>
<script type="text/javascript">
	$(function() {
		$('table tr:gt(0)').click(function() {
			var prod_id = $(this).find('td:eq(0)').text();
			location.replace('<%=request.getContextPath()%>/10/main.jsp?contentPage=/10/prodView.jsp?prod_id=' + prod_id);
		});
		
		$('#btn1').on('click', function() {
			location.replace('<%=request.getContextPath()%>/10/main.jsp?contentPage=/10/prodForm.jsp');
		})
	})
</script>
<style type="text/css">
	.text-center{
		display : inline-block;		
	}

	ul {
		list-style-type : none;
	}
	
	li{
		float : left;
		margin : 10px;  
	}
</style>
</head>
<body>
<div id="list">
	<table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp" style="width: 100%;">
		<thead>
			<tr>
				<th class="mdl-data-table__cell--non-numeric">상품분류코드</th>
				<th class="mdl-data-table__cell--non-numeric">상품명</th>
				<th class="mdl-data-table__cell--non-numeric">매입가</th>
				<th class="mdl-data-table__cell--non-numeric">소비자가</th>
				<th class="mdl-data-table__cell--non-numeric">판매가</th>
				<th class="mdl-data-table__cell--non-numeric">총입고수량</th>
				<th class="mdl-data-table__cell--non-numeric">재고수량</th>
			</tr>
		</thead>
		<tbody>
		<%
			for(int i = 0; i<prodList.size(); i++){
				
		%>
			<tr>
				<td class="mdl-data-table__cell--non-numeric"><%=prodList.get(i).getProd_id() %></td>
				<td class="mdl-data-table__cell--non-numeric"><%=prodList.get(i).getProd_name() %></td>
				<td class="mdl-data-table__cell--non-numeric"><%=prodList.get(i).getProd_cost() %></td>
				<td class="mdl-data-table__cell--non-numeric"><%=prodList.get(i).getProd_price() %></td>
				<td class="mdl-data-table__cell--non-numeric"><%=prodList.get(i).getProd_sale() %></td>
				<td class="mdl-data-table__cell--non-numeric"><%=prodList.get(i).getProd_qtyin() %></td>
				<td class="mdl-data-table__cell--non-numeric"><%=prodList.get(i).getProd_totalstock() %></td>
			</tr>
		<%	
			}
		 %>
		</tbody>
	</table>
</div>
${paginationMenu }
<div class="searchForm" align="right" style="margin-top: 10px;">
	<form method="post" action="<%=request.getContextPath()%>/10/main.jsp">
		<select name="search_keycode">
			<option value="ALL">전체</option>
			<option value="PRODLGU">상품분류코드</option>
			<option value="PRODNAME">상품명</option>
			<option value="BUYERNAME">거래처명</option>
		</select>
		<input type="text" id="search_keyword" name="search_keyword">
		<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent" type="submit">검색</button>
		<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent" type="button" id="btn1">상품등록</button>
	</form>
</div>
</body>
</html>








