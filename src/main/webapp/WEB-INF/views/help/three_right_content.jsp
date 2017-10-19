<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<c:choose>
	<c:when test="${id eq 1 }">
		<div class="tab_1">
				<h3>SSH框架搭建要注意的问题</h3>
				<ul>
				<li>首先，明确spring,struts,hibernate在环境中各自的作用。</li>
				<li>struts:用来响应用户的action，对应到相应的类进行处理。需要struts对应的包。</li>
				<li>hibernate:用来把实体类对应到数据库。提供增删改查的基本操作实现。需要hibernate对应的包以及mysql的jdbc驱动包。</li>
				<li>spring:
管理struts：在xml配置文件中为struts的action进行值注入。
管理hibernate：在xml配置文件中配置hibernate的配置信息（dataSource，sessionFactory），即不需要原来的hibernate的xml文件。为hibernate的dao操作注入sessionfactory属性值。
需要提供spring对应的包，除此以外，还需要提供一个整合spring与struts的包：truts2-spring-plugin-2.0.11.1.jar</li>
			</ul>
		</div>
	</c:when>
	<c:when test="${id eq 2}">
		<div class="tab_2">
			<h4><strong>简介</strong></h4>
			<p>现在网上各种各样的分页组件很多，但是很难找到十分"称心如意"的，于是jqPaginator诞生了。
我心中理想的分页组件，要不受CSS框架限制，可以使用在各种不同风格中的网页中。以我浅显的经验来看，要达到这个目标，关键的一点就是高度自定义的Html结构。所以jqPaginator努力做到合理范围内的自定义，使其灵活的使用了各种不同的场景。
效果截图：</p>
	<img alt="" src="<%=path%>/images/bootstrap/bootstrap1.png">
	<img alt="" src="<%=path%>/images/bootstrap/bootstrap2.png">
	<img alt="" src="<%=path%>/images/bootstrap/bootstrap3.png">
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
