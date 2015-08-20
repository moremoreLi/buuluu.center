package com.mobile.blue.buuluu.api.dao.mysql;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.jdbc.ListUtil;
import com.mobile.blue.buuluu.api.common.jdbc.StatementParameter;
import com.mobile.blue.buuluu.model.AppUser;
import com.mobile.blue.buuluu.model.AppUserBill;
import com.mobile.blue.buuluu.model.AppVistorUser;
/**
 * 
 * @author More
 *2015-7-25
 *保存用户账单
 */
@Repository
public class UserBillDaoMysql extends AbstractBaseDaoMysql<AppUserBill>{

	public List<AppUserBill> checkBill(AppUser user, Integer sourceId,Integer type, AppVistorUser vistorUser) {
		String sql = "SELECT * FROM " + this.tableName + " WHERE USER_ID =? AND SOURCE_ID =? AND TYPE=? AND IS_DELETED=false";
		StatementParameter param = new StatementParameter();
		String id = null;
		if (user==null) {
			id = vistorUser.getId().toString();
		}else {
			id = user.getId().toString();
		}
		param.setString(id);
		param.setInt(sourceId);
		param.setInt(type);
		return super.queryForList(sql, this.baseModelClass, param) ;
	}

	public Map<String, Object> getCoinsDetail(Integer billingId) {
		String sql = "SELECT * FROM  " + this.tableName + "  b LEFT JOIN AD_VIDEO v ON b.SOURCE_ID=v.id WHERE b.ID=? AND b.IS_DELETED=FALSE  ";
		StatementParameter param = new StatementParameter();
		param.setInt(billingId);
		List<Map<String, Object>> list = super.queryForMaps(sql, param);
		if (ListUtil.isEmpty(list)) 
			return null;
		return list.get(0);
	}

	public AppUserBill getBillById(Integer billingId) {
		String sql = "SELECT * FROM  " + this.tableName + "  WHERE ID=? AND IS_DELETED=FALSE ";
		StatementParameter param = new StatementParameter();
		param.setInt(billingId);
		return super.query(sql, this.baseModelClass, param);
	}

	public List<AppUserBill> getBillByUserId(String userId) {
		String sql = "SELECT * FROM  " + this.tableName + "  WHERE USER_ID=? AND IS_DELETED=FALSE ";
		StatementParameter param = new StatementParameter();
		param.setString(userId);
		return super.queryForList(sql, this.baseModelClass, param);
	}

}
