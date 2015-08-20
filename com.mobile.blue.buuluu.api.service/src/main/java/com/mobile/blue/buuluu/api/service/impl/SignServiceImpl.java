package com.mobile.blue.buuluu.api.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mobile.blue.buuluu.api.common.Context;
import com.mobile.blue.buuluu.api.common.exception.BaseAPIException;
import com.mobile.blue.buuluu.api.common.exception.SignExistException;
import com.mobile.blue.buuluu.api.common.util.Constant;
import com.mobile.blue.buuluu.api.common.util.DateUtil;
import com.mobile.blue.buuluu.api.dao.SignDao;
import com.mobile.blue.buuluu.api.dao.UserDao;
import com.mobile.blue.buuluu.api.service.SignService;
import com.mobile.blue.buuluu.model.AppUser;
import com.mobile.blue.buuluu.model.AppUserSign;

@Service
public class SignServiceImpl extends Context implements SignService {
	
	@Autowired
	private SignDao signDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public AppUserSign addSign(AppUser user) throws SQLException {
		String userId = user.getId().toString();
		AppUserSign appUserSign = signDao.getSign(userId);
		
		if (appUserSign!=null) 
			throw new SignExistException(null);
		
		
		 appUserSign =signDao.addSign(userId);
		
		if (appUserSign==null) 
			throw new BaseAPIException();
		
		user.setPoint(user.getPoint()+Constant.USER_SING_CREDIT);
		user.setUpdatedBy(Constant.UPDATE_BY_API);
		
		if (!userDao.upate(user)) 
			throw new BaseAPIException();
		

		return appUserSign;
	}

	@Override
	public List<String> getSignList(String userId) {
		return signDao.getSignList(userId);
	}
	

}
