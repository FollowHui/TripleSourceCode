
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
    //var username = document.getElementById("S_username").value;
    var sex = ((document.getElementById("s_sex").value) == "男" ? "male" : "female");
    var email = document.getElementById("S_email").value;
    var grade = parseFloat(document.getElementById("S_grade").value);
    var gradetype = ((document.getElementById("s_gradetype").value) == "托福" ? "tofel" : "itels");
    var gpa = parseFloat(document.getElementById("S_gpa").value);
    var gre = parseFloat(document.getElementById("S_gre").value);

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
    xmlhttp.open("GET","/selfinfo/change?sex="+sex+"&email="+email+"&grade="+grade+"&gradetype="+gradetype+"&gpa="+gpa+"&gre="+gre,true);
    xmlhttp.send();
}