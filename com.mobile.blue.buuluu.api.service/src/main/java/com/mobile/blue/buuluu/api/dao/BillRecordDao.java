package com.mobile.blue.buuluu.api.dao;

import java.util.List;
import java.util.Map;


/**
 * 
 * @author More
 *2015-7-28
 *用户账单记录
 */
public interface BillRecordDao {

	/*
	 * 获取用户账单记录
	 */
	List<Map<String, Object>> getBillList(String userId);


}
