/**
 * Created by Administrator on 2015/4/4.
 */

function bl_addmoreclick(){
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
            //document.getElementById("si_addmore").innerHTML=xmlhttp.responseText;
        }
    };
    xmlhttp.open("GET","/bloglist/addmore",true);
    xmlhttp.send();
}

function bl_Jump(param){
    var xmlhttp;
    var reqname = param.getAttribute("name");
    alert(reqname);
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
            document.getElementById("div1").innerHTML=xmlhttp.responseText;
        }
    };
    xmlhttp.open("GET","/bloglist/"+reqname,true);
    xmlhttp.send();
}