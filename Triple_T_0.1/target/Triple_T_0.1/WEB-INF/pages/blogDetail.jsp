<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<meta charset="utf-8">
	<title></title>
	<link rel="stylesheet" type="text/css" href="/resources/css/reset.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/clearfix.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/jquery.fancybox-1.3.1.css" media="screen">
	<link rel="stylesheet" href="/resources/css/blogDetail.css">
	<link rel="stylesheet" href="/resources/css/base.css">
	<link rel="stylesheet" href="/resources/css/dark.css">
	<link rel="stylesheet" href="/resources/css/login_register.css">
	<script class="autoinsert" src="/resources/js/jquery-1.2.6.min.js"></script>
	<script src="/resources/js/jquery-1.4.2.min.js"></script>
	<script src="/resources/js/index.js"></script>
	<script src="/resources/js/blogDetail.js"></script>
	<script src="/resources/js/base.js"></script>
	<script src="/resources/js/login_register.js"></script>

	<script type="text/javascript">
		function changeImg(){
			document.getElementById("captcha-image").src = "/Kaptcha.jpg?" + Math.floor(Math.random()*100);
		}

		function onSearch(){

		}

		$(document).ready(function($){

			$('.theme-login').click(function(){
				if($('.theme-login span').html()=="登录") {
					var flag= getCookie("flag");
					if(flag =="true"){
						alert("您已登录");
						location.reload(true);
					}else {
						$('.login-mask').show();
						$('.login-mask').height($(document).height());
						$('.login-box').slideDown(200);
					}
				}

			})
			$('.close').click(function(){
				$('.login-mask').hide();
				$('.login-box').slideUp(200);
			})

		});
		$(document).ready(function($) {
			$('.exit').click(function () {
				$('.exit').click(function () {
					var flag = getCookie("flag");
					if (flag != "true") {
//                    alert("您已登出");
						location.reload(true);
					} else {
						deleteCookie("flag");
						location.href = "/logout";
					}
				})
			});
		});
			$(document).ready(function ($) {

				$('.theme-register').click(function () {
					$('.register-mask').show();
					$('.register-mask').height($(document).height());
					$('.register-box').slideDown(200);
				})
				$('.close').click(function () {
					$('.register-mask').hide();
					$('.register-box').slideUp(200);
				})

			});
			$(document).ready(function () {
				$("#email").blur(function () {
					var email = $("#email").val();
					if (email == '') {
						document.getElementById("sm").style.display = "block";
						return false;
					}
					else {
						var reg = /^([a-zA-Z0-9]+[_|-|.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|-|.]?)*[a-zA-Z0-9]+.[a-zA-Z]{2,3}$/;
						if (!reg.test(email)) {
							document.getElementById("sm").style.display = "block";
							return false;
						}
					}
					document.getElementById("sm").style.display = "none";
				})
			});
			function Cmd(obj) {
				var len = obj.value.replace(/[^\x00-\xff]/g, "**").length;
				if (len < 6 || len > 18) {
					// alert("请输入6-18个字节的字符");
					document.getElementById("sp").style.display = "block";
					//  obj.focus();
				} else {
					document.getElementById("sp").style.display = "none";
				}
			}

			function confirm(obj) {
				var conpassword = obj.value;
				var password = $("#R_password").val();
				if (conpassword != password) {
					document.getElementById("scp").style.display = "block";
				} else {

					document.getElementById("scp").style.display = "none";
				}

		}
	</script>
</head>

<body  class="jsDisabled">
<div id="header" class="clearfix">

	<div class="holder clearfix">

		<div class="skipLink"><a href="#content" title="Skip to content">Skip to content</a></div>

		<div id="title"><span><a href="/" title="点击我回到首页" rel="home">Triple T</a></span></div>
		<ul id="siteNav">
			<c:choose>
				<c:when test="${sessionScope.flag}">
					<li><a class="exit" href="javascript:;" style="text-decoration:none"><span>退出</span></a></li>
					<li><a class="theme-login"  name="selfinfo" onclick="loginout()" style="text-decoration:none"
						   <%--onclick="loginout(this)"--%>
							><span>
                        <c:out value="${sessionScope.userName}"/>
                    </span></a></li>

				</c:when>
				<c:otherwise>
					<li><a class="theme-register" href="javascript:;"style="text-decoration:none"><span>注册</span></a></li>
					<li><a class="theme-login" href="javascript:;" style="text-decoration:none"><span>登录</span></a></li>
				</c:otherwise>
			</c:choose>
		</ul>

	</div>

</div><!-- #header -->
<div class="wrapper">
	<div id="div1">
		<div id="container">
			<div id="wrap">
				<div id="sd_detail">
					<div class="sd_title">
						<div id="sd_title_t" name="${note.noteid}">${note.title}</div>
						<c:choose>
							<c:when test="${sessionScope.favourNoteFlag}">
								<div id="sd_collect" onclick="sdcollect()" name="collectCancle">[取消收藏]</div>
							</c:when>
							<c:otherwise>
								<div id="sd_collect" onclick="sdcollect()" name="collect" >[收藏帖子] </div>
							</c:otherwise>

						</c:choose>
					</div>
					<div id="sd_article">
						<p>
							${note.pushcontent}
						</p>
					</div>
				</div>

				<div id="sd_comment">
					<div class="sd_title">
						<div class="sd_title_t" style="font-size: 18px;">评论</div>
					</div>
					<div id="sd_list">
						<div id="add_comment">
							<div id="add_c_part">
								<input type="text" id="comment_input"/>
							</div>
							<div id="add_c_btn" onclick="bd_addcomment()">添加评论</div>
						</div>
						<ul>
							<c:forEach items="${commentList}" var="Comment">
								<li class="list_detail">
									<div class="user">
										<div class="user_name">
												${Comment.commenter}
										</div>
										<div class="comment_time">
											<td><fmt:formatDate value='${Comment.commentdate}' pattern='yyyy-MM-dd HH:mm:ss'/></td>
										</div>
									</div>
									<div class="comment_detail">
											${Comment.commentcontent}
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
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
				<button type="submit" tabindex="5" onclick="onlogin()">登录</button>
			</div>
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
						<input type="text" name="userName" id="R_username" tabindex="1" autocomplete="off" />
					</div>
				</div>
				<div class="password">
					<div class="before">
						<label>密码：</label>
					</div>
					<div class="back">
						<input type="password"  placeholder="最少6个字符"  name="password" id="R_password" maxlength="16" tabindex="2" onblur="Cmd(this)"/>
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
						<input type="text"  placeholder="如:15150698580@163.com" name="email" id="email"/>
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
</body>
</html>
