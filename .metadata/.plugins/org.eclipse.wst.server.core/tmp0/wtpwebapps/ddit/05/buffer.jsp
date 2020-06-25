<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="1kb" autoFlush="false"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//HttpServletReponse(응답객체) : 서버에서 클랑이언트(브라우저) 대상의 응답 컨텐츠를 저장 후 전송하는 자원
	//							   출력버퍼 - 응답 컨첸츠를 저장하기 위한 응답 객체의 저장소
	//		출력버퍼 : default 8kb
	//		Flush(전송) : 출력버퍼에 저장된 응답 컨텐츠의 클라이언트(브라우저) 대상 전송
	//					 1. jsp 요청시 천이되는 서블릿 클래스 내 _jspService() 내에서 출력버퍼 대상 
	//						저장 후 해당 메서드 종료시 Flush
	//					 2. 출력버퍼의 사이즈 제한 용량까지 응답컨텐츠가 저장되면 해당 응답 컨첸츠를 Flush(반복가능)
	//		AutoFlush : default true(자동Flush)
	//					AutoFlush=false(코드를 통해 직접 Flush처리)
	//					* 해당 툴력버퍼 사이즈 이상의 응답컨첸츠가 저장되어지는 시점에 Flush 미처리시 에러 발생
	//					* out.flush() - 수동 전송처리(출력버퍼 Clear)
	//					* out.clear() - Flush되지 않으며 출력버퍼만 Clear
	//									출력버퍼가 1번이상 Flush 기록 존재시 에러(IOExeption) 발생
	//					* out.clearBuffer() - Flush되지 않으며 출력버퍼만 Clear
	//										    출력버퍼의 Flush 기록 존재시 에러 미발생
	
	for(int i=0; i<50; i++){
		out.println("출력버퍼의 총 사이즈 : " + out.getBufferSize() + "<br/>");
		out.println("출력버퍼의 저장가능 사이즈 : " + out.getRemaining() + "<br/>");
		
		if(i%10 == 0){
			out.println("암달의 법칙 : 전체시스템에서 개선을 위한 일부 시스템의 프로젝트 수행결과가 시스템 전체성능에 미치는 영향정도 계산법");
			out.flush();
		}
	}
%>

</body>
</html>