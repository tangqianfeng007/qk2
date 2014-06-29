package com.qk.action;

import com.opensymphony.xwork2.ActionSupport;
import com.qk.bean.EventBean;
import com.qk.bean.PublicationsBean;
import com.qk.bean.QkNewsBean;
import com.qk.bean.User;
import com.qk.common.Page;
import com.qk.common.PageTool;
import com.qk.dao.DaoFactory;
import com.qk.dao.EventDao;
import com.qk.dao.NewsDao;
import com.qk.dao.PublicationDao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zheng
 * Date: 13-8-7
 * Time: 上午11:51
 * To change this template use File | Settings | File Templates.
 */
public class IndexAction extends ActionSupport {
    private List<QkNewsBean> newsList;
    private List<EventBean> eventList;
    private List<PublicationsBean> publicationsList;

    public String index() {
        NewsDao newsDao = DaoFactory.newsDao;
        newsList = newsDao.getList(1, 4, 0);

        EventDao eventDao = DaoFactory.eventDao;
        eventList = eventDao.getList(1, 4, 0);

        PublicationDao publicationDao = DaoFactory.publicationDao;
        publicationsList = publicationDao.getList(1, 4, 0);
        return SUCCESS;
    }

    public List<QkNewsBean> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<QkNewsBean> newsList) {
        this.newsList = newsList;
    }

    public List<EventBean> getEventList() {
        return eventList;
    }

    public void setEventList(List<EventBean> eventList) {
        this.eventList = eventList;
    }

    public List<PublicationsBean> getPublicationsList() {
        return publicationsList;
    }

    public void setPublicationsList(List<PublicationsBean> publicationsList) {
        this.publicationsList = publicationsList;
    }
}
