<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/style.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/plugins/css/iconfont.css">
<style type="text/css">
body {
	display: flex;
	flex-direction: column;
}
/**
头部样式CSS样式，begin
**/
#help-title-panel {
	flex-grow: 1;
	min-height: 60px;
	max-height: 60px;
	background-color: #fff;
	position: relative;
}

#help-title-panel .logo-panel {
	width: 300px;
	height: 60px;
	position: absolute;
	left: 20px;
}

#help-title-panel .menu-panel {
	height: 60px;
	position: absolute;
	right: 20px;
}

#help-title-panel .logo-panel h5 {
	color: #585F69;
	font-size: 24px;
	margin: 0;
	line-height: 60px;
	position: absolute;
}
#help-title-panel .logo-panel span{
	position: absolute;
	left:100px;
	bottom: -5px;
	line-height: 60px;
	font-size: 12px;
	color: #929292;
	
}
#help-title-panel .menu-panel ul {
	list-style: none;
	float: right;
	margin: 0;
	padding:0;
}

#help-title-panel .menu-panel ul li {
	float: left;
	font-size: 20px;
	margin-left:30px;
	line-height: 60px;
}

#help-title-panel .menu-panel ul li a {
	text-decoration: none;
	font-size:18px;
	color: grey;
	padding-left: 8px;
}
#help-title-panel .menu-panel ul li:hover, #help-title-panel .menu-panel ul li.active
	{
	/* background-color: #CCCCCC; */
/* 	color: #4d98c1; */
	border-bottom: 2px solid #438EB9; 
}
#help-title-panel .menu-panel ul li a:hover {
	color: #4d98c1;
}

#help-title-panel .menu-panel ul li a:active {
	color: grey;
}
/*头部样式 end*/
#help-content-panel {
	flex-grow: 1;
	display: flex;
	flex-direction: row;
}
/*右侧内容模块，CSS样式 begin*/
#help-content-panel .right-content .tab_1,
#help-content-panel .right-content .tab_2,
#help-content-panel .right-content .tab_3{
	margin-left: 20px;
}
#help-content-panel .right-content .tab_3 img,
#help-content-panel .right-content .tab_2 img{
	width:-moz-calc(100% - 20px);
	width:-webkit-calc(100% - 20px);
	width: calc(100% - 20px);
}
</style>
</head>
<body>
	<div id="top-panel"></div>
	<div id="help-title-panel">
		<div class="logo-panel">
			<h5>帮助中心</h5><span>你想知道的全在这里了</span>
		</div>
		<div class="menu-panel">
			<ul>
				<li class="left-item"><i class="iconfont icon-kuaisurumen" style="color: black;"></i><a href="quickGetStart" data-id="1">快速入门</a></li>
				<li class="left-item"><i class="iconfont icon-jichugongneng" style="color: black;"></i><a href="quickGetStart" data-id="2">基础功能</a></li>
				<li class="left-item"><i class="iconfont icon-wentiquestions1" style="color: black;"></i><a href="quickGetStart" data-id="3">常见问题</a></li>
			</ul>
		</div>
	</div>
	<div id="help-content-panel">
	</div>
	<script src="<%=path%>/plugins/jquery2.1.3.min.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		var $topPanel;
		var $titlePanel;
		var $contentPanel;
		$(function() {
			$topPanel = $("#top-panel");
			$titlePanel=$("#help-title-panel");
			$contentPanel=$("#help-content-panel");
			//加载头部列表
			$topPanel.load("common/top.jsp");
			$titlePanel.find(".menu-panel").find(".left-item").on("click", function(e) {
				var $this = $(this);
				var $parent=$this.parent();
				//高亮处理
				$parent.find(".left-item").removeClass("active");
				$this.addClass("active");
				//使用SPA，在一个URL加载两个界面
				//阻止a标签原有的默认事件
				e.preventDefault();
				//得到a标签href属性的值
				var pageRef = $this.find("a").prop("href");
				var id=$this.find("a").data("id");
				console.log("id:"+id);
				//JQuery load页面
				$contentPanel.load(pageRef,{id:id});
			}).first().click();
		});
	</script>
</body>
</html>