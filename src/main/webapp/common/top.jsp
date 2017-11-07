<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
%>
<div class="logo-panel">
	<div class="logo-content-panel"></div>
	<h5>用户管理系统</h5>
</div>
<div class="menu-panel">
	<div class="userinfo">
		<c:choose>
			<c:when test="${not empty currentAccount.photo }">
			<img src="getImage" alt="" width="30" height="30" style=" border-radius: 50%;" />
			</c:when>
			<c:otherwise>
			<img src="<%=path %>/images/avatar.png" alt="" width="30" height="30" style=" border-radius: 50%;" />
			</c:otherwise>
		</c:choose>
		
		<c:choose>
		<c:when test="${not empty currentAccount.role.name}">
		<span>${currentAccount.role.name}</span>
		</c:when>
		<c:otherwise>
		<span>角色</span>
		</c:otherwise>
		</c:choose>
		 
	</div>
	<!--userinfo-->
	<div class="userinfodrop">
		<div class="avatar">
		<c:choose>
			<c:when test="${not empty currentAccount.photo }">
			<a href=""><img src="getImage" alt="" width="60" height="60" style=" border-radius: 50%;"/></a>
			</c:when>
			<c:otherwise>
			<a href=""><img src="<%=path %>/images/avatarbig.png" alt="" width="60" height="60" style=" border-radius: 50%;"/></a>
			</c:otherwise>
		</c:choose>
			
			<div class="changetheme">
				切换主题: <br /> <a class="default"></a>
				 <a class="blueline"></a>
				 <a class="greenline"></a>
				 <a class="contrast"></a>
				 <a class="custombg"></a>
			</div>
		</div>
		<!--avatar-->
		<div class="userdata">
		<c:choose>
		<c:when test="${not empty currentAccount.name}">
		<h4>${currentAccount.name }</h4>
		</c:when>
		<c:otherwise>
		<h4>TomisZ</h4>
		</c:otherwise>
		</c:choose>
			
		<c:choose>
		<c:when test="${not empty currentAccount.phoneNumber}">
		<span class="phone-number">${currentAccount.phoneNumber}</span>
		</c:when>
		<c:otherwise>
		<span class="phone-number">18883986xxx</span>
		</c:otherwise>
		</c:choose>
			
			<ul>
				<li><a href="personalSetting">编辑资料</a></li>
				<li><a href="toHelp">帮助</a></li>
				<li><a href="logoutAccount">退出</a></li>
			</ul>
		</div>
		<!--userdata-->
	</div>
	<!--userinfodrop-->
</div>
<script type="text/javascript">
	var $menuPanel = $topPanel.find(".menu-panel");
	var $userinfodrop = $menuPanel.find(".userinfodrop");
	$menuPanel.find('.userinfo').click(function() {
		if (!$(this).hasClass('active')) {
			$menuPanel.find('.userinfodrop').show();
			$(this).addClass('active');
		} else {
			$menuPanel.find('.userinfodrop').hide();
			$(this).removeClass('active');
		}

		return false;
	});
	$menuPanel.find('.userinfodrop').on("mouseleave",function(){
		var $this=$(this);
		$this.hide();
		$menuPanel.find('.userinfo').removeClass('active');
	});
	
	$topPanel.find(".logo-panel").find("h5").on("click",function(){
		// 以下方式直接跳转
	/* 	window.location.href='loginAccount'; */
		// 以下方式定时跳转
		setTimeout("javascript:location.href='loginAccount'", 300); 
	});

	//切换主题
	var $changetheme=$userinfodrop.find(".avatar").find(".changetheme");
	$changetheme.find("a").on("click",function(){
		var $this=$(this);
		
		$topPanel.css("background-color",$this.css("background-color"));
		$leftContent.css("background-color",$this.css("color"));
	});
</script>
