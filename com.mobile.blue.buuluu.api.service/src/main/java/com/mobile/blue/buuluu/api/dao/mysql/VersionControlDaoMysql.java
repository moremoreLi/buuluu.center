package com.mobile.blue.buuluu.api.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.jdbc.StatementParameter;
import com.mobile.blue.buuluu.model.AppVersionUpdate;
/**
 * 
 * @author More
 * 版本更新
 *
 */
@Repository
public class VersionControlDaoMysql extends AbstractBaseDaoMysql<AppVersionUpdate>{

	public List<AppVersionUpdate> getVersionUpdate(Integer device, String store,String channel, String lang) {
		String sql = "SELECT * FROM   "+  this.tableName+ "  WHERE DEVICE=? AND STORE=? AND CHANNEL=? AND IS_DELETED=false";
		StatementParameter param = new StatementParameter();
		param.setInt(device);
		param.setString(store);
		param.setString(channel);
		return super.queryForList(sql, this.baseModelClass, param);
	}
	

	

}
