package com.mobile.blue.buuluu.api.dao;

import java.sql.SQLException;

import com.mobile.blue.buuluu.model.AppAccountType;




/**
 * 
 * @author More
 * 2015-7-31
 * 绑定相关接口
 *
 */
public interface AccountTypeDao {

	/*
	 * 获取第三方类型
	 */
	AppAccountType getById(Integer type) throws SQLException;

}
