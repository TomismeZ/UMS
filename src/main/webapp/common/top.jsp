<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="logo-panel">
	<div class="logo-content-panel"></div>
	<h5>用户管理系统</h5>
</div>
<div class="menu-panel">
	<div class="userinfo">
		<img src="getImage" alt="" width="30" height="30" style=" border-radius: 50%;" />
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
			<a href=""><img src="getImage" alt="" width="90" height="90" style=" border-radius: 50%;"/></a>
			<div class="changetheme">
				切换主题: <br /> <a class="default"></a> <a class="blueline"></a> <a
					class="greenline"></a> <a class="contrast"></a> <a class="custombg"></a>
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
				<li><a href="javascript:;">账号设置</a></li>
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
	
	$topPanel.find(".logo-panel").find("h5").on("click",function(){
		// 以下方式直接跳转
	/* 	window.location.href='loginAccount'; */
		// 以下方式定时跳转
		setTimeout("javascript:location.href='loginAccount'", 1000); 
	});
/* 	//列表的点击事件
	var $li = $userinfodrop.find(".userdata").find("li:not(:last-child)");
	$li.find("a").on("click", function(e) {

		var $this = $(this);
		//阻止a标签原有的默认事件
		e.preventDefault();
		//得到a标签href属性的值
		var pageRef = $this.prop("href");
		console.log(pageRef);
		$leftContent.load(pageRef, function() {
			var $parent = $(this);
			//点击
			$parent.find(".left-item").on("click", function(e) {
				var $this = $(this);

				//高亮处理
				$parent.find(".left-item").removeClass("active");
				$this.addClass("active");
				//使用SPA，在一个URL加载两个界面
				//阻止a标签原有的默认事件
				e.preventDefault();
				//得到a标签href属性的值
				var id = $this.find("a").data("id");
				console.log("基本资料:" + id);
				var pageRef1 = $this.find("a").prop("href");
				//JQuery load页面
				$rightContent.load(pageRef1, {
					id : id
				});
			}).first().click();
		});
	}); */
	//切换主题
	var $changetheme=$userinfodrop.find(".avatar").find(".changetheme");
	$changetheme.find("a").on("click",function(){
		var $this=$(this);
		
		$topPanel.css("background-color",$this.css("background-color"))
	});
</script>
