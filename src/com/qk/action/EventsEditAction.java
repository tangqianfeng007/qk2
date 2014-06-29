package com.qk.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.qk.bean.EventBean;
import com.qk.bean.User;
import com.qk.dao.DaoFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-12
 * Time: 上午11:13
 * To change this template use File | Settings | File Templates.
 */
public class EventsEditAction implements ModelDriven<EventBean> {
    private EventBean eventBean;
    private String responseMsg = "0";

    public String eventsEdit() {
        User user = (User) ActionContext.getContext().getSession().get("msg");
        eventBean.setUserId(user.getId());
        eventBean.setEventCount(0);
        eventBean.setEventPosted(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        int key = DaoFactory.eventDao.insertEvent(eventBean);
        if (key > 0) {
            responseMsg = "1";
        } else {
            responseMsg = "-1";
        }
        return "success";
    }

    public String eventsChange() {
        User user = (User) ActionContext.getContext().getSession().get("msg");
        EventBean u = DaoFactory.eventDao.infoFindById(eventBean.getEventId());
        int key = -1;
        if (user.getId() == u.getUserId() || user.getRole_id()==1) {
            key = DaoFactory.eventDao.updateEvent(eventBean);
        }

        if (key > 0) {
            responseMsg = "1";
        } else {
            responseMsg = "-1";
        }
        return "success";
    }

    @Override
    public EventBean getModel() {
        if (eventBean == null) {
            eventBean = new EventBean();
        }
        return eventBean;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }
}
