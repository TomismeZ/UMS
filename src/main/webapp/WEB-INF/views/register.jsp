<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
							type="text" name="account.userName"></label>
					</section>
					<section>
						<label class="lable">登陆密码</label> <label class="input"><input
							type="password" name="account.password"></label>
					</section>
				</div>
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
	
	$registContent.find(".register-button-panel").find("button").on("click",
			function() {
				/* alert($("input[type='hidden']").val()); */
				$form = $registContent.find("form");
				var userName = $form.find("input[type='text']").val();
				var password = $form.find("input[type='password']").val();
				var id=$form.find("input[type='hidden']").val();
				if(id == 1){
					if (!$.trim(userName) || !$.trim(password)) {
						alert("用户名或者密码不能为空！");
					} else {
						$.ajax({
							cache : true,
							type : "POST",
							url : $form.prop("action"),
							data : $form.serialize(),// 你的formid
							async : false,
							error : function(request) {
								alert("Connection error");
							},
							success : function(data) {
								alert(data.message);
							}
						});
					}
				}else if(id==2){
					if (!$.trim(userName)) {
						alert("用户名不能为空！");
					} else {
						$.ajax({
							cache : true,
							type : "POST",
							url : $form.prop("action"),
							data : $form.serialize(),// 你的formid
							async : false,
							error : function(request) {
								alert("Connection error");
							},
							success : function(data) {
								alert(data.message);
							}
						});
					}
				}
				
			});
</script>