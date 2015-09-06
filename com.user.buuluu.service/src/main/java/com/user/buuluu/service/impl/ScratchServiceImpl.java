package com.user.buuluu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.buuluu.annotation.CacheKey;
import com.user.buuluu.annotation.Cacheable;
import com.user.buuluu.common.util.DateUtil;
import com.user.buuluu.dao.mapper.AppScratchMapper;
import com.user.buuluu.dao.mapper.AppUserScratchMapper;
import com.user.buuluu.model.AppBuuluuUser;
import com.user.buuluu.model.AppScratch;
import com.user.buuluu.model.AppUserScratch;
import com.user.buuluu.service.ScratchService;
import com.user.buuluu.service.model.AppUserScratchModel;
@Service("scratchService")
public class ScratchServiceImpl implements ScratchService{
	
	@Autowired
	private AppUserScratchMapper appUserScratchMapper;
	@Autowired 
	private AppScratchMapper appScratchMapper;

	@Override
	@Cacheable(table=AppUserScratch.class)
	public List<AppUserScratch> getUserScratch(@CacheKey String userId, Integer type) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("type", type);
		return appUserScratchMapper.getUserScratch(map);
	}
	@Override
	@Cacheable(table=AppUserScratch.class)
	public List<AppUserScratch> getScratchList(@CacheKey String cache) {
		return appUserScratchMapper.getScratchList();
	}
	@Override
	@Cacheable(table=AppUserScratch.class)
	public List<AppUserScratchModel> getScratchNews(int i,@CacheKey String cache) {
		return appUserScratchMapper.getScratchNews(i);
	}
	@Override
	@Cacheable(table=AppScratch.class)
	public AppScratch getScratchCoins(Integer scratchId,@CacheKey String cache) {
		return appScratchMapper.getScratchCoins(scratchId);
	}
	@Override
	@Cacheable(table=AppUserScratch.class)
	public int addUserScratch(AppBuuluuUser user, AppScratch appScratch,
			String string, int i, Float returnFloat,@CacheKey String cache) {
		AppUserScratch appUserScratch = new AppUserScratch();
		appUserScratch.setId(appScratch.getId());
		appUserScratch.setCreatedTime(new Date());
		appUserScratch.setCreatedTime(DateUtil.getCurrentDate());
//		appUserScratch.setDescription(appScratch.getDescription());
//		appUserScratch.setMakeFlows(user.getMakeFlow());
		appUserScratch.setLoginType(1);
		appUserScratch.setUserId(user.getId().toString());
		return appUserScratchMapper.insertSelective(appUserScratch);
	}

}
