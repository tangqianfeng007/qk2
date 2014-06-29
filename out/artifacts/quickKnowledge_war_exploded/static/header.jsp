<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.qk.bean.User" %>
<script type="text/javascript">
    function seekExperts(num) {
        var seekType =  $("#seekType").val();
        var nameIndex = $("#nameIndex").val();
        var jsonData = {nameIndex:nameIndex, pageNumber:num,seekType:seekType};
        var htmlobj = $.ajax({
            url:"/experts/expertsSeek.action",
            data:jsonData,
            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
            processData:true,
            cache:false,
            async:true,
            success:function () {
                $("#centerArea").html(htmlobj.responseText);
            }
        });
    }
</script>

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
                <%
                    User user = (User) session.getAttribute("msg");
                    if (user != null && user.getRole_id() == 1) {
                %>
                <li>
                    <strong><a href="/man/getManList.action?pageNumber=1">注册管理</a></strong>
                </li>
                <%
                    }
                %>
            </ul>

        </div>
        <div class="sub" style="text-indent: 0px;margin-top: 27px;">
            <select name="type" id="seekType" class="g-ipt" style="width:80px" class="text">
                <option value="1" selected="selected">专家</option>
                <option value="2">企业</option>
            </select>
            <input type="text" id="nameIndex" placeholder="搜索" class="text">
            <input type="button" value="搜索" class="buttonTopAndLogin" onclick="seekExperts(1)">
            <!--搜索专家：<a href="###">登陆</a>-->
            <!--<a href="###">注册</a>-->
        </div>
    </div>
</div>