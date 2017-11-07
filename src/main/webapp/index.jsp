<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>用户管理系统</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
<link rel="stylesheet" type="text/css" href="css/index.css">

</head>
<style type="text/css">

	html, body {
	margin: 0px;
	padding: 0px;
	overflow-x: hidden;
}

#index {
	width: 100%;
	height: 670px;
	/*background-image: url(1.png);*/
	background-size: 100% 100%;
}

.container {
	width: 100%;
	height: 60px;
	/*background-color: rgba(192, 192, 192, 0.8);*/
	background-color: #ccc;
	position: fixed;
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	z-index: 1;
}
.container .ourname{
	flex-basis: 20%;
	margin-left: 30px;
	/*background-color: yellow;*/

	display: flex;
	justify-content: center;
	align-items: center;
	color: white;
	font-size: 32px;
	flex-direction: row;

}
.container .logo{
	flex-basis: 60px;
	height: 60px;
	/*background-color: red;*/
	background-image: url(images/logo1.png);
	background-size: 100% 100%;
}
ul{
	list-style: none;
	float: right;
	margin: 0;
	padding-right:60px;
}
ul li {
	float: left;
	/* font-size: 20px; */
	margin-right:20px;
	line-height: 60px;
}
ul li a {
	text-decoration: none;
	font-size:16px;
	color: white;
}
 ul li:hover, ul li.active
	{
	/*text-decoration: underline;*/
}
a:focus {
	text-decoration: none;	
}

a:hover {
	color: #777;
	/*text-decoration: underline;*/
	text-decoration: none;
}

.menu {
	width: 20%;
	height: 60px;
	line-height: 60px;
	font-size: 24px;
	color: white;
	float: left;
	text-align: center;
}

.collapse {
	float: right;
	width: 35%;
	height: 100%;
	line-height: 60px;
}

.mission {
	width: 100%;
	height: 950px;
	/*background-image: url(../images/index.jpg);*/
	background-size: cover;
	/*overflow-y: scroll;*/
}



#index .title-v1, .title-v2 {
	width: 600px;
	height: 70px;
	margin: 0 auto;
	text-align: center;
	font-size: 2.4em;
	font-weight:lighter;
	color: white;
	position: relative;
	top: 240px;
}

#index .title-v2 button {
	width: 150px;
	height: 40px;
	font-size: 20px;
	background-color: rgba(192, 192, 192, 0.1);
	color: white;
	border:2px solid white;
	border-radius: 5px;
	outline: none;
}

#index .title-v2 button:hover {
	background-color: rgba(192, 192, 192, 0.3);
}

#index .title-v2 button:active {
	background-color: gray;
	opacity: 0.5;
	border-color: white;
}

.mission {
	padding-top: 60px;
	/*background-color: #c4f7aa;*/
}

.brief-introduction {
	width: 88%;
	margin: 0 auto;
	padding-top: 20px;
	font-size: 18px;
	color: white;
	line-height: 30px;
}

.liu {
	text-align: center;
}

.brief-introduction table {
	width: 100%;
	margin: 0 auto;
	font-size: 20px;
}

.brief-introduction tr {
	width: 100%;
	height: 250px;
}

.brief-introduction td {
	text-align: center;
	border-collapse: collapse;
	padding: 0 20px;
}

.help {
	width: 100%;
	height: 650px;
	/*background-image: url(index1.);*/
	background-size: 100%;
	background-position: absolute;
	left: 0px;
	top: 0px;
	/*background-color: rgba(30, 30, 30, 0.1);*/
}

.contact {
	margin: 0 auto;
	width: 68%;
	height: 80%;
	position: relative;
	top: 120px;
	/*background-color: red;*/
	color: white;
}
.contact .sendtome{
	margin: 0 auto;
	width: 50%;
	height: 10%;
	/*background-color: red;*/
	line-height: 100%;
	text-align: center;
	font-size: 2.4em;
	font-weight: lighter;
}

.contact-us {
	width: 50%;
	height: 50%;
	position: relative;
	top: 40px;
	float: left;
}

.contact-us td {
	color: white;
	font-size: 18px;
	line-height: 100px;
}

.contact-words {
	position: relative;
	top: 70px;
	width: 50%;
	height: 50%;
	float: right;
	color: white;
	font-size: 1.4em;
	padding-top: 5px;
}

.contact-words input {
	width: 370px;
	height: 20px;
	margin: 0 0 35px 0;
	background-color: rgba(192, 192, 192, 0.9);
	border-radius: 4px;
	border-color: rgba(192, 192, 192, 0.2);
	/*border: 1px solid rgba(192, 192, 192, 0.2);*/
}

.contact-words textarea {
	position:relative;
	top:5px;
	width: 370px;
	height: 100px;
	/*border-color: rgba(192, 192, 192, 0.8);*/
	background-color: rgba(192, 192, 192, 0.9);
	margin: 0 0 15px 0;
	border-radius: 5px;
}

.contact-words button {
	color: white;
	background-color: rgba(192, 192, 192, 0.2);
	border-color: rgba(192, 192, 192, 0.2);
	width: 80px;
	height: 30px;
	border-color: rgba(192, 192, 192, 0.2);
	border-radius: 4px;

}

.submit {
	position: relative;
	left: 300px;
}

.contact-words textarea:hover {
	background-color: rgba(192, 192, 192, 0.1);
}

.contact-words input:hover {
	background-color: rgba(192, 192, 192, 0.1);
}
.nouser{
	height: 60px;
	width: 100%;
	background-color: #d4e7ba;
}

.love {
    display: block;
    width: 115px; height: 115px;
    background: url(images/web_heart_animation.png) 0 0 no-repeat;
    background-size: 2900%;
    animation: heart-burst steps(28) 1.2s infinite both;
    position:absolute;
    left: 360px;
    bottom: 230px; 
}
@keyframes heart-burst {
  0% {
    background-position: 0%;
  }
  100% {
    background-position: 100%;
  }
}
</style>
<body>
	<nav class="navbar navbar-default navbar-fixed-top topnav"
		role="navigation">
		<div class="container">
			 <div class="ourname">
			 	<div class="logo"></div>UMS</div>
			 <div class="collapse" id="example">
				<ul class="navbar-nav">
					<li><a href="#about">关于</a></li>
					<li><a href="#mission">简介</a></li>
					<li><a href="#help">联系我们</a></li>
					<li><a href="toLogin">登录/注册</a></li>
				</ul>
			</div> 
		</div>
	</nav>

	<a name="about"></a>

	<div id="index">
		<div class="title-v1">用 户 管 理 系 统</div>
		<div class="title-v2">
			<button>Login...</button>
		</div>
			<iframe frameborder="0" scrolling="no" src="index2.html" width="100%" height="500px"></iframe>
			<div class="love"></div>
	</div>


	<section id="mission" class="">
	
		<div class="mission">
			<div class="brief-introduction">
				本用户管理系统是通过用户进行登录管理其他用户的一个系统性系统，登录用户可以有编辑，删除，增加用户等权限，
				也可以为用户赋予其他权限，用户操作后将永久从数据库中删除和改动。<br>
				<hr>
				<table>
					<tr>
						<td class="a"><img src="images/login.jpg" width="350px"><br>登录界面</td>
						<td class="b"><img src="images/register.jpg" width="350px"><br>注册界面</td>
						<td class="c"><img src="images/index2.jpg" width="350px"><br>帮助页面</td>
					</tr>
					<tr>
						<td><img src="images/operation.jpg" width="350px"><br>操作界面</td>
						<td><img src="images/append.jpg" width="350px"><br>添加界面</td>
						<td><img src="images/Headportrait.jpg"
							width="350px"><br>头像页面</td>
					</tr>
				</table>
				本系统由HPE Unversity java2班无敌霸王六枪组合完成<br>
				<hr>
				<table>
					<tr>
						<td><img src="images/liu.jpg" width="350px"
							height="230"><br>无敌霸王六枪</td>
						<td><img src="images/liu1.jpg" width="350px"
							height="230"><br>双击666</td>
						<td><img src="images/liu2.jpg" width="350px"
							height="230"><br>认真中...</td>
					</tr>
				</table>
			</div>
		</div>
	</section>

	<section id="help" class="contacts-section">
		<div class="help">
			<div class="contact">
				<div class="sendtome">『&nbsp;联系我们&nbsp;』</div>
				<div class="contact-us">

					<table>
						<tr>
							<td>地址：遵义市红花岗区重创小镇阿尔泰室</td>
						</tr>
						<tr>
							<td>电话：+86-8888888888</td>
						</tr>
						<tr>
							<td>邮件：wbangquan@sina.com</td>
						</tr>
						<tr>
							<td>集团：无敌霸王枪集团</td>
						</tr>
					</table>
				</div>
				<div class="contact-words">
					<form action="#" method="post">
						<div class="name">
							姓名:<br>
							<input type="text" name="name">
						</div>
						<div class="email">
							邮件:<br>
							<input type="text" name="email">
						</div>
						<div class="textareas">
							留言:<br>
							<textarea name="liuyan" style="resize: none; overflow: hidden;"></textarea>
						</div>

						<div class="submit">
							<button>提交</button>
						</div>
					</form>
				</div>
			</div>
		</div>

	</section>
	
	<script src="<%=path%>/plugins/jquery2.1.3.min.js"
		type="text/javascript"></script>
	<script type="text/javascript">
	
		$("#index").find(".title-v2").find("button").on("click",function(){
			
			window.location.href="toLogin";
		});
	</script>
	
</body>
</html>
