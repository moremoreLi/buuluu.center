package com.mobile.blue.buuluu.api.dao.mysql;

import org.springframework.stereotype.Repository;

import com.mobile.blue.buuluu.api.common.util.Constant;
import com.mobile.blue.buuluu.api.common.util.DateUtil;
import com.mobile.blue.buuluu.model.AppFeedBack;
/**
 * 用户反馈
 * @author More
 *2015-7-23
 */
@Repository
public class FeedBackDaoMysql extends AbstractBaseDaoMysql<AppFeedBack>{


	public AppFeedBack feedBack(String userId, String content) {
		AppFeedBack feedBack = new AppFeedBack();
		feedBack.setUserId(userId);
		feedBack.setContent(content);
		feedBack.setCreatedBy(Constant.CREATE_BY_API);
		feedBack.setCreatedTime(DateUtil.getCurrentDate());
		return super.add(feedBack);
	}

}
