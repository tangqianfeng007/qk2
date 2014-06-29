package com.qk.bean;

import java.io.Serializable;

public class VirtualTeamBean implements Serializable {
    private Integer vtId = -1;

    private Integer rfpInfoId;

    private String vtName;

    private String vtNote;

    private String vtCreateTime;

    private String vtStatus;

    private String vtRemark;

    private static final long serialVersionUID = 1L;

    public Integer getVtId() {
        return vtId;
    }

    public void setVtId(Integer vtId) {
        this.vtId = vtId;
    }

    public Integer getRfpInfoId() {
        return rfpInfoId;
    }

    public void setRfpInfoId(Integer rfpInfoId) {
        this.rfpInfoId = rfpInfoId;
    }

    public String getVtName() {
        return vtName;
    }

    public void setVtName(String vtName) {
        this.vtName = vtName == null ? null : vtName.trim();
    }

    public String getVtNote() {
        return vtNote;
    }

    public void setVtNote(String vtNote) {
        this.vtNote = vtNote == null ? null : vtNote.trim();
    }

    public String getVtCreateTime() {
        return vtCreateTime;
    }

    public void setVtCreateTime(String vtCreateTime) {
        this.vtCreateTime = vtCreateTime == null ? null : vtCreateTime.trim();
    }

    public String getVtStatus() {
        return vtStatus;
    }

    public void setVtStatus(String vtStatus) {
        this.vtStatus = vtStatus == null ? null : vtStatus.trim();
    }

    public String getVtRemark() {
        return vtRemark;
    }

    public void setVtRemark(String vtRemark) {
        this.vtRemark = vtRemark == null ? null : vtRemark.trim();
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
        VirtualTeamBean other = (VirtualTeamBean) that;
        return (this.getVtId() == null ? other.getVtId() == null : this.getVtId().equals(other.getVtId()))
                && (this.getRfpInfoId() == null ? other.getRfpInfoId() == null : this.getRfpInfoId().equals(other.getRfpInfoId()))
                && (this.getVtName() == null ? other.getVtName() == null : this.getVtName().equals(other.getVtName()))
                && (this.getVtNote() == null ? other.getVtNote() == null : this.getVtNote().equals(other.getVtNote()))
                && (this.getVtCreateTime() == null ? other.getVtCreateTime() == null : this.getVtCreateTime().equals(other.getVtCreateTime()))
                && (this.getVtStatus() == null ? other.getVtStatus() == null : this.getVtStatus().equals(other.getVtStatus()))
                && (this.getVtRemark() == null ? other.getVtRemark() == null : this.getVtRemark().equals(other.getVtRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVtId() == null) ? 0 : getVtId().hashCode());
        result = prime * result + ((getRfpInfoId() == null) ? 0 : getRfpInfoId().hashCode());
        result = prime * result + ((getVtName() == null) ? 0 : getVtName().hashCode());
        result = prime * result + ((getVtNote() == null) ? 0 : getVtNote().hashCode());
        result = prime * result + ((getVtCreateTime() == null) ? 0 : getVtCreateTime().hashCode());
        result = prime * result + ((getVtStatus() == null) ? 0 : getVtStatus().hashCode());
        result = prime * result + ((getVtRemark() == null) ? 0 : getVtRemark().hashCode());
        return result;
    }
}