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
    <link rel="stylesheet" href="../css/cutter.css">

    <script src="/js/jquery-1.3.2.min.js"></script>
    <script src="/js/cutter.js"></script>
    <script src="/js/placeholder2.js"></script>
    <script src="/js/selectBar.js"></script>
</head>


<body>
<%@ include file="/static/header.jsp" %>
<div class="wrapper">
    <div class="row">
        <jsp:include page="/static/left.jsp"></jsp:include>
        <script type="text/javascript">
            function aa() {
                selectBar(4);//使第一个菜单被选中
            }
            window.onload = aa;
        </script>
        <div class="seven" id="centerArea">
            <div>
                <h1 class="ep_h1"><s:property value="pubs.pubTitle"/></h1>
            </div>

            <div>
            <span class="ep_info">
                <s:property value="pubs.pubPosted"/>　来源: <a
                    href="/experts/get.action?id=<s:property value="pubs.userId" />"><s:property
                    value="pubs.userId"/></a> 　
                有<s:property value="pubs.pubCount"/>人点击
            </span>
            </div>
            <div class="ep_summary">
                <p>
                    类型：<s:property value="pubs.pubType"/>
                </p>

                <p>
                    价格：<s:property value="pubs.pubPrice"/>
                </p>

                <%--<p>--%>
                    <%--简介： ${pubs.pubIntroduce}--%>
                <%--</p>--%>
            </div>
            <div class="content_text">
                <p>
                    ${pubs.pubIntroduce}
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