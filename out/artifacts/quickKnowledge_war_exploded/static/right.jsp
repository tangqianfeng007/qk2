<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<div class="three">
    <h4><img src="/images/up_alt.png" alt="" class="imgHot"/>活动前五排行榜</h4>

    <div class="bordered">
        <ul>

            <s:iterator value="#request.eventList" status="statu" id="item">
                <li>
                    <span class="top_title"><a href="/events/get.action?id=<s:property value="eventId" />"><s:property
                            value="eventTitle"/></a></span>
                <span class="point_num">点击数：<s:property value="eventCount"/>
                </span>
                </li>
            </s:iterator>
        </ul>
    </div>


    <h4><img src="/images/up_alt.png" alt="" class="imgHot"/>出版物前五排行榜</h4>

    <div class="bordered">
        <ul>
            <s:iterator value="#request.pubList" status="statu" id="item">
                <li>
                    <span class="top_title"><a href="/pubs/get.action?id=<s:property value="pubId" />"><s:property
                            value="pubTitle"/></a></span>
                <span class="point_num">点击数：<s:property value="pubCount"/>
                </span>
                </li>
            </s:iterator>

        </ul>
    </div>
    <h4><img src="/images/up_alt.png" alt="" class="imgHot"/> 专家前五排行榜</h4>

    <div class="bordered">
        <ul>

            <s:iterator value="#request.expertList" status="statu" id="item">
                <li>
                    <span class="top_title"><a href="/enterpriseToExperts/commentsList.action?id=<s:property value="Id" />"><s:property
                            value="username"/></a></span>
                <span class="point_num">热度：<s:property value="hot_value"/>
                </span>
                </li>
            </s:iterator>

        </ul>
    </div>

    <h4><img src="/images/up_alt.png" alt="" class="imgHot"/>站点评论</h4>

    <div class="bordered">
        <ul>
            <s:iterator value="#request.comList" status="statu" id="item">
                <li>
                    <span class="top_title"><a href="/comments/get.action?id=<s:property value="scId" />"><s:property
                            value="scTitle"/></a></span>
                <span class="point_num">点击数：<s:property value="scCount"/>
                </span>
                </li>
            </s:iterator>
        </ul>
    </div>
</div>
