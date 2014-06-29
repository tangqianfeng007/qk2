$(document).ready(function () {
    $.formValidator.initConfig({theme:"126", formID:"regform1", validatorgroup:"1",
        onSuccess:function () {
            var jsonInfro = $("#regform1").serializeObject();
            jQuery.ajax({
                type:'POST',
                url:'/ajax/reg.action',
                processData:true,
                async:true,
                data:jsonInfro,
                dataType:'html',
                success:function (data) {
                    data = jQuery.parseJSON(data);
                    if (data.status == '1') {
                        alert("注册成功");
                        var email = $("#userEmail").val();
                        var es = email.split("@");
                        var ename = es[0].substr(0, 3);
                        var dealEmail = ename + "******@" + es[1];
                        window.location.href = "/checkEmail.jsp?email=" + dealEmail;
                    } else if (data.status == '-1') {
                        alert("用户名重复！");
                    } else {
                        alert("注册失败，稍后再试！");
                    }
                },
                error:function () {
                    alert("服务器繁忙中！稍后再试！");
                }
            });
            return false;
        },
        onError:function (msg) {
            alert(msg);
        },
        submitAfterAjaxPrompt:'有数据正在异步验证，请稍等...'
    });

    $("#userName").formValidator({theme:"126", validatorgroup:"1", onShowFixText:"用户名长度为4-20个字符。", onShowText:" ", onShow:"请输入用户名,只有输入\"maodong\"才是对的", onCorrect:"该用户名可以注册"}).inputValidator({min:4, max:20, onError:"你输入的用户长度不正确,请确认"})
        .ajaxValidator({
            type:"post",
            dataType:"html",
            processData:true,
            async:true,
            url:"/ajax/checkUsername.action",
            success:function (data) {
                var jsonD = jQuery.parseJSON(data);
                if (jsonD.status <= 0) {
                    return false;
                } else {
                    return true;
                }
            },
            buttons:$("#button"),

            onError:"该用户名已经使用，请更换用户名",
            onWait:"正在进行合法性校验，请稍候..."
        });
    $("#userPsd").formValidator({validatorgroup:"1", onShowFixText:"请输入密码", onShow:"请输入密码", onFocus:"至少6个长度", onCorrect:"密码合法"}).inputValidator({min:6, max:16, empty:{leftEmpty:false, rightEmpty:false, emptyError:"密码两边不能有空符号"}, onError:"密码长度错误,请确认"}).passwordValidator({compareID:"userName"});
    $("#reuserPsd").formValidator({validatorgroup:"1", onShowFixText:"请再次输入密码", onShow:"输再次输入密码", onFocus:"至少1个长度", onCorrect:" "}).inputValidator({min:1, empty:{leftEmpty:false, rightEmpty:false, emptyError:"重复密码两边不能有空符号"}, onError:"重复密码不能为空,请确认"}).compareValidator({desID:"userPsd", operateor:"=", onError:"2次密码不一致,请确认"});
    $("#userEmail").formValidator({validatorgroup:"1", onShowFixText:"输入一个正确的邮箱地址", onShow:"请输入邮箱", onFocus:"邮箱6-100个字符,输入正确了才能离开焦点", onCorrect:" ", defaultValue:""}).inputValidator({min:6, max:100, onError:"你输入的邮箱长度非法,请确认"}).regexValidator({regExp:"^([\\w-.]+)@(([[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.)|(([\\w-]+.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(]?)$", onError:"你输入的邮箱格式不正确"});

    $("#userRealName").formValidator({validatorgroup:"1", onShowFixText:"长度为1-20个字符。"}).inputValidator({min:1, max:20, onError:"真实姓名的长度不正确,请确认"});
    $("#userCity").formValidator({validatorgroup:"1", onShowFixText:"长度为1-20个字符。"}).inputValidator({min:1, max:20, onError:"地址长度不正确,请确认"});
    $("#userPostalcode").formValidator({validatorgroup:"1", onShowFixText:"长度为6个字符。"}).inputValidator({min:6, max:6, onError:"邮编长度不正确,请确认"}).regexValidator({regExp:"^[0-9]*$", onError:"邮编只能是数字"});
});



