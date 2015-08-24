package com.user.buuluu.dao.model;

import java.io.Serializable;
import java.util.List;

import com.user.buuluu.model.AppInfoWithBLOBs;

/**
 * 
 * @author More.li
 * 2015-8-24
 *下载app的返回model
 */
public class AppInfoModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1799360919111744047L;
	
	private String  className;//APP的名字
	
	private AppInfoWithBLOBs appInfoWithBLOBs;//Appinfo具体详情s

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public AppInfoWithBLOBs getAppInfoWithBLOBs() {
		return appInfoWithBLOBs;
	}

	public void setAppInfoWithBLOBs(AppInfoWithBLOBs appInfoWithBLOBs) {
		this.appInfoWithBLOBs = appInfoWithBLOBs;
	}
	
}
