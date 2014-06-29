package com.qk.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qk.bean.QkNewsBean;
import com.qk.bean.User;
import com.qk.common.Page;
import com.qk.common.PageTool;
import com.qk.dao.DaoFactory;
import com.qk.dao.NewsDao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zheng
 * Date: 13-8-7
 * Time: 上午11:51
 * To change this template use File | Settings | File Templates.
 */
public class NewsAction extends ActionSupport {
    private int id;
    private QkNewsBean news;

    /**
     * pageNumber代表是哪一页
     * pageSize代表一页中显示多少条数据
     */
    private int pageNumber = 1;
    private int pageSize = 10;
    private List<QkNewsBean> list = null;
    private String pageTools = null;

    public String get() {
        if (id > 0) {
            news = DaoFactory.newsDao.infoFindById(id);
        }
        return SUCCESS;
    }


    public String getNewsList() {
        NewsDao newsDao = DaoFactory.newsDao;
        int count = newsDao.getCount(0);
        list = newsDao.getList(pageNumber, pageSize, 0);
        Page page = new Page(pageNumber, count, pageSize, list);
        PageTool pt = new PageTool();
        pageTools = pt.getPageString("/news/getNewsList.action", page);
        return SUCCESS;
    }

    public String getPersonNewsList() {
        User user = (User) ActionContext.getContext().getSession().get("msg");
        int uid = user.getId();
        NewsDao newsDao = DaoFactory.newsDao;
        int count = newsDao.getCount(uid);
        list = newsDao.getList(pageNumber, pageSize, uid);
        Page page = new Page(pageNumber, count, pageSize, list);
        PageTool pt = new PageTool();
        pageTools = pt.getPageString("/news/getNewsList.action", page);
        return SUCCESS;
    }

    public String newsChange() {
        news = DaoFactory.newsDao.infoFindById(id);
        return "success";
    }

    public String deleteNews() {
        User user = (User) ActionContext.getContext().getSession().get("msg");
        QkNewsBean qkNewsBean = DaoFactory.newsDao.infoFindById(id);
        if (user.getId() == qkNewsBean.getUserId() || user.getRole_id()==1) {
            DaoFactory.newsDao.deleteNews(id);
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public QkNewsBean getNews() {
        return news;
    }

    public void setNews(QkNewsBean news) {
        this.news = news;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageTools() {
        return pageTools;
    }

    public void setPageTools(String pageTools) {
        this.pageTools = pageTools;
    }

    public List<QkNewsBean> getList() {
        return list;
    }

    public void setList(List<QkNewsBean> list) {
        this.list = list;
    }
}
