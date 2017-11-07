<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>

<c:choose>
	<c:when test="${account ==null }">
		<div class="headline">
			<h2>新增用户</h2>
		</div>
		<div class="accountContent">
			<form action="saveAccount" method="post"
				class="real-content-form form">
				<div class="form-group">
					<label class="input-label">用户名</label> <input class="input-content"
						type="text" name="account.userName" placeholder="请输入用户名"
						data-easyform="length:3 16;char-normal;real-time;"
                               data-message="用户名必须为3—16位的英文字母或数字"
                               data-easytip="class:easy-blue;">
				</div>
				<div class="form-group">
					<label class="input-label">姓名</label> <input class="input-content"
						name="account.name" type="text" placeholder="请输入姓名"
						data-easyform="length:1 20;real-time;"
                               data-message="姓名不可为空"
                               data-easytip="class:easy-blue;">
				</div>
				<div class="form-group">
					<label class="input-label">密码</label> <input class="input-content"
						type="password" name="account.password" placeholder="请输入密码"
						data-easyform="length:6 20;char-normal;real-time;"
                               data-message="密码必须为6—16位的英文字母或数字"
                               data-easytip="class:easy-blue;">
				</div>
				<div class="form-group">
					<label class="input-label">手机</label> <input class="input-content"
						type="text" name="account.phoneNumber" placeholder="请输入手机号"
						data-easyform="length:1 20;real-time;"
                               data-message="手机号码不可为空"
                               data-easytip="class:easy-blue;">
				</div>
				<div class="form-group">
					<label class="input-label">部门</label> 
					<select name="account.department.id" class="select-content">
						<c:forEach items="${departments}" var="department">
							<option value="${department.id }">${department.name }</option>
						</c:forEach>
					</select> <i class="select-arrow"></i>
				</div>
				<div class="form-group">
					<label class="input-label">角色</label>
					 <select name="account.role.id"
						class="select-content">
						<c:forEach items="${roles}" var="role">
							<option value="${role.id }">${role.name }</option>
						</c:forEach>
					</select> <i class="select-arrow"></i>
				</div>
				<div class="form-group">
					<label class="input-label">性别</label>
					<div class="radio-content">
						<input type="radio" name="account.gender" value="男" checked> 男 <input
							type="radio" name="account.gender" value="女"> 女
					</div>
				</div>
				<div class="form-group">
					<label class="input-label">状态</label>
					<div class="radio-content">
						<input type="radio" name="account.status" value="启用" checked> 启用 <input
							type="radio" name="account.status" value="禁用"> 禁用
					</div>
				</div>
			</form>
		</div>
		<div class="button-group">
			<button class="btn btn-warning">取消</button>
			<button class="btn btn-success">保存</button>
		</div>
	</c:when>
	<c:otherwise>
		<div class="headline">
			<h2>编辑用户</h2>
		</div>
		<div class="accountContent">
			<form action="editAccount" method="post"
				class="real-content-form form">
				<input type="hidden" name="account.id" value="${account.id }">
				<div class="form-group">
					<label class="input-label">用户名</label> <input class="input-content"
						type="text" name="account.userName" value="${account.userName }" readonly="readonly">
				</div>
				<div class="form-group">
					<label class="input-label">姓名</label> <input class="input-content"
						name="account.name" type="text" value="${account.name }">
				</div>
				<div class="form-group">
					<label class="input-label">密码</label> <input class="input-content"
						type="password" name="account.password" value="${account.password}"
						data-easyform="length:6 20;char-normal;real-time;"
                               data-message="密码必须为6—16位的英文字母或数字"
                               data-easytip="class:easy-blue;">
				</div>
				<div class="form-group">
					<label class="input-label">手机</label> <input class="input-content"
						type="text" name="account.phoneNumber" value="${account.phoneNumber }"
						data-easyform="length:1 20;real-time;"
                               data-message="手机号码不可为空"
                               data-easytip="class:easy-blue;">
				</div>
				<div class="form-group">
					<label class="input-label">部门</label> 
					<select name="account.department.id" class="select-content">
						<c:forEach items="${departments}" var="department">
									<c:choose>

										<c:when test="${account.department.name eq department.name}">
											<option value="${department.id }" selected="selected">${department.name }</option>
										</c:when>
										<c:otherwise>
											<option value="${department.id }">${department.name }</option>
										</c:otherwise>
									</c:choose>

								</c:forEach>
					</select> <i class="select-arrow"></i>
				</div>
				<div class="form-group">
					<label class="input-label">角色</label>
					 <select name="account.role.id"
						class="select-content">
						<c:forEach items="${roles}" var="role">
									<c:choose>
										<c:when test="${account.role.name == role.name}">
											<option value="${role.id }" selected="selected">${role.name }</option>
										</c:when>
										<c:otherwise>
											<option value="${role.id }">${role.name }</option>
										</c:otherwise>
									</c:choose>

								</c:forEach>
					</select> <i class="select-arrow"></i>
				</div>
				<div class="form-group">
					<label class="input-label">性别</label>
					<div class="radio-content">
						<c:choose>
								<c:when test="${account.gender == '男'}">
									<input type="radio" name="account.gender" value="男" checked>男 <input
										type="radio" name="account.gender" value="女">女
					</c:when>
								<c:otherwise>
									<input type="radio" name="account.gender" value="男">男 <input
										type="radio" name="account.gender" value="女" checked>女
					</c:otherwise>
							</c:choose>
					</div>
				</div>
				<div class="form-group">
					<label class="input-label">状态</label>
					<div class="radio-content">
						<c:choose>
								<c:when test="${account.status == '启用' }">
									<input type="radio" name="account.status" value="启用"
										checked>启用
						<input type="radio" name="account.status" value="禁用">禁用
						</c:when>
								<c:otherwise>
									<input type="radio" name="account.status" value="启用">启用
					<input type="radio" name="account.status" value="禁用" checked>禁用
						</c:otherwise>
							</c:choose>
					</div>
				</div>
			</form>
		</div>
		<div class="button-group">
			<button class="btn btn-warning">取消</button>
			<button class="btn btn-success">保存</button>
		</div>
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	var $content = $rightContent.find(".accountContent");
	var findAllInfo = "findAllAccount";
	var v = $content.find("form").easyform();
	$rightContent.find(".button-group").find("button:first").on("click",
			function() {
				$rightContent.load(findAllInfo);
			});
	$rightContent.find(".button-group").find("button:last").on(
			"click",
			function() {
				var $form = $content.find("form");
				/*$form.on("submit",function(e){
					//阻止原标签原有的默认事件
					 e.preventDefault();
					 //得到form标签action属性的值
				     var pageRef=$(this).prop("action");
				     //JQuery load页面,局部刷新
				     $rightContent.load(pageRef,$form.serialize());
				}).submit();*/
				//异步刷新
				var $userName = $form.find("input[name='account.userName']");
						
				var $name = $form.find("input[name='account.name']");
				var $password = $form.find("input[type='password']");
				var $number = $form.find("input[name='account.phoneNumber']");
				if ($userName.val().length <3 || $userName.val().length>16) {
					$userName.trigger("blur");
				} else if($name.val().length ==0){
					$name.trigger("blur");
				}else if($password.val().length <6 || $password.val().length>20){
					$password.trigger("blur");
				}else if($number.val().length==0){
					$number.trigger("blur");
				}else {
					
					 $.ajax({
						cache : true,
						type : "POST",
						url : $form.prop("action"),
						data : $form.serialize(),// 你的formid
						async : false,
						error : function(request) {
							// alert("Connection error"); 
							toastr.error("Connection error");
						},
						success : function(data) {
							if (data.message == 'success') {
								$rightContent.load(findAllInfo,function(){
				        			toastr.success("保存成功");
				        		});
							} else if (data.message == 'error') {
								 toastr.warning("用户名已存在，请重新输入");					
								// alert("用户名已存在，请重新输入"); 	
								
							} else {
								// alert("权限不足");
								toastr.info("权限不足");
							}

						}
					}); 
				}

			});
</script>

