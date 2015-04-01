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
					<ul>
						<li>亚洲</li>
						<li>欧洲</li>
						<li>北美洲</li>
						<li>澳大利亚</li>
						<li>南美</li>
						<li>非洲</li>
					</ul>
				</div>
			</div>

			<div class="filter" name="rankfilter">
				<div class="f_left"><p>排名偏好</p></div>
				<div class="f_right">
					<ul>
						<li>1-100</li>
						<li>101-300</li>
						<li>301-600</li>
						<li>601-1000</li>
						<li>1001-2000</li>
						<li>2001+</li>
					</ul>
				</div>
				
			</div>

			<div class="filter" name="tuitionfilter">
				<div class="f_left"><p>学费区间</p></div>
				<div class="f_right">
					<p>￥:</p><input name="low" type="input" />
					<p>-</p><input name="high" type="input" />
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
								<div class="sr_img_container"><div class="sr_img"><img src="/resources/img/MIT.png" /></div></div>
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