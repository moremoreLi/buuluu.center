package com.mobile.blue.buuluu.api.dao.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.dao.APITestDao;
import com.mobile.blue.buuluu.api.dao.mysql.APITestDaoMysql;
import com.mobile.blue.buuluu.model.AppApiTest;

/**
 * 
 * @author kelvin.tie
 */
@Repository
public class APITestDaoImpl extends Context implements APITestDao {

	@Autowired
	private APITestDaoMysql apiTestDaoMysql;
	

	@Override
	public boolean add(AppApiTest test) {

		test = apiTestDaoMysql.add(test);
		
		return true;
	}

	@Override
	public AppApiTest get(Long id) throws SQLException {

		AppApiTest test= apiTestDaoMysql.get(id);
		
		return test;
	}

	@Override
	public boolean del(Long id) throws SQLException {
		
		boolean del = apiTestDaoMysql.del(id);
		
		return del;
	}

	@Override
	public boolean delData(Long id) throws SQLException {
		boolean del = apiTestDaoMysql.delData(id);
		return del;
	}

	@Override
	public boolean update(AppApiTest test) throws SQLException {
		boolean update = apiTestDaoMysql.update(test);
		return update;
	}

}
