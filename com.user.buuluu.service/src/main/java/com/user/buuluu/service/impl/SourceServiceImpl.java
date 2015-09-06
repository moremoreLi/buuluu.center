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
import com.user.buuluu.common.util.Constant;
import com.user.buuluu.common.util.DateUtil;
import com.user.buuluu.dao.mapper.AdVideoMapper;
import com.user.buuluu.dao.mapper.AppInfoMapper;
import com.user.buuluu.dao.mapper.AppUserBillLogMapper;
import com.user.buuluu.dao.mapper.AppUserBillMapper;
import com.user.buuluu.dao.model.AppInfoAllRowModel;
import com.user.buuluu.dao.model.AppInfoModel;
import com.user.buuluu.dao.model.AppRandModel;
import com.user.buuluu.dao.model.AppVideoAllRow;
import com.user.buuluu.model.AdVideoWithBLOBs;
import com.user.buuluu.model.AppBuuluuUser;
import com.user.buuluu.model.AppInfoWithBLOBs;
import com.user.buuluu.model.AppUserBill;
import com.user.buuluu.model.AppUserBillLog;
import com.user.buuluu.service.SourceService;

@Service("sourceService")
public class SourceServiceImpl implements SourceService{
	
	@Autowired
	private AdVideoMapper adVideoMapper;
	
	@Autowired
	private AppInfoMapper appInfoMapper;
	
	@Autowired
	private AppUserBillMapper appUserBillMapper;
	
	@Autowired
	private AppUserBillLogMapper appUserBillLogMapper;

	@Override
	@Cacheable(table=AdVideoWithBLOBs.class,type=TypeMode.HASH) 
	public List<AdVideoWithBLOBs> getVideoList(Map<String, Object> map,@CacheKey String userid) {
		return adVideoMapper.getVideoList(map);
	}

	@Override
	@Cacheable(table=AppInfoModel.class,type=TypeMode.HASH) 
	public List<AppInfoModel> getAppList(Map<String, Object> map,@CacheKey String cache) {
		return appInfoMapper.getAppList(map);
	}

	@Override
	@Cacheable(table=AppRandModel.class,type=TypeMode.HASH) 
	public List<AppRandModel> getRandForVideo(int i,@CacheKey String cache) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("limitStr", 0+","+i);
		return adVideoMapper.getRandForVideo(map);
	}

	@Override
	@Cacheable(table=AppRandModel.class,type=TypeMode.HASH) 
	public List<AppRandModel> getRandForApp(int i,@CacheKey String cache) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("limitStr", 0+","+i);
		return appInfoMapper.getRandForApp(map);
	}

	@Override
	@Cacheable(table=AppUserBill.class,type=TypeMode.HASH)
	public AppUserBill checkBill(Map<String,Object> map,@CacheKey String key){
		return appUserBillMapper.checkBill(map);
	}

	@Override
	@Cacheable(table=AppUserBill.class,type=TypeMode.HASH)
	public AdVideoWithBLOBs getVideoDetail(Integer sourceId,@CacheKey String cache) {
		return adVideoMapper.selectByPrimaryKey(sourceId);
	}

	@Override
	@Cacheable(table=AppInfoWithBLOBs.class,type=TypeMode.HASH)
	public AppInfoWithBLOBs getAppDetail(Integer sourceId,@CacheKey String cache) {
		return appInfoMapper.selectByPrimaryKey(sourceId);
	}

	@Override
	@Cacheable(table=AppUserBill.class,type=TypeMode.HASH)
	public int saveBill(AppUserBill appUserBill,@CacheKey String cache) {
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
	@Cacheable(table=AppUserBillLog.class,type=TypeMode.HASH)
	public int addBillLog(AppUserBillLog appUserBillLog ,@CacheKey String cache) {
		return appUserBillLogMapper.insert(appUserBillLog);
	}

	@Override
	@Cacheable(table=AppUserBillLog.class,type=TypeMode.HASH)
	public List<AppUserBillLog> getBillLogByUserId(@CacheKey String userId) {
		return appUserBillLogMapper.getBillLogByUserId(userId);
	}

	@Override
	@Cacheable(table=AppUserBill.class,type=TypeMode.HASH)
	public List<AppUserBill> getBillByUserId(@CacheKey  String userId) {
		return appUserBillMapper.getBillByUserId(userId);
	}

	@Override
	@Cacheable(table=AppUserBillLog.class,type=TypeMode.HASH)
	public int requestCoins(AppBuuluuUser user, float f,@CacheKey String cache) {
		AppUserBillLog appUserBillLog = new AppUserBillLog();
		appUserBillLog.setBillId(null);
		appUserBillLog.setCreatedBy(Constant.CREATE_BY_API);
		appUserBillLog.setCreatedTime(DateUtil.getCurrentDate());
//		appUserBillLog.setFlowCoins(user.getFlowCoins()-f);
		appUserBillLog.setUserCoin(Float.floatToIntBits(f));
		appUserBillLog.setDescription("由于流量偏低，系统自动购买"+f+"M流量");
		appUserBillLog.setUserId(user.getId().toString());
//		appUserBillLogMapper.addBillLog(appUserBillLog,Constant.API1_LINK_IMAGE_PATH);
		return appUserBillLogMapper.insertSelective(appUserBillLog);
	}

	@Override
	@Cacheable(table=AppVideoAllRow.class,type=TypeMode.HASH)
	public List<AppVideoAllRow> getFarVideo(@CacheKey String userId) {
		return adVideoMapper.getFarVideo(userId);
	}

	@Override
	@Cacheable(table=AppInfoAllRowModel.class,type=TypeMode.HASH)
	public List<AppInfoAllRowModel> getFarApp(@CacheKey String userId) {
		return appInfoMapper.getFarApp(userId);
	}

}
