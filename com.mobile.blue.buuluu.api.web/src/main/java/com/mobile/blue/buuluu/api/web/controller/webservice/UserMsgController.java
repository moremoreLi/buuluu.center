package com.mobile.blue.buuluu.api.web.controller.webservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mobile.blue.buuluu.api.common.util.PropertiesUtil;
import com.mobile.blue.buuluu.api.service.SnsAccountService;
import com.mobile.blue.buuluu.api.service.UserService;
import com.mobile.blue.buuluu.api.util.ResultUtil;
import com.mobile.blue.buuluu.api.web.handler.UserHandler;
import com.mobile.blue.buuluu.api.web.view.InviteFriendVO;
import com.mobile.blue.buuluu.api.web.view.MsgDetailVO;
import com.mobile.blue.buuluu.api.web.view.MsgVO;

/**
 * 
 * @author More
 * 邀请和消息接口的开发
 * 2015.8.4
 *
 */
@Controller
public class UserMsgController {

	private Log log = LogFactory.getLog(this.getClass());


	@Autowired
	private SnsAccountService snsAccountService;

	@Autowired
	private UserHandler userHandler;
	
	@Autowired
	private UserService userService;
	
	private static final String LOCAL_SERVER= PropertiesUtil.getProperty("LOCAL_SERVER");
	
	/**
	 *  邀请朋友的接口
	 * @param request
	 * @param model
	   @param lang  返回的语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param imsi   用户SIM卡号(没有时为”00000000”)
	 * @param countryCode  手机电话号码的国家编号
	 * @param tel  手机电话号码的国家编号
	 * @param userId   用户ID
	 * @param token  用户token
	 * @param countryCode  发送的电话号码的国家编号
	 * @param tel  发送的电话号码
	 * @param email  发送的邮件
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/inviteFriend.do",method=RequestMethod.POST)
	public  String inviteFriend(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String userId, String token,String countryCode,String tel,String email) throws Exception {
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId, null);
		Assert.hasText(token, null);
		String jsonStr = null;
		
		InviteFriendVO vo = new InviteFriendVO();
		vo.setActCode(getActCode(8));
		vo.setDetailUrl("www.baidu.com");
		vo.setFreeFlows(0.2f);
		vo.setMsg("获取50M的buuluu流量币。");
		vo.setReigisterUrl("http://58.96.173.140:12345/bapp.php");
		jsonStr = ResultUtil.getResultJson(vo);
		model.put("message", jsonStr);
		return "message.json";
	}
	
	
	/**
	 *  接受消息的接口
	 * @param request
	 * @param model
	   @param lang  返回的语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param imsi   用户SIM卡号(没有时为”00000000”)
	 * @param countryCode  手机电话号码的国家编号
	 * @param tel  手机电话号码的国家编号
	 * @param userId   用户ID
	 * @param token  用户token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/receiverMsg.do",method=RequestMethod.POST)
	public  String receiverMsg(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String userId, String token) throws Exception {
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId, null);
		Assert.hasText(token, null);
		String jsonStr = null;
		
		List<MsgVO> list = new ArrayList<MsgVO>();
		MsgVO vo = new MsgVO();
		vo.setCreateTime(System.currentTimeMillis());
		vo.setIcon(LOCAL_SERVER+"20150804182731.png");
		vo.setInfo("爱音乐约‘Pao’神器免费领！还有150M流量等你拿！数量不多想要下手的同学速度啦！戳开马上有。");
		vo.setName("爱音乐");
		vo.setTypeId(110);
		vo.setUnreadCount(1);
		
		MsgVO vo1 = new MsgVO();
		vo1.setCreateTime(System.currentTimeMillis());
		vo1.setIcon(LOCAL_SERVER+"20150804182816.png");
		vo1.setInfo("天翼阅读60牛任性送！还有三星Galaxy免费抽！参与订购送百万牛币活动，即送会员特权带你畅游书海。");
		vo1.setName("天翼阅读");
		vo1.setTypeId(111);
		vo1.setUnreadCount(2);
		
		MsgVO vo2 = new MsgVO();
		vo2.setCreateTime(System.currentTimeMillis());
		vo2.setIcon(LOCAL_SERVER+"20150804182925.png");
		vo2.setInfo("美悦优选福利疯狂来袭，送流量再送代金劵！注册并关注美悦优选即可参与抽奖，百分百中奖！速度戳开。");
		vo2.setName("美悦优选");
		vo2.setTypeId(112);
		vo2.setUnreadCount(3);
		
		list.add(vo2);
		list.add(vo1);
		list.add(vo);
		jsonStr = ResultUtil.getResultJson(list);
		model.put("message", jsonStr);
		return "message.json";
	}
	
	/**
	 *  接受消息详情的接口
	 * @param request
	 * @param model
	   @param lang  返回的语言类型
	 * @param device  设备类型，1是IOS，2是AOS
	 * @param deviceVerNum  App版本的控制，如1.0.0
	 * @param imei  用户标识码(没有时为” 00000000”)
	 * @param mac   用户mac地址
	 * @param imsi   用户SIM卡号(没有时为”00000000”)
	 * @param countryCode  手机电话号码的国家编号
	 * @param tel  手机电话号码的国家编号
	 * @param userId   用户ID
	 * @param token  用户token
	 * @param typeId  消息id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/receiverMsgDetail.do",method=RequestMethod.POST)
	public  String receiverMsgDetail(HttpServletRequest request, ModelMap model, String lang, Integer device,String deviceVerNum,
			String imei,String mac,String imsi , String userId, String token,Integer typeId) throws Exception {
		Assert.hasText(lang, null);
		Assert.notNull(device,null);
		Assert.hasText(deviceVerNum, null);
		Assert.hasText(imei, null);
		Assert.hasText(mac, null);
		Assert.hasText(imsi,null);
		Assert.hasText(userId, null);
		Assert.hasText(token, null);
		Assert.notNull(typeId,null);
		String jsonStr = null;
		
		List<MsgDetailVO> list = new ArrayList<MsgDetailVO>();
		for (int i = 0; i < 3; i++) {
			MsgDetailVO vo = new MsgDetailVO();
			vo.setCreateTime(System.currentTimeMillis()-(i+1)*1000);
			if (i==0) {
				if (typeId==110) {
					vo.setInfo("爱音乐约‘Pao’神器免费领！还有150M流量等你拿！数量不多想要下手的同学速度啦！戳开马上有。");
				}else if (typeId==111) {
					vo.setInfo("天翼阅读60牛任性送！还有三星Galaxy免费抽！参与订购送百万牛币活动，即送会员特权带你畅游书海。");
				}else if (typeId==112) {
					vo.setInfo("美悦优选福利疯狂来袭，送流量再送代金劵！注册并关注美悦优选即可参与抽奖，百分百中奖！速度戳开。");
				}
				
			}else if (i==1) {
               if (typeId==110) {
            	   vo.setInfo("这是一个史上最虐狗的薪资测评！爱音乐薪酬PK百分百有奖哦！你敢来测吗？速度查看史上最虐狗的评测报告吧！");
				}else if (typeId==111) {
					vo.setInfo("股票狂跌也不怕，天翼阅读帮你补牛气！参与活动即送60牛，每月最高获270牛，这个夏日助你牛气冲天！");
				}
			}else {
               if (typeId==110) {
            	   vo.setInfo("爱音乐流量狂欢节N多好礼送不停！即日起挑战闯关游戏连闯三关即有机会赢取IpadMini等海量流量！速度来战！");
				}
			}
			
			vo.setReadFlag(false);
			list.add(vo);
		}
		
		jsonStr = ResultUtil.getResultJson(list);
		model.put("message", jsonStr);
		return "message.json";
	}
	//发送短息和邮件产生的校验码
	private String getActCode(int length) {
		Random rd = new Random(); // 创建随机对象
        String n = "";            //保存随机数
        int rdGet; // 取得随机数
        do {
            if (rd.nextInt() % 2 == 1) {
            rdGet = Math.abs(rd.nextInt()) % 10 + 48; // 产生48到57的随机数(0-9的键位值)
           } else
           {
             rdGet = Math.abs(rd.nextInt()) % 26 + 97; // 产生97到122的随机数(a-z的键位值)
           }
        char num1 = (char) rdGet;            //int转换char
        String dd = Character.toString(num1);
        n += dd;
             } while (n.length() < length);// 设定长度，此处假定长度小于8
        
        return n;
	}
	
	
}
