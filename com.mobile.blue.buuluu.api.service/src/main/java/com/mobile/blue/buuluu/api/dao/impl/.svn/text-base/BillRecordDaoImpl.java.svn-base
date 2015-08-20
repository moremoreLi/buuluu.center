package com.mobile.blue.buuluu.api.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.dao.BillRecordDao;
import com.mobile.blue.buuluu.api.dao.mysql.BillRecordDaoMysql;

@Repository
public class BillRecordDaoImpl implements BillRecordDao{
	
	@Autowired
	private BillRecordDaoMysql billRecordDaoMysql;

	@Override
	public List<Map<String, Object>> getBillList(String userId) {
		return billRecordDaoMysql.getBillList(userId);
	}

}
