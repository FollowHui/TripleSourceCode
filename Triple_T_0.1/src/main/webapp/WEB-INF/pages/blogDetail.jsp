<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>

		<link rel="stylesheet" href="/resources/css/blogDetail.css">
	</head>

	<body>
	<div id="container">
		<div id="wrap">
			<div id="sd_detail">
				<div class="sd_title">
					<div class="sd_title_t">${note.title}</div>
					<div class="sd_click"> 收藏</div>
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
					<div class="sd_click"> 添加评论 </div>
				</div>
				<div id="sd_list">
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
	</body>
</html>
