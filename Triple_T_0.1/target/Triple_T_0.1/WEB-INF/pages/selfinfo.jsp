<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/resources/css/selfinfo.css">
		<script src="/resources/js/selfinfo.js"></script>
	</head>
	<body>
	<div id="main-page">
		<div id="slideshow">
			<div id="slidesContainer">
				<div class="slide">
					<div class="selfinfo1">
						<h3>个人信息</h3>
						<div id="localImag"><img id="preview" style="width:150px;height:180px;" src="/resources/img/avatar.png"></div>
						<div class="upload">
							<a href="javascript:;" class="a-upload"><input type="file" name="imgfile" id="imgfile" style="width:150px;" onchange="javascript:setImagePreview();"><span>上传图片</span></a>
						</div>
					</div>
					<form action="/selfinfo" method="post">
						<div class="selfinfo2">
							<div class="layer">
								<div class="mylabel">
									<label>用户名:</label>
								</div>
								<div class="slide_input">
									<input type="text" name="username"/><br/>
								</div>
							</div>
							<div class="layer">
								<div class="mylabel">
									<label>性别:</label>
								</div>
								<div class="slide_input">
									<select>
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
									<input type="text" name="mailbox"/><br/>
								</div>
							</div>
							<div class="layer">
								<div class="mylabel">
									<label>分数:</label>
								</div>
								<div class="slide_input">
									<input type="text" name="grade"/><br/>
								</div>
							</div>
							<div class="layer">
								<div class="mylabel">
									<label>类型:</label>
								</div>
								<div class="slide_input">
									<select>
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
									<input type="text" name="gpa"/><br/>
								</div>
							</div>
							<div class="layer">
								<div class="mylabel">
									<label>GRE:</label>
								</div>
								<div class="slide_input">
									<input type="text" name="gre"/><br/>
								</div>
							</div>
							<div class="savebutton">
								<input style="height:30px;"type="button" name="submit" value="保存" onclick="#">
								<%--<button style="height:30px;" type="submit" name="save" tabindex="5">保存</button>--%>
							</div>
						</div>
						<div class="slide">
							<h3>收藏的学校</h3>
							<div class="collegelogo">
							</div>
							<div class="collegelogo">
							</div>
							<div class="collegelogo">
							</div>
						</div>
					</form>
				</div>
				<div class="slide">
					<h3>收藏的帖子</h3>
					<div class="talk">
						<ul>
							<li><a href="#">Js弹出基于Table的可关闭浮动层</a><span>2009-6-21</span></li>
							<li><a href="#">Js弹出基于Table的可关闭浮动层</a><span>2009-6-21</span></li>
							<li><a href="#">Js弹出基于Table的可关闭浮动层</a><span>2009-6-21</span></li>
							<li><a href="#">Js弹出基于Table的可关闭浮动层</a><span>2009-6-21</span></li>
							<li><a href="#">Js弹出基于Table的可关闭浮动层</a><span>2009-6-21</span></li>
							<li><a href="#">Js弹出基于Table的可关闭浮动层</a><span>2009-6-21</span></li>

						</ul>
					</div>
				</div>
				<div class="slide">
					<h3>写帖</h3>
					<div id="note"contenteditable="true">
						<p>说点什么吧！</p>
					</div>
					<div id="submitbutton">
						<input style="height:30px;"type="button" name="submit" value="发布" onclick="#">
							<%--<button style="height:35px;" type="submit" name="publish" tabindex="5">发布</button>--%>
					</div>
					<div id="cancelbutton">
						<input style="height:30px;"type="button" name="submit" value="取消" onclick="#">
						<%--<button style="height:35px;" type="submit" name="cancel" tabindex="5">取消</button>--%>
					</div>

				</div>
			</div>
		</div>
	</div>
	</body>
</html>