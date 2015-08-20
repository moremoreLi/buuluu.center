package com.mobile.blue.buuluu.api.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.common.util.Constant;
import com.mobile.blue.buuluu.api.common.util.DateUtil;
import com.mobile.blue.buuluu.api.dao.SignDao;
import com.mobile.blue.buuluu.api.dao.mysql.SignDaoMysql;
import com.mobile.blue.buuluu.model.AppUserSign;

@Repository
public class SignDaoImpl extends Context implements SignDao{
	
	@Autowired
	private SignDaoMysql signDaoMysql;

	@Override
	public AppUserSign getSign(String userId) {
		return signDaoMysql.getByUserId(userId);
	}

	@Override
	public AppUserSign addSign(String userId) {
		AppUserSign appUserSign = new AppUserSign();
		appUserSign.setCreatedBy(Constant.CREATE_BY_API);
		appUserSign.setCreatedTime(DateUtil.getCurrentDate());
		appUserSign.setUserId(userId);
		appUserSign.setCredit(Constant.USER_SING_CREDIT);
		appUserSign.setExpireTime(DateUtil.addYears(new Date(), 1));
		return signDaoMysql.add(appUserSign);
	}

	@Override
	public List<String> getSignList(String userId) {
		return signDaoMysql.getSignList(userId);
	}
	
	
}
