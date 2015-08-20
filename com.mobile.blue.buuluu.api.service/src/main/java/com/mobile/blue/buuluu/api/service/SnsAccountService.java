package com.mobile.blue.buuluu.api.service;

import java.sql.SQLException;

import com.mobile.blue.buuluu.model.AppAccountType;
import com.mobile.blue.buuluu.model.AppSnsAccount;
import com.mobile.blue.buuluu.model.AppUser;


/**
 * 
 * @author More
 *2015-7-31
 * 第三方绑定相关接口 
 */
public interface SnsAccountService {

	/*
	 * 获取第三方账号类型
	 */
	AppAccountType getById(Integer type) throws SQLException;

	/*
	 * 获取是否绑定有第三方账号
	 */
	AppSnsAccount getSns(Integer type, String snsId);

	/*
	 * 添加绑定的第三方账号
	 */
	AppSnsAccount addSns(AppUser user, Integer type, String snsId) throws SQLException;

}
