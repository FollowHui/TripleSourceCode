
function setImagePreview(avalue) {
    var docObj=document.getElementById("imgfile");

    var imgObjPreview=document.getElementById("preview");
    if(docObj.files &&docObj.files[0])
    {
        imgObjPreview.style.display = 'block';
        imgObjPreview.style.width = '150px';
        imgObjPreview.style.height = '180px';
        imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
    }
    else
    {

        docObj.select();
        var imgSrc = document.selection.createRange().text;
        var localImagId = document.getElementById("localImag");
        localImagId.style.width = "150px";
        localImagId.style.height = "180px";
        try{
            localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
        }
        catch(e)
        {
            alert("您上传的图片格式不正确，请重新选择!");
            return false;
        }
        imgObjPreview.style.display = 'none';
        document.selection.empty();
    }
    return true;

}

function sendmessage()
{
    var flag = getCookie("flag");
    if(flag!="true"){
        alert("您未登录");
        location.href="/";
    }else {
        //var username = document.getElementById("S_username").value;
        var sex = ((document.getElementById("s_sex").value) == "男" ? "male" : "female");
        var email = document.getElementById("S_email").value;
        var grade = parseFloat(document.getElementById("S_grade").value);
        var gradetype = ((document.getElementById("s_gradetype").value) == "托福" ? "tofel" : "itels");
        var gpa = parseFloat(document.getElementById("S_gpa").value);
        var gre = parseFloat(document.getElementById("S_gre").value);
        var gsch = document.getElementById("S_gschool").value;
        var gsub = document.getElementById("S_gsubject").value;
        var myphoto = document.getElementById("localImag").value;
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
            }
        };
        //xmlhttp.open("GET", "/selfinfo/change?sex=" + sex + "&email=" + email + "&grade=" + grade + "&gradetype=" + gradetype + "&gpa=" + gpa + "&gre=" + gre, true);
        xmlhttp.open("GET", "/selfinfo/change?sex=" + sex + "&email=" + email + "&grade=" + grade + "&gradetype=" + gradetype + "&gpa=" + gpa + "&gre=" + gre + "&gsch=" + gsch + "&gsub=" + gsub, true);
        xmlhttp.send();
        alert("亲，你的个人信息修改成功");
        document.getElementById("S_username").disabled = true;
        document.getElementById("S_email").disabled = true;
        document.getElementById("S_grade").disabled = true;
        document.getElementById("S_gpa").disabled = true;
        document.getElementById("S_gre").disabled = true;
        document.getElementById("S_gschool").disabled = true;
        document.getElementById("S_gsubject").disabled = true;
    }

}

function sendnote(){
    var flag = getCookie("flag");
    if(flag!="true"){
        alert("您未登录");
        location.href="/";
    }else {
        var notetitle = document.getElementById("notetitle").value;
        var notemessage = document.getElementById("note").value;
        var xmlhttp;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        }
        else {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("div1").innerHTML = xmlhttp.responseText;
            }
        };
        xmlhttp.open("POST", "/sendcomment?notemessage=" + notemessage + "&notetitle=" + notetitle, true);
        xmlhttp.send();
        alert("亲，你的帖子已发送成功");
        location.reload(true);
    }
}
function changeoption1(){
    document.getElementById("selfinfo2").style.display="block";
    document.getElementById("collecttalk").style.display="none";
    document.getElementById("collectschool").style.display="none";
    document.getElementById("mytalk").style.display="none";
    document.getElementById("writecomment").style.display="none";
    document.getElementById("bi").style.color="#FFF";
    document.getElementById("ct").style.color="";
    document.getElementById("cs").style.color="";
    document.getElementById("mt").style.color="";
    document.getElementById("wt").style.color="";
}
function changeoption2(){
    document.getElementById("selfinfo2").style.display="none";
    document.getElementById("collecttalk").style.display="block";
    document.getElementById("collectschool").style.display="none";
    document.getElementById("writecomment").style.display="none";
    document.getElementById("mytalk").style.display="none";
    document.getElementById("bi").style.color="";
    document.getElementById("ct").style.color="#FFF";
    document.getElementById("cs").style.color="";
    document.getElementById("mt").style.color="";
    document.getElementById("wt").style.color="";
}
function changeoption3(){
    document.getElementById("selfinfo2").style.display="none";
    document.getElementById("collecttalk").style.display="none";
    document.getElementById("collectschool").style.display="block";
    document.getElementById("mytalk").style.display="none";
    document.getElementById("writecomment").style.display="none";
    document.getElementById("bi").style.color="";
    document.getElementById("ct").style.color="";
    document.getElementById("cs").style.color="#FFF";
    document.getElementById("mt").style.color="";
    document.getElementById("wt").style.color="";
}
function changeoption4(){
    document.getElementById("selfinfo2").style.display="none";
    document.getElementById("collecttalk").style.display="none";
    document.getElementById("collectschool").style.display="none";
    document.getElementById("mytalk").style.display="block";
    document.getElementById("writecomment").style.display="none";
    document.getElementById("bi").style.color="";
    document.getElementById("ct").style.color="";
    document.getElementById("cs").style.color="";
    document.getElementById("mt").style.color="#FFF";
    document.getElementById("wt").style.color="";
}
function changeoption5(){
    document.getElementById("selfinfo2").style.display="none";
    document.getElementById("collecttalk").style.display="none";
    document.getElementById("collectschool").style.display="none";
    document.getElementById("mytalk").style.display="none";
    document.getElementById("writecomment").style.display="block";
    document.getElementById("bi").style.color="";
    document.getElementById("ct").style.color="";
    document.getElementById("cs").style.color="";
    document.getElementById("mt").style.color="";
    document.getElementById("wt").style.color="#FFF";
}

function modify(){
    document.getElementById("S_username").disabled=false;
    document.getElementById("S_email").disabled=false;
    document.getElementById("S_grade").disabled=false;
    document.getElementById("S_gpa").disabled=false;
    document.getElementById("S_gre").disabled=false;
    document.getElementById("S_gschool").disabled=false;
    document.getElementById("S_gsubject").disabled=false;
}
