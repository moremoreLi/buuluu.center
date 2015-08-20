package com.mobile.blue.buuluu.api.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.common.util.Constant;
import com.mobile.blue.buuluu.api.common.util.DateUtil;
import com.mobile.blue.buuluu.api.dao.UserBillDao;
import com.mobile.blue.buuluu.api.dao.mysql.UserBillDaoMysql;
import com.mobile.blue.buuluu.model.AppUser;
import com.mobile.blue.buuluu.model.AppUserBill;
import com.mobile.blue.buuluu.model.AppVistorUser;

@Repository
public class UserBillDaoImpl extends Context implements UserBillDao{
	
	@Autowired
	private UserBillDaoMysql userBillDaoMysql;

	@Override
	public AppUserBill saveBill(AppUser user, Integer sourceId, Integer type,Map<String, Object> sourceObj, AppVistorUser vistorUser) {
		AppUserBill appUserBill = new AppUserBill();
		appUserBill.setCreatedBy(Constant.CREATE_BY_API);
		appUserBill.setCreatedTime(DateUtil.getCurrentDate());
		String userId = "";
		if (user==null) {
			userId = vistorUser.getId().toString();
		}else {
			userId =user.getId().toString();
		}
		appUserBill.setUserId(userId);
		appUserBill.setSourceId(sourceId);
		float flowCoins = Float.parseFloat(sourceObj.get("flowCoins").toString());
		appUserBill.setRewardCoins(flowCoins);
		appUserBill.setExpireTime(DateUtil.addYears(new Date(), 3));
		appUserBill.setType(type);
		appUserBill.setStatus(0);
		if (type==1) {
			appUserBill.setDescription("正在观看'"+sourceObj.get("title").toString()+"'，未完成");
		}else if (type==2) {
			appUserBill.setDescription("正在下载'"+sourceObj.get("name").toString()+"'，未完成");
		}else{
			appUserBill.setDescription("正在进行中，未完成");
		}
		appUserBill.setFlowCoins(flowCoins);
		
		return userBillDaoMysql.add(appUserBill);
	}

	@Override
	public List<AppUserBill> checkBill(AppUser user, Integer sourceId,
			Integer type, AppVistorUser vistorUser) {
		return userBillDaoMysql.checkBill(user,sourceId,type, vistorUser);
	}

	@Override
	public Map<String, Object> getCoinsDetail(Integer billingId) {
		return userBillDaoMysql.getCoinsDetail(billingId);
	}

	@Override
	public AppUserBill getBillById(Integer billingId) {
		return userBillDaoMysql.getBillById(billingId);
	}

	@Override
	public boolean updateBillById(AppUserBill appUserBill) throws SQLException {
		return userBillDaoMysql.update(appUserBill);
	}

	@Override
	public List<AppUserBill> getBillByUserId(String userId) {
		return userBillDaoMysql.getBillByUserId(userId);
	}
	
}
