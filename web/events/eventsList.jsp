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
    <script type="text/javascript">
        function deleteInfo(userId, sel) {
            if (confirm("确认要删除？")) {
                var jsonData = {id:userId};
                var htmlobj = $.ajax({
                    url:"/events/deleteEvents.action",
                    data:jsonData,
                    contentType:"application/x-www-form-urlencoded; charset=UTF-8",
                    processData:true,
                    cache:false,
                    async:false
                });
                $(sel).parents("tr").hide(1500);
            }
        }
    </script>
</head>
<body>
<%@ include file="/static/header.jsp" %>
<div class="wrapper">
    <div class="row">
        <jsp:include page="/static/left.jsp"></jsp:include>

        <script type="text/javascript">
            function aa() {
                var url = location.href;
                if (url.search(/getEventsList.action/) == -1) {
                    selectLeft(1, 3);//左方 我的活动
                }
                else {
                    selectBar(3);//上方 活动
                }
            }
            window.onload = aa;
        </script>
        <div class="seven" id="centerArea">
            <table style="font-size: 15px">
                <tr>
                    <th>活动标题</th>
                    <th>发布ID</th>
                    <th>发布时间</th>
                    <c:if test="${msg!=null}">
                        <th>操作</th>
                    </c:if>
                </tr>
                <s:iterator value="#request.list" status="statu" id="item">
                    <tr>
                        <td class="titleListtd">
                            <a href="/events/get.action?id=<s:property value="eventId" />"><s:property
                                    value="eventTitle"/></a>
                        </td>
                        <td>
                            <span class="content_attach"><s:property value="userId"/> </span>
                        </td>
                        <td>
                            <span class="content_attach"><s:property value="eventPosted"/></span>
                        </td>

                        <s:if test="#session.msg!=null && #item.userId  ==  #session.msg.id || #session.msg.role_id==1">
                            <td>
                                 <span>
                                     <a href="/events/eventsChange.action?id=<s:property value="eventId" />"
                                        class="button">编辑</a>
                                     <a href="javascript:return false;" class="button"
                                        onclick="deleteInfo(<s:property value="eventId" />,this)"/>
                                         删除
                                     </a>
                                 </span>
                            </td>
                        </s:if>

                        <s:if test="(#session.msg!=null) && (#item.userId  !=  #session.msg.id) && #session.msg.role_id!=1">
                            <td>
                                <span>
                                    <a class="buttonSecurity">编辑</a>
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