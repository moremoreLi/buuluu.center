/**
 * This class has been generated by Fast Code Eclipse Plugin 
 * For more information please go to http://fast-code.sourceforge.net/
 * @author : lenovo
 * Created : 11/14/2013
 */

package com.user.buuluu.service.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.user.buuluu.common.util.Constant;
import com.user.buuluu.common.util.DateUtil;
import com.user.buuluu.dao.mapper.AppUserBillLogMapper;
import com.user.buuluu.dao.mapper.AppUserBillMapper;
import com.user.buuluu.dao.model.AppRandModel;
import com.user.buuluu.model.AdVideoWithBLOBs;
import com.user.buuluu.model.AppInfoWithBLOBs;
import com.user.buuluu.model.AppUserBill;
import com.user.buuluu.model.AppUserBillLog;
import com.user.buuluu.service.SourceService;


public class APITestServiceImplTest{

//	private UserService userService;
	private SourceService sourceService;
	
	@Autowired
	private AppUserBillLogMapper appUserBillLogMapper;
	
	@Autowired
	private AppUserBillMapper appUserBillMapper;
	
     
         /**
	      * 这个before方法在所有的测试方法之前执行，并且只执行一次
	      * 所有做Junit单元测试时一些初始化工作可以在这个方法里面进行
	      * 比如在before方法里面初始化ApplicationContext和userService
	      */
	     @Before
	     public void before(){
	         //使用"spring.xml"和"spring-mybatis.xml"这两个配置文件创建Spring上下文
	         ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"application-context.xml"});
	         //从Spring容器中根据bean的id取出我们要使用的userService对象
//	         userService = (UserService) ac.getBean("userService");
	         sourceService = (SourceService) ac.getBean("sourceService");
	         appUserBillLogMapper =(AppUserBillLogMapper) ac.getBean("appUserBillLogMapper");
	         appUserBillMapper =(AppUserBillMapper) ac.getBean("appUserBillMapper");
	     }
	     
//	     @Test
	     public void testAddUser(){
	         //ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
	        //UserServiceI userService = (UserServiceI) ac.getBean("userService");
//	         User user = new User();
//	         user.setId(Constant.getUserId());
//	         user.setBirthday("123213");
//	         user.setCountry("12121212");
//	         userService.addUser(user,user.getId());
	    	 Map<String,Object> map = new HashMap<String, Object>();
	    	 map.put("orderStr", "rand()");
				map.put("limitStr", "0,3");
				/*map.put("classid", 1);
				   map.put("categoryId", 1);
				   List<AppInfoModel> source = sourceService.getAppList(map);
				   for (AppInfoModel appInfoModel : source) {
					System.out.println(appInfoModel.getClassName());
//					System.out.println(appInfoModel.getAppInfoWithBLOBs());
					System.out.println(appInfoModel.getAppInfoWithBLOBs().getAuthor());
				}*/
				List<AdVideoWithBLOBs> sourceMap = sourceService.getVideoList(map,Constant.getUserId()+Constant.getSessionId());
				for (AdVideoWithBLOBs adVideoWithBLOBs : sourceMap) {
					System.out.println(adVideoWithBLOBs.getTitle());
				}
	     }
	     
//	     @Test
	     public void testFlow(){
	     List<AppRandModel> list = sourceService.getRandForVideo(5,Constant.getUserId()+5);
	     for (AppRandModel appVideoRandModel : list) {
			System.out.println(appVideoRandModel.getMakeFlows());
		}
	     }
	     
//	     @Test
	     public void testFlow1(){
		     List<AppRandModel> list = sourceService.getRandForApp(5,Constant.getUserId()+5);
		     for (AppRandModel appVideoRandModel : list) {
				System.out.println(appVideoRandModel.getMakeFlows());
				System.out.println(appVideoRandModel.getIcon());
			}
		     }
	     
//	     @Test
	     public void getVideo(){
	    	 AppInfoWithBLOBs video = sourceService.getAppDetail(7,7+Constant.getSessionId());
	    	 System.out.println(video.getAuthor());
	    	 System.out.println(video.getDownloadurl());
		     }
	     
//	     @Test
	     public void checkBill(){
	    	 Map<String,Object> map = new HashMap<String, Object>();
	    	 String userId ="0ab84f9a46234195952ca20c4b70e925";
	    	 int sourceId=80;
	    	 int type =1;
	    	 map.put("userId", userId);
	 		map.put("sourceId", sourceId);
	 		map.put("type", type);
	 		String key = userId+Constant.SPLITE_STRING+sourceId+Constant.SPLITE_STRING+type;
	    	 AppUserBill list = sourceService.checkBill(map, key);
	    	 if (list!=null) {
				System.out.println("successs");
			}else {
				System.out.println("fail");
			}
	     }
	     
	     @Test
	     public void getBillLog(){
	    	 AppUserBill appUserBill = new AppUserBill();
	    	 appUserBill.setId(32L);
	    	 appUserBill.setStatus(1);
	    	 appUserBill.setUpdatedBy(Constant.UPDATE_BY_API);
	    	 appUserBill.setUpdatedTime(DateUtil.getCurrentDate());
	    	 appUserBillMapper.updateBillById(appUserBill);
	     }
}
