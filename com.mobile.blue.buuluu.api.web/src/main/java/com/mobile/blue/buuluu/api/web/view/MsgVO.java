package com.mobile.blue.buuluu.api.web.view;

import java.io.Serializable;

/**
 * 
 * @author More
 *2015-8-4
 * 消息返回对象
 */
public class MsgVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 370984734871028865L;
	
	private int typeId;//消息类型id
	private String  icon;//消息类型头像
	private String name; //消息名字
	private String info;//消息内容
	private long createTime;//消息最新时间
	private int unreadCount;//未读数量
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
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
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public int getUnreadCount() {
		return unreadCount;
	}
	public void setUnreadCount(int unreadCount) {
		this.unreadCount = unreadCount;
	}
	
}
