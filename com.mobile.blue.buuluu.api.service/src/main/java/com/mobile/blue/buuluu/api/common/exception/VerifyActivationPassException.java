package com.mobile.blue.buuluu.api.common.exception;

import com.mobile.blue.buuluu.api.common.util.CodeStatus;
import com.mobile.blue.buuluu.api.common.util.I18nUtil;

public class VerifyActivationPassException extends BuuluuAPIException {


	private static final long serialVersionUID = 3730032417693458386L;
	
	private static int errorCode = CodeStatus.VERIFY_ACTIVATION_PASS_EXCEPTION;
	
	@Override
	public int getErrorCode() {
		return errorCode;
	}
	
	public VerifyActivationPassException(String langCode) {
		super(I18nUtil.getMessage(errorCode, null, langCode));
	}
}
