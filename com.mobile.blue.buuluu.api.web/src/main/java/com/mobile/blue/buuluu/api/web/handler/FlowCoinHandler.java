package com.mobile.blue.buuluu.api.web.handler;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mobile.blue.buuluu.api.common.exception.BaseAPIException;
import com.mobile.blue.buuluu.api.common.exception.BillExpireException;
import com.mobile.blue.buuluu.api.common.exception.BillNotExistException;
import com.mobile.blue.buuluu.api.common.exception.CoinUseNotMatchException;
import com.mobile.blue.buuluu.api.common.exception.FlowCoinNotEnoughException;
import com.mobile.blue.buuluu.api.common.exception.ScratchNotExistException;
import com.mobile.blue.buuluu.api.common.exception.SourceNotExistException;
import com.mobile.blue.buuluu.api.common.util.Constant;
import com.mobile.blue.buuluu.api.common.util.DateUtil;
import com.mobile.blue.buuluu.api.common.util.HttpClientUtils;
import com.mobile.blue.buuluu.api.common.util.Json;
import com.mobile.blue.buuluu.api.common.util.PropertiesUtil;
import com.mobile.blue.buuluu.api.model.RandomAdsModel;
import com.mobile.blue.buuluu.api.service.BillRecordService;
import com.mobile.blue.buuluu.api.service.FlowPkgService;
import com.mobile.blue.buuluu.api.service.ScratchService;
import com.mobile.blue.buuluu.api.service.SourceService;
import com.mobile.blue.buuluu.api.service.UserService;
import com.mobile.blue.buuluu.api.service.VistorUserService;
import com.mobile.blue.buuluu.api.web.view.AdsVO;
import com.mobile.blue.buuluu.api.web.view.FlowPkgVO;
import com.mobile.blue.buuluu.api.web.view.GameVO;
import com.mobile.blue.buuluu.api.web.view.RequestCoinsVO;
import com.mobile.blue.buuluu.api.web.view.SoftVO;
import com.mobile.blue.buuluu.model.AppFlowPackage;
import com.mobile.blue.buuluu.model.AppScratch;
import com.mobile.blue.buuluu.model.AppUser;
import com.mobile.blue.buuluu.model.AppUserBill;
import com.mobile.blue.buuluu.model.AppUserBillLog;
import com.mobile.blue.buuluu.model.AppUserScratch;
import com.mobile.blue.buuluu.model.AppVistorUser;


/**
 * 赚流量的相关接口
 * @author More
 *2015-7-25
 */
public class FlowCoinHandler {
	
	@Autowired
	private SourceService sourceSerice;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FlowHandler flowHandler;
	
	@Autowired
	private ScratchService scratchService;
	
	@Autowired
	private BillRecordService billRecordService;
	
	@Autowired
	private FlowPkgService flowPkgService;
	
	@Autowired
	private SourceService sourceService;
	
	@Autowired
	private VistorUserService vistorUserService;
	
	private static final String LOCAL_SERVER= PropertiesUtil.getProperty("LOCAL_SERVER");
	
	public AppUserBill getFlowCoins(AppUser user, Integer sourceId,Integer type, AppVistorUser vistorUser) throws SQLException {
		 Map<String, Object> sourceObj = sourceSerice.getSource(sourceId,type);
		 if (sourceObj==null) 
			throw new SourceNotExistException(null);
		
		AppUserBill appUserBill = sourceSerice.saveBill(user,sourceId,type,sourceObj,vistorUser);
		
		return appUserBill;
		
//		boolean flag = false;
//		if (appUserBill!=null) {
//			user.setMakeFlow(Float.parseFloat(sourceObj.get("flowCoins").toString()));
//			user.setUpdatedBy(Constant.UPDATE_BY_API);
//			user.setUpdatedTime(DateUtil.getCurrentDate());
//			flag =userService.update(user);
//		}
//		if (flag) {
//			AppBillRecord appBillRecord =billRecordService.add(user,sourceObj);
//			if (appBillRecord==null) 
//			throw new BaseAPIException();
//			
//			return appUserBill;
//		}else {
//			throw new BaseAPIException();
//		}
	}

//	public Map<String, Object> getCoinsDetail(Integer billingId) throws UnsupportedEncodingException {
//		AppUserBill appUserBill = sourceSerice.getBillById(billingId);
//		if (appUserBill==null) {
//			throw new BillNotExistException(null);
//		}
////		Map<String, Object>  map = sourceSerice.getCoinsDetail(billingId);
//		int sourceId = appUserBill.getSourceId();
//		int type = appUserBill.getType();
//		String userId = appUserBill.getUserId();
//		Object obj = flowHandler.getAdsDetail(userId, type, sourceId);
//		Map<String,Object> returnMap = new HashMap<String, Object>();
//		
//		returnMap.put("billingId", billingId);
//		returnMap.put("billTime", appUserBill.getCreatedTime().getTime());
//		returnMap.put("billDes",  appUserBill.getDescription());
//		returnMap.put("type",  type);
//		returnMap.put("sourceDetail", obj);
//		return returnMap;
//	}
	
	
	private String[] StringToArray(String str){
		String[] arr = str.split("\"");
		List<String> list = new ArrayList<String>();
		for (String s : arr) {
			if (s.startsWith("http")) {
				list.add(s);
			}
		}
		String[] strArr = new String[list.size()];
		for (int j = 0; j < list.size(); j++) {
			strArr[j]=list.get(j);
		}
		return strArr;
	}
	
	/*
	 * JSON字符串特殊字符处理，比如：“\A1;1300” 
     * @param s 
     * @return String 
	 */
	private String  string2Json(String s){
		return s.replaceAll("\r", "\\r").replaceAll("\n", "\\n").replaceAll("/", "\\/");
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public boolean  useCoins(AppUser user, Integer billingId, Float flowCoins,Float userCoin,String sourceName, AppVistorUser vistorUser) throws SQLException {
		AppUserBill appUserBill = sourceSerice.getBillById(billingId);
		if (appUserBill==null) 
		throw new BillNotExistException(null);
		
		if (appUserBill.getFlowCoins()!=(flowCoins+userCoin)) 
			throw new CoinUseNotMatchException(null);
		
		if (appUserBill.getFlowCoins()<userCoin) 
			throw new CoinUseNotMatchException(null);
		
		if (appUserBill.getStatus()==0){
			if (user!=null) {
				user.setMakeFlow(user.getMakeFlow()+appUserBill.getFlowCoins());
				user.setFlowCoins(user.getFlowCoins()+flowCoins+userCoin);
			}else {
				vistorUser.setMakeFlow(vistorUser.getMakeFlow()+appUserBill.getFlowCoins());
				vistorUser.setFlowCoins(vistorUser.getFlowCoins()+flowCoins+userCoin);
			}
		}
			
		if (!sourceSerice.updateBillById(appUserBill,flowCoins,sourceName)) 
			throw new BaseAPIException();
		
		if (appUserBill.getExpireTime()==null || appUserBill.getExpireTime().compareTo(new Date())>0) {
			AppUserBillLog appUserBillLog = sourceSerice.addBillLog(user,billingId,flowCoins,userCoin,sourceName,appUserBill,vistorUser);
			
			if (appUserBillLog!=null) {
				if (user!=null) {
					user.setFlowCoins(user.getFlowCoins()-userCoin);
					user.setUserFlow(user.getUserFlow()+userCoin);
					user.setUpdatedBy(Constant.UPDATE_BY_API);
					user.setUpdatedTime(DateUtil.getCurrentDate());
					if (!userService.update(user)) {
						throw new BaseAPIException();
					}else {
						return true;
					}
				}else {
					vistorUser.setFlowCoins(vistorUser.getFlowCoins()-userCoin);
					vistorUser.setUserFlow(vistorUser.getUserFlow()+userCoin);
					vistorUser.setUpdatedBy(Constant.UPDATE_BY_API);
					vistorUser.setUpdatedTime(DateUtil.getCurrentDate());
					if (!vistorUserService.update(vistorUser)) {
						throw new BaseAPIException();
					}else {
						return true;
					}
				}
				
			}else{
				throw  new BillExpireException(null);
			}
		}
		return false;
	}

	/*
	 * 使用刮刮卡的流程
	 */
	public int getScratchCoins(AppUser user, Integer scratchId) throws SQLException {
		int returnFloat = 0;
		AppScratch appScratch =scratchService.getScratchCoins(scratchId);
		
		if (appScratch==null) 
		 throw new ScratchNotExistException(null);	
		
		if (user.getFlowCoins()<appScratch.getFlowCoins()) 
		throw new FlowCoinNotEnoughException(null);
		
		//TODO:扣除流量币，中奖后加流量币
		Random random = new Random();
		int newFlow = random.nextInt(10);
		if (newFlow<=3&&newFlow>=1) {
			returnFloat =newFlow;
			scratchService.addUserScratch(user,appScratch, "使用刮刮卡获奖流量币"+returnFloat+".0",2,returnFloat);
		}
		user.setUpdatedBy(Constant.UPDATE_BY_API);
		user.setUpdatedTime(DateUtil.getCurrentDate());
		user.setFlowCoins(user.getFlowCoins()-appScratch.getFlowCoins()+returnFloat);
		if ( userService.update(user)) {
			scratchService.addUserScratch(user, appScratch, "使用刮刮卡消耗流量币"+appScratch.getFlowCoins(), 1, appScratch.getFlowCoins());
			return returnFloat;
		}else {
			throw new BaseAPIException();
		}
		
	}

	/*
	 * 获取账单记录 
	 */
	public List<Map<String, Object>> getBillList(String userId, Integer type) {
//		List<Map<String,Object>> list= new ArrayList<Map<String,Object>>();
//		List<Map<String,Object>> list= billRecordService.getBillList(userId);
//		
		List<Map<String,Object>> returnList = new ArrayList<Map<String,Object>>();
		
		if (type==null) {
			returnList.addAll(getBillLogByUserId(userId));
			returnList.addAll(getBillByUserId(userId));
			returnList.addAll(getUserScratch(userId, null));
		}else if (type==1) {
			returnList.addAll(getBillLogByUserId(userId));
			returnList.addAll(getUserScratch(userId, type));
		}else if (type==2) {
			returnList.addAll(getBillByUserId(userId));
			returnList.addAll(getUserScratch(userId, type));
		}else {
			returnList.addAll(getBillLogByUserId(userId));
			returnList.addAll(getBillByUserId(userId));
			returnList.addAll(getUserScratch(userId, null));
		}
		
		
		Collections.sort(returnList, new Comparator<Map<String,Object>>() {
			@Override
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				return (int) ((Long.parseLong(o2.get("time").toString())-Long.parseLong(o1.get("time").toString())));
			}
		});
		return returnList;
	}
	
	private List<Map<String,Object>> getBillLogByUserId(String userId){
		List<Map<String,Object>> returnList = new ArrayList<Map<String,Object>>();
		List<AppUserBillLog> userBillLogList = sourceSerice.getBillLogByUserId(userId);
		for (AppUserBillLog appUserBillLog : userBillLogList) {
			Map<String,Object> m = new HashMap<String, Object>();
			m.put("status", 1);//账单记录使用状态，0是未完成，1是完成
			m.put("description", appUserBillLog.getDescription());//账单记录描述
			m.put("time",  appUserBillLog.getCreatedTime().getTime());//账单记录时间
			m.put("makeFlows", appUserBillLog.getUserCoin());//账单记录的流量增减
			m.put("type", 1);
			m.put("billId", appUserBillLog.getBillId());
			m.put("generate_key", 1+"_"+appUserBillLog.getId().toString());
			returnList.add(m);
		}
		return returnList;
	}
	
     private List<Map<String,Object>> getBillByUserId(String userId){
    		List<Map<String,Object>> returnList = new ArrayList<Map<String,Object>>();
    		List<AppUserBill>  userBillList = sourceSerice.getBillByUserId(userId);
    		for (AppUserBill appUserBill : userBillList) {
    			Map<String,Object> m = new HashMap<String, Object>();
    			m.put("status", appUserBill.getStatus());//账单记录使用状态，0是未完成，1是完成
    			m.put("description",appUserBill.getDescription());//账单记录描述
    			m.put("time",  appUserBill.getCreatedTime().getTime());//账单记录时间
    			m.put("makeFlows", appUserBill.getRewardCoins());//账单记录的流量增减
    			m.put("type", 2);
    			m.put("billId", Integer.parseInt(appUserBill.getId().toString()));
    			m.put("generate_key", 2+"_"+appUserBill.getId().toString());
    			returnList.add(m);
    		}
    		return returnList;
	}
     
     private List<Map<String,Object>> getUserScratch(String userId,Integer type){
    	 List<Map<String,Object>> returnList = new ArrayList<Map<String,Object>>();
    	 List<AppUserScratch> appUserScratchList = scratchService.getUserScratch(userId,type);
 		for (int i = 0; i < appUserScratchList.size(); i++) {
 			Map<String,Object> m = new HashMap<String, Object>();
 			m.put("status",1);//账单记录使用状态，0是未完成，1是完成
 			m.put("description",appUserScratchList.get(i).getDescription());//账单记录描述
 			m.put("time",  appUserScratchList.get(i).getCreatedTime().getTime());//账单记录时间
 			m.put("makeFlows", appUserScratchList.get(i).getMakeFlows());//账单记录的流量增减
 			m.put("type", appUserScratchList.get(i).getType());
 			m.put("billId", Integer.parseInt(appUserScratchList.get(i).getId().toString()));
 			m.put("generate_key", appUserScratchList.get(i).getType()+"_"+appUserScratchList.get(i).getId().toString());
 			returnList.add(m);
 		}
 		return returnList;
 	}

     /*
      * 根据要分配哪种类型的流量送取，保存账单
      */
	public RequestCoinsVO  requestCoins(AppUser user, Integer type) throws SQLException {
		float f = 0f;
		if (type==1) {
			f=10L;
		}else if (type==2) {
			f=15;
		}else if (type==3) {
			f=20;
		}
		if (user.getFlowCoins()<f) 
			throw new FlowCoinNotEnoughException(null);
		
		if (sourceSerice.requestCoins(user,f)==null) 
		throw new BaseAPIException();
		
		user.setFlowCoins(user.getFlowCoins()-f);
		user.setUserFlow(user.getUserFlow()+f);
		user.setUpdatedBy(Constant.UPDATE_BY_API);
		user.setUpdatedTime(DateUtil.getCurrentDate());
		if (!userService.update(user))
			throw new BaseAPIException();
		
		RequestCoinsVO vo = new RequestCoinsVO();
		vo.setCredit(user.getCredit());
		vo.setFlowCoins(user.getFlowCoins());
		vo.setPoint(user.getPoint());
		vo.setUserFlow(user.getUserFlow());
		return vo;
	
	}

	/*
	 * 获取流量包规则
	 */
	public List<FlowPkgVO> getFlowPkg() {
		List<FlowPkgVO>  list = new ArrayList<FlowPkgVO>();
		List<AppFlowPackage> appFlowPackages = flowPkgService.getFlowPkg();
		
		for (AppFlowPackage flow : appFlowPackages) {
			FlowPkgVO vo = new FlowPkgVO();
			vo.setExpireDate(flow.getExpireDate());
			vo.setFlowCoins(flow.getFlowCoins());
			vo.setType(Integer.parseInt(flow.getId().toString()));
			vo.setFreeCoins(flow.getFlowCoins());
			list.add(vo);
		}
		
		return list;
	}

	/*
	 * 
	 */
	public List<AdsVO> getFarVideo(String userId) throws UnsupportedEncodingException {
		
			List<AdsVO>  returnList = new ArrayList<AdsVO>();
		    List<Map<String, Object>> list = sourceService.getFarVideo(userId);
//				List<Map<String, Object>> list = sourceService.getVideoList("createTime", "desc", 1, Constant.PAGE_NUM,null);
//				return getVideoList(list);
				
//				 AppUserBill appUserBill = sourceService.checkBill(user, sourceId, type);
//				
//			 Map<String, Object> map = sourceService.getVideoDetail(sourceId);
//			 
//			 
//			 
		    for (Map<String, Object> map : list) {
		    	AdsVO  adsVO = new AdsVO();
		    	String description = map.get("description").toString();
		    	adsVO.setContent(string2Json(URLDecoder.decode(description == null ? "" : description, "utf-8")));
		    	adsVO.setCover(map.get("picture").toString());
		    	adsVO.setDuration(0L);
		    	
		    	adsVO.setFinishTime(0L);
		    	adsVO.setMakeFlows(Float.parseFloat(map.get("flowCoins").toString()));
		    	adsVO.setInstruction(string2Json(URLDecoder.decode(description == null ? "" : description, "utf-8")));
		    	
		    	if (map.get("status")==null|| map.get("status").equals("0")) {
		    		adsVO.setIsFinished(0);
		    	}else if(map.get("status").equals("0")){
		    		adsVO.setIsFinished(1);
		    	}
		    	adsVO.setPublishTime(map.get("createTime").toString());
		    	String title = map.get("title").toString();
		    	adsVO.setTitle(URLDecoder.decode(title == null ? "" : title, "utf-8"));
		    	adsVO.setVideoId(Integer.parseInt(map.get("id").toString()));
		    	adsVO.setVideoUrl(StringToArray(map.get("videoUrl").toString())[0]);
		    	adsVO.setVtimeEnd("");
		    	adsVO.setVtimeStart("");
		    	returnList.add(adsVO);
			}
			
			return returnList;
				 
	}
	

       private List<RandomAdsModel> getVideoList(List<Map<String, Object>> list){
	     List<RandomAdsModel> modelList = new ArrayList<RandomAdsModel>();
	     for (Map<String, Object> map : list) {
		 RandomAdsModel model = new RandomAdsModel();
		 model.setIcon(map.get("tinyPicture").toString());
		 model.setMakeFlows(Float.parseFloat(map.get("flowCoins").toString()));
		 model.setSourceId(Integer.parseInt(map.get("id").toString()));
		 model.setTitle(map.get("title").toString());
		 model.setType(1);
		 model.setSourceUrl(StringToArray(map.get("videoUrl").toString())[0]);
		 modelList.add(model);
	     }
	   return modelList;
       }

       /*
        * 获取游戏的集合
        */
	public List<GameVO> getGameList() throws Exception {
		String url = "http://203.195.202.229:10090/api-getH5Games.html";
		 String resultDownServer = HttpClientUtils.getMethodRequest(url);
		 List<GameVO> list = Json.toListObject(resultDownServer, GameVO.class);
			
			return list;
	}

	public List<SoftVO> getFarApp(String userId) throws UnsupportedEncodingException {
		List<SoftVO> list = new ArrayList<SoftVO>();
		List<Map<String, Object>> mapList = sourceService.getFarApp(userId);
		 
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			SoftVO softVO = new SoftVO();
			softVO.setPackageName(map.get("pkgName").toString());
			softVO.setAppId(Integer.parseInt(map.get("rowid").toString()));
			softVO.setTitle(map.get("name").toString());
			softVO.setVersion(map.get("version").toString());
			softVO.setAppIcon(map.get("iconURL").toString());
			softVO.setAppUrl(map.get("downloadURL").toString());
			softVO.setAppBannerPic(StringToArray(map.get("screenshot").toString()));
			softVO.setApppreView(StringToArray(map.get("smallPic").toString()));
			String description = map.get("description").toString();
			softVO.setInstruction(string2Json(description));
			softVO.setSize(Float.parseFloat(map.get("apkSizeRaw").toString()));
			softVO.setDownloadFinishTime(0L);
			String whatsNew = map.get("overview").toString();
			softVO.setIntroduction(string2Json(URLDecoder.decode(whatsNew == null ? "" : whatsNew, "utf-8")));
			softVO.setFlowCoins(Float.parseFloat(map.get("flowCoins").toString()));
			softVO.setShareCoins(Float.parseFloat(map.get("shareCoins").toString()));
			if (map.get("status")==null|| map.get("status").toString().equals("0")) {
				softVO.setIsDownloadFinished(false);
			}else if (map.get("status").toString().equals("1")) {
				softVO.setIsDownloadFinished(true);
			}
			softVO.setIsDownloadFinished(false);
			softVO.setIsShareFinished(false);
			softVO.setShareFinishTime(0L);
			list.add(softVO);
		}
		return list;
	}
}
