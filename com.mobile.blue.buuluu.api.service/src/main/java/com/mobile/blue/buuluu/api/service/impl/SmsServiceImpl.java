package com.mobile.blue.buuluu.api.service.impl;

import org.springframework.stereotype.Service;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.service.SmsService;

@Service
public class SmsServiceImpl extends Context implements SmsService {

	@Override
	public boolean sendSMS(String smsDomain, String countryCode, String tel,String msg) {
		return true;
		
	}
	
}