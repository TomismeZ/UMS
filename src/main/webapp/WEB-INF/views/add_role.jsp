<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<c:choose>
	<c:when test="${role ==null }">
		<div class="header">
			<h4>添加角色</h4>
		</div>
		<div class="roleContent">
			<form action="saveRole" method="post">

				<div class="input-group">
					<label class="input-label">名称：</label> <label class="input-content">
						<input class="input" type="text" name="role.name">
					</label>
				</div>
				<div class="input-group">
					<label class="input-label">描述：</label> <label class="input-content">
						
						<textarea name="role.description" ></textarea>
					</label>
				</div>
				
				<div class="input-group ">
					<label class="input-label">权限：</label> <label class="input-content">
						<c:forEach items="${jurisdictions }" var="item">
							<input type="checkbox" name="role.jurisdictions.id" class="checkbox" value="${item.id }"
							>${item.name }　
						</c:forEach>
					</label>
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
			<h4>修改角色信息</h4>
		</div>
		<div class="roleContent">
			<form action="editRole" method="post">
				
				<div class="input-group">
					<label class="input-label">名称：</label> <label class="input-content">
						<input class="input" type="text" name="role.name" value="${role.name }">
					</label>

				</div>
				<div class="input-group">
					<label class="input-label">描述：</label> <label class="input-content">
						
						<textarea name="role.description">${role.description }</textarea>
					</label>
				</div>
				
				<div class="input-group">
					<label class="input-label">权限：</label> <label class="input-content">
						<c:forEach items="${jurisdictions }" var="item">
							<c:choose>
								<c:when test="${item.flag eq true}">
								<input type="checkbox" name="role.jurisdictions.id" class="checkbox" value="${item.id }" checked>${item.name }　
								</c:when>
								<c:otherwise>
								<input type="checkbox" name="role.jurisdictions.id" class="checkbox" value="${item.id }">${item.name }　
								</c:otherwise>
							</c:choose>
							
						</c:forEach>
					</label>
				</div>
			<input type="hidden" name="role.id" value="${role.id }">
			</form>
		</div>
		<div class="button-group">

			<button type="reset">取消</button>
			<button>保存</button>
		</div>
	</c:otherwise>
</c:choose>

<script type="text/javascript">
var $content=$rightContent.find(".roleContent");
var findAllInfo="findAllRole";
</script>
<!-- 引入外部脚本 -->
<script src="<%=path%>/js/add_common.js"></script>
