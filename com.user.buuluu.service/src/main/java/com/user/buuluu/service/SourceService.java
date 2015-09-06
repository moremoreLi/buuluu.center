package com.user.buuluu.service;

import java.util.List;
import java.util.Map;

import com.user.buuluu.dao.model.AppInfoAllRowModel;
import com.user.buuluu.dao.model.AppInfoModel;
import com.user.buuluu.dao.model.AppRandModel;
import com.user.buuluu.dao.model.AppVideoAllRow;
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
	List<AppInfoModel> getAppList(Map<String, Object> map,String cache);
	 AppInfoWithBLOBs getAppDetail(Integer sourceId,String cache);
	int saveBill(AppUserBill appUserBill,String cache);
	/* * 根据账单id获取账单详情*/
//	Map<String, Object> getCoinsDetail(Integer billingId);
	/* * 根据账单id获取粗略的账单信息*/
	AppUserBill getBillById(Long billingId);
	 /** 随机获取video i个视频*/
	List<AppRandModel> getRandForVideo(int i,String cache);
	/* * 随机获取app i个视频*/
	List<AppRandModel> getRandForApp(int i,String cache);
	 /** 添加用户使用账单的记录*/
	int addBillLog(AppUserBillLog appUserBillLog,String cache);
	/* *更新账单剩余的可使用的流量*/
	boolean updateBillById(AppUserBill appUserBill, Integer key);
	/* * 检查账单是否存在*/
	AppUserBill checkBill(Map<String,Object> map,String key);
	AdVideoWithBLOBs getVideoDetail(Integer sourceId,String cache);
	 /** 根据用户id获取用户使用流量包日志*/
	List<AppUserBillLog> getBillLogByUserId(String userId);
	 /** 根据用户id获取用户流量包*/
	List<AppUserBill> getBillByUserId(String userId);
	int requestCoins(AppBuuluuUser user, float f,String cache);
	List<AppVideoAllRow> getFarVideo(String userId);
	List<AppInfoAllRowModel> getFarApp(String userId);
	List<AdVideoWithBLOBs> getVideoList(Map<String, Object> map, String userid);
}
