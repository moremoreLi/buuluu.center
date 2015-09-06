package com.user.buuluu.model;

import java.io.Serializable;
import java.util.Date;

public class AppUserScratch implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4922902449221577999L;

	private Long id;

    private String userId;
    private String token;
    private Integer loginType;
    private Date loginTime;
    private Date logoutTime;
    private String lang;
    private String device;
    private String deviceVerNum;
    private String imei;
    private String mac;
    private String imsi;
    private Integer status;
    private String createdBy;
    private Date createdTime;
    private String updatedBy;
    private Date updatedTime;
    private Integer isDeleted;
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_scratch.ID
     *
     * @param id the value for app_user_scratch.ID
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_scratch.USER_ID
     *
     * @return the value of app_user_scratch.USER_ID
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_scratch.USER_ID
     *
     * @param userId the value for app_user_scratch.USER_ID
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_scratch.TOKEN
     *
     * @return the value of app_user_scratch.TOKEN
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public String getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_scratch.TOKEN
     *
     * @param token the value for app_user_scratch.TOKEN
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_scratch.LOGIN_TYPE
     *
     * @return the value of app_user_scratch.LOGIN_TYPE
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public Integer getLoginType() {
        return loginType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_scratch.LOGIN_TYPE
     *
     * @param loginType the value for app_user_scratch.LOGIN_TYPE
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_scratch.LOGIN_TIME
     *
     * @return the value of app_user_scratch.LOGIN_TIME
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_scratch.LOGIN_TIME
     *
     * @param loginTime the value for app_user_scratch.LOGIN_TIME
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_scratch.LOGOUT_TIME
     *
     * @return the value of app_user_scratch.LOGOUT_TIME
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public Date getLogoutTime() {
        return logoutTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_scratch.LOGOUT_TIME
     *
     * @param logoutTime the value for app_user_scratch.LOGOUT_TIME
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_scratch.LANG
     *
     * @return the value of app_user_scratch.LANG
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public String getLang() {
        return lang;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_scratch.LANG
     *
     * @param lang the value for app_user_scratch.LANG
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public void setLang(String lang) {
        this.lang = lang == null ? null : lang.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_scratch.DEVICE
     *
     * @return the value of app_user_scratch.DEVICE
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public String getDevice() {
        return device;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_scratch.DEVICE
     *
     * @param device the value for app_user_scratch.DEVICE
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public void setDevice(String device) {
        this.device = device == null ? null : device.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_scratch.DEVICE_VER_NUM
     *
     * @return the value of app_user_scratch.DEVICE_VER_NUM
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public String getDeviceVerNum() {
        return deviceVerNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_scratch.DEVICE_VER_NUM
     *
     * @param deviceVerNum the value for app_user_scratch.DEVICE_VER_NUM
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public void setDeviceVerNum(String deviceVerNum) {
        this.deviceVerNum = deviceVerNum == null ? null : deviceVerNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_scratch.IMEI
     *
     * @return the value of app_user_scratch.IMEI
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public String getImei() {
        return imei;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_scratch.IMEI
     *
     * @param imei the value for app_user_scratch.IMEI
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_scratch.MAC
     *
     * @return the value of app_user_scratch.MAC
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public String getMac() {
        return mac;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_scratch.MAC
     *
     * @param mac the value for app_user_scratch.MAC
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_scratch.IMSI
     *
     * @return the value of app_user_scratch.IMSI
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public String getImsi() {
        return imsi;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_scratch.IMSI
     *
     * @param imsi the value for app_user_scratch.IMSI
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public void setImsi(String imsi) {
        this.imsi = imsi == null ? null : imsi.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_scratch.STATUS
     *
     * @return the value of app_user_scratch.STATUS
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_scratch.STATUS
     *
     * @param status the value for app_user_scratch.STATUS
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_scratch.CREATED_BY
     *
     * @return the value of app_user_scratch.CREATED_BY
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_scratch.CREATED_BY
     *
     * @param createdBy the value for app_user_scratch.CREATED_BY
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_scratch.CREATED_TIME
     *
     * @return the value of app_user_scratch.CREATED_TIME
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_scratch.CREATED_TIME
     *
     * @param createdTime the value for app_user_scratch.CREATED_TIME
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_scratch.UPDATED_BY
     *
     * @return the value of app_user_scratch.UPDATED_BY
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_scratch.UPDATED_BY
     *
     * @param updatedBy the value for app_user_scratch.UPDATED_BY
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_scratch.UPDATED_TIME
     *
     * @return the value of app_user_scratch.UPDATED_TIME
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_scratch.UPDATED_TIME
     *
     * @param updatedTime the value for app_user_scratch.UPDATED_TIME
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_scratch.IS_DELETED
     *
     * @return the value of app_user_scratch.IS_DELETED
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_scratch.IS_DELETED
     *
     * @param isDeleted the value for app_user_scratch.IS_DELETED
     *
     * @mbggenerated Tue Sep 08 12:09:04 CST 2015
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}