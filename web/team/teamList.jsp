<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%@ include file="../static/header.jsp" %>
<div class="wrapper">
    <div class="row">
        <jsp:include page="../static/left.jsp"></jsp:include>

        <script type="text/javascript">
            function aa() {
                selectLeft(1, 6);//选择坐标菜单
            }
            window.onload = aa;

            function deleteTeam(teamId) {
                var isC = window.confirm("确认删除？");
                if (isC) {
                    jQuery.ajax({
                        type:'post',
                        url:'/ajax/deleteTeam.action',
                        processData:true,
                        async:true,
                        dataType:'html',
                        data:{teamId:teamId},
                        success:function (data) {
                            data = jQuery.parseJSON(data);
                            if (data.status == 1) {
                                alert("删除成功");
                                location.reload();
                            }
                            else {
                                alert("修改失败" + data.status);
                            }
                        },
                        error:function () {
                            alert("服务器繁忙中！稍后再试！");
                        }
                    });
                }
            }
        </script>
        <div class="seven">

            <table style="font-size: 15px">
                <tr>
                    <th>团队名</th>
                    <th>团队标签</th>
                    <th>创建时间</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="item" items="${teamList}">
                    <tr>
                        <td class="titleListtd">
                            <a href="/team/teamContent.action?rfpId=${item.rfpInfoId}">${item.vtName}</a>
                        </td>
                        <td>
                            <span class="content_attach">${item.vtNote}</span>
                        </td>
                        <td>
                            <span class="content_attach">${item.vtCreateTime}</span>
                        </td>
                        <td>
                            <span>
                              <a href="/team/editTeam.action?rfpId=${item.rfpInfoId}" class="button">编辑</a>
                              <a href="javaScript:void(0)" onClick="deleteTeam(${item.vtId});" class="button">删除</a>
                            </span>
                        </td>
                    </tr>

                </c:forEach>

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

<%@ include file="../static/footer.jsp" %>
</body>
</html>