package com.user.buuluu.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.center.buuluu.model.User;
import com.user.buuluu.annotation.CacheKey;
import com.user.buuluu.annotation.CachePut;
import com.user.buuluu.annotation.CacheValue;
import com.user.buuluu.annotation.Cacheable;
import com.user.buuluu.annotation.CachePut.PutTypeMode;
import com.user.buuluu.annotation.Cacheable.TypeMode;
import com.user.buuluu.common.Context;
import com.user.buuluu.dao.mapper.UserMapper;
import com.user.buuluu.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl extends Context implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
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
	

	
}
