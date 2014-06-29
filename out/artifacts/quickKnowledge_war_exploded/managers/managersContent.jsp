<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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
</head>

<body>
<%
    User u = (User) ActionContext.getContext().getSession().get("msg");
    if (u == null || u.getRole_id() != 1) {
        response.sendRedirect("/index.action");
    }
%>
<%@ include file="/static/header.jsp" %>
<div class="wrapper">
    <div class="row">
        <jsp:include page="/static/left.jsp"></jsp:include>

        <script type="text/javascript">
            function aa() {
                selectBar(7);//使第一个菜单被选中
            }
            window.onload = aa;
        </script>
        <div class="seven" id="centerArea">
            <div>
                <h1 class="ep_h1" style="width: 70%;display: inline-block;">
                    ${user.username}
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

            <div id="lists">

            </div>

            <div class="foot" style="float: right;">
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


<script type="text/javascript">
    /**
     * 数据获取
     */
    function getPage(page) {
        jQuery.ajax({
            type:'get',
            url:'/ajax/bidsReview.action?pageNumber=' + page,
            processData:true,
            async:true,
            dataType:'html',
            success:function (data) {
                data = jQuery.parseJSON(data);
                $("#lists").html(data.lists);
            },
            error:function () {
                alert("服务器繁忙中！稍后再试！");
            }
        });
    }

    jQuery(function ($) {
        updateBodyDivHeight();
        $(window).resize(function () {
            updateBodyDivHeight();
        });
    });

    function updateBodyDivHeight() {
        jQuery(".body-table-div").height(jQuery(".fanwe-body").height() - 36);
        if (jQuery(".body-table-div").get(0).scrollHeight > jQuery(".body-table-div").height()) {
            var width = jQuery(".body-table-div").width() - 16;
            jQuery(".body-table-div > *").each(function () {
                if (!$(this).hasClass('ajax-loading')) {
                    $(this).width(width)
                }
            });
        }
    }

</script>
<c:if test="${not empty msg}">
    <script type="text/javascript">
        art.dialog({
            id:"msg",
            title:"提示",
            time:2000,
            content:"${msg}"
        });
    </script>
</c:if>


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
            items:[
                'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                'insertunorderedlist', '|', 'emoticons', 'image', 'link', '|', 'flash', 'media', 'insertfile'],
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

<script type="text/javascript">

    function popupDivOpen() {
        var dialog = art.dialog({
            id:"newsFocusPic",
            title:"选择文件上传",
            width:300,
            height:200,
            lock:true,
            content:"<div style='width:250;'><input type='file' name='file'/> </div>" +
                    "<div id=''><img src=''/></div>" +
                    "<div style='width:250;'><input id='fileUploadButton' type='submit' value='确认上传'/></div>",
            ok:function () {
            },
            okValue:"确定"
        })
    }

    function upFocusImgBack(msg) {
        alert(msg);
    }

    $("#fileUploadButton").click(function () {
        alert("click fileUploadButton");
        $.upload({
            url:'/newsManage/up.do',
            fileName:'file',
            dataType:'json',
            onSend:function () {
                return true;
            },
            onComplate:function (data) {
                alert(data);
            }
        });
    });

</script>

<script type="text/javascript">
    function uploadComplete() {
        if (this.getStats().files_queued > 0) {
            this.startUpload();
        } else {
            cancelUpload();
            $("#divFileProgressContainer").html("所有文件上传完毕")
        }
    }

    function fileDialogComplete() {
        if ($("#focusSrc").attr("value") != "") {
            alert("只能上传一张图片");
            return;
        }
        swfu.startUpload();
    }

    function uploadSuccess(file, serverdata) {
        if (serverdata == 0) {
            alert("上传失败，请重试！");
            return;
        }
        var imgStr = "<div id='" + serverdata + "'><img onload=\"javascript:if(this.width>100||this.width<100)this.width=100;if(this.height>100||this.height<100) this.height=100;\" src='" + serverdata + "'/>";
        var deleteLink = "<a href='#' onclick=\"removeImg('" + serverdata + "')\">删除</a></div>";
        $("#imgDiv").append(imgStr + deleteLink);
        $("#focusSrc").attr("value", serverdata);
    }

    function removeImg(picDivId) {
        var picDiv = document.getElementById(picDivId);
        picDiv.parentNode.removeChild(picDiv);

        $("#focusSrc").attr("value", "");
    }
</script>

<script type="text/javascript">
    function setInterrelateNews() {
        window.open("/newsManage/interrelateNewsList.do", "test",
                "top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=n o, status=no");
    }

    function checkPic(id) {
        var src = $("#focusSrc").val();
        if (src == null || src == "") {
            alert("当前新闻没有图片，不能设为图片新闻！");
            id.checked = false;
            $("#notPicRadio").attr("checked", true);
        }
    }
</script>
</body>
</html>