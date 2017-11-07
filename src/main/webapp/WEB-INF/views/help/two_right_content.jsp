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
			<h4>修改个人资料</h4>
			<img alt="" src="<%=path%>/images/mysetting.png">
		</div>
	</c:when>
</c:choose>
