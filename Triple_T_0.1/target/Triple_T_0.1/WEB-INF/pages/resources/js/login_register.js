/**
 * Created by Administrator on 2015/4/10.
 */
function onlogin(){
    var username = document.getElementById("L_username").value;
    var password = document.getElementById("L_password").value;
    var code = document.getElementById("code").value;
    var xmlhttp;
    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }
    else
    {// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            //document.getElementById("div1").innerHTML=xmlhttp.responseText;
            var response = xmlhttp.responseText;
            if(response =="登录成功"){
                addCookie("flag","true",0);
                //alert(getCookie("flag"));
                location.reload(true);
            }else{alert(response);}
        }
    };
    xmlhttp.open("POST","/login?"+"userName="+username+"&password="+password+"&verifyCode="+code,true);
    xmlhttp.send();

}

function loginout(){
    var flag = getCookie("flag");
    if ( flag == "true"){
        window.open("/selfinfo");
    }
    else{
        alert("您已登出");
        location.reload(true);
    }

}
