package com.user.buuluu.web.handle;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.buuluu.common.util.Constant;
import com.user.buuluu.common.util.PropertiesUtil;
import com.user.buuluu.dao.model.AppInfoModel;
import com.user.buuluu.dao.model.AppRandModel;
import com.user.buuluu.model.AdVideoWithBLOBs;
import com.user.buuluu.service.SourceService;
import com.user.buuluu.vo.RandomAdsModel;

/**
 * flow的相关
 * @author More
 *2015-7-20
 */
@Component
public class FlowHandler {
	
	private static final String DOWNLOAD_SERVER= PropertiesUtil.getProperty("DOWNLOAD_SERVER");
	
	public static Map<String,List> adsMap = new HashMap<String, List>();
	
	@Autowired
	private SourceService sourceService;
	
	/*
	 * categoryid 大分类  1代表应用、2代表游戏
       classid 小分类 -1 代表所有分类，其余大于等于0的值代表相应小分类
       order 排序字段 有 name、author、apkSizeRaw、downloadTimes、updateTime、starScore
	 */
	/*public Map<String,Object> getDownloadList() throws Exception {
//		boolean flag = true;//资源服务器开启状态
//		String url = DOWNLOAD_SERVER+"appinfo-applist-aaaaa.html?categoryid=1&classid=-1&order=apkSizeRaw&orderType=asc&page=1";
//		String resultDownServer = null;
//		try {
//			 resultDownServer = HttpClientUtils.getMethodRequest(url);
//		} catch (Exception e) {
//			e.printStackTrace();
//			flag = false;
//		}
//		List<SoftVO> softList = new ArrayList<SoftVO>();
//		Map<String, Object> map = new HashMap<String, Object>();
//		if (flag&&StringUtils.isNotEmpty(resultDownServer)) {
//			List<DownLoadAppModel> list = Json.toListObject(resultDownServer, DownLoadAppModel.class);
//			
//			for (DownLoadAppModel downLoadAppModel : list) {
//				softList.add(setSoftVO(downLoadAppModel));
//			}
//		}else {
//			for (int i = 0; i < Constant.PAGE_NUM; i++) {
//				SoftVO softVO = new SoftVO();
//				softList.add(softVO);
//			}
//		}
//		
//		
//		map.put("bannerList", softList);
//		map.put("appList", softList);
//		return map;
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = sourceService.getAppList(1, -1, "apkSizeRaw", "desc", 1,null);
		List bannerList = new ArrayList();
		List appList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			if (i<5) {
				RandomAdsModel model = new RandomAdsModel();
				model.setIcon(list.get(i).get("iconURL").toString());
				model.setMakeFlows(Float.parseFloat(list.get(i).get("flowCoins").toString()));
				model.setSourceId(Integer.parseInt(list.get(i).get("rowid").toString()));
				model.setTitle(list.get(i).get("name").toString());
				model.setType(2);
				bannerList.add(model);
			}else if (i<15) {
				RandomAdsModel model = new RandomAdsModel();
				model.setIcon(list.get(i).get("iconURL").toString());
				model.setMakeFlows(Float.parseFloat(list.get(i).get("flowCoins").toString()));
				model.setSourceId(Integer.parseInt(list.get(i).get("rowid").toString()));
				model.setTitle(list.get(i).get("name").toString());
				model.setType(2);
				appList.add(model);
			}
			
			map.put("bannerList", bannerList);
			map.put("appList", appList);
		}
		return map;
	}
	
	public Map<String, Object> getDownloadNextList(Integer pageNo) throws UnsupportedEncodingException {
//		boolean flag = true;//资源服务器开启状态
//		String url = DOWNLOAD_SERVER+"appinfo-applist-aaaaa.html?categoryid=1&classid=-1&order=apkSizeRaw&orderType=asc&page=1";
//		String resultDownServer = null;
//		try {
//			 resultDownServer = HttpClientUtils.getMethodRequest(url);
//		} catch (Exception e) {
//			e.printStackTrace();
//			flag = false;
//		}
//		List<SoftVO> softList = new ArrayList<SoftVO>();
//		Map<String, Object> map = new HashMap<String, Object>();
//		if (flag&&StringUtils.isNotEmpty(resultDownServer)) {
//			List<DownLoadAppModel> list = Json.toListObject(resultDownServer, DownLoadAppModel.class);
//			
//			for (DownLoadAppModel downLoadAppModel : list) {
//				softList.add(setSoftVO(downLoadAppModel));
//			}
//		}else {
//			for (int i = 0; i < Constant.PAGE_NUM; i++) {
//				SoftVO softVO = new SoftVO();
//				softList.add(softVO);
//			}
//		}
//		map.put("wonderfulList", softList);
//		map.put("hasNextPage", softList.size()<10?0:1);
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = sourceService.getAppList(1, -1, "apkSizeRaw", "desc", pageNo+1,pageNo);
		List wonderfulList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			RandomAdsModel model = new RandomAdsModel();
			model.setIcon(list.get(i).get("iconURL").toString());
			model.setMakeFlows(Float.parseFloat(list.get(i).get("flowCoins").toString()));
			model.setSourceId(Integer.parseInt(list.get(i).get("rowid").toString()));
			model.setTitle(list.get(i).get("name").toString());
			model.setType(2);
			wonderfulList.add(model);
		}
		map.put("wonderfulList", wonderfulList);
		map.put("hasNextPage", wonderfulList.size()<10?0:1);
		return map;
	}
	
	
	private SoftVO setSoftVO(DownLoadAppModel downLoadAppModel) throws UnsupportedEncodingException{
		SoftVO softVO = new SoftVO();
		softVO.setPackageName(downLoadAppModel.getPkgName());
		softVO.setAppId(Integer.parseInt(downLoadAppModel.getRowid()));
		softVO.setTitle(downLoadAppModel.getName());
		softVO.setVersion(downLoadAppModel.getVersion());
		softVO.setAppIcon(downLoadAppModel.getIconURL());
		softVO.setAppUrl(downLoadAppModel.getDownloadURL());
		softVO.setAppBannerPic(downLoadAppModel.getScreenshot());
		softVO.setApppreView(downLoadAppModel.getSmallPic());
		String description = downLoadAppModel.getDescription();
		softVO.setInstruction(string2Json(description));
		softVO.setSize(Float.parseFloat(downLoadAppModel.getApkSizeRaw()));
		softVO.setDownloadFinishTime(Long.parseLong(downLoadAppModel.getDownloadTimes()));
		String whatsNew = downLoadAppModel.getWhatsNew();
		softVO.setIntroduction(string2Json(URLDecoder.decode(whatsNew == null ? "" : whatsNew, "utf-8")));
		softVO.setFlowCoins(Float.parseFloat(downLoadAppModel.getFlowCoins()));
		softVO.setShareCoins(Float.parseFloat(downLoadAppModel.getShareCoins()));
		softVO.setIsDownloadFinished(false);
		softVO.setIsShareFinished(false);
		softVO.setShareFinishTime(0L);
		return softVO;
	}

	public Map<String,Object> getAdFristList(String userId) throws Exception {
//		String url = DOWNLOAD_SERVER+"api-adVideo.html";
//		String resultServer = HttpClientUtils.getMethodRequest(url);
//		List<DownLoadAdsModel> list = Json.toListObject(resultServer,DownLoadAdsModel.class);
		List  bannerList = new ArrayList();
		List newestList = new ArrayList();
		List  wonderfulList = new ArrayList();
		
		List<Map<String, Object>> list = sourceService.getVideoList("createTime", "desc", 1, 9,null);
//		for (int i = 0; i < list.size(); i++) {
//			if (i<3) {
//				AdsVO  adsVO = setAdsVO(list.get(i));
//				bannerList.add(adsVO);
//			}else if (i<6) {
//				AdsVO  adsVO = setAdsVO(list.get(i));
//				newestList.add(adsVO);
//			}else if (i<9) {
//				AdsVO  adsVO = setAdsVO(list.get(i));
//				wonderfulList.add(adsVO);
//			}
//		}
		for (int i = 0; i < list.size(); i++) {
			if (i<Constant.BANNER_SIZE*1) {
				RandomAdsModel model = new RandomAdsModel();
				model.setIcon(list.get(i).get("picture").toString());
				model.setMakeFlows(Float.parseFloat(list.get(i).get("flowCoins").toString()));
				model.setSourceId(Integer.parseInt(list.get(i).get("id").toString()));
				model.setTitle(list.get(i).get("title").toString());
				model.setType(1);
				bannerList.add(model);
			}else if (i<Constant.BANNER_SIZE*2) {
				RandomAdsModel model = new RandomAdsModel();
				model.setIcon(list.get(i).get("tinyPicture").toString());
				model.setMakeFlows(Float.parseFloat(list.get(i).get("flowCoins").toString()));
				model.setSourceId(Integer.parseInt(list.get(i).get("id").toString()));
				model.setTitle(list.get(i).get("title").toString());
				model.setType(1);
				newestList.add(model);
			}else if (i<Constant.BANNER_SIZE*3) {
				RandomAdsModel model = new RandomAdsModel();
				model.setIcon(list.get(i).get("picture").toString());
				model.setMakeFlows(Float.parseFloat(list.get(i).get("flowCoins").toString()));
				model.setSourceId(Integer.parseInt(list.get(i).get("id").toString()));
				model.setTitle(list.get(i).get("title").toString());
				model.setType(1);
				wonderfulList.add(model);
			}
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("bannerList", bannerList);//添加横向滚动的图片详细信息
		map.put("newestList", newestList);//添加横向的小方块图片详细信息
		map.put("wonderfulList", wonderfulList);//添加纵向的大图片详细信息
		return map;
	}
	
	private AdsVO setAdsVO(DownLoadAdsModel downLoadAdsModel) throws UnsupportedEncodingException{
		AdsVO  adsVO = new AdsVO();
		String description = downLoadAdsModel.getDescription();
		adsVO.setContent(string2Json(URLDecoder.decode(description == null ? "" : description, "utf-8")));
		adsVO.setCover(downLoadAdsModel.getPicture());
		adsVO.setDuration(0L);
		adsVO.setFinishTime(0L);
		adsVO.setMakeFlows(Float.parseFloat(downLoadAdsModel.getFlowCoins()));
		adsVO.setInstruction(string2Json(URLDecoder.decode(description == null ? "" : description, "utf-8")));
		adsVO.setIsFinished(0);
		adsVO.setPublishTime(downLoadAdsModel.getCreateTime());
		String title = downLoadAdsModel.getTitle();
		adsVO.setTitle(URLDecoder.decode(title == null ? "" : title, "utf-8"));
		adsVO.setVideoId(Integer.parseInt(downLoadAdsModel.getId()));
		adsVO.setVideoUrl(downLoadAdsModel.getVideoUrl().get("url270p"));
		adsVO.setVtimeEnd("");
		adsVO.setVtimeStart("");
		return adsVO;
	}

	public Map<String, Object> getGreatAdsList(Integer pageNo) throws Exception {
//		String url = DOWNLOAD_SERVER+"api-adVideo.html";
//		String resultServer = HttpClientUtils.getMethodRequest(url);
//		List<DownLoadAdsModel> list = Json.toListObject(resultServer,DownLoadAdsModel.class);
//		Map<String,Object> map = new HashMap<String, Object>();
//		List<AdsVO> wonderfulList = new ArrayList<AdsVO>();
//		//TODO:为了测试使用，页码大小为10
//	    for (int i = 0; i < list.size(); i++) {
//			wonderfulList.add(setAdsVO(list.get(i)));
//		}
//		map.put("wonderfulList", wonderfulList);//添加wonderfulList
//		map.put("hasNextPage", "0");//是否有下一页(0是没有下一页，1是有下一页）
		
		Map<String,Object> returnMap = new HashMap<String, Object>();
		if (pageNo==null|| pageNo<=1) 
			pageNo =1;
		
		
		List<Map<String, Object>> list = sourceService.getVideoList("createTime", "desc", pageNo, Constant.PAGE_NUM,1);
			List<RandomAdsModel> modelList = new ArrayList<RandomAdsModel>();
			for (Map<String, Object> map : list) {
				RandomAdsModel model = new RandomAdsModel();
				model.setIcon(map.get("tinyPicture").toString());
				model.setMakeFlows(Float.parseFloat(map.get("flowCoins").toString()));
				model.setSourceId(Integer.parseInt(map.get("id").toString()));
				model.setTitle(map.get("title").toString());
				model.setType(1);
				modelList.add(model);
			}
		returnMap.put("wonderfulList", modelList);//添加wonderfulList
		returnMap.put("hasNextPage", modelList.size()==Constant.PAGE_NUM?1:0);
		return returnMap;
	}
	
	 * JSON字符串特殊字符处理，比如：“\A1;1300” 
     * @param s 
     * @return String 
	 
	private String  string2Json(String s){
		return s.replaceAll("\r", "\\r").replaceAll("\n", "\\n").replaceAll("/", "\\/");
	}

/**
 * 随机获取广告
 */
	public List getAds(String userId,Integer type) throws Exception {
		List modelList = new ArrayList();
		if (type==null) {
			   List<AppRandModel> videoList = sourceService.getRandForVideo(2);
			   List<AppRandModel> appList = sourceService.getRandForApp(3);
			  for (int i = 0; i < videoList.size(); i++) {
				  RandomAdsModel model = new RandomAdsModel();
				  model.setIcon(videoList.get(i).getIcon());
				  model.setMakeFlows(new Float(videoList.get(i).getMakeFlows()));
				  model.setSourceId(videoList.get(i).getSourceId());
				  model.setTitle(videoList.get(i).getTitle());
				  model.setSourceUrl(StringToArray(videoList.get(i).getVideoUrl())[0]);
				  model.setType(1);
				  modelList.add(model);
			}
			  for (int i = 0; i < appList.size(); i++) {
				  RandomAdsModel model = new RandomAdsModel();
				  model.setIcon(appList.get(i).getIcon());
				  model.setMakeFlows(new Float(appList.get(i).getMakeFlows()));
				  model.setSourceId(appList.get(i).getSourceId());
				  model.setTitle(appList.get(i).getTitle());
				  model.setSourceUrl(StringToArray(appList.get(i).getVideoUrl())[0]);
				  model.setType(2);
				  modelList.add(model);
			}
			  Collections.shuffle(modelList);
		}else if (type==1) {
			 List<AppRandModel> videoList = sourceService.getRandForVideo(5);
			for (int i = 0; i < videoList.size(); i++) {
				 RandomAdsModel model = new RandomAdsModel();
				  model.setIcon(videoList.get(i).getIcon());
				  model.setMakeFlows(new Float(videoList.get(i).getMakeFlows()));
				  model.setSourceId(videoList.get(i).getSourceId());
				  model.setTitle(videoList.get(i).getTitle());
				  model.setSourceUrl(StringToArray(videoList.get(i).getVideoUrl())[0]);
				  model.setType(1);
				  modelList.add(model);
			}
		}else if(type==2){
			
		}else if(type ==3){
			
		}else{
			   List<AppRandModel> videoList = sourceService.getRandForVideo(2);
			   List<AppRandModel> appList = sourceService.getRandForApp(3);
			  for (int i = 0; i < videoList.size(); i++) {
				  RandomAdsModel model = new RandomAdsModel();
				  model.setIcon(videoList.get(i).getIcon());
				  model.setMakeFlows(new Float(videoList.get(i).getMakeFlows()));
				  model.setSourceId(videoList.get(i).getSourceId());
				  model.setTitle(videoList.get(i).getTitle());
				  model.setSourceUrl(StringToArray(videoList.get(i).getVideoUrl())[0]);
				  model.setType(1);
				  modelList.add(model);
			}
			  for (int i = 0; i < appList.size(); i++) {
				  RandomAdsModel model = new RandomAdsModel();
				  model.setIcon(appList.get(i).getIcon());
				  model.setMakeFlows(new Float(appList.get(i).getMakeFlows()));
				  model.setSourceId(appList.get(i).getSourceId());
				  model.setTitle(appList.get(i).getTitle());
				  model.setSourceUrl(StringToArray(appList.get(i).getVideoUrl())[0]);
				  model.setType(2);
				  modelList.add(model);
			}
			  Collections.shuffle(modelList);
		}
		
		return modelList;
	}
/*
	public Object getAdsDetail(AppUser user, Integer type,Integer sourceId, AppVistorUser vistorUser) throws UnsupportedEncodingException {
		AppUserBill appUserBill = sourceService.checkBill(user, sourceId, type,vistorUser);
			if (type==null) {
				throw new SourceTypeException(null);
			}else if (type==1) {
//				List<DownLoadAdsModel> list = adsMap.get(userId+"_"+type);
//				if (ListUtil.isNotEmpty(list)) {
//					for (DownLoadAdsModel downLoadAdsModel : list) {
//						if ((sourceId+"").equals(downLoadAdsModel.getId())) {
//							return setAdsVO(downLoadAdsModel);
//						}
//					}
//				}
				
			 Map<String, Object> map = sourceService.getVideoDetail(sourceId);
			 
			 
			 
			 AdsVO  adsVO = new AdsVO();
			String description = map.get("description").toString();
			adsVO.setContent(string2Json(URLDecoder.decode(description == null ? "" : description, "utf-8")));
			adsVO.setCover(map.get("picture").toString());
			adsVO.setDuration(0L);
			
			adsVO.setFinishTime(0L);
			adsVO.setMakeFlows(Float.parseFloat(map.get("flowCoins").toString()));
			adsVO.setInstruction(string2Json(URLDecoder.decode(description == null ? "" : description, "utf-8")));
			
			if (appUserBill==null|| appUserBill.getStatus()==0) {
				adsVO.setIsFinished(0);
			}else {
				adsVO.setIsFinished(1);
			}
			adsVO.setPublishTime(map.get("createTime").toString());
			String title = map.get("title").toString();
			adsVO.setTitle(URLDecoder.decode(title == null ? "" : title, "utf-8"));
			adsVO.setVideoId(Integer.parseInt(map.get("id").toString()));
			adsVO.setVideoUrl(StringToArray(map.get("videoUrl").toString())[0]);
			adsVO.setVtimeEnd("");
			adsVO.setVtimeStart("");
			
			return adsVO;
				
			}else if (type==2) {
//				List<DownLoadAdsModel> list = adsMap.get(userId+"_"+type);
//				if (ListUtil.isNotEmpty(list)) {
//					for (DownLoadAdsModel downLoadAdsModel : list) {
//						if ((sourceId+"").equals(downLoadAdsModel.getId())) {
//							return setAdsVO(downLoadAdsModel);
//						}
//					}
//				}
				 Map<String, Object> map = sourceService.getAppDetail(sourceId);
				 
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
				if (appUserBill==null|| appUserBill.getStatus()==0) {
					softVO.setIsDownloadFinished(false);
				}else {
					softVO.setIsDownloadFinished(true);
				}
				softVO.setIsDownloadFinished(false);
				softVO.setIsShareFinished(false);
				softVO.setShareFinishTime(0L);
				return softVO;
			}else if(type==3){
//				List<DownLoadAdsModel> list = adsMap.get(userId+"_"+type);
//				if (ListUtil.isNotEmpty(list)) {
//					for (DownLoadAdsModel downLoadAdsModel : list) {
//						if ((sourceId+"").equals(downLoadAdsModel.getId())) {
//							return setAdsVO(downLoadAdsModel);
//						}
//					}
//				}
				throw new SourceTypeException(null);
			}else{
				throw new SourceTypeException(null);
			}
//		return null;
	}

	public List getAdsList(String userId, Integer type,Integer pageNo) {
		if (type==1) {
			if(pageNo==null|| pageNo<=1)
				pageNo=1;
				List<Map<String, Object>> list = sourceService.getVideoList("createTime", "desc", pageNo, Constant.PAGE_NUM,null);
				return getVideoList(list);
		}
		return null;
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
			modelList.add(model);
		}
		return modelList;
	}*/
	
	/**
	 * 随机获取广告视频
	 * @param userId
	 * @param type
	 * @param pageNo
	 * @return
	 */
	public List getAdsList2(String userId, Integer type,Integer pageNo) {
		if (type==1) {
			if(pageNo==null|| pageNo<=1)
				pageNo=1;
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("orderStr", "rand()");
				map.put("limitStr", "0,3");
				 List<AdVideoWithBLOBs> list = sourceService.getVideoList(map);
				return getVideoList2(list);
		}
		return null;
	}
	
	public List getAppsList2(String userId, Integer type,Integer pageNo) {
		List<RandomAdsModel> modelList = new ArrayList<RandomAdsModel>();
			if(pageNo==null|| pageNo<=1)
				pageNo=1;
			   Map<String,Object> map = new HashMap<String, Object>();
			   map.put("classid", -1);
			   map.put("categoryId", 1);
			   map.put("orderStr", "rand()");
			   map.put("limitStr", "0,2");
				List<AppInfoModel> list2 = sourceService.getAppList(map);
				for (int i = 0; i < list2.size(); i++) {
					RandomAdsModel model = new RandomAdsModel();
					model.setIcon(list2.get(i).getAppInfoWithBLOBs().getIconurl());
					model.setMakeFlows(new Float(list2.get(i).getAppInfoWithBLOBs().getFlowcoins()));
					model.setSourceId(list2.get(i).getAppInfoWithBLOBs().getRowid());
					model.setTitle(list2.get(i).getAppInfoWithBLOBs().getName());
					model.setType(2);
					modelList.add(model);
				}
				return modelList;
	}

	
	private List<RandomAdsModel> getVideoList2(List<AdVideoWithBLOBs> list){
		List<RandomAdsModel> modelList = new ArrayList<RandomAdsModel>();
		for (AdVideoWithBLOBs adVideoWithBLOBs : list) {
			RandomAdsModel model = new RandomAdsModel();
			model.setIcon(adVideoWithBLOBs.getPicture());
			model.setMakeFlows(new Float(adVideoWithBLOBs.getFlowcoins()));
			model.setSourceId(adVideoWithBLOBs.getId());
			model.setTitle(adVideoWithBLOBs.getTitle());
			model.setType(1);
			modelList.add(model);
		}
		return modelList;
	}
	
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

}
