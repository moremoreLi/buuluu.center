package com.mobile.blue.buuluu.api.dao;

import java.sql.SQLException;

import com.mobile.blue.buuluu.model.AppUserSession;

public interface UserSessionDao {


	AppUserSession getUserSessionByUserId(String userId) throws SQLException;

	AppUserSession add(AppUserSession userSession);

	boolean updateUserSession(AppUserSession userSession) throws SQLException;

	/*
	 * 保存用户的session信息到数据库表
	 */

	AppUserSession addSession(AppUserSession userSession);

	/*
	 * 检查用户的id和token是否有效
	 */
	AppUserSession checkUserSession(String userId, String token);

	/*
	 * 登出，将session去掉
	 */
	boolean logout(String userId, String token);

}
