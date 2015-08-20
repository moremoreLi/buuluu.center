package com.mobile.blue.buuluu.model;

/**
 * 
 * @author More
 *2015-7-30
 *用户刮刮卡流量币使用情况
 */
public class AppUserScratch extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3152389934446226408L;
	
	private Integer type;//1是支出，2是收入
	private Float makeFlows;//使用的流量币数量
	private String description;//使用描述
	private String userId;//用户ID
	private Integer appScratchId;
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getAppScratchId() {
		return appScratchId;
	}
	public void setAppScratchId(Integer appScratchId) {
		this.appScratchId = appScratchId;
	}
}
