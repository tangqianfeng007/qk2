package com.qk.action.enterprise;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qk.bean.CallforbitBean;
import com.qk.bean.CfbCommentBean;
import com.qk.bean.User;
import com.qk.common.Page;
import com.qk.common.PageTool;
import com.qk.common.Tools;
import com.qk.dao.BitResultDao;
import com.qk.dao.CallforbitDao;
import com.qk.dao.CfbCommentDao;
import com.qk.dao.DaoFactory;

import java.util.List;

/**
 * 招标列表
 */
public class EnterpriseBidsListReview extends ActionSupport {

    /**
     * pageNumber代表是哪一页
     * pageSize代表一页中显示多少条数据
     */
    private int pageNumber = 1;
    private int pageSize = 6;
    private String pageTools = null;
    private Integer cfbId;
    private List<CfbCommentBean> lists = null;
    private String content = null;
    private Integer statusFlag = null;
    private Integer userId;
    private Boolean flag = false;


    public String enterpriseBidsReview() {
        User user = (User) ActionContext.getContext().getSession().get("msg");
        CallforbitDao callforbitDao = DaoFactory.callforbitDao;
        CfbCommentDao cfbCommentDao = DaoFactory.cfbCommentDao;
        int count = cfbCommentDao.getCfbCommentCountByUser(cfbId, user);
        List<CfbCommentBean> list = cfbCommentDao.getCfbCommentBycfbIdAndUser(pageNumber, 6, cfbId, user);
        Page page = new Page(pageNumber, count, pageSize, list);
        PageTool pt = new PageTool();
        CallforbitBean callforbitBean = callforbitDao.getCallforbitBycfbId(cfbId);
        statusFlag = Integer.parseInt(callforbitBean.getCfbStatus());
        this.pageTools = pt.getPageStringForjs("/enterpriseBids/enterpriseBidsReview!enterpriseBidsComments.action", page);
        this.lists = page.getResult();
        return "enterpriseBidsComments";
    }

    public String enterpriseResponseBidsUser() {
        User user = (User) ActionContext.getContext().getSession().get("msg");
        CfbCommentDao cfbCommentDao = DaoFactory.cfbCommentDao;
        boolean flag = false;
        CfbCommentBean cfbCommentBean = new CfbCommentBean();

        if (user != null) {
            cfbCommentBean.setUserId(user.getId());
        }
        cfbCommentBean.setCfbId(cfbId);
        cfbCommentBean.setCfbCContent(content);
        cfbCommentBean.setCfbCPosted(Tools.getNowDate());
        cfbCommentBean.setCfbCRemark("备注");

        flag = cfbCommentDao.insertCfbCommentBycfbIdAnduserID(cfbCommentBean);

        int count = cfbCommentDao.getCfbCommentCountByUser(cfbId, user);
        List<CfbCommentBean> list = cfbCommentDao.getCfbCommentBycfbIdAndUser(pageNumber, 6, cfbId, user);
        Page page = new Page(pageNumber, count, 6, list);
        PageTool pt = new PageTool();
        this.pageTools = pt.getPageStringForjs("/enterpriseBids/enterpriseResponseBidsUser.action", page);
        this.lists = page.getResult();
        return "enterpriseResponse";
    }

    public String expertWinBids() {
        User user = (User) ActionContext.getContext().getSession().get("msg");
        BitResultDao bitResultDao = DaoFactory.bitResultDao;
        CallforbitDao callforbitDao = DaoFactory.callforbitDao;
        CfbCommentDao cfbCommentDao = DaoFactory.cfbCommentDao;

        flag = bitResultDao.insertBitResultBycfbIdAnduserId(cfbId, userId);

        int count = cfbCommentDao.getCfbCommentCountByUser(cfbId, user);
        List<CfbCommentBean> list = cfbCommentDao.getCfbCommentBycfbIdAndUser(pageNumber, 6, cfbId, user);
        Page page = new Page(pageNumber, count, pageSize, list);
        PageTool pt = new PageTool();
        CallforbitBean callforbitBean = callforbitDao.getCallforbitBycfbId(cfbId);
        statusFlag = Integer.parseInt(callforbitBean.getCfbStatus());
        this.pageTools = pt.getPageStringForjs("/enterpriseBids/enterpriseBidsReview!enterpriseBidsComments.action", page);
        this.lists = page.getResult();
        return "expertWinBidsTheUser";
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

    public Integer getCfbId() {
        return cfbId;
    }

    public void setCfbId(Integer cfbId) {
        this.cfbId = cfbId;
    }

    public List<CfbCommentBean> getLists() {
        return lists;
    }

    public void setLists(List<CfbCommentBean> lists) {
        this.lists = lists;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(Integer statusFlag) {
        this.statusFlag = statusFlag;
    }
}