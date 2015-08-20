package com.mobile.blue.buuluu.api.service.impl;

import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.common.util.Constant;
import com.mobile.blue.buuluu.api.common.util.DateUtil;
import com.mobile.blue.buuluu.api.dao.UserDao;
import com.mobile.blue.buuluu.api.dao.UserSessionDao;
import com.mobile.blue.buuluu.api.dao.VistorUserDao;
import com.mobile.blue.buuluu.api.service.UserService;
import com.mobile.blue.buuluu.model.AppUser;
import com.mobile.blue.buuluu.model.AppVistorUser;

@Service
public class UserServiceImpl extends Context implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserSessionDao userSessionDao;
	
	@Autowired
	private VistorUserDao vistorUserDao;

	@Override
	public AppUser getByTel(String countryCode, String tel) {
		return userDao.getByTel(countryCode,tel);
	}

	@Override
	public AppUser register(String countryCode, String tel, String pwd,
			Integer pushStatus, Double log, Double lat,AppUser user, String activation, String vistorId) throws SQLException {
		user.setCountryCode(countryCode);
		user.setTel(tel);
		user.setPwd(pwd);
		user.setPushStatus(pushStatus);
		user.setLat(lat);
		user.setLog(log);
		user.setFlowCoins(0F);
		user.setMakeFlow(0F);
		user.setUserFlow(0F);
		user.setSex(1);
		user.setCredit(0);
		user.setPoint(0);
		user.setUpdatedBy(Constant.UPDATE_BY_API);
		user.setUpdatedTime(DateUtil.getCurrentDate());
		user.setBirthday(-28800000L);//默认原始时间 1970-01-01
		user.setIcon("");
		user.setCountry("");
		user.setNickName("");
		if (log==null) 
			user.setLog(0D);
		if (lat==null) 
			user.setLat(0D);
		if (StringUtils.isNotEmpty(vistorId)) {
			 AppVistorUser vistorUser = vistorUserDao.getUserById(vistorId);
			 if (vistorUser!=null) {
				 user.setFlowCoins(vistorUser.getFlowCoins());
					user.setMakeFlow(vistorUser.getMakeFlow());
					user.setUserFlow(vistorUser.getUserFlow());
			}
		}
		boolean flag =userDao.upate(user);
		if (flag) {
			return user;
		}else {
			return null;
		}
	}

	@Override
	public AppUser getUserById(String userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public boolean update(AppUser user) throws SQLException {
		return userDao.upate(user);
	}

	@Override
	public boolean logout(String userId, String token) {
		return userSessionDao.logout(userId,token);
	}

	@Override
	public AppUser add(AppUser user) {
		return userDao.save(user);
	}

	@Override
	public AppUser quickRegister(String countryCode, String tel, String pwd,Integer pushStatus, Double log, Double lat, AppUser user, String userId, String vistorId) throws SQLException {
		user = new AppUser();
		user.setCountryCode(countryCode);
		user.setTel(tel);
		user.setPwd(pwd);
		user.setPushStatus(pushStatus);
		user.setLat(lat);
		user.setLog(log);
		user.setId(userId);
		user.setFlowCoins(0F);
		user.setMakeFlow(0F);
		user.setUserFlow(0F);
		user.setCreatedBy(Constant.CREATE_BY_API);
		user.setCreatedTime(DateUtil.getCurrentDate());
		user.setTelValueFlag(2);
		user.setCredit(0);
		user.setPoint(0);
		user.setSex(1);
		user.setBirthday(-28800000L);//默认初始时间 1970-01-01
		user.setIcon("");
		user.setCountry("");
		user.setNickName("");
		
		if (log==null) 
			user.setLog(0D);
		if (lat==null) 
			user.setLat(0D);
		
		if (StringUtils.isNotEmpty(vistorId)) {
			 AppVistorUser vistorUser = vistorUserDao.getUserById(vistorId);
			 if (vistorUser!=null) {
				 user.setFlowCoins(vistorUser.getFlowCoins());
					user.setMakeFlow(vistorUser.getMakeFlow());
					user.setUserFlow(vistorUser.getUserFlow());
			}
		}
		
		return userDao.save(user);
	}

}
