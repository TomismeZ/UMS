<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<c:choose>
	<c:when test="${role ==null }">
		<div class="headline">
			<h2>添加角色</h2>
		</div>
		<div class="roleContent">
			<form action="saveRole" method="post" class="real-content-form form" id="reg-form">
				<div class="form-group">
					<label class="input-label">名称</label> <label class="input-content">
						<input class="input" type="text" name="role.name"
						data-easyform="length:2 16;real-time;"
                               data-message="名称必须为2—16位的英文字母或数字或（1-8）中文"
                               data-easytip="class:easy-blue;">
					</label>
				</div>
				<div class="form-group">
					<label class="input-label">描述</label> 
					<label class="textarea-content">
						<textarea name="role.description"
						data-easyform="length:2 255;real-time;"
                               data-message="描述尽可能要多一点"
                               data-easytip="class:easy-blue;"></textarea>
					</label>
				</div>

				<div class="form-group">
					<label class="input-label">权限</label> <label class="jurisdiction-content">
						<c:forEach items="${jurisdictions }" var="item">
							<input type="checkbox" name="role.jurisdictions.id"
								class="checkbox" value="${item.id }">&nbsp;${item.name }　
						</c:forEach>
					</label>
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
			<h2>修改角色信息</h2>
		</div>
		<div class="roleContent">
			<form action="editRole" method="post" class="real-content-form form">
				<div class="form-group">
					<label class="input-label">名称</label> <label class="input-content">
						<input class="input" type="text" name="role.name"
						value="${role.name }" readonly="readonly">
					</label>

				</div>
				<div class="form-group">
					<label class="input-label">描述</label> <label class="textarea-content">

						<textarea name="role.description">${role.description }</textarea>
					</label>
				</div>

				<div class="form-group">
					<label class="input-label">权限</label> <label class="jurisdiction-content">
						<c:forEach items="${jurisdictions }" var="item">
							<c:choose>
								<c:when test="${item.flag eq true}">
									<input type="checkbox" name="role.jurisdictions.id"
										class="checkbox" value="${item.id }" checked>${item.name }　
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="role.jurisdictions.id"
										class="checkbox" value="${item.id }">&nbsp;${item.name }　
								</c:otherwise>
							</c:choose>

						</c:forEach>
					</label>
				</div>
				<input type="hidden" name="role.id" value="${role.id }">
			</form>
		</div>
		<div class="button-group">
			<button class="btn btn-warning">取消</button>
			<button class="btn btn-success">保存</button>
		</div>
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	var $content = $rightContent.find(".roleContent");
	var findAllInfo = "findAllRole";
	var v = $content.find("form").easyform();
</script>
<!-- 引入外部脚本 -->
<script src="<%=path%>/js/add_common.js"></script>
