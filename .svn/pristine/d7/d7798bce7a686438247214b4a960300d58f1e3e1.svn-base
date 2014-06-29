$(document).ready(function () {
    $.formValidator.initConfig({theme:"126", formID:"regform1", validatorgroup:"1",
        onSuccess:function () {
            $("#regform1").submit();
        },
        onError:function (msg) {
            alert(msg);
        },
        submitAfterAjaxPrompt:'有数据正在异步验证，请稍等...'
    });

    $("#userRealName").formValidator({validatorgroup:"1", onShowFixText:"长度为1-20个字符。"}).inputValidator({min:1, max:20, onError:"真实姓名的长度不正确,请确认"});
    $("#userCity").formValidator({validatorgroup:"1", onShowFixText:"长度为1-20个字符。"}).inputValidator({min:1, max:20, onError:"地址长度不正确,请确认"});
    $("#userPostalcode").formValidator({validatorgroup:"1", onShowFixText:"长度为6个字符。"}).inputValidator({min:6, max:6, onError:"邮编长度不正确,请确认"}).regexValidator({regExp:"^[0-9]*$", onError:"邮编只能是数字"});
});



