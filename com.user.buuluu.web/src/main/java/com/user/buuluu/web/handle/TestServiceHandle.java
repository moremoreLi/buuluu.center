package com.user.buuluu.web.handle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.buuluu.service.UserService;

public class TestServiceHandle {

	private Log log = LogFactory.getLog(this.getClass());

	@Autowired
	private UserService userService;

	public void test() throws Exception {
		
		log.info("-------test start-------");
		
		
	 userService.getUserById("33e5854b5296436ca37e74a697c52886");
		

		log.info("-------test end-------");
	}
}
