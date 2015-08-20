package com.mobile.blue.buuluu.api.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.jdbc.ListUtil;
import com.mobile.blue.buuluu.api.common.jdbc.StatementParameter;
import com.mobile.blue.buuluu.model.AppSnsAccount;
/**
 * 
 * @author More
 *2015-7-31
 * 第三方绑定接口
 */
@Repository
public class SnsAccountDaoMysql extends AbstractBaseDaoMysql<AppSnsAccount>{

	public AppSnsAccount getSns(Integer type, String snsId) {
		String sql = "SELECT * FROM " + this.tableName + " WHERE ACCOUNT_TYPE_ID =? AND SNS_ID =? AND IS_DELETED=false";
		StatementParameter param = new StatementParameter();
		param.setInt(type);
		param.setString(snsId);
		
		 List<AppSnsAccount> list = super.queryForList(sql, this.baseModelClass, param);
		
		if (ListUtil.isEmpty(list)) {
			return null;
		}else {
			return list.get(0);
		}
	}



}
