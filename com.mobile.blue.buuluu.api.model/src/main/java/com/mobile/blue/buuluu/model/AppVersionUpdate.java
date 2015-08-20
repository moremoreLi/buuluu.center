package com.mobile.blue.buuluu.model;

/**
 * 
 * @author More
 *版本更新 2015-7-24
 */
public class AppVersionUpdate extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 361918166037702003L;

	private String store;//存储号
	private String channel;//渠道号
	private Integer type;//0:已是最新版本   1:强制升级  2:普通升级
	private String filePath;//更新路径
	private Double fileSize;//版本大小
	private String version;//版本类型
	private String description;//版本描述
	private String versionNum;//版本号
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Double getFileSize() {
		return fileSize;
	}
	public void setFileSize(Double fileSize) {
		this.fileSize = fileSize;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVersionNum() {
		return versionNum;
	}
	public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
	}
}
