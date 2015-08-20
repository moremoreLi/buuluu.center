package com.mobile.blue.buuluu.api.dao;

import java.util.List;

import com.mobile.blue.buuluu.model.AppVersionUpdate;

/**
 * 
 * @author More
 *2015-7-24
 *版本更新
 */
public interface VersionControlDao {

	
	List<AppVersionUpdate> getVersionUpdate(Integer device, String store,String channel, String lang);

}
