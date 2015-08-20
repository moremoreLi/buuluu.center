package com.mobile.blue.buuluu.model;

import java.util.Date;

/**
 * 
 * @author More
 *2015-7-17
 */
public class AppUserSession extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1909836476937957243L;

	private String token;
	private Integer loginType;
	private Date loginTime;
	private Date logoutTime;
	private Integer device;
	private String deviceVerNum;
	private Integer status;
	private String userId;
	private String imei; 
	private String mac;
	private String imsi;
	private String lang;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getLoginType() {
		return loginType;
	}
	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Date getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}
	public Integer getDevice() {
		return device;
	}
	public void setDevice(Integer device) {
		this.device = device;
	}
	public String getDeviceVerNum() {
		return deviceVerNum;
	}
	public void setDeviceVerNum(String deviceVerNum) {
		this.deviceVerNum = deviceVerNum;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	
}
