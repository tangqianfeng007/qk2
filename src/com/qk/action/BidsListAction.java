package com.qk.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qk.bean.CallforbitAndUserBean;
import com.qk.bean.CallforbitBean;
import com.qk.bean.CfbCommentBean;
import com.qk.bean.User;
import com.qk.common.Page;
import com.qk.common.PageTool;
import com.qk.dao.CallforbitDao;
import com.qk.dao.CfbCommentDao;
import com.qk.dao.DaoFactory;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 招标列表
 */
public class BidsListAction extends ActionSupport {

    /**
     * pageNumber代表是哪一页
     * pageSize代表一页中显示多少条数据
     */
    private int pageNumber = 1;
    private int pageSize = 12;
    private List<CallforbitBean> list = null;
    private String pageTools = null;
    private Integer cfbId;
    private CallforbitBean callforbitBean = null;
    private List<CfbCommentBean> lists = null;
    private String cfbStatus = null;
    private CallforbitAndUserBean callforbitAndUserBean = null;
    private String noticeType = "0";

    public String bidsList() {

        User user = (User) ActionContext.getContext().getSession().get("msg");

        CallforbitDao callforbitDao = DaoFactory.callforbitDao;
        int count = callforbitDao.getCallforbitCount();
        List<CallforbitBean> list = callforbitDao.getAllCallforbitBean(pageNumber, pageSize);
        Page page = new Page(pageNumber, count, pageSize, list);
        PageTool pt = new PageTool();
        this.pageTools = pt.getPageString("/bids/bidsAll!bidsList.action", page);
        this.list = page.getResult();
        return "bidList";
    }


    public String bidsContent() {
        User user = (User) ActionContext.getContext().getSession().get("msg");

        CallforbitDao callforbitDao = DaoFactory.callforbitDao;
        callforbitBean = callforbitDao.getCallforbitBycfbId(cfbId);

        CfbCommentDao cfbCommentDao = DaoFactory.cfbCommentDao;

        cfbStatus = callforbitBean.getCfbStatus();
        int count = cfbCommentDao.getCfbCommentCount(cfbId);
        List<CfbCommentBean> list = cfbCommentDao.getCfbCommentBycfbId(pageNumber, 6, cfbId);
        Page page = new Page(pageNumber, count, 6, list);
        PageTool pt = new PageTool();
        this.pageTools = pt.getPageStringForjs("/bids/bidsReview.action", page);
        this.lists = page.getResult();
        return "bidsContent";
    }


    public String bidsNoticeList() {
        User user = (User) ActionContext.getContext().getSession().get("msg");
        CallforbitDao callforbitDao = DaoFactory.callforbitDao;
        int count = callforbitDao.getCallforbitCountByUserAndStatus(user);

        List<CallforbitBean> list = callforbitDao.getAllCallforbitBeanByStatus(pageNumber, pageSize, user, noticeType);
        Page page = new Page(pageNumber, count, pageSize, list);
        PageTool pt = new PageTool();
        this.pageTools = pt.getPageString("/bids/bidsNoticeList.action", page);
        this.list = page.getResult();
        return "noticeList";
    }

    public String bidsNotice() {
        User user = (User) ActionContext.getContext().getSession().get("msg");
        CallforbitDao callforbitDao = DaoFactory.callforbitDao;
        callforbitAndUserBean = callforbitDao.getCallforbitByStatus(cfbId);
        return "notice";
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

    public List<CallforbitBean> getList() {
        return list;
    }

    public void setList(List<CallforbitBean> list) {
        this.list = list;
    }

    public String getPageTools() {
        return pageTools;
    }

    public void setPageTools(String pageTools) {
        this.pageTools = pageTools;
    }

    public Integer getCfbId() {
        return cfbId;
    }

    public void setCfbId(Integer cfbId) {
        this.cfbId = cfbId;
    }

    public CallforbitBean getCallforbitBean() {
        return callforbitBean;
    }

    public void setCallforbitBean(CallforbitBean callforbitBean) {
        this.callforbitBean = callforbitBean;
    }

    public List<CfbCommentBean> getLists() {
        return lists;
    }

    public void setLists(List<CfbCommentBean> lists) {
        this.lists = lists;
    }

    public String getCfbStatus() {
        return cfbStatus;
    }

    public void setCfbStatus(String cfbStatus) {
        this.cfbStatus = cfbStatus;
    }

    public CallforbitAndUserBean getCallforbitAndUserBean() {
        return callforbitAndUserBean;
    }

    public void setCallforbitAndUserBean(CallforbitAndUserBean callforbitAndUserBean) {
        this.callforbitAndUserBean = callforbitAndUserBean;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }
}