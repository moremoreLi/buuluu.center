package com.user.buuluu.web.handle;

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
import org.springframework.stereotype.Component;

import com.user.buuluu.common.exception.BaseAPIException;
import com.user.buuluu.common.exception.BillExistException;
import com.user.buuluu.common.exception.BillExpireException;
import com.user.buuluu.common.exception.BillNotExistException;
import com.user.buuluu.common.exception.CoinUseNotMatchException;
import com.user.buuluu.common.exception.ScratchNotExistException;
import com.user.buuluu.common.util.Constant;
import com.user.buuluu.common.util.DateUtil;
import com.user.buuluu.common.util.Json;
import com.user.buuluu.common.util.PropertiesUtil;
import com.user.buuluu.dao.model.AppInfoAllRowModel;
import com.user.buuluu.dao.model.AppVideoAllRow;
import com.user.buuluu.model.AdVideoWithBLOBs;
import com.user.buuluu.model.AppBuuluuUser;
import com.user.buuluu.model.AppFlowPackage;
import com.user.buuluu.model.AppInfoWithBLOBs;
import com.user.buuluu.model.AppScratch;
import com.user.buuluu.model.AppUserBill;
import com.user.buuluu.model.AppUserBillLog;
import com.user.buuluu.model.AppVistorUser;
import com.user.buuluu.service.FlowPkgService;
import com.user.buuluu.service.ScratchService;
import com.user.buuluu.service.SourceService;
import com.user.buuluu.service.UserService;
import com.user.buuluu.service.VistorUserService;
import com.user.buuluu.util.HttpClientUtils;
import com.user.buuluu.vo.AdsVO;
import com.user.buuluu.vo.RandomAdsModel;
import com.user.buuluu.vo.RequestCoinsVO;
import com.user.buuluu.vo.SoftVO;
import com.user.buuluu.web.view.FlowPkgVO;
import com.user.buuluu.web.view.GameVO;


/**
 * 赚流量的相关接口
 * @author More
 *2015-7-25
 */
@Component
public class FlowCoinHandler {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FlowHandler flowHandler;
	
	@Autowired
	private ScratchService scratchService;
	/*
	@Autowired
	private BillRecordService billRecordService;
	*/
	@Autowired
	private FlowPkgService flowPkgService;
	
	@Autowired
	private SourceService sourceService;
	
	@Autowired
	private VistorUserService vistorUserService;
	
	private static final String LOCAL_SERVER= PropertiesUtil.getProperty("LOCAL_SERVER");
	
	public AppUserBill getFlowCoins(AppBuuluuUser user, Integer sourceId,Integer type, AppVistorUser vistorUser) throws SQLException {
//		 Map<String, Object> sourceObj = sourceSerice.getSource(sourceId,type);
//		 if (sourceObj==null) 
//			throw new SourceNotExistException(null);
//		
//		AppUserBill appUserBill = sourceSerice.saveBill(user,sourceId,type,sourceObj,vistorUser);
		String desc = "";
		Float flowCoins = 0F;
		if (type==1) {
			AdVideoWithBLOBs video = sourceService.getVideoDetail(sourceId,Constant.CMS_LINK_IMAGE_PATH);
			desc = video.getTitle();
			flowCoins = new Float(video.getFlowcoins());
		}else if (type==2) {
			AppInfoWithBLOBs appInfo = sourceService.getAppDetail(sourceId,Constant.getUserId()+sourceId);
			desc = appInfo.getName();
			flowCoins = new Float(appInfo.getFlowcoins());
		}else if (type==3) {
			
		}
		
		return returnMap(user, sourceId, type, vistorUser, desc, flowCoins);
		
	}

	/**
	 * 根据类型查找是否存在账单记录
	 * @param user
	 * @param sourceId
	 * @param type
	 * @param vistorUser
	 * @return
	 */
	private AppUserBill returnMap(AppBuuluuUser user, Integer sourceId,Integer type, AppVistorUser vistorUser,String desc,Float flowCoins){
		Map<String,Object> map = new HashMap<String	, Object>();
		String userId = "";
		if (user!=null) {
			userId= user.getId();
		}else if (vistorUser!=null) {
			userId= vistorUser.getId();
		}
		map.put("userId", userId);
		map.put("sourceId", sourceId);
		map.put("type", type);
		String key = userId+Constant.SPLITE_STRING+sourceId+Constant.SPLITE_STRING+type;
		AppUserBill userBill = sourceService.checkBill(map, key);
		if (userBill==null) {
				userBill = new AppUserBill();
				userBill.setCreatedBy(Constant.CREATE_BY_API);
				userBill.setCreatedTime(DateUtil.getCurrentDate());
				userBill.setUserId(userId);
				userBill.setSourceId(new Long(sourceId));
				userBill.setRewardCoins(flowCoins);
				userBill.setExpireTime(DateUtil.addYears(new Date(), 3));
				userBill.setType(type);
				userBill.setStatus(0);
				userBill.setIsDeleted(0);
				if (type==1) {
					userBill.setDescription("正在观看'"+desc+"'，未完成");
				}else if (type==2) {
					userBill.setDescription("正在下载'"+desc+"'，未完成");
				}else{
					userBill.setDescription("正在进行中，未完成");
				}
				userBill.setFlowCoins(flowCoins);
				sourceService.saveBill(userBill,userBill.getUserId()+Constant.getUserId());
				return userBill;
		}else {
			if (userBill.getStatus()==1) {
				throw new BillExistException(null);
			}else {
				return userBill;
			}
		}
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

	public boolean  useCoins(AppBuuluuUser user, Integer billingId, Float flowCoins,Float userCoin,String sourceName, AppVistorUser vistorUser) throws SQLException {
		AppUserBill appUserBill = sourceService.getBillById(new Long(billingId));
		if (appUserBill==null) 
		throw new BillNotExistException(null);
		
		if (appUserBill.getFlowCoins()!=(flowCoins+userCoin)) 
			throw new CoinUseNotMatchException(null);
		
		if (appUserBill.getFlowCoins()<userCoin) 
			throw new CoinUseNotMatchException(null);
		
		if (appUserBill.getStatus()==0){
			if (user!=null) {
//				user.setMakeFlow(user.getMakeFlow()+appUserBill.getFlowCoins());
//				user.setFlowCoins(user.getFlowCoins()+flowCoins+userCoin);
				
			}else {
				vistorUser.setMakeFlow(vistorUser.getMakeFlow()+appUserBill.getFlowCoins());
				vistorUser.setFlowCoins(vistorUser.getFlowCoins()+flowCoins+userCoin);
			}
		}
		appUserBill.setUpdatedBy(Constant.UPDATE_BY_API);
		appUserBill.setUpdatedTime(DateUtil.getCurrentDate());
		if (appUserBill.getStatus()==0) {
			if (appUserBill.getType()==1) {
				appUserBill.setDescription("观看了"+(sourceName==null?"":sourceName)+"赠送了"+appUserBill.getFlowCoins()+"流量礼包");
			}else {
				appUserBill.setDescription("下载了"+(sourceName==null?"":sourceName)+"赠送了"+appUserBill.getFlowCoins()+"流量礼包");
			}
		}
		appUserBill.setStatus(1);
		appUserBill.setFlowCoins(flowCoins);
		boolean flag =sourceService.updateBillById(appUserBill,billingId);
		if (!flag) {
			throw new BaseAPIException();
		}
		
		if (appUserBill.getExpireTime()==null || appUserBill.getExpireTime().compareTo(new Date())>0) {
			String userId = "";
			String desc ="";
			if (user!=null) {
				userId= user.getId();
			}else if (vistorUser!=null) {
				userId = vistorUser.getId();
			}
			if (appUserBill.getType()==1) {
				desc ="观看了"+(sourceName==null?"":sourceName)+",使用了"+userCoin+"流量充值";
			}else {
				desc ="下载了"+(sourceName==null?"":sourceName)+",使用了"+userCoin+"流量充值";
			}
			AppUserBillLog appUserBillLog = new AppUserBillLog();
			appUserBillLog.setBillId(new Long(billingId));
			appUserBillLog.setCreatedBy(Constant.CREATE_BY_API);
			appUserBillLog.setCreatedTime(DateUtil.getCurrentDate());
			appUserBillLog.setDescription(desc);
			appUserBillLog.setFlowCoins(flowCoins.intValue());
			appUserBillLog.setUserCoin(userCoin.intValue());
			appUserBillLog.setUserId(userId);
			appUserBillLog.setIsDeleted(0);
			int insertCount = sourceService.addBillLog(appUserBillLog,Constant.getUserId()+appUserBillLog.getUserId());
			
			if (insertCount>0) {
				if (user!=null) {
//					user.setFlowCoins(user.getFlowCoins()-userCoin);
//					user.setUserFlow(user.getUserFlow()+userCoin);
//					user.setUpdatedBy(Constant.UPDATE_BY_API);
//					user.setUpdatedTime(DateUtil.getCurrentDate());
//					if (!userService.update(user)) {
//						throw new BaseAPIException();
//					}else {
//						return true;
//					}
					//TODO:请求用户服务器更新用户流量币信息
					return true;
				}else {
					vistorUser.setFlowCoins(vistorUser.getFlowCoins()-userCoin);
					vistorUser.setUserFlow(vistorUser.getUserFlow()+userCoin);
					vistorUser.setUpdatedBy(Constant.UPDATE_BY_API);
					vistorUser.setUpdatedTime(DateUtil.getCurrentDate());
					if (!vistorUserService.update(vistorUser,Constant.getSessionId()+vistorUser.getId())) {
						throw new BaseAPIException();
					}else {
						return true;
					}
				}
				
			}else {
				throw new BaseAPIException();
			}
		}else{
			throw  new BillExpireException(null);
		}
	}

	/*使用刮刮卡的流程*/
	 
	public int getScratchCoins(AppBuuluuUser user, Integer scratchId) throws SQLException {
		int returnFloat = 0;
		AppScratch appScratch =scratchService.getScratchCoins(scratchId,scratchId+Constant.getSessionId());
		
		if (appScratch==null) 
		 throw new ScratchNotExistException(null);	
//		
//		if (user.getFlowCoins()<appScratch.getFlowCoins()) 
//		throw new FlowCoinNotEnoughException(null);
		
		//TODO:扣除流量币，中奖后加流量币
		Random random = new Random();
		int newFlow = random.nextInt(10);
		if (newFlow<=3&&newFlow>=1) {
			returnFloat =newFlow;
			scratchService.addUserScratch(user,appScratch, "使用刮刮卡获奖流量币"+returnFloat+".0",2,Float.valueOf(returnFloat),user.getId()+appScratch.getId());
		}
		user.setUpdatedBy(Constant.UPDATE_BY_API);
		user.setUpdatedTime(DateUtil.getCurrentDate());
//		user.setFlowCoins(user.getFlowCoins()-appScratch.getFlowCoins()+returnFloat);
		if ( userService.updateUser(user, user.getId())==1) {
			scratchService.addUserScratch(user, appScratch, "使用刮刮卡消耗流量币"+appScratch.getFlowCoins(), 1, appScratch.getFlowCoins(),user.getId()+appScratch.getId());
			return returnFloat;
		}else {
			throw new BaseAPIException();
		}
		
	}

	/**
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
		List<AppUserBillLog> userBillLogList = sourceService.getBillLogByUserId(userId);
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
    		List<AppUserBill>  userBillList = sourceService.getBillByUserId(userId);
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
    	/* List<AppUserScratch> appUserScratchList = sourceService.getUserScratch(userId,type);
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
 		}*/
 		return returnList;
 	}

     /*
      * 根据要分配哪种类型的流量送取，保存账单
      */
	public RequestCoinsVO  requestCoins(AppBuuluuUser user, Integer type) throws SQLException {
		float f = 0f;
		if (type==1) {
			f=10L;
		}else if (type==2) {
			f=15;
		}else if (type==3) {
			f=20;
		}
		/*if (user.getFlowCoins()<f) 
			throw new FlowCoinNotEnoughException(null);*/
		
		if (sourceService.requestCoins(user,f,user.getId()+Constant.getUserId())==0) 
		throw new BaseAPIException();
		
	/*	user.setFlowCoins(user.getFlowCoins()-f);
		user.setUserFlow(user.getUserFlow()+f);
		user.setUpdatedBy(Constant.UPDATE_BY_API);
		user.setUpdatedTime(DateUtil.getCurrentDate());
		if (!userService.update(user))
			throw new BaseAPIException();*/
		
		RequestCoinsVO vo = new RequestCoinsVO();
		vo.setCredit(0);
		vo.setFlowCoins(0);
		vo.setPoint(0);
		vo.setUserFlow(0);
		return vo;
	
	}
		/*获取流量包规则*/
	 
	public List<FlowPkgVO> getFlowPkg() {
		List<FlowPkgVO>  list = new ArrayList<FlowPkgVO>();
		List<AppFlowPackage> appFlowPackages = flowPkgService.getFlowPkg(Constant.getSessionId()+Constant.getUserId());
		
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

	
	public List<AdsVO> getFarVideo(String userId) throws UnsupportedEncodingException {
		
		List<AdsVO>  returnList = new ArrayList<AdsVO>();
	    List<AppVideoAllRow> list = sourceService.getFarVideo(userId);
//				List<Map<String, Object>> list = sourceService.getVideoList("createTime", "desc", 1, Constant.PAGE_NUM,null);
//				return getVideoList(list);
				
//				 AppUserBill appUserBill = sourceService.checkBill(user, sourceId, type);
//				
//			 Map<String, Object> map = sourceService.getVideoDetail(sourceId);
//			 
//			 
//		 if(list==null){
	    for(int i=0;i<list.size();i++){
	    	AdsVO  adsVO = new AdsVO();
	    	String description=list.get(i).getDescription();
	    	adsVO.setContent(string2Json(URLDecoder.decode(description == null ? "" : description, "utf-8")));
	    	adsVO.setCover(list.get(i).getPicture());
	    	adsVO.setDuration(0L);
	    	adsVO.setFinishTime(0L);
	    	adsVO.setMakeFlows(Float.valueOf(list.get(i).getFlowcoins()));
	    	adsVO.setInstruction(string2Json(URLDecoder.decode(description == null ? "" : description, "utf-8")));
	    	adsVO.setIsFinished(1);
	    	adsVO.setPublishTime(list.get(i).getCreatetime());
	    	String title = list.get(i).getTitle();
	    	adsVO.setTitle(URLDecoder.decode(title == null ? "" : title, "utf-8"));
	    	adsVO.setVideoId(list.get(i).getId());
	    	adsVO.setVideoUrl(list.get(i).getVideourl());
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

       
       /*  获取游戏的集合*/
        
	public List<GameVO> getGameList() throws Exception {
		String url = "http://203.195.202.229:10090/api-getH5Games.html";
		 String resultDownServer = HttpClientUtils.getMethodRequest(url);
		 List<GameVO> list = Json.toListObject(resultDownServer, GameVO.class);
			return list;
	}

	public List<SoftVO> getFarApp(String userId) throws UnsupportedEncodingException {
		List<SoftVO> list = new ArrayList<SoftVO>();
		List<AppInfoAllRowModel> mapList = sourceService.getFarApp(userId);
		 if(mapList==null){
			 return null;
		 }
		 
		 for(int i=1;i<mapList.size();i++){
			SoftVO softVO = new SoftVO();
			softVO.setPackageName(mapList.get(i).getPkgname());
			softVO.setAppId(mapList.get(i).getRowid());
			softVO.setTitle(mapList.get(i).getName());
			softVO.setVersion(mapList.get(i).getVersion());
//			softVO.setAppIcon(mapList.get(i).get);
			softVO.setAppUrl(mapList.get(i).getDownloadurl());
//			softVO.setAppBannerPic(Integer.parseInt(mapList.get(i).getPrice()));
//			softVO.setApppreView(mapList.get(i).getOverview());
			String description = mapList.get(i).getDescription();
			softVO.setInstruction(string2Json(description));
			softVO.setSize(mapList.get(i).getApksizeraw()+0.0f);
			softVO.setDownloadFinishTime(0L);
			String whatsNew = mapList.get(i).getOverview();
			softVO.setIntroduction(string2Json(URLDecoder.decode(whatsNew == null ? "" : whatsNew, "utf-8")));
			softVO.setFlowCoins(mapList.get(i).getFlowcoins()+0.0f);
			softVO.setShareCoins(mapList.get(i).getSharecoins()+0.0f);
			if (mapList.get(i).getStatus()==0) {
				softVO.setIsDownloadFinished(false);
			}else if (mapList.get(i).getStatus()==1) {
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
