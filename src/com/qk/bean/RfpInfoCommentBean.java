package com.qk.bean;

import java.io.Serializable;

public class RfpInfoCommentBean implements Serializable {
    private String ricContent;

    private String ricPosted;

    private String ricRemark;

    private Integer rfpInfoId;

    private Integer userId;
    private String userName;
    private int status = 0;//评论的状态，1已经被加入到团队中，0未被加入
    private String userType;//评论者的类型，技术专家

    private static final long serialVersionUID = 1L;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getRfpInfoId() {
        return rfpInfoId;
    }

    public void setRfpInfoId(Integer rfpInfoId) {
        this.rfpInfoId = rfpInfoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRicContent() {
        return ricContent;
    }

    public void setRicContent(String ricContent) {
        this.ricContent = ricContent == null ? null : ricContent.trim();
    }

    public String getRicPosted() {
        return ricPosted;
    }

    public void setRicPosted(String ricPosted) {
        this.ricPosted = ricPosted == null ? null : ricPosted.trim();
    }

    public String getRicRemark() {
        return ricRemark;
    }

    public void setRicRemark(String ricRemark) {
        this.ricRemark = ricRemark == null ? null : ricRemark.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        RfpInfoCommentBean other = (RfpInfoCommentBean) that;
        return (this.getRfpInfoId() == null ? other.getRfpInfoId() == null : this.getRfpInfoId().equals(other.getRfpInfoId()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getRicContent() == null ? other.getRicContent() == null : this.getRicContent().equals(other.getRicContent()))
                && (this.getRicPosted() == null ? other.getRicPosted() == null : this.getRicPosted().equals(other.getRicPosted()))
                && (this.getRicRemark() == null ? other.getRicRemark() == null : this.getRicRemark().equals(other.getRicRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRfpInfoId() == null) ? 0 : getRfpInfoId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRicContent() == null) ? 0 : getRicContent().hashCode());
        result = prime * result + ((getRicPosted() == null) ? 0 : getRicPosted().hashCode());
        result = prime * result + ((getRicRemark() == null) ? 0 : getRicRemark().hashCode());
        return result;
    }
}