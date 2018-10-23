package org.tsrj.common.contants;

import java.math.BigDecimal;

public class Constants {

	/**
	 * 默认编码
	 */
	public static final String CHARSET_UTF8 = "UTF-8";

	/**
	 * 分隔符
	 */
	public static final String SPLIT = "|";
	
	/**
	 * token
	 */
	public static final String TOKEN = "token";
	
	/**
	 * 用户数据
	 */
	public static final String USER_DATA = "tokenData";
	
	/**
	 * 签名
	 */
	public static final String SIGN = "sign";
	
	/**
	 * 爱家贷token
	 */
	public static final String RRAJD_TOKEN = "token";
	
	
	/**
	 * 分页大小
	 */
	public static final Integer PAGE_SIZE = 20;	
	
	/**
	 * 起始页 
	 * */
	public static final Integer PAGE_NO = 1;	
	
	/**
	 * 状态 启用
	 */
	public static final Short STATUS_ZERO = 0;

	/**
	 * 状态 禁用
	 */
	public static final Short STATUS_ONE = 1;
	
	/***默认SPV用户ID**/
	public static final Long DEFAULT_SPV_USER_ID = 1000008L;
	
	
	/***理财红包**/
	public static final BigDecimal RED_ROCKET = new BigDecimal(888);
	
	/** 体验金*/
//	public static final BigDecimal EXPERIENCE_TICKET = new BigDecimal(8888);
	
	/**返回稳赚计划显示尾单返利的剩余可投限额*/
	public static final BigDecimal PROJECT_SHOW_LAST_RETURN_LIMIT = new BigDecimal(100000);
	public static final BigDecimal CAR_LOAN_SHOW_LAST_RETURN_LIMIT = new BigDecimal(10000);


	/** 精选首页标*/
	public static final String HOT_WORDS = "热卖";
	
	/**
	 * 本次银行卡鉴权未通过，请点击下方按钮再次尝试。如仍未通过，请致电客户400-667-0571，感谢您的支持！
	 */
	public static final String AUTH_BANK_CARD_ERROR_MSG = "本次银行卡鉴权未通过，请点击下方按钮再次尝试。如仍未通过，请致电客户400-667-0571，感谢您的支持！";
	
	public static final BigDecimal ONE_AMOUNT = new BigDecimal(1);
	
	public static final BigDecimal ONE_PLUS_AMOUNT = new BigDecimal(10000);
	
	
	/**
	 * 交易密码长度
	 */
	public static final int PAY_PASSWORD_LENGTH = 6;

	/**
	 * 请求头
	 */
	public static final String API_ACCEPT_VERSION = "accept-version";

	/**
	 * 请求时间
	 */
	public static final String API_REQUEST_TIME = "request-time";

	/**
	 * 设备型号
	 */
	public static final String API_DEVICE = "device";

	/**
	 * 设备类型 1:andriod, 2:ios
	 */
	public static final String API_DEVICE_TYPE = "device-type";
	
	/**
	 * 设备类型:android
	 */
	public static final int API_DEVICE_TYPE_ANDRIOD = 1;
	
	/**
	 * 设备类型:IOS
	 */
	public static final int API_DEVICE_TYPE_IOS = 2;
	
	
	/**
	 * 设备类型:H5(Wap)
	 */
	public static final int API_DEVICE_TYPE_WAP = 4;
	

	/**
	 * 设备序列
	 */
	public static final String API_DEVICE_SERIAL_NUMBER = "device-serial-number";

	/**
	 * 系统版本
	 */
	public static final String APP_VERSION = "app-version";

	/**
	 * 登录ID
	 */
	public static final String API_MEMBER_ID = "login_member_id";

	/**
	 * Token
	 */
	public static final String API_TOKEN = "token";

	/**
	 * 手机号
	 */
	public static final String API_MEMBER_MOBILE = "login_member_mobile";

	/**
	 * 金额格式化 ###,###.00
	 */
	public static final String BIGDECIMAL_FORMAT_01 = "###,###.00";

	/**
	 * 金额格式化 ###.00
	 */
	public static final String BIGDECIMAL_FORMAT_02 = "###.00";

	/**
	 * 金额格式化 0.00
	 */
	public static final String BIGDECIMAL_FORMAT_03 = "0.00";

	/**
	 * 极光registrationId
	 */
	public static final String API_CHANNEL_ID = "channel-id";
	
	/**
	 * 客户机的IP
	 */
	public static final String API_IP = "ip";

}
