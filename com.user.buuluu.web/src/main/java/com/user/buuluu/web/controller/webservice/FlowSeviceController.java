package com.user.buuluu.web.controller.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.user.buuluu.common.util.PropertiesUtil;
import com.user.buuluu.service.ScratchService;
import com.user.buuluu.service.UserService;
import com.user.buuluu.service.VistorUserService;
import com.user.buuluu.util.ResultUtil;
import com.user.buuluu.vo.FoundListVO;
import com.user.buuluu.web.handle.FlowHandler;

/**
 * 
 * @author More
 * æµ�é‡�çš„ç›¸å…³æŽ¥å�£
 * 2015.7.16
 *
 */
@Controller
public class FlowSeviceController {

	private Log log = LogFactory.getLog(this.getClass());
	
	private static final String LOCAL_SERVER= PropertiesUtil.getProperty("LOCAL_SERVER");
	
	@Autowired
	private FlowHandler flowHanler;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ScratchService  scratchService;
	
	
	@Autowired
	private VistorUserService vistorUserService;
	/**
	 * 获取发现视频
	 * @param request
	 * @param model
	 * @param lang  返回的数量语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param userId   用户ID
	 * @param token  用户token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getFoundList.do",method=RequestMethod.POST)
	public @ResponseBody String getFoundList(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String userId, String token) throws Exception {
		String jsonStr = null;

		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId);
		Assert.hasText(token);
		List<FoundListVO> resultList = new ArrayList<FoundListVO>();
		List list = flowHanler.getAdsList2(userId, 1, 1);
		FoundListVO vo = new FoundListVO();
		vo.setType(1);
		vo.setBody(list.subList(0, 3));
		resultList.add(vo);
		
		List list2 = flowHanler.getAppsList2(userId, 2, 1);
		FoundListVO vo2 = new FoundListVO();
		vo2.setType(2);
		vo2.setBody(list2.subList(0, 3));
		resultList.add(vo2);
		
		jsonStr = ResultUtil.getResultJson(resultList);

		return jsonStr;
		/*model.put("message", jsonStr);
		return "message.json";*/
	}

	/**
	 * éš�æœºèŽ·å�–å¹¿å‘Š
	 * @param request
	 * @param model
	 * @param lang  è¿”å›žçš„æ•°é‡�è¯­è¨€ç±»åž‹
	 * @param device  è®¾å¤‡ç±»åž‹ï¼Œ1æ˜¯IOSï¼Œ2æ˜¯AOS
	 * @param deviceVerNum  Appç‰ˆæœ¬çš„æŽ§åˆ¶ï¼Œå¦‚1.0.0
	 * @param imei  ç”¨æˆ·æ ‡è¯†ç �(æ²¡æœ‰æ—¶ä¸ºâ€� 00000000â€�)
	 * @param mac   ç”¨æˆ·macåœ°å�€
	 * @param userId   ç”¨æˆ·ID
	 * @param token  ç”¨æˆ·token
	 * @param type  
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping(value = "/getAds.do",method=RequestMethod.POST)
	public String getAds(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String userId, String token,Integer type) throws Exception {
		String jsonStr = null;

		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId);
		Assert.hasText(token);
		List list = flowHanler.getAds(userId,type);
		jsonStr = ResultUtil.getResultJson(list);

		model.put("message", jsonStr);
		return "message.json";
	}
	
	*//**
	 * éš�æœºèŽ·å�–å¹¿å‘Š
	 * @param request
	 * @param model
	 * @param lang  è¿”å›žçš„æ•°é‡�è¯­è¨€ç±»åž‹
	 * @param device  è®¾å¤‡ç±»åž‹ï¼Œ1æ˜¯IOSï¼Œ2æ˜¯AOS
	 * @param deviceVerNum  Appç‰ˆæœ¬çš„æŽ§åˆ¶ï¼Œå¦‚1.0.0
	 * @param imei  ç”¨æˆ·æ ‡è¯†ç �(æ²¡æœ‰æ—¶ä¸ºâ€� 00000000â€�)
	 * @param mac   ç”¨æˆ·macåœ°å�€
	 * @param userId   ç”¨æˆ·ID
	 * @param token  ç”¨æˆ·token
	 * @param type  1:è§†é¢‘ 2: APP 3:GAME
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping(value = "/getAdsList.do",method=RequestMethod.POST)
	public String getAdsList(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String userId, String token,Integer type,Integer pageNo) throws Exception {
		String jsonStr = null;

		List list = flowHanler.getAdsList(userId, type, pageNo);
		jsonStr = ResultUtil.getResultJson(list);

		model.put("message", jsonStr);
		return "message.json";
	}
	
	*//**
	 * èŽ·å�–å¹¿å‘Šè¯¦æƒ…
	 * @param request
	 * @param model
	 * @param lang  è¿”å›žçš„æ•°é‡�è¯­è¨€ç±»åž‹
	 * @param device  è®¾å¤‡ç±»åž‹ï¼Œ1æ˜¯IOSï¼Œ2æ˜¯AOS
	 * @param deviceVerNum  Appç‰ˆæœ¬çš„æŽ§åˆ¶ï¼Œå¦‚1.0.0
	 * @param imei  ç”¨æˆ·æ ‡è¯†ç �(æ²¡æœ‰æ—¶ä¸ºâ€� 00000000â€�)
	 * @param mac   ç”¨æˆ·macåœ°å�€
	 * @param userId   ç”¨æˆ·ID
	 * @param token  ç”¨æˆ·token
	 * @param type  
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping(value = "/getAdsDetail.do",method=RequestMethod.POST)
	public String getAdsDetail(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String userId, String token,Integer type,Integer sourceId) throws Exception {
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
		if (user == null) {
			throw new UserNotExistException(lang);
		}
		 Object downLoadAdsModel = flowHanler.getAdsDetail(user,type,sourceId,null);
		jsonStr = ResultUtil.getResultJson(downLoadAdsModel);
		model.put("message", jsonStr);
		return "message.json";
	}
	
	*//**
	 * çœ‹å¹¿å‘Šé¦–é¡µåˆ—è¡¨
	 * @param request
	 * @param model
	 * @param lang  è¿”å›žçš„æ•°é‡�è¯­è¨€ç±»åž‹
	 * @param device  è®¾å¤‡ç±»åž‹ï¼Œ1æ˜¯IOSï¼Œ2æ˜¯AOS
	 * @param deviceVerNum  Appç‰ˆæœ¬çš„æŽ§åˆ¶ï¼Œå¦‚1.0.0
	 * @param imei  ç”¨æˆ·æ ‡è¯†ç �(æ²¡æœ‰æ—¶ä¸ºâ€� 00000000â€�)
	 * @param mac   ç”¨æˆ·macåœ°å�€
	 * @param userId   ç”¨æˆ·ID
	 * @param token  ç”¨æˆ·token
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping(value = "/getAdFristList.do",method=RequestMethod.POST)
	public String getAdFristList(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String userId, String token) throws Exception {
		String jsonStr = null;

		Map<String,Object> map = flowHanler.getAdFristList(userId);
		jsonStr = ResultUtil.getResultJson(map);

		model.put("message", jsonStr);
		return "message.json";
	}
	
	*//**
	 * ç²¾å½©å¹¿å‘Šåˆ—è¡¨
	 * @param request
	 * @param model
	 * @param lang  è¿”å›žçš„æ•°é‡�è¯­è¨€ç±»åž‹
	 * @param device  è®¾å¤‡ç±»åž‹ï¼Œ1æ˜¯IOSï¼Œ2æ˜¯AOS
	 * @param deviceVerNum  Appç‰ˆæœ¬çš„æŽ§åˆ¶ï¼Œå¦‚1.0.0
	 * @param imei  ç”¨æˆ·æ ‡è¯†ç �(æ²¡æœ‰æ—¶ä¸ºâ€� 00000000â€�)
	 * @param mac   ç”¨æˆ·macåœ°å�€
	 * @param userId   ç”¨æˆ·ID
	 * @param token  ç”¨æˆ·token
	 * @param pageNo  é¡µç �ï¼Œä»Žé¦–é¡µæ•°å­—1å¼€å§‹
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping(value = "/getGreatAdsList.do",method=RequestMethod.POST)
	public String getGreatAdsList(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String userId, String token,Integer pageNo) throws Exception {
		String jsonStr = null;
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId);
		Assert.hasText(token);

		Map<String,Object> map = flowHanler.getGreatAdsList(pageNo);
		jsonStr = ResultUtil.getResultJson(map);

		model.put("message", jsonStr);
		return "message.json";
	}
	
	*//**
	 * çœ‹å¹¿å‘Šä¸‹è½½è½¯ä»¶èµšæµ�é‡�å¸�
	 * @param request
	 * @param model
	* @param lang  è¿”å›žçš„æ•°é‡�è¯­è¨€ç±»åž‹
	 * @param device  è®¾å¤‡ç±»åž‹ï¼Œ1æ˜¯IOSï¼Œ2æ˜¯AOS
	 * @param deviceVerNum  Appç‰ˆæœ¬çš„æŽ§åˆ¶ï¼Œå¦‚1.0.0
	 * @param imei  ç”¨æˆ·æ ‡è¯†ç �(æ²¡æœ‰æ—¶ä¸ºâ€� 00000000â€�)
	 * @param mac   ç”¨æˆ·macåœ°å�€
	 * @param userId   ç”¨æˆ·ID
	 * @param token  ç”¨æˆ·token
	 * @param productId  äº§å“�ID, å‰�é�¢çš„videoId
	 * @param type ä»€ä¹ˆç±»åž‹çš„å¹¿å‘Š(1:è§†é¢‘ 2: APP 3:GAME)
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping(value = "/getFlowCoins.do",method=RequestMethod.POST)
	@Transactional
	public String getFlowCoins(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String userId, String token,Integer sourceId,Integer type) throws Exception {
		String jsonStr = null;
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId);
		Assert.hasText(token);

		AppUser user = null;
		AppVistorUser vistorUser = null;
		
		if (userId.startsWith("000000")) {
			vistorUser = vistorUserService.getUserById(userId);
		}else {
			user = userService.getUserById(userId);
			if (user == null) {
				throw new UserNotExistException(lang);
			}
		}
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		AppUserBill appUserBill=flowCoinHandler.getFlowCoins(user,sourceId,type,vistorUser);
		
		map.put("billingId", appUserBill.getId());
		
		jsonStr = ResultUtil.getResultJson(map);

		model.put("message", jsonStr);
		return "message.json";
	}
	
	*//**
	 * èµšæµ�é‡�å¸�è´¦å�•ä¿¡æ�¯
	 * @param request
	 * @param model
	* @param lang  è¿”å›žçš„æ•°é‡�è¯­è¨€ç±»åž‹
	 * @param device  è®¾å¤‡ç±»åž‹ï¼Œ1æ˜¯IOSï¼Œ2æ˜¯AOS
	 * @param deviceVerNum  Appç‰ˆæœ¬çš„æŽ§åˆ¶ï¼Œå¦‚1.0.0
	 * @param imei  ç”¨æˆ·æ ‡è¯†ç �(æ²¡æœ‰æ—¶ä¸ºâ€� 00000000â€�)
	 * @param mac   ç”¨æˆ·macåœ°å�€
	 * @param userId   ç”¨æˆ·ID
	 * @param token  ç”¨æˆ·token
	 * @param billingId è´¦å�•id
	 * @return
	 * @throws Exception
	 *//*
//	@RequestMapping(value = "/getCoinsDetail.do",method=RequestMethod.POST)
//	public String getCoinsDetail(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
//			String imei,String mac,String imsi , String userId, String token,Integer billingId) throws Exception {
//		String jsonStr = null;
//		Assert.hasText(lang, null);
//		Assert.notNull(device,null);
//		Assert.hasText(deviceVerNum, null);
//		Assert.hasText(imei, null);
//		Assert.hasText(mac, null);
//		Assert.hasText(imsi,null);
//		Assert.hasText(userId);
//		Assert.hasText(token);
//
//		Map<String,Object> map = flowCoinHandler.getCoinsDetail(billingId);
//		
//		jsonStr = ResultUtil.getResultJson(map);
//
//		model.put("message", jsonStr);
//		return "message.json";
//	}
//	
	*//**
	 *  æµ�é‡�å¸�ä½¿ç”¨
	 * @param request
	 * @param model
	* @param lang  è¿”å›žçš„æ•°é‡�è¯­è¨€ç±»åž‹
	 * @param device  è®¾å¤‡ç±»åž‹ï¼Œ1æ˜¯IOSï¼Œ2æ˜¯AOS
	 * @param deviceVerNum  Appç‰ˆæœ¬çš„æŽ§åˆ¶ï¼Œå¦‚1.0.0
	 * @param imei  ç”¨æˆ·æ ‡è¯†ç �(æ²¡æœ‰æ—¶ä¸ºâ€� 00000000â€�)
	 * @param mac   ç”¨æˆ·macåœ°å�€
	 * @param userId   ç”¨æˆ·ID
	 * @param token  ç”¨æˆ·token
	 * @param billingId è´¦å�•id
	 * @param flowCoins  æµ�é‡�å¸�åˆ†é…�é‡�
	 * @param simCoins  Simå�¡çš„æµ�é‡�åˆ†é…�
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping(value = "/useCoins.do",method=RequestMethod.POST)
	@Transactional
	public String useCoins(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String userId, String token,Integer billingId,Float flowCoins,Float userCoin,String sourceName) throws Exception {
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
        AppVistorUser vistorUser = null;
		
		if (userId.startsWith("000000")) {
			vistorUser = vistorUserService.getUserById(userId);
		}else {
			user = userService.getUserById(userId);
			if (user == null) 
				throw new UserNotExistException(lang);
		}
		
		boolean flag =flowCoinHandler.useCoins(user,billingId,flowCoins,userCoin,sourceName,vistorUser);
		if (flag) {
			RequestCoinsVO vo = new RequestCoinsVO();
			if (user!=null) {
				user = userService.getUserById(userId);
				vo.setCredit(user.getCredit());
				vo.setFlowCoins(user.getFlowCoins());
				vo.setPoint(user.getPoint());
				vo.setUserFlow(user.getUserFlow());
			}else {
				vistorUser = vistorUserService.getUserById(userId);
				vo.setCredit(vistorUser.getCredit());
				vo.setFlowCoins(vistorUser.getFlowCoins());
				vo.setPoint(vistorUser.getPoint());
				vo.setUserFlow(vistorUser.getUserFlow());
			}
			jsonStr = ResultUtil.getResultJson(vo);
		}else {
			throw new BaseAPIException();
		}

		model.put("message", jsonStr);
		return "message.json";
	}
	
	*//**
	 *  è¯·æ±‚æµ�é‡�å¸�ä½¿ç”¨
	 * @param request
	 * @param model
	* @param lang  è¿”å›žçš„æ•°é‡�è¯­è¨€ç±»åž‹
	 * @param device  è®¾å¤‡ç±»åž‹ï¼Œ1æ˜¯IOSï¼Œ2æ˜¯AOS
	 * @param deviceVerNum  Appç‰ˆæœ¬çš„æŽ§åˆ¶ï¼Œå¦‚1.0.0
	 * @param imei  ç”¨æˆ·æ ‡è¯†ç �(æ²¡æœ‰æ—¶ä¸ºâ€� 00000000â€�)
	 * @param mac   ç”¨æˆ·macåœ°å�€
	 * @param userId   ç”¨æˆ·ID
	 * @param token  ç”¨æˆ·token
	 * @param type  è¯·æ±‚ä½¿ç”¨æµ�é‡�å¸�ä½¿ç”¨ç±»åž‹ï¼Œ1æ˜¯10Mï¼Œ2æ˜¯15Mï¼Œ3æ˜¯20M
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping(value = "/requestCoins.do",method=RequestMethod.POST)
	@Transactional
	public String requestCoins(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String userId, String token,Integer type) throws Exception {
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId);
		Assert.hasText(token);
		Assert.notNull(type,null);
		String jsonStr = null;
		AppUser user = null;
		
		user = userService.getUserById(userId);
		if (user == null) 
			throw new UserNotExistException(lang);
		
		RequestCoinsVO vo = flowCoinHandler.requestCoins(user,type);
		jsonStr = ResultUtil.getResultJson(vo);

		model.put("message", jsonStr);
		return "message.json";
	}
	
	*//**
	 * è´¦å�•è®°å½•
	 * 
	 * @param request
	 * @param model
	* @param lang  è¿”å›žçš„æ•°é‡�è¯­è¨€ç±»åž‹
	 * @param device  è®¾å¤‡ç±»åž‹ï¼Œ1æ˜¯IOSï¼Œ2æ˜¯AOS
	 * @param deviceVerNum  Appç‰ˆæœ¬çš„æŽ§åˆ¶ï¼Œå¦‚1.0.0
	 * @param imei  ç”¨æˆ·æ ‡è¯†ç �(æ²¡æœ‰æ—¶ä¸ºâ€� 00000000â€�)
	 * @param mac   ç”¨æˆ·macåœ°å�€
	 * @param userId   ç”¨æˆ·ID
	 * @param token  ç”¨æˆ·token
	 * @param PageNo  é¡µç �ï¼Œä»Ž1å¼€å§‹
	 * @param type,0æ˜¯å…¨éƒ¨ï¼Œ1æ˜¯æ”¯å‡ºï¼Œ2æ˜¯æ”¶å…¥,3äº¤æ˜“ä¸­
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping(value = "/getBillList.do",method=RequestMethod.POST)
	public String getBillList(HttpServletRequest request, ModelMap model, String lang,Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String userId, String token,Integer pageNo,Integer type) throws Exception {
		String jsonStr = null;
		AppUser user = null;
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId);
		Assert.hasText(token);
		Assert.notNull(pageNo,null);
		Assert.isTrue(pageNo>0);
		
		
		user = userService.getUserById(userId);
		if (user == null) 
			throw new UserNotExistException(lang);
		
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String,Object>> list =flowCoinHandler.getBillList(userId,type);
		
		int fristIndex = (pageNo-1)*Constant.PAGE_NUM;
		int toIndex = list.size()<=pageNo*Constant.PAGE_NUM?list.size():pageNo*Constant.PAGE_NUM;
		if (fristIndex>=toIndex) {
			map.put("hasNextPage", false);
			map.put("billList", new ArrayList<Map<String,Object>>());
			jsonStr = ResultUtil.getResultJson(map);
		}else {
			List<Map<String,Object>> resultList =list.subList(fristIndex, toIndex);
//			if ((list.size()/Constant.PAGE_NUM)==pageNo ) {
//				if (list.size()%Constant.PAGE_NUM==0) {
//					map.put("hasNextPage", 0);
//				}else {
//					map.put("hasNextPage", 1);
//				}
//			}else if ((list.size()/Constant.PAGE_NUM)==0) {
//				map.put("hasNextPage", 0);
//			}else {
//				if (list.size()/Constant.PAGE_NUM>pageNo) {
//					map.put("hasNextPage", 1);
//				}else {
//					
//				}
//			}
			if (list.size()/Constant.PAGE_NUM>pageNo) {
				map.put("hasNextPage", true);
			}else if (list.size()/Constant.PAGE_NUM==pageNo) {
				if (list.size()%Constant.PAGE_NUM==0) {
					map.put("hasNextPage", false);
				}else {
					map.put("hasNextPage", true);
				}
			}else {
				map.put("hasNextPage", false);
			}
			map.put("billList", resultList);
			jsonStr = ResultUtil.getResultJson(map);
		}

		model.put("message", jsonStr);
		return "message.json";
	}
	
	*//**ä¸‹è½½è½¯ä»¶é¦–é¡µ
	 * 
	 * @param request
	 * @param model
	* @param lang  è¿”å›žçš„æ•°é‡�è¯­è¨€ç±»åž‹
	 * @param device  è®¾å¤‡ç±»åž‹ï¼Œ1æ˜¯IOSï¼Œ2æ˜¯AOS
	 * @param deviceVerNum  Appç‰ˆæœ¬çš„æŽ§åˆ¶ï¼Œå¦‚1.0.0
	 * @param imei  ç”¨æˆ·æ ‡è¯†ç �(æ²¡æœ‰æ—¶ä¸ºâ€� 00000000â€�)
	 * @param mac   ç”¨æˆ·macåœ°å�€
	 * @param userId   ç”¨æˆ·ID
	 * @param token  ç”¨æˆ·token
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping(value = "/getDownloadList.do",method=RequestMethod.POST)
	public String getDownloadList(HttpServletRequest request, ModelMap model, String lang,Integer device,String deviceVerNum,
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

		Map<String,Object> map = flowHanler.getDownloadList();
		jsonStr = ResultUtil.getResultJson(map);

		model.put("message", jsonStr);
		return "message.json";
	}
	
	*//**
	 * ä¸‹è½½è½¯ä»¶åˆ—è¡¨
	 * @param request
	 * @param model
	 * @param lang  è¿”å›žçš„æ•°é‡�è¯­è¨€ç±»åž‹
	 * @param device  è®¾å¤‡ç±»åž‹ï¼Œ1æ˜¯IOSï¼Œ2æ˜¯AOS
	 * @param deviceVerNum  Appç‰ˆæœ¬çš„æŽ§åˆ¶ï¼Œå¦‚1.0.0
	 * @param imei  ç”¨æˆ·æ ‡è¯†ç �(æ²¡æœ‰æ—¶ä¸ºâ€� 00000000â€�)
	 * @param mac   ç”¨æˆ·macåœ°å�€
	 * @param userId   ç”¨æˆ·ID
	 * @param token  ç”¨æˆ·token
	 * @param pageNo  é¡µç �ï¼Œä»Ž1å¼€å§‹
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping(value = "/getDownloadNextList.do",method=RequestMethod.POST)
	public String getDownloadNextList(HttpServletRequest request, ModelMap model, String lang,Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String userId, String token,Integer pageNo) throws Exception {
     	Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId,null);
		Assert.hasText(token,null);
		Assert.notNull(pageNo);
		String jsonStr = null;

		Map<String, Object> map = flowHanler.getDownloadNextList(pageNo);
//		List<SoftVO> list = new ArrayList<SoftVO>();
//		for (int i = 0; i < Constant.PAGE_NUM; i++) {
//			SoftVO softVO = new SoftVO();
//			list.add(softVO);
//		}
//		map.put("wonderfulList", list);
//		map.put("hasNextPage", "1");
		jsonStr = ResultUtil.getResultJson(map);

		model.put("message", jsonStr);
		return "message.json";
	}
	
	*//**
	 * èŽ·å�–åˆ®åˆ®å�¡ä¿¡æ�¯
	 * @param request
	 * @param model
	 * @param lang  è¿”å›žçš„æ•°é‡�è¯­è¨€ç±»åž‹
	 * @param device  è®¾å¤‡ç±»åž‹ï¼Œ1æ˜¯IOSï¼Œ2æ˜¯AOS
	 * @param deviceVerNum  Appç‰ˆæœ¬çš„æŽ§åˆ¶ï¼Œå¦‚1.0.0
	 * @param imei  ç”¨æˆ·æ ‡è¯†ç �(æ²¡æœ‰æ—¶ä¸ºâ€� 00000000â€�)
	 * @param mac   ç”¨æˆ·macåœ°å�€
	 * @param userId   ç”¨æˆ·ID
	 * @param token  ç”¨æˆ·token
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping(value = "/getScratchList.do",method=RequestMethod.POST)
	public String getScratchList(HttpServletRequest request, ModelMap model, String lang,Integer device,String deviceVerNum,
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

		List<Map<String,Object>> scratchs = scratchService.getScratchList();
		
		List<AppUserScratchModel> scrathList =scratchService.getScratchNews(50);
		
		String serverDomain = LOCAL_SERVER;
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for (Map<String, Object> map : scratchs) {
			Map<String,Object> m = new HashMap<String, Object>();
//			m.put("img", map.get("IMG"));
			m.put("scratchId", Integer.parseInt(map.get("ID").toString()));
			m.put("flowCoins", Float.parseFloat(map.get("FLOW_COINS").toString()));
			m.put("description", map.get("DESCRIPTION").toString());
			m.put("detailUrl",serverDomain+"9d44a4e19a4565c3-959e27b1f8ed1f15-fce1e8dffaf36ed8138bd38db364e580.jpg");
			List<String> l = new ArrayList<String>();
			l.add(serverDomain+"20150803161203.png");
			l.add(serverDomain+"20150803161224.png");
			l.add(serverDomain+"20150803161318.png");
			l.add(serverDomain+"20150803161331.png");
			
			m.put("rewardList",l);
			m.put("rewardNews", scrathList);
			list.add(m);
		}
		
		jsonStr = ResultUtil.getResultJson(list);

		model.put("message", jsonStr);
		return "message.json";
	}
	
	*//**
	 * åˆ®åˆ®å�¡èŽ·å�–æµ�é‡�
	 * @param request
	 * @param model
	 * @param lang  è¿”å›žçš„æ•°é‡�è¯­è¨€ç±»åž‹
	 * @param device  è®¾å¤‡ç±»åž‹ï¼Œ1æ˜¯IOSï¼Œ2æ˜¯AOS
	 * @param deviceVerNum  Appç‰ˆæœ¬çš„æŽ§åˆ¶ï¼Œå¦‚1.0.0
	 * @param imei  ç”¨æˆ·æ ‡è¯†ç �(æ²¡æœ‰æ—¶ä¸ºâ€� 00000000â€�)
	 * @param mac   ç”¨æˆ·macåœ°å�€
	 * @param userId   ç”¨æˆ·ID
	 * @param token  ç”¨æˆ·token
	 * @param scratchId  åˆ®åˆ®å�¡ID
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping(value = "/getScratchCoins.do",method=RequestMethod.POST)
	@Transactional
	public String getScratchCoins(HttpServletRequest request, ModelMap model, String lang, String device, String deviceVerNum,
			String imei,String mac,String imsi , String userId, String token,Integer scratchId) throws Exception {
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId,null);
		Assert.hasText(token,null);
		Assert.notNull(scratchId,null);
		String jsonStr = null;

		AppUser user = null;
		user = userService.getUserById(userId);
		
		if (user==null) 
		throw new UserNotExistException(lang);
		
		int f =flowCoinHandler.getScratchCoins(user,scratchId);
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("reward", f);
		jsonStr = ResultUtil.getResultJson(map);

		model.put("message", jsonStr);
		return "message.json";
	}
	
	
	*//**
	 * èŽ·å�–æµ�é‡�åŒ…è§„åˆ™
	 * @param request
	 * @param model
	 * @param lang  è¿”å›žçš„æ•°é‡�è¯­è¨€ç±»åž‹
	 * @param device  è®¾å¤‡ç±»åž‹ï¼Œ1æ˜¯IOSï¼Œ2æ˜¯AOS
	 * @param deviceVerNum  Appç‰ˆæœ¬çš„æŽ§åˆ¶ï¼Œå¦‚1.0.0
	 * @param imei  ç”¨æˆ·æ ‡è¯†ç �(æ²¡æœ‰æ—¶ä¸ºâ€� 00000000â€�)
	 * @param mac   ç”¨æˆ·macåœ°å�€
	 * @param userId   ç”¨æˆ·ID
	 * @param token  ç”¨æˆ·token
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping(value = "/getFlowPkg.do",method=RequestMethod.POST)
	public String getFlowPkg(HttpServletRequest request, ModelMap model, String lang, String device, String deviceVerNum,
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

		List<FlowPkgVO> pkgs = flowCoinHandler.getFlowPkg();
		
		jsonStr = ResultUtil.getResultJson(pkgs);

		model.put("message", jsonStr);
		return "message.json";
	}
	
	*//**
	 * èŽ·å�–å�—ä¼—çš„è§†é¢‘
	 * @param request
	 * @param model
	 * @param lang  è¿”å›žçš„æ•°é‡�è¯­è¨€ç±»åž‹
	 * @param device  è®¾å¤‡ç±»åž‹ï¼Œ1æ˜¯IOSï¼Œ2æ˜¯AOS
	 * @param deviceVerNum  Appç‰ˆæœ¬çš„æŽ§åˆ¶ï¼Œå¦‚1.0.0
	 * @param imei  ç”¨æˆ·æ ‡è¯†ç �(æ²¡æœ‰æ—¶ä¸ºâ€� 00000000â€�)
	 * @param mac   ç”¨æˆ·macåœ°å�€
	 * @param userId   ç”¨æˆ·ID
	 * @param token  ç”¨æˆ·token
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping(value = "/getFarVideo.do",method=RequestMethod.POST)
	public String getFarVideo(HttpServletRequest request, ModelMap model, String lang, String device, String deviceVerNum,
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

	List<AdsVO> list = flowCoinHandler.getFarVideo(userId);
		
		jsonStr = ResultUtil.getResultJson(list);

		model.put("message", jsonStr);
		return "message.json";
	}
	
	*//**
	 * èŽ·å�–å�—ä¼—çš„app
	 * @param request
	 * @param model
	 * @param lang  è¿”å›žçš„æ•°é‡�è¯­è¨€ç±»åž‹
	 * @param device  è®¾å¤‡ç±»åž‹ï¼Œ1æ˜¯IOSï¼Œ2æ˜¯AOS
	 * @param deviceVerNum  Appç‰ˆæœ¬çš„æŽ§åˆ¶ï¼Œå¦‚1.0.0
	 * @param imei  ç”¨æˆ·æ ‡è¯†ç �(æ²¡æœ‰æ—¶ä¸ºâ€� 00000000â€�)
	 * @param mac   ç”¨æˆ·macåœ°å�€
	 * @param userId   ç”¨æˆ·ID
	 * @param token  ç”¨æˆ·token
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping(value = "/getFarApp.do",method=RequestMethod.POST)
	public String getFarApp(HttpServletRequest request, ModelMap model, String lang, String device, String deviceVerNum,
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

	 List<SoftVO> list = flowCoinHandler.getFarApp(userId);
		
		jsonStr = ResultUtil.getResultJson(list);

		model.put("message", jsonStr);
		return "message.json";
	}
	
	
	*//**
	 * èŽ·å�–æ¸¸æˆ�çš„list
	 * @param request
	 * @param model
	 * @param lang  è¿”å›žçš„æ•°é‡�è¯­è¨€ç±»åž‹
	 * @param device  è®¾å¤‡ç±»åž‹ï¼Œ1æ˜¯IOSï¼Œ2æ˜¯AOS
	 * @param deviceVerNum  Appç‰ˆæœ¬çš„æŽ§åˆ¶ï¼Œå¦‚1.0.0
	 * @param imei  ç”¨æˆ·æ ‡è¯†ç �(æ²¡æœ‰æ—¶ä¸ºâ€� 00000000â€�)
	 * @param mac   ç”¨æˆ·macåœ°å�€
	 * @param userId   ç”¨æˆ·ID
	 * @param token  ç”¨æˆ·token
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping(value = "/getGameList.do",method=RequestMethod.POST)
	public String getGameList(HttpServletRequest request, ModelMap model, String lang, String device, String deviceVerNum,
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

	    List<GameVO> list = flowCoinHandler.getGameList();
		
		jsonStr = ResultUtil.getResultJson(list);

		model.put("message", jsonStr);
		return "message.json";
	}*/
}
