<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<link rel="stylesheet" type="text/css" href="<%=path%>/plugins/css/iconfont.css">
<div class="top-logo-panel">
	<img src="<%=path%>/images/logo.png">
</div>
<div class="center-menu-panel">
<ul class="menu-item-list">
	<li class="left-item"><i class="iconfont icon-jibenziliao"></i><a href="baseData" data-id="1">基本资料</a></li>
	<li class="left-item"><i class="iconfont icon-xiangxiziliao1"></i><a href="baseData" data-id="2">详细资料</a></li>
	<li class="left-item"><i class="iconfont icon-touxiangshezhi"></i><a href="baseData" data-id="3">头像设置</a></li>
</ul>
</div>

