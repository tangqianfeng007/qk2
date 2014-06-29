package com.qk.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qk.bean.LogBean;
import com.qk.bean.TUserBean;
import com.qk.bean.User;
import com.qk.dao.DaoFactory;
import org.apache.struts2.json.annotations.JSON;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created with IntelliJ IDEA.
 * User: zheng
 * Date: 13-8-2
 * Time: 上午10:45
 * To change this template use File | Settings | File Templates.
 */
public class LoginAction extends ActionSupport implements ModelDriven<LogBean> {
    private LogBean logBean;
    private String code;
    private int status = 0;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @JSON(serialize = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JSON(serialize = false)
    public LogBean getLogBean() {
        return logBean;
    }

    public void setLogBean(LogBean logBean) {
        this.logBean = logBean;
    }

    /*
     *验证码 用户名 密码 验证
     */
    public String login() throws UnsupportedEncodingException {

        String randCode = (String) ActionContext.getContext().getSession().get("rand");
        if (randCode.equals(code)) {
            String username = logBean.getUsername();
            String password = logBean.getPassword();
            //System.out.println(username+"    "+password);
            User user = DaoFactory.userDao.loginCheck(username, password);
            if (user != null) {
                if (!"3".equals(user.getStatus())) {
                    status = 2;
                } else {
                    ActionContext.getContext().getSession().put("msg", user);
                    status = 1;
                }
            } else {
                status = -1;//密码，用户名错误
            }

        } else {
            status = -2;//验证码错误
        }
        return SUCCESS;
    }

    @Override
    public LogBean getModel() {
        if (logBean == null) {
            logBean = new LogBean();
        }
        return logBean;
    }
}
