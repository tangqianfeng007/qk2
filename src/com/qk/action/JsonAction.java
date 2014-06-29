package com.qk.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.json.annotations.JSON;

public class JsonAction extends ActionSupport {
    private static final long serialVersionUID = 7443363719737618408L;
    /**
     * 姓名
     */
    private String name;
    /**
     * 身高
     */
    private String inch;
    /**
     * ajax返回结果，也可是其他类型的，这里以String类型为例
     */
    private String result;

    @Override
    public String execute() throws Exception {
        if ("张三".equals(name)) {
            result = "身份验证通过,身高为" + inch;
        } else
            result = "不是张三！";
        return SUCCESS;
    }

    public String getJsp() {
        this.name = "张三";
        return SUCCESS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JSON(serialize = false)
    public String getInch() {
        return inch;
    }

    public void setInch(String inch) {
        this.inch = inch;
    }

    /**
     * @param @return
     * @return String
     * @throws
     * @Title: getResult
     * @Description:json调取结果
     */
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
