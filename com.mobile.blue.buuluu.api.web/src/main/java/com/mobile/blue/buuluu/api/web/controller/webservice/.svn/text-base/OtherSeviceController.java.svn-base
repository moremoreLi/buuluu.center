package com.mobile.blue.buuluu.api.web.controller.webservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mobile.blue.buuluu.api.common.exception.BaseAPIException;
import com.mobile.blue.buuluu.api.common.exception.InputLengthException;
import com.mobile.blue.buuluu.api.common.exception.UserNotExistException;
import com.mobile.blue.buuluu.api.common.util.DateUtil;
import com.mobile.blue.buuluu.api.service.FeedBackService;
import com.mobile.blue.buuluu.api.service.SignService;
import com.mobile.blue.buuluu.api.service.UserService;
import com.mobile.blue.buuluu.api.service.VersionControlService;
import com.mobile.blue.buuluu.api.util.ResultUtil;
import com.mobile.blue.buuluu.model.AppFeedBack;
import com.mobile.blue.buuluu.model.AppUser;
import com.mobile.blue.buuluu.model.AppUserSign;
import com.mobile.blue.buuluu.model.AppVersionUpdate;

/**
 * 
 * @author More
 * 其他的相关接口（反馈，版本更新，签到，签到列表）
 * 2015.7.16
 *
 */
@Controller
public class OtherSeviceController {

	private Log log = LogFactory.getLog(this.getClass());
	
    @Autowired
    private FeedBackService feedBackService;
    
    @Autowired
    private SignService signService;
    
    @Autowired
    private  VersionControlService versionControlService;
    
    @Autowired
    private UserService userService;

	/**
	 * 意见反馈
	 * @param request
	 * @param model
	 * @param lang  返回的数量语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param userId   用户ID
	 * @param token  用户token
	 * @param content  用户反馈内容
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/feedBack.do",method=RequestMethod.POST)
	public String feedBack(HttpServletRequest request, ModelMap model, String lang, String device, String deviceVerNum,
			String imei,String mac,String imsi , String userId, String token,String content) throws Exception {
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId, null);
		Assert.hasText(token, null);
		Assert.hasText(content, null);
		String jsonStr = null;

		if (content.getBytes("utf-8").length > 600) {
			throw new InputLengthException(lang, "300"); 
		}
		AppFeedBack feedBack =feedBackService.feedBack(userId,content);
		if (feedBack==null) 
			throw new BaseAPIException();
		
		jsonStr = ResultUtil.getResultJson("");

		model.put("message", jsonStr);
		return "message.json";
	}
	
	/**
	 * 检查更新
	 * @param request
	 * @param model
	* @param lang  返回的数量语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param channel  渠道号
	 * @param internet  网络类型
	 * @param resolution  屏幕分辨率
	 * @param store 存储号（如coogle_play)
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/versionUpdate.do",method=RequestMethod.POST)
	public String versionUpdate(HttpServletRequest request, ModelMap model, String lang, Integer device, String deviceVerNum,
			String imei,String mac,String imsi , String channel,String internet,String resolution,String store) throws Exception {
		String jsonStr = null;

		
		AppVersionUpdate versionUpdate = versionControlService.getVersionUpdate(device, store, channel, lang);
		
		String VersionNum = versionUpdate.getVersionNum();
		String clientVersion = deviceVerNum;
		
		
		Map<String,Object> map = new HashMap<String, Object>();
		if(VersionNum.compareTo(clientVersion) > 0){
//			map.put("isUpdate", 1);
//			map.put("updateUrl", versionUpdate.getUpdateUrl());
//			if(versionUpdate.getForceUpdate()){
//				map.put("forceUpdate", 1);
//			}else{
//				map.put("forceUpdate", 0);
//			}
			if (versionUpdate.getType()==0) {
				map.put("type", 2);//0:已是最新版本   1:强制升级  2:普通升级
			}else {
				map.put("type", 1);//0:已是最新版本   1:强制升级  2:普通升级
			}
		}else{
			map.put("type", 0);
		}
		map.put("version", versionUpdate.getVersion());//返回最新版本号
//		map.put("type", versionUpdate.getType());//0:已是最新版本   1:强制升级  2:普通升级
		map.put("fileSize", versionUpdate.getFileSize());//该版本文件大小
		map.put("filePath", versionUpdate.getFilePath());//进行升级下载地址
		map.put("description",versionUpdate.getDescription());//版本描述
		map.put("serverTime", System.currentTimeMillis());//服务器返回时间
		jsonStr = ResultUtil.getResultJson(map);

		model.put("message", jsonStr);
		return "message.json";
	}
	
	/**签到列表
	 * 
	 * @param request
	 * @param model
	* @param lang  返回的数量语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param userId  用户的userID
	 * @param token 用户的token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getSignList.do",method=RequestMethod.POST)
	public String getSignList(HttpServletRequest request, ModelMap model, String lang, Integer device, String deviceVerNum,
			String imei,String mac,String imsi ,String userId , String token) throws Exception {
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId);
		Assert.hasText(token);
		String jsonStr = null;

		Map<String,Object> map = new HashMap<String, Object>();
		
		AppUser user = null;
	    user = userService.getUserById(userId);
		
		if (user==null) 
		throw new UserNotExistException(lang);
		
		List<String> signList =signService.getSignList(userId);
//		map.put("signList", listToString(signList));//签到时间(以”,”隔开, 写的是日期)
		map.put("totalCredit", user.getPoint());//签到总奖励积分
		map.put("signCount", signList.size());//签到次数
		map.putAll(listToString(signList));
		jsonStr = ResultUtil.getResultJson(map);

		model.put("message", jsonStr);
		return "message.json";
	}
	
	private Map<String,Object> listToString(List<String> list){
		String str = "";
		Map<String,Object> map = new HashMap<String, Object>();
		List<Long>  l = new ArrayList<Long>();
		map.put("status", 0);
		for (int i = 0; i < list.size(); i++) {
//			str+=DateUtil.parseDate(list.get(i)).getTime();
			l.add(DateUtil.parseDate(list.get(i)).getTime());
			
			if (list.get(i).equals(DateUtil.getCurrentDateStr())) 
				map.put("status", 1);
			
			if (i==list.size()-1)
			break;
			
			str+=",";
			
			
		}
		
		map.put("signList", l);
		return map;
	}
	
	/**
	 *  签到
	 * @param request
	 * @param model
	* @param lang  返回的数量语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param userId  用户的userID
	 * @param token 用户的token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addSign.do",method=RequestMethod.POST)
	public String addSign(HttpServletRequest request, ModelMap model, String lang, Integer device, String deviceVerNum,
			String imei,String mac,String imsi ,String userId , String token) throws Exception {
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId);
		Assert.hasText(token);
		String jsonStr = null;

		AppUser user = null;
	    user = userService.getUserById(userId);
		
		if (user==null) 
			throw new UserNotExistException(lang);
		AppUserSign appUserSign =signService.addSign(user);
		
		if (appUserSign!=null) {
			jsonStr = ResultUtil.getResultJson("");
		}

		model.put("message", jsonStr);
		return "message.json";
	}
	
	/**
	 * 心跳监测上传消耗buuluu数据
	 * @param request
	 * @param model
	* @param lang  返回的数量语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param userId  用户的userID
	 * @param token 用户的token
	  * @param dataTime 手机当前时间
	  * @param consumBuuluu 消耗的流量币
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/buuluuMonitor.do",method=RequestMethod.POST)
	public String buuluuMonitor(HttpServletRequest request, ModelMap model, String lang, String device, String deviceVerNum,
			String imei,String mac,String userId , String token,Long dataTime,Float consumBuuluu) throws Exception {
		String jsonStr = null;

		Map<String,Float> map = new HashMap<String, Float>();
		map.put("userFlow", 14.1144F);
		jsonStr = ResultUtil.getResultJson(map);

		model.put("message", jsonStr);
		return "message.json";
	}
	
	/**
	 * Buuluu币低于报警值发送消息
	 * @param request
	 * @param model
	* @param lang  返回的数量语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param userId  用户的userID
	 * @param token 用户的token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/alarmPush.do",method=RequestMethod.POST)
	public String alarmPush(HttpServletRequest request, ModelMap model, String lang, String device, String deviceVerNum,
			String imei,String mac,String userId , String token) throws Exception {
		String jsonStr = null;

		Map<String,Object> map = new HashMap<String, Object>();
		map.put("freeFlow", 5);
		map.put("status", 1);
		jsonStr = ResultUtil.getResultJson(map);

		model.put("message", jsonStr);
		return "message.json";
	}
}
