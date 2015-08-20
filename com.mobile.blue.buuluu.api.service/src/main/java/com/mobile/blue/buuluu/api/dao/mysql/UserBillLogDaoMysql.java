package com.mobile.blue.buuluu.api.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.jdbc.StatementParameter;
import com.mobile.blue.buuluu.model.AppUserBillLog;
/**
 * 
 * @author More
 *2015-7-27
 *保存用户账单分配记录
 */
@Repository
public class UserBillLogDaoMysql extends AbstractBaseDaoMysql<AppUserBillLog>{

	public List<AppUserBillLog> getBillLogByUserId(String userId) {
		String sql = "SELECT * FROM " + this.tableName + " WHERE USER_ID =?  AND IS_DELETED=false";
		StatementParameter param = new StatementParameter();
		param.setString(userId);
		List<AppUserBillLog> list = super.queryForList(sql, this.baseModelClass, param);
		return list;
	}

}
