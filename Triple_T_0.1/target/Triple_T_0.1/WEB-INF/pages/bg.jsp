<%--
  Created by IntelliJ IDEA.
  User: badguy
  Date: 2015/4/25
  Time: 0:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="/resources/css/jquery.slideBox.css" rel="stylesheet" type="text/css" />
  <script src="/resources/js/jquery-1.7.1.min.js" type="text/javascript"></script>
  <script src="/resources/js/jquery.slideBox.js" type="text/javascript"></script>
  <link href="/resources/css/base.css" rel="stylesheet" type="text/css" />
  <script>
    jQuery(function($){

      $('#demo3').slideBox({
        duration : 0.3,//滚动持续时间，单位：秒
        easing : 'linear',//swing,linear//滚动特效
        delay : 2,//滚动延迟时间，单位：秒
        hideClickBar : false,//不自动隐藏点选按键
        clickBarRadius : 10
      });

    });
  </script>
</head>
<body>
  <p class="intro">掌握最新留学咨询，为您私人订制适合您的学校，实现您的出国留学梦！</p>

  <div id="demo3" class="slideBox">
    <ul class="items">
      <li><a href="#" title="人才辈出"><img src="/resources/img/temp/slider_1.jpg"></a></li>
      <li><a href="#" title="六朝松下"><img src="/resources/img/temp/slider_2.jpg"></a></li>
      <li><a href="#" title="杨子银涛"><img src="/resources/img/temp/slider_3.jpg"></a></li>

    </ul>
  </div>
  <div class="footInfo">
  <h2><span>关于我们</span></h2>

  <div class="columns">

    <div class="col">

      <h3>What we do</h3>

      <p>为有出国留学或深造的同学提供一个比较真实的、实时的在线咨询和查询平台。通过大数据和数据挖掘为同学们量身打造适合他们的理想大学，提供最正确的建议和指导。</p>

    </div>

    <div class="col">

      <h3>About us</h3>

      <p>Triple T是三个单词的简写：talented,technical,tenet分别代表我们团队是有天赋，有技术，有原则的一群人。 </p>

    </div>

    <div class="col">

      <h3>Our work</h3>

      <p>帮助有留学意向的同学做出正确的分析和判断，提供给他们最新的留学信息和资讯，给他们以最大的信心和鼓励</p>

    </div>

    <div class="col">

      <h3>Stay in touch</h3>

      <ul class="socialLinks">
        <li><p>地址:南京东南大学路2号</p></li>
        <li><p>邮箱:15150698580@163.com</p></li>
      </ul>

    </div>

  </div><!-- .columns -->

  </div>

</body>
</html>
