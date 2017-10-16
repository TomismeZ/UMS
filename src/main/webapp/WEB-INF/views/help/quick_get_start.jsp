<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<div class="left-content" data-id="${id}">
</div>
<div class="right-content"></div>
<script type="text/javascript">
	var $leftContent=$contentPanel.find(".left-content");
	var $rightContent=$contentPanel.find(".right-content");
	var flag=$leftContent.data("id");
	$leftContent.load("leftContent",{id:flag},function(){
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
			var id=$this.find("a").data("id");
			//JQuery load页面
			$rightContent.load(pageRef,{id:id});
		}).first().click();
	});
</script>