package com.mobile.blue.buuluu.api.dao;

import java.sql.SQLException;

import com.mobile.blue.buuluu.model.AppApiTest;


/**
 * 
 * @author kelvin.tie
 */
public interface APITestDao {

	public boolean add(AppApiTest test)throws SQLException;
	
	public boolean update(AppApiTest test)throws SQLException;

	public AppApiTest get(Long id) throws SQLException;
	
	public boolean del(Long id) throws SQLException;
	
	/**
	 * 邏輯刪除
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean delData(Long id) throws SQLException;

}