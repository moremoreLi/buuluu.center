package com.mobile.blue.buuluu.api.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.jdbc.StatementParameter;
import com.mobile.blue.buuluu.api.model.AppUserScratchModel;
import com.mobile.blue.buuluu.model.AppUserScratch;
/**
 * 
 * @author More
 *2015-7-30
 *用户使用刮刮卡流量使用情况
 */
@Repository
public class UserScratchDaoMysql extends AbstractBaseDaoMysql<AppUserScratch>{

	public List<AppUserScratch> getUserScratch(String userId, Integer type) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM   "+  this.tableName+ " WHERE USER_ID =? AND IS_DELETED=false ");
		StatementParameter param = new StatementParameter();
		param.setString(userId);
		if (type==null) {
			
		}else {
			if (type==1||type==2) {
				sql.append(" AND TYPE=?");
				param.setInt(type);
			}
		}
		return super.queryForList(sql.toString(), this.baseModelClass, param);
	}

	public List<AppUserScratchModel> getScratchNews(int i) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT s.`MAKE_FLOWS`,s.`DESCRIPTION`,s.`CREATED_TIME`,s.`USER_ID`,u.`COUNTRY_CODE`,u.`TEL`,u.`ICON`,u.`SEX`  FROM ");
		sql.append(this.tableName);
		sql.append("  s  LEFT JOIN APP_USER u ON s.`USER_ID`=u.`ID` WHERE s.`TYPE`=2 AND s.`IS_DELETED`=FALSE AND u.`IS_DELETED`=FALSE  order by s.MAKE_FLOWS desc limit 0,?");
		
		StatementParameter param = new StatementParameter();
		param.setInt(i);
		return super.queryForList(sql.toString(), AppUserScratchModel.class, param);
	}

}
