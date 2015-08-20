package com.mobile.blue.buuluu.model;

/**
 * 
 * @author More
 *用户反馈  2015-7-23
 */
public class AppFeedBack extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 361918166037702003L;

	private String userId;

	private String content;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
