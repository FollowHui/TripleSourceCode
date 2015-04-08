<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="utf-8">
	<title></title>

	<link rel="stylesheet" href="/resources/css/sList.css">
</head>

<body>
<div id="container_sList">
	<div id="search_filter">
		<div class="filter" name="addrfilter">
			<div class="f_left">地区偏好</div>
			<div class="f_right">
				<div class="f_right_f" name="11" onclick="addrclick(this)">亚洲</div>
				<div class="f_right_f" name="12" onclick="addrclick(this)">欧洲</div>
				<div class="f_right_f" name="13" onclick="addrclick(this)">北美洲</div>
				<div class="f_right_f" name="14" onclick="addrclick(this)">澳大利亚</div>
				<div class="f_right_f" name="15" onclick="addrclick(this)">南美</div>
				<div class="f_right_f" name="16" onclick="addrclick(this)">非洲</div>
			</div>
		</div>

		<div class="filter" name="rankfilter">
			<div class="f_left"><p>排名偏好</p></div>
			<div class="f_right">
				<div class="f_right_f" name="21" onclick="addrclick(this)">1-100</div>
				<div class="f_right_f" name="22" onclick="addrclick(this)">101-300</div>
				<div class="f_right_f" name="23" onclick="addrclick(this)">301-600</div>
				<div class="f_right_f" name="24" onclick="addrclick(this)">601-1000</div>
				<div class="f_right_f" name="25" onclick="addrclick(this)">1001-2000</div>
				<div class="f_right_f" name="26" onclick="addrclick(this)">2001+</div>
			</div>

		</div>

		<div class="filter" name="tuitionfilter">
			<div class="f_left"><p>学费区间</p></div>
			<div class="f_right">
				<p>￥:</p><input id="low" type="input" onblur="tuitionfinish()"/>
				<p>-</p><input id="high" type="input" onblur="tuitionfinish()"/>
			</div>

		</div>
	</div>

	<div id="search_result">
		<div id="wrap">
			<div id="sr_title">搜索结果</div>
			<div id="sr_content">
				<ul>
					<li>
						<div class="sr_content_detail">
							<div class="sr_img_container"><div class="sr_img"><a href="/school/1" target="_blank"><img src="/resources/img/MIT.png" /></a></div></div>
							<div class="sr_name_container"><div class="sr_name"><p>TMITMITEEEE</p></div></div>
						</div>
					</li>

					<li>
						<div class="sr_content_detail">
							<div class="sr_img_container"><div class="sr_img"><img src="/resources/img/MIT.png" /></div></div>
							<div class="sr_name_container"><div class="sr_name">MIT</div></div>
						</div>
					</li>

					<li>
						<div class="sr_content_detail">
							<div class="sr_img_container"><div class="sr_img"><img src="/resources/img/MIT.png" /></div></div>
							<div class="sr_name_container"><div class="sr_name">MIT</div></div>
						</div>
					</li>

					<li>
						<div class="sr_content_detail">
							<div class="sr_img_container"><div class="sr_img"><img src="/resources/img/MIT.png" /></div></div>
							<div class="sr_name_container"><div class="sr_name">MIT</div></div>
						</div>
					</li>

					<li>
						<div class="sr_content_detail">
							<div class="sr_img_container"><div class="sr_img"><img src="/resources/img/MIT.png" /></div></div>
							<div class="sr_name_container"><div class="sr_name">MIT</div></div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
</body>

</html>