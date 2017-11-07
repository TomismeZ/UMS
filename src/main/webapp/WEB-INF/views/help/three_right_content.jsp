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
			
		</div>
	</c:when>
	<c:otherwise>
		<div class="tab_3">
			<h3>
				<strong>实例</strong>
			</h3>
			<p>通过AJAX加载一段文本：</p>
			<p>JQuery代码:</p>
			<img alt="" src="<%=path%>/images/ajax/ajax1.png">
			<p>HTML代码:</p>
			<img alt="" src="<%=path%>/images/ajax/ajax2.png">
		</div>
	</c:otherwise>
</c:choose>
