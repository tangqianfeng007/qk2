<%@ page import="com.qk.bean.User" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%--
  Created by IntelliJ IDEA.
  User: zheng
  Date: 13-8-10
  Time: 上午10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>

<%
    ////登陆 验证
    User u = (User) ActionContext.getContext().getSession().get("msg");
    if (u == null) {
        response.sendRedirect("/index.action");
    }
%>
<body>
<div style="margin: 20px;width: 750px;">
    <div class="ep_summary"
         style="overflow: scroll;width: 300px;height: 400px;font-family: Verdana,arial,sans-serif;float: left;">
        <h1 class="ep_h1">待选人员</h1>
        <table id="outTable">
            <c:forEach var="item" items="${commentList}">
                <c:if test="${item.status == 0}">
                    <tr>
                        <td>
                                ${item.userName}
                        </td>
                        <td class="uId" style="display: none">${item.userId}</td>
                        <td>
                                ${item.userType}
                        </td>
                        <td>
                            <button class="button" onclick="exchangeTr(this)">添加</button>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>

        </table>
    </div>

    <div class="ep_summary"
         style="overflow: scroll;width: 300px;height: 400px;font-family: Verdana,arial,sans-serif;float: left;">
        <h1 class="ep_h1">已有人员</h1>
        <table id="inTable">
            <c:forEach var="item" items="${commentList}">
                <c:if test="${item.status == 1}">
                    <tr>
                        <td>
                                ${item.userName}
                        </td>
                        <td class="uId" style="display: none">${item.userId}</td>
                        <td>
                                ${item.userType}
                        </td>
                        <td>
                            <button class="button" onclick="exchangeTr(this)">删除</button>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </div>
    <div style="float: left;margin-left: 40%;margin-top: 30px;">
        <form action="" id="addForm" style="display: none">
            <input name="uerIdList" id="uerIdList">
            <input name="vtId" id="vtId">
        </form>
    </div>

    <div style="clear: both"></div>
</div>


</body>
</html>