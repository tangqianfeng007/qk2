package com.qk.bean;

import java.io.Serializable;

public class TUserBean {
    private Integer userId;

    private Integer roleId;

    private String userName;

    private String userPsd;

    private String userEmail;

    private String userRealName;

    private String userPhone;

    private String userAddress;

    private String userCity;

    private String userProvince;

    private String userPostalcode;

    private String userType;

    private String userIntroduce;

    private String userActiveCode;

    private String userCode;

    private String userStatus;

    private String userRemark;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPsd() {
        return userPsd;
    }

    public void setUserPsd(String userPsd) {
        this.userPsd = userPsd == null ? null : userPsd.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName == null ? null : userRealName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity == null ? null : userCity.trim();
    }

    public String getUserProvince() {
        return userProvince;
    }

    public void setUserProvince(String userProvince) {
        this.userProvince = userProvince == null ? null : userProvince.trim();
    }

    public String getUserPostalcode() {
        return userPostalcode;
    }

    public void setUserPostalcode(String userPostalcode) {
        this.userPostalcode = userPostalcode == null ? null : userPostalcode.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getUserIntroduce() {
        return userIntroduce;
    }

    public void setUserIntroduce(String userIntroduce) {
        this.userIntroduce = userIntroduce == null ? null : userIntroduce.trim();
    }

    public String getUserActiveCode() {
        return userActiveCode;
    }

    public void setUserActiveCode(String userActiveCode) {
        this.userActiveCode = userActiveCode == null ? null : userActiveCode.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark == null ? null : userRemark.trim();
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
        TUserBean other = (TUserBean) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
                && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
                && (this.getUserPsd() == null ? other.getUserPsd() == null : this.getUserPsd().equals(other.getUserPsd()))
                && (this.getUserEmail() == null ? other.getUserEmail() == null : this.getUserEmail().equals(other.getUserEmail()))
                && (this.getUserRealName() == null ? other.getUserRealName() == null : this.getUserRealName().equals(other.getUserRealName()))
                && (this.getUserPhone() == null ? other.getUserPhone() == null : this.getUserPhone().equals(other.getUserPhone()))
                && (this.getUserAddress() == null ? other.getUserAddress() == null : this.getUserAddress().equals(other.getUserAddress()))
                && (this.getUserCity() == null ? other.getUserCity() == null : this.getUserCity().equals(other.getUserCity()))
                && (this.getUserProvince() == null ? other.getUserProvince() == null : this.getUserProvince().equals(other.getUserProvince()))
                && (this.getUserPostalcode() == null ? other.getUserPostalcode() == null : this.getUserPostalcode().equals(other.getUserPostalcode()))
                && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
                && (this.getUserIntroduce() == null ? other.getUserIntroduce() == null : this.getUserIntroduce().equals(other.getUserIntroduce()))
                && (this.getUserActiveCode() == null ? other.getUserActiveCode() == null : this.getUserActiveCode().equals(other.getUserActiveCode()))
                && (this.getUserCode() == null ? other.getUserCode() == null : this.getUserCode().equals(other.getUserCode()))
                && (this.getUserStatus() == null ? other.getUserStatus() == null : this.getUserStatus().equals(other.getUserStatus()))
                && (this.getUserRemark() == null ? other.getUserRemark() == null : this.getUserRemark().equals(other.getUserRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getUserPsd() == null) ? 0 : getUserPsd().hashCode());
        result = prime * result + ((getUserEmail() == null) ? 0 : getUserEmail().hashCode());
        result = prime * result + ((getUserRealName() == null) ? 0 : getUserRealName().hashCode());
        result = prime * result + ((getUserPhone() == null) ? 0 : getUserPhone().hashCode());
        result = prime * result + ((getUserAddress() == null) ? 0 : getUserAddress().hashCode());
        result = prime * result + ((getUserCity() == null) ? 0 : getUserCity().hashCode());
        result = prime * result + ((getUserProvince() == null) ? 0 : getUserProvince().hashCode());
        result = prime * result + ((getUserPostalcode() == null) ? 0 : getUserPostalcode().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getUserIntroduce() == null) ? 0 : getUserIntroduce().hashCode());
        result = prime * result + ((getUserActiveCode() == null) ? 0 : getUserActiveCode().hashCode());
        result = prime * result + ((getUserCode() == null) ? 0 : getUserCode().hashCode());
        result = prime * result + ((getUserStatus() == null) ? 0 : getUserStatus().hashCode());
        result = prime * result + ((getUserRemark() == null) ? 0 : getUserRemark().hashCode());
        return result;
    }
}