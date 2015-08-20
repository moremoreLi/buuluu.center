package com.mobile.blue.buuluu.api.common.exception;

import com.mobile.blue.buuluu.api.common.util.CodeStatus;

/**
 * 
 * @author More
 * 2015-7-16
 */
public  class BuuluuAPIException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7065579710316348767L;

	private int errorCode = CodeStatus.SYSTEM_ERROR;
	public int getErrorCode() {
		return errorCode;
	}

	public BuuluuAPIException() {
		super();
	}

	public BuuluuAPIException(String message, Throwable cause) {
		super(message, cause);
	}

	public BuuluuAPIException(String message) {
		super(message);
	}

	public BuuluuAPIException(Throwable cause) {
		super(cause);
	}

}
