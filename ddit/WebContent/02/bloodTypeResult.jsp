<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String bloodType = request.getParameter("bloodType");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//리다이렉트 응답 제어 처리
		//response.sendRedirect("/ddit/02/type/" + bloodType + ".jsp");
	//포워딩 처리
	//	* 컨텍스트 루트|패스가 배제된 서블릿 패스로 작성되어야 함
	//		/ddit/02/type/a.jsp X
	//		/02/type/a.jsp		O
		RequestDispatcher dispatcher = request.getRequestDispatcher("/02/type" + bloodType +".jsp");
		//forward(HttpServletRequest bloodTypeResult.jsp 리다이렉트 요청시 생성
		//        HttpServletResponse bloodTypeResult.jsp 리다이렉트 요청시 생성)
		dispatcher.forward(request, response);
	%>

</body>
</html>