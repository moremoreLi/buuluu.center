package com.mobile.blue.buuluu.api.util;

import com.google.gson.Gson;
import com.mobile.blue.buuluu.api.web.view.ResultVO;

public class ResultUtil {

	public static String getResultJson(Object object) {
		ResultVO<Object> resultVo = new ResultVO<Object>();
		resultVo.setResult(object);
		Gson json = new Gson();
		return json.toJson(resultVo);
	}

	public static String getResultJson(String status, String errorMessage)  {
		ResultVO<Object> resultVo = new ResultVO<Object>();
		
		resultVo.setStatus(status);
		resultVo.setErrorMessage(errorMessage);
		
		Gson json = new Gson();
		return json.toJson(resultVo);
    }
	
	public static String getResultJson(Object object,String status, String errorMessage) {
		ResultVO<Object> resultVo = new ResultVO<Object>();
		resultVo.setResult(object);
		resultVo.setStatus(status);
		resultVo.setErrorMessage(errorMessage);
		Gson json = new Gson();
		return json.toJson(resultVo);
	}
	
	public static String getSeqNumResultJson(Object object,String seqNum) {
		ResultVO<Object> resultVo = new ResultVO<Object>();
		resultVo.setResult(object);
		Gson json = new Gson();
		return json.toJson(resultVo);
	}

}
