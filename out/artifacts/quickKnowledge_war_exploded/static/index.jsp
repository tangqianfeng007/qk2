<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<div style="margin-bottom: 15px">
    <div style="height: 200px">
        <h2>新闻</h2>

        <s:iterator value="#request.newsList" status="statu" id="item">
            <h2>
                <small>
                                <span class="index_title overflow">
                                    <a href="/news/get.action?id=<s:property value="newsId" />"><s:property
                                            value="newsTitle"/></a>
                                </span>

                                <span class="content_attach"
                                      style="display: inline-block;width: 200px;overflow: hidden">
                                    <s:property value="username"/>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
                                    <s:property value="newsPosted"/>
                                </span>

                </small>
            </h2>
        </s:iterator>
    </div>

    <div class="content_more"><span><a href="/news/getNewsList.action">更多···</a></span></div>
    <hr style="width: 605px;"/>
</div>

<div style="margin-bottom: 25px">
    <div style="height: 200px">
        <h2>活动</h2>

        <s:iterator value="#request.eventList" status="statu" id="item">
            <h2>
                <small>
                                <span class="index_title overflow">
                                    <a href="/events/get.action?id=<s:property value="eventId" />"><s:property
                                            value="eventTitle"/></a>
                                </span>
                                <span class="content_attach"
                                      style="display: inline-block;width: 200px;overflow: hidden">
                                    <s:property value="username"/>
                                    &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
                                    <s:property value="eventPosted"/>
                                </span>

                </small>
            </h2>
        </s:iterator>
    </div>
    <div class="content_more"><span><a href="/events/getEventsList.action">更多···</a></span></div>
    <hr style="width: 605px;"/>
</div>

<div style="margin-bottom: 25px">
    <div style="height: 200px">
        <h2>出版物</h2>

        <s:iterator value="#request.publicationsList" status="statu" id="item">
            <h2>
                <small>
                        <span class="index_title overflow">
                            <a href="/pubs/get.action?id=<s:property value="pubId" />"><s:property
                                    value="pubTitle"/></a>
                        </span>
                                <span class="content_attach"
                                      style="display: inline-block;width: 200px;overflow: hidden">
                                    <s:property value="username"/>
                                    &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
                                    <s:property value="pubPosted"/>
                                </span>

                </small>
            </h2>
        </s:iterator>
    </div>

    <div class="content_more"><span><a href="/pubs/getPubsList.action">更多···</a></span></div>
    <hr style="width: 605px;"/>
</div>