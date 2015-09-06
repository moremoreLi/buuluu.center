package com.user.buuluu.dao.model;

import java.io.Serializable;

public class AppInfoAllRowModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 451946942858392205L;
	private Integer rowid;
    private String pkgname;
    private String name;
    private String author;
    private String version;
    private String versioncode;
    private Integer apksizeraw;
    private String price;
    private Integer downloadtimes;
    private String updatetime;
    private Integer minsdkversion;
    private String stars;
    private Float starscore;
    private String countrycode;
    private Integer classid;
    private Integer flowcoins;
    private Integer sharecoins;
    private Integer sourceflag;
	public Integer getRowid() {
		return rowid;
	}
	public void setRowid(Integer rowid) {
		this.rowid = rowid;
	}
	public String getPkgname() {
		return pkgname;
	}
	public void setPkgname(String pkgname) {
		this.pkgname = pkgname;
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
	public String getVersioncode() {
		return versioncode;
	}
	public void setVersioncode(String versioncode) {
		this.versioncode = versioncode;
	}
	public Integer getApksizeraw() {
		return apksizeraw;
	}
	public void setApksizeraw(Integer apksizeraw) {
		this.apksizeraw = apksizeraw;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getDownloadtimes() {
		return downloadtimes;
	}
	public void setDownloadtimes(Integer downloadtimes) {
		this.downloadtimes = downloadtimes;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public Integer getMinsdkversion() {
		return minsdkversion;
	}
	public void setMinsdkversion(Integer minsdkversion) {
		this.minsdkversion = minsdkversion;
	}
	public String getStars() {
		return stars;
	}
	public void setStars(String stars) {
		this.stars = stars;
	}
	public Float getStarscore() {
		return starscore;
	}
	public void setStarscore(Float starscore) {
		this.starscore = starscore;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public Integer getClassid() {
		return classid;
	}
	public void setClassid(Integer classid) {
		this.classid = classid;
	}
	public Integer getFlowcoins() {
		return flowcoins;
	}
	public void setFlowcoins(Integer flowcoins) {
		this.flowcoins = flowcoins;
	}
	public Integer getSharecoins() {
		return sharecoins;
	}
	public void setSharecoins(Integer sharecoins) {
		this.sharecoins = sharecoins;
	}
	public Integer getSourceflag() {
		return sourceflag;
	}
	public void setSourceflag(Integer sourceflag) {
		this.sourceflag = sourceflag;
	}
	public String getDownloadurl() {
		return downloadurl;
	}
	public void setDownloadurl(String downloadurl) {
		this.downloadurl = downloadurl;
	}
	public String getIconurl() {
		return iconurl;
	}
	public void setIconurl(String iconurl) {
		this.iconurl = iconurl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getScreenshot() {
		return screenshot;
	}
	public void setScreenshot(String screenshot) {
		this.screenshot = screenshot;
	}
	public String getSmallpic() {
		return smallpic;
	}
	public void setSmallpic(String smallpic) {
		this.smallpic = smallpic;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getWhatsnew() {
		return whatsnew;
	}
	public void setWhatsnew(String whatsnew) {
		this.whatsnew = whatsnew;
	}
	public String getIdentifierflag() {
		return identifierflag;
	}
	public void setIdentifierflag(String identifierflag) {
		this.identifierflag = identifierflag;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	private String downloadurl;
	private String iconurl;
	private String description;
	private String screenshot;
	private String smallpic;
	private String overview;
	private String whatsnew;
	private String identifierflag;
	private String instruction;
	private int status;
}
