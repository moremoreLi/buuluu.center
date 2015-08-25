package com.user.buuluu.vo;

import java.io.Serializable;

/**
 * 
 * @author More
 * 2015.7.15
 *下载软件对象
 */
public class SoftVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2270338064602334746L;
	
	private String packageName;//软件包
	private Integer appId;//软件 的id
	private String title;//软件标题
	private String version;//软件版本
	private String appIcon;//软件头像
	private String appUrl;//软件下载地址
	private String[] appBannerPic;//	banner展示图片地址
	private String[] apppreView;//软件预览图地址
	private String introduction;//软件产品介绍
	private String instruction;//赚流量币说明
	private Float flowCoins;//流量币
	private Float shareCoins;//分享赚流量币
	private Float size;//软件大小
	private Boolean isDownloadFinished;//是否完成下载(赚币) 0-未完成 1-已完成
	private Long downloadFinishTime;//下载完成时间ms
	private Boolean isShareFinished;//是否完成分享(赚币) 0-未完成 1-已完成
	private Long shareFinishTime;//分享完成时间ms
	
	public SoftVO(){
		if (packageName==null) 
			this.packageName="";
		if(this.appId==null)
			this.appId=1;
		if(this.title==null)
			this.title="";
		if(this.version==null)
			this.version="1.0.0";
		if(this.appIcon==null)
			this.appIcon="";
		if(this.appUrl==null)
			this.appUrl="";
		if(this.appBannerPic==null)
			this.appBannerPic=new String[]{};
		if(this.apppreView==null)
			this.apppreView=new String[]{};
		if(this.introduction==null)
			this.introduction="";
		if(this.instruction==null)
			this.instruction="";
		if(this.flowCoins==null)
			this.flowCoins=1F;
		if(this.shareCoins==null)
			this.shareCoins=1F;
		if(this.size==null)
			this.size=1F;
		if(this.isDownloadFinished==null)
			this.isDownloadFinished=false;
		if(this.downloadFinishTime==null)
			this.downloadFinishTime=1L;
		if(this.isShareFinished==null)
			this.isShareFinished=false;
		if(this.shareFinishTime==null)
			this.shareFinishTime=1L;
		
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAppIcon() {
		return appIcon;
	}

	public void setAppIcon(String appIcon) {
		this.appIcon = appIcon;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	
	public String[] getAppBannerPic() {
		return appBannerPic;
	}

	public void setAppBannerPic(String[] appBannerPic) {
		this.appBannerPic = appBannerPic;
	}

	public String[] getApppreView() {
		return apppreView;
	}

	public void setApppreView(String[] apppreView) {
		this.apppreView = apppreView;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public Float getFlowCoins() {
		return flowCoins;
	}

	public void setFlowCoins(Float flowCoins) {
		this.flowCoins = flowCoins;
	}

	public Float getShareCoins() {
		return shareCoins;
	}

	public void setShareCoins(Float shareCoins) {
		this.shareCoins = shareCoins;
	}

	public Float getSize() {
		return size;
	}

	public void setSize(Float size) {
		this.size = size;
	}

	public Boolean getIsDownloadFinished() {
		return isDownloadFinished;
	}

	public void setIsDownloadFinished(Boolean isDownloadFinished) {
		this.isDownloadFinished = isDownloadFinished;
	}

	public Long getDownloadFinishTime() {
		return downloadFinishTime;
	}

	public void setDownloadFinishTime(Long downloadFinishTime) {
		this.downloadFinishTime = downloadFinishTime;
	}

	public Boolean getIsShareFinished() {
		return isShareFinished;
	}

	public void setIsShareFinished(Boolean isShareFinished) {
		this.isShareFinished = isShareFinished;
	}

	public Long getShareFinishTime() {
		return shareFinishTime;
	}

	public void setShareFinishTime(Long shareFinishTime) {
		this.shareFinishTime = shareFinishTime;
	}
	
}
