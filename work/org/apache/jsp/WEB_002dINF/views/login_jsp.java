/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.45
 * Generated at: 2017-10-31 09:29:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>UMS</title>\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.print(path);
      out.write("/css/login.css\" />\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"header-panel\">\r\n");
      out.write("\t\t<div class=\"logo-panel\">\r\n");
      out.write("\t\t\t<div class=\"logo-content-panel\"></div>\r\n");
      out.write("\t\t\t<h5>用户管理系统</h5>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"menu-panel\">\r\n");
      out.write("\t\t\t<a href=\"index.jsp\">首页</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!--SIGN UP-->\r\n");
      out.write("\t<h1>用户登录</h1>\r\n");
      out.write("\t<div class=\"login-form\">\r\n");
      out.write("\t\t<div class=\"close\"></div>\r\n");
      out.write("\t\t<div class=\"head-info\">\r\n");
      out.write("\t\t\t<label class=\"lbl-1\"> </label> <label class=\"lbl-2\"> </label> <label\r\n");
      out.write("\t\t\t\tclass=\"lbl-3\"> </label>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"avtar\">\r\n");
      out.write("\t\t\t<img src=\"images/login_avatar.jpg\" style=\" border-radius:50% ;\"/>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<form action=\"loginAccount\" method=\"post\">\r\n");
      out.write("\t\t\t<input type=\"text\" class=\"text\" name=\"account.userName\"\r\n");
      out.write("\t\t\t\tplaceholder=\"Username\">\r\n");
      out.write("\t\t\t<div class=\"key\">\r\n");
      out.write("\t\t\t\t<input type=\"password\" name=\"account.password\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"password\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t<div class=\"signin\">\r\n");
      out.write("\t\t\t<button>Login</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"bottom\">\r\n");
      out.write("\t\t\t<button  data-id=\"1\">注册一个账户</button>\r\n");
      out.write("\t\t\t<button data-id=\"2\">忘记密码</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"footer\"></div>\r\n");
      out.write("\t<div id=\"bg\"></div>\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"");
      out.print(path);
      out.write("/plugins/jquery2.1.3.min.js\"\r\n");
      out.write("\t\ttype=\"text/javascript\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tvar $loginForm = $(\".login-form\");\r\n");
      out.write("\t\tvar $form = $loginForm.find(\"form\");\r\n");
      out.write("\t\tvar $headInfo = $loginForm.find(\".head-info\");\r\n");
      out.write("\t\tvar $bottom = $loginForm.find(\".bottom\");\r\n");
      out.write("\t\tvar $clear = $loginForm.find(\".clear\");\r\n");
      out.write("\t\tvar $avtar = $loginForm.find(\".avtar\");\r\n");
      out.write("\t\tvar $footer=$(\"#footer\");\r\n");
      out.write("\t\t$loginForm.find(\".signin\").find(\"button\").on(\"click\", function() {\r\n");
      out.write("\t\t\t/* $form.submit(); */\r\n");
      out.write("\t\t\tvar userName = $form.find(\"input[type='text']\").val();\r\n");
      out.write("\t\t\tvar password = $form.find(\"input[type='password']\").val();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif (!$.trim(userName) || !$.trim(password)) {\r\n");
      out.write("\t\t\t\t$clear.text(\"用户名或者密码不能为空！\");\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\tcache : true,\r\n");
      out.write("\t\t\t\t\ttype : \"POST\",\r\n");
      out.write("\t\t\t\t\turl : \"validateLogin\",\r\n");
      out.write("\t\t\t\t\tdata : $form.serialize(),// 你的formid\r\n");
      out.write("\t\t\t\t\tasync : false,\r\n");
      out.write("\t\t\t\t\terror : function(request) {\r\n");
      out.write("\t\t\t\t\t\talert(\"Connection error\");\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\t\tif (data.message == \"success\") {\r\n");
      out.write("\t\t\t\t\t\t\t$form.submit();\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t$clear.text(data.message);\r\n");
      out.write("\t\t\t\t\t\t\t$clear.css(\"background-color\", \"#fff\");\r\n");
      out.write("\t\t\t\t\t\t\t$clear.css(\"color\", \"red\");\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\tif (data.id == 1) {\r\n");
      out.write("\t\t\t\t\t\t\t//这里可以设置标识用于显示用户头像\r\n");
      out.write("\t\t\t\t\t\t\t/* $avtar.find(\"img\").prop(\"src\",\"getImage?flag=1\"); */\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$headInfo.find(\"label\").on(\r\n");
      out.write("\t\t\t\t\"click\",\r\n");
      out.write("\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\tvar $this = $(this);\r\n");
      out.write("\t\t\t\t\t/* alert($this.css(\"background-color\")); */\r\n");
      out.write("\t\t\t\t\t$headInfo.css(\"background-color\", $this\r\n");
      out.write("\t\t\t\t\t\t\t.css(\"background-color\"));\r\n");
      out.write("\t\t\t\t\t$bottom.find(\"button\").css(\"background-color\",\r\n");
      out.write("\t\t\t\t\t\t\t$this.css(\"background-color\"));\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t//按钮点击事件，根据Id来判断需要跳转到哪个界面\r\n");
      out.write("\t\t$bottom.find(\"button\").on(\"click\", function() {\r\n");
      out.write("\t\t\tvar $this=$(this);\r\n");
      out.write("\t\t\tvar id=$this.data(\"id\");\r\n");
      out.write("\t\t\t$(\"body\").css(\"overflow\",\"auto\");\r\n");
      out.write("\t\t\t$(\"#bg\").css(\"display\",\"block\");\r\n");
      out.write("\t\t\t$(\"#footer\").css(\"display\",\"block\");\r\n");
      out.write("\t\t\t$(\"#footer\").load(\"toRegister\",{id:id},function(){\r\n");
      out.write("\t\t\t\t/* document.getElementById(\"bg\").style.display = 'block'; */\r\n");
      out.write("\t\t\t\t$registContent.find(\".topPanel\").find(\"button\").on(\"click\", function() {\r\n");
      out.write("\t\t\t\t\t$registContent.remove();\r\n");
      out.write("\t\t\t\t\t$(\"#bg\").css(\"display\",\"none\");\r\n");
      out.write("\t\t\t\t\t$(\"body\").css(\"overflow\",\"hidden\");\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
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
