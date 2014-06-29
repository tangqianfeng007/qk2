package com.qk.bean;

import java.io.Serializable;

public class CallforbitBean implements Serializable {
    private Integer cfbId;

    private Integer userId;

    private Integer cfbUser;

    private String cfbTitle;

    private String cfbIndusty;

    private String cfbContact;

    private String cfbAddress;

    private String cfbPhone;

    private String cfbFax;

    private String cfbEmail;

    private String cfbOpenDate;

    private String cfbExpDate;

    private String cfbDetails;

    private String cfbPosted;

    private String cfbFileUrl;

    private String cfbRemark;

    private String cfbStatus;

    private String userRealName;

    private static final long serialVersionUID = 1L;

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
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

    public Integer getCfbUser() {
        return cfbUser;
    }

    public void setCfbUser(Integer cfbUser) {
        this.cfbUser = cfbUser;
    }

    public String getCfbTitle() {
        return cfbTitle;
    }

    public void setCfbTitle(String cfbTitle) {
        this.cfbTitle = cfbTitle == null ? null : cfbTitle.trim();
    }

    public String getCfbIndusty() {
        return cfbIndusty;
    }

    public void setCfbIndusty(String cfbIndusty) {
        this.cfbIndusty = cfbIndusty == null ? null : cfbIndusty.trim();
    }

    public String getCfbContact() {
        return cfbContact;
    }

    public void setCfbContact(String cfbContact) {
        this.cfbContact = cfbContact == null ? null : cfbContact.trim();
    }

    public String getCfbAddress() {
        return cfbAddress;
    }

    public void setCfbAddress(String cfbAddress) {
        this.cfbAddress = cfbAddress == null ? null : cfbAddress.trim();
    }

    public String getCfbPhone() {
        return cfbPhone;
    }

    public void setCfbPhone(String cfbPhone) {
        this.cfbPhone = cfbPhone == null ? null : cfbPhone.trim();
    }

    public String getCfbFax() {
        return cfbFax;
    }

    public void setCfbFax(String cfbFax) {
        this.cfbFax = cfbFax == null ? null : cfbFax.trim();
    }

    public String getCfbEmail() {
        return cfbEmail;
    }

    public void setCfbEmail(String cfbEmail) {
        this.cfbEmail = cfbEmail == null ? null : cfbEmail.trim();
    }

    public String getCfbOpenDate() {
        return cfbOpenDate;
    }

    public void setCfbOpenDate(String cfbOpenDate) {
        this.cfbOpenDate = cfbOpenDate == null ? null : cfbOpenDate.trim();
    }

    public String getCfbExpDate() {
        return cfbExpDate;
    }

    public void setCfbExpDate(String cfbExpDate) {
        this.cfbExpDate = cfbExpDate == null ? null : cfbExpDate.trim();
    }

    public String getCfbDetails() {
        return cfbDetails;
    }

    public void setCfbDetails(String cfbDetails) {
        this.cfbDetails = cfbDetails == null ? null : cfbDetails.trim();
    }

    public String getCfbPosted() {
        return cfbPosted;
    }

    public void setCfbPosted(String cfbPosted) {
        this.cfbPosted = cfbPosted == null ? null : cfbPosted.trim();
    }

    public String getCfbRemark() {
        return cfbRemark;
    }

    public void setCfbRemark(String cfbRemark) {
        this.cfbRemark = cfbRemark == null ? null : cfbRemark.trim();
    }

    public String getCfbStatus() {
        return cfbStatus;
    }

    public void setCfbStatus(String cfbStatus) {
        this.cfbStatus = cfbStatus == null ? null : cfbStatus.trim();
    }

    public String getCfbFileUrl() {
        return cfbFileUrl;
    }

    public void setCfbFileUrl(String cfbFileUrl) {
        this.cfbFileUrl = cfbFileUrl == null ? null : cfbFileUrl.trim();
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
        CallforbitBean other = (CallforbitBean) that;
        return (this.getCfbId() == null ? other.getCfbId() == null : this.getCfbId().equals(other.getCfbId()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getCfbUser() == null ? other.getCfbUser() == null : this.getCfbUser().equals(other.getCfbUser()))
                && (this.getCfbTitle() == null ? other.getCfbTitle() == null : this.getCfbTitle().equals(other.getCfbTitle()))
                && (this.getCfbIndusty() == null ? other.getCfbIndusty() == null : this.getCfbIndusty().equals(other.getCfbIndusty()))
                && (this.getCfbContact() == null ? other.getCfbContact() == null : this.getCfbContact().equals(other.getCfbContact()))
                && (this.getCfbAddress() == null ? other.getCfbAddress() == null : this.getCfbAddress().equals(other.getCfbAddress()))
                && (this.getCfbPhone() == null ? other.getCfbPhone() == null : this.getCfbPhone().equals(other.getCfbPhone()))
                && (this.getCfbFax() == null ? other.getCfbFax() == null : this.getCfbFax().equals(other.getCfbFax()))
                && (this.getCfbEmail() == null ? other.getCfbEmail() == null : this.getCfbEmail().equals(other.getCfbEmail()))
                && (this.getCfbOpenDate() == null ? other.getCfbOpenDate() == null : this.getCfbOpenDate().equals(other.getCfbOpenDate()))
                && (this.getCfbExpDate() == null ? other.getCfbExpDate() == null : this.getCfbExpDate().equals(other.getCfbExpDate()))
                && (this.getCfbDetails() == null ? other.getCfbDetails() == null : this.getCfbDetails().equals(other.getCfbDetails()))
                && (this.getCfbPosted() == null ? other.getCfbPosted() == null : this.getCfbPosted().equals(other.getCfbPosted()))
                && (this.getCfbRemark() == null ? other.getCfbRemark() == null : this.getCfbRemark().equals(other.getCfbRemark()))
                && (this.getCfbFileUrl() == null ? other.getCfbFileUrl() == null : this.getCfbFileUrl().equals(other.getCfbFileUrl()))
                && (this.getCfbStatus() == null ? other.getCfbStatus() == null : this.getCfbStatus().equals(other.getCfbStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCfbId() == null) ? 0 : getCfbId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCfbUser() == null) ? 0 : getCfbUser().hashCode());
        result = prime * result + ((getCfbTitle() == null) ? 0 : getCfbTitle().hashCode());
        result = prime * result + ((getCfbIndusty() == null) ? 0 : getCfbIndusty().hashCode());
        result = prime * result + ((getCfbContact() == null) ? 0 : getCfbContact().hashCode());
        result = prime * result + ((getCfbAddress() == null) ? 0 : getCfbAddress().hashCode());
        result = prime * result + ((getCfbPhone() == null) ? 0 : getCfbPhone().hashCode());
        result = prime * result + ((getCfbFax() == null) ? 0 : getCfbFax().hashCode());
        result = prime * result + ((getCfbEmail() == null) ? 0 : getCfbEmail().hashCode());
        result = prime * result + ((getCfbOpenDate() == null) ? 0 : getCfbOpenDate().hashCode());
        result = prime * result + ((getCfbExpDate() == null) ? 0 : getCfbExpDate().hashCode());
        result = prime * result + ((getCfbDetails() == null) ? 0 : getCfbDetails().hashCode());
        result = prime * result + ((getCfbPosted() == null) ? 0 : getCfbPosted().hashCode());
        result = prime * result + ((getCfbFileUrl() == null) ? 0 : getCfbFileUrl().hashCode());
        result = prime * result + ((getCfbRemark() == null) ? 0 : getCfbRemark().hashCode());
        result = prime * result + ((getCfbStatus() == null) ? 0 : getCfbStatus().hashCode());
        return result;
    }
}