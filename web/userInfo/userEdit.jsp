<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=7"/>
    <title> QuickKnowledge </title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link rel="Shortcut Icon" href="/images/favicon.ico">
    <link rel="stylesheet" href="/css/cutter.css">

    <script src="/js/jquery-1.3.2.min.js"></script>
    <script src="/js/formcheck22.js"></script>
    <script src="/js/cutter.js"></script>
    <script src="/js/placeholder2.js"></script>
    <script src="/js/selectBar.js"></script>
</head>


<%
    ////登陆 验证
    User u = (User) ActionContext.getContext().getSession().get("msg");
    if (u == null) {
        response.sendRedirect("/index.action");
    }
%>

<body>
<%@ include file="/static/header.jsp" %>
<div class="wrapper">
<div class="row">
<jsp:include page="/static/left.jsp"></jsp:include>

<script type="text/javascript">
    function aa() {
    <%
        if(u.getRole_id()==2) //企业家
        {
    %>
        selectLeft(1, 3);//选择坐标菜单
    <%
        }
        else {
    %>
        selectLeft(1, 9);//选择坐标菜单
    <%
        }
    %>
    }
    window.onload = aa;
</script>
<div class="seven" style="">
<link href="/css/user.css" rel="stylesheet" type="text/css"/>
<script src="/js/formValidator-4.1.1.js" type="text/javascript"></script>
<script src="/js/formValidatorRegex.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
<script src="/js/formcheck22.js" type="text/javascript"></script>
<script src="/js/json.min.js" type="text/javascript"></script>
<script src="/js/jquery.json-2.2.min.js" type="text/javascript"></script>
<script src="/js/autoemail.js" type="text/javascript"></script>

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

    #regform td {
        border: 0
    }
</style>
<form id="regform1" style="" method="post" action="/info/infoChange.action">
    <table class="tab1">

        <tr>
            <td align="right"> 用户名</td>
            <td id="nameTD1">
                <%=user.getUsername()%>
            </td>
            <td>
            </td>
        </tr>
        <tr>
            <td align="right">* 原密码:</td>
            <td><input type="password" placeholder="" value="" id="oldUserPsd" name="oldUserPsd"
                       class="g-ipt" style="width:140px"/></td>
            <td>
                <div id="oldUserPsdTip" style="width:280px"></div>
            </td>
        </tr>
        <tr>
            <td align="right">* 修改后的密码:</td>
            <td><input type="password" id="userPsd" name="userPsd" class="g-ipt" style="width:140px"/></td>
            <td>
                <div id="userPsdTip" style="width:280px"></div>
            </td>
        </tr>
        <tr>
            <td align="right">* 邮箱:</td>
            <td width="150px"><%=user.getEmail()%>
            </td>
            <td>
                <div id="userEmailTip" style="width:280px"></div>
            </td>
        </tr>

        <tr>
            <td align="right">* 名称</td>
            <td><input type="text" id="userRealName" name="userRealName" style="width:140px"
                       value="<%=user.getReal_name()%>"/></td>
            <td>
                <div id="userRealNameTip" style="width:280px"></div>
            </td>
        </tr>
        <tr>
            <td align="right"> 联系电话</td>
            <td><input class="g-ipt" type="text" id="userPhone" name="userPhone" style="width:140px"
                       value="<%=user.getPhone()%>"/></td>
            <td>
                <div id="userPhoneTip" style="width:280px"></div>
            </td>
        </tr>
        <tr>
            <td align="right">* 地址</td>
            <td>
                <input type="text" id="userCity" name="userCity" style="width:140px"
                       value="<%=user.getAddress()%>"/>
                <input type="hidden" id="userProvince" name="userProvince" style="width:140px"/>
            </td>
            <td>
                <div id="userCityTip" style="width:280px"></div>
            </td>
        </tr>

        <tr>
            <td align="right">* 邮编</td>
            <td><input type="text" id="userPostalcode" name="userPostalcode" style="width:140px"
                       value="<%=user.getPostalcode()%>"/></td>
            <td>
                <div id="userPostalcodeTip" style="width:280px"></div>
            </td>
        </tr>

        <tr>

            <%
                if (user.getRole_id() == 3)//专家
                {
            %>
            <td align="right">* 专业领域</td>
            <td>
                <select name="userType" class="g-ipt" style="width:153px">
                    <option value="技术专家"<%= user.getType() != null ? (user.getType().equals("技术专家") ? "selected" : "") : ""%> >
                        技术专家
                    </option>
                    <option value="网页设计" <%= user.getType() != null ? (user.getType().equals("网页设计") ? "selected" : "") : ""%> >
                        网页设计
                    </option>
                    <option value="舞蹈教师" <%= user.getType() != null ? (user.getType().equals("舞蹈教师") ? "selected" : "") : ""%> >
                        舞蹈教师
                    </option>
                    <option value="电脑专家" <%= user.getType() != null ? (user.getType().equals("电脑专家") ? "selected" : "") : ""%> >
                        电脑专家
                    </option>
                </select>
            </td>
            <%
            } else if (user.getRole_id() == 2)//企业
            {
            %>
            <td align="right">* 专业领域</td>
            <td>
                <select name="userType" class="g-ipt" style="width:153px">
                    <option value="服装行业"<%= user.getType() != null ? (user.getType().equals("服装行业") ? "selected" : "") : ""%> >
                        服装行业
                    </option>
                    <option value="建筑行业" <%= user.getType() != null ? (user.getType().equals("建筑行业") ? "selected" : "") : ""%> >
                        建筑行业
                    </option>
                    <option value="广告行业" <%= user.getType() != null ? (user.getType().equals("广告行业") ? "selected" : "") : ""%> >
                        广告行业
                    </option>
                </select>
            </td>
            <%
                }
            %>


            <td>
                <div id="userTypeTip" style="width:280px"></div>
            </td>
        </tr>
        <tr>
            <td align="right">* 简介</td>
            <td colspan="2" style="text-align: left">
                <textarea id="userIntroduce" name="userIntroduce"
                          style="width:387px; height: 199px;resize: none;"><%=user.getIntroduce()%>
                </textarea>
            </td>

        </tr>
    </table>
    <input type="hidden" name="id" value="<%=user.getId()%>" style="width:140px"/>

    <p>
            <span>
                <input type="submit" value="&nbsp;&nbsp;保存&nbsp;&nbsp;" class="uc_submit btn_yellow">
            </span>
    </p>
</form>
</div>
<s:action name="right" namespace="/static" executeResult="true">
</s:action>
</div>
</div>

<%@ include file="/static/footer.jsp" %>
</body>
</html>