package com.mobile.blue.buuluu.api.web.handler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.mobile.blue.buuluu.api.common.exception.BaseAPIException;
import com.mobile.blue.buuluu.api.common.util.Constant;
import com.mobile.blue.buuluu.api.common.util.DateUtil;
import com.mobile.blue.buuluu.api.common.util.I18nUtil;
import com.mobile.blue.buuluu.api.common.util.Json;
import com.mobile.blue.buuluu.api.common.util.PropertiesUtil;
import com.mobile.blue.buuluu.api.service.SmsService;
import com.mobile.blue.buuluu.api.service.UserService;
import com.mobile.blue.buuluu.api.service.UserSessionService;
import com.mobile.blue.buuluu.api.util.HttpClientUtils;
import com.mobile.blue.buuluu.api.web.view.UserVO;
import com.mobile.blue.buuluu.model.AppUser;
import com.mobile.blue.buuluu.model.AppUserSession;

/**
 * user用户表的相关
 * @author More
 *2015-7-17
 */
public class UserHandler {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserSessionService userSessionService;
	
	@Autowired
	private SmsService smsService;
	
	private static final String SMS_DOMAIN= PropertiesUtil.getProperty("SMS_DOMAIN");

	//registerType 快速注册类型，1是普通注册，2是快速注册
	public UserVO register(String countryCode,String tel,String pwd,Integer pushStatus,Double log,Double lat, String lang, Integer device, String imei, String mac, String imsi, AppUser user, String activation,int registerType, String vistorId) throws SQLException {
		UserVO vo = null;
		if (registerType==1) {
			String userId = user.getId().toString();
			user =userService.register(countryCode, tel, pwd, pushStatus, log, lat,user,activation,vistorId);
			if (user!=null) {
				String token = Constant.getSessionId();
				AppUserSession userSession = userSessionService.addSession(userId,token,lang, device,imei,mac,imsi);
				if (userSession!=null) {
					vo = new UserVO();
					vo.setUserId(userId);
					vo.setToken(token);
					vo.setLat(user.getLat());
					vo.setLog(user.getLog());
					vo.setUserFlow(user.getUserFlow());
					vo.setFlowCoins(user.getFlowCoins());
					vo.setMakeFlow(user.getMakeFlow());
					vo.setCredit(user.getCredit());
					vo.setNickName(user.getNickName());
					vo.setIcon(user.getIcon());
					vo.setCountry(user.getCountry());
					vo.setBirthday(user.getBirthday());
					vo.setTel(user.getTel());
				}
			}
			
			if (vo==null) 
				throw new BaseAPIException();
		}else {
			String userId = Constant.getUserId();
			user =userService.quickRegister(countryCode, tel, pwd, pushStatus, log, lat,user,userId,vistorId);
			if (user!=null) {
				String token = Constant.getSessionId();
				AppUserSession userSession = userSessionService.addSession(userId,token,lang, device,imei,mac,imsi);
				if (userSession!=null) {
					vo = new UserVO();
					vo.setUserId(userId);
					vo.setToken(token);
					vo.setUserFlow(user.getUserFlow());
					vo.setFlowCoins(user.getFlowCoins());
					vo.setMakeFlow(user.getMakeFlow());
					vo.setCredit(user.getCredit());
					vo.setNickName(user.getNickName());
					vo.setIcon(user.getIcon());
					vo.setCountry(user.getCountry());
					vo.setBirthday(user.getBirthday());
					vo.setLat(user.getLat());
					vo.setLog(user.getLog());
					vo.setTel(user.getTel());
				}
			}
			
			if (vo==null) 
				throw new BaseAPIException();
		}
		
		return vo;
	}

	public UserVO login(String lang,Integer  device,String imei,String mac,String imsi,AppUser user) throws SQLException {
		AppUserSession userSession = null;
		String userId = user.getId().toString();
		UserVO vo = null;
		 userSession =userSessionService.getUserSessionByUserId(userId);
		 String token = null;
		if (userSession==null) {
			token = Constant.getSessionId();
			userSession = userSessionService.addSession(userId,token,lang, device,imei,mac,imsi);
		}else {
			token = Constant.getSessionId();
			userSession.setUpdatedBy(Constant.UPDATE_BY_API);
			userSession.setUpdatedTime(DateUtil.getCurrentDate());
			userSession.setStatus(1);
			userSession.setImei(imei);
			userSession.setMac(mac);
			userSession.setImsi(imsi);
			userSession.setLang(lang);
			userSession.setToken(token);
			userSessionService.updateUserSession(userSession);
		}
		if (token!=null) {
			vo = new UserVO();
			vo.setUserId(userId);
			vo.setToken(token);
			vo.setBirthday(user.getBirthday());
			vo.setIcon(user.getIcon());
			vo.setLat(user.getLat());
			vo.setLog(user.getLog());
			vo.setNickName(user.getNickName());
			vo.setTel(user.getTel());
			vo.setSex(user.getSex());
			vo.setFlowCoins(user.getFlowCoins());
			vo.setMakeFlow(user.getMakeFlow());
			vo.setUserFlow(user.getUserFlow());
			vo.setCredit(user.getCredit());
		}else {
			throw new BaseAPIException();
		}
		return vo;
	}

	/*
	 * msisdn（必选）： 下发手机号码，可以为一个或多个，多个用逗号隔开。以国家码开头，形如 66880889858, 0880889858. 如果手机号以0开头，则countrycode一定为必选。

        countrycode（可选）： 国家电话号码区号，以非0非+数字开头。

        msg（必选）：下发内容本身，需要对内容进行urlencode，例如msg=Test%20Msg。
        http://58.96.173.161:8081/notifyCentreServer/sms?countrycode=66&msisdn=0805723615&msg=Test%20Msg
	 */
	public boolean update(AppUser user,String lang,String countryCode,String tel) throws Exception {
		ResourceBundleMessageSource s = new ResourceBundleMessageSource();
		s.setBasename("i18n/message");
		String msg = s.getMessage("subject", null,I18nUtil.getLocale(lang));
		String autoCode = getAutCode(6);
		
		msg = msg.replaceAll("autoCode", autoCode);
		Map<String,String> params = new HashMap<String, String>();
		params.put("countrycode", countryCode);
		params.put("msg", msg);
		params.put("msisdn",tel );
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			String result = HttpClientUtils.postMethodRequest(SMS_DOMAIN, params);
			System.out.println("result="+result);
			resultMap = Json.toMap(result);
		} catch (Exception e) {
			//因为国内发送不了sms，暂时定到都成功
			resultMap.put("status", "200");
			//因为发送短信机制用不了，设定短信为1234
			autoCode = "1234";
		}
		if (!countryCode.equals("66")) {
			autoCode = "1234";
			if (user!=null) {
				user.setTelApproveKey(autoCode);
				user.setTelValueFlag(1);
				user.setTel(tel);
				user.setCountryCode(countryCode);
				user.setUpdatedBy(Constant.UPDATE_BY_API);
				user.setUpdatedTime(DateUtil.getCurrentDate());
				return userService.update(user);
			}else {
				user = new AppUser();
				user.setTelApproveKey(autoCode);
				user.setTelValueFlag(1);
				user.setTel(tel);
				user.setCountryCode(countryCode);
				user.setCreatedBy(Constant.CREATE_BY_API);
				user.setCreatedTime(DateUtil.getCurrentDate());
				user.setId(Constant.getUserId());
				user.setFlowCoins(0F);
				user.setMakeFlow(0F);
				user.setUserFlow(0F);
				user.setSex(1);
				user.setCredit(0);
				user.setPoint(0);
				user.setBirthday(-28800000L);//默认原始时间 1970-01-01
				user.setIcon("");
				user.setCountry("");
				user.setNickName("");
				user.setLog(0D);
				user.setLat(0D);
				user = userService.add(user);
				if (user!=null) {
					return true;
				}else{
					return false;
				}
			}
		}else if (resultMap.get("status").toString().equals("200")) {
			if (user!=null) {
				user.setTelApproveKey(autoCode);
				user.setTelValueFlag(1);
				user.setTel(tel);
				user.setCountryCode(countryCode);
				user.setUpdatedBy(Constant.UPDATE_BY_API);
				user.setUpdatedTime(DateUtil.getCurrentDate());
				return userService.update(user);
			}else {
				user = new AppUser();
				user.setTelApproveKey(autoCode);
				user.setTelValueFlag(1);
				user.setTel(tel);
				user.setCountryCode(countryCode);
				user.setCreatedBy(Constant.CREATE_BY_API);
				user.setCreatedTime(DateUtil.getCurrentDate());
				user.setId(Constant.getUserId());
				user.setFlowCoins(0F);
				user.setMakeFlow(0F);
				user.setUserFlow(0F);
				user.setSex(1);
				user.setCredit(0);
				user.setPoint(0);
				user.setBirthday(-28800000L);//默认原始时间 1970-01-01
				user.setIcon("");
				user.setCountry("");
				user.setNickName("");
				user.setLog(0D);
				user.setLat(0D);
				user = userService.add(user);
				if (user!=null) {
					return true;
				}else{
					return false;
				}
			}
		}else {
			
			throw new BaseAPIException();
		}
	}
	
	private  String getAutCode(int size){
		String str ="";
	        Random random = new Random();
	        List<Integer> list = new ArrayList<Integer>();
	        Integer temp = 0;
	       out:for (int i = 0; i < size; i++) {
	        	temp=random.nextInt(10);
//	        	if (list.contains(temp)) {
//					while(true){
//						temp =random.nextInt(10);
//						if (!list.contains(temp)) {
//							list.add(temp);
//							continue out;
//						}
//					}
//				}
	        	list.add(temp);
		   }

	        for (Integer integer : list) {
				str+=integer;
			}
	        return str;
	}
}
