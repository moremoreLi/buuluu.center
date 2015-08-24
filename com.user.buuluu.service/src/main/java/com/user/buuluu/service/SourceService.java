package com.user.buuluu.service;

import java.util.List;
import java.util.Map;

import com.user.buuluu.model.AdVideoWithBLOBs;

/**
 * 
 * @author More
 *2015-7-24
 *图片，app，视频，游戏资源服务器相关接口
 */
public interface SourceService {

	/*
	 * 根据排序 获取视频资源
	 */
//	List<Map<String, Object>> getVideoList(String order,String orderType,int pageNo,int limit,Integer type);

	List<AdVideoWithBLOBs> getVideoList(Map<String, Object> map);

	/*
	 * 根据排序 获取app下载
	 */
	List<Map<String, Object>> getAppList(Map<String, Object> map);
	
	/*Map<String, Object> getVideoDetail(int sourceId);

	List<Map<String, Object>> getAppList(Integer categoryid, Integer classid,
			String order, String orderType, Integer page,Integer type);

	
	 * 获取下载apk的具体信息 
	 
	Map<String, Object> getAppDetail(Integer sourceId);

	
	 * 获取资源的具体详情
	 
	Map<String, Object> getSource(Integer sourceId, Integer type);

	
	 * 保存用户账单资料
	 
	AppUserBill saveBill(AppUser user, Integer sourceId, Integer type,Map<String, Object> sourceObj, AppVistorUser vistorUser);

	
	 * 根据账单id获取账单详情
	 
	Map<String, Object> getCoinsDetail(Integer billingId);

	
	 * 根据账单id获取粗略的账单信息
	 
	AppUserBill getBillById(Integer billingId);

	
	 * 随机获取video i个视频
	 
	List<Map<String,Object>> getRandForVideo(int i);

	
	 * 随机获取app i个视频
	 
	List<Map<String, Object>> getRandForApp(int i);

	
	 * 添加用户使用账单的记录
	 
	AppUserBillLog addBillLog(AppUser user, Integer billingId, Float flowCoins,
			Float userCoin, String sourceName, AppUserBill appUserBill, AppVistorUser vistorUser);

	
	 *更新账单剩余的可使用的流量
	 
	boolean updateBillById(AppUserBill appUserBill, Float userCoin, String sourceName) throws SQLException;
	
	
	 * 检查账单是否存在
	 
	AppUserBill checkBill(AppUser user,Integer sourceId,Integer type, AppVistorUser vistorUser);

	
	 * 根据用户id获取用户使用流量包日志
	 
	List<AppUserBillLog> getBillLogByUserId(String userId);

	
	 * 根据用户id获取用户流量包
	 
	List<AppUserBill> getBillByUserId(String userId);

	
	 * 保存用户总的流量币的使用，保存账单
	 
	AppUserBillLog requestCoins(AppUser user, float f);

	
	 * 获取比较常用的视频
	 
	List<Map<String, Object>> getFarVideo(String userId);

	
	 * 获取比较常用的APK
	 
	List<Map<String, Object>> getFarApp(String userId);*/
	
}
