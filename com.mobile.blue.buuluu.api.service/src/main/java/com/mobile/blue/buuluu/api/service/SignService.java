package com.mobile.blue.buuluu.api.service;

import java.sql.SQLException;
import java.util.List;

import com.mobile.blue.buuluu.model.AppUser;
import com.mobile.blue.buuluu.model.AppUserSign;

/**
 * 
 * @author More
 *2015-7-27
 * 用户签到接口 
 */
public interface SignService {

	/*
	 * 添加签到记录
	 */
	AppUserSign addSign(AppUser user) throws SQLException;

	/*
	 * 获取签到记录
	 */
	List<String> getSignList(String userId);

}
