<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="../css/head.css">
	</head>

<style type="text/css">
*{padding:0px;margin:0px;}
#main-page{
	clear: both;
  	width: 900px;
    height: 200px;
    padding: 50px 40px 70px 40px;
    margin-bottom: 40px;
    margin-left: 11%;
    margin-top: 10%;
    background: url(../img/mainpage.png) top center no-repeat;
}
#slideshow {
	margin:0 auto;
	width: 900px;
	height:250px;
	position:relative;
}
#slideshow #slidesContainer {
  margin:0 auto;
  width: 750px;
  height: 250px;
  overflow:hidden;
  position:relative;
}
#slideshow #slidesContainer .slide {
  width: 750px;
  height: 250px;
  margin:0 auto;  
  font-size: 10px;
  font-family: 微软雅黑;
}
.slide_input
{
	padding: 5px 0 0 35%;
	display: block;
}
.slide img {
	float:left;
	margin-right: 40px;
	border:1px solid #4f4b42;
}
.slide input{
	font-family: weiruanyahei;
	height: 23px;
	width: 120px;
	padding: 2px;
	margin: 0px;
	color: #fad40d;
	font-size: 12px;
	font-variant: normal;
	line-height: normal;
	background: none;
	border: 1px dashed #aeada4;	
}
.slide select{
	width:120px;
	cursor:hand;
	border:1px solid #aeada4;
	background-color:transparent;
}
.control {
  display:block;
  width: 30px;
  height: 200px;
  text-indent:-10000px;
  position:absolute;
  cursor: pointer;
}
#note
{
	width: 650px;
	height: 200px;
	overflow: auto;
	background:none;
	margin-left: 25px;
	border: 1px dashed #aeada4;	

}
#note p
{
	margin:0px; 
	padding:0px; 
	font-size:14px;
	color:#C6C6C6;
    letter-spacing:2px; 
	font-weight:bold;
}
#leftControl {
  top: 85px;
  left:0;
  background:transparent url(../img/slider_left_control.png) no-repeat 0 0;
}
#rightControl {
  top: 85px;
  right:0;
  background: transparent url(../img/slider_right_control.png) no-repeat 0 0;
}
.collegelogo
{
	float: left;
	width: 30px;
	height: 30px;
	padding: 50px 0 0 40px;
	background-color: transparent;
	border-color: transparent;

}
#submitbutton
{
	float: left;
	padding: 2px 5px 0 10px;
	position: relative;
	margin-bottom: 2px;
	margin-left: 15%;
}
#cancelbutton
{
	float: left;
	padding: 2px 0 0 200px;
	position: relative;

}
</style>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script language="javascript" type="text/javascript">
$(document).ready(function(){
  var currentPosition = 0;
  var slideWidth = 750;
  var slides = $('.slide');
  var numberOfSlides = slides.length;

  // Remove scrollbar in JS
  $('#slidesContainer').css('overflow', 'hidden');

  // Wrap all .slides with #slideInner div
  slides
    .wrapAll('<div id="slideInner"></div>')
    // Float left to display horizontally, readjust .slides width
	.css({
      'float' : 'left',
      'width' : slideWidth
    });

  // Set #slideInner width equal to total width of all slides
  $('#slideInner').css('width', slideWidth * numberOfSlides);

  // Insert controls in the DOM
  $('#slideshow')
    .prepend('<span class="control" id="leftControl">Clicking moves left</span>')
    .append('<span class="control" id="rightControl">Clicking moves right</span>');

  // Hide left arrow control on first load
  manageControls(currentPosition);

  // Create event listeners for .controls clicks
  $('.control')
    .bind('click', function(){
    // Determine new position
	currentPosition = ($(this).attr('id')=='rightControl') ? currentPosition+1 : currentPosition-1;
    
	// Hide / show controls
    manageControls(currentPosition);
    // Move slideInner using margin-left
    $('#slideInner').animate({
      'marginLeft' : slideWidth*(-currentPosition)
    });
  });

  // manageControls: Hides and Shows controls depending on currentPosition
  function manageControls(position){
    // Hide left arrow if position is first slide
	if(position==0){ $('#leftControl').hide() } else{ $('#leftControl').show() }
	// Hide right arrow if position is last slide
    if(position==numberOfSlides-1){ $('#rightControl').hide() } else{ $('#rightControl').show() }
  }	
});
$(document).bind('click',function(e){
    var e = e || window.event; //浏览器兼容性
    var elem = e.target || e.srcElement;
       while (elem) { //循环判断至跟节点，防止点击的是div子元素
             if (elem.id && elem.id=='ss') {
                        return;
                    }
                    elem = elem.parentNode;
                }

             $('#ss2').fadeOut("fast");
	
});
</script>
	<body id="body">
		<iframe name="head" src="bg.jsp" width=100% height="93px" frameborder="0" scrolling="no"></iframe>
		<div id="main-page">
			<div id="slideshow">
          		<div id="slidesContainer">
           			 <div class="slide">
           			 <h3>个人信息</h3><br/>
           			 <div class="slide_input">
           			 用户名：<input type="text" name="username"/><br/>
           			 </div>
           			  <div class="slide_input">
           			 性别：男<input type="radio" checked="checked" name="sex" value="male"/>
           			 		女<input type="radio" checked="checked" name="sex" value="female"/>
           			 		<br/>
           			 </div>
           			 <div class="slide_input">
           			 邮箱:<input type="text" name="mailbox"/><br/>
           			 </div>
           			  <div class="slide_input">
           			 分数：<input type="text" name="grade"/><br/>
           			 </div>
           			  <div class="slide_input">
           			 类型:<select>
           			 		<option>托福</option>
           			 		<option>雅思</option>
           			 	  </select>
           			 	  <br/>
           			 </div>
           			  <div class="slide_input">
           			 GPA:<input type="text" name="gpa"/><br/>
           			 </div>
           			  <div class="slide_input">
           			 GRE:<input type="text" name="gre"/><br/>
           			 </div>
              		</div>
           			 <div class="slide"> 
           			 <h3>收藏的学校</h3>
           			 <div class="collegelogo">
           			 </div>
           			 <div class="collegelogo">
           			 </div>
           			 <div class="collegelogo">
           			 </div>
           		    </div>
            		<div class="slide">
            		<h3>收藏的帖子</h3>

              		</div>
            		<div class="slide"> 
            			<h3>写帖</h3>
            			<div id="note"contenteditable="true">
            				<p>说点什么吧！</p>
            			</div>
            			<div id="submitbutton">
            				<input type="button" name="submit" value="发布" onclick="#">
            			</div>
            			<div id="cancelbutton">
            				<input type="button"  name="cancel" value="取消" onclick="#">
            			</div>
            			
              		</div>
          		</div>
        	</div> 
        </div>
	</body>
</html>