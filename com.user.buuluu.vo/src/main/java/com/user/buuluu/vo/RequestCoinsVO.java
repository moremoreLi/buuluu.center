package com.user.buuluu.vo;

import java.io.Serializable;

/**
 * 
 * @author More
 *2015-8-4
 *请求流量返回的Mode
 */
public class RequestCoinsVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7320184720957571669L;
	
	private float flowCoins;//用户剩余的buuluu流量币
	private float userFlow;//用户剩下的buuluu—sim的流量
	private int point;//用户剩下积分
	private int credit;//用户剩余的信用值
	public float getFlowCoins() {
		return flowCoins;
	}
	public void setFlowCoins(float flowCoins) {
		this.flowCoins = flowCoins;
	}
	public float getUserFlow() {
		return userFlow;
	}
	public void setUserFlow(float userFlow) {
		this.userFlow = userFlow;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
}
