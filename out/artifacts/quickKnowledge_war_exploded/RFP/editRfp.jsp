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

<body>
<%
    ////登陆 验证
    User u = (User) ActionContext.getContext().getSession().get("msg");
    if (u == null) {
        response.sendRedirect("/index.action");
    }
%>
<c:choose>
    <c:when test="${status != null && status == 1}">
        <script>
            alert("修改成功");
        </script>
    </c:when>
    <c:when test="${status != null && (status == 0 || status == -1)}">
        <script>
            alert("修改失败");
        </script>
    </c:when>
</c:choose>

<%@ include file="/static/header.jsp" %>
<div class="wrapper">
    <div class="row" style="margin-left: 0">
        <jsp:include page="/static/left.jsp"></jsp:include>
        <div class="seven">
            <h3 class="ep_h1" style="width: 70%;display: inline-block;">
                修改团队招标
            </h3>

            <div class="ep_summary" style="margin-top: 10px;">
                <form action="/rfp/doEditRfp.action" name="form" id="form" method="post" onsubmit="return formSub()">
                    <table style="width: 548px;margin-top: 0px;">
                        <tr>
                            <td style="width: 25%">团队招标标题：</td>
                            <td>
                                <input name="rfpInfoBean.rfpInfoId" value="${rfpInfoBean.rfpInfoId}" type="hidden"/>
                                <input name="rfpInfoBean.userId" value="${msg.id}" type="hidden"/>
                                <input name="rfpInfoBean.rfpInfoTitle" value="${rfpInfoBean.rfpInfoTitle}"
                                       id="rfpInfoTitle" class="g-ipt"
                                       style="width:80%;border:0;height: 20px;"/>
                            </td>
                        </tr>
                        <tr>
                            <td>招标关键字：</td>
                            <td><input name="rfpInfoBean.rfpInfoKey" value="${rfpInfoBean.rfpInfoKey}" class="g-ipt"
                                       style="color:#7d7f89;border:0;width:80%;height: 20px;"/>
                            </td>
                        </tr>
                        <tr>
                            <td>招标类型：</td>
                            <td><input name="rfpInfoBean.rfpInfoType" value="${rfpInfoBean.rfpInfoType}" class="g-ipt"
                                       style="border:0;color:#7d7f89;width:80%;border:0;height: 20px;"/>
                            </td>
                        </tr>

                        <tr>
                            <td style="border: none">招标内容：</td>
                            <td style="border: none">&nbsp;</td>
                        </tr>

                        <tr>
                            <td colspan="2" class="text_indent">
                                <textarea id="rfpInfoContent" name="rfpInfoBean.rfpInfoContent"
                                          style="width:100%;height:250px;visibility:hidden;resize: none;">${rfpInfoBean.rfpInfoContent}</textarea>
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
        editor = K.create('textarea[name="rfpInfoBean.rfpInfoContent"]', {
            resizeType:0,
            allowPreviewEmoticons:false,
            allowUpload:true,
            //是否可以弹出对话框选择文件
            allowFileManager:true,
            //文件选择的时候弹出的对话框/对话框中可以放置服务器图片文件
            //fileManagerJson:"/test/saveImage",
            allowImageUpload:true,
            syncType:"absolute",
            items:[
                'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                'insertunorderedlist'
            ],
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

    function formSub() {
        var rfpInfoTitle = $("#rfpInfoTitle").val();
        var key = $("input[name='rfpInfoBean.rfpInfoKey']").val();
        var type = $("input[name='rfpInfoBean.rfpInfoType']").val();
        var content = editor.html().replace(" ", "");

        if (!rfpInfoTitle || rfpInfoTitle == "") {
            alert("请输入标题");
            return false;
        }
        if (!key || key == "") {
            alert("请输关键字");
            return false;
        }
        if (!type || type == "") {
            alert("请输入类型");
            return false;
        }
        if (!content || content == "") {
            alert("请输入内容");
            return false;
        }
        return true;
    }

</script>
</body>
</html>