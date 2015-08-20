package com.mobile.blue.buuluu.api.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.dao.SourceDao;
import com.mobile.blue.buuluu.api.dao.mysql.SourceDaoMysql;

@Repository
public class SourceDaoImpl  extends Context implements SourceDao {
	
	@Autowired
	private SourceDaoMysql sourceDaoMysql;

	@Override
	public List<Map<String, Object>> getVideoList(String order,String orderType,int pageNo,int limit,Integer type) {
		return sourceDaoMysql.getVideoList(order, orderType, pageNo, limit,type);
	}
	
	@Override
	public Map<String, Object>  getVideoDetail(int sourceId) {
		return sourceDaoMysql.getVideoDetail(sourceId);
	}
	
	@Override
	public List<Map<String, Object>> getAppList(Integer categoryid,Integer classid,String order,String orderType,Integer page,Integer type){
		return sourceDaoMysql.getAppList(categoryid, classid, order, orderType, page,type);
	}

	@Override
	public Map<String, Object> getAppDetail(Integer sourceId) {
		return sourceDaoMysql.getAppDetail(sourceId);
	}

	@Override
	public List<Map<String, Object>> getRandForVideo(int i) {
		return sourceDaoMysql.getRandForVideo( i);
	}

	@Override
	public List<Map<String, Object>> getRandForApp(int i) {
		return sourceDaoMysql.getRandForApp( i);
	}

	@Override
	public List<Map<String, Object>> getFarVideo(String userId) {
		return sourceDaoMysql.getFarVideo(userId);
	}

	@Override
	public List<Map<String, Object>> getFarApp(String userId) {
		return sourceDaoMysql.getFarApp(userId);
	}

}
