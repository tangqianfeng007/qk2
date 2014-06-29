function isPlaceholder() {
    var input = document.createElement('input');
    return 'placeholder' in input;
}

/**
 *  不支持placeholder 用jquery来完成
 */
if (!isPlaceholder()) {
    $(document).ready(function () {
        if (!isPlaceholder()) {
            //把input绑定事件 排除password框
            $("input").not("input[type='password']").each(
                function () {
                    if ($(this).val() == "" && $(this).attr("placeholder") != "") {
                        $(this).val($(this).attr("placeholder"));
                        $(this).focus(function () {
                            if ($(this).val() == $(this).attr("placeholder")) $(this).val("");
                        });
                        $(this).blur(function () {
                            if ($(this).val() == "") $(this).val($(this).attr("placeholder"));
                        });
                    }
                });
        }
    });
}