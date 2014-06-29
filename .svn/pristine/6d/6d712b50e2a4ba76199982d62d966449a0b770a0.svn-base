package com.qk.bean;

import java.io.Serializable;

public class BitreslutBean implements Serializable {
    private Integer bitreslutId;

    private Integer cfbId;

    private String bitreslutTitle;

    private String bitreslutDetials;

    private String bitreslutRemark;

    private String bitreslutPosted;

    private static final long serialVersionUID = 1L;

    public Integer getBitreslutId() {
        return bitreslutId;
    }

    public void setBitreslutId(Integer bitreslutId) {
        this.bitreslutId = bitreslutId;
    }

    public Integer getCfbId() {
        return cfbId;
    }

    public void setCfbId(Integer cfbId) {
        this.cfbId = cfbId;
    }

    public String getBitreslutTitle() {
        return bitreslutTitle;
    }

    public void setBitreslutTitle(String bitreslutTitle) {
        this.bitreslutTitle = bitreslutTitle == null ? null : bitreslutTitle.trim();
    }

    public String getBitreslutDetials() {
        return bitreslutDetials;
    }

    public void setBitreslutDetials(String bitreslutDetials) {
        this.bitreslutDetials = bitreslutDetials == null ? null : bitreslutDetials.trim();
    }

    public String getBitreslutRemark() {
        return bitreslutRemark;
    }

    public void setBitreslutRemark(String bitreslutRemark) {
        this.bitreslutRemark = bitreslutRemark == null ? null : bitreslutRemark.trim();
    }

    public String getBitreslutPosted() {
        return bitreslutPosted;
    }

    public void setBitreslutPosted(String bitreslutPosted) {
        this.bitreslutPosted = bitreslutPosted == null ? null : bitreslutPosted.trim();
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
        BitreslutBean other = (BitreslutBean) that;
        return (this.getBitreslutId() == null ? other.getBitreslutId() == null : this.getBitreslutId().equals(other.getBitreslutId()))
                && (this.getCfbId() == null ? other.getCfbId() == null : this.getCfbId().equals(other.getCfbId()))
                && (this.getBitreslutTitle() == null ? other.getBitreslutTitle() == null : this.getBitreslutTitle().equals(other.getBitreslutTitle()))
                && (this.getBitreslutDetials() == null ? other.getBitreslutDetials() == null : this.getBitreslutDetials().equals(other.getBitreslutDetials()))
                && (this.getBitreslutRemark() == null ? other.getBitreslutRemark() == null : this.getBitreslutRemark().equals(other.getBitreslutRemark()))
                && (this.getBitreslutPosted() == null ? other.getBitreslutPosted() == null : this.getBitreslutPosted().equals(other.getBitreslutPosted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBitreslutId() == null) ? 0 : getBitreslutId().hashCode());
        result = prime * result + ((getCfbId() == null) ? 0 : getCfbId().hashCode());
        result = prime * result + ((getBitreslutTitle() == null) ? 0 : getBitreslutTitle().hashCode());
        result = prime * result + ((getBitreslutDetials() == null) ? 0 : getBitreslutDetials().hashCode());
        result = prime * result + ((getBitreslutRemark() == null) ? 0 : getBitreslutRemark().hashCode());
        result = prime * result + ((getBitreslutPosted() == null) ? 0 : getBitreslutPosted().hashCode());
        return result;
    }
}