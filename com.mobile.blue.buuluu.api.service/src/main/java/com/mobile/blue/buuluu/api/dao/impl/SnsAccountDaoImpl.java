package com.mobile.blue.buuluu.api.dao.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.dao.SnsAccountDao;
import com.mobile.blue.buuluu.api.dao.mysql.SnsAccountDaoMysql;
import com.mobile.blue.buuluu.model.AppSnsAccount;

@Repository
public class SnsAccountDaoImpl extends Context implements SnsAccountDao{
	

	@Autowired
	private SnsAccountDaoMysql snsAccountDaoMysql;

	@Override
	public AppSnsAccount getSns(Integer type, String snsId) {
		return snsAccountDaoMysql.getSns(type,snsId);
	}

	@Override
	public AppSnsAccount addSns(AppSnsAccount appSnsAccount) {
		return snsAccountDaoMysql.add(appSnsAccount);
	}

	@Override
	public boolean  updateSns(AppSnsAccount appSnsAccount) throws SQLException {
		return snsAccountDaoMysql.update(appSnsAccount);
	}
	
}
