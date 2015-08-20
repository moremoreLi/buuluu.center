package com.mobile.blue.buuluu.api.dao;

import java.util.List;
import java.util.Map;



/**
 * 
 * @author More
 * 2015-7-24
 *图片，app，视频，游戏资源服务器相关接口
 */
public interface SourceDao {

	List<Map<String, Object>> getVideoList(String order,String orderType,int pageNo,int limit,Integer type);

	Map<String, Object> getVideoDetail(int sourceId);

	List<Map<String, Object>> getAppList(Integer categoryid, Integer classid,
			String order, String orderType, Integer page,Integer type);

	/*
	 * 获取apk的具体信息
	 */
	Map<String, Object> getAppDetail(Integer sourceId);

	/*
	 * 随机获取video i个视频
	 */
	List<Map<String, Object>> getRandForVideo(int i);

	/*
	 * 随机获取app i个app
	 */
	List<Map<String, Object>> getRandForApp(int i);

	/*
	 * 获取受众的视频
	 */
	List<Map<String, Object>> getFarVideo(String userId);

	/*
	 * 获取比较常用的apk
	 */
	List<Map<String, Object>> getFarApp(String userId);

}
