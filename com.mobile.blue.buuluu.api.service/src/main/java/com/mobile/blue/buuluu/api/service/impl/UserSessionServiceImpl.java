package com.mobile.blue.buuluu.api.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.common.exception.IllegalUserSessionException;
import com.mobile.blue.buuluu.api.common.util.CodeStatus;
import com.mobile.blue.buuluu.api.common.util.Constant;
import com.mobile.blue.buuluu.api.common.util.DateUtil;
import com.mobile.blue.buuluu.api.common.util.I18nUtil;
import com.mobile.blue.buuluu.api.dao.UserSessionDao;
import com.mobile.blue.buuluu.api.service.UserSessionService;
import com.mobile.blue.buuluu.model.ApiUser;
import com.mobile.blue.buuluu.model.AppUserSession;

@Service
public class UserSessionServiceImpl extends Context implements UserSessionService{
	
	@Autowired
	private UserSessionDao userSessionDao;


	@Override
	public boolean checkUserSession(ApiUser apiUser) {
		boolean legal = false;
		try{
//			ApiUser redisSession = userSessionDao.getUserSessionByUserId(apiUser.getId().toString());
			ApiUser redisSession = null;
			if(redisSession != null){
				String userId=redisSession.getId().toString();
				String session=redisSession.getSession();
				if(userId.equals(apiUser.getId().toString()) && 
					session.equals(apiUser.getSession()) ){
					legal = true;
				}else{
					//legal = false;
					throw new IllegalUserSessionException(I18nUtil.getMessage(CodeStatus.USER_SESSION_EXCEPTION, null, null));
				}
			}else{
				//legal = false;
				throw new IllegalUserSessionException(I18nUtil.getMessage(CodeStatus.USER_SESSION_EXCEPTION, null, null));
			}
		}catch(Exception e){
			//legal = false;
			throw new IllegalUserSessionException(I18nUtil.getMessage(CodeStatus.USER_SESSION_EXCEPTION, null, null));
		}
		
		return legal;
	}


	@Override
	public AppUserSession getUserSessionByUserId(String userId) throws SQLException {
		return userSessionDao.getUserSessionByUserId(userId);
	}


	@Override
	public boolean updateUserSession(AppUserSession userSession) throws SQLException {
		return userSessionDao.updateUserSession(userSession);
	}


	@Override
	public AppUserSession addSession(String userId, String token, String lang,
			Integer device,String imei, String mac,
			String imsi) {
		AppUserSession userSession = new AppUserSession();
		userSession.setUserId(userId);
		userSession.setCreatedBy(Constant.CREATE_BY_API);
		userSession.setCreatedTime(DateUtil.getCurrentDate());
		userSession.setToken(token);
		userSession.setLoginTime(DateUtil.getCurrentDate());
		userSession.setLang(lang);
		userSession.setImei(imei);
		userSession.setMac(mac);
		userSession.setImsi(imsi);
		userSession.setStatus(1);
		return userSessionDao.addSession(userSession);
	}


	@Override
	public AppUserSession checkUserSession(String userId, String token) {
		AppUserSession userSession = userSessionDao.checkUserSession(userId,token);
		if (userSession==null) {
			throw new IllegalUserSessionException(I18nUtil.getMessage(CodeStatus.USER_SESSION_EXCEPTION, null, null));
		}
		return userSession ;
	}



}
