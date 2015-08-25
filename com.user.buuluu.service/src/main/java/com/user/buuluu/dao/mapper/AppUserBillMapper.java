package com.user.buuluu.dao.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.user.buuluu.annotation.MyBatisRepository;
import com.user.buuluu.model.AppUserBill;

@Component
@MyBatisRepository
public interface AppUserBillMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user_bill
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user_bill
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    int insert(AppUserBill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user_bill
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    int insertSelective(AppUserBill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user_bill
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    AppUserBill selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user_bill
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    int updateByPrimaryKeySelective(AppUserBill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user_bill
     *
     * @mbggenerated Tue Aug 25 15:49:37 CST 2015
     */
    int updateByPrimaryKey(AppUserBill record);
    
    /**
	 * 检查账单是否存在
	 * @param map
	 * @return
	 */
	AppUserBill checkBill(Map<String, Object> map);
}