package com.mobile.blue.buuluu.api.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.dao.UserScratchDao;
import com.mobile.blue.buuluu.api.dao.mysql.UserScratchDaoMysql;
import com.mobile.blue.buuluu.api.model.AppUserScratchModel;
import com.mobile.blue.buuluu.model.AppUserScratch;

@Repository
public class UserScratchDaoImpl extends Context implements UserScratchDao{
	
	@Autowired
	private UserScratchDaoMysql userScratchDaoMysql;

	@Override
	public AppUserScratch addUserScratch(AppUserScratch appUserScratch) {
		return userScratchDaoMysql.add(appUserScratch);
	}

	@Override
	public List<AppUserScratch> getUserScratch(String userId, Integer type) {
		return userScratchDaoMysql.getUserScratch(userId,type);
	}

	@Override
	public List<AppUserScratchModel> getScratchNews(int i) {
		return userScratchDaoMysql.getScratchNews(i);
	}
	
	
}
