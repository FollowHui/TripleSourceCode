<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>

		<link rel="stylesheet" href="/resources/css/blogDetail.css">
		<link rel="stylesheet" href="/resources/css/index.css">
		<link rel="stylesheet" href="/resources/css/login_register.css">
		<script class="autoinsert" src="/resources/js/jquery-1.2.6.min.js"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
		<script src="/resources/js/jquery-1.4.2.min.js"></script>

		<script src="/resources/js/index.js"></script>
		<script src="/resources/js/blogDetail.js"></script>
	</head>

	<body>
	<div id="bd_outer">
		<div id="header">
		<ul class="ful">
			<c:choose>
				<c:when test="${sessionScope.flag}">
					<li class="fli"><a class="exit" href="javascript:;" style="text-decoration:none"><span>退出</span></a></li>
					<li class="fli"><a class="theme-login" href="javascript:;"style="text-decoration:none"><span>
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
			<div id="nav-title" name="${note.noteid}"><span>帖子 详细信息</span></div>
	</div>
		<div id="container">
			<div id="wrap">
				<div id="sd_detail">
					<div class="sd_title">
						<div class="sd_title_t">${note.title}</div>
						<c:choose>
							<c:when test="${sessionScope.favourNoteFlag}">
								<div id="sd_collect" onclick="sdcollect()" name="collectCancle"> [取消收藏]</div>
							</c:when>
							<c:otherwise>
								<div id="sd_collect" onclick="sdcollect()" name="collect"> [收藏帖子]</div>
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
						<div class="sd_title_t">评论</div>
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
												${Comment.commentdate}
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
	</body>
</html>
