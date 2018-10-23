package org.tsrj.model.member;

import java.io.Serializable;
import java.util.Date;
import org.tsrj.common.domain.BaseDomain;

public class Member extends BaseDomain<Long> implements Serializable {
    private Long id;

    private String userName;

    private String trueName;

    private String identityNumber;

    private String payPassword;

    private String password;

    private String mobile;

    private Short gender;

    private String registerIp;

    private String avatars;

    private Short isVerified;

    private Short stepPercent;

    private Short status;

    private String deviceSerialNumber;

    private Date createTime;

    private Date updateTime;

    private Short delFlag;

    private Boolean isHit;

    private Boolean useGesturePassword;

    private String channel;

    private String fadadaCustomerId;

    private Integer repayDay;

    private Integer isBaseRealName;

    private String nickName;

    private Date realNameTime;

    private Integer belongTo;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public String getAvatars() {
        return avatars;
    }

    public void setAvatars(String avatars) {
        this.avatars = avatars;
    }

    public Short getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Short isVerified) {
        this.isVerified = isVerified;
    }

    public Short getStepPercent() {
        return stepPercent;
    }

    public void setStepPercent(Short stepPercent) {
        this.stepPercent = stepPercent;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getDeviceSerialNumber() {
        return deviceSerialNumber;
    }

    public void setDeviceSerialNumber(String deviceSerialNumber) {
        this.deviceSerialNumber = deviceSerialNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Short getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Short delFlag) {
        this.delFlag = delFlag;
    }

    public Boolean getIsHit() {
        return isHit;
    }

    public void setIsHit(Boolean isHit) {
        this.isHit = isHit;
    }

    public Boolean getUseGesturePassword() {
        return useGesturePassword;
    }

    public void setUseGesturePassword(Boolean useGesturePassword) {
        this.useGesturePassword = useGesturePassword;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getFadadaCustomerId() {
        return fadadaCustomerId;
    }

    public void setFadadaCustomerId(String fadadaCustomerId) {
        this.fadadaCustomerId = fadadaCustomerId;
    }

    public Integer getRepayDay() {
        return repayDay;
    }

    public void setRepayDay(Integer repayDay) {
        this.repayDay = repayDay;
    }

    public Integer getIsBaseRealName() {
        return isBaseRealName;
    }

    public void setIsBaseRealName(Integer isBaseRealName) {
        this.isBaseRealName = isBaseRealName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getRealNameTime() {
        return realNameTime;
    }

    public void setRealNameTime(Date realNameTime) {
        this.realNameTime = realNameTime;
    }

    public Integer getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(Integer belongTo) {
        this.belongTo = belongTo;
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
        Member other = (Member) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getTrueName() == null ? other.getTrueName() == null : this.getTrueName().equals(other.getTrueName()))
            && (this.getIdentityNumber() == null ? other.getIdentityNumber() == null : this.getIdentityNumber().equals(other.getIdentityNumber()))
            && (this.getPayPassword() == null ? other.getPayPassword() == null : this.getPayPassword().equals(other.getPayPassword()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getRegisterIp() == null ? other.getRegisterIp() == null : this.getRegisterIp().equals(other.getRegisterIp()))
            && (this.getAvatars() == null ? other.getAvatars() == null : this.getAvatars().equals(other.getAvatars()))
            && (this.getIsVerified() == null ? other.getIsVerified() == null : this.getIsVerified().equals(other.getIsVerified()))
            && (this.getStepPercent() == null ? other.getStepPercent() == null : this.getStepPercent().equals(other.getStepPercent()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDeviceSerialNumber() == null ? other.getDeviceSerialNumber() == null : this.getDeviceSerialNumber().equals(other.getDeviceSerialNumber()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getIsHit() == null ? other.getIsHit() == null : this.getIsHit().equals(other.getIsHit()))
            && (this.getUseGesturePassword() == null ? other.getUseGesturePassword() == null : this.getUseGesturePassword().equals(other.getUseGesturePassword()))
            && (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
            && (this.getFadadaCustomerId() == null ? other.getFadadaCustomerId() == null : this.getFadadaCustomerId().equals(other.getFadadaCustomerId()))
            && (this.getRepayDay() == null ? other.getRepayDay() == null : this.getRepayDay().equals(other.getRepayDay()))
            && (this.getIsBaseRealName() == null ? other.getIsBaseRealName() == null : this.getIsBaseRealName().equals(other.getIsBaseRealName()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getRealNameTime() == null ? other.getRealNameTime() == null : this.getRealNameTime().equals(other.getRealNameTime()))
            && (this.getBelongTo() == null ? other.getBelongTo() == null : this.getBelongTo().equals(other.getBelongTo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getTrueName() == null) ? 0 : getTrueName().hashCode());
        result = prime * result + ((getIdentityNumber() == null) ? 0 : getIdentityNumber().hashCode());
        result = prime * result + ((getPayPassword() == null) ? 0 : getPayPassword().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getRegisterIp() == null) ? 0 : getRegisterIp().hashCode());
        result = prime * result + ((getAvatars() == null) ? 0 : getAvatars().hashCode());
        result = prime * result + ((getIsVerified() == null) ? 0 : getIsVerified().hashCode());
        result = prime * result + ((getStepPercent() == null) ? 0 : getStepPercent().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDeviceSerialNumber() == null) ? 0 : getDeviceSerialNumber().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getIsHit() == null) ? 0 : getIsHit().hashCode());
        result = prime * result + ((getUseGesturePassword() == null) ? 0 : getUseGesturePassword().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getFadadaCustomerId() == null) ? 0 : getFadadaCustomerId().hashCode());
        result = prime * result + ((getRepayDay() == null) ? 0 : getRepayDay().hashCode());
        result = prime * result + ((getIsBaseRealName() == null) ? 0 : getIsBaseRealName().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getRealNameTime() == null) ? 0 : getRealNameTime().hashCode());
        result = prime * result + ((getBelongTo() == null) ? 0 : getBelongTo().hashCode());
        return result;
    }

    public Member id(Long value) {
        this.id = value;
        return this;
    }

    public Member userName(String value) {
        this.userName = value;
        return this;
    }

    public Member trueName(String value) {
        this.trueName = value;
        return this;
    }

    public Member identityNumber(String value) {
        this.identityNumber = value;
        return this;
    }

    public Member payPassword(String value) {
        this.payPassword = value;
        return this;
    }

    public Member password(String value) {
        this.password = value;
        return this;
    }

    public Member mobile(String value) {
        this.mobile = value;
        return this;
    }

    public Member gender(Short value) {
        this.gender = value;
        return this;
    }

    public Member registerIp(String value) {
        this.registerIp = value;
        return this;
    }

    public Member avatars(String value) {
        this.avatars = value;
        return this;
    }

    public Member isVerified(Short value) {
        this.isVerified = value;
        return this;
    }

    public Member stepPercent(Short value) {
        this.stepPercent = value;
        return this;
    }

    public Member status(Short value) {
        this.status = value;
        return this;
    }

    public Member deviceSerialNumber(String value) {
        this.deviceSerialNumber = value;
        return this;
    }

    public Member createTime(Date value) {
        this.createTime = value;
        return this;
    }

    public Member updateTime(Date value) {
        this.updateTime = value;
        return this;
    }

    public Member delFlag(Short value) {
        this.delFlag = value;
        return this;
    }

    public Member isHit(Boolean value) {
        this.isHit = value;
        return this;
    }

    public Member useGesturePassword(Boolean value) {
        this.useGesturePassword = value;
        return this;
    }

    public Member channel(String value) {
        this.channel = value;
        return this;
    }

    public Member fadadaCustomerId(String value) {
        this.fadadaCustomerId = value;
        return this;
    }

    public Member repayDay(Integer value) {
        this.repayDay = value;
        return this;
    }

    public Member isBaseRealName(Integer value) {
        this.isBaseRealName = value;
        return this;
    }

    public Member nickName(String value) {
        this.nickName = value;
        return this;
    }

    public Member realNameTime(Date value) {
        this.realNameTime = value;
        return this;
    }

    public Member belongTo(Integer value) {
        this.belongTo = value;
        return this;
    }
}