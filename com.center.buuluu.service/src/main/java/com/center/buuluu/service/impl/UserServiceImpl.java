package com.center.buuluu.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.center.buuluu.annotation.CacheKey;
import com.center.buuluu.annotation.CachePut;
import com.center.buuluu.annotation.CachePut.PutTypeMode;
import com.center.buuluu.annotation.CacheValue;
import com.center.buuluu.annotation.Cacheable;
import com.center.buuluu.annotation.Cacheable.TypeMode;
import com.center.buuluu.common.Context;
import com.center.buuluu.dao.mapper.AppUserMapper;
import com.center.buuluu.dao.mapper.UserMapper;
import com.center.buuluu.model.AppUser;
import com.center.buuluu.model.User;
import com.center.buuluu.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl extends Context implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private AppUserMapper appUserMapper;
	
	@Override
	@CachePut(table=User.class,type=PutTypeMode.HASH)
	public User addUser(@CacheValue User user,@CacheKey String userId) {
		userMapper.insertSelective(user); 
     return user;
	}

	@Override
	 @Cacheable(table=User.class,type=TypeMode.HASH) 
	public  Object getUserById(@CacheKey String id) {
		 return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public AppUser getByTel(String countryCode, String tel) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("countryCode", countryCode);
		map.put("tel", tel);
		return appUserMapper.getByTel(map);
	}
	

	
}
