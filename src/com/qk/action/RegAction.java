package com.qk.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qk.bean.User;
import com.qk.common.Tools;
import com.qk.dao.DaoFactory;
import com.qk.dao.UserDao;
import org.apache.struts2.json.annotations.JSON;

import java.io.UnsupportedEncodingException;

public class RegAction extends ActionSupport implements ModelDriven<User> {
    private int status = 0;
    private User user;


    /**
     * 验证用户名重复
     *
     * @return
     */
    public String checkUsername() {
        String name = "";
        //对中文乱码的处理
        try {
            name = java.net.URLDecoder.decode(user.getUsername(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        if (!"".equals(name)) {
            UserDao userDao = DaoFactory.userDao;
            User user = userDao.regCheck(name);
            if (user != null) {
                status = -1; //用户名已经存在
            } else {
                status = 1; //用户名可以用
            }
        } else {
            status = -2; //输入为空
        }

        return SUCCESS;
    }

    /**
     * 用户注册处理
     *
     * @return
     */
    public String reg() {
        UserDao userDao = DaoFactory.userDao;

        if (user.getUsername() == null || Tools.length(user.getUsername()) < 4) status = -2;
        if (user.getPassword() == null || Tools.length(user.getPassword()) < 6) status = -2;
        ;
        if (user.getEmail() == null) user.setEmail("");

        if (user.getPhone() == null) user.setPhone("");

        if (user.getRole_id() <= 0) user.setRole_id(1);

        if (user.getAddress() == null) user.setAddress("");

        if (user.getCity() == null) user.setCity("");
        if (user.getProvince() == null) user.setProvince("");

        if (user.getPostalcode() == null) user.setPostalcode("");
        ;

        if (user.getType() == null) user.setType("");

        if (user.getIntroduce() == null) user.setIntroduce("");
        ;

        if (user.getActive_code() == null) user.setActive_code("");
        ;

        if (user.getStatus() == null) user.setStatus("");
        ;

        if (user.getRemark() == null) user.setRemark("");
        ;

        if (user.getReal_name() == null) user.setReal_name("");
        if (user.getHeaderPicUrl() == null) user.setHeaderPicUrl("");
        if (this.status == 0) {
            User user1 = userDao.register(user);
            if (user1 == null) {
                this.status = -1;//用户名重复
            } else {
                this.status = 1;//成功
            }
        }
        return SUCCESS;
    }

    @Override
    public User getModel() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    @JSON(serialize = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
