package com.mobile.blue.buuluu.api.service;

import java.util.List;
import java.util.Map;

import com.mobile.blue.buuluu.api.model.AppUserScratchModel;
import com.mobile.blue.buuluu.model.AppScratch;
import com.mobile.blue.buuluu.model.AppUser;
import com.mobile.blue.buuluu.model.AppUserScratch;


/**
 * 
 * @author More
 *2015-7-27
 * 用户刮刮卡记录相关接口
 */
public interface ScratchService {

	/*
	 * 获取刮刮卡信息
	 */
	List<Map<String, Object>> getScratchList();

	/*
	 * 更加刮刮卡id获取刮刮卡信息
	 */
	AppScratch getScratchCoins(Integer scratchId);

	/*
	 * 添加刮刮卡流量币使用情况 
	 */
	AppUserScratch addUserScratch(AppUser user, AppScratch appScratch,String description,int type,float makeFlows);

	/*
	 * 根据userId获取刮刮卡消耗和得奖情况
	 */
	List<AppUserScratch> getUserScratch(String userId, Integer type);

	/*
	 * 获取i个刮刮卡得奖的信息
	 */
	List<AppUserScratchModel> getScratchNews(int i);

}
