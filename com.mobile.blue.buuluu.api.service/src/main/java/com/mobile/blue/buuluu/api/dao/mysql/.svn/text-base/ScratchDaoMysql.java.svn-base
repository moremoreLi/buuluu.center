package com.mobile.blue.buuluu.api.dao.mysql;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.jdbc.StatementParameter;
import com.mobile.blue.buuluu.model.AppScratch;
/**
 * 
 * @author More
 *2015-7-27
 *刮刮卡相关信息接口
 */
@Repository
public class ScratchDaoMysql extends AbstractBaseDaoMysql<AppScratch>{

	public List<Map<String,Object>> getScratchList() {
		String sql = "SELECT * FROM " + this.tableName + " WHERE  IS_DELETED=false";
		return super.queryForMaps(sql);
	}

	public AppScratch getScratchCoins(Integer scratchId) {
		String sql = "SELECT * FROM " + this.tableName + " WHERE  ID=? AND IS_DELETED=false";
		StatementParameter param = new StatementParameter();
		param.setInt(scratchId);
		return super.query(sql, this.baseModelClass, param);
	}


}
