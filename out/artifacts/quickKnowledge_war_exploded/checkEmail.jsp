<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13-8-14
  Time: 下午8:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="Shortcut Icon" href="/images/favicon.ico">
    <title>激活您的帐户</title>
    <link rel="stylesheet" href="/css/styleEmail.css">
</head>
<body>
<%
    String email = request.getParameter("email");
%>
<div class="content_login">
    <div class="top_bg"></div>
    <ul class="login_top">
        <li><img src="/images/pic_login04.gif"></li>
        <li><img src="/images/pic_login05.gif"></li>
        <li><img src="/images/pic_login03.gif"></li>
    </ul>
    <div class="login_cont03">
        <img src="/images/pic_04.gif" alt="">

        <p class="cont">您的信息已经成功提交，我们会在一个工作日内审核您的信息，而后将激活链接发送到您的邮箱 <em style="color:#f00; font-style:normal;"><%=email%>
        </em>.
            <br>请注意查收邮箱，按照邮件内容提示，激活您的帐户即可完成注册。</p>
    </div>
    <div>
        <span class="quicklogin">想返回主页? <a class="fcf60" href="/index.action">点此返回 »</a></span>
    </div>
    <div class="btm_bg"></div>
</div>
</body>
</html>