/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.75
 * Generated at: 2017-09-28 08:35:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.emp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class listEmps_005fByCompositeQuery_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/emp/pages/page1_ByCompositeQuery.file", Long.valueOf(1505827844516L));
    _jspx_dependants.put("/emp/pages/page2_ByCompositeQuery.file", Long.valueOf(1505827844360L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems_005fend_005fbegin;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems_005fend_005fbegin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems_005fend_005fbegin.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      java.util.List listEmps_ByCompositeQuery = null;
      listEmps_ByCompositeQuery = (java.util.List) _jspx_page_context.getAttribute("listEmps_ByCompositeQuery", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (listEmps_ByCompositeQuery == null){
        throw new java.lang.InstantiationException("bean listEmps_ByCompositeQuery not found within scope");
      }
      out.write('\r');
      out.write('\n');
      com.dept.model.DeptService deptSvc = null;
      deptSvc = (com.dept.model.DeptService) _jspx_page_context.getAttribute("deptSvc", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (deptSvc == null){
        deptSvc = new com.dept.model.DeptService();
        _jspx_page_context.setAttribute("deptSvc", deptSvc, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>複合查詢 - listEmps_ByCompositeQuery.jsp</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body bgcolor='white'>\r\n");
      out.write("<b><font color=blue>\r\n");
      out.write("☆萬用複合查詢-可由客戶端select_page.jsp隨意增減任何想查詢的欄位<br>\r\n");
      out.write("☆此頁作為複合查詢時之結果練習，</font> <font color=red>已增加分頁、送出修改、刪除之功能:</font></b>\r\n");
      out.write("<table border='1' cellpadding='5' cellspacing='0' width='800'>\r\n");
      out.write("\t<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<h3><font color=red>複合查詢</font>員工 - listEmps_ByCompositeQuery.jsp</h3>\r\n");
      out.write("\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/select_page.jsp\"><img src=\"images/back1.gif\" width=\"100\" height=\"32\" border=\"0\">回首頁</a>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table border='1' bordercolor='#CCCCFF' width='800'>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>員工編號</th>\r\n");
      out.write("\t\t<th>員工姓名</th>\r\n");
      out.write("\t\t<th>職位</th>\r\n");
      out.write("\t\t<th>雇用日期</th>\r\n");
      out.write("\t\t<th>薪水</th>\r\n");
      out.write("\t\t<th>獎金</th>\r\n");
      out.write("\t\t<th>部門</th>\r\n");
      out.write("\t\t<th>修改</th>\r\n");
      out.write("\t\t<th>刪除</th>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");
      out.write('\r');
      out.write('\n');
  int rowsPerPage = 3;  //每頁的筆數    
    int rowNumber=0;      //總筆數
    int pageNumber=0;     //總頁數      
    int whichPage=1;      //第幾頁
    int pageIndexArray[]=null;
    int pageIndex=0; 

      out.write("\r\n");
      out.write("\r\n");
  
    rowNumber=listEmps_ByCompositeQuery.size();
    if (rowNumber%rowsPerPage !=0)
     pageNumber=rowNumber/rowsPerPage +1;
    else pageNumber=rowNumber/rowsPerPage;    

    pageIndexArray=new int[pageNumber]; 
    for (int i=1 ; i<=pageIndexArray.length ; i++)
    pageIndexArray[i-1]=i*rowsPerPage-rowsPerPage;

      out.write("\r\n");
      out.write("\r\n");
  try {
      whichPage = Integer.parseInt(request.getParameter("whichPage"));
      pageIndex=pageIndexArray[whichPage-1];
    } catch (NumberFormatException e) { //第一次執行的時候
       whichPage=1;
       pageIndex=0;
    } catch (ArrayIndexOutOfBoundsException e) { //總頁數之外的錯誤頁數
         if (pageNumber>0){
              whichPage=pageNumber;
              pageIndex=pageIndexArray[pageNumber-1];
         }
    } 

      out.write('\r');
      out.write('\n');
if (pageNumber>0){
      out.write("\r\n");
      out.write("<b><font color= red>第");
      out.print(whichPage);
      out.write('/');
      out.print(pageNumber);
      out.write("頁　</font></b>\r\n");
}
      out.write("\r\n");
      out.write("<b>●符 合 查 詢 條 件 如 下 所 示: 共<font color=red>");
      out.print(rowNumber);
      out.write("</font>筆</b>\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write('	');
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems_005fend_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      boolean _jspx_th_c_005fforEach_005f0_reused = false;
      try {
        _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
        _jspx_th_c_005fforEach_005f0.setParent(null);
        // /emp/listEmps_ByCompositeQuery.jsp(40,1) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fforEach_005f0.setVar("empVO");
        // /emp/listEmps_ByCompositeQuery.jsp(40,1) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${listEmps_ByCompositeQuery}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        // /emp/listEmps_ByCompositeQuery.jsp(40,1) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fforEach_005f0.setBegin(pageIndex);
        // /emp/listEmps_ByCompositeQuery.jsp(40,1) name = end type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fforEach_005f0.setEnd(pageIndex+rowsPerPage-1);
        int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
        try {
          int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
          if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("\t\t<tr align='center' valign='middle' ");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(empVO.empno==param.empno) ? 'bgcolor=#CCCCFF':''}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write("><!--將修改的那一筆加入對比色而已-->\r\n");
              out.write("\t\t\t<td>");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empVO.empno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write("</td>\r\n");
              out.write("\t\t\t<td>");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empVO.ename}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write("</td>\r\n");
              out.write("\t\t\t<td>");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empVO.job}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write("</td>\r\n");
              out.write("\t\t\t<td>");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empVO.hiredate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write("</td>\r\n");
              out.write("\t\t\t<td>");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empVO.sal}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write("</td>\r\n");
              out.write("\t\t\t<td>");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empVO.comm}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write("</td>\t\t\t\r\n");
              out.write("\t\t\t<td>");
              if (_jspx_meth_c_005fforEach_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
                return;
              out.write("\r\n");
              out.write("\t\t\t</td>\r\n");
              out.write("\t\t\t\t\t\t<td>\r\n");
              out.write("\t\t\t  <FORM METHOD=\"post\" ACTION=\"");
              out.print(request.getContextPath());
              out.write("/emp/emp.do\">\r\n");
              out.write("\t\t\t     <input type=\"submit\" value=\"修改\"> \r\n");
              out.write("\t\t\t     <input type=\"hidden\" name=\"empno\" value=\"");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empVO.empno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write("\">\r\n");
              out.write("\t\t\t     <input type=\"hidden\" name=\"requestURL\"\tvalue=\"");
              out.print(request.getServletPath());
              out.write("\"><!--送出本網頁的路徑給Controller-->\r\n");
              out.write("\t\t\t     <input type=\"hidden\" name=\"whichPage\"\tvalue=\"");
              out.print(whichPage);
              out.write("\">               <!--送出當前是第幾頁給Controller-->\r\n");
              out.write("\t\t\t     <input type=\"hidden\" name=\"action\"\tvalue=\"getOne_For_Update\"></FORM>\r\n");
              out.write("\t\t\t</td>\r\n");
              out.write("\t\t\t<td>\r\n");
              out.write("\t\t\t  <FORM METHOD=\"post\" ACTION=\"");
              out.print(request.getContextPath());
              out.write("/emp/emp.do\">\r\n");
              out.write("\t\t\t    <input type=\"submit\" value=\"刪除\">\r\n");
              out.write("\t\t\t    <input type=\"hidden\" name=\"empno\" value=\"");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empVO.empno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write("\">\r\n");
              out.write("\t\t\t    <input type=\"hidden\" name=\"requestURL\"\tvalue=\"");
              out.print(request.getServletPath());
              out.write("\"><!--送出本網頁的路徑給Controller-->\r\n");
              out.write("\t\t\t    <input type=\"hidden\" name=\"whichPage\"\tvalue=\"");
              out.print(whichPage);
              out.write("\">               <!--送出當前是第幾頁給Controller-->\r\n");
              out.write("\t\t\t    <input type=\"hidden\" name=\"action\"value=\"delete\"></FORM>\r\n");
              out.write("\t\t\t</td>\r\n");
              out.write("\t\t</tr>\r\n");
              out.write("\t");
              int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            return;
          }
        } catch (java.lang.Throwable _jspx_exception) {
          while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
            out = _jspx_page_context.popBody();
          _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
        } finally {
          _jspx_th_c_005fforEach_005f0.doFinally();
        }
        _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems_005fend_005fbegin.reuse(_jspx_th_c_005fforEach_005f0);
        _jspx_th_c_005fforEach_005f0_reused = true;
      } finally {
        if (!_jspx_th_c_005fforEach_005f0_reused) {
          _jspx_th_c_005fforEach_005f0.release();
          _jsp_getInstanceManager().destroyInstance(_jspx_th_c_005fforEach_005f0);
        }
      }
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<table border=\"0\">    \r\n");
      out.write(" <tr>\r\n");
      out.write("  ");
if (rowsPerPage<rowNumber) {
      out.write("\r\n");
      out.write("    ");
if(pageIndex>=rowsPerPage){
      out.write("\r\n");
      out.write("        <td><A href=\"");
      out.print(request.getContextPath());
      out.write("/emp/emp.do?whichPage=1&action=listEmps_ByCompositeQuery\">至第一頁</A>&nbsp;</td>\r\n");
      out.write("        <td><A href=\"");
      out.print(request.getContextPath());
      out.write("/emp/emp.do?whichPage=");
      out.print(whichPage-1);
      out.write("&action=listEmps_ByCompositeQuery\">上一頁 </A>&nbsp;</td>\r\n");
      out.write("    ");
}
      out.write("\r\n");
      out.write("  \r\n");
      out.write("    ");
if(pageIndex<pageIndexArray[pageNumber-1]){
      out.write("\r\n");
      out.write("        <td><A href=\"");
      out.print(request.getContextPath());
      out.write("/emp/emp.do?whichPage=");
      out.print(whichPage+1);
      out.write("&action=listEmps_ByCompositeQuery\">下一頁 </A>&nbsp;</td>\r\n");
      out.write("        <td><A href=\"");
      out.print(request.getContextPath());
      out.write("/emp/emp.do?whichPage=");
      out.print(pageNumber);
      out.write("&action=listEmps_ByCompositeQuery\">至最後一頁</A>&nbsp;</td>\r\n");
      out.write("    ");
}
      out.write("\r\n");
      out.write("  ");
}
      out.write("  \r\n");
      out.write(" </tr>\r\n");
      out.write("</table>    \r\n");
if ( pageNumber > 1) {
      out.write("\r\n");
      out.write("<table border=\"0\">   \r\n");
      out.write(" <tr> \r\n");
      out.write("        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("        </td>\r\n");
      out.write("   <FORM METHOD=\"post\" ACTION=\"");
      out.print(request.getContextPath());
      out.write("/emp/emp.do\">   \r\n");
      out.write("        <td>\r\n");
      out.write("           <select size=\"1\" name=\"whichPage\">\r\n");
      out.write("        ");
for (int i=1; i<=pageNumber; i++){
      out.write("\r\n");
      out.write("           <option value=\"");
      out.print(i);
      out.write("\">跳至第");
      out.print(i);
      out.write("頁\r\n");
      out.write("        ");
}
      out.write(" \r\n");
      out.write("           </select>\r\n");
      out.write("           <input type=\"submit\" value=\"確定\" >\r\n");
      out.write("           <input type=\"hidden\" name=\"action\"  value=\"listEmps_ByCompositeQuery\">  \r\n");
      out.write("        </td>\r\n");
      out.write("   </FORM>\r\n");
      out.write(" </tr>\r\n");
      out.write("</table>\r\n");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("<br>本網頁的路徑:<br><b>\r\n");
      out.write("   <font color=blue>request.getServletPath():</font> ");
      out.print( request.getServletPath());
      out.write("<br>\r\n");
      out.write("   <font color=blue>request.getRequestURI(): </font> ");
      out.print( request.getRequestURI());
      out.write(" </b>\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f1_reused = false;
    try {
      _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
      // /emp/listEmps_ByCompositeQuery.jsp(48,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setVar("deptVO");
      // /emp/listEmps_ByCompositeQuery.jsp(48,7) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${deptSvc.all}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
        if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                    ");
            if (_jspx_meth_c_005fif_005f0(_jspx_th_c_005fforEach_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f1))
              return true;
            out.write("\r\n");
            out.write("                ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f1.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
      _jspx_th_c_005fforEach_005f1_reused = true;
    } finally {
      if (!_jspx_th_c_005fforEach_005f1_reused) {
        _jspx_th_c_005fforEach_005f1.release();
        _jsp_getInstanceManager().destroyInstance(_jspx_th_c_005fforEach_005f1);
      }
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f1, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f1)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
      // /emp/listEmps_ByCompositeQuery.jsp(49,20) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empVO.deptno==deptVO.deptno}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t                    ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${deptVO.deptno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('【');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${deptVO.dname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write(' ');
          out.write('-');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${deptVO.loc}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("】\r\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      if (!_jspx_th_c_005fif_005f0_reused) {
        _jspx_th_c_005fif_005f0.release();
        _jsp_getInstanceManager().destroyInstance(_jspx_th_c_005fif_005f0);
      }
    }
    return false;
  }
}