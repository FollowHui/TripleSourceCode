<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="utf-8">
	<title></title>

	<link rel="stylesheet" href="/resources/css/sList.css">
	<link rel="stylesheet" href="/resources/css/base.css">
</head>

<body>
<div id="wrap">
	<div class="sl_title">
		<div id="sl_title_left"><p>搜索结果</p></div>

		<div id="sl_title_right">
			<ul id="pageTabs">
				<li style="list-style-type: none;" class="hasSub">
					<div style="display: block"><a id="addressPrefer">地区偏好</a></div>
					<ul>
						<li style="list-style-type: none;" class="theSub"><a id="Usa" onclick="getAddressChoose(this)">美国</a></li>
						<li style="list-style-type: none;" class="theSub"><a id="Aus" onclick="getAddressChoose(this)">新澳</a></li>
						<li style="list-style-type: none;" class="theSub"><a id="Can" onclick="getAddressChoose(this)">加拿大</a></li>
						<li style="list-style-type: none;" class="theSub"><a id="Uk" onclick="getAddressChoose(this)">英国</a></li>
						<li style="list-style-type: none;" class="theSub"><a id="Asia" onclick="getAddressChoose(this)">亚欧</a></li>
						<li style="list-style-type: none;" class="theSub"><a id="Addrall" onclick="getAddressChoose(this)">全部地区</a></li>
					</ul>
				</li>
				<li style="list-style-type: none;" class="hasSub">
					<a id="rankPrefer">排名偏好</a>
					<ul>
						<li class="theSub"><a id="first50" onclick="getRankChoose(this)">1-50</a></li>
						<li class="theSub"><a id="first100" onclick="getRankChoose(this)">51-100</a></li>
						<li class="theSub"><a id="first150" onclick="getRankChoose(this)">101-150</a></li>
						<li class="theSub"><a id="first200" onclick="getRankChoose(this)">151-200</a></li>
						<li class="theSub"><a id="after200" onclick="getRankChoose(this)">200+</a></li>
						<li class="theSub"><a id="rankall" onclick="getRankChoose(this)">全部排名</a></li>
					</ul>
				</li>
			</ul>

		</div>
	</div>

	<div id="search_result">
		<%@include file="searchRs.jsp"%>
	</div>
</div>
</body>

</html>