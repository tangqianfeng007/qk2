/*顶部菜单选中，参数从 1 计数*/
function selectBar(num) {
    var list = $(".module li a");
    for (var i = 0; i < list.size(); i++) {
        $(list[i]).attr("class", "");
    }
    $(list[num - 1]).attr("class", "selected");
}
//num 左边的第几个框， index 框下的第几行（两个参数都从1计数）
function selectLeft(num, index) {
    var list = $(".leftBar li");
    for (var i = 0; i < list.size(); i++) {
        $(list[i]).attr("class", "");
    }
    var obj = $(".leftBar:eq(" + (num - 1) + ") li:eq(" + (index - 1) + ")");
    obj.attr("class", "selectedLeft");
}

//$(document).ready(function(){
//    //上方的选择
//    var list1 = $(".module li a");
//    for (var i = 0; i < list1.size(); i++) {
//        $(list1[i]).click(function(){
//            mySelect1($(this));
//        });
//    }
//    function mySelect1(obj){
//        var list = $(".module li a");
//        for (var i = 0; i < list.size(); i++) {
//            $(list[i]).attr("class", "");
//        }
//        $(obj).attr("class", "selected");
//    }
//
//    //作坊的选择
//    var list = $(".leftBar li");
//    for (var i = 0; i < list.size(); i++) {
//        $(list[i]).click(function(){
//            mySelect($(this));
//        });
//    }
//
//    function mySelect(obj){
//        var list = $(".leftBar li");
//        for (var i = 0; i < list.size(); i++) {
//            $(list[i]).attr("class", "");
//        }
//        $(obj).attr("class", "selectedLeft");
//    }
//
//});


(function ($) {
    $.fn.ellipsis = function (enableUpdating) {
        var s = document.documentElement.style;
        if (!('textOverflow' in s || 'OTextOverflow' in s)) {
            return this.each(function () {
                var el = $(this);
                if (el.css("overflow") == "hidden") {
                    var originalText = el.html();
                    var w = el.width();

                    var t = $(this.cloneNode(true)).hide().css({
                        'position':'absolute',
                        'width':'auto',
                        'overflow':'visible',
                        'max-width':'inherit'
                    });
                    el.after(t);

                    var text = originalText;
                    while (text.length > 0 && t.width() > el.width()) {
                        text = text.substr(0, text.length - 1);
                        t.html(text + "...");
                    }
                    el.html(t.html());

                    t.remove();

                    if (enableUpdating == true) {
                        var oldW = el.width();
                        setInterval(function () {
                            if (el.width() != oldW) {
                                oldW = el.width();
                                el.html(originalText);
                                el.ellipsis();
                            }
                        }, 200);
                    }
                }
            });
        } else return this;
    };
})(jQuery);