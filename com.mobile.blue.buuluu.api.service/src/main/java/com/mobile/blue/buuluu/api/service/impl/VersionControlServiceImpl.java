package com.mobile.blue.buuluu.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.common.exception.BaseAPIException;
import com.mobile.blue.buuluu.api.common.exception.VersionNotFindException;
import com.mobile.blue.buuluu.api.dao.VersionControlDao;
import com.mobile.blue.buuluu.api.service.VersionControlService;
import com.mobile.blue.buuluu.model.AppVersionUpdate;

@Service
public class VersionControlServiceImpl extends Context implements VersionControlService{
	
	@Autowired
	private VersionControlDao versionControlDao;

	@Override
	public AppVersionUpdate getVersionUpdate(Integer device, String store,String channel, String lang) {
		List<AppVersionUpdate> list = versionControlDao. getVersionUpdate(device,store,channel,lang);
		
		if (list==null) {
			throw new VersionNotFindException(lang);
		}else if(list.size()==1){
			return list.get(0);
		}else{
			throw new BaseAPIException();
		}
	}
	


}
