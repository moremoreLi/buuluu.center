package com.mobile.blue.buuluu.api.service;

import java.sql.SQLException;

import com.mobile.blue.buuluu.model.AppVistorUser;


/**
 * 
 * @author More
 *2015-8-7
 *访客用户接口中心
 */
public interface VistorUserService {

	/*
	 * 添加访客用户信息
	 */
	AppVistorUser add(AppVistorUser user) throws SQLException;

	/*
	 * 根据id查找游客用户
	 */
	AppVistorUser getUserById(String userId) throws SQLException;

	/*
	 * 更改访客信息
	 */
	boolean update(AppVistorUser vistorUser) throws SQLException;


}
