/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.45
 * Generated at: 2017-09-27 04:58:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
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

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

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

      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Document</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("/**\r\n");
      out.write("总容器\r\n");
      out.write("**/\r\n");
      out.write("#container {\r\n");
      out.write("\twidth: 800px;\r\n");
      out.write("\theight: 600px;\r\n");
      out.write("\tborder: 1px solid red;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tdisplay: flex;\r\n");
      out.write("\tflex-direction: column;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#container header {\r\n");
      out.write("\tflex-grow: 1;\r\n");
      out.write("\tmin-height: 60px;\r\n");
      out.write("\tmax-height: 60px;\r\n");
      out.write("\tborder-bottom: 1px solid red;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#container .content {\r\n");
      out.write("\tflex-grow: 1;\r\n");
      out.write("\tdisplay: flex;\r\n");
      out.write("\tflex-direction: row;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#container .content .left-content {\r\n");
      out.write("\tflex-grow: 1;\r\n");
      out.write("\tmin-width: 140px;\r\n");
      out.write("\tmax-width: 140px;\r\n");
      out.write("\tborder-right: 1px solid red;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#container .content .right-content {\r\n");
      out.write("\tflex-grow: 1;\r\n");
      out.write("\toverflow: auto;\r\n");
      out.write("\tmargin: 8px;\r\n");
      out.write("\tborder: 1px solid red;\r\n");
      out.write("\tdisplay: flex;\r\n");
      out.write("\tflex-direction: column;\r\n");
      out.write("}\r\n");
      out.write("/**\r\n");
      out.write("left.jsp，style代码\r\n");
      out.write("**/\r\n");
      out.write("#container .content .left-content ul {\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tlist-style: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#container .content .left-content ul li {\r\n");
      out.write("\theight: 40px;\r\n");
      out.write("\tline-height: 40px;\r\n");
      out.write("\tpadding-left: 30px;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#container .content .left-content ul li:hover, #container .content .left-content ul li.active\r\n");
      out.write("\t{\r\n");
      out.write("\tbackground-color: red;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/**\r\n");
      out.write("accountManage.jsp,CSS样式\r\n");
      out.write("**/\r\n");
      out.write("#container .content .right-content .header {\r\n");
      out.write("\tflex-grow: 1;\r\n");
      out.write("\tmin-height: 45px;\r\n");
      out.write("\tmax-height: 45px;\r\n");
      out.write("\tborder-bottom: 1px solid red;\r\n");
      out.write("}\r\n");
      out.write("#container .content .right-content .account-manage{\r\n");
      out.write("flex-grow: 1;\r\n");
      out.write("}\r\n");
      out.write("#container .content .right-content .account-manage .footer{\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 80px;\r\n");
      out.write("\ttext-align: right;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("#container .content .right-content table {\r\n");
      out.write("\t/* width:-webkit-calc(100%-8px); */\r\n");
      out.write("\twidth:97%;\r\n");
      out.write("\tborder-collapse: collapse;\r\n");
      out.write("\tmargin: 8px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#container .content .right-content .header button {\r\n");
      out.write("\tmargin: 10px;\r\n");
      out.write("\twidth: 60px;\r\n");
      out.write("\tborder: 1px solid grey;\r\n");
      out.write("\tbackground-color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#container .content .right-content table, #container .content .right-content th,\r\n");
      out.write("\t#container .content .right-content td {\r\n");
      out.write("\tborder: 1px solid red;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/**\r\n");
      out.write("添加account页面的CSS样式\r\n");
      out.write("**/\r\n");
      out.write("#container .content .right-content .accountContent {\r\n");
      out.write("\tflex-grow: 1;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#container .content .right-content .accountContent .left,\r\n");
      out.write("#container .content .right-content .accountContent .right {\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\twidth: 50%;\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#container .content .right-content .accountContent .right {\r\n");
      out.write("\tright: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#container .content .right-content .accountContent .input-group {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\theight: 30px;\r\n");
      out.write("\tline-height: 30px;\r\n");
      out.write("\tmargin-bottom: 5%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#container .content .right-content .accountContent .input-group .input {\r\n");
      out.write("\twidth: 70%;\r\n");
      out.write("\theight: 25px;\r\n");
      out.write("\tborder: 1px solid black;\r\n");
      out.write("\tfont-size: 15px;\r\n");
      out.write("\tpadding-left: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#container .content .right-content .accountContent .input-group .input-content\r\n");
      out.write("\t{\r\n");
      out.write("\twidth: 70%;\r\n");
      out.write("\t/*对于外部其他元素是行内元素，对于内部是块级元素*/\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#container .content .right-content .button-group {\r\n");
      out.write("\tflex-grow: 1;\r\n");
      out.write("\tmin-height: 45px;\r\n");
      out.write("\tmax-height: 45px;\r\n");
      out.write("\tborder-top: 1px solid red;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#container .content .right-content .button-group button {\r\n");
      out.write("\tmargin: 10px;\r\n");
      out.write("\tborder: 1px solid grey;\r\n");
      out.write("\tbackground-color: white;\r\n");
      out.write("\twidth: 60px;\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"container\">\r\n");
      out.write("\t\t<header> </header>\r\n");
      out.write("\t\t<div class=\"content\">\r\n");
      out.write("\t\t\t<div class=\"left-content\"></div>\r\n");
      out.write("\t\t\t<div class=\"right-content\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!--引入jQuery框架库文件-->\r\n");
      out.write("\t<script type=\"text/javascript\"\r\n");
      out.write("\t\tsrc=\"http://code.jquery.com/jquery-2.1.3.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tvar $container;\r\n");
      out.write("\t\tvar $leftContent;\r\n");
      out.write("\t\tvar $rightContent;\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t$container = $(\"#container\");\r\n");
      out.write("\t\t\t$leftContent = $container.find(\".left-content\");\r\n");
      out.write("\t\t\t$rightContent = $container.find(\".right-content\");\r\n");
      out.write("\t\t\t//加载列表\r\n");
      out.write("\t\t\t$leftContent.load(\"left.jsp\", function() {\r\n");
      out.write("\t\t\t\tvar $parent = $(this);\r\n");
      out.write("\t\t\t\t//点击\r\n");
      out.write("\t\t\t\t$parent.find(\".left-item\").on(\"click\", function(e) {\r\n");
      out.write("\t\t\t\t\tvar $this = $(this);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t//高亮处理\r\n");
      out.write("\t\t\t\t\t$parent.find(\".left-item\").removeClass(\"active\");\r\n");
      out.write("\t\t\t\t\t$this.addClass(\"active\");\r\n");
      out.write("\t\t\t\t\t//使用SPA，在一个URL加载两个界面\r\n");
      out.write("\t\t\t\t\t//阻止a标签原有的默认事件\r\n");
      out.write("\t\t\t\t\te.preventDefault();\r\n");
      out.write("\t\t\t\t\t//得到a标签href属性的值\r\n");
      out.write("\t\t\t\t\tvar pageRef = $this.find(\"a\").prop(\"href\");\r\n");
      out.write("\t\t\t\t\t//JQuery load页面\r\n");
      out.write("\t\t\t\t\t$rightContent.load(pageRef);\r\n");
      out.write("\t\t\t\t}).first().click();\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
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
