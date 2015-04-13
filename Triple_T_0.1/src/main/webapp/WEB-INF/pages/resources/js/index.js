/**
 * Created by Administrator on 2015/4/4.
 */

function index_Jump(param){
    var xmlhttp;
    var reqname = param.getAttribute("name");
    //var username = param.getAttribute("")
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
        document.getElementById("div6").style.display="none";
        document.getElementById("div1").style.display="block";
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById("div6").style.display="none";
            document.getElementById("div1").style.display="block";
            document.getElementById("div1").innerHTML=xmlhttp.responseText;
        }
    };
    if(reqname == "index")
        xmlhttp.open("GET","/index",true);
    else if(reqname == "sInfoma")
        xmlhttp.open("GET","/sInfoma",true);
    else if(reqname == "sList")
        xmlhttp.open("GET","/sList",true);
    else if(reqname == "blogList")
        xmlhttp.open("GET","/blogList",true);

    xmlhttp.send();
}

function onselfinfoclick(){
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
            //document.body.innerHTML = xmlhttp.responseText;
            //window.open("/selfinfo", "_blank");
        }
    };

    xmlhttp.open("GET","/selfinfo",false);
    xmlhttp.send();

    //if( xmlhttp.response ){
    //    window.open("/selfinfo", "_blank");
    //}
}