package com.mobile.blue.buuluu.api.common.jdbc;

import com.mobile.blue.buuluu.model.AppTextFilter;

/**
 * 
 * 所有操作Redis的key必须从此获取
 * 
 * @author carlye
 */
public class RedisKey {

	public static final String PREFIX = "walking-app-api";

	/*自定義緩存*/
	public static String getTestKey() {
		return PREFIX + "Test-list";
	}
	
	/*自定義緩存*/
	public static String getTextFilterKey() {
		return PREFIX + AppTextFilter.class.getSimpleName();
	}


}
