package com.mobile.blue.buuluu.api.dao;

import java.sql.SQLException;

import com.mobile.blue.buuluu.model.AppSnsAccount;




/**
 * 
 * @author More
 * 2015-7-31
 * 绑定相关接口
 *
 */
public interface SnsAccountDao {

	/*
	 * 获取第三方是否有账号绑定
	 */
	AppSnsAccount getSns(Integer type, String snsId);

	/*
	 * 添加第三方绑定账号
	 */
	AppSnsAccount addSns(AppSnsAccount appSnsAccount);

	/*
	 * 更新第三方绑定账号
	 */
	boolean updateSns(AppSnsAccount appSnsAccount) throws SQLException;

}
