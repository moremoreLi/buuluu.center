package com.mobile.blue.buuluu.api.dao.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.dao.UserSessionDao;
import com.mobile.blue.buuluu.api.dao.mysql.UserSessionDaoMysql;
import com.mobile.blue.buuluu.api.dao.redis.UserSessionDaoRedis;
import com.mobile.blue.buuluu.model.AppUserSession;

@Repository
public class UserSessionDaoImpl extends Context implements UserSessionDao{
	
	@Autowired
	private UserSessionDaoMysql userSessionDaoMysql;
	
	@Autowired
	private UserSessionDaoRedis userSessionDaoRedis;

	@Override
	public synchronized AppUserSession add(AppUserSession userSession) {
//		UserSession newUserSession =  userSessionDaoMysql.getUserSessionByUserId(userSession.getUserId());
		AppUserSession newUserSession =  null;
		try {
//			if (newUserSession==null) {
				newUserSession = userSessionDaoMysql.add(userSession);
				if (newUserSession!=null &&newUserSession.getId()!=null) {
//					userSessionDaoRedis.add(newUserSession.getUserId(), newUserSession);
				}else {
					newUserSession = userSessionDaoMysql.add(userSession);
				}
//			}else {
//				return newUserSession;
//			}
		} catch (Exception e) {
			return newUserSession;
		}
		
		return newUserSession;
	}

//	@Override
//	public int updateById(Object userId) {
//		int  record =userSessionDaoMysql.updateById(userId);
//		if (record>=0) {
//			userSessionDaoRedis.del(userId);
//		}
//		return record;
//	}

	@Override
	public AppUserSession getUserSessionByUserId(String userId) throws SQLException {
		
		AppUserSession userSession = null;
		try {
//			userSession = userSessionDaoRedis.get(userId);
			if (userSession==null) {
				userSession = userSessionDaoMysql.getUserSessionByUserId(userId);
				if (userSession!=null) {
//					userSessionDaoRedis.add(userSession);
				}else {
					userSession = userSessionDaoMysql.getUserSessionByUserId(userId);
				}
			}
			
		} catch (Exception e) {
			userSession = userSessionDaoMysql.getUserSessionByUserId(userId);
		}
			
		return userSession;
	}

	@Override
	public boolean updateUserSession(AppUserSession userSession) throws SQLException {
		boolean flag =userSessionDaoMysql.update(userSession);
		return flag;
	}

	@Override
	public AppUserSession addSession(AppUserSession userSession) {
		return userSessionDaoMysql.add(userSession);
	}

	@Override
	public AppUserSession checkUserSession(String userId, String token) {
		return userSessionDaoMysql.checkUserSession(userId,token);
	}

	@Override
	public boolean logout(String userId, String token) {
		return userSessionDaoMysql.logout(userId,token);
	}



}
