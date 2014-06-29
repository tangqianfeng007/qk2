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
    <script charset="utf-8" src="/js/common.js"></script>
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
            alert("发布成功");
            location = "/pubs/getPersonPubsList.action?pageNumber=1";
        } else {
            alert("发布失败");
        }
    </script>
</c:if>

<script type="text/javascript">
    function aa() {
        selectLeft(2, 3);//选择坐标菜单
    }
    window.onload = aa;
    function aa() {
        selectLeft(2, 3);//选择坐标菜单
    }
    window.onload = aa;

    function checkSub() {
        var title = $("input[name='pubTitle']").val();
        var pubType = $("input[name='pubType']").val();

        var pubPrice = $("input[name='pubPrice']").val();
        var detail = editor.html().replace(" ", "");

        if (title == null || !title || title == "") {
            alert("请输入出版物名称");
            return false;
        }

        if (pubType == null || !pubType || pubType == "") {
            alert("请输入出版物类型");
            return false;
        }

        if (pubPrice == null || !pubPrice || pubPrice == "") {
            alert("请输入出版物价格");
            return false;
        }

        if (detail == null || !detail || detail == "") {
            alert("请输入出版物简介");
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
                出版物发布
            </h3>

            <div class="ep_summary" style="margin-top: 10px;">
                <form action="/edit/pubsEdit.action" name="form" onsubmit="return checkSub();" id="form" method="post">
                    <table style="width: 548px;margin-top: 0px;">
                        <tr>
                            <td style="width: 25%">出版物名称：</td>
                            <td>
                                <input name="pubTitle" placeholder="请输入出版物名" class="g-ipt"
                                       value=""
                                       style="width:80%;border:0;height: 20px;"/>
                            </td>
                        </tr>

                        <tr>
                            <td style="width: 25%">出版物类型：</td>
                            <td>
                                <input name="pubType" placeholder="请输入出版物类型" class="g-ipt"
                                       value=""
                                       style="width:80%;border:0;height: 20px;"/>
                            </td>
                        </tr>

                        <tr>
                            <td style="width: 25%">出版物价格：</td>
                            <td>
                                <input name="pubPrice" placeholder="请输入出版物价格" class="g-ipt"
                                       value="" onkeyup="clearNoNum(this)"
                                       style="width:80%;border:0;height: 20px;"/>
                            </td>
                        </tr>

                        <tr>
                            <td style="border: none">出版物简介：</td>
                            <td style="border: none">&nbsp;</td>
                        </tr>

                        <tr>
                            <td colspan="2" class="text_indent">
                                <textarea id="pubIntroduce" name="pubIntroduce"
                                          style="width:100%;height:250px;visibility:hidden;resize: none;"></textarea>
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
        editor = K.create('textarea[name="pubIntroduce"]', {
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