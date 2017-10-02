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
<%-- <link type="text/css" rel="stylesheet" href="<%=path%>/css/style.css"/> --%>
<style type="text/css">
/**
总容器
**/
#container {
	width: 800px;
	height: 600px;
	border: 1px solid red;
	margin: 0 auto;
	display: flex;
	flex-direction: column;
}

#container header {
	flex-grow: 1;
	min-height: 60px;
	max-height: 60px;
	border-bottom: 1px solid red;
}

#container .content {
	flex-grow: 1;
	display: flex;
	flex-direction: row;
}

#container .content .left-content {
	flex-grow: 1;
	min-width: 140px;
	max-width: 140px;
	border-right: 1px solid red;
}

#container .content .right-content {
	flex-grow: 1;
	overflow: auto;
	margin: 8px;
	border: 1px solid #797979;
	display: flex;
	flex-direction: column;
}
/**
left.jsp，style代码
**/
#container .content .left-content ul {
	padding: 0;
	margin: 0;
	list-style: none;
}

#container .content .left-content ul li {
	height: 40px;
	line-height: 40px;
	padding-left: 30px;
	cursor: pointer;
	border-bottom: 1px solid grey;
}
#container .content .left-content ul li a{
	text-decoration: none;
	color: #000000;
}

#container .content .left-content ul li:hover, #container .content .left-content ul li.active
	{
	background-color: #CCCCCC;
	color: white;
}

/**
accountManage.jsp,CSS样式
**/
#container .content .right-content .header {
	flex-grow: 1;
	min-height: 45px;
	max-height: 45px;
	padding-left:10px;
	border-bottom:1px solid red;
}
#container .content .right-content .account-manage{
flex-grow: 1;
}
#container .content .right-content .account-manage .footer,
#container .content .right-content .role-manage .footer,
#container .content .right-content .jurisdiction-manage .footer,
#container .content .right-content .department-manage .footer{
	width: 95%;
	margin-right:5%;
	height: 80px;
	text-align: right;
	
}
#container .content .right-content table {
	/* width:-webkit-calc(100%-8px); */
	width:97%;
	border-collapse: collapse;
	margin: 8px;
}

#container .content .right-content .header button {
	margin: 10px;
	width: 60px;
	border: 1px solid grey;
	background-color: white;
}

#container .content .right-content table, #container .content .right-content th,
	#container .content .right-content td {
	border: 1px solid red;
}

/**
添加account页面的CSS样式
**/
#container .content .right-content .accountContent,
#container .content .right-content .roleContent,
#container .content .right-content .jurisdictionContent,
#container .content .right-content .departmentContent {
	flex-grow: 1;
	position: relative;
}

#container .content .right-content .accountContent .left,
#container .content .right-content .accountContent .right {
	position: absolute;
	width: 50%;
	height: 100%;
}

#container .content .right-content .accountContent .right {
	right: 0;
}

#container .content .right-content .accountContent .input-group{
	width: 100%;
	text-align: center;
	height: 30px;
	line-height: 30px;
	margin-bottom: 5%;
}

#container .content .right-content .accountContent .input-group .input{
	width: 90%;
	height: 21px;
	border: 1px solid black;
	font-size: 15px;
	padding-left: 10px;
	margin-top: 10px;
}

#container .content .right-content .accountContent .input-group .input-content,
#container .content .right-content .roleContent .input-group .input-content,
#container .content .right-content .jurisdictionContent .input-group .input-content,
#container .content .right-content .departmentContent .input-group .input-content{
	width: 70%;
	/*对于外部其他元素是行内元素，对于内部是块级元素*/
	display: inline-block;
	text-align: left;
}

#container .content .right-content .button-group {
	flex-grow: 1;
	min-height: 45px;
	max-height: 45px;
	border-top: 1px solid red;
	text-align: center;
}

#container .content .right-content .button-group button {
	margin: 10px;
	border: 1px solid grey;
	background-color: white;
	width: 60px;
	float: right;
}
/**
	add_role.jsp,add_jurisdictionCSS样式
**/

#container .content .right-content .roleContent .input-group,
#container .content .right-content .jurisdictionContent .input-group,
#container .content .right-content .departmentContent .input-group {
	width: 95%;
	height: 30px;
	line-height: 30px;
	margin:2% 0 5% 3%;
}
#container .content .right-content .roleContent .input-group .input-label,
#container .content .right-content .jurisdictionContent .input-group .input-label,
#container .content .right-content .departmentContent .input-group .input-label{
	margin-top:5px;
	vertical-align: top;
	
}
#container .content .right-content .roleContent .input-group:nth-child(2){
	height: 180px;
}
#container .content .right-content .roleContent .input-group .input-content:nth-child(3){
	
	background-color: red;
}
#container .content .right-content .roleContent .input-group .input,
#container .content .right-content .jurisdictionContent .input-group .input,
#container .content .right-content .departmentContent .input-group .input {

	width: 60%;
	height: 21px;
	border: 1px solid black;
	font-size: 15px;
	padding-left: 10px;
	margin-top: 10px;
}

#container .content .right-content .roleContent .input-group textarea,
#container .content .right-content .jurisdictionContent .input-group textarea,
#container .content .right-content .departmentContent .input-group textarea{
	width: 100%;
	height: 160px;
	border: 1px solid #A9A9A9;
	font-size: 15px;
	padding:2px;
	margin-top: 10px;
	overflow: hidden;
	/* resize: none; */
}
</style>
</head>

<body>
	<div id="container">
		<header> </header>
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
		var $leftContent;
		var $rightContent;
		$(function() {
			$container = $("#container");
			$leftContent = $container.find(".left-content");
			$rightContent = $container.find(".right-content");
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
					//JQuery load页面
					$rightContent.load(pageRef);
				}).first().click();
			});
		});
	</script>
</body>

</html>