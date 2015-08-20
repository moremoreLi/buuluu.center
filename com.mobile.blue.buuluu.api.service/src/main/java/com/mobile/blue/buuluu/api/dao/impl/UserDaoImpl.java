package com.mobile.blue.buuluu.api.dao.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.dao.UserDao;
import com.mobile.blue.buuluu.api.dao.mysql.UserDaoMysql;
import com.mobile.blue.buuluu.model.AppUser;

@Repository
public class UserDaoImpl extends Context implements UserDao{
	
	@Autowired
	private UserDaoMysql userDaoMysql;

	@Override
	public AppUser getByTel(String countryCode, String tel) {
		return userDaoMysql.getByTel(countryCode,tel);
	}

	@Override
	public AppUser save(AppUser user) {
		return userDaoMysql.addPKObject(user);
	}

	@Override
	public AppUser getUserById(String userId) {
		return userDaoMysql.getUserById(userId);
	}

	@Override
	public boolean upate(AppUser user) throws SQLException {
		return userDaoMysql.update(user);
	}

	
}
