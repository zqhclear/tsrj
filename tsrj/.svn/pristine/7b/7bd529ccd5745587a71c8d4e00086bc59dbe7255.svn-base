package org.tsrj.common.sms;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tsrj.common.ConfigUtil;
import org.tsrj.common.httpclient.HttpClientUtil;
import org.tsrj.common.httpclient.httpclient.builder.HCB;
import org.tsrj.common.httpclient.httpclient.common.HttpConfig;
import org.tsrj.common.message.SendMessageBiz;
import org.tsrj.common.utils.StrUtils;

/**
 * 短信发送服务
 *
 */
public class SmsService {
	
	private static Logger logger = LoggerFactory.getLogger(SmsService.class);
	
	/**
	 * 发送短信
	 * @param content
	 * @param mobile
	 * @return
	 */
	public static void sendSmsToSingle(String content, String mobile){
		try{
			sendSMS(content, mobile, false);
		}catch(Exception ex){
			logger.error("短信发送失败{}, {}", content, mobile);
		}
	}
	
	public static void sendMarketingSms(String content, String mobile){
		try{
			sendSMS(content, mobile, true);
		}catch(Exception ex){
			logger.error("短信发送失败{}, {}", content, mobile);
		}
	}
	
	
	/**
	 * 指定多少秒后发送短信
	 * @param content
	 * @param mobile
	 * @param delaySeconds 延时秒数
	 */
	public static void sendMarketingSms(final String content, final String mobile, final int delaySeconds){
		if(delaySeconds<=0){
			try{
				sendSMS(content, mobile, true);
			}catch(Exception ex){
				logger.error("短信发送失败{}, {}", content, mobile);
			}
		}else{
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(delaySeconds * 1000);
						sendSMS(content, mobile, true);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
	
	/**
	 * 发送自定义消息用户
	 * 服务接口方最大支持5000
	 * @param content
	 * @param mobile
	 * @return
	 */
	public static void sendSmsToCustomMember(String content, String[] mobiles){
		if (mobiles != null && mobiles.length > 0) {
			StringBuffer mob = new StringBuffer();
			for (int i = 0; i < mobiles.length; i++) {
				if (mobiles[i].length() == 11) {
					mob.append(mobiles[i]);
					mob.append(",");
				}
			}
			if (mob.length() > 0) {
				String _mobiles = mob.substring(0, mob.length() - 1);
				sendSMS(content, _mobiles, true);
			}
		}
	}
	
	

	/**
	 * 发送自定义消息用户
	 * 服务接口方最大支持5000
	 * @param content
	 * @param mobile
	 * @return
	 */
	public static void sendSmsToCustomMember(String content, List<String> mobiles){
		if (mobiles != null) {
			StringBuffer mob = new StringBuffer();
			for (String str : mobiles) {
				mob.append(str);
				mob.append(",");
			}
			if (mob.length() > 0) {
				String _mobiles = mob.substring(0, mob.length() - 1);
				sendSMS(content, _mobiles, true);
			}
		}
	}
	
	
	/**
	 * 发送短信
	 * @param content
	 * @param mobile
	 */
	private static void sendSMS(String content, String mobile, boolean isMarketing){
		try{
			if(!ConfigUtil.getInstance().isDev()){
				String result = HttpClientUtil.get(HttpConfig.custom().client(HCB.custom().timeout(10000).build()).url(getSMSBody(content, mobile, isMarketing)));
				logger.info("手机号：{},短信发送内容：{}, 发送结果{}", mobile, content, result);
			}else{
				logger.info("短信发送内容：{},发送手机号{}", content, mobile);
			}
		}catch(Exception ex){
			logger.error("短信发送失败：{},{}", content, mobile, ex);
		}
	}
	
	
	/**
	 * 发送消息内容
	 * @param content
	 * @param mobile
	 * @return
	 */
	private static String getSMSBody(String content, String mobile, boolean isMarketing){
		String url = null;
		if(isMarketing){
			url = "https://sapi.253.com/msg/HttpBatchSendSM?account=kmjr2016&pswd=Txb123456&needstatus=false&product=&extno=";
		}else{
			url = ConfigUtil.getInstance().getSmsServerURL();
		}
		StringBuffer sb = new StringBuffer();
		sb.append(url).append("&mobile=").append(mobile).append("&msg=").append(StrUtils.encodeUTF(content));
		return sb.toString();
	}
	
	/**
	 * 发送消息内容
	 * @param content
	 * @param mobile
	 * @return
	 */
	private static String getSMSBodyByNew(String content, String mobile, boolean isMarketing){
		String url = null;
		if(isMarketing){
			url = "http://sms.253.com/msg/send/?un=M7813217&pw=p7Db4PCBlAf824&rd=0";
		}else{
			url = "http://sms.253.com/msg/send/?un=N5211761&pw=9ygleR2OkY5bbc&rd=0";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(url).append("&phone=").append(mobile).append("&msg=【人人爱家金融】").append(StrUtils.encodeUTF(content));
		return sb.toString();
	}

	/**
	 * 发送语音验证码
	 * @param content
	 * @param mobile
	 */
	public static void sendVoiceMsg(String content, String mobile){
		try{
			String result = HttpClientUtil.get(HttpConfig.custom().url(getVoiceSMSBody(content, mobile)));
			logger.info("语音验证码：手机号：{},信发送内容：{}, 发送结果{}", mobile, content, result);
		}catch(Exception ex){
			logger.error("语音验证码发送失败：{},{}", content, mobile, ex);
		}
	}
	
	
	/**
	 * 发送消息内容
	 * @param content
	 * @param mobile
	 * @return
	 */
	private static String getVoiceSMSBody(String content, String mobile){
		String url = "https://sapi.253.com/msg/HttpBatchSendSM?account=yuyin-clcs-08&pswd=YUyin2015&needstatus=false&product=&extno=";
		if(!ConfigUtil.getInstance().isDev()){
			url = "https://sapi.253.com/msg/HttpBatchSendSM?account=kmjr2017&pswd=Tch850797&needstatus=false&product=&extno=";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(url).append("&mobile=").append(mobile).append("&msg=").append(StrUtils.encodeUTF(content));
		return sb.toString();
	}
	
	/**
	 * 发送消息
	 * @param sendMessageBiz
	 */
	public static void sendMessage(SendMessageBiz sendMessageBiz){
		sendMarketingSms(sendMessageBiz.getContent(), sendMessageBiz.getMobile());
	}
	
	public static void main(String[] args) {
		sendSmsToCustomMember("hello", new String[]{"15968192937"});
	}
}
