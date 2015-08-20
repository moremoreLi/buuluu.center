package com.mobile.blue.buuluu.api.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.dao.UserBillLogDao;
import com.mobile.blue.buuluu.api.dao.mysql.UserBillLogDaoMysql;
import com.mobile.blue.buuluu.model.AppUserBillLog;

@Repository
public class UserBillLogDaoImpl extends Context implements UserBillLogDao{
	
	@Autowired
	private UserBillLogDaoMysql  userBillLogDaoMysql;

	@Override
	public AppUserBillLog addBillLog(AppUserBillLog appUserBillLog) {
		return userBillLogDaoMysql.add(appUserBillLog);
	}

	@Override
	public List<AppUserBillLog> getBillLogByUserId(String userId) {
		return userBillLogDaoMysql.getBillLogByUserId(userId);
	}
	
	
}
