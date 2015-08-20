package com.mobile.blue.buuluu.api.dao;

import java.sql.SQLException;

import com.mobile.blue.buuluu.model.AppVistorUser;



/**
 * 
 * @author More
 * 2015-8-7
 * 访客用户相关接口
 *
 */
public interface VistorUserDao {

	/*
	 * 添加访客用户信息到数据库
	 */
	AppVistorUser add(AppVistorUser user);

	/*
	 * 删除访客数据库里面相同的userId
	 * 
	 */
	boolean delete(AppVistorUser user) throws SQLException;

	/*
	 * 根据userId查找游客
	 */
	AppVistorUser getUserById(String userId) throws SQLException;

	/*
	 * 更改访客信息
	 */
	boolean update(AppVistorUser vistorUser) throws SQLException;



}
