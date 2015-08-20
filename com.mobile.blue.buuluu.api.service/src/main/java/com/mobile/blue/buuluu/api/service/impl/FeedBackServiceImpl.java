package com.mobile.blue.buuluu.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.buuluu.api.dao.FeedBackDao;
import com.mobile.blue.buuluu.api.service.FeedBackService;
import com.mobile.blue.buuluu.model.AppFeedBack;

@Service
public class FeedBackServiceImpl implements FeedBackService{
	
	@Autowired
	private FeedBackDao feedBackDao;

	@Override
	public AppFeedBack feedBack(String userId, String content) {
		return feedBackDao.feedBack(userId,content);
	}

}
