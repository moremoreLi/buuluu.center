package com.user.buuluu.service;

import java.util.List;

import com.user.buuluu.model.AppBuuluuUser;
import com.user.buuluu.model.AppScratch;
import com.user.buuluu.model.AppUserScratch;
import com.user.buuluu.service.model.AppUserScratchModel;

public interface ScratchService {

	List<AppUserScratch> getUserScratch(String userId, Integer type);

	List<AppUserScratchModel> getScratchNews(int i,String cache);

	AppScratch getScratchCoins(Integer scratchId,String cache);

	int addUserScratch(AppBuuluuUser user, AppScratch appScratch, String string,
			int i, Float returnFloat,String cache);

	List<AppUserScratch> getScratchList(String cache);

}
