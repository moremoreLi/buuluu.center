package com.mobile.blue.buuluu.model;

import java.util.Date;

public class ApiUser extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4568344276362195935L;
	private String session;
	private  Integer loginType;
	private  Date appDbUpdatedTime;
	private String appDbUploadPath;
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public Integer getLoginType() {
		return loginType;
	}
	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
	}
	public Date getAppDbUpdatedTime() {
		return appDbUpdatedTime;
	}
	public void setAppDbUpdatedTime(Date appDbUpdatedTime) {
		this.appDbUpdatedTime = appDbUpdatedTime;
	}
	public String getAppDbUploadPath() {
		return appDbUploadPath;
	}
	public void setAppDbUploadPath(String appDbUploadPath) {
		this.appDbUploadPath = appDbUploadPath;
	}
}
