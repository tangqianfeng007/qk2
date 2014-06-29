/**
 * 限制数字输入
 * @param obj
 */
function clearNoNum(obj) {
    obj.value = obj.value.replace(/[^\d.]/g, "");  //清除“数字”和“.”以外的字符
    obj.value = obj.value.replace(/^\./g, "");  //验证第一个字符是数字而不是.
    obj.value = obj.value.replace(/\.{2,}/g, "."); //只保留第一个. 清除多余的.
    obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
}
/**
 * 限制数字输入  排除小数点
 * @param obj
 */
function clearNoNumAndPoint(obj) {
    obj.value = obj.value.replace(/[^\d]/g, "");  //清除“数字”和“.”以外的字符
    obj.value = obj.value.replace(/^\./g, "");  //验证第一个字符是数字而不是.
    obj.value = obj.value.replace(/\.{2,}/g, "."); //只保留第一个. 清除多余的.
    obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
}

/**
 * 日期判断
 * @param time1
 * @param time2
 */
function checkEndTime(time1, time2) {
    var start = new Date(time1.replace("-", "/").replace("-", "/"));
    var end = new Date(time2.replace("-", "/").replace("-", "/"));
    if (end < start) {
        return false;
    }
    return true;
}

/**
 * 日期格式化
 * //使用方法
 var now = new Date();
 var nowStr = now.format("yyyy-MM-dd hh:mm:ss");
 //使用方法2:
 var testDate = new Date();
 var testStr = testDate.format("YYYY年MM月dd日hh小时mm分ss秒");
 alert(testStr);
 //示例：
 alert(new Date().Format("yyyy年MM月dd日"));
 alert(new Date().Format("MM/dd/yyyy"));
 alert(new Date().Format("yyyyMMdd"));
 alert(new Date().Format("yyyy-MM-dd hh:mm:ss"));
 * @param format
 */
Date.prototype.format = function (format) {
    var o = {
        "M+":this.getMonth() + 1, //month
        "d+":this.getDate(), //day
        "h+":this.getHours(), //hour
        "m+":this.getMinutes(), //minute
        "s+":this.getSeconds(), //second
        "q+":Math.floor((this.getMonth() + 3) / 3), //quarter
        "S":this.getMilliseconds() //millisecond
    }

    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }

    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
}

function bj(fid) {
    var max_fs = document.getElementById("sg_" + fid).innerHTML;
    var m = parseInt(max_fs, 10);
    var n = parseInt($("#fen_" + fid).val(), 10);
    if (n > m) {
        $("#fen_" + fid).val(m);
    }
}

/**
 * 份数加
 * @param fid
 */
function jia(fid) {
    var r = 1;
    var n = parseInt($("#fen_" + fid).val(), 10);
    n = n + r;

    var m = parseInt($("#sg_" + fid).html(), 10);
    if (m < n) {
        $("#fen_" + fid).val(m);
    }
    else {
        $("#fen_" + fid).val(n);
    }
}
/**
 * 份数减
 * @param fid
 */
function jian(fid) {
    var r = 1;
    var n = parseInt($("#fen_" + fid).val(), 10);
    n = n - r;
    if (n > 0)
        $("#fen_" + fid).val(n);
}
function mailfind() {
    var ck = document.getElementById("emailf").checked;
    if (ck == true) {
        $("#tel1,#tel2").hide();
        $("#mail1,#mail2").show();
    }
}
function telfind() {
    var ck = document.getElementById("telf").checked;
    if (ck == true) {
        $("#mail1,#mail2").hide();
        $("#tel1,#tel2").show();
    }

}

function isIdCardNo(num) {
    var factorArr = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1);
    var error;
    var varArray = new Array();
    var intValue;
    var lngProduct = 0;
    var intCheckDigit;
    var intStrLen = num.length;
    var idNumber = num;
// initialize
    if ((intStrLen != 15) && (intStrLen != 18)) {
        error = "输入身份证号码长度不对！";
        // alert(error);
//frmAddUser.txtIDCard.focus();
        return false;
    }
// check and set value
    for (i = 0; i < intStrLen; i++) {
        varArray[i] = idNumber.charAt(i);
        if ((varArray[i] < '0' || varArray[i] > '9') && (i != 17)) {
            error = "错误的身份证号码！.";
            //  alert(error);
//frmAddUser.txtIDCard.focus();
            return false;
        } else if (i < 17) {
            varArray[i] = varArray[i] * factorArr[i];
        }
    }
    if (intStrLen == 18) {
//check date
        var date8 = idNumber.substring(6, 14);
        if (checkDate(date8) == false) {
            error = "身份证中日期信息不正确！.";
            //  alert(error);
            return false;
        }
// calculate the sum of the products
        for (i = 0; i < 17; i++) {
            lngProduct = lngProduct + varArray[i];
        }
// calculate the check digit
        intCheckDigit = 12 - lngProduct % 11;
        switch (intCheckDigit) {
            case 10:
                intCheckDigit = 'X';
                break;
            case 11:
                intCheckDigit = 0;
                break;
            case 12:
                intCheckDigit = 1;
                break;
        }
// check last digit
        if (varArray[17].toUpperCase() != intCheckDigit) {
            error = "身份证效验位错误!...正确为： " + intCheckDigit + ".";
            //alert(error);
            return false;
        }
    }
    else { //length is 15
//check date
        var date6 = idNumber.substring(6, 12);
        if (checkDate(date6) == false) {
            //  alert("身份证日期信息有误！.");
            return false;
        }
    }
//alert ("Correct.");
    return true;
}

function checkDate(date) {
    return true;
}

//验证姓名
function isName(str) {
// [\u4E00-\uFA29]|[\uE7C7-\uE7F3]汉字编码范围
    var re1 = new RegExp("^([\u4E00-\uFA29]|[\uE7C7-\uE7F3])*$");
    if (!re1.test(str)) {
        return false;
    }
    return true;
}

//验证手机号码
function isPhone(phone) {
    if (phone.search(/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/) != -1) {
        return true;
    }
    else {
        return false;
    }
}

function isEmail(obj) {
    var rel = new RegExp("^([\\w-.]+)@(([[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.)|(([\\w-]+.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(]?)$");
    if (rel.test(obj)) {
        return true;
    } else {
        return false;
    }
}

function isQQ(qq) {

    if (qq.search(/^[1-9]\d{4,12}$/) != -1) {
        return true;
    }
    else {
        return false;
    }
}

function checkPsw(password) {
    if (password.length > 6) {
        return true;
    }
    else {
        return false;
    }
}

function setCookie(name, value, cTime)//三个个参数，一个是cookie的名子，一个是值，一个是时间（天）
{
    var exp = new Date();    //new Date("December 31, 9998");
    exp.setTime(exp.getTime() + cTime * 24 * 60 * 60 * 1000);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
}
function getCookie(name)//取cookies函数
{
    var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
    if (arr != null) return (arr[2]);
    return null;
}
function delCookie(name)//删除cookie
{
    var exp = new Date();
    exp.setTime(exp.getTime() - 100);
    var cval = getCookie(name);
    if (cval != null) document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}