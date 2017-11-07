<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/plugins/css/iconfont.css">
<div class="top-logo-panel">
	<img src="<%=path%>/images/logo.png">
</div>
<div class="center-menu-panel">
	<ul class="menu-item-list">
		<li class="left-item"><i class="iconfont icon-zhanghao"></i><a
			href="findAllAccount">账号管理</a></li>
		<li class="left-item"><i class="iconfont icon-jiaoseguanli"></i><a
			href="findAllRole">角色管理</a></li>
		<li class="left-item"><i class="iconfont icon-author"></i><a
			href="findAllJurisdiction">权限管理</a></li>
		<li class="left-item"><i class="iconfont icon-bumenguanli"></i><a
			href="findAllDepartment">部门管理</a></li>
	</ul>
</div>
<div class="bottom-user-panel"></div>
