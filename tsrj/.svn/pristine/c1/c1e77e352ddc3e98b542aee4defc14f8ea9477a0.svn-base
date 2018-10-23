package org.tsrj.common.redis;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tsrj.common.ConfigUtil;
import org.tsrj.common.domain.MemberCache;
import org.tsrj.common.domain.ResultBody;
import org.tsrj.common.utils.BeanCopyUtil;
import org.tsrj.common.utils.DateUtils;
import org.tsrj.common.utils.Tools;

public class MemberRedisUtil {
	
	Logger logger = LoggerFactory.getLogger(MemberRedisUtil.class);
	
	/** member对象缓存 */   
	private static final String MEMBER = "member";
	
	/** 用户缓存有效期 */
	private static final int MEMBER_EXPIRE = 60*60*24*30;
	
	/** 手机验证码 */   
	private static final String MOBILECODE = "mobileCode";
	
	/** IP每天限制获取验证码次数 */   
	private static final int MOBILECODE_EVERYDAY_IP_NUM = 50;
	
	/** IP每天限制获取验证码次数KEY */ 
	private static final String MOBILECODE_EVERYDAY_IP_KEY = "everydayIp";
	
	/** 每分钟限制获取验证码次数 */   
	private static final int MOBILECODE_EVERYMINUTE_MOBILE_NUM = 1;
	
	/** 每分钟限制获取验证码次数KEY */ 
	private static final String MOBILECODE_EVERYMINUTE_MOBILE_KEY = "codeNum";
	
	/** 手机验证码过期时间 15分钟 */   
	private static final int MOBILECODE_EXPIRE = 15*60;
	
	/** 手机检验码校验次数 */ 
	private static final String MOBILECODE_Check_KEY = "checkErrorNum";
	
	/** 手机检验码校验次数,不能超过3次 */ 
	private static final int MOBILECODE_Check_NUM = 3;
	
	/** 业务检验错误 */ 
	private static final String BUSINESS_CHECK_ERROR_KEY = "checkErrorNum";
	
	/** 业务检验错误,不能超过5次 */ 
	private static final int BUSINESS_CHECK_ERROR_NUM = 5;
	
	/** 业务授权,确保业务按照业务流执行 */ 
	private static final String BUSINESS_AUTHORIZATION = "businessAuthor";
	
	/** 业务授权,过期时间 15分钟 */   
	private static final int BUSINESS_AUTHORIZATION_EXPIRE = 15*60;
	
	/** 内容记录器 */
	private final static String CODE = "code";
	
	/** 计数器 */
	private final static String COUNTER = "counter";
	
	/** 有效期一分钟 */
	private final static String MINUTE = "minute";
	
	/** 有效期一小时 */
	private final static String HOUR = "hour";
	
	/** 有效期一天 */
	private final static String DAY = "day";
	
	/** 有效期一周 */
	private final static String WEEK = "week";
	
	/** 有效期一月 */
	private final static String MONTH = "month";
	
	/** 不设置有效期 */
	private final static String NOEXPIRE = "noExpire";
	
	/** 每天领取投资礼包的次数 */
	private final static int INVEST_SHARE_GIFT_TIME = 3;
	
	/** 
	 * 校验验证码是否正确
	 * @param businessCode
	 * @param id
	 * @param mobileCode
	 * @return      
	 * ResultBody<String>      
	 */  
	public static ResultBody<String> checkMobileCode(String businessCode, String id, String mobileCode){
		ResultBody<String> result = new ResultBody<String>();
		//校验手机验证码失败次数
		if (!MemberRedisUtil.checkMobileCodeNum(businessCode, id)) {
			result.setResMsg("验证码失效，请重新获取验证码");
			result.setResCode(-1001);
			return result;
		}
		//校验是否发送，或者超时失效
		String loginSMSCode = MemberRedisUtil.getMobileCode(businessCode, id);
		if (loginSMSCode == null) {
			result.setResMsg("验证码错误，请重新获取验证码");
			result.setResCode(-1002);
			return result;
		}
		//校验验证码
		if (!loginSMSCode.equals(mobileCode)) {
			result.setResMsg("验证码错误");
			result.setResCode(-1003);
			MemberRedisUtil.incrCheckMobileCodeNum(businessCode, id);
			return result;
		}
		//删除验证码
		MemberRedisUtil.delMobileCode(businessCode, id);
		//删除校验次数
		MemberRedisUtil.delCheckMobileCodeNum(businessCode, id);
		result.setResCode(1);
		return result;
	}
	
	/**
	 * 自增IP获取验证码的次数，
	 * 用于限制单个IP地址获取验证码的次数(50)
	 * @param ip
	 */
	public static void incrEveryDayCountByIP(String ip) {
		ip = Tools.formatIpToInt(ip);
		String businessCode = MOBILECODE + ":" + MOBILECODE_EVERYDAY_IP_KEY;
		incrCounterDay(businessCode, ip);
	}
	
	/** 
	 * 校验IP获取验证码的次数，
	 * 用于限制单个IP地址获取验证码的次数(1)
	 * @param ip      
	 * void      
	 */  
	public static boolean checkEveryDayCountByIP(String ip) {
		ip = Tools.formatIpToInt(ip);
		String businessCode = MOBILECODE + ":" + MOBILECODE_EVERYDAY_IP_KEY;
		int num = getCounterDay(businessCode, ip);
		if(num >= ConfigUtil.getInstance().getMemberMobileCodeNumDailyIp()){
			return false;
		}
		return true;
	}
	
	/**
	 * 自增mobile获取验证码的次数，
	 * 用于限制单个id每分钟获取验证码的次数
	 * @param businessCode
	 * @param id
	 */
	public static void incrEveryMinuteCountByMobile(String businessCode, String id) {
		businessCode = MOBILECODE + ":" + MOBILECODE_EVERYMINUTE_MOBILE_KEY + ":" + businessCode;
		incrCounterMinute(businessCode, id);
	}
	
	/** 
	 * 校验IP获取验证码的次数，
	 * 用于限制单个id每分钟获取验证码的次数
	 * @param ip      
	 * void      
	 */  
	public static boolean checkEveryMinuteCountByMobile(String businessCode, String id) {
		businessCode = MOBILECODE + ":" + MOBILECODE_EVERYMINUTE_MOBILE_KEY + ":" +businessCode;
		int num = getCounterMinute(businessCode, id);
		if(num >= MOBILECODE_EVERYMINUTE_MOBILE_NUM){
			return false;
		}
		return true;
	}
	
	/** 
	 * 设置用户短信验证码
	 * @param businessCode 业务标识
	 * @param id
	 * @param code      
	 * void      
	 */  
	public static void setMobileCode(String businessCode, String id, String code) {
		businessCode = MOBILECODE + ":" + businessCode;
		setCode(businessCode, id, code, ConfigUtil.getInstance().getMemberMobileCodeExpire());
	}
	
	/** 
	 * 获取用户短信验证码
	 * @param businessCode 业务标识
	 * @param id
	 * @param code      
	 * void      
	 */  
	public static String getMobileCode(String businessCode, String id) {
		businessCode = MOBILECODE + ":" + businessCode;
		return getCode(businessCode, id);
	}
	
	/** 
	 * 删除用户短信验证码
	 * @param businessCode 业务标识
	 * @param id      
	 * void      
	 */  
	public static void delMobileCode(String businessCode, String id){
		businessCode = MOBILECODE + ":" + businessCode;
		delCode(businessCode, id);
	}
	
	/** 
	 * 设置业务授权码
	 * @param businessCode
	 * @param id
	 * @param code      
	 * void      
	 */  
	public static void setBusinessAuthor(String businessCode, String id, String code) {
		businessCode = BUSINESS_AUTHORIZATION + ":" + businessCode;
		setCode(businessCode, id, code, BUSINESS_AUTHORIZATION_EXPIRE);
	}
	
	/** 
	 * 获取业务授权码
	 * @param businessCode
	 * @param id
	 * @return      
	 * String      
	 */  
	public static String getBusinessAuthor(String businessCode, String id) {
		businessCode = BUSINESS_AUTHORIZATION + ":" + businessCode;
		return getCode(businessCode, id);
	}
	
	/** 
	 * 删除业务授权码
	 * @param businessCode
	 * @param id      
	 * void      
	 */  
	public static void delBusinessAuthor(String businessCode, String id){
		businessCode = BUSINESS_AUTHORIZATION + ":" + businessCode;
		delCode(businessCode, id);
	}
	
	/** 
	 * 自增校验码校验次数
	 * @param businessCode 业务标识
	 * @param id
	 * @param code      
	 * void      
	 */  
	public static void incrCheckMobileCodeNum(String businessCode, String id) {
		businessCode = MOBILECODE + ":" + MOBILECODE_Check_KEY + ":" + businessCode;
		incrCounter(businessCode, id, MOBILECODE_EXPIRE);
	}
	
	/** 
	 * 删除校验码校验次数
	 * @param businessCode 业务标识
	 * @param id      
	 * void      
	 */  
	public static void delCheckMobileCodeNum(String businessCode, String id){
		businessCode = MOBILECODE + ":" + MOBILECODE_Check_KEY + ":" + businessCode;
		delCounter(businessCode, id);
	}
	
	/** 
	 * 验证码验证是否超过2次
	 * @param businessCode 业务标识
	 * @param id      
	 * void      
	 * @return 
	 */  
	public static boolean checkMobileCodeNum(String businessCode, String id){
		businessCode = MOBILECODE + ":" + MOBILECODE_Check_KEY + ":" + businessCode;
		int num = getCounter(businessCode, id);
		if(num >= MOBILECODE_Check_NUM){
			return false;
		}
		return true;
	}
	
	/** 
	 * 自增一天校验失败次数
	 * @param businessCode 业务标识
	 * @param id      
	 * void      
	 */  
	public static void incrErrorNumDay(String businessCode, String id) {
		businessCode = BUSINESS_CHECK_ERROR_KEY + ":" + businessCode;
		incrCounterDay(businessCode, id);

	}
	
	/** 
	 * 删除校验失败次数
	 * @param businessCode 业务标识
	 * @param id      
	 * void      
	 */  
	public static void delErrorNumDay(String businessCode, String id){
		businessCode = BUSINESS_CHECK_ERROR_KEY + ":" + businessCode;
		delCounterDay(businessCode, id);
	}
	
	/** 
	 * 检查校验失败次数，不能超过5次
	 * @param businessCode
	 * @param id
	 * @return      
	 * boolean      
	 */  
	public static boolean checkErrorNumDay(String businessCode, String id){
		businessCode = BUSINESS_CHECK_ERROR_KEY + ":" + businessCode;
		int num = getCounterDay(businessCode, id);
		if(num >= BUSINESS_CHECK_ERROR_NUM){
			return false;
		}
		return true;
	}
	
	/** 
	 * 计数器，有效期每分钟
	 */  
	public static void incrCounterMinute(String businessCode, String id){
		businessCode =  MINUTE + ":" + businessCode;
		int seconds = 0;
		int value = getCounter(businessCode, id);
		if(value <= 0){
			seconds = 60;
		}
		incrCounter(businessCode, id, seconds);
	}
	
	/** 
	 * 计数器，有效期每分钟
	 */  
	public static int getCounterMinute(String businessCode, String id){
		businessCode =  MINUTE + ":" + businessCode;
		return getCounter(businessCode, id);
	}
	
	/** 
	 * 计数器，有效期每分钟
	 */  
	public static void delCounterMinute(String businessCode, String id){
		businessCode =  MINUTE + ":" + businessCode;
		delCounter(businessCode, id);
	}
	
	/** 
	 * 计数器，有效期每小时
	 */  
	public static void incrCounterHour(String businessCode, String id){
		businessCode =  HOUR + ":" + businessCode;
		int seconds = 0;
		int value = getCounter(businessCode, id);
		if(value <= 0){
			seconds = 60*60;
		}
		incrCounter(businessCode, id, seconds);
	}
	
	/** 
	 * 计数器，有效期每小时
	 */  
	public static int getCounterHour(String businessCode, String id){
		businessCode =  HOUR + ":" + businessCode;
		return getCounter(businessCode, id);
	}
	
	/** 
	 * 计数器，有效期每小时
	 */  
	public static void delCounterHour(String businessCode, String id){
		businessCode =  HOUR + ":" + businessCode;
		delCounter(businessCode, id);
	}
	
	/** 
	 * 计数器，有效期每天
	 */  
	public static void incrCounterDay(String businessCode, String id){
		businessCode =  DAY + ":" + businessCode;
		int seconds = 0;
		int value = getCounter(businessCode, id);
		if(value <= 0){
			Date currentDate = DateUtils.getCurrentDate();
			seconds = DateUtils.getTimeIntervalSencond(currentDate, DateUtils.getEndTime(currentDate));
		}
		incrCounter(businessCode, id, seconds);
	}
	
	/** 
	 * 计数器，有效期每天
	 */
	public static int getCounterDay(String businessCode, String id){
		businessCode =  DAY + ":" + businessCode;
		return getCounter(businessCode, id);
	}
	
	/** 
	 * 计数器，有效期每天
	 */
	public static void delCounterDay(String businessCode, String id){
		businessCode =  DAY + ":" + businessCode;
		delCounter(businessCode, id);
	}
	
	/** 
	 * 计数器，有效期每周
	 */  
	public static void incrCounterWeek(String businessCode, String id){
		businessCode = WEEK + ":" + businessCode;
		int seconds = 0;
		int value = getCounter(businessCode, id);
		if(value <= 0){
			Date currentDate = DateUtils.getCurrentDate();
			String dateStr = DateUtils.getStringDate(currentDate, "yyyy-MM-dd");
			DateTime date = new DateTime(DateUtils.getDateWithDateStr(dateStr + " 23:59:59", "yyyy-MM-dd HH:mm:ss"));
			seconds = DateUtils.getTimeIntervalSencond(currentDate,
					DateUtils.getEndTimeAddHour(date.plusDays(7 - date.getDayOfWeek()).toDate()));
		}
		incrCounter(businessCode, id, seconds);
	}
	
	/** 
	 * 计数器，有效期每周
	 */
	public static int getCounterWeek(String businessCode, String id){
		businessCode = WEEK + ":" + businessCode;
		return getCounter(businessCode, id);
	}
	
	/** 
	 * 计数器，有效期每周
	 */
	public static void delCounterWeek(String businessCode, String id){
		businessCode = WEEK + ":" + businessCode;
		delCounter(businessCode, id);
	}
	
	/** 
	 * 计数器，有效期每月
	 */
	public static void incrCounterMonth(String businessCode, String id){
		businessCode = MONTH + ":" + businessCode;
		int seconds = 0;
		int value = getCounter(businessCode, id);
		if(value <= 0){
			Date currentDate = DateUtils.getCurrentDate();
			Calendar cale = Calendar.getInstance();
			cale.set(Calendar.DAY_OF_MONTH, cale.getActualMaximum(Calendar.DAY_OF_MONTH));
			String dateStr = DateUtils.getStringDate(cale.getTime(), DateUtils.YYYY_MM_DD);
			DateTime date = new DateTime(DateUtils.getDateWithDateStr(dateStr + " 23:59:59", DateUtils.YYYY_MM_DD_HH_MM_SS));
			seconds = DateUtils.getTimeIntervalSencond(currentDate, date.toDate());
		}
		incrCounter(businessCode, id, seconds);
	}
	
	/** 
	 * 计数器，有效期每月
	 */
	public static int getCounterMonth(String businessCode, String id){
		businessCode =  MONTH + ":" + businessCode;
		return getCounter(businessCode, id);
	}
	
	/** 
	 * 计数器，有效期每月
	 */
	public static void delCounterMonth(String businessCode, String id){
		businessCode =  MONTH + ":" + businessCode;
		delCounter(businessCode, id);
	}
	
	/** 
	 * 计数器，没有有效期
	 */
	public static void incrCounterNoExpire(String businessCode, String id){
		businessCode =  NOEXPIRE + ":" + businessCode;
		int seconds = 0;
		incrCounter(businessCode, id, seconds);
	}
	
	/** 
	 * 计数器，无有效期
	 */
	public static int getCounterNoExpire(String businessCode, String id){
		businessCode =  NOEXPIRE + ":" + businessCode;
		return getCounter(businessCode, id);
	}
	
	/** 
	 * 计数器，无有效期
	 */
	public static void delCounterNoExpire(String businessCode, String id){
		businessCode =  NOEXPIRE + ":" + businessCode;
		delCounter(businessCode, id);
	}
	
	/** 
	 * 自增计数器
	 * @param businessCode
	 * @param id
	 * @param value
	 * @param seconds      
	 * void      
	 */  
	public static void incrCounter(String businessCode, String id, int seconds) {
		StringBuffer keyValue = new StringBuffer();
		keyValue.append(":").append(COUNTER).append(":").append(businessCode).append(":").append(id);
		RedisKey.Key key = RedisKey.Key.MEMBER_INCR;
		key.append(keyValue.toString());
		key.setSeconds(seconds);
		RedisClient.incr(key);
	}
	
	/** 
	 * 获取计数器
	 * @param businessCode
	 * @param id
	 * @return      
	 * int      
	 */  
	public static int getCounter(String businessCode, String id){
		RedisKey.Key key = RedisKey.Key.MEMBER_INCR;
		key.append(":").append(COUNTER).append(":").append(businessCode).append(":").append(id);
		String counts = RedisClient.get(key);
		if (StringUtils.isNumeric(counts)) {
			int c = Integer.valueOf(counts);
			return c;
		}
		return 0;
	}
	
	/** 
	 * 删除计数器
	 * @param businessCode
	 * @param id      
	 * void      
	 */  
	public static void delCounter(String businessCode, String id){
		RedisKey.Key key = RedisKey.Key.MEMBER_INCR;
		key.append(":").append(COUNTER).append(":").append(businessCode).append(":").append(id);
		RedisClient.del(key);
	}
	
	/** 
	 * 设置内容记录器
	 * @param businessCode
	 * @param id
	 * @param value
	 * @param seconds      
	 * void      
	 */  
	public static void setCode(String businessCode, String id, String value, int seconds) {
		RedisKey.Key key = RedisKey.Key.MEMBER_INCR;
		key.append(":").append(CODE).append(":").append(businessCode).append(":").append(id);
		key.setSeconds(seconds);
		RedisClient.set(key, value);
	}
	
	/** 
	 * 获取删除内容记录器
	 * @param businessCode
	 * @param id
	 * @return      
	 * int      
	 */  
	public static String getCode(String businessCode, String id){
		RedisKey.Key key = RedisKey.Key.MEMBER_INCR;
		key.append(":").append(CODE).append(":").append(businessCode).append(":").append(id);
		return RedisClient.get(key);
	}
	
	/** 
	 * 删除内容记录器
	 * @param businessCode
	 * @param id      
	 * void      
	 */  
	public static void delCode(String businessCode, String id){
		RedisKey.Key key = RedisKey.Key.MEMBER_INCR;
		key.append(":").append(CODE).append(":").append(businessCode).append(":").append(id);
		RedisClient.del(key);
	}

	/** 
	 * 缓存用户信息
	 */  
//	public static void setMemberDTO(MemberDTO member){
//		if(member == null || member.getId() != null || member.getId() == 0L){
//			return  ;
//		}
//		RedisKey.Key key = RedisKey.Key.MEMBER_OBJECT;
//		key.append(":").append(MEMBER).append(":").append(member.getId());
//		key.setSeconds(MEMBER_EXPIRE);
//		RedisClient.setObject(key, member);
//	}
	
	/** 
	 * 获取缓存用户信息
	 */ 
//	public static MemberDTO getMemberDTOById(Long memberId){
//		RedisKey.Key key = RedisKey.Key.MEMBER_OBJECT;
//		key.append(":").append(MEMBER).append(":").append(memberId.toString());
//		return RedisClient.getObject(key, MemberDTO.class);
//	}
	
	/** 
	 * 删除缓存用户信息
	 */ 
//	public static void delMemberDTOById(Long memberId){
//		RedisKey.Key key = RedisKey.Key.MEMBER_OBJECT;
//		key.append(":").append(MEMBER).append(":").append(memberId.toString());
//		RedisClient.del(key);
//	}
	
	/** 
	 * 设置member缓存
	 */  
	public static void setMemberCache(Long memberId, Map<String, String> data){
		RedisKey.Key key = RedisKey.Key.MEMBER_HMSET;
		key.append(":").append(MEMBER).append(":").append(memberId.toString());
		RedisClient.hmset(key, data);
	}
	
	/** 
	 * 设置member缓存
	 */  
	public static void setMemberCache(MemberCache memberCache){
		Map<String, String> data = BeanCopyUtil.toTreeMap((memberCache));
		setMemberCache(memberCache.getMemberId(), data);
	}
	
	/** 
	 * 设置member缓存
	 */ 
	public static void setMemberCache(Long memberId, String field, String value){
		RedisKey.Key key = RedisKey.Key.MEMBER_HMSET;
		key.append(":").append(MEMBER).append(":").append(memberId.toString());
		RedisClient.hset(key, field, value);
	}
	
	/** 
	 * 获取member缓存
	 */ 
	public static Map<String, String> getMemberCacheMap(Long memberId){
		RedisKey.Key key = RedisKey.Key.MEMBER_HMSET;
		key.append(":").append(MEMBER).append(":").append(memberId.toString());
		return RedisClient.hgetall(key);
	}

	/** 
	 * 获取member缓存
	 */ 
	public static MemberCache getMemberCache(Long memberId){
		Map<String, String> data = getMemberCacheMap(memberId);
		return BeanCopyUtil.map(data, MemberCache.class);
	}
	
	/** 
	 * 获取member缓存
	 */
	public static String getMemberCache(Long memberId, String field){
		RedisKey.Key key = RedisKey.Key.MEMBER_HMSET;
		key.append(":").append(MEMBER).append(":").append(memberId.toString());
		return RedisClient.hget(key, field);
	}
	
	/** 
	 * 删除member缓存
	 */
	public static long delMemberCache(Long memberId){
		RedisKey.Key key = RedisKey.Key.MEMBER_HMSET;
		key.append(":").append(MEMBER).append(":").append(memberId.toString());
		return RedisClient.del(key);
	}
	
	/** 
	 * 删除member缓存
	 */
	public static long delMemberCache(Long memberId, String ...fields){
		RedisKey.Key key = RedisKey.Key.MEMBER_HMSET;
		key.append(":").append(MEMBER).append(":").append(memberId.toString());
		return RedisClient.hdel(key, fields);
	}
	
	/** 
	 *  检查领取礼包次数
	 */  
	public static boolean checkGetGiftTimeDay(String iNVEST_SHARE_GIFT, Long memberId) {
		int counterDay = MemberRedisUtil.getCounterDay(iNVEST_SHARE_GIFT, memberId.toString());
		if (counterDay >= INVEST_SHARE_GIFT_TIME) {
			return true;
		}
		return false;
	}
	
}
