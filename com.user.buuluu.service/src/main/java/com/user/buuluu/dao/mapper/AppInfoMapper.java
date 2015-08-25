package com.user.buuluu.dao.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.user.buuluu.annotation.MyBatisRepository;
import com.user.buuluu.dao.model.AppInfoModel;
import com.user.buuluu.dao.model.AppRandModel;
import com.user.buuluu.model.AppInfo;
import com.user.buuluu.model.AppInfoWithBLOBs;

@Component
@MyBatisRepository
public interface AppInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_info
     *
     * @mbggenerated Mon Aug 24 12:06:12 CST 2015
     */
    int deleteByPrimaryKey(Integer rowid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_info
     *
     * @mbggenerated Mon Aug 24 12:06:12 CST 2015
     */
    int insert(AppInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_info
     *
     * @mbggenerated Mon Aug 24 12:06:12 CST 2015
     */
    int insertSelective(AppInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_info
     *
     * @mbggenerated Mon Aug 24 12:06:12 CST 2015
     */
    AppInfoWithBLOBs selectByPrimaryKey(Integer rowid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_info
     *
     * @mbggenerated Mon Aug 24 12:06:12 CST 2015
     */
    int updateByPrimaryKeySelective(AppInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_info
     *
     * @mbggenerated Mon Aug 24 12:06:12 CST 2015
     */
    int updateByPrimaryKeyWithBLOBs(AppInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_info
     *
     * @mbggenerated Mon Aug 24 12:06:12 CST 2015
     */
    int updateByPrimaryKey(AppInfo record);

    /**
     * 获取app下载信息
     * @param map
     * @return
     */
	List<AppInfoModel> getAppList(Map<String, Object> map);

	/**
	 * 随机获取app下载信息
	 * @param map
	 * @return
	 */
	List<AppRandModel> getRandForApp(Map<String, Object> map);
	
}