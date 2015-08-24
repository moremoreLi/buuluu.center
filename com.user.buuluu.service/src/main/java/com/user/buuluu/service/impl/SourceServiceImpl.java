package com.user.buuluu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.buuluu.common.Context;
import com.user.buuluu.dao.mapper.AdVideoMapper;
import com.user.buuluu.model.AdVideoWithBLOBs;
import com.user.buuluu.service.SourceService;

@Service("sourceService")
public class SourceServiceImpl  extends Context implements SourceService{
	
	@Autowired
	private AdVideoMapper adVideoMapper;

	@Override
	public List<AdVideoWithBLOBs> getVideoList(Map<String, Object> map) {
		return adVideoMapper.getVideoList(map);
	}

	@Override
	public List<Map<String, Object>> getAppList(Map<String, Object> map) {
		return null;
	}
	
}
