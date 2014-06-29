package com.qk.action;

import com.opensymphony.xwork2.ActionSupport;
import com.qk.bean.User;
import com.qk.common.Page;
import com.qk.common.PageTool;
import com.qk.dao.DaoFactory;
import com.qk.dao.UserDao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-8
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
public class ExpertsAction extends ActionSupport {
    private int id;
    private User user;
    private int seekType=1;

    //用于模糊查找的索引
    private String nameIndex;
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


    public String getExpertsList() {
        UserDao userDao = DaoFactory.userDao;
        int count = userDao.getCount();
        list = userDao.getList(pageNumber, pageSize);
        Page page = new Page(pageNumber, count, pageSize, list);
        PageTool pt = new PageTool();
        pageTools = pt.getPageString("/experts/getExpertsList.action", page);
        return SUCCESS;
    }

    /*
    * 模糊查询
     */
    public String expertsSeek() {
        UserDao userDao = DaoFactory.userDao;
        int count =0;
        switch (seekType){
            case 1:    count = userDao.getCount3(nameIndex); list = userDao.getSeekList(pageNumber, pageSize, nameIndex);break;
            case 2:    count = userDao.getCount4(nameIndex); list = userDao.getSeekListForEnterprise(pageNumber,pageSize,nameIndex);break;
        }
        Page page = new Page(pageNumber, count, pageSize, list);
        PageTool pt = new PageTool();
        pageTools = pt.getPageStringForJsSeek("#", page);
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

    public String getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(String nameIndex) {
        this.nameIndex = nameIndex;
    }

    public void setSeekType(int seekType) {
        this.seekType = seekType;
    }
}
