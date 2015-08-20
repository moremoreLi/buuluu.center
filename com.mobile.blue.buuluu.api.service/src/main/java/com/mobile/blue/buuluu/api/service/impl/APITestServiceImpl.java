package com.mobile.blue.buuluu.api.service.impl;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.dao.APITestDao;
import com.mobile.blue.buuluu.api.service.APITestService;
import com.mobile.blue.buuluu.model.AppApiTest;

/**
 * 
 * @author kelvin.tie
 */
@Service
public class APITestServiceImpl extends Context implements APITestService {

	@Autowired
	private APITestDao apiTestDao;

	@Override
	public boolean add(String name) throws SQLException {

		AppApiTest test = new AppApiTest();
		test.setCreatedBy("TEST create");
		test.setCreatedTime(new Date());
		test.setIsDeleted(false);
		test.setName(name);

		return apiTestDao.add(test);
	}

	@Override
	public AppApiTest get(long id) throws SQLException {
		return apiTestDao.get(id);
	}

	@Override
	public boolean del(Long id) throws SQLException {
		
		return apiTestDao.del(id);
	}

	@Override
	public boolean delData(Long id) throws SQLException {
		
		return apiTestDao.delData(id);
	}
}
