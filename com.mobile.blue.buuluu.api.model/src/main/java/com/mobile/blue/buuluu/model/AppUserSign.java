package com.mobile.blue.buuluu.model;

import java.util.Date;

/**
 * 
 * @author More
 *2015-7-27
 *用户签到列表
 */
public class AppUserSign  extends AbstractEntity  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2566669016189948108L;
	
	private String userId;
	private Integer credit;
	private Date expireTime;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	
}
