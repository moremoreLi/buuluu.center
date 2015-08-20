package com.mobile.blue.buuluu.api.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.model.AppFlowPackage;
/**
 * 
 * @author More
 *2015-8-5
 * 流量包相关接口
 */
@Repository
public class FlowPkgDaoMysql extends AbstractBaseDaoMysql<AppFlowPackage>{

	public List<AppFlowPackage> getFlowPkg() {
		String sql = "SELECT * FROM " + this.tableName + " WHERE  IS_DELETED=false";
		return super.queryForList(sql, this.baseModelClass);
	}


}
