<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
%>
<div class="header">
	<button>添加</button>
	<button>删除</button>
</div>

<div class="account-manage">
	<div class="table">
		<table>
			<thead>
				<th>序号</th>
				<th>用户名</th>
				<th>姓名</th>
				<th>部门</th>
				<th>角色</th>
				<th>状态</th>
				<th>创建时间</th>
				<th>操作</th>
			</thead>
			<tbody>
				<!-- varStatus获取当前索引或序号 -->
				<c:forEach var="item" items="${pageBean.list }" varStatus="status">
					<tr class="account-content-item" data-id="${item.id }">
						<!-- count获取当前序号，从1开始 -->
						<!-- index获取当前索引，从0开始 -->
						<td><input type="checkbox" name="checkbox"
							value="${item.id }" data-id="${item.id }"> ${status.count }</td>
						<td class="username">${item.userName }</td>
						<td class="name">${item.name }</td>
						<td class="department">${item.department.name }</td>
						<td class="role">${item.role.name }</td>
						<td>${item.status }</td>

						<td><fmt:formatDate value="${item.createTime }" /></td>
						<td><a class="link link-primary" href="toEdit"
							data-id="${item.id }">编辑</a> <a class="link link-danger"
							href="deleteAccount" data-id="${item.id }">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="footer">
<input type="hidden"
			data-currentpage="${pageBean.currentPage }"> <input
			type="hidden" value="${pageBean.allRows }"> <input
			type="hidden" data-totalpages="${pageBean.totalPage }">

		<ul class="pagination" id="pagination1"></ul>
	</div>
</div>
<script type="text/javascript">
	var addPrivilege="toAdd";
	var manageRef = "toAccount";
	var deleteInfo = "deleteAccount";
	var findAllInfo = "findAllAccount";
	var $mangeClass = $rightContent.find(".account-manage");
	//Jquery分页插件用到时的变量
	var $inputFirst = $mangeClass.find(".footer").find("input:first");
	var $inputLast = $mangeClass.find(".footer").find("input:last");
	var $inputallRows = $mangeClass.find(".footer").find(
			"input:not(:first,:last)");
	var totalPages = $inputLast.data("totalpages");
	var currentPage = $inputFirst.data("currentpage");
	var allRows = $inputallRows.val();

	
	if (totalPages == 0) {
		totalPages = 1;
	}
	/**
	 * jQuery 分页插件
	 */

	$.jqPaginator(
					'#pagination1',
					{
						totalPages : totalPages,
						visiblePages : 8,
						currentPage : currentPage,
						first : '<li class="first"><a href="javascript:;">首页</a></li>',
						prev : '<li class="prev"><a href="javascript:;" data-page="${pageBean.currentPage - 1 }">上一页</a></li>',
						next : '<li class="next"><a href="javascript:;" data-page="${pageBean.currentPage + 1 }">下一页</a></li>',
						last : '<li class="last"><a href="javascript:;" data-page="${pageBean.totalPage }">尾页</a></li>',
						page : '<li class="page"><a href="javascript:;" data-page="{{page}}">{{page}}</a></li>',
					/* onPageChange : function(num, type) {
						$('font').text(type + '：' + num);
					} */
					});
	
/* 	if (allRows % totalPages == 1) {
		--currentPage;
	}
	alert(currentPage+":dsf"); */
</script>
<!-- 引入外部脚本 -->
<script src="<%=path%>/js/common.js"></script>
