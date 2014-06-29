package com.qk.bean;

import java.io.Serializable;

public class EnterpriseCommentBean implements Serializable {
    private Integer ecId;

    private Integer ecEnterpriseId;

    private Integer ecExpertsId;

    private String ecContent;

    private String ecPosted;

    private String ecRamark;

    private String ecTitle;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEcTitle() {
        return ecTitle;
    }

    public void setEcTitle(String ecTitle) {
        this.ecTitle = ecTitle;
    }

    private static final long serialVersionUID = 1L;

    public Integer getEcId() {
        return ecId;
    }

    public void setEcId(Integer ecId) {
        this.ecId = ecId;
    }

    public Integer getEcEnterpriseId() {
        return ecEnterpriseId;
    }

    public void setEcEnterpriseId(Integer ecEnterpriseId) {
        this.ecEnterpriseId = ecEnterpriseId;
    }

    public Integer getEcExpertsId() {
        return ecExpertsId;
    }

    public void setEcExpertsId(Integer ecExpertsId) {
        this.ecExpertsId = ecExpertsId;
    }

    public String getEcContent() {
        return ecContent;
    }

    public void setEcContent(String ecContent) {
        this.ecContent = ecContent == null ? null : ecContent.trim();
    }

    public String getEcPosted() {
        return ecPosted;
    }

    public void setEcPosted(String ecPosted) {
        this.ecPosted = ecPosted == null ? null : ecPosted.trim();
    }

    public String getEcRamark() {
        return ecRamark;
    }

    public void setEcRamark(String ecRamark) {
        this.ecRamark = ecRamark == null ? null : ecRamark.trim();
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
        EnterpriseCommentBean other = (EnterpriseCommentBean) that;
        return (this.getEcId() == null ? other.getEcId() == null : this.getEcId().equals(other.getEcId()))
                && (this.getEcEnterpriseId() == null ? other.getEcEnterpriseId() == null : this.getEcEnterpriseId().equals(other.getEcEnterpriseId()))
                && (this.getEcExpertsId() == null ? other.getEcExpertsId() == null : this.getEcExpertsId().equals(other.getEcExpertsId()))
                && (this.getEcContent() == null ? other.getEcContent() == null : this.getEcContent().equals(other.getEcContent()))
                && (this.getEcPosted() == null ? other.getEcPosted() == null : this.getEcPosted().equals(other.getEcPosted()))
                && (this.getEcRamark() == null ? other.getEcRamark() == null : this.getEcRamark().equals(other.getEcRamark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEcId() == null) ? 0 : getEcId().hashCode());
        result = prime * result + ((getEcEnterpriseId() == null) ? 0 : getEcEnterpriseId().hashCode());
        result = prime * result + ((getEcExpertsId() == null) ? 0 : getEcExpertsId().hashCode());
        result = prime * result + ((getEcContent() == null) ? 0 : getEcContent().hashCode());
        result = prime * result + ((getEcPosted() == null) ? 0 : getEcPosted().hashCode());
        result = prime * result + ((getEcRamark() == null) ? 0 : getEcRamark().hashCode());
        return result;
    }
}