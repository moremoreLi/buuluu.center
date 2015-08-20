package com.mobile.blue.buuluu.api.web.view;

import java.io.Serializable;

/**
 * 
 * @author More
 *2015-8-5
 * 流量包规则
 */
public class FlowPkgVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 370984734871028865L;
	
	private int type;//流量包id
	private int  flowCoins;//流量包获取的多少M流量币
	private int expireDate; //流量包过期天数
	private int  freeCoins;//流量包获取的多少M流量
	
	public int getFreeCoins() {
		return freeCoins;
	}
	public void setFreeCoins(int freeCoins) {
		this.freeCoins = freeCoins;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getFlowCoins() {
		return flowCoins;
	}
	public void setFlowCoins(int flowCoins) {
		this.flowCoins = flowCoins;
	}
	public int getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(int expireDate) {
		this.expireDate = expireDate;
	}
}
