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
<c:if test="${responseMsg!=null}">
    <script type="text/javascript">
        if (${responseMsg=="1"}) {
            alert("删除成功");
            location.href = "/comments/getPersonCommentsList.action?pageNumber=1";
        } else if (${responseMsg=="-1"}) {
            alert("删除失败");
            location.href = "/comments/getPersonCommentsList.action?pageNumber=1";
        }
    </script>
</c:if>

<%@ include file="/static/header.jsp" %>
<div class="wrapper">
    <div class="row">
        <jsp:include page="/static/left.jsp"></jsp:include>

        <script type="text/javascript">
            function aa() {
                var url = location.href;
                if (url.search(/getCommentsList.action/) == -1) {
                    selectLeft(1, 4);//左方 我的站点评论
                }
                else {
                    selectBar(6);//上方 站点评论
                }
            }
            window.onload = aa;
        </script>
        <div class="seven" id="centerArea">

            <table style="font-size: 15px">
                <tr>
                    <th>评论标题</th>
                    <th>发布ID</th>
                    <th>发布时间</th>
                    <s:if test="#session.msg!=null">
                        <th>
                            操作
                        </th>
                    </s:if>
                </tr>
                <s:iterator value="#request.list" status="statu" id="item">
                    <tr>
                        <td class="titleListtd">
                            <a href="/comments/get.action?id=<s:property value="scId" />"><s:property
                                    value="scTitle"/></a>
                        </td>
                        <td>
                            <span class="content_attach"><s:property value="userId"/> </span>
                        </td>
                        <td>
                            <span class="content_attach"><s:property value="scPosted"/></span>
                        </td>


                        <s:if test="#session.msg!=null && #item.userId  ==  #session.msg.id  || #session.msg.role_id==1">
                            <td>
                                 <span>
                                    <a href="/comments/deleteComments?id=<s:property value="scId" />"
                                       class="button">删除</a>
                                 </span>
                            </td>
                        </s:if>

                        <s:if test="(#session.msg!=null) && (#item.userId  !=  #session.msg.id)  && #session.msg.role_id!=1">
                            <td>
                                <span>
                                    <a class="buttonSecurity">删除</a>
                                </span>
                            </td>
                        </s:if>
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