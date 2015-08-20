package com.mobile.blue.buuluu.api.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author More
 * 2015-08-03
 * 用户获奖的对象类型
 *
 */
public class AppUserScratchModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8772085421037840391L;

	private Float makeFlows;
	private String description;
	private Date createTime;
	private String userId;
	private String countryCode;
	private String tel;
	private String icon;
	private Integer sex;
	public Float getMakeFlows() {
		return makeFlows;
	}
	public void setMakeFlows(Float makeFlows) {
		this.makeFlows = makeFlows;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
}
