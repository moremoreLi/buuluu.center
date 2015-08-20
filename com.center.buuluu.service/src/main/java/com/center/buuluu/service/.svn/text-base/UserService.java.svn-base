package com.center.buuluu.service;

import com.center.buuluu.model.AppUser;
import com.center.buuluu.model.User;


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

	    /**
	     * 根据国家编号和电话查找
	     * @param countryCode
	     * @param tel
	     * @return
	     */
		AppUser getByTel(String countryCode, String tel);
}
