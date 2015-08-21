package com.user.buuluu.util;

import com.user.buuluu.common.util.Json;
import com.user.buuluu.web.view.ResultVO;

public class ResultUtil {

	public static String getResultJson(Object object) {
		ResultVO<Object> resultVo = new ResultVO<Object>();
		resultVo.setResult(object);
		return Json.toJson(resultVo);
	}

	public static String getResultJson(int errorCode, String errorMessage)  {
		ResultVO<Object> resultVo = new ResultVO<Object>();
		
		resultVo.setErrorCode(errorCode);
		resultVo.setErrorMessage(errorMessage);
		
		return Json.toJson(resultVo);
    }
	
	public static String getResultJson(Object object,int errorCode, String errorMessage) {
		ResultVO<Object> resultVo = new ResultVO<Object>();
		resultVo.setResult(object);
		resultVo.setErrorCode(errorCode);
		resultVo.setErrorMessage(errorMessage);
		return Json.toJson(resultVo);
	}
	
	public static String getSeqNumResultJson(Object object,String seqNum) {
		ResultVO<Object> resultVo = new ResultVO<Object>();
		resultVo.setResult(object);
		return Json.toJson(resultVo);
	}

}
