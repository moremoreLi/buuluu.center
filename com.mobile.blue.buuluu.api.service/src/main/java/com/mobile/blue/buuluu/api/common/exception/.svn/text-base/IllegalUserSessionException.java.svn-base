package com.mobile.blue.buuluu.api.common.exception;

import com.mobile.blue.buuluu.api.common.util.CodeStatus;
import com.mobile.blue.buuluu.api.common.util.I18nUtil;

public class IllegalUserSessionException extends BuuluuAPIException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7693767574751303954L;

	private static int errorCode = CodeStatus.USER_SESSION_EXCEPTION;

	public int getErrorCode() {
		return errorCode;
	}
	
	public IllegalUserSessionException(String langCode) {
		super(I18nUtil.getMessage(errorCode, null, langCode));
	}

}
