package com.mobile.blue.buuluu.model;

/**
 * 
 * @author More
 *第三方绑定数据  2015-7-31
 */
public class AppSnsAccount extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 361918166037702003L;

	private String userId;//APP用户id
	private Integer accountTypeId;//第三方绑定账号类型
	private  String snsId;//第三方账号的账号id
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(Integer accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public String getSnsId() {
		return snsId;
	}
	public void setSnsId(String snsId) {
		this.snsId = snsId;
	}
}
