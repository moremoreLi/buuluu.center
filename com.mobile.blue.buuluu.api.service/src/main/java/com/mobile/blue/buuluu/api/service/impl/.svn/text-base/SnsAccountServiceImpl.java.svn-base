package com.mobile.blue.buuluu.api.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.common.util.Constant;
import com.mobile.blue.buuluu.api.common.util.DateUtil;
import com.mobile.blue.buuluu.api.dao.AccountTypeDao;
import com.mobile.blue.buuluu.api.dao.SnsAccountDao;
import com.mobile.blue.buuluu.api.service.SnsAccountService;
import com.mobile.blue.buuluu.model.AppAccountType;
import com.mobile.blue.buuluu.model.AppSnsAccount;
import com.mobile.blue.buuluu.model.AppUser;

@Service
public class SnsAccountServiceImpl extends Context implements SnsAccountService {
	
	@Autowired
	private SnsAccountDao snsAccountDao;
	
	@Autowired
	private AccountTypeDao accountTypeDao;

	@Override
	public AppAccountType getById(Integer type) throws SQLException {
		return accountTypeDao.getById(type);
	}

	@Override
	public AppSnsAccount getSns(Integer type, String snsId) {
		return snsAccountDao.getSns(type, snsId);
	}

	@Override
	public AppSnsAccount addSns(AppUser user, Integer type, String snsId) throws SQLException {
		
		AppSnsAccount appSnsAccount =snsAccountDao.getSns(type, snsId);
		if (appSnsAccount==null) {
			
			appSnsAccount = new AppSnsAccount();
			appSnsAccount.setCreatedBy(Constant.CREATE_BY_API);
			appSnsAccount.setCreatedTime(DateUtil.getCurrentDate());
			appSnsAccount.setUserId(user.getId().toString());
			appSnsAccount.setAccountTypeId(type);
			appSnsAccount.setSnsId(snsId);
			appSnsAccount=snsAccountDao.addSns(appSnsAccount);
		}else {
			appSnsAccount.setUpdatedBy(Constant.UPDATE_BY_API);
			appSnsAccount.setUpdatedTime(DateUtil.getCurrentDate());
			appSnsAccount.setUserId(user.getId().toString());
			snsAccountDao.updateSns(appSnsAccount);
		}
		return appSnsAccount;
	}
	

}
