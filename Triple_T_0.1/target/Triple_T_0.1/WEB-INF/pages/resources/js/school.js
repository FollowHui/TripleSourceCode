/**
 * Created by Administrator on 2015/4/7.
 */
function s_collect(){
    var flag = getCookie("flag");
    if( flag !="true"){
        alert("请先登录");
        location.reload(true);
    }
    else {
        var param = document.getElementById("s_collect").getAttribute("name");
        var paramid = parseInt(document.getElementById("s_titlename").getAttribute("name"));

        var xmlhttp;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        }
        else {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                //document.getElementById("div1").innerHTML=xmlhttp.responseText;
                //document.getElementById("s_collect").setAttribute("name")
            }
        };
        xmlhttp.open("GET", "/school/collect?param=" + param + "&schoolId=" + paramid, true);
        xmlhttp.send();

        setTimeout(function () {
            location.reload(true);
        }, 100);
    }
}