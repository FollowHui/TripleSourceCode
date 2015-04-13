/**
 * Created by Administrator on 2015/4/10.
 */
//function logclick(){
//    var username = document.getElementById("L_username");
//    var password = document.getElementById("L_password");
//    var code = document.getElementById("code");
//    var xmlhttp;
//    if (window.XMLHttpRequest)
//    {// code for IE7+, Firefox, Chrome, Opera, Safari
//        xmlhttp=new XMLHttpRequest();
//    }
//    else
//    {// code for IE6, IE5
//        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
//    }
//    xmlhttp.onreadystatechange=function()
//    {
//        if (xmlhttp.readyState==4 && xmlhttp.status==200)
//        {
//            //document.getElementById("div1").innerHTML=xmlhttp.responseText;
//            var response = xmlhttp.responseText;
//            if(response = "登录成功"){
//            }else{alert(response);}
//        }
//    };
//    xmlhttp.open("POST","/login?"+"userName="+username+"&password="+password+"&code="+code,true);
//    xmlhttp.send();
//}

function onlogin() {

    //$('#formloginsubmit').submit(function () {
            var AjaxURL = "/login?";
            //var username = document.getElementById("L_username");
            //var password = document.getElementById("L_password");
            //var code = document.getElementById("code");
            //alert($('#formloginsubmit').serialize());
            $.ajax({
                type: "POST",
                dataType: "html",
                url: AjaxURL+$('#formloginsubmit').serialize(),
                data:"",
                success: function (result) {
                    $('#resText').empty();
                    var strresult = result;
                    alert(strresult);
                    location.reload(true);
                    return false;
                },
                error: function (result2) {
                    alert("error:" + result2.responseText);
                }

            });
        //}
    //);
}
