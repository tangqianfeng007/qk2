<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="com.qk.bean.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    ////登陆 验证
    User u = (User) ActionContext.getContext().getSession().get("msg");
    if (u == null) {
        response.sendRedirect("/index.action");
    }
%>
<div>
    <input id="cfbStatus" name="cfbStatus" type="hidden" value="${statusFlag}"/>
    <input id="flag" name="flag" type="hidden" value="${flag}"/>
    <c:forEach var="item" items="${lists}">
        <div class="ep_summary_p">
            昵称：${item.username}
            <hr/>
            评论内容：${item.cfbCContent}
            <hr/>
            评论时间：${item.cfbCPosted}
            <c:if test="${msg!=null}">
                <%--当评论的人是企业家自己时或者是标已经中标了之后应该去掉中标--%>
                <c:if test="${(item.userId!=msg.id)}">
                    <c:if test="${(item.cfbStatus!=1)}">
                        <input class='winbutton' type='button' value='中标'
                               onclick="winBids('${item.cfbId}','${item.userId}');">
                    </c:if>
                </c:if>
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

<c:if test="${msg!=null}">
    <%--当评论的人是企业家自己时或者是标已经中标了之后应该去掉中标--%>
    <c:if test="${(item.userId!=msg.id)||(item.cfbStatus=='1')}">
        <h3 id="hideH3" name="hideH3"
            style="text-indent: 0em;width: 70%;margin-bottom:0;color: #000000;font-size: 22px;">
            评论
        </h3>
    </c:if>
</c:if>
