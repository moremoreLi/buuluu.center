package com.mobile.blue.buuluu.api.service;

import java.sql.SQLException;

import com.mobile.blue.buuluu.model.AppApiTest;

/**
 * 
 * @author kelvin.tie
 */
public interface APITestService {

	public boolean add(String Name) throws SQLException;

	public AppApiTest get(long id) throws SQLException;
	
	public boolean del(Long id) throws SQLException;
	
	public boolean delData(Long id) throws SQLException;

}
