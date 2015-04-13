<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="utf-8">
	<title></title>

	<link rel="stylesheet" href="/resources/css/school.css">
	<link rel="stylesheet" href="/resources/css/index.css">
	<link rel="stylesheet" href="/resources/css/login_register.css">
	<script class="autoinsert" src="/resources/js/jquery-1.2.6.min.js"></script>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
	<script src="/resources/js/jquery-1.4.2.min.js"></script>

	<script src="/resources/js/index.js"></script>
	<script src="/resources/js/school.js"></script>

	<%--<script type="text/javascript">--%>
		<%--function s_collect(){--%>
			<%--var flag = document.getElementById("flag").name;--%>
			<%--if( flag !=true){--%>
				<%--alert("请先登录");--%>
			<%--}--%>
			<%--else {--%>
				<%--s_collectxmlhttp();--%>
			<%--}--%>
		<%--}--%>
	<%--</script>--%>

	<script type="text/javascript">
		function changeImg(){
			document.getElementById("captcha-image").src = "/Kaptcha.jpg?" + Math.floor(Math.random()*100);
		}

		$(document).ready(function($){
			$('.exit').click(function(){
				location.href = "/logout";
			})
		});
		$(document).ready(function($){

			$('.theme-login').click(function(){
				if($('.theme-login span').html()=="登录") {
					$('.login-mask').show();
					$('.login-mask').height($(document).height());
					$('.login-box').slideDown(200);
				}
				else
				{
					//document.getElementById("div1").style.display="none";
					//document.getElementById("div6").style.display="block";
				}
			})
			$('.close').click(function(){
				$('.login-mask').hide();
				$('.login-box').slideUp(200);
			})

		});
		$(document).ready(function($){

			$('.theme-register').click(function(){
				$('.register-mask').show();
				$('.register-mask').height($(document).height());
				$('.register-box').slideDown(200);
			})
			$('.close').click(function(){
				$('.register-mask').hide();
				$('.register-box').slideUp(200);
			})

		});
		$(document).ready(function() {
			$("#email").blur(function () {
				var email = $("#email").val();
				if (email == '') {
					document.getElementById("sm").style.display="block";
					return false;
				}
				else {
					var reg =/^([a-zA-Z0-9]+[_|-|.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|-|.]?)*[a-zA-Z0-9]+.[a-zA-Z]{2,3}$/;
					if (!reg.test(email)) {
						document.getElementById("sm").style.display="block";
						return false;
					}
				}
				document.getElementById("sm").style.display="none";
			})
		});
		function Cmd(obj){
			var len = obj.value.replace(/[^\x00-\xff]/g, "**").length;
			if(len < 6|| len > 18){
				// alert("请输入6-18个字节的字符");
				document.getElementById("sp").style.display="block";
				//  obj.focus();
			}else
			{
				document.getElementById("sp").style.display="none";
			}
		}
		function confirm(obj){
			var conpassword = obj.value;
			var password = $("#R_password").val();
			if(conpassword!=password){
				document.getElementById("scp").style.display="block";
			}else{

				document.getElementById("scp").style.display="none";
			}
		}
	</script>
</head>

<body>
<div id="s_outer">
	<div id="flag" name="${sessionScope.flag}" style="display: none"></div>

	<div id="header">
		<ul class="ful">
			<c:choose>
				<c:when test="${sessionScope.flag}">
					<li class="fli"><a class="exit" href="javascript:;" style="text-decoration:none"><span>退出</span></a></li>
					<li class="fli"><a class="theme-login" href="/selfinfo" target="_blank" style="text-decoration:none"><span>
                        <c:out value="${sessionScope.userName}"/>
                    </span></a></li>

				</c:when>
				<c:otherwise>
					<li class="fli"><a class="theme-register" href="javascript:;"style="text-decoration:none"><span>注册</span></a></li>
					<li class="fli"><a class="theme-login" href="javascript:;" style="text-decoration:none"><span>登录</span></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	<div id="header-nav">
		<span style="float:left; margin-left:5%;">
			<img src="/resources/img/llogo.png">
		</span>
		<div id ="nav-title" class="nav-title" name="${schoolId}"><span>名校 详细信息</span></div>

		<br clear="all"/>
	</div>
	<div id="div1">
	<div id="container">
		<div id="wrap">
			<div id="s_discribe">
				<div class="s_title">
					<div class="s_titleline">
						<div class="s_t_p">
							<c:choose>
						<c:when test="${sessionScope.favourFlag}">
						<div id="s_collect" onclick="s_collect()" name="collectCancle">[取消收藏]</div>
						</c:when>
						<c:otherwise>
							<div id="s_collect" onclick="s_collect()" name="collect" >[收藏学校]</div>
						</c:otherwise>

						</c:choose>
						</div>
						<div class="s_titlename"><p>${school.schoolname}</p></div>
					</div>
					<div id="s_disc">
						<div id="s_disc_left">
							<a href="${school.address}" target="_blank"><img src="/resources/schoolLogo/${school.schoollogo}"></a>
						</div>
						<div id="s_disc_right">
								<p>成立时间:${school.settime}</p><br/>
								<p>国内排名:${school.ranking}</p><br/>
								<p>地址:${school.address}</p><br/>
								<p>联系电话：${school.phonenumber}</p>
						</div>
					</div>
				</div>

				<div id="s_project">
					<div class="s_titleline"><div class="s_titlename"><p>学校简介</p></div></div>
					<div class="s_disc">
						<p>${school.description}</p>
					</div>
				</div>

			</div>
		</div>

		<div class="login-mask">
			<div class="login-box" style=" display:none;">
				<h1>Triple T</h1>
				<div class="close">
					<h1><a href="javascript:;" style="text-decoration:none">X</a></h1>
				</div>
				<form method="post" action="/login">
					<div class="name">
						<div class="before">
							<label>用户名：</label>
						</div>
						<div class="back">
							<input type="text" name="userName" id="L_username" tabindex="1" autocomplete="off" />
						</div>
					</div>
					<div class="password">
						<div class="before">
							<label>密  码：</label>
						</div>
						<div class="back">
							<input type="password" name="password" maxlength="16" id="L_password"   tabindex="2"/>
						</div>

					</div>
					<div class="code">
						<div class="before">
							<label>验证码：</label>
						</div>
						<div class="back">
							<input type="text" name="verifyCode" maxlength="4" id="code" tabindex="3"/>
						</div>
						<div class="codeImg">
							<img src="/Kaptcha.jpg" id="captcha-image" onclick="changeImg();"/>
						</div>
					</div>
					<div class="remember">
						<input type="checkbox" id="remember" tabindex="4">
						<label>记住密码</label>
					</div>
					<div class="login">
						<button type="submit" tabindex="5">登录</button>
					</div>
				</form>
			</div>
		</div>
		<div class="register-mask">
			<div class="register-box" style="display:none;">
				<h1>Triple T</h1>
				<div class="close">
					<h1><a href="javascript:;" style="text-decoration:none">X</a></h1>
				</div>
				<form method="post" action="/register">
					<div class="name">
						<div class="before">
							<label>用户名:</label>
						</div>
						<div class="back">
							<input type="text" name="" id="R_username" tabindex="1" autocomplete="off" />
						</div>
					</div>
					<div class="password">
						<div class="before">
							<label>密码：</label>
						</div>
						<div class="back">
							<input type="password"  placeholder="最少6个字符"  name="" id="R_password" maxlength="16" tabindex="2" onblur="Cmd(this)"/>
						</div>
						<span id="sp" style="display: none">输入错误</span>
					</div>
					<div class="password">
						<div class="before">
							<label>确认密码：</label>
						</div>
						<div class="back">
							<input type="password" name="" id="C_password" maxlength="16" tabindex="2" onblur="confirm(this)"/>
						</div>
						<span id="scp" style="display: none">输入错误</span>
					</div>
					<div class="mailbox">
						<div class="before">
							<label>邮箱:</label>
						</div>
						<div class="back">
							<input type="text"  placeholder="如:15150698580@163.com" name="R_email" id="email"/>
						</div>
						<span id="sm" style="display: none">输入非法</span>
					</div>
					<div class="sex">
						<div class="before">
							<label>性别：</label>
						</div>
						<div class="back" style="margin-top: 10px;">
							男<input type="radio" checked="checked" name="sex" value="male"/>
							女<input type="radio" checked="checked" name="sex" value="female"/>
						</div>
					</div>
					<div class="register">
						<button type="submit" tabindex="5" class="submit">注册</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	</div>
</div>
</body>
</html>
