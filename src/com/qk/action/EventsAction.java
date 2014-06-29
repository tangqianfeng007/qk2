package com.qk.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qk.bean.EventBean;
import com.qk.bean.User;
import com.qk.common.Page;
import com.qk.common.PageTool;
import com.qk.dao.DaoFactory;
import com.qk.dao.EventDao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-7
 * Time: 下午6:52
 * To change this template use File | Settings | File Templates.
 */
public class EventsAction extends ActionSupport {
    private int id;
    private EventBean event;

    /**
     * pageNumber代表是哪一页
     * pageSize代表一页中显示多少条数据
     */
    private int pageNumber = 1;
    private int pageSize = 10;
    private List<EventBean> list = null;
    private String pageTools = null;


    /*
    * 获取新闻具体内容
     */
    public String get() {
        if (id > 0) {
            DaoFactory.eventDao.updateClickCount(1, id);
            event = DaoFactory.eventDao.infoFindById(id);
        }
        return SUCCESS;
    }

    /*
    * 获取所有发布的新闻列表
     */
    public String getEventsList() {
        EventDao eventDao = DaoFactory.eventDao;
        int count = eventDao.getCount(0);
        list = eventDao.getList(pageNumber, pageSize, 0);
        Page page = new Page(pageNumber, count, pageSize, list);
        PageTool pt = new PageTool();
        pageTools = pt.getPageString("/events/getEventsList.action", page);
        return SUCCESS;
    }

    /*
    * 获取自己所发布的新闻列表
     */
    public String getPersonEventsList() {
        User user = (User) ActionContext.getContext().getSession().get("msg");
        int useid = user.getId();
        EventDao eventDao = DaoFactory.eventDao;
        int count = eventDao.getCount(useid);
        list = eventDao.getList(pageNumber, pageSize, useid);
        Page page = new Page(pageNumber, count, pageSize, list);
        PageTool pt = new PageTool();
        pageTools = pt.getPageString("/events/getEventsList.action", page);
        return "success";
    }

    /*
    * 修改新闻
     */
    public String eventsChange() {
        event = DaoFactory.eventDao.infoFindById(id);
        return "success";
    }

    /*
     * 删除新闻
     */
    public String deleteEvents() {
        User user = (User) ActionContext.getContext().getSession().get("msg");
        EventBean eventBean = DaoFactory.eventDao.infoFindById(id);
        if (user.getId() == eventBean.getUserId() || user.getRole_id()==1) {
            DaoFactory.eventDao.deleteEvents(id);
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPageTools() {
        return pageTools;
    }

    public void setPageTools(String pageTools) {
        this.pageTools = pageTools;
    }

    public List<EventBean> getList() {
        return list;
    }

    public void setList(List<EventBean> list) {
        this.list = list;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public EventBean getEvent() {
        return event;
    }

    public void setEvent(EventBean event) {
        this.event = event;
    }

}
