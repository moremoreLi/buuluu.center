package com.user.buuluu.dao.mapper;

import org.springframework.stereotype.Component;

import com.center.buuluu.model.User;
import com.user.buuluu.annotation.MyBatisRepository;
@Component
@MyBatisRepository
public interface UserMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_user
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_user
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	int insert(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_user
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	int insertSelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_user
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	User selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_user
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_user
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	int updateByPrimaryKeyWithBLOBs(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_user
	 * @mbggenerated  Tue Aug 18 19:50:19 CST 2015
	 */
	int updateByPrimaryKey(User record);
}