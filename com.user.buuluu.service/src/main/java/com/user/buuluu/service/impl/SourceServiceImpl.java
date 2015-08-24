package com.user.buuluu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.buuluu.common.Context;
import com.user.buuluu.dao.mapper.AdVideoMapper;
import com.user.buuluu.dao.mapper.AppInfoMapper;
import com.user.buuluu.dao.model.AppInfoModel;
import com.user.buuluu.dao.model.AppRandModel;
import com.user.buuluu.model.AdVideoWithBLOBs;
import com.user.buuluu.service.SourceService;

@Service("sourceService")
public class SourceServiceImpl  extends Context implements SourceService{
	
	@Autowired
	private AdVideoMapper adVideoMapper;
	
	@Autowired
	private AppInfoMapper appInfoMapper;

	@Override
	public List<AdVideoWithBLOBs> getVideoList(Map<String, Object> map) {
		return adVideoMapper.getVideoList(map);
	}

	@Override
	public List<AppInfoModel> getAppList(Map<String, Object> map) {
		return appInfoMapper.getAppList(map);
	}

	@Override
	public List<AppRandModel> getRandForVideo(int i) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("limitStr", 0+","+i);
		return adVideoMapper.getRandForVideo(map);
	}

	@Override
	public List<AppRandModel> getRandForApp(int i) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("limitStr", 0+","+i);
		return appInfoMapper.getRandForApp(map);
	}

	
}
