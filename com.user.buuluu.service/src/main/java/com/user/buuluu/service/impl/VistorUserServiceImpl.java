package com.user.buuluu.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.buuluu.annotation.CacheKey;
import com.user.buuluu.annotation.Cacheable;
import com.user.buuluu.common.Context;
import com.user.buuluu.dao.mapper.AppVistorUserMapper;
import com.user.buuluu.model.AppVistorUser;
import com.user.buuluu.service.VistorUserService;

@Service("vistorUserService")
public class VistorUserServiceImpl extends Context implements VistorUserService {
	
	@Autowired
	private AppVistorUserMapper  appVistorUserMapper;

	@Override
	public AppVistorUser add(AppVistorUser user) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Cacheable(table=AppVistorUser.class)
	public AppVistorUser getUserById(@CacheKey String userId) throws SQLException {
		return appVistorUserMapper.selectByPrimaryKey(userId);
	}

	@Override
	public boolean update(AppVistorUser vistorUser) throws SQLException {
		return false;
	}
	
	/*@Autowired
	private VistorUserDao  vistorUserDao;

	@Override
	public AppVistorUser add(AppVistorUser user) throws SQLException {
		vistorUserDao.delete(user);
		
		user.setCountryCode("");
		user.setPwd("");
		user.setPushStatus(0);
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
			user.setLog(0D);
			user.setLat(0D);
		return vistorUserDao.add(user);
	}

	@Override
	public AppVistorUser getUserById(String userId) throws SQLException {
		return vistorUserDao.getUserById(userId);
	}

	@Override
	public boolean update(AppVistorUser vistorUser) throws SQLException {
		return vistorUserDao.update(vistorUser);
	}*/
	
}
