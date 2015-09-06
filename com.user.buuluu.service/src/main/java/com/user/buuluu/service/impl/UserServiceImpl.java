package com.user.buuluu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.buuluu.annotation.CacheDel;
import com.user.buuluu.annotation.CacheDel.DelsTypeMode;
import com.user.buuluu.annotation.CacheKey;
import com.user.buuluu.annotation.Cacheable;
import com.user.buuluu.annotation.Cacheable.TypeMode;
import com.user.buuluu.dao.mapper.AppBuuluuUserMapper;
import com.user.buuluu.model.AppBuuluuUser;
import com.user.buuluu.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private  AppBuuluuUserMapper appBuuluuUserMapper;
	
	@Override
	 @Cacheable(table=AppBuuluuUser.class,type=TypeMode.HASH) 
	public  AppBuuluuUser getUserById(@CacheKey String id) {
		 return appBuuluuUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public int add(AppBuuluuUser user) {
		return appBuuluuUserMapper.insertSelective(user);
	}

	@Override
	@CacheDel(table=AppBuuluuUser.class,type=DelsTypeMode.HASH)
	public int updateUser(AppBuuluuUser user,@CacheKey String userId) {
		return appBuuluuUserMapper.updateByPrimaryKeySelective(user);
	}
	

	
}
