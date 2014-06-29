package com.qk.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.qk.bean.QkNewsBean;
import com.qk.bean.User;
import com.qk.dao.DaoFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-10
 * Time: 下午4:28
 * To change this template use File | Settings | File Templates.
 */
public class NewsEditAction implements ModelDriven<QkNewsBean> {
    private QkNewsBean qkNewsBean;
    private String responseMsg = "0";

    public String newsEdit() {
        User user = (User) ActionContext.getContext().getSession().get("msg");
        qkNewsBean.setUserId(user.getId());
        qkNewsBean.setNewsSource(user.getUsername());
        qkNewsBean.setNewsCount(0);
        qkNewsBean.setNewsPosted(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        int key = DaoFactory.newsDao.insertNews(qkNewsBean);
        if (key > 0) {
            responseMsg = "1";
        } else {
            responseMsg = "-1";
        }
        return "success";
    }

    /*
    * 修改自己所发布的新闻列表
     */
    public String newsChange() {
        User user = (User) ActionContext.getContext().getSession().get("msg");
        QkNewsBean u = DaoFactory.newsDao.infoFindById(qkNewsBean.getNewsId());
        int key = -1;
        if (user.getId() == u.getUserId() || user.getRole_id()==1) {
            key = DaoFactory.newsDao.updateNews(qkNewsBean);
        }
        if (key > 0) {
            responseMsg = "1";
        } else {
            responseMsg = "-1";
        }
        return "success";
    }

    @Override
    public QkNewsBean getModel() {
        if (qkNewsBean == null) {
            qkNewsBean = new QkNewsBean();
        }
        return qkNewsBean;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }
}
