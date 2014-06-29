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

<%
    ////登陆 验证
    User u = (User) ActionContext.getContext().getSession().get("msg");
    if (u == null) {
        response.sendRedirect("/index.action");
    }
%>

<c:if test="${responseMsg!=null}">
    <script type="text/javascript">
        if (${responseMsg=="1"}) {
            alert("删除成功");
            location.href = "/ec_comments/getTomeCommentsList.action";
        } else if (${responseMsg=="-1"}) {
            alert("删除失败");
            location.href = "/ec_comments/getTomeCommentsList.action";
        }
    </script>
</c:if>
<script language="javascript">
    function aa() {
        selectLeft(1, 5);//左方 我的rfp
    }
    window.onload = aa;
</script>
<body>
<%@ include file="/static/header.jsp" %>
<div class="wrapper">
    <div class="row">
        <jsp:include page="/static/left.jsp"></jsp:include>

        <div class="seven" id="centerArea">

            <table style="font-size: 15px">
                <tr>
                    <th>评论人</th>
                    <th>评论ID</th>
                    <th>评论时间</th>
                </tr>
                <s:iterator value="#request.list" status="statu" id="item">
                    <tr>
                        <td class="titleListtd">
                            <a href="/ec_comments/get.action?id=<s:property value="ecId" />"><s:property value="userName"/></a>
                        </td>
                        <td>
                            <span class="content_attach"><s:property value="ecEnterpriseId"/> </span>
                        </td>
                        <td>
                            <span class="content_attach"><s:property value="ecPosted"/></span>
                        </td>
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
        </div>
        <s:action name="right" namespace="/static" executeResult="true">
        </s:action>
    </div>
</div>

<%@ include file="/static/footer.jsp" %>
</body>
</html>