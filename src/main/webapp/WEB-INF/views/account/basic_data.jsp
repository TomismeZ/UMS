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
		<div class="header">
			<h4>基本资料</h4>
		</div>
		<div class="accountContent">
			<form action="editCurrentAccount" method="post">
				<input type="hidden" name="account.id" value="${account.id }">
				<input type="hidden" name="id" value="${id}">
				<div class="left">
					<div class="input-group">
						<label class="input-label">用户名：</label> <label
							class="input-content"> <input type="text" class="input"
							name="account.userName" value="${account.userName}">
						</label>
					</div>
					<div class="input-group">
						<label class="input-label">姓 名：</label> <label
							class="input-content"> <input type="text" class="input"
							name="account.name" value="${account.name }">
						</label>

					</div>
					<div class="input-group">
						<label class="input-label">性 别：</label> <label
							class="input-content"> <c:choose>
								<c:when test="${account.gender == 'male'}">
									<input type="radio" name="account.gender" value="male" checked>男 <input
										type="radio" name="account.gender" value="female">女
					</c:when>
								<c:otherwise>
									<input type="radio" name="account.gender" value="male">男 <input
										type="radio" name="account.gender" value="female" checked>女
					</c:otherwise>
							</c:choose>
						</label>
					</div>
				</div>
				<div class="right">
					<div class="input-group">
						<label class="input-label">密 码：</label> <label
							class="input-content"> <input type="password"
							name="account.password" value="${account.password }"
							class="input">
						</label>
					</div>
					<div class="input-group">
						<label class="input-label">手 机：</label> <label
							class="input-content"> <input type="number" class="input"
							name="account.phoneNumber" value="${account.phoneNumber }">
						</label>
					</div>
					<div class="input-group">
						<c:choose>
							<c:when test="${account.status == 'enable' }">
								<input type="radio" name="account.status" value="enable" checked>启用
						<input type="radio" name="account.status" value="disable">禁用
						</c:when>
							<c:otherwise>
								<input type="radio" name="account.status" value="enable">启用
					<input type="radio" name="account.status" value="disable" checked>禁用
						</c:otherwise>
						</c:choose>
					</div>
				</div>
			</form>
		</div>
		<div class="button-group">
			<button type="reset">取消</button>
			<button>编辑</button>
		</div>
	</c:when>
	<c:when test="${id eq 2}">
		<div class="header">
			<h4>详细资料</h4>
		</div>
		<div class="accountContent">

			<form action="editCurrentAccount" method="post">
				<input type="hidden" name="account.id" value="${account.id }">
				<input type="hidden" name="id" value="${id}">
				<div class="left">
					<div class="input-group">
						<label class="input-label">用户名：</label> <label
							class="input-content"> <input type="text"
							name="account.userName" value="${account.userName }">
						</label>

					</div>
					<div class="input-group">
						<label class="input-label">姓 名：</label> <label
							class="input-content"> <input type="text"
							name="account.name" value="${account.name }">
						</label>

					</div>

					<div class="input-group">
						<label class="input-label">性 别：</label> <label
							class="input-content"> <c:choose>
								<c:when test="${account.gender == 'male'}">
									<input type="radio" name="account.gender" value="male" checked>男 <input
										type="radio" name="account.gender" value="female">女
					</c:when>
								<c:otherwise>
									<input type="radio" name="account.gender" value="male">男 <input
										type="radio" name="account.gender" value="female" checked>女
					</c:otherwise>
							</c:choose>


						</label>
					</div>


					<div class="input-group">
						<label class="input-label">状 态：</label> <label
							class="input-content"> <c:choose>
								<c:when test="${account.status == 'enable' }">
									<input type="radio" name="account.status" value="enable"
										checked>启用
						<input type="radio" name="account.status" value="disable">禁用
						</c:when>
								<c:otherwise>
									<input type="radio" name="account.status" value="enable">启用
					<input type="radio" name="account.status" value="disable" checked>禁用
						</c:otherwise>
							</c:choose>

						</label>
					</div>
				</div>

				<div class="right">
					<div class="input-group">
						<label class="input-label">密 码：</label> <label
							class="input-content"> <input type="password"
							name="account.password" placeholder="${account.password}" value="${currentAccount.password}">
						</label>
					</div>


					<div class="input-group">
						<label class="input-label">手 机：</label> <label
							class="input-content"> <input type="number"
							name="account.phoneNumber" value="${account.phoneNumber }">
						</label>
					</div>

					<div class="input-group">
						<label class="input-label">部 门：</label> <label
							class="input-content"> <select name="account.department.id">
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
						</select>

						</label>	
					</div>

					<div class="input-group">
						<label class="input-label">角 色：</label> <label
							class="input-content"> <select name="account.role.id">
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
						</select>

						</label>
					</div>
				</div>


			</form>
		</div>
		<div class="button-group">

			<button type="reset">取消</button>
			<button>修改</button>
		</div>
	</c:when>
	<c:otherwise>
		<div class="header">
			<h4>头像设置</h4>
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
				<s:submit value="修改" class="submit"></s:submit>
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
