<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
%>
<div id="hidden" style="display: none;" data-id="${id}"></div>
<c:choose>
	<c:when test="${id eq 1}">
		<div class="headline">
			<h2>基本资料</h2>
		</div>
		<div class="accountContent">
			<form action="editCurrentAccount" method="post" class="real-content-form form">
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
						type="password" name="account.password" value="${account.password}">
				</div>
				<div class="form-group">
					<label class="input-label">手机</label> <input class="input-content"
						type="text" name="account.phoneNumber" value="${account.phoneNumber }">
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
				<input type="hidden" name="account.id" value="${account.id }">
				<input type="hidden" name="id" value="${id}">
			</form>
		</div>
		<div class="button-group">
			<button class="btn btn-warning">取消</button>
			<button class="btn btn-success">保存</button>
		</div>
	</c:when>
	<c:when test="${id eq 2}">
		<div class="headline">
			<h2>详细资料</h2>
		</div>
		<div class="accountContent">

			<form action="editCurrentAccount" method="post" class="real-content-form form">
				<input type="hidden" name="account.id" value="${account.id }">
				<input type="hidden" name="id" value="${id}">
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
						type="password" name="account.password" value="${account.password}">
				</div>
				<div class="form-group">
					<label class="input-label">手机</label> <input class="input-content"
						type="text" name="account.phoneNumber" value="${account.phoneNumber }">
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
	</c:when>
	<c:otherwise>
		<div class="headline">
			<h2>头像设置</h2>
		</div>
		<div class="accountContent">
			<div class="avatar-setting">
			<s:form theme="simple" action="editCurrentAccount" method="post"
				enctype="multipart/form-data" validate="true">
				<input type="hidden" name="account.id" value="${account.id }">
				<input type="hidden" name="id" value="${id}">
				<img id="image" src="getImage.action" width="100" height="120" />
				<s:file name="photo" accept="image/*"
					onchange="document.all['image'].src=getImgURL(this);" />
				<s:submit value="修改" class="btn btn-success submit"></s:submit>
			</s:form>
			</div>		
		</div>
		
	</c:otherwise>
</c:choose>
<script type="text/javascript">
	function getImgURL(node) {
		var imgURL = "";
		try {
			var file = null;
			if (node.files && node.files[0]) {
				file = node.files[0];
			} else if (node.files && node.files.item(0)) {
				file = node.files.item(0);
			}
			try {
				imgURL = window.URL.createObjectURL(file);
			} catch (e) {
				imgRUL = window.URL.createObjectURL(file);
			}
		} catch (e) {

			if (node.files && node.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					imgURL = e.target.result;
				};
				reader.readAsDataURL(node.files[0]);
			}
		}
		return imgURL;
	}
</script>
<script type="text/javascript">
	var $content = $rightContent.find(".accountContent");
	
	$rightContent.find(".button-group").find("button:first").on("click",function(){
		$rightContent.load(findAllInfo);
	});
	$rightContent.find(".button-group").find("button:last").on("click",function(){
		var $form=$content.find("form");
		var id=$("#hidden").data("id");
		/* $form.submit(); */
		/*  $form.on("submit",function(e){
			//阻止原标签原有的默认事件
			 e.preventDefault();
			 //得到a标签href属性的值
	         var pageRef=$(this).prop("action");
	         //JQuery load页面
	         $rightContent.load(pageRef);
		}).submit();  */
		console.log("基本资料:" + id);
		$.ajax({
	        cache: true,
	        type: "POST",
	        url:$form.prop("action"),
	        data:$form.serialize(),// 你的formid
	        async: false,
	        error: function(request) {
	            alert("Connection error");
	        },
	        success: function(data) {
	        	
	        	if(data.message='success'){
	        		alert("修改成功！"); 
	        	}
	        }
	    });
	});
</script>
