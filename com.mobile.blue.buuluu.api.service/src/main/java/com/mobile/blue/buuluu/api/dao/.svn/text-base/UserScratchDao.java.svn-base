package com.mobile.blue.buuluu.api.dao;

import java.util.List;

import com.mobile.blue.buuluu.api.model.AppUserScratchModel;
import com.mobile.blue.buuluu.model.AppUserScratch;


/**
 * 
 * @author More
 *2015-7-30
 *用户刮刮卡轻卡
 */
public interface UserScratchDao {

	/*
	 * 用户使用流量币轻卡
	 */
	AppUserScratch addUserScratch(AppUserScratch appUserScratch);

	/*
	 * 根据用户userID获取使用刮刮卡消耗和得奖情况
	 */
	List<AppUserScratch> getUserScratch(String userId, Integer type);

	/*
	 * 获取i个刮刮卡得奖的人员信息
	 */
	List<AppUserScratchModel> getScratchNews(int i);

}
