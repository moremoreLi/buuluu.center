package com.user.buuluu.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.buuluu.annotation.CacheDel;
import com.user.buuluu.annotation.CacheKey;
import com.user.buuluu.annotation.Cacheable;
import com.user.buuluu.annotation.Cacheable.TypeMode;
import com.user.buuluu.common.Context;
import com.user.buuluu.dao.mapper.AppVistorUserMapper;
import com.user.buuluu.model.AppBuuluuUser;
import com.user.buuluu.model.AppVistorUser;
import com.user.buuluu.service.VistorUserService;

@Service("vistorUserService")
public class VistorUserServiceImpl extends Context implements VistorUserService {
	
	@Autowired
	private AppVistorUserMapper  appVistorUserMapper;

	@Override
	@Cacheable(table=AppBuuluuUser.class,type=TypeMode.HASH) 
	public int add(AppVistorUser user,@CacheKey String cache) throws SQLException {
		return appVistorUserMapper.insertSelective(user);
	}

	@Override
	@Cacheable(table=AppVistorUser.class)
	public AppVistorUser getUserById(@CacheKey String userId) throws SQLException {
		return appVistorUserMapper.selectByPrimaryKey(userId);
	}

	@Override
	@CacheDel(table=AppBuuluuUser.class) 
	public boolean update(AppVistorUser vistorUser,@CacheKey String cache) throws SQLException {
		return false;
	}
	
}
