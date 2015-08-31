package com.user.buuluu.service;

import java.util.List;
import java.util.Map;

import com.user.buuluu.dao.model.AppInfoModel;
import com.user.buuluu.dao.model.AppRandModel;
import com.user.buuluu.model.AdVideoWithBLOBs;
import com.user.buuluu.model.AppBuuluuUser;
import com.user.buuluu.model.AppInfoWithBLOBs;
import com.user.buuluu.model.AppUserBill;
import com.user.buuluu.model.AppUserBillLog;

/**
 * 
 * @author More
 *2015-7-24
 *图片，app，视频，游戏资源服务器相关接口
 */
public interface SourceService {


	List<AdVideoWithBLOBs> getVideoList(Map<String, Object> map);

	/*
	 * 根据排序 获取app下载
	 */
	List<AppInfoModel> getAppList(Map<String, Object> map);
	

	
	 /** 获取下载apk的具体信息 */
	 
	 AppInfoWithBLOBs getAppDetail(Integer sourceId);

	
	/* * 获取资源的具体详情*/
	 
//	Map<String, Object> getSource(Integer sourceId, Integer type);

	
	/* * 保存用户账单资料*/
	 
	int saveBill(AppUserBill appUserBill);

	
	/* * 根据账单id获取账单详情*/
	 
//	Map<String, Object> getCoinsDetail(Integer billingId);

	
	/* * 根据账单id获取粗略的账单信息*/
	 
	AppUserBill getBillById(Long billingId);

	
	 /** 随机获取video i个视频*/
	 
	List<AppRandModel> getRandForVideo(int i);

	
	/* * 随机获取app i个视频*/
	 
	List<AppRandModel> getRandForApp(int i);

	
	 /** 添加用户使用账单的记录*/
	 
	int addBillLog(AppUserBillLog appUserBillLog);

	
	/* *更新账单剩余的可使用的流量*/
	 
	boolean updateBillById(AppUserBill appUserBill, Integer key);
	
	
	/* * 检查账单是否存在*/
	 
	AppUserBill checkBill(Map<String,Object> map,String key);

	/**
	 * 获取视频详情
	 * @param sourceId
	 * @return
	 */
	AdVideoWithBLOBs getVideoDetail(Integer sourceId);

	
	 /** 根据用户id获取用户使用流量包日志*/
	 
	List<AppUserBillLog> getBillLogByUserId(String userId);

	
	 /** 根据用户id获取用户流量包*/
	 
	List<AppUserBill> getBillByUserId(String userId);

	
	/* * 保存用户总的流量币的使用，保存账单*/
	 
	AppUserBillLog requestCoins(AppBuuluuUser user, float f);

	
	 /** 获取比较常用的视频*/
	 
//	List<Map<String, Object>> getFarVideo(String userId);

	
	/* * 获取比较常用的APK*/
	 
//	List<Map<String, Object>> getFarApp(String userId);
	
}
