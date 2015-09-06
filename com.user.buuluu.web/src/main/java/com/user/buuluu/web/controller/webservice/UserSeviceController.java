package com.user.buuluu.web.controller.webservice;

import java.util.HashMap;
import java.util.Map;

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

import com.alibaba.druid.util.StringUtils;
import com.google.gson.internal.LinkedTreeMap;
import com.user.buuluu.common.exception.BaseAPIException;
import com.user.buuluu.common.exception.IllegalUserSessionException;
import com.user.buuluu.common.exception.UserNotExistException;
import com.user.buuluu.common.util.CodeStatus;
import com.user.buuluu.common.util.Constant;
import com.user.buuluu.common.util.DateUtil;
import com.user.buuluu.model.AppBuuluuUser;
import com.user.buuluu.model.AppVistorUser;
import com.user.buuluu.service.UserService;
import com.user.buuluu.service.VistorUserService;
import com.user.buuluu.util.HttpClientUtils;
import com.user.buuluu.util.ResultUtil;
import com.user.buuluu.vo.UserVO;
import com.user.buuluu.web.view.ResultVO;


/**
 * 
 * @author More
 * 用户的相关接口
 * 2015.8.25
 *
 */
@Controller
public class UserSeviceController {

	private Log log = LogFactory.getLog(this.getClass());
	
	public static final String CENTER_SERVER="http://120.25.2.222/buuluu_webservice";
	
	@Autowired
	private VistorUserService vistorUserService;
	
	@Autowired
	private UserService userService;
	
	private Map<String,String> returnMap(String lang,Integer device,String deviceVerNum,String imei,String mac,String imsi){
		Map<String,String> map = new HashMap<String, String>();
		map.put("lang",lang );
		map.put("device",device+"");
		map.put("deviceVerNum", deviceVerNum);
		map.put("imei", imei);
		map.put("mac", mac);
		map.put("imsi",imsi );
		return map;
	}
	/**
	 * 获取验证码
	 * @param request
	 * @param model
	 * @param lang  返回的数量语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param imsi   用户SIM卡号(没有时为”00000000”)
	 * @param countryCode  手机电话号码的国家编号
	 * @param tel  手机电话号码的国家编号
	 * @param type  验证码类型(1:注册 2:重置 3:修改)
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sendActivation.do",method=RequestMethod.POST)
	@Transactional
	public String sendActivation(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String countryCode, String tel, Integer type) throws Exception {
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(countryCode,null);
		Assert.hasText(tel,null);
		Assert.notNull(type);
		Map<String,String> map = returnMap(lang, device, deviceVerNum, imei, mac, imsi);
		
		map.put("countryCode", countryCode);
		map.put("tel", tel);
		map.put("type", type+"");
		String result = HttpClientUtils.postMethodRequest(CENTER_SERVER+ "/sendActivation.do", map);
		model.put("message", result);
		return "message.json";
	}
	
    /**
	 * 注册
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
	 * @param deviceId   手机的deviceId(用来后期服务器注册push）
	 * @param log 经度位置
	 * @param lat  纬度位置
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/register.do",method=RequestMethod.POST)
	@Transactional
	public  String register(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String countryCode, String tel, Double log,Double lat,String pwd,Integer pushStatus,String activation,Float flowCoins) throws Exception {
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(countryCode,null);
		Assert.hasText(tel,null);
		Assert.hasText(pwd,null);
		Assert.hasText(activation,null);
		
		Map<String,String> map = returnMap(lang, device, deviceVerNum, imei, mac, imsi);
		map.put("countryCode", countryCode);
		map.put("tel", tel);
		if (log!=null) 
			map.put("log", log+"");
			
		if (lat!=null) {
			map.put("lat", lat+"");
		}
		map.put("pwd", pwd);
		map.put("pushStatus", pushStatus+"");
		map.put("activation", activation);
		if (flowCoins!=null) {
			map.put("flowCoins", flowCoins+"");
		}
		String result = HttpClientUtils.postMethodRequest(CENTER_SERVER+ "/register.do", map);
		System.out.println("result="+result);
		ResultVO vo = ResultUtil.toObject(result);
		if (vo.getStatus().equals(CodeStatus.SUCCESS)){
			 LinkedTreeMap<String, Object> userVO = (LinkedTreeMap<String, Object>) vo.getResult();
				AppBuuluuUser user = new AppBuuluuUser();
				user.setCreatedBy(Constant.CREATE_BY_API);
				user.setCreatedTime(DateUtil.getCurrentDate());
				user.setDevice(device+"");
				user.setDeviceVerNum(deviceVerNum);
				user.setId(userVO.get("userId").toString());
				user.setImei(imei);
				user.setImsi(imsi);
				user.setIsDeleted(0);
				user.setLang(lang);
				user.setLoginTime(DateUtil.getCurrentDate());
				user.setLoginType(0);
				user.setMac(mac);
				user.setStatus(1);
				user.setToken(userVO.get("token").toString());
				int resultCount =userService.add(user);
				if (resultCount!=1) 
					throw new BaseAPIException();
		}
		model.put("message", result);
		return "message.json";
	}
	
	/**
	 * 快速注册
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
	@RequestMapping(value = "/quickRegister.do",method=RequestMethod.POST)
	@Transactional
	public  String quickRegister(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String countryCode, String tel, Double log,Double lat,String pwd,Integer pushStatus,Float  flowCoins) throws Exception {
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(countryCode,null);
		Assert.hasText(tel,null);
		Assert.hasText(pwd,null);
		
		Map<String,String> map = returnMap(lang, device, deviceVerNum, imei, mac, imsi);
		
		map.put("countryCode", countryCode);
		map.put("tel", tel);
		if (log!=null) 
			map.put("log", log+"");
			
		if (lat!=null) 
			map.put("lat", lat+"");
		
		map.put("pwd", pwd);
		map.put("pushStatus", pushStatus==null?"0":pushStatus+"");
		if (flowCoins!=null) {
			map.put("flowCoins", flowCoins+"");
		}
		
		String result = HttpClientUtils.postMethodRequest(CENTER_SERVER+ "/quickRegister.do", map);
		System.out.println("result="+result);
		ResultVO vo = ResultUtil.toObject(result);
		if (vo.getStatus().equals(CodeStatus.SUCCESS)){
			 LinkedTreeMap<String, Object> userVO = (LinkedTreeMap<String, Object>) vo.getResult();
				AppBuuluuUser user = new AppBuuluuUser();
				user.setCreatedBy(Constant.CREATE_BY_API);
				user.setCreatedTime(DateUtil.getCurrentDate());
				user.setDevice(device+"");
				user.setDeviceVerNum(deviceVerNum);
				user.setId(userVO.get("userId").toString());
				user.setImei(imei);
				user.setImsi(imsi);
				user.setIsDeleted(0);
				user.setLang(lang);
				user.setLoginTime(DateUtil.getCurrentDate());
				user.setLoginType(0);
				user.setMac(mac);
				user.setStatus(1);
				user.setToken(userVO.get("token").toString());
				int resultCount =userService.add(user);
				if (resultCount!=1) 
					throw new BaseAPIException();
		}
		model.put("message", result);
		return "message.json";
	}
	
	/**
	 * 登录
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
	@RequestMapping(value = "/login.do",method=RequestMethod.POST)
	@Transactional
	public String login(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String countryCode, String tel, String pwd) throws Exception {
	   Assert.hasText(lang, null);
	   Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		String jsonStr = null;
		if (StringUtils.isEmpty(tel)||StringUtils.isEmpty(pwd)) {
			AppVistorUser user = new AppVistorUser();
			user.setId(Constant.getTempUserId());
			user.setTel("13XXXXXXXXX");
			user.setNickName("GUEST");
			int resultUserCount = vistorUserService.add(user,user.getId()+Constant.getTempUserId());
			
			if (resultUserCount!=1) 
				throw new UserNotExistException(lang);
			
			jsonStr = returnJsonStr2(user.getId().toString(), Constant.getSessionId(), user);
		}else {
			AppBuuluuUser user = null;
			Map<String,String> map = returnMap(lang, device, deviceVerNum, imei, mac, imsi);
			
			map.put("countryCode", countryCode);
			map.put("tel", tel);
			map.put("pwd", pwd);
			String result = HttpClientUtils.postMethodRequest(CENTER_SERVER+ "/login.do", map);
			
			System.out.println("result="+result);
			
			ResultVO vo = ResultUtil.toObject(result);
			if (vo.getStatus().equals(CodeStatus.SUCCESS)){
				 LinkedTreeMap<String, Object> userVO = (LinkedTreeMap<String, Object>) vo.getResult();
				 String userId = userVO.get("userId").toString();
				 String token = userVO.get("token").toString();
				 user = userService.getUserById(userId);
				 
				 if (user==null) 
				 throw new UserNotExistException(lang);
				 
				 user.setUpdatedBy(Constant.UPDATE_BY_API);
				 user.setUpdatedTime(DateUtil.getCurrentDate());
				 user.setToken(token);
				 int updateCount =userService.updateUser(user,userId);
				 
				 if (updateCount!=1) 
					throw new BaseAPIException();
			}
			jsonStr = result;
		}

		model.put("message", jsonStr);
		return "message.json";
	}
	
	/**
	 * 自动登录
	 * @param request
	 * @param model
	 * @param lang  返回的语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param imsi   用户SIM卡号(没有时为”00000000”)
	 * @param pwd   用户密码
	 * @param userId   用户的唯一的用户id
	 * @param token   单点登录的token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/autoLogin.do",method=RequestMethod.POST)
	public String autoLogin(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String userId, String token) throws Exception {
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId);
		Assert.hasText(token);
		String jsonStr = null;
		AppBuuluuUser user = null;
		user =userService.getUserById(userId);
		if (user==null) 
			throw new UserNotExistException(lang);
		
		if (!user.getToken().equals(token)) 
			throw new IllegalUserSessionException(lang);
		
		Map<String,String> map = returnMap(lang, device, deviceVerNum, imei, mac, imsi);
		
		map.put("userId", userId);
		map.put("token", token);
		jsonStr = HttpClientUtils.postMethodRequest(CENTER_SERVER+ "/autoLogin.do", map);
		model.put("message", jsonStr);
		return "message.json";
	}
	
	

	/**
	 * 重置密码
	 * @param request
	 * @param model
	 * @param lang  返回的语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param imsi   用户SIM卡号(没有时为”00000000”)
	 * @param pwd   用户密码
	 * @param userId   用户的唯一的用户id
	 * @param token   单点登录的token
	 * @param oldPwd 用户的旧密码
	 * @param newPwd 用户的新密码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/resetPassword.do",method=RequestMethod.POST)
	public String resetPassword(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String userId, String token,String oldPwd,String newPwd) throws Exception {
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId);
		Assert.hasText(token);
		Assert.hasText(oldPwd);
		Assert.hasText(newPwd);
		String jsonStr = null;
		
     Map<String,String> map = returnMap(lang, device, deviceVerNum, imei, mac, imsi);
		
		map.put("userId", userId);
		map.put("token", token);
		map.put("oldPwd", oldPwd);
		map.put("newPwd", newPwd);
		jsonStr = HttpClientUtils.postMethodRequest(CENTER_SERVER+ "/resetPassword.do", map);

		model.put("message", jsonStr);
		return "message.json";
	}
	
	/**
	 * 忘记密码
	 * @param request
	 * @param model
	* @param lang  返回的语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param imsi   用户SIM卡号(没有时为”00000000”)
	 * @param countryCode 电话的国家编码
	 * @param tel 电话号码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/recoverPassword.do",method=RequestMethod.POST)
	public String recoverPassword(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi,String countryCode,String tel,String email) throws Exception {
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(countryCode);
		Assert.hasText(tel);
		String jsonStr = null;
		
		 Map<String,String> map = returnMap(lang, device, deviceVerNum, imei, mac, imsi);
			
			map.put("countryCode", countryCode);
			map.put("tel", tel);
			jsonStr = HttpClientUtils.postMethodRequest(CENTER_SERVER+ "/recoverPassword.do", map);

		model.put("message", jsonStr);
		return "message.json";
	}
	
	/**
	 * 获取用户信息
	 * @param request
	 * @param model
	 * @param lang  返回的语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param imsi   用户SIM卡号(没有时为”00000000”)
	 * @param userId  用户的userId
	 * @param token 用户的token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getUserProfile.do",method=RequestMethod.POST)
	public String getUserProfile(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi,
			String userId,String token) throws Exception {
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId,null);
		Assert.hasText(token,null);
		String jsonStr = null;
		
		Map<String,String> map = returnMap(lang, device, deviceVerNum, imei, mac, imsi);
		
		map.put("userId", userId);
		map.put("token", token);
		jsonStr = HttpClientUtils.postMethodRequest(CENTER_SERVER+ "/getUserProfile.do", map);
		
		model.put("message", jsonStr);
		return "message.json";
	}
	
	/**
	 * 更改用户信息
	 * @param request
	 * @param model
	 * @param lang  返回的语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param imsi   用户SIM卡号(没有时为”00000000”)
	 * @param sex 性别
	 * @param icon 头像
	 * @param birthday  出生日期
	 * @param country  国籍
	 * @param nickName  用户昵称
	 * @param log  经度
	 * @param lat  纬度
	 * @param userId  用户的userId
	 * @param token 用户的token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateUserProfile.do",method=RequestMethod.POST)
	public String updateUserProfile(HttpServletRequest request, ModelMap model, String lang,Integer device,String deviceVerNum,
			String imei,String mac,String imsi,
			Integer sex,String icon,Long birthday,String country,String nickName,Double log,
			Double lat,String userId,String token,String tel) throws Exception {
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId);
		Assert.hasText(token);
		String jsonStr = null;
		
		 Map<String,String> map = returnMap(lang, device, deviceVerNum, imei, mac, imsi);
			
			map.put("userId", userId);
			map.put("token", token);
		
		if (sex!=null) 
			map.put("sex", sex+"");
		if (birthday!=null) 
			map.put("birthday",birthday+"" );
		if (!StringUtils.isEmpty(country)) 
			map.put("country", country);
		if (!StringUtils.isEmpty(nickName)) 
			map.put("nickName", nickName);
		if (log!=null) 
			map.put("log",log+"" );
		if (lat!=null) 
			map.put("lat", lat+"");
		if (tel!=null) 
			map.put("tel",tel );
		
		
		jsonStr = HttpClientUtils.postMethodRequest(CENTER_SERVER+ "/updateUserProfile.do", map);

		model.put("message", jsonStr);
		return "message.json";
	}
	
	/**
	 * 登出
	 * @param request
	 * @param model
	 * @param lang  返回的语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param imsi   用户SIM卡号(没有时为”00000000”)
	 * @param userId
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/logout.do",method=RequestMethod.POST)
	@Transactional
	public String logout(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi,
			String userId,String token) throws Exception {
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId);
		Assert.hasText(token);
		String jsonStr = null;

      Map<String,String> map = returnMap(lang, device, deviceVerNum, imei, mac, imsi);
		
		map.put("userId", userId);
		map.put("token", token);
		jsonStr = HttpClientUtils.postMethodRequest(CENTER_SERVER+ "/logout.do", map);
		System.out.println(jsonStr);
		
		ResultVO vo = ResultUtil.toObject(jsonStr);
		if (vo.getStatus().equals(CodeStatus.SUCCESS)){
			AppBuuluuUser user = null;
			user =userService.getUserById(userId);
			if (user==null) 
				throw new UserNotExistException(lang);
			
			user.setUpdatedBy(Constant.UPDATE_BY_API);
			user.setUpdatedTime(DateUtil.getCurrentDate());
			user.setStatus(0);
			userService.updateUser(user, userId);
		}
		
		
		
		model.put("message", jsonStr);
		return "message.json";
	}
	
	
	
	//整理访客userId，token，user返回数据
	private String returnJsonStr2(String userId,String token,AppVistorUser user){
		String jsonStr = null;
		UserVO userVO = new UserVO();
		userVO.setUserId(userId);
		userVO.setToken(token);
		userVO.setBirthday(user.getBirthday()==null?"":user.getBirthday());
		userVO.setLat(user.getLat());
		userVO.setLog(user.getLog());
		userVO.setNickName(user.getNickName());
		userVO.setSex(user.getSex()==null?1:user.getSex());
		userVO.setTel(user.getTel());
		userVO.setFlowCoins(user.getFlowCoins());
		userVO.setMakeFlow(user.getMakeFlow());
		userVO.setUserFlow(user.getUserFlow());
		userVO.setCredit(user.getCredit());
		jsonStr = ResultUtil.getResultJson(userVO);
		
		return jsonStr;
	}
	
	
}
