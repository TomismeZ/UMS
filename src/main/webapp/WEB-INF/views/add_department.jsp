<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<c:choose>
	<c:when test="${department ==null }">
		<div class="header">
			<h4>添加部门</h4>
		</div>
		<div class="departmentContent">
			<form action="saveDepartment" method="post">

				<div class="input-group">
					<label class="input-label">名称：</label> <label class="input-content">
						<input class="input" type="text" name="department.name">
					</label>

				</div>
				<div class="input-group">
					<label class="input-label">描述：</label> <label class="input-content">
						
						<textarea name="department.description" ></textarea>
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
			<h4>修改部门信息</h4>
		</div>
		<div class="departmentContent">
			<form action="editDepartment" method="post">
			<!-- 把id的值传到Action里，验证id是否存在，如果存在只修改信息，否则添加新记录 -->
			<input type="hidden" name="department.id" value="${department.id }">
				<div class="input-group">
					<label class="input-label">名称：</label> <label class="input-content">
						<input class="input" type="text" name="department.name" value="${department.name }">
					</label>

				</div>
				<div class="input-group">
					<label class="input-label">描述：</label> <label class="input-content">
						
						<textarea name="department.description"> ${department.description }</textarea>
					</label>
				</div>
				

			</form>
		</div>
		<div class="button-group">

			<button type="reset">取消</button>
			<button>保存</button>
		</div>
	</c:otherwise>
</c:choose>

<script type="text/javascript">
var $content=$rightContent.find(".departmentContent");
var findAllInfo="findAllDepartment";
</script>
<!-- 引入外部脚本 -->
<script src="<%=path%>/js/add_common.js"></script>
