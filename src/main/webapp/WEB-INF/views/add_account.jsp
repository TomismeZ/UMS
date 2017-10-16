<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>

<c:choose>
	<c:when test="${account ==null }">
	<div class="header">
	<h4>添加用户</h4>
	</div>
<div class="accountContent">
	<form action="saveAccount" method="post">
		<div class="left">
			 <div class="input-group">
				<label class="input-label">用户名：</label> <label class="input-content">
					<input type="text" class="input" name="account.userName">
				</label>

			</div>
			<div class="input-group">
				<label class="input-label">姓 名：</label> <label class="input-content">
					<input type="text" class="input" name="account.name">
				</label>

			</div>
			<div class="input-group">
				<label class="input-label">性 别：</label> <label class="input-content">
					<input type="radio" name="account.gender" value="male" checked>男 <input
					type="radio" name="account.gender" value="female">女
				</label>
			</div>
			<div class="input-group">
				<label class="input-label">状 态：</label> <label class="input-content">
					<input type="radio" name="account.status" value="enable" checked>启用
					<input type="radio" name="account.status" value="disable">禁用
				</label>
			</div> 
		</div>

		<div class="right">
			<div class="input-group">
				<label class="input-label">密 码：</label> <label class="input-content">
					<input type="password" name="account.password" class="input">
				</label>
			</div>


			<div class="input-group">
				<label class="input-label">手 机：</label> <label class="input-content">
					<input type="number" class="input" name="account.phoneNumber">
				</label>
			</div>

			<div class="input-group">
				<label class="input-label">部　门：</label> <label class="input-content">
					<select name="departmentName">
						<c:forEach items="${departments}" var="department">
							<option value="${department.name }">${department.name }</option>
						</c:forEach>
				</select>

				</label>
			</div>
			
			<div class="input-group">
				<label class="input-label">角　色：</label> <label class="input-content">
					<select name="roleName">
						<c:forEach items="${roles}" var="role">
							<option value="${role.name }">${role.name }</option>
						</c:forEach>
				</select>

				</label>
			</div>
		</div>


	</form>
</div>
<div class="button-group">

	<button type="reset">取消</button>
	<button>保存</button>
</div>
	</c:when>
	<c:otherwise>
	<div class="header">
	<h4>编辑用户</h4>
</div>
<div class="accountContent">
	
	<form action="saveAccount" method="post">
		<input type="hidden" name="account.id" value="${account.id }">
		<div class="left">
			 <div class="input-group">
				<label class="input-label">用户名：</label> <label class="input-content">
					<input type="text" name="account.userName" value="${account.userName }">
				</label>

			</div>
			<div class="input-group">
				<label class="input-label">姓 名：</label> <label class="input-content">
					<input type="text" name="account.name" value="${account.name }">
				</label>

			</div>
			
			<div class="input-group">
				<label class="input-label">性 别：</label> <label class="input-content">
				<c:choose>
					<c:when test="${account.gender == 'male'}">
					<input type="radio" name="account.gender" value="male" checked>男 <input
					type="radio" name="account.gender" value="female" >女
					</c:when>
					<c:otherwise>
					<input type="radio" name="account.gender" value="male">男 <input
					type="radio" name="account.gender" value="female" checked>女
					</c:otherwise>
				</c:choose>
				
					
				</label>
			</div>
			
		
			<div class="input-group">
				<label class="input-label">状 态：</label> <label class="input-content">
					<c:choose>
						<c:when test="${account.status == 'enable' }">
						<input type="radio" name="account.status" value="enable" checked>启用
						<input type="radio" name="account.status" value="disable">禁用
						</c:when>
						<c:otherwise>
						<input type="radio" name="account.status" value="enable" >启用
					<input type="radio" name="account.status" value="disable" checked>禁用
						</c:otherwise>
					</c:choose>
					
				</label>
			</div> 
		</div>

		<div class="right">
			<div class="input-group">
				<label class="input-label">密 码：</label> <label class="input-content">
					<input type="password" name="account.password"
					placeholder="${account.password}">
				</label>
			</div>


			<div class="input-group">
				<label class="input-label">手 机：</label> <label class="input-content">
					<input type="number" name="account.phoneNumber" value="${account.phoneNumber }">
				</label>
			</div>

			<div class="input-group">
				<label class="input-label">部　门：</label> <label class="input-content">
					<select name="departmentName">
						<c:forEach items="${departments}" var="department">
						<c:choose>
							
							<c:when test="${account.department.name eq department.name}">
							<option value="${department.name }" selected="selected">${department.name }</option>
							</c:when>
							<c:otherwise>
							<option value="${department.name }">${department.name }</option>
							</c:otherwise>
						</c:choose>
							
						</c:forEach>
				</select>

				</label>
			</div>
			
			<div class="input-group">
				<label class="input-label">角　色：</label> <label class="input-content">
					<select name="roleName">
						<c:forEach items="${roles}" var="role">
						<c:choose>
							<c:when test="${account.role.name == role.name}">
							<option value="${role.name }" selected="selected">${role.name }</option>
							</c:when>
							<c:otherwise>
							<option value="${role.name }">${role.name }</option>
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
	</c:otherwise>
</c:choose>

<script type="text/javascript">
var $content=$rightContent.find(".accountContent");
var findAllInfo="findAllAccount";
</script>
<!-- 引入外部脚本 -->
<script src="<%=path%>/js/common.js"></script>
