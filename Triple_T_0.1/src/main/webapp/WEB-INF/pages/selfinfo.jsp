<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/resources/css/selfinfo.css">
		<link rel="stylesheet" href="/resources/css/index.css">
		<script src="/resources/js/index.js"></script>
		<script src="/resources/js/selfinfo.js"></script>

		<script type="text/javascript">
			function changeImg(){
				document.getElementById("captcha-image").src = "/Kaptcha.jpg?" + Math.floor(Math.random()*100);
			}

			function onSearch(){

			}

			$(document).ready(function($){

				$('.theme-login').click(function(){
					if($('.theme-login span').html()=="登录") {
						$('.login-mask').show();
						$('.login-mask').height($(document).height());
						$('.login-box').slideDown(200);
					}
					else
					{
						onselfinfoclick();
//                    document.getElementById("div1").style.display="none";
//                    document.getElementById("div6").style.display="block";
					}
				})
				$('.close').click(function(){
					$('.login-mask').hide();
					$('.login-box').slideUp(200);
				})

			});
			$(document).ready(function($){
				$('.exit').click(function(){
					location.href = "/logout";
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
	<div id="header">
		<ul class="ful">
			<li class="fli"><a class="exit" href="/logout" style="text-decoration:none"><span>退出</span></a></li>
			<%--<c:choose>--%>
				<%--<c:when test="${sessionScope.flag}">--%>
					<%--<li class="fli"><a class="exit" href="javascript:;" style="text-decoration:none"><span>退出</span></a></li>--%>
					<%--<li class="fli"><a class="theme-login" href="javascript:;"style="text-decoration:none"><span>--%>
                        <%--<c:out value="${sessionScope.userName}"/>--%>
                    <%--</span></a></li>--%>

				<%--</c:when>--%>
				<%--<c:otherwise>--%>
					<%--<li class="fli"><a class="theme-register" href="javascript:;"style="text-decoration:none"><span>注册</span></a></li>--%>
					<%--<li class="fli"><a class="theme-login" href="javascript:;" style="text-decoration:none"><span>登录</span></a></li>--%>
				<%--</c:otherwise>--%>
			<%--</c:choose>--%>
		</ul>
	</div>
	<div id="header-nav">
		<span style="float:left; margin-left:5%;">
			<img src="/resources/img/llogo.png">
		</span>
		<div id="nav-title" name=""><span>用户 详细信息</span></div>
	</div>
	<div class="slide">
		<div class="selfinfo1">
			<h3>个人信息</h3>
			<div id="localImag"><img id="preview" style="width:150px;height:180px;" src="/resources/img/logo.png"></div>
			<div class="upload">
				<a href="javascript:;" class="a-upload"><input type="file" name="imgfile" id="imgfile" style="width:150px;" onchange="javascript:setImagePreview();"><span>上传图片</span></a>
			</div>
				<div class="selfinfo2">
					<div class="layer">
						<div class="mylabel">
							<label>用户名:</label>
						</div>
						<div class="slide_input">
							<%--<input type="text" id="S_username" name="username"/>--%>
								<p><c:out value="${user.username}"></c:out></p>
						</div>
					</div>
					<div class="layer">
						<div class="mylabel">
							<label>性别:</label>
						</div>
						<div class="slide_input">
							<select id="s_sex">
								<option value="男">男</option>
								<option value="女">女</option>
							</select>
						</div>
					</div>
					<div class="layer">
						<div class="mylabel">
							<label>邮箱:</label>
						</div>
						<div class="slide_input">
							<input type="text" id="S_email" name="mailbox" value="${user.emailaddress}"/><br/>
						</div>
					</div>
					<div class="layer">
						<div class="mylabel">
							<label>分数:</label>
						</div>
						<div class="slide_input">
							<input type="text" id="S_grade" name="grade" value="${user.score}"/><br/>
						</div>
					</div>
					<div class="layer">
						<div class="mylabel">
							<label>类型:</label>
						</div>
						<div class="slide_input">
							<select id="s_gradetype">
								<option>托福</option>
								<option>雅思</option>
							</select>
						</div>
					</div>
					<div class="layer">
						<div class="mylabel">
							<label>GPA:</label>
						</div>
						<div class="slide_input">
							<input type="text" id="S_gpa" name="gpa" value="${user.gpa}"/><br/>
						</div>
					</div>
					<div class="layer">
						<div class="mylabel">
							<label>GRE:</label>
						</div>
						<div class="slide_input">
							<input type="text" id="S_gre" name="gre" value="${user.grescore}"/><br/>
						</div>
					</div>
					<div class="savebutton">
						<button type="submit" tabindex="5" onclick="sendmessage()">保存</button>
					</div>
				</div>
		</div>
		<div class="collecttalk">
			<h3>收藏的帖子</h3>
			<div class="talk">
				<ul>
					<c:forEach items="${noteList}" var="Favourites">
					<li><a href="/bloglist/bljump/${Favourites.noteId}">${Favourites.noteTitle}</a><span>
						<td><fmt:formatDate value='${Favourites.pushDate}' pattern='yyyy-MM-dd HH:mm:ss'/></td>
					</span></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="collectschool">
			<div class="school">
				<h3>收藏的学校</h3>
				<div class="collegelogo">
					<ul>
						<c:forEach items="${schoolList}" var="Favourites">
						<li><a href="/school/${Favourites.schoolId}"><img src="/resources/schoolLogo/${Favourites.schoolLogo}" style="width:40px;height:40px;border:none;"></a><p style="padding:10px;">${Favourites.schoolName}</p></li>
						</c:forEach>

					</ul>
				</div>
			</div>
		</div>
		<div class="writecomment">
			<h3>写帖</h3>
			<%--<form action="/sendcomment" method="post">--%>
				<input id="notetitle" type="text" name="notetitle" value="标题写在这"/>
				<textarea id="note"  name="notemessage" clos="20" rows="5" >
					说点什么吧！
				</textarea>
			<div class="submitbutton">
				<button type="submit" tabindex="5" onclick="sendnote()">发布</button>
			</div>
			<%--<div class="cancelbutton">--%>
				<%--<button type="cancel" tabindex="5">取消</button>--%>
			<%--</div>--%>
			<%--</form>--%>
		</div>
	</div>
	</body>

</html>