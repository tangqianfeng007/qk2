/*tooltip*/
$(function () {
    $('[rel=tooltip]').hover(function () {
            $('<div class="tooltip" style="display:none; top:' + ($(this).offset().top + $(this).height() + 5) + 'px;left:' + $(this).offset().left + 'px;">' + $(this).attr('title') + '<div class="arrow"></div></div>').appendTo('body').fadeIn();
        },
        function () {
            $('.tooltip').fadeOut().remove();
        });


    $('.topbar .collapse').click(function () {
        $('.topbar .module, .topbar .sub').toggle();
    });
});


$(function () {
    $('.taber .head a').hover(function () {
        $('.taber .body').hide();
        $('.taber #' + $(this).attr('lang')).show();

        $('.taber .head a').removeClass('selected');
        $(this).addClass('selected');
    });
});

$(function () {
    $('.topbar .module li').hover(function () {
            $(this).addClass('selected');
        },
        function () {
            $(this).removeClass('selected');
        });
})

$(function () {
    $('a[rel=popup]').click(function () {

        $('body').prepend('<div id="mask"></div>').find('#mask').css({opacity:0.5, cursor:'pointer', background:'black', position:'absolute', zIndex:999, width:'100%', height:$(document).height()});

        $('body').append('<div class="popup"><del>x</del><div class="head">����-��Դ����css���</div><div class="body">������һ����Դ���� (X)HTML/CSS ��� ,���Ŀ���Ǽ������css����ʱ�䡣���ṩһ���ɿ���css��ȥ���������Ŀ,�ܹ�������վ�Ŀ������,ͨ��������ؽ��������׼��������ÿ����վ�� ֹ����Ŀ�����������Բ��ԡ�����Խ�������һ��ģ�壬������˴����վ��������Ҫ����Щcss�ࡣ���С��ֻ���ĸ��ļ����ѡ��ܹ�����6KB��</div><div class="foot"><a href="#" class="button blue">�ر�</a></div></div>').find('.popup').fadeIn();
    });

    $('#mask, .popup del').live('click', function () {
        $('#mask, .popup').remove();
    });
});

$(function () {
    setTimeout(function () {
        $('.cartoon').fadeIn();
    }, 1000);
});

$(function () {
    $('.spring del').click(function () {
        $('.spring').slideUp();
    });
});