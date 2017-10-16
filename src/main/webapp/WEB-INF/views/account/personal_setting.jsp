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
<link type="text/css" rel="stylesheet" href="<%=path%>/css/style.css"/>
<style type="text/css">
body {
	display: flex;
	flex-direction: column;
}
</style>

</head>
<body>
	<div id="top-panel"></div>
	<div id="account-setting-panel">
		<div class="left-content"></div>
		<div class="right-content"></div>
	</div>
	<script src="<%=path%>/plugins/jquery2.1.3.min.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		var $topPanel;
		var $leftContent;
		var $rightContent;
		$(function() {
			$topPanel = $("#top-panel");
			$leftContent=$("#account-setting-panel").find(".left-content");
			$rightContent=$("#account-setting-panel").find(".right-content");
			//加载头部列表
			$topPanel.load("common/top.jsp");
			$leftContent.load("settingMenu", function() {
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
					var id = $this.find("a").data("id");
					console.log("基本资料:" + id);
					var pageRef1 = $this.find("a").prop("href");
					//JQuery load页面
					$rightContent.load(pageRef1, {
						id : id
					});
				}).first().click();
			});
			
		
		});
	</script>
</body>
</html>