package com.mobile.blue.buuluu.api.dao;

import java.sql.SQLException;

import com.mobile.blue.buuluu.model.AppUser;


/**
 * 
 * @author More
 * 2015-7-15
 * 登陆相关接口
 *
 */
public interface UserDao {

	/*
	 * 根据国家编号和电话号码获取用户信息
	 */
	AppUser getByTel(String countryCode, String tel);

	/*
	 * 保存用户信息到用户表里面去
	 */
	AppUser save(AppUser user);

	/*
	 * 获取用户资料
	 */
	AppUser getUserById(String userId);

	/*
	 * 更改用户信息
	 */
	boolean upate(AppUser user) throws SQLException;



}
