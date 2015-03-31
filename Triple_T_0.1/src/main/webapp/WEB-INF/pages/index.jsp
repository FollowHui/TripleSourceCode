<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <tittle></tittle>

    <link rel="stylesheet" href="/resources/css/index.css">
    <link rel="stylesheet" href="/resources/css/login_register.css">
    <script class="autoinsert" src="/resources/js/jquery-1.2.6.min.js"></script>
    <script src="/resources/js/jquery-1.4.2.min.js"></script>

    <script type="text/javascript">
        function click1 () {
            document.getElementById("div1").style.display="block";
            document.getElementById("div2").style.display="none";
            document.getElementById("div3").style.display="none";
            document.getElementById("div4").style.display="none";
            document.getElementById("div5").style.display="none";
        }
        function click2 () {
            document.getElementById("div1").style.display="none";
            document.getElementById("div2").style.display="block";
            document.getElementById("div3").style.display="none";
            document.getElementById("div4").style.display="none";
            document.getElementById("div5").style.display="none";
        }
        function click3 () {
            document.getElementById("div1").style.display="none";
            document.getElementById("div2").style.display="none";
            document.getElementById("div3").style.display="block";
            document.getElementById("div4").style.display="none";
            document.getElementById("div5").style.display="none";
        }
        function click4 () {
            document.getElementById("div1").style.display="none";
            document.getElementById("div2").style.display="none";
            document.getElementById("div3").style.display="none";
            document.getElementById("div4").style.display="block";
            document.getElementById("div5").style.display="none";
        }
        function click5 () {
            document.getElementById("div1").style.display="none";
            document.getElementById("div2").style.display="none";
            document.getElementById("div3").style.display="none";
            document.getElementById("div4").style.display="none";
            document.getElementById("div5").style.display="block";
        }

        function onSearch(){
            var xmlhttp;
            if(window.XMLHttpRequest){
                xmlhttp = new XMLHttpRequest();
            }
            else {
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange = function(){
                if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
                    document.getElementById("").innerHTML = xmlhttp.responseText;
                }
            };
            xmlhttp.open("GET","",true);
            xmlhttp.send();
        }

        $(document).ready(function($){

            $('.theme-login').click(function(){
                $('.login-mask').show();
                $('.login-mask').height($(document).height());
                $('.login-box').slideDown(200);
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
    </script>
</head>

<body>
<div id="outer">
    <div id="header">
        <ul class="ful">
            <li class="fli"><a href="#" style="text-decoration:none"><span>收藏夹</span></a></li>
            <li class="fli"><a class="theme-register" href="javascript:;"style="text-decoration:none"><span>注册</span></a></li>
            <li class="fli"><a class="theme-login" href="javascript:;" style="text-decoration:none"><span>登录</span></a></li>
        </ul>
    </div>
    <div id="header-nav">
		<span style="float:left; margin-left:5%;">
			<img src="/resources/img/llogo.png">
		</span>
        <ul >
            <li class="nav-li" ><a href="#" onclick="click1()"><span>首页</span></a></li>
            <li class="nav-li" ><a href="#" onclick="click2()"><span>校内资讯</span></a></li>
            <li class="nav-li" ><a href="#" onclick="click3()"><span>名校推荐</span></a></li>
            <li class="nav-li" ><a href="#" onclick="click4()"><span>论坛</span></a></li>
            <li class="nav-li" ><a href="#" onclick="click5()"><span>搜索</span></a></li>
            <input  class="searchinput" value="Enter keyword..." name="q" size="10"  title="searchfield" onfocus="clearText(this)" onblur="clearText(this)" />
        </ul>
        <br clear="all"/>
    </div>
    <div id="div1"  >
        <%@include file="bg.jsp"%>
    </div>
    <div id="div2"  style="display: none">
        <%@include file="sInfoma.jsp"%>
    </div>
    <div id="div3"  style="display: none">
        <%@include file="sList.jsp"%>
    </div>
    <div id="div4"  style="display: none">
        <%@include file="blogList.jsp"%>
    </div>
    <div id="div5"  style="display: none">
        <%@include file="sList.jsp"%>
    </div>

    <div class="login-mask">
        <div class="login-box" style=" display:none;">
            <h1>Triple T</h1>
            <div class="close">
                <h1><a href="javascript:;" style="text-decoration:none">X</a></h1>
            </div>
            <form method="post" action="">
                <div class="name">
                    <label>用户名：</label>
                    <input type="text" name="" id="userNameLogin" tabindex="1" autocomplete="off" />
                </div>
                <div class="password">
                    <label>密  码：</label>
                    <input type="password" name="" maxlength="16" id="passwordLogin" tabindex="2"/>
                </div>
                <div class="code">
                    <label>验证码：</label>
                    <input type="text" name="" maxlength="4" id="code" tabindex="3"/>
                    <div class="codeImg">
                        <img src="/resources/img/captcha.jpeg.jpg" />
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
            <div class="name">
                <label>用户名:</label>
                <input type="text" name="" id="usernameRegister" tabindex="1" autocomplete="off" />
            </div>
            <div class="password">
                <label>密码：</label>
                <input type="password" name="" id="passwordRegister" maxlength="16" tabindex="2"/>
            </div>
            <div class="pqssword">
                <label>确认密码：</label>
                <input type="password" name="" id="identifyPassword" maxlength="16" tabindex="2"/>
            </div>
            <div class="mailbox">
                <label>邮箱:</label>
                <input type="text" name="" id="email" maxlength="16" />
            </div>
            <div class="sex">
                <label>性别：</label>
                <input type="text" name="" id="sex" maxlength="16" />
            </div>
            <div class="grades">
                <label>分数：</label>
                <input type="text" name="" id="score" maxlength="16" />
            </div>
            </br>
            <div class="register">
                <button type="submit" tabindex="5">注册</button>
            </div>
        </div>
    </div>
</div>
</body>

</html>