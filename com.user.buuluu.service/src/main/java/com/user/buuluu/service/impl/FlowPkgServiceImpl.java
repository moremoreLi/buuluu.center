package com.user.buuluu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.buuluu.annotation.CacheKey;
import com.user.buuluu.annotation.Cacheable;
import com.user.buuluu.annotation.Cacheable.TypeMode;
import com.user.buuluu.dao.mapper.AppFlowPackageMapper;
import com.user.buuluu.model.AppBuuluuUser;
import com.user.buuluu.model.AppFlowPackage;
import com.user.buuluu.service.FlowPkgService;


@Service("flowPkgService")
public class FlowPkgServiceImpl implements FlowPkgService{

	@Autowired
	private AppFlowPackageMapper appFlowPackageMapper;
	@Override
	@Cacheable(table=AppFlowPackage.class,type=TypeMode.HASH) 
	public List<AppFlowPackage> getFlowPkg(@CacheKey String cache) {
		return appFlowPackageMapper.getFlowPkg();
	}

}
