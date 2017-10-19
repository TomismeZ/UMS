<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<ul>
	<c:choose>
		<c:when test="${id eq 1}">
		<li class="left-item"><a href="oneRightContent" data-id="1">开启之旅！</a></li>
		<li class="left-item"><a href="oneRightContent" data-id="2">环境要求</a></li>
		<li class="left-item"><a href="oneRightContent" data-id="3">功能介绍</a></li>
		</c:when>
		<c:when test="${id eq 2}">
		<li class="left-item"><a href="twoRightContent" data-id="1">个人账户</a></li>
		<li class="left-item"><a href="twoRightContent" data-id="2">账户管理</a></li>
		<li class="left-item"><a href="twoRightContent" data-id="3">部门管理</a></li>
		</c:when>
		<c:otherwise>
		<li class="left-item"><a href="threeRightContent" data-id="1">框架搭建</a></li>
		<li class="left-item"><a href="threeRightContent" data-id="2">分页插件</a></li>
		<li class="left-item"><a href="threeRightContent" data-id="3">Ajax</a></li>
		</c:otherwise>
	</c:choose>
	
</ul>