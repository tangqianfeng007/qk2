package com.qk.bean;

import java.io.Serializable;

public class VtMemberBean implements Serializable {
    private String vtMemberRemark;

    private Integer userId;

    private Integer vtId;

    private String userName;//成员名称
    private String userType;//专家类型
    private static final long serialVersionUID = 1L;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVtId() {
        return vtId;
    }

    public void setVtId(Integer vtId) {
        this.vtId = vtId;
    }


    public String getVtMemberRemark() {
        return vtMemberRemark;
    }

    public void setVtMemberRemark(String vtMemberRemark) {
        this.vtMemberRemark = vtMemberRemark == null ? null : vtMemberRemark.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        VtMemberBean other = (VtMemberBean) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getVtId() == null ? other.getVtId() == null : this.getVtId().equals(other.getVtId()))
                && (this.getVtMemberRemark() == null ? other.getVtMemberRemark() == null : this.getVtMemberRemark().equals(other.getVtMemberRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getVtId() == null) ? 0 : getVtId().hashCode());
        result = prime * result + ((getVtMemberRemark() == null) ? 0 : getVtMemberRemark().hashCode());
        return result;
    }
}