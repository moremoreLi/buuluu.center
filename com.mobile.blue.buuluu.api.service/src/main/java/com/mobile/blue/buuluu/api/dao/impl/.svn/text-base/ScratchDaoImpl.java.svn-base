package com.mobile.blue.buuluu.api.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.dao.ScratchDao;
import com.mobile.blue.buuluu.api.dao.mysql.ScratchDaoMysql;
import com.mobile.blue.buuluu.model.AppScratch;

@Repository
public class ScratchDaoImpl extends Context implements ScratchDao{
	
	@Autowired
	private ScratchDaoMysql scratchDaoMysql;

	@Override
	public List<Map<String, Object>> getScratchList() {
		return scratchDaoMysql.getScratchList();
	}

	@Override
	public AppScratch getScratchCoins(Integer scratchId) {
		return scratchDaoMysql.getScratchCoins(scratchId);
	}
	
}
