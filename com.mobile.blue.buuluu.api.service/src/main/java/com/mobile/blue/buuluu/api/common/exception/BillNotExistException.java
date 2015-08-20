package com.mobile.blue.buuluu.api.common.exception;

import com.mobile.blue.buuluu.api.common.util.CodeStatus;
import com.mobile.blue.buuluu.api.common.util.I18nUtil;

public class BillNotExistException extends BuuluuAPIException {


	private static final long serialVersionUID = 3730032417693458386L;
	
	private static int errorCode = CodeStatus.BILL_NOT_EXIST_EXCEPTION;
	
	@Override
	public int getErrorCode() {
		return errorCode;
	}
	
	public BillNotExistException(String langCode) {
		super(I18nUtil.getMessage(errorCode, null, langCode));
	}
}
