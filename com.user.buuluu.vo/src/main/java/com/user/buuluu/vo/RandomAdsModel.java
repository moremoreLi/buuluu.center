package com.user.buuluu.vo;

import java.io.Serializable;

/**
 * 从资源服务器随机获取视频
 * @author More
 *2015-7-23
 */
public class RandomAdsModel implements Serializable{

	private static final long serialVersionUID = 4378226283003943069L;
    private String icon;//图片头像
    private Integer sourceId;//资源ID
    private Float makeFlows;//赠送流量
    private String title;//标题
    private Integer type;//类型
    private Boolean  flag;//资源是否播放成功，false是失败，true是成功
    private String sourceUrl;//资源路径
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getSourceId() {
		return sourceId;
	}
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}
	
	public Float getMakeFlows() {
		return makeFlows;
	}
	public void setMakeFlows(Float makeFlows) {
		this.makeFlows = makeFlows;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	public String getSourceUrl() {
		return sourceUrl;
	}
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}
}
