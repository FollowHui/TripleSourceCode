<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/resources/css/selfinfo.css">
		<link rel="stylesheet" href="/resources/css/base.css">
		<link rel="stylesheet" type="text/css" href="/resources/css/reset.css">
		<link rel="stylesheet" type="text/css" href="/resources/css/clearfix.css">
		<link rel="stylesheet" type="text/css" href="/resources/css/jquery.fancybox-1.3.1.css" media="screen">
		<link rel="stylesheet" type="text/css" href="/resources/css/dark.css">
		<script src="/resources/js/selfinfo.js"></script>
		<script src="/resources/js/index.js"></script>

		<script type="text/javascript">
			$(document).ready(function($){
				$('.exit').click(function(){
					location.href = "/logout";
				})
			});

		</script>
	</head>
	<body  class="jsDisabled">
		<div id="header" class="clearfix">

					<div class="holder clearfix">

					<div class="skipLink"><a href="#content" title="Skip to content">Skip to content</a></div>

					<div id="title"><span><a href="index.html" title="click me can logon" rel="home">Triple T</a></span></div>
					<ul id="siteNav">
						<li class="selected"><a name="index" onclick="index_Jump(this)">首页</a></li>
						<li><a name="sInfoma" onclick="index_Jump(this)">校内资讯</a></li>
						<li><a name="sList" onclick="index_Jump(this)">名校推荐</a></li>
						<li><a name="blogList" onclick="index_Jump(this)">论坛</a></li>

						<li><a class="exit" href="javascript:;" style="text-decoration:none"><span>退出</span></a></li>
					</ul>

				</div>

			</div><!-- #header -->
		<div class="wrap">
	<div id="header-nav">
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
			</div>
	</body>

</html>