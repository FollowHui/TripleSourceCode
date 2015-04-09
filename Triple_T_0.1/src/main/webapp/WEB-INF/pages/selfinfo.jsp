<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/resources/css/selfinfo.css">
	</head>
	<body>
	<div class="slide">
		<div class="selfinfo1">
			<h3>个人信息</h3>
			<div id="localImag"><img id="preview" style="width:150px;height:180px;" src="../img/avatar.png"></div>
			<div class="upload">
				<a href="javascript:;" class="a-upload"><input type="file" name="imgfile" id="imgfile" style="width:150px;" onchange="javascript:setImagePreview();"><span>上传图片</span></a>
			</div>
				<div class="selfinfo2">
					<div class="layer">
						<div class="mylabel">
							<label>用户名:</label>
						</div>
						<div class="slide_input">
							<input type="text" id="S_username" name="username"/>
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
							<input type="text" id="S_email" name="mailbox"/><br/>
						</div>
					</div>
					<div class="layer">
						<div class="mylabel">
							<label>分数:</label>
						</div>
						<div class="slide_input">
							<input type="text" id="S_grade" name="grade"/><br/>
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
							<input type="text" id="S_gpa" name="gpa"/><br/>
						</div>
					</div>
					<div class="layer">
						<div class="mylabel">
							<label>GRE:</label>
						</div>
						<div class="slide_input">
							<input type="text" id="S_gre" name="gre"/><br/>
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
					<li><a href="#">Js弹出基于Table的可关闭浮动层</a><span>2009-6-21</span></li>
					<li><a href="#">Js弹出基于Table的可关闭浮动层</a><span>2009-6-21</span></li>
					<li><a href="#">Js弹出基于Table的可关闭浮动层</a><span>2009-6-21</span></li>
					<li><a href="#">Js弹出基于Table的可关闭浮动层</a><span>2009-6-21</span></li>
					<li><a href="#">Js弹出基于Table的可关闭浮动层</a><span>2009-6-21</span></li>
					<li><a href="#">Js弹出基于Table的可关闭浮动层</a><span>2009-6-21</span></li>
				</ul>
			</div>
		</div>
		<div class="collectschool">
			<div class="school">
				<h3>收藏的学校</h3>
				<div class="collegelogo">
					<ul>
						<li><a href="#"><img src="../img/seu.png" style="width:40px;height:40x;border:none;"></a><p style="padding:10px;">东南大学 2009-6-21</p></li>
						<li><a href="#"><img src="../img/seu.png" style="width:40px;height:40x;border:none;"></a><p style="padding:10px;">东南大学 2009-6-21</p></li>
						<li><a href="#"><img src="../img/seu.png" style="width:40px;height:40x;border:none;"></a><p style="padding:10px;">东南大学 2009-6-21</p></li>
						<li><a href="#"><img src="../img/seu.png" style="width:40px;height:40x;border:none;"></a><p style="padding:10px;">东南大学 2009-6-21</p></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="writecomment">
			<h3>写帖</h3>
			<div id="note"contenteditable="true">
				<p>说点什么吧！</p>
			</div>
			<div class="submitbutton">
				<button type="submit" tabindex="5">发布</button>
			</div>
			<div class="cancelbutton">
				<button type="cancel" tabindex="5">取消</button>
			</div>

		</div>


	</div>
	</body>

</html>