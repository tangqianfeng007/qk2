<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.qk.bean.User" %>
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

    <script type="text/javascript">
        function aa() {
            selectLeft(3, 1);//选择坐标菜单
        }
        window.onload = aa;
    </script>
</head>

<body>
<%
    ////登陆 验证
    User u = (User) ActionContext.getContext().getSession().get("msg");
    if (u == null) {
        response.sendRedirect("/index.action");
    }
%>
<%@ include file="/static/header.jsp" %>
<div class="wrapper">
    <div class="row">
        <jsp:include page="/static/left.jsp"></jsp:include>
        <div class="seven" id="centerArea">
            <table style="font-size: 15px">
                <tr>
                    <th>招标名称</th>
                    <th>招标类型</th>
                    <th>招标联系</th>
                    <th>招标时间</th>
                </tr>
                <s:iterator value="#request.list" status="statu" id="item">
                    <tr>
                        <td class="titleListtd">
                            <a href="/bids/bidsAll!bidsContent.action?cfbId=<s:property value="cfbId"/>"><s:property
                                    value="cfbTitle"/></a>
                        </td>
                        <td>
                            <span class="content_attach"><s:property value="cfbIndusty"/></span>
                        </td>
                        <td>
                            <span class="content_attach"><s:property value="cfbContact"/></span>
                        </td>
                        <td>
                            <span>
                                <a href="/bids/bidsAll!bidsContent.action?cfbId=<s:property value="cfbId"/>"
                                   class="button">评论</a>
                            </span>
                        </td>
                    </tr>
                </s:iterator>
            </table>


            <div class="foot pageTools">
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
