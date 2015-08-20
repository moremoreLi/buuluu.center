package com.mobile.blue.buuluu.api.web.controller.webservice;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mobile.blue.buuluu.api.common.exception.BaseAPIException;
import com.mobile.blue.buuluu.api.common.exception.BlindAccountNotExistException;
import com.mobile.blue.buuluu.api.common.exception.BlindAccountTypeNotExistException;
import com.mobile.blue.buuluu.api.common.exception.ExistMobileException;
import com.mobile.blue.buuluu.api.common.exception.UserNotExistException;
import com.mobile.blue.buuluu.api.common.exception.WrongPasswordException;
import com.mobile.blue.buuluu.api.service.SnsAccountService;
import com.mobile.blue.buuluu.api.service.UserService;
import com.mobile.blue.buuluu.api.util.ResultUtil;
import com.mobile.blue.buuluu.api.web.handler.UserHandler;
import com.mobile.blue.buuluu.api.web.view.UserVO;
import com.mobile.blue.buuluu.model.AppAccountType;
import com.mobile.blue.buuluu.model.AppSnsAccount;
import com.mobile.blue.buuluu.model.AppUser;

/**
 * 
 * @author More
 * 绑定的相关接口的开发
 * 2015.7.31
 *
 */
@Controller
public class BlindUserSeviceController {

	private Log log = LogFactory.getLog(this.getClass());


	@Autowired
	private SnsAccountService snsAccountService;

	@Autowired
	private UserHandler userHandler;
	
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
	@RequestMapping(value = "/blindRegister.do",method=RequestMethod.POST)
	@Transactional
	public  String blindRegister(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String countryCode, String tel, Double log,Double lat,String pwd,Integer pushStatus, Integer type,String snsId,String vistorId) throws Exception {
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(snsId, null);
		Assert.notNull(type,null);
		String jsonStr = null;
		
		AppUser user = null;
		UserVO userVO = null;
		if (countryCode!=null && tel!=null) {
			user = userService.getByTel(countryCode,tel);
			if (user != null) 
				throw new ExistMobileException(lang);
		}
		
		userVO = userHandler.register(countryCode, tel, pwd, pushStatus, log, lat, lang, device, imei, mac, imsi, user, "", 2,vistorId);
		jsonStr = ResultUtil.getResultJson(userVO);
		model.put("message", jsonStr);
		return "message.json";
	}
	
	
	/**
	 * 绑定现有app账号登录
	@param lang  返回的语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param imsi   用户SIM卡号(没有时为”00000000”)
	 * @param countryCode  手机电话号码的国家编号
	 * @param tel  手机电话号码的国家编号
	 * @param pwd   用户密码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blindLogin.do",method=RequestMethod.POST)
	@Transactional
	public String blindLogin(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String countryCode, String tel, String pwd, Integer type,String snsId) throws Exception {
	   Assert.hasText(lang, null);
	   Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(countryCode, null);
		Assert.hasText(tel, null);
		Assert.hasText(pwd, null);
		Assert.notNull(type,null);
		Assert.hasText(snsId, null);
		String jsonStr = null;
		AppUser user = null;

		user = userService.getByTel(countryCode,tel);
		if (user == null) {
			throw new UserNotExistException(lang);
		}
		if(pwd.equals(user.getPwd())){
		AppSnsAccount appSnsAccount =	snsAccountService.addSns(user,type,snsId);
		if (appSnsAccount==null)
		throw new BaseAPIException();
		
			UserVO userVO =userHandler.login(lang, device, imei, mac, imsi, user);
			jsonStr = ResultUtil.getResultJson(userVO);
		}else{
			throw new WrongPasswordException(lang);
		}
		model.put("message", jsonStr);
		return "message.json";
	}
	
	/**
	 * 获取第三方是否有绑定过账号
	@param lang  返回的语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param imsi   用户SIM卡号(没有时为”00000000”)
	 * @param userId   用户id
	 * @param token   用户token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getBlindStatus.do",method=RequestMethod.POST)
	public String getBlindStatus(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String userId, String token) throws Exception {
	   Assert.hasText(lang, null);
	   Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId,null);
		Assert.hasText(token,null);
		String jsonStr = null;
		
		jsonStr = ResultUtil.getResultJson(false);

		model.put("message", jsonStr);
		return "message.json";
	}
	/**
	 * 绑定第三方（facebook，line）
	 * 1是faceBook
	 * 2是line 
	@param lang  返回的语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param imsi   用户SIM卡号(没有时为”00000000”)
	 * @param type   1是faceBook，2 是line
	 * @param snsId   faceBook或者line返回到唯一id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blindSns.do",method=RequestMethod.POST)
	public String blindSns(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , Integer type,String snsId,String snsToken, String userId, String token) throws Exception {
	   Assert.hasText(lang, null);
	   Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.notNull(type);
		Assert.hasText(snsId, null);
		Assert.hasText(snsToken, null);
		Assert.hasText(userId, null);
		Assert.hasText(token, null);
		String jsonStr = null;
		
		jsonStr = ResultUtil.getResultJson(true);

		model.put("message", jsonStr);
		return "message.json";
	}
	/**
	 * 获取用户faceBook 
	@param lang  返回的语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param imsi   用户SIM卡号(没有时为”00000000”)
	 * @param type   1是faceBook，2 是line
	 * @param snsId   faceBook或者line返回到唯一id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/snsLogin.do",method=RequestMethod.POST)
	public String snsLogin(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , Integer type,String snsId) throws Exception {
	   Assert.hasText(lang, null);
	   Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.notNull(type);
		Assert.hasText(snsId, null);
		String jsonStr = null;
		
		AppUser user = null;
		
		AppAccountType appAccountType = snsAccountService.getById(type);
		
		if (appAccountType==null) 		
			throw new BlindAccountTypeNotExistException(lang);
		
		 AppSnsAccount snsAccount =  snsAccountService.getSns(type,snsId);
		 if (snsAccount==null) 
			throw new BlindAccountNotExistException(lang);
		
		 
		 user = userService.getUserById(snsAccount.getUserId());
		 UserVO userVO =userHandler.login(lang, device, imei, mac, imsi, user);
		jsonStr = ResultUtil.getResultJson(userVO);

		model.put("message", jsonStr);
		return "message.json";
	}
}
