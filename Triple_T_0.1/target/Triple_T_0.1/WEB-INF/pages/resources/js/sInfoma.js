/**
 * Created by Administrator on 2015/4/4.
 */
/**
 * Created by Freyja on 2015/3/31.
 */

function si_addmoreclick(){
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
            document.getElementById("si_addmore").innerHTML=xmlhttp.responseText;
        }
    };
    xmlhttp.open("GET","/sinfoma/addmore",true);
    xmlhttp.send();
}

