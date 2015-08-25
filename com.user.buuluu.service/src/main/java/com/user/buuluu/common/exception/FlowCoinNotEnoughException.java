package com.user.buuluu.common.exception;

import com.user.buuluu.common.util.CodeStatus;
import com.user.buuluu.common.util.I18nUtil;

public class FlowCoinNotEnoughException extends BuuluuAPIException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1079977826116980538L;

	private static int errorCode = CodeStatus.FLOW_COIN_NOT_ENOUGH_EXCEPTION;

	public int getErrorCode() {
		return errorCode;
	}
	
	public FlowCoinNotEnoughException(String langCode) {
		super(I18nUtil.getMessage(errorCode, null, langCode));
	}

}
