package com.mobile.blue.buuluu.api.service;

import java.sql.SQLException;

import com.mobile.blue.buuluu.model.AppUser;

/**
 * 
 * @author More
 *2015-7-15
 */
public interface UserService {

	/*
	 * 根据国家编号和电话号码获取用户信息
	 */
	AppUser getByTel(String countryCode, String tel);

	/*
	 * 注册用户信息到数据库表格
	 */
	AppUser register(String countryCode, String tel, String pwd,
			Integer pushStatus, Double log, Double lat,AppUser user, String activation, String vistorId) throws SQLException;

	/*
	 * 根据userId获取用户资料
	 */
	AppUser getUserById(String userId);

	/*
	 * 更改用户信息
	 */
	boolean update(AppUser user) throws SQLException;

	/*
	 * 登出，把session去掉
	 */
	boolean logout(String userId, String token);

	/*
	 * 添加用户信息
	 */
	AppUser add(AppUser user);

	/*
	 * 快速注册用户信息到数据库表格
	 */
	AppUser quickRegister(String countryCode, String tel, String pwd,
			Integer pushStatus, Double log, Double lat, AppUser user, String userId, String vistorId) throws SQLException;
	
	

}
