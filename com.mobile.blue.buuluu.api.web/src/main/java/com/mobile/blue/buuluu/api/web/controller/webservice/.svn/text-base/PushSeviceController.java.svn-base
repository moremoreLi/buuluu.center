package com.mobile.blue.buuluu.api.web.controller.webservice;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mobile.blue.buuluu.api.common.exception.UserNotExistException;
import com.mobile.blue.buuluu.api.service.UserService;
import com.mobile.blue.buuluu.api.util.ResultUtil;
import com.mobile.blue.buuluu.model.AppUser;

/**
 * 
 * @author More
 * 绑定的相关接口的开发
 * 2015.7.31
 *
 */
@Controller
public class PushSeviceController {

	private Log log = LogFactory.getLog(this.getClass());


	@Autowired
	private UserService userService;

	
	
	
	/**
	 * 绑定快速注册
	 * @param request
	 * @param model
	   @param lang  返回的语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param imsi   用户SIM卡号(没有时为”00000000”)
	 * @param countryCode  手机电话号码的国家编号
	 * @param tel  手机电话号码的国家编号
	 * @param pwd   注册用户密码，后续再讨论加密
	 * @param pushStatus  推送状态，0是不推送，1是推送
	 * @param log 经度位置
	 * @param lat  纬度位置
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/pushMessage.do",method=RequestMethod.POST)
	public  String pushMessage(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String userId) throws Exception {
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId, null);
		String jsonStr = null;
		
		AppUser user = null;
		user = userService.getUserById(userId);
		
		if (user==null) 
			throw new UserNotExistException(lang);
		
		
		jsonStr = ResultUtil.getResultJson("");
		model.put("message", jsonStr);
		return "message.json";
	}
	
}
