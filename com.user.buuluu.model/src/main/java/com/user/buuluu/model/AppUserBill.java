package com.user.buuluu.model;

import java.io.Serializable;
import java.util.Date;

public class AppUserBill implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4875535121683072034L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user_bill.ID
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user_bill.USER_ID
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user_bill.SOURCE_ID
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    private Long sourceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user_bill.TYPE
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user_bill.DESCRIPTION
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user_bill.EXPIRE_TIME
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    private Date expireTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user_bill.FLOW_COINS
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    private Float flowCoins;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user_bill.REWARD_COINS
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    private Float rewardCoins;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user_bill.STATUS
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user_bill.CREATED_BY
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    private String createdBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user_bill.CREATED_TIME
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    private Date createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user_bill.UPDATED_BY
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    private String updatedBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user_bill.UPDATED_TIME
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    private Date updatedTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user_bill.IS_DELETED
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    private Integer isDeleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_bill.ID
     *
     * @return the value of app_user_bill.ID
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_bill.ID
     *
     * @param id the value for app_user_bill.ID
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_bill.USER_ID
     *
     * @return the value of app_user_bill.USER_ID
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_bill.USER_ID
     *
     * @param userId the value for app_user_bill.USER_ID
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_bill.SOURCE_ID
     *
     * @return the value of app_user_bill.SOURCE_ID
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public Long getSourceId() {
        return sourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_bill.SOURCE_ID
     *
     * @param sourceId the value for app_user_bill.SOURCE_ID
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_bill.TYPE
     *
     * @return the value of app_user_bill.TYPE
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
   

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_bill.DESCRIPTION
     *
     * @return the value of app_user_bill.DESCRIPTION
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public String getDescription() {
        return description;
    }

    public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_bill.DESCRIPTION
     *
     * @param description the value for app_user_bill.DESCRIPTION
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_bill.EXPIRE_TIME
     *
     * @return the value of app_user_bill.EXPIRE_TIME
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_bill.EXPIRE_TIME
     *
     * @param expireTime the value for app_user_bill.EXPIRE_TIME
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_bill.FLOW_COINS
     *
     * @return the value of app_user_bill.FLOW_COINS
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public Float getFlowCoins() {
        return flowCoins;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_bill.FLOW_COINS
     *
     * @param flowCoins the value for app_user_bill.FLOW_COINS
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public void setFlowCoins(Float flowCoins) {
        this.flowCoins = flowCoins;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_bill.REWARD_COINS
     *
     * @return the value of app_user_bill.REWARD_COINS
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public Float getRewardCoins() {
        return rewardCoins;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_bill.REWARD_COINS
     *
     * @param rewardCoins the value for app_user_bill.REWARD_COINS
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public void setRewardCoins(Float rewardCoins) {
        this.rewardCoins = rewardCoins;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_bill.STATUS
     *
     * @return the value of app_user_bill.STATUS
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_bill.STATUS
     *
     * @param status the value for app_user_bill.STATUS
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_bill.CREATED_BY
     *
     * @return the value of app_user_bill.CREATED_BY
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_bill.CREATED_BY
     *
     * @param createdBy the value for app_user_bill.CREATED_BY
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_bill.CREATED_TIME
     *
     * @return the value of app_user_bill.CREATED_TIME
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_bill.CREATED_TIME
     *
     * @param createdTime the value for app_user_bill.CREATED_TIME
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_bill.UPDATED_BY
     *
     * @return the value of app_user_bill.UPDATED_BY
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_bill.UPDATED_BY
     *
     * @param updatedBy the value for app_user_bill.UPDATED_BY
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_bill.UPDATED_TIME
     *
     * @return the value of app_user_bill.UPDATED_TIME
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_bill.UPDATED_TIME
     *
     * @param updatedTime the value for app_user_bill.UPDATED_TIME
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user_bill.IS_DELETED
     *
     * @return the value of app_user_bill.IS_DELETED
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user_bill.IS_DELETED
     *
     * @param isDeleted the value for app_user_bill.IS_DELETED
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}