<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Document</title>
<%-- <link type="text/css" rel="stylesheet" href="<%=path%>/plugins/bootstrap.min.css"/> --%>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/style.css"/>

</head>

<body>
	<div id="container">
		<div class="topPanel">
		</div>
		<div class="content">
			<div class="left-content"></div>
			<div class="right-content"></div>
		</div>
	</div>
	<!--引入jQuery框架库文件-->
	<!-- <script type="text/javascript"
		src="http://code.jquery.com/jquery-2.1.3.js"></script> -->
<script src="<%=path %>/plugins/jquery2.1.3.min.js" type="text/javascript"></script>
<!-- 引用JQuery分页插件 -->
<script src="<%=path%>/plugins/jqPaginator.js" type="text/javascript"></script>
	<script type="text/javascript">
		var $container;
		var $topPanel;
		var $leftContent;
		var $rightContent;
		$(function() {
			$container = $("#container");
			$topPanel=$container.find(".topPanel");
			$leftContent = $container.find(".left-content");
			$rightContent = $container.find(".right-content");
			//加载头部列表
			$topPanel.load("common/top.jsp");
			//加载列表
			$leftContent.load("toLeft", function() {
				var $parent = $(this);
				//点击
				$parent.find(".left-item").on("click", function(e) {
					var $this = $(this);

					//高亮处理
					$parent.find(".left-item").removeClass("active");
					$this.addClass("active");
					//使用SPA，在一个URL加载两个界面
					//阻止a标签原有的默认事件
					e.preventDefault();
					//得到a标签href属性的值
					var pageRef = $this.find("a").prop("href");
					var id= $this.find("a").data("id");
					console.log("id:"+id);
					//JQuery load页面
					$rightContent.load(pageRef,{id:id});
				}).first().click();
			});
		});
	</script>
</body>

</html>