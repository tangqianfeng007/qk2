<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.qk.bean.User" %>
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
    <script charset="utf-8" src="/js/kindeditor-4.1.1/kindeditor-min.js"></script>
    <script charset="utf-8" src="/js/kindeditor-4.1.1/lang/zh_CN.js"></script>
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
<%@ include file="../static/header.jsp" %>
<div class="wrapper">
    <div class="row">
        <jsp:include page="../static/left.jsp"></jsp:include>
        <div class="seven" id="centerArea">
            <div>
                <h1 class="ep_h1" style="width: 70%;display: inline-block;">
                    招标名称：${callforbitBean.cfbTitle}
                </h1>
            </div>
            <div class="ep_summary">
                <p>
                    投标开始时间：${callforbitBean.cfbOpenDate}
                </p>

                <p>
                    投标结束时间：${callforbitBean.cfbExpDate}
                </p>

                <p>
                    投标发布时间：${callforbitBean.cfbPosted}
                </p>

                <p>
                    联系地址：${callforbitBean.cfbAddress}
                </p>

                <p>
                    联系电话：${callforbitBean.cfbPhone}
                </p>

                <p>
                    详细内容：${callforbitBean.cfbDetails}
                </p>

                <p>
                    类型：${callforbitBean.cfbIndusty}
                </p>

                <p>
                    邮箱：${callforbitBean.cfbEmail}
                    <input type="hidden" name="cfbId" id="cfbId" value="${callforbitBean.cfbId}">
                    <input id="cfbStatus" name="cfbStatus" type="hidden" value="${cfbStatus}"/>
                </p>
            </div>

            <h3 class="ep_h1" style="width: 70%;display: inline-block;">
                评价
            </h3>

            <div class="ep_summary" style="border: 0">
                <div id="lists">
                    <c:forEach var="item" items="${lists}">
                        <div class="ep_summary_p">
                            昵称：${item.username}
                            <hr/>
                            评论内容：${item.cfbCContent}
                            <hr/>
                            评论时间：${item.cfbCPosted}
                                <%--<input class='winbutton' type='button' value='中标'--%>
                                <%--onclick="javascript:widBids('${item.cfbId}','${item.userId}');">--%>
                        </div>
                    </c:forEach>

                    <div class="foot" style="float: right;">
                        <div class="right">
                            <div class="pager" id="pager">
                                ${pageTools}
                            </div>
                        </div>
                    </div>
                    <c:if test="${msg!=null&&msg.role_id==3}">
                        <h3 id="hideH3"
                            style="text-indent: 0em;width: 70%;margin-bottom:0;color: #000000;font-size: 22px;">
                            评论
                        </h3>
                    </c:if>
                </div>
                <c:if test="${msg!=null&&msg.role_id==3}">
                    <p>

                    <form method='post' id="form" name="form" action="/ajax/respondBidsComment.action">
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
        <s:action name="right" namespace="/static" executeResult="true">
        </s:action>
    </div>
</div>
<%@ include file="/static/footer.jsp" %>


<script type="text/javascript">

    /**
     *   提交评论
     */
    function submitComment() {
        var content = editor.html();
        var detail = editor.html().replace(" ", "");
        if (detail == null || !detail || detail == "") {
            alert("请输入内容");
            return false;
        }
        var cfbId = $("#cfbId").val();
        var jsonData = {content:content, cfbId:cfbId};
        var htmlobj = $.ajax({
            url:"/bids/respondBidsComment.action",
            data:jsonData,
            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
            processData:true,
            cache:false,
            async:false
        });
        $("#lists").html(htmlobj.responseText);
        editor.html("");
    }

    function getPage(page) {
        var cfbId = $("#cfbId").val();
        var jsonData = {pageNumber:page, cfbId:cfbId};
        var htmlobj = $.ajax({url:"/bids/bidsReview.action", data:jsonData, cache:false, async:false});
        $("#lists").html(htmlobj.responseText);
        hideKindEditor();
    }

    window.onload = hideKindEditor;

    function hideKindEditor() {
        var cfbStatus = $("#cfbStatus").val();
        if (cfbStatus == '1') {
            $("#hideH3").hide();
            $("#form").hide();
        }
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
