package com.mobile.blue.buuluu.api.dao.mysql;

import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.jdbc.StatementParameter;
import com.mobile.blue.buuluu.model.AppUserSession;

@Repository
public class UserSessionDaoMysql extends AbstractBaseDaoMysql<AppUserSession>{
	

	public int updateById(Object userId) {
		String sql = "UPDATE  "+  this.tableName+ "  SET IS_DELETED=TRUE WHERE USER_ID =? AND IS_DELETED=false";
		StatementParameter param = new StatementParameter();
		param.setString(String.valueOf(userId));
		return super.updateForRecord(sql, param);
	}

	public AppUserSession getUserSessionByUserId(String userId) {
		String sql = "SELECT * FROM  "+  this.tableName+ "  WHERE USER_ID =? AND IS_DELETED=false";
		StatementParameter param = new StatementParameter();
		param.setString(String.valueOf(userId));
		return super.query(sql, this.baseModelClass, param);
	}

	public AppUserSession checkUserSession(String userId, String token) {
		String sql = "SELECT * FROM  "+  this.tableName+ "  WHERE USER_ID =? AND TOKEN=? AND STATUS =1 AND IS_DELETED=false";
		StatementParameter param = new StatementParameter();
		param.setString(userId);
		param.setString(token);
		return super.query(sql, this.baseModelClass, param);
	}

	public boolean logout(String userId, String token) {
		String sql = "UPDATE   "+  this.tableName+ " SET STATUS=0 WHERE USER_ID =? AND TOKEN=? AND STATUS =1 AND IS_DELETED=false";
		StatementParameter param = new StatementParameter();
		param.setString(userId);
		param.setString(token);
		return super.updateForBoolean(sql, param);
	}

}
