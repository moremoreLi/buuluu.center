package com.user.buuluu.dao.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.user.buuluu.annotation.MyBatisRepository;
import com.user.buuluu.dao.model.AppRandModel;
import com.user.buuluu.model.AdVideo;
import com.user.buuluu.model.AdVideoWithBLOBs;

@Component
@MyBatisRepository
public interface AdVideoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_video
     *
     * @mbggenerated Mon Aug 24 11:03:56 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_video
     *
     * @mbggenerated Mon Aug 24 11:03:56 CST 2015
     */
    int insert(AdVideoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_video
     *
     * @mbggenerated Mon Aug 24 11:03:56 CST 2015
     */
    int insertSelective(AdVideoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_video
     *
     * @mbggenerated Mon Aug 24 11:03:56 CST 2015
     */
    AdVideoWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_video
     *
     * @mbggenerated Mon Aug 24 11:03:56 CST 2015
     */
    int updateByPrimaryKeySelective(AdVideoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_video
     *
     * @mbggenerated Mon Aug 24 11:03:56 CST 2015
     */
    int updateByPrimaryKeyWithBLOBs(AdVideoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_video
     *
     * @mbggenerated Mon Aug 24 11:03:56 CST 2015
     */
    int updateByPrimaryKey(AdVideo record);

    /**
     *根据排序 获取视频资源
     * @param map
     * @return
     */
	List<AdVideoWithBLOBs> getVideoList(Map<String, Object> map);

	/**
	 * 随机获取视频
	 * @param i
	 * @return
	 */
	List<AppRandModel> getRandForVideo(Map<String, Object> map);
}