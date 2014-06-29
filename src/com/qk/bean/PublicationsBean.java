package com.qk.bean;

import java.io.Serializable;

public class PublicationsBean implements Serializable {
    private Integer pubId;

    private Integer userId;

    private String pubTitle;

    private String pubType;

    private String pubIntroduce;

    private String pubDate;

    private String pubPrice;

    private String pubPosted;

    private Integer pubCount;

    private String pubRemark;

    private String username = "";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private static final long serialVersionUID = 1L;

    public Integer getPubId() {
        return pubId;
    }

    public void setPubId(Integer pubId) {
        this.pubId = pubId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPubTitle() {
        return pubTitle;
    }

    public void setPubTitle(String pubTitle) {
        this.pubTitle = pubTitle == null ? null : pubTitle.trim();
    }

    public String getPubType() {
        return pubType;
    }

    public void setPubType(String pubType) {
        this.pubType = pubType == null ? null : pubType.trim();
    }

    public String getPubIntroduce() {
        return pubIntroduce;
    }

    public void setPubIntroduce(String pubIntroduce) {
        this.pubIntroduce = pubIntroduce == null ? null : pubIntroduce.trim();
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate == null ? null : pubDate.trim();
    }

    public String getPubPrice() {
        return pubPrice;
    }

    public void setPubPrice(String pubPrice) {
        this.pubPrice = pubPrice == null ? null : pubPrice.trim();
    }

    public String getPubPosted() {
        return pubPosted;
    }

    public void setPubPosted(String pubPosted) {
        this.pubPosted = pubPosted == null ? null : pubPosted.trim();
    }

    public Integer getPubCount() {
        return pubCount;
    }

    public void setPubCount(Integer pubCount) {
        this.pubCount = pubCount;
    }

    public String getPubRemark() {
        return pubRemark;
    }

    public void setPubRemark(String pubRemark) {
        this.pubRemark = pubRemark == null ? null : pubRemark.trim();
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
        PublicationsBean other = (PublicationsBean) that;
        return (this.getPubId() == null ? other.getPubId() == null : this.getPubId().equals(other.getPubId()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getPubTitle() == null ? other.getPubTitle() == null : this.getPubTitle().equals(other.getPubTitle()))
                && (this.getPubType() == null ? other.getPubType() == null : this.getPubType().equals(other.getPubType()))
                && (this.getPubIntroduce() == null ? other.getPubIntroduce() == null : this.getPubIntroduce().equals(other.getPubIntroduce()))
                && (this.getPubDate() == null ? other.getPubDate() == null : this.getPubDate().equals(other.getPubDate()))
                && (this.getPubPrice() == null ? other.getPubPrice() == null : this.getPubPrice().equals(other.getPubPrice()))
                && (this.getPubPosted() == null ? other.getPubPosted() == null : this.getPubPosted().equals(other.getPubPosted()))
                && (this.getPubCount() == null ? other.getPubCount() == null : this.getPubCount().equals(other.getPubCount()))
                && (this.getPubRemark() == null ? other.getPubRemark() == null : this.getPubRemark().equals(other.getPubRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPubId() == null) ? 0 : getPubId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPubTitle() == null) ? 0 : getPubTitle().hashCode());
        result = prime * result + ((getPubType() == null) ? 0 : getPubType().hashCode());
        result = prime * result + ((getPubIntroduce() == null) ? 0 : getPubIntroduce().hashCode());
        result = prime * result + ((getPubDate() == null) ? 0 : getPubDate().hashCode());
        result = prime * result + ((getPubPrice() == null) ? 0 : getPubPrice().hashCode());
        result = prime * result + ((getPubPosted() == null) ? 0 : getPubPosted().hashCode());
        result = prime * result + ((getPubCount() == null) ? 0 : getPubCount().hashCode());
        result = prime * result + ((getPubRemark() == null) ? 0 : getPubRemark().hashCode());
        return result;
    }
}