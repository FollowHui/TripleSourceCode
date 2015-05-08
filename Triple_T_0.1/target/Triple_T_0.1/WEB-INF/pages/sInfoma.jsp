<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="utf-8">
	<title></title>
	<link rel="stylesheet" href="/resources/css/sInfoma.css">
	<script src="/resources/js/sInfoma.js"></script>
</head>

<body>
<div id="container">
	<div class="wrap">
		<div class="si_title"><p>校内资讯</p></div>
		<div id="si_table">
			<ul>
				<c:if test="${schoolNewsList.size()==0}">
					<div class="si_con_title"><p>请在个人信息中选择您的学校&nbsp您的信息越完善&nbsp推荐越合理</p></div>
				</c:if>
				<c:forEach items="${schoolNewsList}" var="SchoolNews" begin="0" end="${sessionScope.sInfoCount}">
				<li class="si_table_title">
					<div class="si_container" ><a href="${SchoolNews.url}" target="_blank">
						<div class="si_con_title"><p>${SchoolNews.newscontent}</p></div>
						<div class="si_con_time"><p>${SchoolNews.newsdate}</p></div></a>
					</div>
				</li>
				</c:forEach>

			</ul>

			<div id="si_addmore" onclick="si_addmoreclick()"></div>
		</div>
	</div>
</div>
</body>
</html>
