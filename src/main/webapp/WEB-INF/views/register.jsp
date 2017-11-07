<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<link type="text/css" rel="stylesheet" href="<%=path%>/plugins/toastr/toastr.min.css" />
<script src="<%=path%>/plugins/toastr/toastr.min.js"></script>
<div class="registContent">
	<c:choose>
		<c:when test="${id eq 1}">
			<div class="topPanel">
				<div class="title">用户注册</div>
				<button>×</button>
			</div>
			<form method="post" action="validateRegister">
				<input type="hidden" name="id" value="${id}">
				<div class="input-group-panle">
					<section>
						<label class="lable">用户名称</label> <label class="input"><input
							type="text" name="account.userName"
							data-easyform="length:3 16;char-normal;real-time;"
                               data-message="用户名必须为3—16位的英文字母或数字"
                               data-easytip="class:easy-blue;"></label>
					</section>
					<section>
						<label class="lable">登陆密码</label> <label class="input"><input
							type="password" name="account.password"
							data-easyform="length:6 20;char-normal;real-time;"
                               data-message="密码必须为6—16位的英文字母或数字"
                               data-easytip="class:easy-blue;"></label>
					</section>
					<section>
						<label class="lable">确认密码</label> <label class="input"><input
							type="password" name="account.passwordAgain"
							data-easyform="length:6 20;char-normal;real-time;"
                               data-message="密码必须为6—16位的英文字母或数字"
                               data-easytip="class:easy-blue;"></label>
					</section>
				</div>
				<input name="account.name" type="hidden" value="default">
				<input name="account.role.id" type="hidden" value="6">
				<input name="account.department.id" type="hidden" value="1">
			</form>
			<div class="register-button-panel">
				<button type="button">确定</button>
			</div>
			<div class="footPanel">
				点击注册，即同意我们的<a href="#">用户隐私条款</a>
			</div>

		</c:when>
		<c:otherwise>
			<div class="topPanel">
				<div class="title">找回密码</div>
				<button>×</button>
			</div>
			<form method="post" action="validateRegister">
				<input type="hidden" name="id" value="${id}">
				<div class="input-group-panle">
					<section>
						<label class="lable">用户名称</label> <label class="input"><input
							type="text" name="account.userName"></label>
					</section>
				</div>
			</form>
			<div class="register-button-panel">
				<button type="button">确定</button>
			</div>


		</c:otherwise>
	</c:choose>
</div>
<script type="text/javascript">
	var $registContent = $footer.find(".registContent");
	$registContent.find("form").easyform();
	$registContent.find(".register-button-panel").find("button").on("click",
			function() {
				/* alert($("input[type='hidden']").val()); */
				$form1 = $registContent.find("form");
				
				
				var $userName = $form1.find("input[type='text']");
				var $password = $form1.find("input[name='account.password']");
				var $passwordAgain=$form1.find("input[name='account.passwordAgain']");
				var id=$form1.find("input[type='hidden']").val();
				if(id == 1){
					if ($userName.val().length <3 || $userName.val().length>16) {
						$userName.trigger("blur");
					}else if($password.val().length <6 || $password.val().length>20){
						$password.trigger("blur");
					}else if($passwordAgain.val().length <6 || $passwordAgain.val().length>20){
						$passwordAgain.trigger("blur");
					} else {
						$.ajax({
							cache : true,
							type : "POST",
							url : $form1.prop("action"),
							data : $form1.serialize(),// 你的formid
							async : false,
							error : function(request) {
								toastr.error("Connection error");
							},
							success : function(data) {
								
								if(data.message == 'success'){
									toastr.success("您已经成功注册！等待管理员验证方可登录");
									$registContent.find(".topPanel").find("button").trigger("click");
								}else{
									toastr.warning(data.message);
								}
							}
						});
					}
				}else if(id==2){
					if (!$.trim($userName.val())) {
						toastr.warning("用户名不能为空！");
					} else {
						$.ajax({
							cache : true,
							type : "POST",
							url : $form1.prop("action"),
							data : $form1.serialize(),// 你的formid
							async : false,
							error : function(request) {
								toastr.error("Connection error");
							},
							success : function(data) {
								toastr.warning(data.message);
							}
						});
					}
				}
				
			});
</script>