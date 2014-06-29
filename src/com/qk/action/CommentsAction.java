package com.qk.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qk.bean.SiteCommentBean;
import com.qk.bean.User;
import com.qk.common.Page;
import com.qk.common.PageTool;
import com.qk.common.Tools;
import com.qk.dao.DaoFactory;
import com.qk.dao.SiteCommentDao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-8
 * Time: 下午4:19
 * To change this template use File | Settings | File Templates.
 */
public class CommentsAction extends ActionSupport {
    private int id;
    private SiteCommentBean sc;
    private String scTitle = null;
    private String scContent = null;
    private String scRemark = null;
    private String responseMsg = "0";


    /**
     * pageNumber代表是哪一页
     * pageSize代表一页中显示多少条数据
     */
    private int pageNumber = 1;
    private int pageSize = 10;
    private List<SiteCommentBean> list = null;
    private String pageTools = null;

    public String get() {
        if (id > 0) {
            DaoFactory.siteCommentDao.updateClickCount(1, id);
            sc = DaoFactory.siteCommentDao.infoFindById(id);
        }
        return SUCCESS;
    }

    public String getCommentsList() {
        SiteCommentDao siteCommentDao = DaoFactory.siteCommentDao;
        int count = siteCommentDao.getCount(0);
        list = siteCommentDao.getList(pageNumber, pageSize, 0);
        Page page = new Page(pageNumber, count, pageSize, list);
        PageTool pt = new PageTool();
        pageTools = pt.getPageString("/comments/getCommentsList.action", page);
        return SUCCESS;
    }

    public String getPersonCommentsList() {
        User user = (User) ActionContext.getContext().getSession().get("msg");
        int useid = user.getId();
        SiteCommentDao siteCommentDao = DaoFactory.siteCommentDao;
        int count = siteCommentDao.getCount(useid);
        list = siteCommentDao.getList(pageNumber, pageSize, useid);
        Page page = new Page(pageNumber, count, pageSize, list);
        PageTool pt = new PageTool();
        pageTools = pt.getPageString("/comments/getCommentsList.action", page);
        return "success";
    }

    public String insertComments() {
        SiteCommentDao siteCommentDao = DaoFactory.siteCommentDao;
        User user = (User) ActionContext.getContext().getSession().get("msg");
        SiteCommentBean siteCommentBean = new SiteCommentBean();
        siteCommentBean.setScTitle(scTitle);
        siteCommentBean.setScContent(scContent);
        siteCommentBean.setScRemark(scRemark);
        siteCommentBean.setScPosted(Tools.getNowDate());
        siteCommentBean.setUserId(user.getId());
        siteCommentBean.setScCount(0);
        int key = siteCommentDao.insertSiteCommentBean(siteCommentBean);
        if (key > 0) {
            responseMsg = "1";
        } else {
            responseMsg = "-1";
        }
        return "insertComments";
    }

    public String deleteComments() {
        SiteCommentDao siteCommentDao = DaoFactory.siteCommentDao;
        int count = siteCommentDao.getCount(0);
        list = siteCommentDao.getList(pageNumber, pageSize, 0);
        Page page = new Page(pageNumber, count, pageSize, list);
        PageTool pt = new PageTool();
        pageTools = pt.getPageString("/comments/getCommentsList.action", page);

        int key = siteCommentDao.deleteCommentBean(id);
        if (key > 0) {
            responseMsg = "1";
        } else {
            responseMsg = "-1";
        }
        return "deleteComments";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SiteCommentBean getSc() {
        return sc;
    }

    public void setSc(SiteCommentBean sc) {
        this.sc = sc;
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

    public List<SiteCommentBean> getList() {
        return list;
    }

    public void setList(List<SiteCommentBean> list) {
        this.list = list;
    }

    public String getPageTools() {
        return pageTools;
    }

    public void setPageTools(String pageTools) {
        this.pageTools = pageTools;
    }

    public String getScTitle() {
        return scTitle;
    }

    public void setScTitle(String scTitle) {
        this.scTitle = scTitle;
    }

    public String getScContent() {
        return scContent;
    }

    public void setScContent(String scContent) {
        this.scContent = scContent;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getScRemark() {
        return scRemark;
    }

    public void setScRemark(String scRemark) {
        this.scRemark = scRemark;
    }
}
