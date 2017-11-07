<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<c:choose>
	<c:when test="${jurisdiction ==null }">
		<div class="headline">
			<h2>添加权限</h2>
		</div>
		<div class="jurisdictionContent">
			<form action="saveJurisdiction" method="post" class="real-content-form form" id="reg-form" id="reg-form">

				<div class="form-group">
					<label class="input-label">名称</label> <label class="input-content">
						<input class="input" type="text" name="jurisdiction.name" 
						data-easyform="length:2 16;real-time;"
                               data-message="名称必须为2—16位的英文字母或数字或（1-8）中文"
                               data-easytip="class:easy-blue;">
					</label>

				</div>
				<div class="form-group">
					<label class="input-label">描述</label> <label class="textarea-content">

						<textarea name="jurisdiction.description"
						data-easyform="length:1 255;real-time;"
                               data-message="描述不可为空"
                               data-easytip="class:easy-blue;"></textarea>
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
			<h2>修改权限信息</h2>
		</div>
		<div class="jurisdictionContent">
			<form action="editJurisdiction" method="post" class="real-content-form form">
				<!-- 把id的值传到Action里，验证id是否存在，如果存在只修改信息，否则添加新记录 -->
				
				<div class="form-group">
					<label class="input-label">名称</label> <label class="input-content">
						<input class="input" type="text" name="jurisdiction.name"
						value="${jurisdiction.name }" readonly="readonly">
					</label>

				</div>
				<div class="form-group">
					<label class="input-label">描述</label> <label class="jurisdiction-content">

						<textarea name="jurisdiction.description"> ${jurisdiction.description }</textarea>
					</label>
				</div>

	<input type="hidden" name="jurisdiction.id"
					value="${jurisdiction.id }">
			</form>
		</div>
		<div class="button-group">
			<button class="btn btn-warning">取消</button>
			<button class="btn btn-success">保存</button>
		</div>
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	var $content = $rightContent.find(".jurisdictionContent");
	var findAllInfo = "findAllJurisdiction";
	var v = $content.find("form").easyform();
</script>
<!-- 引入外部脚本 -->
<script src="<%=path%>/js/add_common.js"></script>
