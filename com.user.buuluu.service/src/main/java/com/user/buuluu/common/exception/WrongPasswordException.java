package com.user.buuluu.common.exception;

import com.user.buuluu.common.util.CodeStatus;
import com.user.buuluu.common.util.I18nUtil;

public class WrongPasswordException extends BuuluuAPIException{

	private static final long serialVersionUID = 4409556217020156002L;

	private static int errorCode = CodeStatus.WRONG_PASSWORD_EXCEPTION;
	
	@Override
	public int getErrorCode() {
		return errorCode;
	}
	
	public WrongPasswordException(String langCode) {
		super(I18nUtil.getMessage(errorCode, null, langCode));
	}

}
