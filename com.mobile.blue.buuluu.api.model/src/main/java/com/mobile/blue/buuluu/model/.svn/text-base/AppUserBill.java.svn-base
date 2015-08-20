package com.mobile.blue.buuluu.model;

import java.util.Date;

/**
 * 
 * @author More
 *2015-7-25
 *用户使用流量账单
 */
public class AppUserBill extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3152389934446226408L;
	
	private String userId;//用户id
	private Integer sourceId;//资源id
	private Integer type;//1:视频 2: APP 3:GAME
	private String description;//账单描述
	private Date expireTime;//账单过期时间
	private Float flowCoins;//这个账单用户剩下的流量币
	private Integer status;//视频是否是完成状态 (0是未完成，1是完成)
	private Float rewardCoins;//获得的流量包总奖励
	
	
	public Float getRewardCoins() {
		return rewardCoins;
	}
	public void setRewardCoins(Float rewardCoins) {
		this.rewardCoins = rewardCoins;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Float getFlowCoins() {
		return flowCoins;
	}
	public void setFlowCoins(Float flowCoins) {
		this.flowCoins = flowCoins;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getSourceId() {
		return sourceId;
	}
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
