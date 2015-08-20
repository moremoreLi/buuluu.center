package com.mobile.blue.buuluu.api.dao.mysql;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.jdbc.StatementParameter;
import com.mobile.blue.buuluu.model.AppBillRecord;
/**
 * 用户账单记录
 * @author More
 *2015-7-28
 */
@Repository
public class BillRecordDaoMysql extends AbstractBaseDaoMysql<AppBillRecord>{

	public List<Map<String, Object>> getBillList(String userId) {
		String sql = "SELECT * FROM " + this.tableName + " WHERE  USER_ID=? AND IS_DELETED=false";
		StatementParameter param = new StatementParameter();
		param.setString(userId);
		return super.queryForMaps(sql, param);
	}


}
