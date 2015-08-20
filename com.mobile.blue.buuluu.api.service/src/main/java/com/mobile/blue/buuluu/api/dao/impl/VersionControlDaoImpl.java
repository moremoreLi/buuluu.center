package com.mobile.blue.buuluu.api.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.dao.VersionControlDao;
import com.mobile.blue.buuluu.api.dao.mysql.VersionControlDaoMysql;
import com.mobile.blue.buuluu.model.AppVersionUpdate;

/**
 * 
 * @author More
 * 2015-7-24
 * 版本更新
 */
@Repository
public class VersionControlDaoImpl extends Context implements VersionControlDao {
	
	@Autowired 
	private VersionControlDaoMysql versionControlDaoMysql;

	@Override
	public List<AppVersionUpdate> getVersionUpdate(Integer device, String store,String channel, String lang) {
		return versionControlDaoMysql.getVersionUpdate(device,store,channel,lang);
	}
	

}
