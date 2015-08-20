package com.mobile.blue.buuluu.api.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.mobile.blue.buuluu.model.AppUser;
import com.mobile.blue.buuluu.model.AppUserBill;
import com.mobile.blue.buuluu.model.AppVistorUser;



/**
 * 
 * @author More
 * 2015-7-25
 * 用户相关接口
 *
 */
public interface UserBillDao {

	/*
	 * 保存用户账单
	 */
	AppUserBill saveBill(AppUser user, Integer sourceId, Integer type, Map<String, Object> sourceObj, AppVistorUser vistorUser);

	/*
	 * 根据用户id，资料id和资源类型查找唯一账单记录
	 */
	List<AppUserBill> checkBill(AppUser user, Integer sourceId, Integer type, AppVistorUser vistorUser);

	/*
	 * 根据账单id获取账单详情
	 */
	Map<String, Object> getCoinsDetail(Integer billingId);

	/*
	 * 根据账单id粗略获取账单信息
	 */
	AppUserBill getBillById(Integer billingId);

	/*
	 * 更新用户账单剩余的可用流量
	 */
	boolean updateBillById(AppUserBill appUserBill) throws SQLException;

	/*
	 * 获取用户账单的获取流量包
	 */
	List<AppUserBill> getBillByUserId(String userId);



}
