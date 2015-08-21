package com.user.buuluu.service;

import com.user.buuluu.model.User;


public interface UserService {

	/**
	       * 添加用户
	      * @param user
	      */
	     User addUser(User user,String userId);
	    
	    /**
	      * 根据用户id获取用户
	      * @param userId
	      * @return
	      */
	    Object getUserById(String userId);
}
