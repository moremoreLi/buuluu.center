package com.user.buuluu.web.controller.webservice;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.user.buuluu.common.util.Constant;
import com.user.buuluu.common.util.DateUtil;
import com.user.buuluu.model.User;
import com.user.buuluu.service.UserService;
import com.user.buuluu.util.ResultUtil;

@Controller
public class TestServiceController {

	
	private Log log = LogFactory.getLog(this.getClass());

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/test.do")
	public String test(HttpServletRequest request, ModelMap model) throws Exception {
		
		log.info("-------test start-------");
		
		String jsonStr = null;
		
		User user =new User();
		user.setId(Constant.getUserId());
		user.setBirthday("1213213");
		user.setCountryCode("12121");
		user.setCreatedTime(DateUtil.getCurrentDate());
		User resultUser = userService.addUser(user,user.getId());
//		jsonStr = ResultUtil.getResultJson(resultUser);
		
		model.put("message", jsonStr);

		log.info("-------test end-------");
		return "message.json";
	}
	
	@RequestMapping(value = "/test1.do")
	public String test1(HttpServletRequest request, ModelMap model,String id) throws Exception {
		
		log.info("-------test start-------");
		
		String jsonStr = null;
		
		Object o = userService.getUserById(id);
//		jsonStr = ResultUtil.getResultJson(o);
		
		model.put("message", jsonStr);

		log.info("-------test end-------");
		return "message.json";
	}
}
