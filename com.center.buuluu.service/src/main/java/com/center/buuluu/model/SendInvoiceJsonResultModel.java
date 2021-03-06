package com.center.buuluu.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class SendInvoiceJsonResultModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6508567287945663703L;

	@JsonProperty("IsSuccess")
	private Boolean isSuccess;

	@JsonProperty("ReturnData")
	private String returnData;

	@JsonProperty("ErrorInfo")
	private String errorInfo;

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getReturnData() {
		return returnData;
	}

	public void setReturnData(String returnData) {
		this.returnData = returnData;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

}
