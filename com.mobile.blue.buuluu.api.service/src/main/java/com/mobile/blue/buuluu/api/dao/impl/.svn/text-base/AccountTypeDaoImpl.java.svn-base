package com.mobile.blue.buuluu.api.dao.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.dao.AccountTypeDao;
import com.mobile.blue.buuluu.api.dao.mysql.AccountTypeDaoMysql;
import com.mobile.blue.buuluu.model.AppAccountType;

@Repository
public class AccountTypeDaoImpl extends Context implements AccountTypeDao{
	

	@Autowired
	private AccountTypeDaoMysql accountTypeDaoMysql;

	@Override
	public AppAccountType getById(Integer type) throws SQLException {
		return accountTypeDaoMysql.get(type);
	}

}
