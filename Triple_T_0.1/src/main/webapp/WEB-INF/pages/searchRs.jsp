<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/4/9
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
  <link rel="stylesheet" href="/resources/css/sList.css">
</head>
<body>
<div id="wrap">
  <%--<div id="sr_title">搜索结果</div>--%>
  <div id="sr_content">
    <ul>
      <c:forEach items="${schoolList}" var="SchoolInformation">
        <li>
          <div class="sr_content_detail">
            <div class="sr_img_container"><div class="sr_img"><a href="/school/${SchoolInformation.schoolid}" target="_blank"><img src="/resources/schoolLogo/${SchoolInformation.schoollogo}" /></a></div></div>
            <div class="sr_name_container"><div class="sr_name"><p>${SchoolInformation.schoolname}</p></div></div>
          </div>
        </li>
      </c:forEach>
      <%--<li>--%>
        <%--<div class="sr_content_detail">--%>
          <%--<div class="sr_img_container"><div class="sr_img"><img src="/resources/img/MIT.png" /></div></div>--%>
          <%--<div class="sr_name_container"><div class="sr_name">MIT</div></div>--%>
        <%--</div>--%>
      <%--</li>--%>
      <%--<li>--%>
        <%--<div class="sr_content_detail">--%>
          <%--<div class="sr_img_container"><div class="sr_img"><img src="/resources/img/MIT.png" /></div></div>--%>
          <%--<div class="sr_name_container"><div class="sr_name">MIT</div></div>--%>
        <%--</div>--%>
      <%--</li>--%>

      <%--<li>--%>
        <%--<div class="sr_content_detail">--%>
          <%--<div class="sr_img_container"><div class="sr_img"><img src="/resources/img/MIT.png" /></div></div>--%>
          <%--<div class="sr_name_container"><div class="sr_name">MIT</div></div>--%>
        <%--</div>--%>
      <%--</li>--%>

      <%--<li>--%>
        <%--<div class="sr_content_detail">--%>
          <%--<div class="sr_img_container"><div class="sr_img"><img src="/resources/img/MIT.png" /></div></div>--%>
          <%--<div class="sr_name_container"><div class="sr_name">MIT</div></div>--%>
        <%--</div>--%>
      <%--</li>--%>

      <%--<li>--%>
        <%--<div class="sr_content_detail">--%>
          <%--<div class="sr_img_container"><div class="sr_img"><img src="/resources/img/MIT.png" /></div></div>--%>
          <%--<div class="sr_name_container"><div class="sr_name">MIT</div></div>--%>
        <%--</div>--%>
      <%--</li>--%>
    </ul>
  </div>
</div>
</div>
</body>
</html>
