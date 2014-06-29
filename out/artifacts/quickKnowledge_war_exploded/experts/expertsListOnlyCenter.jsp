<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="/js/cutter.js"></script>
    <script src="/js/placeholder2.js"></script>
    <script src="/js/selectBar.js"></script>
</head>


<body>

<table style="font-size: 17px">
    <tr>
        <th>用户ID</th>
        <th>用户姓名</th>
        <th>用户类型</th>
        <c:if test="${msg!=null&&msg.role_id==2}">
            <th>操作</th>
        </c:if>
    </tr>
    <s:iterator value="#request.list" status="statu" id="item">
        <tr>
            <td>
                <a href="/enterpriseToExperts/commentsList.action?id=<s:property value="Id" />"><s:property
                        value="id"/> </a>
            </td>
            <td>
                <a href="/enterpriseToExperts/commentsList.action?id=<s:property value="Id" />"><span
                        class="content_attach"><s:property value="username"/> </span> </a>
            </td>
            <td>
                <span class="content_attach"><s:property value="type"/></span>
            </td>
            <c:if test="${msg!=null&&msg.role_id==2}">
                <td>
                            <span>
                                <a href="/enterpriseToExperts/commentsList.action?id=<s:property value="Id" />"
                                   class="button">评论</a>
                            </span>
                </td>
            </c:if>
        </tr>
    </s:iterator>
</table>


<div class="foot" style="float: right;margin: 30px">
    <div class="right">
        <div class="pager">
            ${pageTools}
        </div>
    </div>
</div>


</body>
</html>