package kr.or.ddit.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberFormController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, 
			               HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>                                                                   ");
		out.println("<html>                                                                            ");
		out.println("<head>                                                                            ");
		out.println("<meta charset='UTF-8'>                                                            ");
		out.println("<title>Insert title here</title>                                                  ");
		out.println("<script type='text/javascript' src='http://code.jquery.com/jquery-latest.js'></script>");
		/*out.println("<script type='text/javascript'>");
		out.println("$(function(){");
		out.println("	$('input[value=회원가입]').click(function(){");
		out.println("		location.href = '/ServletToddler/member/memberView?mem_id='+ mem_id;");
		out.println("	});");
		out.println("});");
		out.println("</script>");*/
		out.println("</head>                                                                           ");
		out.println("<body>                                                                            ");
		out.println("<form action='/ServletToddler/member/insertMember' method='post'>             ");
		out.println("	<table>                                                                        ");
		out.println("		<tr>                                                                       ");
		out.println("			<td>아이디</td>                                                           ");
		out.println("			<td>                                                                   ");
		out.println("				<input type='text' name='mem_id' />            ");
		out.println("			</td>                                                                  ");
		out.println("		</tr>                                                                      ");
		out.println("		<tr>                                                                       ");
		out.println("			<td>패스워드</td>                                                          ");
		out.println("			<td>                                                                   ");
		out.println("				<input type='text' name='mem_pass'/>                              ");
		out.println("			</td>                                                                  ");
		out.println("		</tr>                                                                      ");
		out.println("		<tr>                                                                       ");
		out.println("			<td>성명</td>                                                            ");
		out.println("			<td><input type='text' name='mem_name'/></td>     ");
		out.println("		</tr>                                                                      ");
		out.println("		<tr>                                                                       ");
		out.println("			<td>주민등록번호</td>                                                        ");
		out.println("			<td>                                                                   ");
		out.println("				<input type='text' name='mem_regno1'/>        ");
		out.println("				<input type='text' name='mem_regno2'/>        ");
		out.println("			</td>                                                                  ");
		out.println("		</tr>                                                                      ");
		out.println("		<tr>                                                                       ");
		out.println("			<td>생년월일</td>                                                            ");
		out.println("			<td><input type='text' name='mem_bir'/></td>     ");
		out.println("		</tr>                                                                      ");
		out.println("		<tr>                                                                       ");
		out.println("			<td>우편번호</td>                                                            ");
		out.println("			<td><input type='text' name='mem_zip'/></td>     ");
		out.println("		</tr>                                                                      ");
		out.println("		<tr>                                                                       ");
		out.println("			<td>주소</td>                                                            ");
		out.println("			<td>                                                                   ");
		out.println("				<input type='text' name='mem_add1' />-                             ");
		out.println("				<input type='text' name='mem_add2' />                              ");
		out.println("			</td>                                                                  ");
		out.println("		</tr>                                                                      ");
		out.println("		<tr>                                                                       ");
		out.println("			<td>집전화번호</td>                                                         ");
		out.println("			<td><input type='text' name='mem_hometel'/></td>                      ");
		out.println("		</tr>                                                                      ");
		out.println("		<tr>                                                                       ");
		out.println("			<td>회사전화번호</td>                                                        ");
		out.println("			<td><input type='text' name='mem_comtel'/></td>                       ");
		out.println("		</tr>                                                                      ");
		out.println("		<tr>                                                                       ");
		out.println("			<td>휴대폰번호</td>                                                         ");
		out.println("			<td><input type='text' name='mem_hp'></td>                    ");
		out.println("		</tr>                                                                      ");
		out.println("		<tr>                                                                       ");
		out.println("			<td>이메일</td>                                                           ");
		out.println("			<td><input type='text' name='mem_mail' /></td>                         ");
		out.println("		</tr>                                                                      ");
		out.println("		<tr>                                                                       ");
		out.println("			<td>직업</td>                                                            ");
		out.println("			<td><input type='text' name='mem_job' /></td>                          ");
		out.println("		</tr>                                                                      ");
		out.println("		<tr>                                                                       ");
		out.println("			<td>취미</td>                                                            ");
		out.println("			<td><input type='text' name='mem_like'/></td>                         ");
		out.println("		</tr>                                                                      ");
		out.println("		<tr>                                                                       ");
		out.println("			<td colspan='2'>                                                       ");
		out.println("				<input type='submit' value='회원가입' />                                 ");
		out.println("				<input type='reset' value='취소' />                                  ");
		out.println("			</td>                                                                  ");
		out.println("		</tr>                                                                      ");
		out.println("	</table>                                                                       ");
		out.println("</form>                                                                           ");
		out.println("</body>                                                                           ");
		out.println("</html>                                                                           ");
	}
	
}







