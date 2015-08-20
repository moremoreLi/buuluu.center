package com.mobile.blue.buuluu.api.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.buuluu.api.dao.BillRecordDao;
import com.mobile.blue.buuluu.api.service.BillRecordService;
import com.mobile.blue.buuluu.model.AppBillRecord;
import com.mobile.blue.buuluu.model.AppUser;

@Service
public class BillRecordServiceImpl implements BillRecordService{
	
	@Autowired
	private BillRecordDao billRecordDao;

	@Override
	public List<Map<String, Object>> getBillList(String userId) {
		return billRecordDao.getBillList(userId);
	}

	@Override
	public AppBillRecord add(AppUser user, Map<String, Object> sourceObj) {
		AppBillRecord appBillRecord = new AppBillRecord();
//		return billRecordDao.add(user, Map<String, Object> sourceObj);
		return appBillRecord;
	}


}
