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
</head>


<body>
<%@ include file="/static/header.jsp" %>
<div class="wrapper">
    <div class="row">
        <jsp:include page="/static/left.jsp"></jsp:include>
        <script type="text/javascript">
            function aa() {
                selectBar(5);//使第一个菜单被选中
            }
            window.onload = aa;
        </script>
        <div class="seven" id="centerArea">
            <div>
                <h1 class="ep_h1" style="width: 70%;display: inline-block;">
                    专家姓名：${user.username}
                    <input type="hidden" id="id" name="id" value="${user.id}"/>
                </h1>
            </div>

            <div class="ep_summary">
                <p>
                    邮箱：${user.email}
                </p>

                <p>
                    电话：${user.phone}
                </p>

                <p>
                    地址：${user.address}
                </p>

                <p>
                    邮编：${user.postalcode}
                </p>

                <p>
                    类型：${user.type}
                </p>

                <p>
                    简介：${user.introduce}
                </p>
            </div>

            <h3 class="ep_h1" style="width: 70%;display: inline-block;">
                评价
            </h3>

            <div class="ep_summary" style="border: 0">
                <div id="lists">
                    <c:forEach var="item" items="${lists}">
                        <div class="ep_summary_p">
                            昵称：${item.userName}
                            <hr/>
                            评论内容：${item.ecContent}
                            <hr/>
                            评论时间：${item.ecPosted}
                        </div>
                    </c:forEach>
                    <div class="foot" style="float: right;">
                        <div class="right">
                            <div class="pager" id="pager">
                                ${pageTools}
                            </div>
                        </div>
                    </div>
                    <c:if test="${msg!=null&&msg.role_id==2}">
                        <h3 id="hideH3" name="hideH3Content"
                            style="text-indent: 0em;width: 70%;margin-bottom:0;color: #000000;font-size: 22px;display: block;">
                            评论
                        </h3>
                    </c:if>
                </div>
                <c:if test="${msg!=null&&msg.role_id==2}">
                    <p>

                    <form method='post' id="form" name="form" action="#">
                        <table style="width: 100%">
                            <tr>
                                <td class="text_indent">
                                    <textarea id="content" name="content"
                                              style="width:100%;height:250px;visibility:hidden;resize: none;">
                                            ${news.content}
                                    </textarea>
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: left;text-indent: 0em">
                                    <input class="button" type="submit" value="提交"
                                           onclick="submitComment();return false;">
                                </td>
                            </tr>
                        </table>
                    </form>
                    </p>
                </c:if>
            </div>
        </div>
        <s:action name="right" namespace="/static" executeResult="true"></s:action>
    </div>
</div>

<%@ include file="/static/footer.jsp" %>


<script type="text/javascript">

    /**
     *   提交评论
     */
    function submitComment() {
        var content = editor.html();
        var detail = content.replace(" ", "");
        if (detail == null || !detail || detail == "") {
            alert("请输入内容");
            return false;
        }
        var id = $("#id").val();
        var jsonData = {content:content, id:id};
        var htmlobj = $.ajax({
            url:"/enterpriseToExperts/commentsExperts.action",
            type:'POST',
            contentType:"application/x-www-form-urlencoded; charset=utf-8",
            dataType:'html',
            data:jsonData,
            processData:true,
            cache:false,
            async:false
        });
        $("#lists").html(htmlobj.responseText);
        editor.html("");
    }

    function getPage(page) {
        var id = $("#id").val();
        var jsonData = {pageNumber:page, id:id};
        var htmlobj = $.ajax({
            url:"/enterpriseToExperts/seeComments.action",
            dataType:'html',
            data:jsonData,
            cache:false,
            async:false
        });
        $("#lists").html(htmlobj.responseText);
    }

</script>

<%--加载KindEditor编辑器--%>
<script type="text/javascript">
    var editor;
    KindEditor.ready(function (K) {
        editor = K.create('textarea[name="content"]', {
            resizeType:0,
            allowPreviewEmoticons:false,
            allowUpload:true,
            //是否可以弹出对话框选择文件
            allowFileManager:true,
            //文件选择的时候弹出的对话框/对话框中可以放置服务器图片文件
            //fileManagerJson:"/test/saveImage",
            allowImageUpload:true,
            uploadJson:"/newsManage/imageUpload.do",
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
            }
        });
    });
</script>
</body>
</html>

</body>
</html>