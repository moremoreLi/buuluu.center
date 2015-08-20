package com.mobile.blue.buuluu.api.dao.mysql;

import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.model.AppVistorUser;
/**
 * 
 * @author More
 *2015-8-7
 */
@Repository
public class VistorUserDaoMysql extends AbstractBaseDaoMysql<AppVistorUser>{

//	public AppUser getByTel(String countryCode, String tel) {
//		String sql = "SELECT * FROM " + this.tableName + " WHERE TEL =? AND COUNTRY_CODE =? AND IS_DELETED=false";
//		StatementParameter param = new StatementParameter();
//		param.setString(tel);
//		param.setString(countryCode);
//		List<AppUser> list = super.queryForList(sql, this.baseModelClass, param);
//		
//		if (ListUtil.isEmpty(list)) {
//			return null;
//		}else {
//			return list.get(0);
//		}
//	}
//
//	public AppUser getUserById(String userId) {
//		String sql = "SELECT * FROM " + this.tableName + " WHERE ID=?  AND IS_DELETED=false";
//		StatementParameter param = new StatementParameter();
//		param.setString(userId);
//		return super.query(sql, this.baseModelClass, param);
//	}

}
