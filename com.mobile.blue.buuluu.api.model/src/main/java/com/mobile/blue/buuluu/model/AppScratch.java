package com.mobile.blue.buuluu.model;

/**
 * 
 * @author More
 *2015-7-27
 *用户刮刮卡
 */
public class AppScratch extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3152389934446226408L;
	
	private String img; //刮刮卡图片
	private Float flowCoins;//刮刮卡刮一次需要多少流量币
	private String description;//刮刮卡描述
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Float getFlowCoins() {
		return flowCoins;
	}
	public void setFlowCoins(Float flowCoins) {
		this.flowCoins = flowCoins;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	  
}
