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
    <div class="row" id="centerArea">
        <jsp:include page="/static/left.jsp"></jsp:include>
        <div class="seven">
            <div>
                <h1 class="ep_h1"><s:property value="enterpriseCommentBean.ecTitle"/></h1>
            </div>

            <div>
            <span class="ep_info">
                <s:property value="enterpriseCommentBean.ecPosted"/>　评论ID: <s:property
                    value="enterpriseCommentBean.ecEnterpriseId"/></a> 　
            </span>
            </div>
            <div class="content_text">
                <p>
                    ${enterpriseCommentBean.ecContent}
                </p>
            </div>
        </div>
        <s:action name="right" namespace="/static" executeResult="true">
        </s:action>
    </div>
</div>

<%@ include file="/static/footer.jsp" %>
</body>
</html>