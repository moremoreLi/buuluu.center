package com.mobile.blue.buuluu.model;

/**
 * 
 * @author More
 *2015-7-25
 *用户使用流量账单
 */
public class AppUserBillLog extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3152389934446226408L;
	
	private Integer billId;//账单id
	private String userId;//用户Id
	private Float flowCoins;//buuluu账号的流量币
	private Float userCoin;//buuluu_sim 账号的流量币
	private String description;//使用流量情况描述
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getBillId() {
		return billId;
	}
	public void setBillId(Integer billId) {
		this.billId = billId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Float getFlowCoins() {
		return flowCoins;
	}
	public void setFlowCoins(Float flowCoins) {
		this.flowCoins = flowCoins;
	}
	public Float getUserCoin() {
		return userCoin;
	}
	public void setUserCoin(Float userCoin) {
		this.userCoin = userCoin;
	}
}
