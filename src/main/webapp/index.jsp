<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<head>
<meta charset="UTF-8">
<title>用户管理系统</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top topnav"
		role="navigation">
		<div class="container">
			<div class="btn-audio" data-path="<%=path%>"><audio id="mp3Btn" loop="loop" autoplay="autoplay"><source src="<%=path %>/music/1.mp3" type="audio/mpeg" /></audio></div>
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
	</div>


	<section id="mission" class="">
		<div class="mission">
			<div class="brief-introduction">
				本用户管理系统是通过用户进行登录管理其他用户的一个系统性系统，登录用户可以有编辑，删除，增加用户等权限，
				也可以为用户赋予其他权限，用户操作后将永久从数据库中删除和改动<br>
				<hr>
				<table>
					<tr>
						<td><img src="<%=path%>/images/login.jpg" width="350px"><br>登录界面</td>
						<td><img src="<%=path%>/images/register.jpg" width="350px"><br>注册界面</td>
						<td><img src="<%=path%>/images/index2.jpg" width="350px"><br>系统首页面</td>
					</tr>
					<tr>
						<td><img src="<%=path%>/images/operation.jpg" width="350px"><br>操作界面</td>
						<td><img src="<%=path%>/images/append.jpg" width="350px"><br>添加界面</td>
						<td><img src="<%=path%>/images/Headportrait.jpg"
							width="350px"><br>头像页面</td>
					</tr>
				</table>
				本系统由HPE Unversity java2班无敌霸王六枪组合完成<br>
				<hr>
				<table>
					<tr>
						<td><img src="<%=path%>/images/liu.jpg" width="350px"
							height="230"><br>无敌霸王六枪</td>
						<td><img src="<%=path%>/images/liu1.jpg" width="350px"
							height="230"><br>双击666</td>
						<td><img src="<%=path%>/images/liu2.jpg" width="350px"
							height="230"><br>认真中...</td>
					</tr>
				</table>
			</div>
		</div>
	</section>

	<section id="help" class="contacts-section">
		<div class="help">
			<div class="contact">
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
        $(function(){
        	var path=$(".btn-audio").data("path");
            //播放完毕
            $('#mp3Btn').on('ended', function() {
                console.log("音频已播放完成");
                $('.btn-audio').css({'background':'url('+path+'/images/zanting.jpg) no-repeat center bottom','background-size':'cover'});
            })
            //播放器控制
            var audio = document.getElementById('mp3Btn');
            audio.volume = 0.3;
            audio.currentTime += 20;
            $('.btn-audio').click(function() {
                event.stopPropagation();//防止冒泡
                if(audio.paused){ //如果当前是暂停状态
                    $('.btn-audio').css({'background':'url('+path+'/images/bofang.jpg) no-repeat center bottom','background-size':'cover'});
                    audio.play(); //播放
                    return;
                }else{//当前是播放状态
                    $('.btn-audio').css({'background':'url('+path+'/images/zanting.jpg) no-repeat center bottom','background-size':'cover'});
                    audio.pause(); //暂停
                }
            });
        })
    </script>
	<script type="text/javascript">
	
		$("#index").find(".title-v2").find("button").on("click",function(){
			
			window.location.href="toLogin";
		});
	</script>
</body>
</html>
