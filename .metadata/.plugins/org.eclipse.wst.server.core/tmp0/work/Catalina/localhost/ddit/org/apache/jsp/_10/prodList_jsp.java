/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.73
 * Generated at: 2020-06-26 07:03:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._10;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kr.or.ddit.utiles.RolePaginationUtil;
import java.util.HashMap;
import java.util.Map;
import kr.or.ddit.vo.ProdVO;
import java.util.List;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.service.IProdService;

public final class prodList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

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
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");

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

      out.write('\r');
      out.write('\n');
      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      try {
        _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
        _jspx_th_c_005fset_005f0.setParent(null);
        // /10/prodList.jsp(36,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fset_005f0.setVar("paginationMenu");
        // /10/prodList.jsp(36,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
        _jspx_th_c_005fset_005f0.setValue(pagination.getPagingHtmls() );
        int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
        if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } finally {
        _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      }
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script type='text/javascript' src='http://code.jquery.com/jquery-latest.js'></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$('table tr:gt(0)').click(function() {\r\n");
      out.write("\t\t\tvar prod_id = $(this).find('td:eq(0)').text();\r\n");
      out.write("\t\t\tlocation.replace('");
      out.print(request.getContextPath());
      out.write("/10/main.jsp?contentPage=/10/prodView.jsp?prod_id=' + prod_id);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#btn1').on('click', function() {\r\n");
      out.write("\t\t\tlocation.replace('");
      out.print(request.getContextPath());
      out.write("/10/main.jsp?contentPage=/10/prodForm.jsp');\r\n");
      out.write("\t\t})\r\n");
      out.write("\t})\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\t.text-center{\r\n");
      out.write("\t\tdisplay : inline-block;\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tul {\r\n");
      out.write("\t\tlist-style-type : none;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tli{\r\n");
      out.write("\t\tfloat : left;\r\n");
      out.write("\t\tmargin : 10px;  \r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"list\">\r\n");
      out.write("\t<table class=\"mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp\" style=\"width: 100%;\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th class=\"mdl-data-table__cell--non-numeric\">상품분류코드</th>\r\n");
      out.write("\t\t\t\t<th class=\"mdl-data-table__cell--non-numeric\">상품명</th>\r\n");
      out.write("\t\t\t\t<th class=\"mdl-data-table__cell--non-numeric\">매입가</th>\r\n");
      out.write("\t\t\t\t<th class=\"mdl-data-table__cell--non-numeric\">소비자가</th>\r\n");
      out.write("\t\t\t\t<th class=\"mdl-data-table__cell--non-numeric\">판매가</th>\r\n");
      out.write("\t\t\t\t<th class=\"mdl-data-table__cell--non-numeric\">총입고수량</th>\r\n");
      out.write("\t\t\t\t<th class=\"mdl-data-table__cell--non-numeric\">재고수량</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t");

			for(int i = 0; i<prodList.size(); i++){
				
		
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"mdl-data-table__cell--non-numeric\">");
      out.print(prodList.get(i).getProd_id() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td class=\"mdl-data-table__cell--non-numeric\">");
      out.print(prodList.get(i).getProd_name() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td class=\"mdl-data-table__cell--non-numeric\">");
      out.print(prodList.get(i).getProd_cost() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td class=\"mdl-data-table__cell--non-numeric\">");
      out.print(prodList.get(i).getProd_price() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td class=\"mdl-data-table__cell--non-numeric\">");
      out.print(prodList.get(i).getProd_sale() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td class=\"mdl-data-table__cell--non-numeric\">");
      out.print(prodList.get(i).getProd_qtyin() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td class=\"mdl-data-table__cell--non-numeric\">");
      out.print(prodList.get(i).getProd_totalstock() );
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t");
	
			}
		 
      out.write("\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t</table>\r\n");
      out.write("</div>\r\n");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${paginationMenu }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("<div class=\"searchForm\" align=\"right\" style=\"margin-top: 10px;\">\r\n");
      out.write("\t<form method=\"post\" action=\"");
      out.print(request.getContextPath());
      out.write("/10/main.jsp\">\r\n");
      out.write("\t\t<select name=\"search_keycode\">\r\n");
      out.write("\t\t\t<option value=\"ALL\">전체</option>\r\n");
      out.write("\t\t\t<option value=\"PRODLGU\">상품분류코드</option>\r\n");
      out.write("\t\t\t<option value=\"PRODNAME\">상품명</option>\r\n");
      out.write("\t\t\t<option value=\"BUYERNAME\">거래처명</option>\r\n");
      out.write("\t\t</select>\r\n");
      out.write("\t\t<input type=\"text\" id=\"search_keyword\" name=\"search_keyword\">\r\n");
      out.write("\t\t<button class=\"mdl-button mdl-js-button mdl-button--raised mdl-button--accent\" type=\"submit\">검색</button>\r\n");
      out.write("\t\t<button class=\"mdl-button mdl-js-button mdl-button--raised mdl-button--accent\" type=\"button\" id=\"btn1\">상품등록</button>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
