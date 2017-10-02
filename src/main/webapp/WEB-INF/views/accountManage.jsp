<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<link type="text/css" rel="stylesheet" href="<%=path%>/plugins/bootstrap.min.css"/> 
<div class="header">
	<button>添加</button>
	<button>删除</button>
</div>

<div class="account-manage">
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
					<td><input type="checkbox" name="checkbox" value="${item.id }" data-id="${item.id }">
						${item.id }</td>
					<td>${item.userName }</td>
					<td>${item.name }</td>
					<td>${item.department.name }</td>
					<td>${item.role.name }</td>
					<td>${item.status }</td>
					<td>${item.createTime }</td>
					<td><a href="toAccount" data-id="${item.id }">编辑</a>
					 <a href="deleteAccount" data-id="${item.id }">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="footer">
		<font size="3">共<font color="red">${pageBean.totalPage }</font>页
		</font>&nbsp;&nbsp; <font size="3">共<font color="red">${pageBean.allRows }</font>条记录
		</font><br>
	<input type="hidden" data-currentpage="${pageBean.currentPage }">
	<input type="hidden" data-totalpages="${pageBean.totalPage }">
	
    <ul class="pagination" id="pagination1"></ul>
	</div>
</div>
<script type="text/javascript">
var manageRef="toAccount";
var deleteInfo="deleteAccount";
var findAllInfo="findAllAccount";
var $mangeClass=$rightContent.find(".account-manage");
//Jquery分页插件用到时的变量
var $inputFirst=$mangeClass.find(".footer").find("input:first");
var $inputLast=$mangeClass.find(".footer").find("input:last");
var totalPages=$inputLast.data("totalpages");
var currentPage=$inputFirst.data("currentpage");
/**
 * jQuery 分页插件
 */

$.jqPaginator(
				'#pagination1',
				{
					totalPages : totalPages,
					visiblePages : 8,
					currentPage : currentPage,
					first : '<li class="first"><a href="javascript:;">First</a></li>',
					prev : '<li class="prev"><a href="javascript:;" data-page="${pageBean.currentPage - 1 }">Previous</a></li>',
					next : '<li class="next"><a href="javascript:;" data-page="${pageBean.currentPage + 1 }">Next</a></li>',
					last : '<li class="last"><a href="javascript:;" data-page="${pageBean.totalPage }">Last</a></li>',
					page : '<li class="page"><a href="javascript:;" data-page="{{page}}">{{page}}</a></li>',
				/* onPageChange : function(num, type) {
					$('font').text(type + '：' + num);
				} */
				});

</script>
<!-- 引入外部脚本 -->
<script src="<%=path%>/js/common.js"></script>
