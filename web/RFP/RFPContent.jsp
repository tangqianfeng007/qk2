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
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/cutter.css">

    <script src="/js/jquery.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/json.min.js" type="text/javascript"></script>
    <script src="/js/jquery.json-2.2.min.js" type="text/javascript"></script>
    <script src="/js/teamManage.js"></script>
    <script src="/js/cutter.js"></script>
    <script src="/js/placeholder2.js"></script>
    <script src="/js/selectBar.js"></script>
    <script charset="utf-8" src="/js/kindeditor-4.1.1/kindeditor-min.js"></script>
    <script charset="utf-8" src="/js/kindeditor-4.1.1/lang/zh_CN.js"></script>
    <script type="text/javascript">
        function aa() {
            selectLeft(3, 3);//选择坐标菜单
        }
        window.onload = aa;
    </script>
</head>


<%
    ////登陆 验证
    User u = (User) ActionContext.getContext().getSession().get("msg");
    if (u == null) {
        response.sendRedirect("/index.action");
    }
%>

<body>
<%@ include file="/static/header.jsp" %>
<div class="wrapper">
    <div class="row" style="margin-left: 0">
        <jsp:include page="/static/left.jsp"></jsp:include>
        <div class="seven" id="centerArea">
            <div>
                <h1 class="ep_h1" style="width: 70%;display: inline-block;">
                    团队招标名称：${rfpInfoBean.rfpInfoTitle}
                    <%--有团队 --%>
                    <input name="vtId" type="hidden" value="${virtualTeamBean.vtId}" id="vtId">
                    <input name="rfpUserId" type="hidden" value="${rfpInfoBean.userId}" id="rfpUserId">
                    <input name="userId" type="hidden" value="<%=u.getId()%>" id="userId">
                    <c:if test="${rfpInfoBean.userId == msg.id}">
                        <c:choose>
                            <c:when test="${virtualTeamBean.vtId > 0}">
                                <span><input class="button" type="button" value="团队人员管理" id="manageMembers"/>
                                </span>
                            </c:when>
                            <c:otherwise>
                                <span><input class="button" type="button" id="createTeam" value="创建团队"></span>
                            </c:otherwise>
                        </c:choose>
                    </c:if>

                </h1>

            </div>
            <div class="ep_summary">
                <p>
                    招标关键字：${rfpInfoBean.rfpInfoKey}
                </p>

                <p>
                    招标类型：${rfpInfoBean.rfpInfoType}
                </p>

                <p>
                    发布招标时间：${rfpInfoBean.rfpInfoPosted}
                </p>

                <p>
                    发布人姓名：${rfpInfoBean.userName}
                </p>

                <p>
                    招标内容：${rfpInfoBean.rfpInfoContent}
                </p>
                <input type="hidden" name="rfpInfoId" id="rfpInfoId" value="${rfpInfoBean.rfpInfoId}">
            </div>

            <h3 class="ep_h1" style="width: 70%;display: inline-block;">
                评价
            </h3>

            <div class="ep_summary" style="border: 0">
                <div id="lists">
                    <c:forEach var="item" items="${commentList}">
                        <div class="ep_summary_p">
                            昵称：${item.userName}
                            <c:if test="${rfpInfoBean.userId == item.userId}">
                                <span style="background-color: #49494e;color: #ffffff">RFP发布者</span>
                            </c:if>
                            <hr/>
                            评论内容：${item.ricContent}
                            <hr/>
                            评论时间：${item.ricPosted}
                                <%--如果是本人的招标信息，则可以显示添加删除按钮--%>
                            <c:if test="${rfpInfoBean.userId == msg.id}">
                                <span class='act${virtualTeamBean.vtId}${item.userId}'>
                                           <c:choose>
                                               <%--已经加入团队中--%>
                                               <c:when test="${item.status==1}">
                                                   <input class='winbutton blackBackground' type='button' value='移出'
                                                          onclick="delOneMember('${virtualTeamBean.vtId}','${item.userId}');">
                                               </c:when>
                                               <c:otherwise>
                                                   <input class='winbutton' type='button' value='加入'
                                                          onclick="addOneMember('${virtualTeamBean.vtId}','${item.userId}',this);">
                                               </c:otherwise>
                                           </c:choose>
                                </span>
                            </c:if>

                        </div>
                    </c:forEach>
                </div>

                <div class="foot" style="float: right;">
                    <div class="right">
                        <div class="pager" id="pager">
                            ${pageTools}
                        </div>
                    </div>
                </div>

                <s:if test="#session.msg!=null && #session.msg.role_id==3">
                    <h3 style="text-indent: 0em;width: 70%;margin-bottom:0;color: #000000;font-size: 22px;">
                        评论
                    </h3>

                    <p>

                    <form method='post' id="form" name="form" action="/ajax/respondRFPComment.action">
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
                </s:if>

            </div>
        </div>
        <s:action name="right" namespace="/static" executeResult="true">
        </s:action>
    </div>
</div>
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">创建团队</h3>
    </div>
    <div class="modal-body">
        <form action="" name="createTeamForm" id="createTeamForm" method="post">
            <table style="width: 548px;margin-top: 0px;">
                <tr>
                    <td style="width: 25%">虚拟团队名：</td>
                    <td>
                        <input type="hidden" name="virtualTeamBean.rfpInfoId" value="${rfpInfoBean.rfpInfoId}">
                        <input name="virtualTeamBean.vtName" id="vtName" placeholder="请输入虚拟团队名" class="g-ipt"
                               style="width:80%;border:0;height: 20px;"/>
                    </td>
                </tr>
                <tr>
                    <td>虚拟团队标签：</td>
                    <td><input name="virtualTeamBean.vtNote" placeholder="请输入虚拟团队标签" class="g-ipt"
                               style="color:#7d7f89;border:0;width:80%;height: 20px;"/>
                    </td>
                </tr>

            </table>
        </form>
    </div>
    <div class="modal-footer">
        <button class="btn btn-primary" id="createSubmit">提交</button>
        <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
    </div>
</div>

<div id="myModal2" class="modal hide fade" style="width: 810px;left: 570px;" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel2" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel2">人员管理</h3>
    </div>
    <div class="modal-body" id="memberList">

    </div>
    <div class="modal-footer">
        <button class="btn btn-primary" id="changeMember">保存</button>
        <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>

    </div>
</div>

<%@ include file="/static/footer.jsp" %>
<script type="text/javascript">
/**
 * 提交评论
 */
function submitComment() {
    var content = editor.html();
    var rfpInfoId = $("#rfpInfoId").val();
    var jsonData = {content:content, id:rfpInfoId};
    jQuery.ajax({
        type:'post',
        url:'/ajax/respondRFPComment.action',
        processData:true,
        async:true,
        dataType:'html',
        data:jsonData,
        success:function (data) {
            alert("评论成功");
            location.reload();
//            data = jQuery.parseJSON(data);
//            $("#pager").html(data.pageTools);
//            var retStr = "";
//            for (var i = 0; i < data.commentList.length; i++) {
//                var inp = "";
//                var rfpUserId = $("#rfpUserId").val();
//                var userId = $("#userId").val();
//                var mySpan = "";
//                //判断这个rfp是否属于本人
//                if (rfpUserId == userId) {
//                    if (data.commentList[i].status != 1)//未加入
//                    {
//                        var method = "addOneMember(" + data.virtualTeamBean.vtId + "," + data.commentList[i].userId + ",this);"
//                        inp = "<input class='winbutton' type='button' value='加入' onclick='" + method + "'>";
//                    }
//                    else {
//                        var method = "delOneMember(" + data.virtualTeamBean.vtId + "," + data.commentList[i].userId + ",this);"
//                        inp = "<input class='winbutton blackBackground' type='button' value='移出' onclick='" + method + "'>";
//                    }
//
//                    mySpan = "<span class='act" + data.virtualTeamBean.vtId + data.commentList[i].userId + "'>" + inp + "</span>";
//                }
//                var tipspan = "";
//                if (data.commentList[i].userId == rfpUserId) {
//                    tipspan = "<span style='background-color: #49494e;color: #ffffff'>RFP发布者</span>"
//                }
//
//                retStr = retStr + "<div class='ep_summary_p'>昵称：" + data.commentList[i].userName + tipspan + " <hr/>" +
//                        "                             评论内容：" + data.commentList[i].ricContent + "\n" +
//                        "                             <hr/>\n" +
//                        "                             评论时间：" + data.commentList[i].ricPosted + "\n" +
//                        mySpan +
//                        "                          </div>"
//                "</div>";
//            }
//            $("#lists").html(retStr);
            editor.html("");
        },
        error:function () {
            alert("服务器繁忙中！稍后再试！");
        }
    });
}

//获取评论分页
function getPage(page) {
    var rfpInfoId = $("#rfpInfoId").val();
    jQuery.ajax({
        type:'get',
        url:'/ajax/RFPCommentPage.action?pageNumber=' + page + "&id=" + rfpInfoId,
        processData:true,
        async:true,
        dataType:'html',
        success:function (data) {
            data = jQuery.parseJSON(data);
            //alert(data.pageTools);
            //alert(data.pageTools2);
            $("#pager").html(data.pageTools2);
            var retStr = "";
            for (var i = 0; i < data.commentList.length; i++) {
                var inp = "";
                var rfpUserId = $("#rfpUserId").val();
                var userId = $("#userId").val();
                var mySpan = "";
                //判断这个rfp是否属于本人
                if (rfpUserId == userId) {
                    if (data.commentList[i].status != 1)//未加入
                    {
                        var method = "addOneMember(" + data.virtualTeamBean.vtId + "," + data.commentList[i].userId + ",this);"
                        inp = "<input class='winbutton' type='button' value='加入' onclick='" + method + "'>";
                    }
                    else {
                        var method = "delOneMember(" + data.virtualTeamBean.vtId + "," + data.commentList[i].userId + ",this);"
                        inp = "<input class='winbutton blackBackground' type='button' value='移出' onclick='" + method + "'>";
                    }

                    mySpan = "<span class='act" + data.virtualTeamBean.vtId + data.commentList[i].userId + "'>" + inp + "</span>";
                }

                var tipspan = "";
                if (data.commentList[i].userId == rfpUserId) {
                    tipspan = "<span style='background-color: #49494e;color: #ffffff'>RFP发布者</span>"
                }
                retStr = retStr + "<div class='ep_summary_p'>昵称：" + data.commentList[i].userName + tipspan + " <hr/>" +
                        "                             评论内容：" + data.commentList[i].ricContent + "\n" +
                        "                             <hr/>\n" +
                        "                             评论时间：" + data.commentList[i].ricPosted + "\n" +
                        mySpan +
                        "                          </div>"
                "</div>";
            }
            $("#lists").html(retStr);
        },
        error:function () {
            alert("服务器繁忙中！稍后再试！");
        }
    });
}


/**
 * 加入一个成员
 */
function addOneMember(teamId, actUserId, obj) {
    if (teamId > 0) {
        jQuery.ajax({
            type:'post',
            url:"/ajax/addRFPMember.action",
            processData:true,
            async:true,
            data:{teamId:teamId, actUserId:actUserId},
            dataType:'html',
            success:function (data) {
                data = jQuery.parseJSON(data);
                if (data.status == 1)//成功
                {
                    alert("添加成功");
                    var spanList = $(".act" + teamId + "" + actUserId);
                    var method = "delOneMember(" + teamId + "," + actUserId + ",this);"
                    var str = "<input class='winbutton blackBackground' type='button' value='移出' onclick='" + method + "'>";
                    $(spanList).each(function () {
                        $(this).html(str);
                    });
                }
                else if (data.status == 0) {
                    alert("添加失败，可能是您还未创建团队，请先创建团队！");
                }
                else {
                    alert("添加失败" + data.status);
                }
            },
            error:function () {
                alert("服务器繁忙中！稍后再试！");
            }
        });
    }
    else {
        alert("请先创建团队，然后再添加成员！");
    }

}
function delOneMember(teamId, actUserId, obj) {
    if (teamId > 0) {
        jQuery.ajax({
            type:'post',
            url:"/ajax/delRFPMember.action",
            processData:true,
            async:true,
            data:{teamId:teamId, actUserId:actUserId},
            dataType:'html',
            success:function (data) {
                data = jQuery.parseJSON(data);
                if (data.status == 1)//成功
                {
                    alert("移出成功");
                    var spanList = $(".act" + teamId + "" + actUserId);
                    var method = "addOneMember(" + teamId + "," + actUserId + ",this);"
                    var str = "<input class='winbutton' type='button' value='加入' onclick='" + method + "'>";
                    $(spanList).each(function () {
                        $(this).html(str);
                    });
                }
                else if (data.status == 0) {
                    alert("移出失败，可能是您还未创建团队");
                }
                else if (data.status == -10) {
                    alert("该人员是团队创建人员，不能删除");
                }
                else {
                    alert("移出失败" + data.status);
                }
            },
            error:function () {
                alert("服务器繁忙中！稍后再试！");
            }
        });
    }
    else {
        alert("您还没有自己的团队！");
    }
    return false;
}


</script>

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
