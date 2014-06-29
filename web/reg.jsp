<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-CN" xmlns=http://www.w3.org/1999/xhtml>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="chrome=1"/>
    <title>注册</title>
    <link rel="Shortcut Icon" href="/images/favicon.ico">
    <link rel="stylesheet" href="/css/cutter.css">

    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/css/user.css" rel="stylesheet" type="text/css"/>
    <script src="/js/jquery.js" type="text/javascript"></script>
    <script src="/js/formValidator-4.1.1.js" type="text/javascript"></script>
    <script src="/js/formValidatorRegex.js" type="text/javascript"></script>
    <script src="/js/common.js" type="text/javascript"></script>
    <script src="/js/formcheck.js" type="text/javascript"></script>
    <script src="/js/json.min.js" type="text/javascript"></script>
    <script src="/js/jquery.json-2.2.min.js" type="text/javascript"></script>
    <script src="/js/autoemail.js" type="text/javascript" async="true"></script>

    <script src="/js/cutter.js" async="true"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#userEmail').autoMail({
                emails:['qq.com', '163.com', '126.com', 'sina.com', 'vip.sina.com', 'sohu.com', 'gmail.com', '139.cn', '21cn.com']
            });
        });
    </script>
    <style>
        table, tr, td {
            border: none;
        }

        table tr {
            height: 40px;
        }

        .noticeWrap {
            padding: 0px;
            float: none;
        }

        .noticeWrap span {
            float: none;
            line-height: normal;
        }

        .user_client p {
            margin-bottom: 0px;
            width: 100%;
            float: none;
        }

        .g-ipt {
            background-color: #FBFBFB;
            border: 1px solid #C1C1C1;
            color: #444444;
            font-family: Verdana, arial, sans-serif;
            font-size: 14px;
            ime-mode: disabled;
            line-height: normal;
            margin: 0;
            padding: 4px;
            text-align: left;
            vertical-align: middle;
        }

        .g-ipt-err {
            background-color: #FBE2E2;
            border: 1px solid #D28C8C;
            color: #A63B3B;
            font-family: Verdana, arial, sans-serif;
            font-size: 14px;
            line-height: normal;
            margin: 0;
            padding: 4px;
            text-align: left;
            vertical-align: middle;
        }

        #introduce {
            background-color: #FBFBFB;
            border: 1px solid #C1C1C1;
            color: #444444;
            font-family: Verdana, arial, sans-serif;
            font-size: 14px;
            ime-mode: disabled;
            line-height: normal;
            margin: 0;
            padding: 4px;
            text-align: left;
            vertical-align: middle;
        }

    </style>
    <script type="text/javascript">
        function changeFrom(num, obj) {
            var f1 = $("#regform1");
            var but1 = $("#but1");
            var but2 = $("#but2");

            but1.attr({class:"uc_submit btn_white"});
            but2.attr({class:"uc_submit btn_white"});

            $(obj).attr({class:"uc_submit btn_gray"});

            if (num == 1) {
                $("#realNameLable").html("真实姓名");
                $("#typeLable").html("专业领域");
                $("#role_id").val("3");
                var str = "<option value='技术专家'>技术专家</option><option value='网页设计'>网页设计</option><option value='舞蹈教师'>舞蹈教师</option><option value='电脑专家'>电脑专家</option>";
                $("#type").html(str);
            }
            else if (num == 2) {
                $("#realNameLable").html("企业名称");
                $("#typeLable").html("企业领域");
                $("#role_id").val("2");
                var str = "<option value='服装行业'>服装行业</option><option value='建筑行业'>建筑行业</option><option value='广告行业'>广告行业</option>";
                $("#type").html(str);
            }
        }
    </script>
</head>
<body id="reg">

<div class="topbar">
    <div class="wrapper">
        <div class="logo">
            <a href="/index.action">QuickKnowledge</a>
        </div>
        <div class="module">
            <ul>
                <li>
                    <strong><a href="/index">首页</a></strong>
                </li>
                <li>
                    <strong><a href="/news/getNewsList.action?pageNumber=1">新闻</a></strong>
                </li>
                <li>
                    <strong><a href="/events/getEventsList.action?pageNumber=1">活动</a></strong>
                </li>
                <li>
                    <strong><a href="/pubs/getPubsList.action?pageNumber=1">出版物</a></strong>
                </li>
                <li>
                    <strong><a href="/experts/getExpertsList.action?pageNumber=1">专家</a></strong>
                </li>
                <li>
                    <strong><a href="/comments/getCommentsList.action?pageNumber=1">站点评论</a></strong>
                </li>
            </ul>

        </div>
    </div>
</div>
<script type="text/javascript">
    function seekExperts() {
        var nameIndex = $("#nameIndex").val();
        var jsonData = {nameIndex:nameIndex};
        var htmlobj = $.ajax({
            url:"/experts/expertsSeek.action",
            data:jsonData,
            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
            processData:true,
            cache:false,
            async:false
        });
        $("#centerArea").html(htmlobj.responseText);
    }
</script>
</div>
<div class="w100">
    <div class="w1000">
        <div class="reg_pic" style="margin-top: 40px;"></div>
        <div class="user_client">
            <div class="user_client_left">
                <p>
                    <input type="button" value="专家" id="but1" class="uc_submit btn_gray" onclick="changeFrom(1,this);">
                    <input type="button" value="企业" id="but2" class="uc_submit btn_white" onclick="changeFrom(2,this)">
                </p>

                <form id="regform1" style="" method="post" action="#" onsubmit="return false;">
                    <table class="tab1">

                        <tr>
                            <td align="right">* 用户名</td>
                            <td id="nameTD1">
                                <input type="text" id="userName" name="username" style="width:140px"/>
                                <input type="hidden" name="role_id" id="role_id" value="3"/>
                            </td>
                            <td>
                                <div id="userNameTip" style="width:280px"></div>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">* 密码:</td>
                            <td><input type="password" id="userPsd" name="password" style="width:140px"/></td>
                            <td>
                                <div id="userPsdTip" style="width:280px"></div>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">* 确认密码</td>
                            <td><input type="password" id="reuserPsd" name="reuserPsd" style="width:140px"/></td>
                            <td>
                                <div id="reuserPsdTip" style="width:280px"></div>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">* 邮箱:</td>
                            <td><input type="text" id="userEmail" name="email" style="width:140px"/></td>
                            <td>
                                <div id="userEmailTip" style="width:280px"></div>
                            </td>
                        </tr>

                        <tr>
                            <td align="right" id="realNameLable">* 真实姓名</td>
                            <td><input type="text" id="userRealName" name="real_name" style="width:140px"/></td>
                            <td>
                                <div id="userRealNameTip" style="width:280px"></div>
                            </td>
                        </tr>
                        <tr>
                            <td align="right"> 联系电话</td>
                            <td><input class="g-ipt" type="text" id="userPhone" name="phone" style="width:140px"/></td>
                            <td>
                                <div id="userPhoneTip" style="width:280px"></div>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">* 地址</td>
                            <td>
                                <input type="text" id="userCity" name="city" style="width:140px"/>
                                <input type="hidden" id="userProvince" name="province" style="width:140px"/>
                            </td>
                            <td>
                                <div id="userCityTip" style="width:280px"></div>
                            </td>
                        </tr>

                        <tr>
                            <td align="right">* 邮编</td>
                            <td><input type="text" id="userPostalcode" name="postalcode" style="width:140px"/></td>
                            <td>
                                <div id="userPostalcodeTip" style="width:280px"></div>
                            </td>
                        </tr>

                        <tr>
                            <td align="right" id="typeLable">* 专业领域</td>
                            <td>
                                <select name="type" id="type" class="g-ipt" style="width:153px">
                                    <option value="技术专家">技术专家</option>
                                    <option value="网页设计">网页设计</option>
                                    <option value="舞蹈教师">舞蹈教师</option>
                                    <option value="电脑专家">电脑专家</option>
                                </select>
                            </td>
                            <td>
                                <div id="userTypeTip" style="width:280px"></div>
                            </td>
                        </tr>
                        <tr>
                            <td align="right"> 简介</td>
                            <td colspan="2" style="text-align: left">
                                <textarea id="userIntroduce" name="introduce"
                                          style="width:387px; height: 199px;resize: none;"></textarea>
                            </td>

                        </tr>
                    </table>

                    <p>
                        <span> <input type="submit" value="&nbsp;&nbsp;注册&nbsp;&nbsp;"
                                      class="uc_submit btn_yellow"/> </span>
                        <span class="quicklogin">已有账号? <a class="fcf60" href="/index.action">点此登录 »</a></span>
                    </p>
                </form>
            </div>
            <div class="clearer"></div>
        </div>
    </div>
</div>
</body>

</html>
