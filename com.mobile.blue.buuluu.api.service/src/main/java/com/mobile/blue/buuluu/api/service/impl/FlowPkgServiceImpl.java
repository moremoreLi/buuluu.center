package com.mobile.blue.buuluu.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.dao.FlowPkgDao;
import com.mobile.blue.buuluu.api.service.FlowPkgService;
import com.mobile.blue.buuluu.model.AppFlowPackage;

@Service
public class FlowPkgServiceImpl extends Context implements FlowPkgService {
	
	@Autowired
	private FlowPkgDao  flowPkgDao;

	@Override
	public List<AppFlowPackage> getFlowPkg() {
		return flowPkgDao.getFlowPkg();
	}

}