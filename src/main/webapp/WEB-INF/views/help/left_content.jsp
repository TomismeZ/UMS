<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<link rel="stylesheet" type="text/css" href="<%=path%>/plugins/css/iconfont.css">
<div class="top-logo-panel">
	<img src="<%=path%>/images/logo.png">
</div>
<div class="center-menu-panel">
<ul class="menu-item-list">
	<c:choose>
		<c:when test="${id eq 1}">
		<li class="left-item"><i class="iconfont icon-xiugaimima-yanjing-hongse"></i><a href="oneRightContent" data-id="1">开启之旅</a></li>
		<li class="left-item"><i class="iconfont icon-huanjingpeizhi"></i><a href="oneRightContent" data-id="2">环境要求</a></li>
		<li class="left-item"><i class="iconfont icon-iconmoban215"></i><a href="oneRightContent" data-id="3">功能介绍</a></li>
		</c:when>
		<c:when test="${id eq 2}">
		<li class="left-item"><i class="iconfont icon-zhanghao"></i><a href="twoRightContent" data-id="1">个人账户</a></li>
		<li class="left-item"><i class="iconfont icon-jiaoseguanli"></i><a href="twoRightContent" data-id="2">账户管理</a></li>
		</c:when>
		<c:otherwise>
		<li class="left-item"><i class="iconfont icon-dajian"></i><a href="threeRightContent" data-id="1">框架搭建</a></li>
		<li class="left-item"><i class="iconfont icon-chajian"></i><a href="threeRightContent" data-id="2">分页插件</a></li>
		<li class="left-item"><i class="iconfont icon-ajax"></i><a href="threeRightContent" data-id="3">AJAX</a></li>
		</c:otherwise>
	</c:choose>
	
</ul>
</div>