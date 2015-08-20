package com.mobile.blue.buuluu.api.service;

import java.sql.SQLException;

import com.mobile.blue.buuluu.model.ApiUser;
import com.mobile.blue.buuluu.model.AppUserSession;
/**
 * 
 * @author More
 *2015-7-17
 */
public interface UserSessionService {


	AppUserSession getUserSessionByUserId(String userId) throws SQLException;

	boolean updateUserSession(AppUserSession userSession) throws SQLException;

	/*
	 * 保存用户session
	 */
	AppUserSession addSession(String userId, String token, String lang,
			Integer device,String imei, String mac,
			String imsi);

	boolean  checkUserSession(ApiUser apiUser);

	/*
	 * 检测用户的id 和token是否有效
	 */
	AppUserSession checkUserSession(String userId, String token);

}
