<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UMS</title>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/login.css"/>

</head>

<body>
	<div id="container">
		<header> </header>
		<div class="content">

			<div class="loginAccount">
				<form action="loginAccount" method="post">
					<div class="input-group">
						<input type="text" name="account.userName" placeholder="用户名">
						
					</div>
					<span></span>
					<div class="input-group">

						<input type="password" name="account.password" placeholder="密码">
						
					</div>
					<span></span>
					<div class="button-group">
						<div>忘记密码？</div>
						<div class="submit">
							<button>登录</button>
						</div>
					</div>
				</form>
			</div>
		</div>

	</div>
	<!--引入jQuery框架库文件-->
<!-- 	<script type="text/javascript"
		src="http://code.jquery.com/jquery-2.1.3.js"></script> -->
<script src="<%=path %>/plugins/jquery2.1.3.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		var $container = $("#container");
		var $form = $container.find(".loginAccount").find("form");
		$form.find("span").hide();
		var $username = $form.find("input[name='account.userName']");
		$username.on("blur", function() {
			/* alert($username.prop("placeholder")); */

			$.ajax({
				cache : true,
				type : "POST",
				url : "findByName",
				data : {
					"account.userName" : $username.val()
				},
				async : false,
				error : function(request) {
					alert("Connection error");
				},
				success : function(data) {
					/* alert(data.message) */
					$username.css("border", "1px solid red");
					/* $username.css("color", "red"); */
					$username.prop("placeholder", data.message);
					/* $container.find(".loginAccount").css("height","60%");
					$container.find(".loginAccount").css("top","20%"); */
					
						$username.parent().next().show().text(data.message);
					
					
					
				}
			});
		});
	</script>

</body>

</html>