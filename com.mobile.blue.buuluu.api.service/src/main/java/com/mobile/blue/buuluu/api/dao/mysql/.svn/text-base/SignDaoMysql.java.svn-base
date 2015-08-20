package com.mobile.blue.buuluu.api.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.jdbc.ListUtil;
import com.mobile.blue.buuluu.api.common.jdbc.StatementParameter;
import com.mobile.blue.buuluu.api.common.util.DateUtil;
import com.mobile.blue.buuluu.model.AppUserSign;
/**
 * 
 * @author More
 *2015-7-27
 * 用户签到相关
 */
@Repository
public class SignDaoMysql extends AbstractBaseDaoMysql<AppUserSign>{

	public AppUserSign getByUserId(String userId) {
		String sql = "SELECT * FROM " + this.tableName + " WHERE USER_ID=? AND DATE_FORMAT(CREATED_TIME,'%Y-%m-%d')=?  AND IS_DELETED=false";
		StatementParameter param = new StatementParameter();
		param.setString(userId);
		param.setString(DateUtil.getCurrentDateStr(DateUtil.DATE_PATTERN_DEFAULT));
		
		List<AppUserSign> list = super.queryForList(sql, this.baseModelClass, param);
//		
		if (ListUtil.isEmpty(list)) {
			return null;
		}else {
			return list.get(0);
		}
	}

	public List<String> getSignList(String userId) {
		String sql = "SELECT DATE_FORMAT(CREATED_TIME,'%Y-%m-%d') FROM " + this.tableName + " WHERE USER_ID=?  AND IS_DELETED=false ORDER BY CREATED_TIME";
		StatementParameter param = new StatementParameter();
		param.setString(userId);
		return super.queryForStrings(sql, param);
	}


}
