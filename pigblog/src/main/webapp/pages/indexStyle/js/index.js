var screenWidth=$(window).width();

$("#body").css("width",screenWidth);
$(window).on('resize', function() {
    // 设置Iframe窗口大小
    configIframe();
}).resize();
function configIframe(){
    var $content = $('.layui-body');
    $content.height($(this).height() - 75);
    $content.width($(this).width() - 250);
    $content.find('iframe').each(function() {
        $(this).height($content.height());
        $(this).width($content.width());
    });
    var $screenWidth = $("body").width();
    var $mainHeader = $(".layui-header");
    $mainHeader.width($screenWidth - $(".layui-side ").width());

}