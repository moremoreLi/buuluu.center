package com.mobile.blue.buuluu.api.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.jdbc.ListUtil;
import com.mobile.blue.buuluu.api.common.jdbc.StatementParameter;
import com.mobile.blue.buuluu.model.AppUser;
/**
 * 
 * @author More
 *2015-7-17
 */
@Repository
public class UserDaoMysql extends AbstractBaseDaoMysql<AppUser>{

	public AppUser getByTel(String countryCode, String tel) {
		String sql = "SELECT * FROM " + this.tableName + " WHERE TEL =? AND COUNTRY_CODE =? AND IS_DELETED=false";
		StatementParameter param = new StatementParameter();
		param.setString(tel);
		param.setString(countryCode);
		List<AppUser> list = super.queryForList(sql, this.baseModelClass, param);
		
		if (ListUtil.isEmpty(list)) {
			return null;
		}else {
			return list.get(0);
		}
	}

	public AppUser getUserById(String userId) {
		String sql = "SELECT * FROM " + this.tableName + " WHERE ID=?  AND IS_DELETED=false";
		StatementParameter param = new StatementParameter();
		param.setString(userId);
		return super.query(sql, this.baseModelClass, param);
	}

}
