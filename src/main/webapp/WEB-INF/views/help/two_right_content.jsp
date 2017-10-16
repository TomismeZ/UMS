<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<c:choose>
	<c:when test="${id eq 1 }">
		<div class="tab_1">

			<p>【个人账户】页面汇总和你有关的一切信息：</p>
			<ul>
			<li>基本信息：姓名、用户名、头像、密码、手机、性别、状态等</li>
			</ul>
			<p>你可以在这里查看和设置这些信息。</p>
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
			<h3>
				<strong>传统首页</strong>
			</h3>
			<p>学员登录后看到的第一个页面就是首页，也称为“传统首页”。</p>
			<img alt="" src="<%=path%>/images/main.png">
			<h3>
				<strong>主题风格切换</strong>
			</h3>
			<p>个人菜单中，点击切换主题可以自由切换主图风格</p>
			<img alt="" src="<%=path%>/images/theme.png">
			<h3>
				<strong>编辑资料页面</strong>
			</h3>
			<p>可以对当前账户进行编辑，以及可以修改用户头像等</p>
			<img alt="" src="<%=path%>/images/avataredit.png">
		</div>
	</c:otherwise>
</c:choose>
