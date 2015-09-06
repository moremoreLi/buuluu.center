package com.user.buuluu.service;

import com.user.buuluu.model.AppBuuluuUser;



public interface UserService {

	    /**
	      * 根据用户id获取用户
	      * @param userId
	      * @return
	      */
	AppBuuluuUser getUserById(String userId);


		

	/**
	 * 添加用户
	 * @param userVO
	 * @return
	 */
	int add(AppBuuluuUser user);


	/**
	 * 更改用户信息
	 * @param user
	 * @return
	 */

	int updateUser(AppBuuluuUser user,String userId);
}
