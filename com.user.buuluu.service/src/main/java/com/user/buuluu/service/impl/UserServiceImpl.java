package com.user.buuluu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.buuluu.annotation.CacheKey;
import com.user.buuluu.annotation.Cacheable;
import com.user.buuluu.annotation.Cacheable.TypeMode;
import com.user.buuluu.common.Context;
import com.user.buuluu.dao.mapper.AppBuuluuUserMapper;
import com.user.buuluu.model.AppBuuluuUser;
import com.user.buuluu.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl extends Context implements UserService{
	
	@Autowired
	private  AppBuuluuUserMapper appBuuluuUserMapper;
	
	@Override
	 @Cacheable(table=AppBuuluuUser.class,type=TypeMode.HASH) 
	public  AppBuuluuUser getUserById(@CacheKey String id) {
		 return appBuuluuUserMapper.selectByPrimaryKey(id);
	}
	

	
}
