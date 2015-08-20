package com.mobile.blue.buuluu.api.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.common.util.Constant;
import com.mobile.blue.buuluu.api.common.util.DateUtil;
import com.mobile.blue.buuluu.api.dao.ScratchDao;
import com.mobile.blue.buuluu.api.dao.UserScratchDao;
import com.mobile.blue.buuluu.api.model.AppUserScratchModel;
import com.mobile.blue.buuluu.api.service.ScratchService;
import com.mobile.blue.buuluu.model.AppScratch;
import com.mobile.blue.buuluu.model.AppUser;
import com.mobile.blue.buuluu.model.AppUserScratch;

@Service
public class ScratchServiceImpl extends Context implements ScratchService {
	
	@Autowired
	private ScratchDao scratchDao;
	
	@Autowired
	private UserScratchDao userScratchDao;

	@Override
	public List<Map<String, Object>> getScratchList() {
		return scratchDao.getScratchList();
	}

	@Override
	public AppScratch getScratchCoins(Integer scratchId) {
		return scratchDao.getScratchCoins(scratchId);
	}

	@Override
	public AppUserScratch addUserScratch(AppUser user, AppScratch appScratch,String description,int type,float makeFlows) {
		AppUserScratch appUserScratch = new AppUserScratch();
		appUserScratch.setAppScratchId(Integer.parseInt(appScratch.getId().toString()));
		appUserScratch.setCreatedBy(Constant.CREATE_BY_API);
		appUserScratch.setCreatedTime(DateUtil.getCurrentDate());
		appUserScratch.setDescription(description);
		appUserScratch.setMakeFlows(makeFlows);
		appUserScratch.setType(type);
		appUserScratch.setUserId(user.getId().toString());
		return userScratchDao.addUserScratch(appUserScratch);
	}

	@Override
	public List<AppUserScratch> getUserScratch(String userId, Integer type) {
		return userScratchDao.getUserScratch(userId,type);
	}

	@Override
	public List<AppUserScratchModel> getScratchNews(int i) {
		return userScratchDao.getScratchNews(i);
	}
	

}
