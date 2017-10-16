<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<c:choose>
	<c:when test="${id eq 1 }">
		<div class="tab_1">
			<div class="content-box">
				<h3>体验式学习</h3>
				<p>企业真实需求，解决实际工作任务和问题</p>
			</div>
			<div class="content-box">
				<h3>代码级训练</h3>
				<p>真实的实例项目，在线编译和运行源代码</p>
			</div>
			<div class="content-box">
				<h3>群里化协作</h3>
				<p>轻社交平台，虚拟项目团队，一起学习，相互分享、相互支持、互相挑战、共同成长</p>
			</div>
		</div>
	</c:when>
	<c:when test="${id eq 2}">
		<div class="tab_2">
			<p>参与UMS学习，请确保您的计算机满足以下最低配置要求。对于某些功能可能有额外环境或工具要求，具体详细要求，请参照功能介绍页面。</p>
			<h4>操作系统</h4>
			<ul>
				<li>PC：已安装最新版本的 Windows 7 或更高版本</li>
				<li>Mac：已安装最新版本的 OS X 10.6 或更高版本</li>
			</ul>
			<h4>浏览器</h4>
			<ul>
				<li>在使用浏览器访问“轻实训”时，我们强烈建议使用最新版本的 Chrome 或 Safari 浏览器</li>
				<li>我们目前不支持 IE 浏览器</li>
				<li>为了达到最佳的体验效果，屏幕分辨率最低支持：1280 x 768</li>
			</ul>
			<h4>网络连接</h4>
			<ul>
				<li>下行网速：建议 2+ Mbps; 最低 1 Mbps</li>
				<li>上行网速：建议 0.5+ Mbps</li>
			</ul>
		</div>
	</c:when>
	<c:otherwise>
		<div class="tab_3">
			<h3><strong>传统首页</strong></h3>
			<p>学员登录后看到的第一个页面就是首页，也称为“传统首页”。</p>
			<img alt="" src="<%=path %>/images/main.png">
			<h3><strong>主题风格切换</strong></h3>
			<p>个人菜单中，点击切换主题可以自由切换主图风格</p>
			<img alt="" src="<%=path %>/images/theme.png">
			<h3><strong>编辑资料页面</strong></h3>
			<p>可以对当前账户进行编辑，以及可以修改用户头像等</p>
			<img alt="" src="<%=path %>/images/avataredit.png">
		</div>
	</c:otherwise>
</c:choose>
