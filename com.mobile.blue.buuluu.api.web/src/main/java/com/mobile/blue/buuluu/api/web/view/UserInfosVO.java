package com.mobile.blue.buuluu.api.web.view;

import java.io.Serializable;

/**
 * 
 * @author more.li
 *
 */
public class UserInfosVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4367811820904749150L;
	
	private String userId;//用户id
	private String icon;// 用户头像
	private String name;//用户昵称
	private String info;//消息内容
	private boolean isRead;//是否已经读取，false是未读，true是已经读取
	private Long createdTime;//消息时间
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public boolean isRead() {
		return isRead;
	}
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
	public Long getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Long createdTime) {
		this.createdTime = createdTime;
	}
	
}
