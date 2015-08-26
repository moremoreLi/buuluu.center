package com.user.buuluu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.buuluu.annotation.CacheDel;
import com.user.buuluu.annotation.CacheKey;
import com.user.buuluu.annotation.Cacheable;
import com.user.buuluu.annotation.Cacheable.TypeMode;
import com.user.buuluu.common.Context;
import com.user.buuluu.dao.mapper.AdVideoMapper;
import com.user.buuluu.dao.mapper.AppInfoMapper;
import com.user.buuluu.dao.mapper.AppUserBillLogMapper;
import com.user.buuluu.dao.mapper.AppUserBillMapper;
import com.user.buuluu.dao.model.AppInfoModel;
import com.user.buuluu.dao.model.AppRandModel;
import com.user.buuluu.model.AdVideoWithBLOBs;
import com.user.buuluu.model.AppInfoWithBLOBs;
import com.user.buuluu.model.AppUserBill;
import com.user.buuluu.model.AppUserBillLog;
import com.user.buuluu.service.SourceService;

@Service("sourceService")
public class SourceServiceImpl  extends Context implements SourceService{
	
	@Autowired
	private AdVideoMapper adVideoMapper;
	
	@Autowired
	private AppInfoMapper appInfoMapper;
	
	@Autowired
	private AppUserBillMapper appUserBillMapper;
	
	@Autowired
	private AppUserBillLogMapper appUserBillLogMapper;

	@Override
	public List<AdVideoWithBLOBs> getVideoList(Map<String, Object> map) {
		return adVideoMapper.getVideoList(map);
	}

	@Override
	public List<AppInfoModel> getAppList(Map<String, Object> map) {
		return appInfoMapper.getAppList(map);
	}

	@Override
	public List<AppRandModel> getRandForVideo(int i) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("limitStr", 0+","+i);
		return adVideoMapper.getRandForVideo(map);
	}

	@Override
	public List<AppRandModel> getRandForApp(int i) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("limitStr", 0+","+i);
		return appInfoMapper.getRandForApp(map);
	}

	@Override
	@Cacheable(table=AppUserBill.class,type=TypeMode.HASH)
	public AppUserBill checkBill(Map<String,Object> map, String key){
		return appUserBillMapper.checkBill(map);
	}

	@Override
	public AdVideoWithBLOBs getVideoDetail(Integer sourceId) {
		return adVideoMapper.selectByPrimaryKey(sourceId);
	}

	@Override
	public AppInfoWithBLOBs getAppDetail(Integer sourceId) {
		return appInfoMapper.selectByPrimaryKey(sourceId);
	}

	@Override
	public int saveBill(AppUserBill appUserBill) {
		return appUserBillMapper.insert(appUserBill);
	}

	@Override
	@Cacheable(table=AppUserBill.class)
	public AppUserBill getBillById(@Param("id") @CacheKey Long billingId) {
		return appUserBillMapper.selectByPrimaryKey(billingId);
	}

	@Override
	@CacheDel(table=AppUserBill.class)
	public boolean updateBillById( AppUserBill appUserBill,@CacheKey Integer key) {
		return appUserBillMapper.updateBillById(appUserBill)>0?true:false;
	}

	@Override
	public int addBillLog(AppUserBillLog appUserBillLog ) {
		return appUserBillLogMapper.insert(appUserBillLog);
	}

}
