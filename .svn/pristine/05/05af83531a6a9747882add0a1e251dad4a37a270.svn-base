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
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/cutter.css">


    <script src="/js/jquery.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/json.min.js" type="text/javascript"></script>
    <script src="/js/jquery.json-2.2.min.js" type="text/javascript"></script>
    <script src="/js/teamManage.js"></script>
    <script src="/js/cutter.js"></script>
    <script src="/js/placeholder2.js"></script>
    <script src="/js/selectBar.js"></script>
    <script charset="utf-8" src="/js/kindeditor-4.1.1/kindeditor-min.js"></script>
    <script charset="utf-8" src="/js/kindeditor-4.1.1/lang/zh_CN.js"></script>
    <script src="/js/date/WdatePicker.js" type="text/javascript"></script>
</head>


<body>
<%@ include file="/static/header.jsp" %>
<div class="wrapper">
    <div class="row" style="margin-left: 0">
        <jsp:include page="/static/left.jsp"></jsp:include>
        <script type="text/javascript">
            function aa() {
                selectLeft(1, 6);//使第一个菜单被选中
            }
            window.onload = aa;
        </script>
        <div class="seven">
            <div>
                <h1 class="ep_h1">虚拟团队名： ${virtualTeamBean.vtName}</h1>
            </div>
            <div class="ep_summary">
                <p>
                    虚拟团队标签：${virtualTeamBean.vtNote}。
                </p>

                <p>
                    团队创建时间：${virtualTeamBean.vtCreateTime}。
                </p>
            </div>
            <h3 class="ep_h1" style="width: 70%;display: inline-block;">
                团队成员
            </h3>

            <div class="ep_summary" style="border: 0">
                <div id="lists">
                    <c:forEach var="item" items="${memberList}">
                        <div class="ep_summary_p">
                            <span style="background-color: #989bff;color: #ffffff">${item.vtMemberRemark}</span>
                            昵称：${item.userName}
                            <hr/>
                            专家类型：${item.userType}
                        </div>
                    </c:forEach>
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