package com.mobile.blue.buuluu.api.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.dao.FeedBackDao;
import com.mobile.blue.buuluu.api.dao.mysql.FeedBackDaoMysql;
import com.mobile.blue.buuluu.model.AppFeedBack;

@Repository
public class FeedBackDaoImpl implements FeedBackDao{
	
	@Autowired
	private FeedBackDaoMysql feedBackDaoMysql;

	@Override
	public AppFeedBack feedBack(String userId, String content) {
		return feedBackDaoMysql.feedBack(userId,content);
	}

}
