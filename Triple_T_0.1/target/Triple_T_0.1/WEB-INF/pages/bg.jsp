<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<tittle></tittle>
	<link rel="stylesheet" href="/resources/css/bg.css">
</head>
<script src="/resources/js/snowfall.jquery.js"></script>
<script>
	$(document).snowfall('clear');
	$(document).snowfall({
		image: "/resources/img/fur.png",
		flakeCount:5,
		minSize: 10,
		maxSize: 80
	});
</script>


<body>
<div id="home-page">
	<div id="logo">
		<img src="/resources/img/logo.png">

		<%--<p class="logo-p">更方便 更智能 更及时<strong>/</strong>welcome to our world</p>--%>
	</div>
	<p class="logo-h1">东大留学咨询网</p>
	<p class="logo-p">更方便 更智能 更及时</p>
</div>
</body>

</html>