/**
 * Created by freyja on 2015/4/5.
 */

function xmlHttp(param){
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
            document.getElementById("search_result").innerHTML=xmlhttp.responseText;
        }
    };
    xmlhttp.open("GET","/slist/filter1?param="+param,true);
    xmlhttp.send();
}

function getAddressChoose(param){
    var addressName =document.getElementById(param.id).innerText;
    document.getElementById("addressPrefer").innerText = addressName;
    switch (addressName){
        case "美国"   : xmlHttp(11); break;
        case "新澳"   : xmlHttp(12); break;
        case "加拿大" : xmlHttp(13); break;
        case "英国"   : xmlHttp(14); break;
        case "亚欧"   : xmlHttp(15); break;
        default      : xmlHttp(10);
    }

}
function getRankChoose(param){
    var rankName =document.getElementById(param.id).innerText;
    document.getElementById("rankPrefer").innerText = rankName;
    switch (rankName){
        case "1-50"   : xmlHttp(21); break;
        case "51-100" : xmlHttp(22); break;
        case "101-150": xmlHttp(23); break;
        case "151-200": xmlHttp(24); break;
        case "200+"   : xmlHttp(25); break;
        default       : xmlHttp(20);
    }
}

function sr_addmoreclick(){
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
            document.getElementById("search_result").innerHTML=xmlhttp.responseText;
        }
    };
    xmlhttp.open("GET","/slist/addmore",true);
    xmlhttp.send();
}