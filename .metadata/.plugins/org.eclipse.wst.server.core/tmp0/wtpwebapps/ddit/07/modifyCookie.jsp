<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	for(Cookie currentCookie : cookies){
		if("mem_id".intern() == currentCookie.getName().intern()){
			Cookie memidCookie = new Cookie("mem_id", "b00");
			memidCookie.setPath("/");
			response.addCookie(memidCookie);
		}
	}
	// makeCookie.jsp => viewCookie.jsp => modifyCookie.jsp
	// viewCookie.jsp
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	쿠키가 잘 수정되었습니당!~@@#@!#~!
</body>
</html>