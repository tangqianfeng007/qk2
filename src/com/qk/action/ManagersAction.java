package com.qk.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qk.bean.User;
import com.qk.common.Page;
import com.qk.common.PageTool;
import com.qk.dao.DaoFactory;
import com.qk.dao.UserDao;
import com.qk.email.EMailAuthServiceImpl;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-9
 * Time: 上午10:47
 * To change this template use File | Settings | File Templates.
 */
public class ManagersAction extends ActionSupport {
    private int id;
    private User user;
    private String emailCode;

    /**
     * pageNumber代表是哪一页
     * pageSize代表一页中显示多少条数据
     */
    private int pageNumber = 1;
    private int pageSize = 10;
    private List<User> list = null;
    private String pageTools = null;

    public String get() {
        if (id > 0) {
            user = DaoFactory.userDao.infoFindById(id);
        }
        return SUCCESS;
    }

    /*
    * 获取注册管理列表
     */
    public String getManagersList() {
        UserDao userDao = DaoFactory.userDao;
        int count = userDao.getCount2();
        list = userDao.getInactiveList(pageNumber, pageSize);
        Page page = new Page(pageNumber, count, pageSize, list);
        PageTool pt = new PageTool();
        pageTools = pt.getPageString("/man/getManList.action", page);
        return SUCCESS;
    }

    /*
    * 通过注册  发送激活email
     */
    public String pass() throws Exception {
        UserDao userDao = DaoFactory.userDao;
        userDao.setStatus(id, "2");
        User info = DaoFactory.userDao.infoFindById(id);
        new EMailAuthServiceImpl().sendAuthEMail(info.getEmail(), info);
        return "success";
    }

    /*
   * 未通过注册
    */
    public String notPass() {
        DaoFactory.userDao.deleteById(id);
        return "success";
    }

    /*
    * email回执响应
     */
    public String emailCallBackSuccess() {
        User user1 = DaoFactory.userDao.checkEmailCode(emailCode);
        if (user1 != null) {
            DaoFactory.userDao.setStatus(user1.getId(), "3");
            ActionContext.getContext().getSession().remove("msg");
            ActionContext.getContext().getSession().put("msg", user1);
        }
        return "success";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public String getPageTools() {
        return pageTools;
    }

    public void setPageTools(String pageTools) {
        this.pageTools = pageTools;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }
}
