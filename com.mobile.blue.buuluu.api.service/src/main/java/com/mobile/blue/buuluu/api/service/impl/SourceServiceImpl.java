package com.mobile.blue.buuluu.api.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.common.exception.BaseAPIException;
import com.mobile.blue.buuluu.api.common.exception.BillExistException;
import com.mobile.blue.buuluu.api.common.jdbc.ListUtil;
import com.mobile.blue.buuluu.api.common.util.Constant;
import com.mobile.blue.buuluu.api.common.util.DateUtil;
import com.mobile.blue.buuluu.api.dao.SourceDao;
import com.mobile.blue.buuluu.api.dao.UserBillDao;
import com.mobile.blue.buuluu.api.dao.UserBillLogDao;
import com.mobile.blue.buuluu.api.service.SourceService;
import com.mobile.blue.buuluu.model.AppUser;
import com.mobile.blue.buuluu.model.AppUserBill;
import com.mobile.blue.buuluu.model.AppUserBillLog;
import com.mobile.blue.buuluu.model.AppVistorUser;

@Service
public class SourceServiceImpl  extends Context implements SourceService{
	
	@Autowired
	private SourceDao sourceDao;
	
	@Autowired
	private UserBillDao userBillDao;
	
	@Autowired
	private UserBillLogDao userBillLogDao;

	@Override
	public List<Map<String, Object>> getVideoList(String order,String orderType, int pageNo, int limit,Integer type) {
		return sourceDao.getVideoList(order, orderType, pageNo, limit,type);
	}

	@Override
	public Map<String, Object> getVideoDetail(int sourceId) {
		return sourceDao.getVideoDetail(sourceId);
	}
	
	@Override
	 public List<Map<String, Object>> getAppList(Integer categoryid, Integer classid,
			String order, String orderType, Integer page,Integer type){
		return sourceDao.getAppList(categoryid, classid, order, orderType, page,type);
	}

	@Override
	public Map<String, Object> getAppDetail(Integer sourceId) {
		return sourceDao.getAppDetail(sourceId);
	}

	@Override
	public Map<String, Object> getSource(Integer sourceId, Integer type) {
		Map<String, Object> map = null;
		if (type==1) {
			map = getVideoDetail(sourceId);
		}else if (type==2) {
			map = getAppDetail(sourceId);
		}else if (type==3) {
			
		}else {
			throw new BaseAPIException();
		}
		return map;
	}

	@Override
	public AppUserBill saveBill(AppUser user, Integer sourceId, Integer type,Map<String, Object> sourceObj, AppVistorUser vistorUser) {
		
		List<AppUserBill> userBillList =userBillDao.checkBill(user,sourceId,type,vistorUser);
		
		if (ListUtil.isNotEmpty(userBillList)) {
			if (userBillList.get(0).getStatus()==1) {
				throw new BillExistException(null);
			}else {
				return userBillList.get(0);
			}
		}
			
		
		return userBillDao.saveBill(user,sourceId,type,sourceObj,vistorUser);
	}

	@Override
	public Map<String,Object> getCoinsDetail(Integer billingId) {
		return userBillDao.getCoinsDetail(billingId);
	}

	@Override
	public AppUserBill getBillById(Integer billingId) {
		return userBillDao.getBillById(billingId);
	}

	@Override
	public List<Map<String, Object>> getRandForVideo(int i) {
		return sourceDao.getRandForVideo( i);
	}

	@Override
	public List<Map<String, Object>> getRandForApp(int i) {
		return sourceDao.getRandForApp( i);
	}

	@Override
	public AppUserBillLog addBillLog(AppUser user, Integer billingId,Float flowCoins, Float userCoin, String sourceName, AppUserBill appUserBill, AppVistorUser vistorUser) {
		AppUserBillLog appUserBillLog = new AppUserBillLog();
		appUserBillLog.setBillId(billingId);
		appUserBillLog.setCreatedBy(Constant.CREATE_BY_API);
		appUserBillLog.setCreatedTime(DateUtil.getCurrentDate());
		appUserBillLog.setFlowCoins(flowCoins);
		appUserBillLog.setUserCoin(userCoin);
		String userId = "";
		if (user==null) {
			userId = vistorUser.getId().toString();
		}else {
			userId =user.getId().toString();
		}
		appUserBillLog.setUserId(userId);
		if (appUserBill.getType()==1) {
			appUserBillLog.setDescription("观看了"+(sourceName==null?"":sourceName)+",使用了"+userCoin+"流量充值");
		}else {
			appUserBillLog.setDescription("下载了"+(sourceName==null?"":sourceName)+",使用了"+userCoin+"流量充值");
		}
		
		return  userBillLogDao.addBillLog(appUserBillLog);
	}

	@Override
	public boolean updateBillById(AppUserBill appUserBill, Float flowCoins, String sourceName) throws SQLException {
		appUserBill.setUpdatedBy(Constant.UPDATE_BY_API);
		appUserBill.setUpdatedTime(DateUtil.getCurrentDate());
		if (appUserBill.getStatus()==0) {
			if (appUserBill.getType()==1) {
				appUserBill.setDescription("观看了"+(sourceName==null?"":sourceName)+"赠送了"+appUserBill.getFlowCoins()+"流量礼包");
			}else {
				appUserBill.setDescription("下载了"+(sourceName==null?"":sourceName)+"赠送了"+appUserBill.getFlowCoins()+"流量礼包");
			}
		}
		appUserBill.setStatus(1);
		appUserBill.setFlowCoins(flowCoins);
		return userBillDao.updateBillById(appUserBill);
	}

	@Override
	public AppUserBill checkBill(AppUser user, Integer sourceId,
			Integer type, AppVistorUser vistorUser) {
        List<AppUserBill> userBillList =userBillDao.checkBill(user,sourceId,type,vistorUser);
		
		if (ListUtil.isNotEmpty(userBillList)) {
				return userBillList.get(0);
		}
		return null;
	}

	@Override
	public List<AppUserBillLog> getBillLogByUserId(String userId) {
		
		return userBillLogDao.getBillLogByUserId(userId);
	}

	@Override
	public List<AppUserBill> getBillByUserId(String userId) {
		return userBillDao.getBillByUserId(userId);
	}

	@Override
	public AppUserBillLog requestCoins(AppUser user, float f) {
		AppUserBillLog appUserBillLog = new AppUserBillLog();
		appUserBillLog.setBillId(null);
		appUserBillLog.setCreatedBy(Constant.CREATE_BY_API);
		appUserBillLog.setCreatedTime(DateUtil.getCurrentDate());
		appUserBillLog.setFlowCoins(user.getFlowCoins()-f);
		appUserBillLog.setUserCoin(f);
		appUserBillLog.setDescription("由于流量偏低，系统自动购买"+f+"M流量");
		appUserBillLog.setUserId(user.getId().toString());
		return userBillLogDao.addBillLog(appUserBillLog);
	}

	@Override
	public List<Map<String, Object>> getFarVideo(String userId) {
		return sourceDao.getFarVideo(userId);
	}

	@Override
	public List<Map<String, Object>> getFarApp(String userId) {
		return sourceDao.getFarApp(userId);
	}
	
}
