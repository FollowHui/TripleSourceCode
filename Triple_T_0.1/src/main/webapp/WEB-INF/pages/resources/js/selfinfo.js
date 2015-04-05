$(document).ready(function(){
    var currentPosition = 0;
    var slideWidth = 750;
    var slides = $('.slide');
    var numberOfSlides = slides.length;

    // Remove scrollbar in JS
    $('#slidesContainer').css('overflow', 'hidden');

    // Wrap all .slides with #slideInner div
    slides
        .wrapAll('<div id="slideInner"></div>')
        // Float left to display horizontally, readjust .slides width
        .css({
            'float' : 'left',
            'width' : slideWidth
        });

    // Set #slideInner width equal to total width of all slides
    $('#slideInner').css('width', slideWidth * numberOfSlides);

    // Insert controls in the DOM
    $('#slideshow')
        .prepend('<span class="control" id="leftControl">Clicking moves left</span>')
        .append('<span class="control" id="rightControl">Clicking moves right</span>');

    // Hide left arrow control on first load
    manageControls(currentPosition);

    // Create event listeners for .controls clicks
    $('.control')
        .bind('click', function(){
            // Determine new position
            currentPosition = ($(this).attr('id')=='rightControl') ? currentPosition+1 : currentPosition-1;

            // Hide / show controls
            manageControls(currentPosition);
            // Move slideInner using margin-left
            $('#slideInner').animate({
                'marginLeft' : slideWidth*(-currentPosition)
            });
        });

    // manageControls: Hides and Shows controls depending on currentPosition
    function manageControls(position){
        // Hide left arrow if position is first slide
        if(position==0){ $('#leftControl').hide() } else{ $('#leftControl').show() }
        // Hide right arrow if position is last slide
        if(position==numberOfSlides-1){ $('#rightControl').hide() } else{ $('#rightControl').show() }
    }
});
$(document).bind('click',function(e){
    var e = e || window.event; //浏览器兼容性
    var elem = e.target || e.srcElement;
    while (elem) { //循环判断至跟节点，防止点击的是div子元素
        if (elem.id && elem.id=='ss') {
            return;
        }
        elem = elem.parentNode;
    }

    $('#ss2').fadeOut("fast");

});
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