package com.qk.action;

import com.opensymphony.xwork2.ActionContext;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-3
 * Time: 下午3:09
 * To change this template use File | Settings | File Templates.
 */
public class LogoutAction {
    public String logout() {
        ActionContext.getContext().getSession().remove("msg");
        return "logout";
    }
}
