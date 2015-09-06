package com.user.buuluu.dao.model;

import java.io.Serializable;

public class AppVideoAllRow implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -554381348357262726L;
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getTinypicture() {
		return tinypicture;
	}
	public void setTinypicture(String tinypicture) {
		this.tinypicture = tinypicture;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getExpiretime() {
		return expiretime;
	}
	public void setExpiretime(String expiretime) {
		this.expiretime = expiretime;
	}
	public String getVideourl() {
		return videourl;
	}
	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}
	public Integer getFlowcoins() {
		return flowcoins;
	}
	public void setFlowcoins(Integer flowcoins) {
		this.flowcoins = flowcoins;
	}
	public String getActivitydesc() {
		return activitydesc;
	}
	public void setActivitydesc(String activitydesc) {
		this.activitydesc = activitydesc;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private Integer categoryid;
	private String title;
	private String picture;
	private String tinypicture;
	private String description;
	private String createtime;
	private String expiretime;
	private String videourl;
	private Integer flowcoins;
	private String activitydesc;
	private Integer status;
}
