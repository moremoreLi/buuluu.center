package com.mobile.blue.buuluu.api.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.dao.FlowPkgDao;
import com.mobile.blue.buuluu.api.dao.mysql.FlowPkgDaoMysql;
import com.mobile.blue.buuluu.model.AppFlowPackage;

@Repository
public class FlowPkgDaoImpl extends Context implements FlowPkgDao{
	
	@Autowired
	private FlowPkgDaoMysql  flowPkgDaoMysql;

	@Override
	public List<AppFlowPackage> getFlowPkg() {
		return flowPkgDaoMysql.getFlowPkg();
	}
	
	
}
