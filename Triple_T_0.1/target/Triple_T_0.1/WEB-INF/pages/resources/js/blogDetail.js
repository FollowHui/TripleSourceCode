/**
 * Created by Administrator on 2015/4/7.
 */

function sdcollect(){
    var flag = getCookie("flag");
    if( flag !="true"){
        alert("请先登录");
        location.reload(true);
    }
    else {
        var param = document.getElementById("sd_collect").getAttribute("name");
        var paramid = parseInt(document.getElementById("sd_title_t").getAttribute("name"));
        var xmlhttp;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        }
        else {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                //document.getElementById("si_addmore").innerHTML=xmlhttp.responseText;
            }
        };
        xmlhttp.open("GET", "/blogdetail/collect?param=" + param + "&noteId=" + paramid, true);
        xmlhttp.send();
        setTimeout(function () {
            location.reload(true);
            ;
        }, 100);
    }
}

function bd_addcomment() {
    var flag = getCookie("flag");
    if( flag !="true"){
        alert("请先登录");
        location.reload(true);
    }else {
        var param = document.getElementById("comment_input").value;
        var paramid = parseInt(document.getElementById("sd_title_t").getAttribute("name"));
        if (!isNaN(param)) {
            alert("输入为空诶~");
        } else {
            var xmlhttp;
            if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp = new XMLHttpRequest();
            }
            else {// code for IE6, IE5
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    //document.getElementById("si_addmore").innerHTML=xmlhttp.responseText;
                }
            };
            xmlhttp.open("GET", "/blogdetail/comment?param=" + param + "&noteId=" + paramid, true);
            xmlhttp.send();

            alert("评论成功啦~");
            document.getElementById("comment_input").value = "";
            setTimeout(function () {
                location.reload(true);
                ;
            }, 100);
        }
    }
}