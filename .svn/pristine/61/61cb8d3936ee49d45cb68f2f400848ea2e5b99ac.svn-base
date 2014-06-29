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
    <script charset="utf-8" src="/js/kindeditor-4.1.1/kindeditor-min.js"></script>
    <script charset="utf-8" src="/js/kindeditor-4.1.1/lang/zh_CN.js"></script>
    <script src="/js/date/WdatePicker.js" type="text/javascript"></script>
</head>

<%
    ////登陆 验证
    User u = (User) ActionContext.getContext().getSession().get("msg");
    if (u == null) {
        response.sendRedirect("/index.action");
    }
%>

<body>

<c:if test="${responseMsg!=null}">
    <script type="text/javascript">
        if (${responseMsg=="1"}) {
            alert("编辑成功");
            location = "/events/getPersonEventsList.action?pageNumber=1";
        } else {
            alert("编辑失败");
        }
    </script>
</c:if>

<script type="text/javascript">
    function aa() {
        selectLeft(1, 3);//选择坐标菜单
    }
    window.onload = aa;

    function checkSub() {
        var title = $("input[name='eventTitle']").val();
        var date = $("input[name='eventDate']").val();

        var location = $("input[name='eventLocation']").val();
        var key = $("input[name='eventKeywords']").val();
        var detail = editor.html().replace(" ", "");

        if (title == null || !title || title == "") {
            alert("请输入标题");
            return false;
        }

        if (date == null || !date || date == "") {
            alert("请输入活动日期");
            return false;
        }

        if (location == null || !location || location == "") {
            alert("请输入活动地点");
            return false;
        }

        if (key == null || !key || key == "") {
            alert("请输入关键字");
            return false;
        }
        if (detail == null || !detail || detail == "") {
            alert("请输入内容");
            return false;
        }
        return true;
    }
</script>

<%@ include file="/static/header.jsp" %>
<div class="wrapper">
    <div class="row">
        <jsp:include page="/static/left.jsp"></jsp:include>
        <div class="seven" id="centerArea">
            <h3 class="ep_h1" style="width: 70%;display: inline-block;">
                活动发布
            </h3>

            <div class="ep_summary" style="margin-top: 10px;">
                <form action="/edit/eventsChange.action" onsubmit="return checkSub()" name="form" id="form"
                      method="post">
                    <table style="width: 548px;margin-top: 0px;">
                        <tr>
                            <td style="width: 25%">活动标题：</td>
                            <td>

                                <input name="eventId" value="${event.eventId}" type="hidden"/>
                                <input name="eventCount" value="${event.eventCount}" type="hidden"/>
                                <input name="userId" value="${event.userId}" type="hidden"/>
                                <input name="eventPosted" value="${event.eventPosted}" type="hidden"/>

                                <input name="eventTitle" placeholder="请输入活动标题" class="g-ipt"
                                       value="${event.eventTitle}"
                                       style="width:80%;border:0;height: 20px;"/>
                            </td>
                        </tr>

                        <tr>
                            <td style="width: 25%">活动日期：</td>
                            <td>
                                <input name="eventDate" placeholder="请输入活动日期" class="g-ipt"
                                       value="${event.eventDate}"
                                       style="width:80%;border:0;height: 20px;"
                                       onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'1900-01-01',maxDate:'2100-01-01'})"/>
                            </td>
                        </tr>

                        <tr>
                            <td style="width: 25%">活动地点：</td>
                            <td>
                                <input name="eventLocation" placeholder="请输入活动地点" class="g-ipt"
                                       value="${event.eventLocation}"
                                       style="width:80%;border:0;height: 20px;"/>
                            </td>
                        </tr>

                        <tr>
                            <td style="width: 25%">活动关键字：</td>
                            <td>
                                <input name="eventKeywords" placeholder="请输入关键字" class="g-ipt"
                                       value="${event.eventKeywords}"
                                       style="width:80%;border:0;height: 20px;"/>
                            </td>
                        </tr>

                        <tr>
                            <td style="border: none">活动内容：</td>
                            <td style="border: none">&nbsp;</td>
                        </tr>

                        <tr>
                            <td colspan="2" class="text_indent">
                                <textarea id="eventSummary" name="eventSummary"
                                          style="width:100%;height:250px;visibility:hidden;resize: none;">
                                    ${event.eventSummary}
                                </textarea>
                            </td>
                        </tr>
                    </table>
                    <input type="submit" value="&nbsp;保存&nbsp;" class="uc_submit btn_yellow">
                </form>

            </div>

        </div>
        <s:action name="right" namespace="/static" executeResult="true">
        </s:action>
    </div>
</div>

<%@ include file="/static/footer.jsp" %>


<script type="text/javascript">
    var editor;
    KindEditor.ready(function (K) {
        editor = K.create('textarea[name="eventSummary"]', {
            resizeType:0,
            allowPreviewEmoticons:false,
            allowUpload:true,
            //是否可以弹出对话框选择文件
            allowFileManager:true,
            //文件选择的时候弹出的对话框/对话框中可以放置服务器图片文件
            //fileManagerJson:"/test/saveImage",
            allowImageUpload:true,
            syncType:"absolute",
            items:['source', '|', 'fullscreen', 'undo', 'redo', 'print', 'cut', 'copy', 'paste',
                'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                'superscript', '|', 'selectall', '-',
                'title', 'fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold',
                'italic', 'underline', 'strikethrough', 'removeformat', '|'
                , 'advtable', 'hr', 'emoticons', 'link', 'unlink', '|', 'about'],
            afterCreate:function () {
                var self = this;
                K.ctrl(document, 13, function () {
                    self.sync();
                    document.forms['form'].submit();
                });
                K.ctrl(self.edit.doc, 13, function () {
                    self.sync();
                    document.forms['form'].submit();
                });
            },
            afterBlur:function () {
                this.sync();
            }
        });
    });
</script>

</body>
</html>