package com.mobile.blue.buuluu.api.common.exception;

import com.mobile.blue.buuluu.api.common.util.CodeStatus;
import com.mobile.blue.buuluu.api.common.util.I18nUtil;

public class ExistMobileException extends BuuluuAPIException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1079977826116980538L;

	private static int errorCode = CodeStatus.EXIST_MOBILE_EXCEPTION;

	public int getErrorCode() {
		return errorCode;
	}
	
	public ExistMobileException(String langCode) {
		super(I18nUtil.getMessage(errorCode, null, langCode));
	}

}
