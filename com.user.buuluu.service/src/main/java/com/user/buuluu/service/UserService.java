package com.user.buuluu.service;

import com.user.buuluu.model.AppBuuluuUser;



public interface UserService {

	    /**
	      * 根据用户id获取用户
	      * @param userId
	      * @return
	      */
	AppBuuluuUser getUserById(String userId);
}
