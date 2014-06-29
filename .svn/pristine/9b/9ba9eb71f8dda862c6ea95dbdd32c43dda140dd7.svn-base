package com.qk.Interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.qk.bean.User;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-10
 * Time: 下午5:09
 * To change this template use File | Settings | File Templates.
 */
public class RoleCheck extends AbstractInterceptor {

    private int role_id;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        User user = (User) ActionContext.getContext().getSession().get("msg");
        if (user != null && user.getRole_id() == role_id) {
            return actionInvocation.invoke();
        } else if (user != null && role_id == 4) {
            return actionInvocation.invoke();
        } else {
            return "fail";
        }
    }
}
