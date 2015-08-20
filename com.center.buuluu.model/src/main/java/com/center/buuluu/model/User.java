package com.center.buuluu.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.ID
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private String id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.NICK_NAME
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private String nickName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.ICON
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private String icon;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.PWD
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private String pwd;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.TEL
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private String tel;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.COUNTRY_CODE
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private String countryCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.TEL_APPROVE_KEY
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private String telApproveKey;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.COUNTRY
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private String country;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.TEL_VALUE_FLAG
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private Integer telValueFlag;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.SEX
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private Integer sex;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.PUSH_STATUS
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private Integer pushStatus;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.LOG
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private Double log;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.LAT
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private Double lat;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.FLOW_COINS
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private Float flowCoins;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.MAKE_FLOW
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private Float makeFlow;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.USER_FLOW
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private Float userFlow;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.POINT
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private Integer point;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.CREDIT
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private Integer credit;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.CREATED_BY
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private String createdBy;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.CREATED_TIME
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private Date createdTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.UPDATED_BY
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private String updatedBy;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.UPDATED_TIME
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private Date updatedTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.IS_DELETED
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private Integer isDeleted;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column app_user.BIRTHDAY
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	private String birthday;
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.ID
	 * @return  the value of app_user.ID
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public String getId() {
		return id;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.ID
	 * @param id  the value for app_user.ID
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.NICK_NAME
	 * @return  the value of app_user.NICK_NAME
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.NICK_NAME
	 * @param nickName  the value for app_user.NICK_NAME
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName == null ? null : nickName.trim();
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.ICON
	 * @return  the value of app_user.ICON
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.ICON
	 * @param icon  the value for app_user.ICON
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.PWD
	 * @return  the value of app_user.PWD
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.PWD
	 * @param pwd  the value for app_user.PWD
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd == null ? null : pwd.trim();
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.TEL
	 * @return  the value of app_user.TEL
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.TEL
	 * @param tel  the value for app_user.TEL
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setTel(String tel) {
		this.tel = tel == null ? null : tel.trim();
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.COUNTRY_CODE
	 * @return  the value of app_user.COUNTRY_CODE
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.COUNTRY_CODE
	 * @param countryCode  the value for app_user.COUNTRY_CODE
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode == null ? null : countryCode.trim();
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.TEL_APPROVE_KEY
	 * @return  the value of app_user.TEL_APPROVE_KEY
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public String getTelApproveKey() {
		return telApproveKey;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.TEL_APPROVE_KEY
	 * @param telApproveKey  the value for app_user.TEL_APPROVE_KEY
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setTelApproveKey(String telApproveKey) {
		this.telApproveKey = telApproveKey == null ? null : telApproveKey
				.trim();
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.COUNTRY
	 * @return  the value of app_user.COUNTRY
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.COUNTRY
	 * @param country  the value for app_user.COUNTRY
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setCountry(String country) {
		this.country = country == null ? null : country.trim();
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.TEL_VALUE_FLAG
	 * @return  the value of app_user.TEL_VALUE_FLAG
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public Integer getTelValueFlag() {
		return telValueFlag;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.TEL_VALUE_FLAG
	 * @param telValueFlag  the value for app_user.TEL_VALUE_FLAG
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setTelValueFlag(Integer telValueFlag) {
		this.telValueFlag = telValueFlag;
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.SEX
	 * @return  the value of app_user.SEX
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.SEX
	 * @param sex  the value for app_user.SEX
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.PUSH_STATUS
	 * @return  the value of app_user.PUSH_STATUS
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public Integer getPushStatus() {
		return pushStatus;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.PUSH_STATUS
	 * @param pushStatus  the value for app_user.PUSH_STATUS
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setPushStatus(Integer pushStatus) {
		this.pushStatus = pushStatus;
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.LOG
	 * @return  the value of app_user.LOG
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public Double getLog() {
		return log;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.LOG
	 * @param log  the value for app_user.LOG
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setLog(Double log) {
		this.log = log;
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.LAT
	 * @return  the value of app_user.LAT
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public Double getLat() {
		return lat;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.LAT
	 * @param lat  the value for app_user.LAT
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setLat(Double lat) {
		this.lat = lat;
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.FLOW_COINS
	 * @return  the value of app_user.FLOW_COINS
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public Float getFlowCoins() {
		return flowCoins;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.FLOW_COINS
	 * @param flowCoins  the value for app_user.FLOW_COINS
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setFlowCoins(Float flowCoins) {
		this.flowCoins = flowCoins;
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.MAKE_FLOW
	 * @return  the value of app_user.MAKE_FLOW
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public Float getMakeFlow() {
		return makeFlow;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.MAKE_FLOW
	 * @param makeFlow  the value for app_user.MAKE_FLOW
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setMakeFlow(Float makeFlow) {
		this.makeFlow = makeFlow;
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.USER_FLOW
	 * @return  the value of app_user.USER_FLOW
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public Float getUserFlow() {
		return userFlow;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.USER_FLOW
	 * @param userFlow  the value for app_user.USER_FLOW
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setUserFlow(Float userFlow) {
		this.userFlow = userFlow;
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.POINT
	 * @return  the value of app_user.POINT
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public Integer getPoint() {
		return point;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.POINT
	 * @param point  the value for app_user.POINT
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setPoint(Integer point) {
		this.point = point;
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.CREDIT
	 * @return  the value of app_user.CREDIT
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public Integer getCredit() {
		return credit;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.CREDIT
	 * @param credit  the value for app_user.CREDIT
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.CREATED_BY
	 * @return  the value of app_user.CREATED_BY
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.CREATED_BY
	 * @param createdBy  the value for app_user.CREATED_BY
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy == null ? null : createdBy.trim();
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.CREATED_TIME
	 * @return  the value of app_user.CREATED_TIME
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.CREATED_TIME
	 * @param createdTime  the value for app_user.CREATED_TIME
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.UPDATED_BY
	 * @return  the value of app_user.UPDATED_BY
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.UPDATED_BY
	 * @param updatedBy  the value for app_user.UPDATED_BY
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy == null ? null : updatedBy.trim();
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.UPDATED_TIME
	 * @return  the value of app_user.UPDATED_TIME
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public Date getUpdatedTime() {
		return updatedTime;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.UPDATED_TIME
	 * @param updatedTime  the value for app_user.UPDATED_TIME
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.IS_DELETED
	 * @return  the value of app_user.IS_DELETED
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public Integer getIsDeleted() {
		return isDeleted;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.IS_DELETED
	 * @param isDeleted  the value for app_user.IS_DELETED
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column app_user.BIRTHDAY
	 * @return  the value of app_user.BIRTHDAY
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column app_user.BIRTHDAY
	 * @param birthday  the value for app_user.BIRTHDAY
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday == null ? null : birthday.trim();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 628104176110379936L;
	@Override
	public String toString() {
		return "User [id=" + id + ", nickName=" + nickName + ", icon=" + icon
				+ ", pwd=" + pwd + ", tel=" + tel + ", countryCode="
				+ countryCode + ", telApproveKey=" + telApproveKey
				+ ", country=" + country + ", telValueFlag=" + telValueFlag
				+ ", sex=" + sex + ", pushStatus=" + pushStatus + ", log="
				+ log + ", lat=" + lat + ", flowCoins=" + flowCoins
				+ ", makeFlow=" + makeFlow + ", userFlow=" + userFlow
				+ ", point=" + point + ", credit=" + credit + ", createdBy="
				+ createdBy + ", createdTime=" + createdTime + ", updatedBy="
				+ updatedBy + ", updatedTime=" + updatedTime + ", isDeleted="
				+ isDeleted + ", birthday=" + birthday + "]";
	}
	
	
}