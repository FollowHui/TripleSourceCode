/**
 * Created by freyja on 2015/4/5.
 */
var addrs = [0,0,0,0,0,0];
var ranks = [0,0,0,0,0,0];

function addrclick(param){
    //var data = parseInt(param.getAttribute("name"));
    var data = param.getAttribute("name");
    var fil;
    if ( data < 20 && data > 10 ){
        fil = data % 10 - 1;
        if( addrs[fil] == 0){
            param.className = "f_right_f1";
            addrs[fil] = 1;
            xmlHttp(data, "true");
        } else {
            param.className = "f_right_f";
            addrs[fil] = 0;
            xmlHttp(data, "false");
        }
    } else if( data < 30 && data > 20){
        fil = data % 20 - 1;
        if( ranks[fil] == 0){
            param.className = "f_right_f1";
            ranks[fil] = 1;
            xmlHttp(data, "true");
        } else {
            param.className = "f_right_f";
            ranks[fil] = 0;
            xmlHttp(data, "false");
        }
    }
}

function xmlHttp(param, sel){
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
    xmlhttp.open("GET","/slist/filter1?param="+param + "&sel="+sel,true);
    xmlhttp.send();
}

function tuitionfinish(){
    var lowtui = parseInt(document.getElementById("low").value);
    var hightui = parseInt(document.getElementById("high").value);

    if ( !isNaN(lowtui) && !isNaN(hightui)) {
        if (lowtui < 0 || hightui > 100000 || lowtui >= hightui) {
            alert("输入的学费区间不合法");
        } else {
            var xmlhttp;
            if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp = new XMLHttpRequest();
            } else {// code for IE6, IE5
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    //document.getElementById("si_addmore").innerHTML=xmlhttp.responseText;
                }
            };
            xmlhttp.open("GET", "/slist/filter2?low=" + lowtui + "&high=" + hightui, true);
            xmlhttp.send();
        }
    }
}