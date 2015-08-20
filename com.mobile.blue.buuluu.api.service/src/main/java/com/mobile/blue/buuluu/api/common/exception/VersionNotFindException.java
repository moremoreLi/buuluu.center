package com.mobile.blue.buuluu.api.common.exception;

import com.mobile.blue.buuluu.api.common.util.CodeStatus;
import com.mobile.blue.buuluu.api.common.util.I18nUtil;
public class VersionNotFindException extends BuuluuAPIException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8462205612674217727L;

	private static int errorCode = CodeStatus.VERSION_UPDATE_EXCEPTION;

	@Override
	public int getErrorCode() {
		return errorCode;
	}
	
	public VersionNotFindException(String langCode){
		super(I18nUtil.getMessage(errorCode, null, langCode));
	}
}
