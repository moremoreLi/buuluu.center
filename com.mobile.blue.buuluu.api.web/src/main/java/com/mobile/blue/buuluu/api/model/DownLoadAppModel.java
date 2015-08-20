package com.mobile.blue.buuluu.api.model;

import java.io.Serializable;
import java.util.Map;

/**
 * 从资源服务器获取APP，游戏，视频的相关具体信息
 * @author More
 *2015-7-20  screenshot
 */
public class DownLoadAppModel implements Serializable{

	private static final long serialVersionUID = 4378226283003943069L;
    private String rowid;
    private String pkgName;
    private String name;
    private String author;
    private String version;
    private String versionCode;
    private String apkSizeRaw;
    private String downloadURL;
    private String iconURL;
    private String price;
    private String downloadTimes;
    private String description;
    private String updateTime;
    private String[] screenshot;
    private String[] smallPic ;
    private String minSdkVersion;
    private Map<Integer,String> stars;
    private String starScore;
    private String overview;
    private String whatsNew;
    private String[] identifierFlag ;
    private String classId;
    private String className;
    private String countryCode;
    private String instruction;
    private String flowCoins;
    private String shareCoins;
    
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public String getFlowCoins() {
		return flowCoins;
	}
	public void setFlowCoins(String flowCoins) {
		this.flowCoins = flowCoins;
	}
	public String getShareCoins() {
		return shareCoins;
	}
	public void setShareCoins(String shareCoins) {
		this.shareCoins = shareCoins;
	}
	public String getRowid() {
		return rowid;
	}
	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	public String getPkgName() {
		return pkgName;
	}
	public void setPkgName(String pkgName) {
		this.pkgName = pkgName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}
	public String getApkSizeRaw() {
		return apkSizeRaw;
	}
	public void setApkSizeRaw(String apkSizeRaw) {
		this.apkSizeRaw = apkSizeRaw;
	}
	public String getDownloadURL() {
		return downloadURL;
	}
	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}
	public String getIconURL() {
		return iconURL;
	}
	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDownloadTimes() {
		return downloadTimes;
	}
	public void setDownloadTimes(String downloadTimes) {
		this.downloadTimes = downloadTimes;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	public String[] getScreenshot() {
		return screenshot;
	}
	public void setScreenshot(String[] screenshot) {
		this.screenshot = screenshot;
	}
	public String[] getSmallPic() {
		return smallPic;
	}
	public void setSmallPic(String[] smallPic) {
		this.smallPic = smallPic;
	}
	public String getMinSdkVersion() {
		return minSdkVersion;
	}
	public void setMinSdkVersion(String minSdkVersion) {
		this.minSdkVersion = minSdkVersion;
	}
	public Map<Integer, String> getStars() {
		return stars;
	}
	public void setStars(Map<Integer, String> stars) {
		this.stars = stars;
	}
	public String getStarScore() {
		return starScore;
	}
	public void setStarScore(String starScore) {
		this.starScore = starScore;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getWhatsNew() {
		return whatsNew;
	}
	public void setWhatsNew(String whatsNew) {
		this.whatsNew = whatsNew;
	}
	public String[] getIdentifierFlag() {
		return identifierFlag;
	}
	public void setIdentifierFlag(String[] identifierFlag) {
		this.identifierFlag = identifierFlag;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
    
}
