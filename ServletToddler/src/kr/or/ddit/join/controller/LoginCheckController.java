package kr.or.ddit.join.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class LoginCheckController extends HttpServlet {
	//|--------------------URL----------------------|
	//                 |------------URI-------------|
	//http://localhost/ServletToddler/join/loginCheck?mem_id=a001&mem_pass=asdfas
	//                                |--서블릿 패스----||--------Query String------|
	
	//서블릿 클래스의 콜백 메서드
	//*클라이언트의 웹 서버 대상 요청시의 의도가 번영되어진 전송방식에 따라 결정
	//doGet(request, response) : 클라이언트 URL요청시 전송되는 쿼리스트링의  웹서버대상 전달 HTML4, 5활용가능
	//doPost(request, response) : 클라이언트의 URL요청시 해당 웹 서버 대상 값 추가(인서트) HTML4, 5활용가능
	//service(requset, response) : 클라이언트의 URL 요청시 쿼리스트링 전송 방식 GET|POST와 상관없이 콜백
	//doHead(request, response) : 클라이언트의 URL요청시 요청 헤더 정보 전달 HTML5활용가능
	//doPut(request, response) : 웹 서버로부터 클라이언트 측에 값을 전달 HTML5활용가능
	//doOptions(request, response) : 클라이언트의 URL 요청시 쿼리스트링 또는 요청 헤더 외의 정보를 전달 HTML5활용가능
	//doTrace(request, response) : 클라이언트의 URL요청이 가능한지 여부 검증 HTML5활용가능
	
	//클라이언트의 웹 서버 대상 쿼리스트링 전송시 전송방식(GET, POST)
	//GET : 웹 서버 대상 전송되는 쿼리스트링이 브라우저의 주소창에 출력 (전송패킷 활용)
	//		<form method='get|GET'/>
	//		<a href='URI'>누르면 요청가요</a>
	//		location.href = 'URI'	*브라우저의 요청주소를 히스토리 객체에 저장 후 (뒤로가기, 앞으로가기 활용)
	//		location.replace('URI') *해당 요청 주소를 히스토리 객체에 저장하지 않음.
	//		ajax({type : 'get|GET', .....})
	//		브라우저 주소창에 직접 URL입력
	//		*서블릿 클래스의 doGet(request, response) 콜백.
	//POST : 웹 서버 대상 전송되는 쿼리스트링(문자열, 스트리밍[파일] 형태)이 브라우저의 주소창에 미출력 (전송패킷 활용)
	//		<form method='post|POST'/>
	//		ajax({type : 'post|POST'})
	//		*서블릿 클래스의 doPost(request, response) 콜백.
	
	//브라우저별 쿼리스트링 전송방식 GET일 때 쿼리스트링 사이즈 제한
	//	1. IE : 2KB
	//	2. Chrome, Firefox, Safari : 100KB
	//	3. Opera : 200KB
	//브라우저별 쿼리스트링 전송방식 POST일 때 쿼리스트링 사이즈 제한
	// 	사이즈 무제한(파일 전송이 가능)
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//?mem_id=a001&mem_pass=asdfas
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		
		System.out.println("쿼리스트링 전송방식 GET mem_id |" + mem_id + "-mem_pass|" + mem_pass);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//?mem_id=a001&mem_pass=asdfas
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", mem_id);
		params.put("mem_pass", mem_pass);
		
		IMemberService service = IMemberServiceImpl.getInstance();
		MemberVO memberInfo = service.memberInfo(params);
		
		if(memberInfo == null){
			//	1. /join/loginForm
			//	2. 로그인 화면 출력 -> mem_id, mem_pass 입력 | [로그인] 클릭
			//	3. /join/loginCheck
			//	4. 회원 아님
			//	5. /join/loginForm 요청이 시작되도록 클라이언트에 응답 전송
			//	6. /join/loginForm
			//	7. 로그인 화면 출력
			
			
			//리다이렉트 처리
			//	1. 웹 서버에서 특정 요청 주소를 응답 객체에 저장 후 클라이언트에 응답 전송
			//	2. 클라이언트는 웹 서버로 취득한 특정 서버 대상 요청 주소
			//	3. 웹 서버 대상 요청이 시작
			
			String message = URLEncoder.encode("회원이 아닙니다." , "UTF-8");
			response.sendRedirect("/ServletToddler/join/loginForm?message=" + message);
			//쿼리스트링의 한글처리
			// 1. 브라우저의 주소창에 적용된 인코딩 타입 : ISO-8859-1(라틴어)
			// 2. 서버에서 클라이언트 대상 응답 컨텐츠의 전송시 UTF-8 인코딩 처리 후 전송
			// 3. 서버에서 한글을 UTF-8로 인코딩 후 URI와 함께 클라이언트에 전송
			// 4. 클라이언트는 취득한 URI와 쿼리스트링(UTF-8로 인코딩)을 브라우저의 주소창에 출력 후 웹 서버 대상 요청 시작
			// 5. 브라우저의 주소창에 적용된 인코딩 타입(ISO-8859-1)으로 다시 인코딩
			//    UTF-8(회원이 아닙니다.) -> ISO/8859-1(UTF-8(회원이 아닙니다.))=> 서버의 쿼리스트링 디코딩 설정 =>request.getParameter("message");
			//                                                          1. 쿼리스트링 전송방식 GET : server.xml <connector URIEncoding = "UTF-8"
			
			
		}else{
			response.sendRedirect("/ServletToddler/member/memberList");
			
		}
		//컨트롤러
		//	클라이언트의 요청 취듯
		//	클라이언트로부터 전송되는 쿼리스트링 취득
		//	클라이언트에 전송될 응답 컨텐츠 작성
		//서비스 레이어(비지니스 로직 작성 수행)
		//	서버 내 존재하는 자원 File I/O
		//	원격지 서버 대상 요청과 응답 처리
		//	익셉션 제어
		//다오 레이어(퍼시스턴트)
		//	RDMS 질의 환경
		//	RDMS 질의 결과 처리
		
		
		
		
		//System.out.println("쿼리스트링 전송방식 POST mem_id |" + mem_id + "-mem_pass|" + mem_pass);
		
		//iBatis 활용 환경 설정
		//	1. iBatis 라이브러리 추가
		//	2. log4j 라이브러리 추가(로그 출력)
		//	3. ojdbc6 라이브러리 추가
		//	4. iBatis 설정파일(임의의 패키지 : SqlMapConfig.xml, SqlMapConfig.properties)
		//	5. log4j 설정파일(log4j.xml, log4j.properties)
		//	6. iBatis SqlMapClient 객체를 작성 제공하는 팩토리 클래스(SqlMapClientFactory.java)
		
		
		
	}
}
