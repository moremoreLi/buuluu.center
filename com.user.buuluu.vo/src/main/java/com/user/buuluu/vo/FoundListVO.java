package com.user.buuluu.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author More
 *2015-8-4
 *发现返回的对象
 */
public class FoundListVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4581445338127180360L;
	
	private int type;//返回类型，1是视频，2是apk下载，3是游戏apk下载
	private List<RandomAdsModel> body;//内容主体
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<RandomAdsModel> getBody() {
		return body;
	}
	public void setBody(List<RandomAdsModel> body) {
		this.body = body;
	}

}
