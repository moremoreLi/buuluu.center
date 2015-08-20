package com.mobile.blue.buuluu.api.dao.mysql;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.jdbc.Jdbc;
import com.mobile.blue.buuluu.api.common.jdbc.ListUtil;
import com.mobile.blue.buuluu.api.common.jdbc.StatementParameter;
import com.mobile.blue.buuluu.api.common.util.Constant;

@Repository
public class SourceDaoMysql extends Jdbc{
	
	/*
	 * type为null是普通查找视频
	 */
	public List<Map<String, Object>> getVideoList(String order,String orderType,int pageNo,int limit, Integer type){
		String sql = "SELECT * FROM ad_video ORDER BY  ? ? LIMIT ?,?";
		StatementParameter param = new StatementParameter();
		param.setString(order);
		param.setString(orderType);
		int index = -1;
		if (type!=null) {
			index= 3*Constant.BANNER_SIZE+(pageNo-1)*limit;
		}else {
			index = (pageNo-1)*limit;
		}
		int size = limit;
		param.setInt(index);
		param.setInt(size);
		
		return super.queryForMaps(sql, param);
	}
	
	
	public Map<String, Object> getVideoDetail(int sourceId){
		String sql = "SELECT * FROM ad_video WHERE ID=?";
		StatementParameter param = new StatementParameter();
		param.setInt(sourceId);
		
		List<Map<String, Object>> list =super.queryForMaps(sql, param);
		if (ListUtil.isNotEmpty(list)) {
			return super.queryForMaps(sql, param).get(0);
		}
		return null;
	}
	
	public List<Map<String, Object>> getAppList(Integer categoryid,Integer classid,String order,String orderType,Integer page,Integer type){
		StringBuilder sql = new StringBuilder();
		StatementParameter param = new StatementParameter();
		 int index = (page-1)*Constant.PAGE_NUM;
		 int size = Constant.PAGE_NUM;
		 if (type==null) {
			size+=5;
		}else {
			index+=5;
		}
		sql.append("select app_info.*,app_category.className from app_info left join app_category on app_info.classId=app_category.rowid where classid");
		if (classid==-1) {
			sql.append("  in (select rowid from app_category where categoryId=?) ");
		}else {
			sql.append(" = ? ");
		} 
		sql.append(" order by ? ? limit ?,? ");
		
		if (classid==-1 ) {
			param.setInt(categoryid);
		}else {
			param.setInt(classid);
		}
		param.setString("app_info."+order);
		param.setString(orderType);
		param.setInt(index);
		param.setInt(size);
		
		return super.queryForMaps(sql.toString(), param);
	}


	public Map<String, Object> getAppDetail(Integer sourceId) {
		String sql = "SELECT * FROM app_info WHERE rowid=?";
		StatementParameter param = new StatementParameter();
		param.setInt(sourceId);
		
		List<Map<String, Object>> list =super.queryForMaps(sql, param);
		if (ListUtil.isNotEmpty(list)) {
			return super.queryForMaps(sql, param).get(0);
		}
		return null;
	}


	public List<Map<String, Object>> getRandForVideo(int i) {
		//SELECT v.videoUrl AS icon,v.id AS sourceId,v.flowCoins AS makeFlows,v.title AS title FROM ad_video  v ORDER BY RAND() LIMIT 0,2;
		String sql = "SELECT v.picture AS icon,v.id AS sourceId,v.flowCoins AS makeFlows,v.title AS title,v.videoUrl  FROM ad_video  v ORDER BY RAND() LIMIT 0,?";
		StatementParameter param = new StatementParameter();
		param.setInt(i);
		return super.queryForMaps(sql, param);
	}


	public List<Map<String, Object>> getRandForApp(int i) {
		String sql = "SELECT a.iconURL AS icon,a.rowid AS sourceId,a.flowCoins AS makeFlows,a.name AS title FROM app_info a ORDER BY RAND() LIMIT 0,?";
		StatementParameter param = new StatementParameter();
		param.setInt(i);
		return super.queryForMaps(sql, param);
	}


	public List<Map<String, Object>> getFarVideo(String userId) {
		String sql = "SELECT v.*,b.STATUS FROM ad_video v LEFT JOIN APP_USER_BILL b ON v.id=b.SOURCE_ID AND b.TYPE=1 AND b.IS_DELETED=FALSE WHERE v.id not in(SELECT SOURCE_ID FROM APP_USER_BILL WHERE USER_ID=? AND STATUS=1 AND TYPE=1)  ORDER BY RAND() LIMIT 0,3 ";
		StatementParameter param = new StatementParameter();
		param.setString(userId);
		return super.queryForMaps(sql,param);
	}


	public List<Map<String, Object>> getFarApp(String userId) {
		String sql = "SELECT v.*,b.STATUS FROM app_info v LEFT JOIN APP_USER_BILL b ON v.rowid=b.SOURCE_ID AND b.TYPE=1 AND b.IS_DELETED=FALSE WHERE v.rowid not in(SELECT SOURCE_ID FROM APP_USER_BILL WHERE USER_ID=? AND STATUS=1 AND TYPE=2)   ORDER BY RAND() LIMIT 0,3 ";
		StatementParameter param = new StatementParameter();
		param.setString(userId);
		return super.queryForMaps(sql,param);
	}
}
