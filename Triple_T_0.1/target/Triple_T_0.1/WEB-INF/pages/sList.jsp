<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="utf-8">
	<title></title>

	<link rel="stylesheet" href="/resources/css/sList.css">
</head>

<body>
<div id="wrap">
	<div class="sl_title">
		<div id="sl_title_left"><h1>搜索结果</h1></div>

		<div id="sl_title_right">
			<ul id="pageTabs">
				<li class="hasSub">
					<div style="display: block"><a>地区偏好</a></div>
					<ul>
						<li><a>1</a></li>
						<li><a>2</a></li>
						<li><a>3</a></li>
						<li><a>4</a></li>
						<li><a>5</a></li>
					</ul>
				</li>
				<li class>
					<a>排名偏好</a>
				</li>
			</ul>
		</div>
	</div>

	<%--<div id="container_sList">--%>
	<%--<div id="search_filter">--%>
		<%--<div class="filter" name="addrfilter">--%>
			<%--<div class="f_left">地区偏好</div>--%>
			<%--<div class="f_right">--%>
				<%--<div class="f_right_f" name="11" onclick="addrclick(this)">美国</div>--%>
				<%--<div class="f_right_f" name="12" onclick="addrclick(this)">新澳</div>--%>
				<%--<div class="f_right_f" name="13" onclick="addrclick(this)">加拿大</div>--%>
				<%--<div class="f_right_f" name="14" onclick="addrclick(this)">英国</div>--%>
				<%--<div class="f_right_f" name="15" onclick="addrclick(this)">亚欧</div>--%>
			<%--</div>--%>
		<%--</div>--%>

		<%--<div class="filter" name="rankfilter">--%>
			<%--<div class="f_left"><p>排名偏好</p></div>--%>
			<%--<div class="f_right">--%>
				<%--<div class="f_right_f" name="21" onclick="addrclick(this)">1-50</div>--%>
				<%--<div class="f_right_f" name="22" onclick="addrclick(this)">51-100</div>--%>
				<%--<div class="f_right_f" name="23" onclick="addrclick(this)">101-150</div>--%>
				<%--<div class="f_right_f" name="24" onclick="addrclick(this)">151-200</div>--%>
				<%--<div class="f_right_f" name="25" onclick="addrclick(this)">200+</div>--%>
			<%--</div>--%>
		<%--</div>--%>

	<%--</div>--%>
<%--</div>--%>

	<div id="search_result">
	<%@include file="searchRs.jsp"%>
</div>
</div>
</body>

</html>