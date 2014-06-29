package com.qk.bean;

import java.io.Serializable;

public class CfbCommentBean implements Serializable {

    private Integer cfbCId;

    private String cfbCContent;

    private String cfbCPosted;

    private String cfbCRemark;

    private Integer cfbId;

    private Integer userId;

    private String username;

    private String cfbStatus;

    private static final long serialVersionUID = 1L;

    public String getCfbStatus() {
        return cfbStatus;
    }

    public void setCfbStatus(String cfbStatus) {
        this.cfbStatus = cfbStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCfbCId() {
        return cfbCId;
    }

    public void setCfbCId(Integer cfbCId) {
        this.cfbCId = cfbCId;
    }

    public Integer getCfbId() {
        return cfbId;
    }

    public void setCfbId(Integer cfbId) {
        this.cfbId = cfbId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCfbCContent() {
        return cfbCContent;
    }

    public void setCfbCContent(String cfbCContent) {
        this.cfbCContent = cfbCContent == null ? null : cfbCContent.trim();
    }

    public String getCfbCPosted() {
        return cfbCPosted;
    }

    public void setCfbCPosted(String cfbCPosted) {
        this.cfbCPosted = cfbCPosted == null ? null : cfbCPosted.trim();
    }

    public String getCfbCRemark() {
        return cfbCRemark;
    }

    public void setCfbCRemark(String cfbCRemark) {
        this.cfbCRemark = cfbCRemark == null ? null : cfbCRemark.trim();
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
        CfbCommentBean other = (CfbCommentBean) that;
        return (this.getCfbId() == null ? other.getCfbId() == null : this.getCfbId().equals(other.getCfbId()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getCfbCContent() == null ? other.getCfbCContent() == null : this.getCfbCContent().equals(other.getCfbCContent()))
                && (this.getCfbCPosted() == null ? other.getCfbCPosted() == null : this.getCfbCPosted().equals(other.getCfbCPosted()))
                && (this.getCfbCId() == null ? other.getCfbCId() == null : this.getCfbCId().equals(other.getCfbCId()))
                && (this.getCfbCRemark() == null ? other.getCfbCRemark() == null : this.getCfbCRemark().equals(other.getCfbCRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCfbCId() == null) ? 0 : getCfbCId().hashCode());
        result = prime * result + ((getCfbId() == null) ? 0 : getCfbId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCfbCContent() == null) ? 0 : getCfbCContent().hashCode());
        result = prime * result + ((getCfbCPosted() == null) ? 0 : getCfbCPosted().hashCode());
        result = prime * result + ((getCfbCRemark() == null) ? 0 : getCfbCRemark().hashCode());
        return result;
    }
}