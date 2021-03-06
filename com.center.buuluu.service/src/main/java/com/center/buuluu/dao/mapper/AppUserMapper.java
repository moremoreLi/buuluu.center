package com.center.buuluu.dao.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.center.buuluu.annotation.MyBatisRepository;
import com.center.buuluu.model.AppUser;

@Component
@MyBatisRepository
public interface AppUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbggenerated Wed Aug 19 20:56:55 CST 2015
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbggenerated Wed Aug 19 20:56:55 CST 2015
     */
    int insert(AppUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbggenerated Wed Aug 19 20:56:55 CST 2015
     */
    int insertSelective(AppUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbggenerated Wed Aug 19 20:56:55 CST 2015
     */
    AppUser selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbggenerated Wed Aug 19 20:56:55 CST 2015
     */
    int updateByPrimaryKeySelective(AppUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbggenerated Wed Aug 19 20:56:55 CST 2015
     */
    int updateByPrimaryKeyWithBLOBs(AppUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbggenerated Wed Aug 19 20:56:55 CST 2015
     */
    int updateByPrimaryKey(AppUser record);

	AppUser getByTel(Map<String, String> map);
}