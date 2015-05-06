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
<%--<div id="wrap">--%>
  <%--<div id="sr_title">搜索结果</div>--%>
  <div id="sr_content">
    <%--<ul>--%>
      <%--<c:forEach items="${schoolList}" var="SchoolInformation">--%>
        <%--<li>--%>
          <%--<div class="sr_content_detail">--%>
            <%--<div class="sr_img_container"><div class="sr_img"><a href="/school/${SchoolInformation.schoolid}" target="_blank"><img src="/resources/schoolLogo/${SchoolInformation.schoollogo}" /></a></div></div>--%>
            <%--<div class="sr_name_container"><div class="sr_name"><p>${SchoolInformation.schoolname}</p></div></div>--%>
          <%--</div>--%>
        <%--</li>--%>
      <%--</c:forEach>--%>
    <%--</ul>--%>

    <div class="showCollege">
      <ul id="collegeTabs">
        <c:forEach items="${schoolList}" var="SchoolInformation" begin="0" end="${sessionScope.schoolCount}">
          <li class="college">
            <div class="collegeLogo">
              <a href="/school/${SchoolInformation.schoolid}" target="_blank"><img src="/resources/schoolLogo/${SchoolInformation.continent}/${SchoolInformation.schoollogo}"  style="height:150px;"></a>
            </div>
            <div class="collegeDescribe">
              <p>学校名称:${SchoolInformation.schoolname}</p>
              <p>排名:${SchoolInformation.ranking}</p>
              <p>国家：
                <c:if test="${SchoolInformation.continent==1}">
                  <c:out value="美国"></c:out>
                </c:if>
                <c:if test="${SchoolInformation.continent==2}">
                  <c:out value="澳洲"></c:out>
                </c:if>
                <c:if test="${SchoolInformation.continent==3}">
                  <c:out value="加拿大"></c:out>
                </c:if>
                <c:if test="${SchoolInformation.continent==4}">
                  <c:out value="英国"></c:out>
                </c:if>
                <c:if test="${SchoolInformation.continent==5}">
                  <c:out value="亚洲"></c:out>
                </c:if>
              </p>
            </div>
            <div class="successCases">
              <h3>该大学申请案例:</h3>
              <p>郭政吉 东南大学软件工程 均分90</p>
              <p>郭政吉 东南大学通信工程 均分90</p>
              <p>郭政吉 东南大学经济学管理 均分90</p>
            </div>
          </li>
        </c:forEach>

      </ul>
    </div>

    <div id="si_addmore" onclick="sr_addmoreclick()"></div>

  </div>

<%--</div>--%>
</body>
</html>
