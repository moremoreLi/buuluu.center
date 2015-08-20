package com.mobile.blue.buuluu.api.service;

import java.util.List;

import com.mobile.blue.buuluu.model.AppFlowPackage;




/**
 * 
 * @author More
 *2015-8-5
 * 流量包相关接口 
 */
public interface FlowPkgService {

	/*
	 * 流量规则
	 */
	List<AppFlowPackage> getFlowPkg();


}
