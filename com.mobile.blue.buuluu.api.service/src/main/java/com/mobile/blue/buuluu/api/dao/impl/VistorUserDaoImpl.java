package com.mobile.blue.buuluu.api.dao.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.dao.VistorUserDao;
import com.mobile.blue.buuluu.api.dao.mysql.VistorUserDaoMysql;
import com.mobile.blue.buuluu.model.AppVistorUser;

@Repository
public class VistorUserDaoImpl extends Context implements VistorUserDao{
	
	@Autowired
	private VistorUserDaoMysql  vistorUserDaoMysql;

	@Override
	public AppVistorUser add(AppVistorUser user) {
		return vistorUserDaoMysql.addPKObject(user);
	}

	@Override
	public boolean delete(AppVistorUser user) throws SQLException {
		return vistorUserDaoMysql.del(user.getId());
	}

	@Override
	public AppVistorUser getUserById(String userId) throws SQLException {
		return vistorUserDaoMysql.get(userId);
	}

	@Override
	public boolean update(AppVistorUser vistorUser) throws SQLException {
		return vistorUserDaoMysql.update(vistorUser);
	}
	
}
