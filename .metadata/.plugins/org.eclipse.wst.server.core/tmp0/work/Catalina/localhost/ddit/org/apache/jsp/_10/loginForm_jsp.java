/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.73
 * Generated at: 2020-06-16 06:55:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._10;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("    \r\n");

   String message =  request.getParameter("message");

      out.write("    \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/admin.css\" type=\"text/css\">\r\n");
      out.write("<title>회원관리 관리자 로그인</title>\r\n");
      out.write("\r\n");
      out.write("     <script type='text/javascript' src='http://code.jquery.com/jquery-latest.js'></script>\r\n");
      out.write("      <script type='text/javascript' src='/ddit/js/common/validation.js'></script>\r\n");
      out.write("      <script type='text/javascript' src=\"");
      out.print(request.getContextPath());
      out.write("/js/common/cookieControl.js\"></script>\r\n");
      out.write("      <script type='text/javascript'>\r\n");
      out.write("      $(function(){\r\n");
      out.write("            if('");
      out.print(message);
      out.write("' != 'null'){\r\n");
      out.write("               alert('");
      out.print(message);
      out.write("');\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            if(Get_Cookie('mem_id')){\r\n");
      out.write("               $('input[name=mem_id]').val(Get_Cookie(\"mem_id\"));\r\n");
      out.write("               $('input[name=saveID]').attr('checked', true);\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            $('.loginBtn').click(function(){\r\n");
      out.write("               \r\n");
      out.write("               var mem_id = $('input[name=mem_id]').val();\r\n");
      out.write("               if(!mem_id.validationID()){\r\n");
      out.write("                  alert('아이디를 바르게 입력해주세요');\r\n");
      out.write("                  return false;\r\n");
      out.write("               }\r\n");
      out.write("               var mem_pass = $('input[name=mem_pass]').val();\r\n");
      out.write("               if(!mem_pass.validationPWD()){\r\n");
      out.write("                  alert('비밀번호를 바르게 입력해주세요');\r\n");
      out.write("                  return false;\r\n");
      out.write("               }\r\n");
      out.write("               \r\n");
      out.write("         \t\t// 체크박스 체크 여부 : $('input[name=saveID]').is('checked', true)\r\n");
      out.write("         \t\t// 체크박스 체크 : $('input[name=saveID]').attr('checked', true)\r\n");
      out.write("               if($('input[name=saveID]').is(':checked')){\r\n");
      out.write("                  Set_Cookie(\"mem_id\", mem_id, 60*60, \"/\");\r\n");
      out.write("               }else{\r\n");
      out.write("                  Delete_Cookie(\"mem_id\", \"/\");\r\n");
      out.write("               }\r\n");
      out.write("               \r\n");
      out.write("               var $frm = $('<form action=\"/ddit/10/loginCheck.jsp\" method=\"post\"></form>');\r\n");
      out.write("               var $inputID = $('<input type=\"hidden\" value=\"' +mem_id+ '\" name=\"mem_id\" />');\r\n");
      out.write("               var $inputPWD = $('<input type=\"hidden\" value=\"' +mem_pass+ '\" name=\"mem_pass\" />');\r\n");
      out.write("               $frm.append($inputID);\r\n");
      out.write("               $frm.append($inputPWD);\r\n");
      out.write("               $(document.body).append($frm);\r\n");
      out.write("               $frm.submit();\r\n");
      out.write("               \r\n");
      out.write("            });\r\n");
      out.write("      });\r\n");
      out.write("      </script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<table width=\"770\" border=\"0\" align=\"center\" cellpadding=\"0\"\r\n");
      out.write("\t\tcellspacing=\"0\" style=\"margin: 90px;\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td height=\"150\" align=\"center\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/image/p_login.gif\" /></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td height=\"174\"\r\n");
      out.write("\t\t\t\tstyle=\"background: url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/image/login_bg.jpg); border: 1px solid #e3e3e3;\">\r\n");
      out.write("\t\t\t\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"260\" height=\"110\" align=\"center\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"border-right: 1px dotted #736357;\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/image/logo.jpg\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<table border=\"0\" align=\"center\" cellpadding=\"5\"\r\n");
      out.write("\t\t\t\t\t\t\t\tcellspacing=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><b>아이디</b></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"text\" name=\"mem_id\" class=\"box\" tabindex=\"3\" height=\"18\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td rowspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/image/login.gif\" class=\"loginBtn\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><b>패스워드</b></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"password\" name=\"mem_pass\" class=\"box\" tabindex=\"3\" height=\"18\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td colspan=\"3\" align=\"right\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/09/main.jsp?contentPage=memberForm.jsp\">회원가입을 원하세요??</a></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
