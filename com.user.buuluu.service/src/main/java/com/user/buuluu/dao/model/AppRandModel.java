package com.user.buuluu.dao.model;

import java.io.Serializable;

/**
 * 
 * @author More
 *随机获取视频的model说
 */
public class AppRandModel implements Serializable{

	/**
	 *  v.picture AS icon,v.id AS sourceId,v.flowCoins AS makeFlows,v.title AS title,v.videoUrl
	 */
	private static final long serialVersionUID = -8966799072753269600L;

	private String icon;
	private  int sourceId;
	private int makeFlows;
	private String title;
	private String videoUrl;
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getSourceId() {
		return sourceId;
	}
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}
	
	public int getMakeFlows() {
		return makeFlows;
	}
	public void setMakeFlows(int makeFlows) {
		this.makeFlows = makeFlows;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
}
