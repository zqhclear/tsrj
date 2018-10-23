package org.tsrj.common;

import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tsrj.common.redis.RedisClient;
import org.tsrj.common.redis.RedisKey;
import org.tsrj.common.utils.StrUtils;

public class ConfigUtil {

	Logger logger = LoggerFactory.getLogger(ConfigUtil.class);
	
	private final static ConfigUtil configUtil = new ConfigUtil();

	public static ConfigUtil getInstance() {
		return configUtil;
	}

	private ConfigUtil() {
		
	}

	/**
	 * RSA PrivateKey
	 * 
	 * @return
	 */
	public String getSysEncryptRSAPrivateKey() {
		return getConfig("sys.encrypt.rsa.private.key");
	}

	/**
	 * RSA PublicKey
	 * 
	 * @return
	 */
	public String getSysEncryptRSAPublicKey() {
		return getConfig("sys.encrypt.rsa.public.key");
	}

	/**
	 * MD5
	 * 
	 * @return
	 */
	public String getSysEncryptMD5() {
		return getConfig("sys.encrypt.md5");
	}

	/**
	 * DES
	 * 
	 * @return
	 */
	public String getSysEncryptDES() {
		return getConfig("sys.encrypt.des");
	}

	/**
	 * Redis 端口
	 * 
	 * @return
	 */
	public int getSysRedisPort() {
		return getConfig("sys.redis.port", 3690);
	}

	/**
	 * Redis Ip
	 * 
	 * @return
	 */
	public String getSysRedisIp() {
		return getConfig("sys.redis.ip");
	}

	/**
	 * Redis Pwd
	 * 
	 * @return
	 */
	public String getSysRedisPwd() {
		return getConfig("sys.redis.pwd");
	}

	/**
	 * 文件上传路径
	 */
	public String getFileUploadPath() {
		return getConfig("file.upload.path");
	}
	/**
	 * 文件上传根路径
	 * 
	 * @return
	 */
	public String getUploadFileParentPath() {
		return getConfig("upload.file.parent.path");
	}
	/**
	 * 获得支持上传的文件
	 */
	public String[] getUploadFileExts() {
		return ".jpg,.png,.jpeg".split(",");
	}

	/**
	 * Oss keyId
	 */
	public String getOssAccessKeyId() {
		return getConfig("oss.accessKeyId");
	}

	/**
	 * 七牛图片路径
	 * @return
	 */
	public String getQiNiuImgPath() {
		return getConfig("qi.niu.bucket.img.name");
	}
	/**
	 * Web地址
	 * @return      
	 * String
	 */
	public String getWebUrl() {
		return getConfig("sys.web.url");
	}
	
	/**
	 * Oss keySecret
	 */
	public String getOssAccessKeySecret() {
		return getConfig("oss.accessKeySecret");
	}

	/**
	 * Oss picBucket
	 */
	public String getOssPicBucket() {
		return getConfig("oss.picBucket");
	}
	/**
	 * 是否开发环境
	 * 
	 * @return
	 */
	public boolean isDev() {
		return getConfigAsBool("sys.isDev", true);
	}
	
	/**
	 * CDN图片地址
	 */
	public String getCdnOssUrl() {
		return getConfig("cdn.oss.url");
	}
	
	/**
	 * SMS 服务地址
	 */
	public String getSmsServerURL() {
		return getConfig("sms.server.url");
	}
	
	/**
	 * 用户，一个注册设备注册账户数量
	 */
	public int getMemberRegNumDevice(){
		return getConfig("member.registerDeviceNum", 5);
	}
	
	/**
	 * 用户，IP每天限制获取验证码次数 
	 */
	public int getMemberMobileCodeNumDailyIp(){
		return getConfig("member.mobileCodeNumDailyIp", 50);
	}
	
	/**
	 * 用户，手机验证码过期时间  
	 */
	public int getMemberMobileCodeExpire(){
		return getConfig("member.mobileCodeExpire", 15*60);
	}
	
	/**
	 * RSA PrivateKey
	 * 
	 * @return
	 */
	public String getAjdSysEncryptRSAPrivateKey() {
		return getConfig("","");
	}
	
	/**
	 * RSA PrivateKey
	 * 
	 * @return
	 */
	public String getAjdSysEncryptRSAPublicKey() {
		return getConfig("","");
	}

	/**
	 * 客服ID
	 * @return
	 * int[]
	 */
	public int[] getKefuIds(){
		String ids = getConfig("sys.kefuid");
		if(StrUtils.isNotEmpty(ids)){
			String idsArray[] = StrUtils.split(ids,",");
			int ret[] = new int[idsArray.length];
			StringTokenizer toKenizer = new StringTokenizer(ids, ",");
			int i = 0;
			while (toKenizer.hasMoreElements()) {
				ret[i++] = Integer.valueOf(toKenizer.nextToken());
			}
			return ret;
		}
		int kefuids[] = {23,25,39,48,61,59};
		return kefuids;
	}
	
	/**
	 * 根据Key获得配置
	 * 
	 * @param key
	 * @return
	 */
	public final String getConfig(String key) {
		RedisKey.Key redisKey = RedisKey.Key.SYS_CONFIG;
		return RedisClient.hget(redisKey, key);
	}

	/**
	 * 根据Key获得配置
	 * 
	 * @param key
	 * @return
	 */
	protected final Integer getConfig(String key, int defValue) {
		return new Integer(getConfig(key, "" + defValue));
	}

	/**
	 * 根据Key获得配置
	 * 
	 * @param key
	 * @return
	 */
	protected final String getConfig(String key, String defValue) {
		String configValue = getConfig(key);
		return configValue == null ? defValue : configValue;
	}

	/**
	 * 根据Key获得配置
	 * 
	 * @param key
	 * @return
	 */
	protected final String[] getConfigAsArray(String key) {
		return StrUtils.toArray(getConfig(key));
	}

	/**
	 * 根据Key获得配置
	 * 
	 * @param key
	 * @return
	 */
	protected final String[] getConfigAsArray(String key, String delim) {
		return StrUtils.toArrayByDelim(getConfig(key), delim);
	}

	/**
	 * 根据Key获得配置
	 * 
	 * @param key
	 * @return
	 */
	protected final boolean getConfigAsBool(String key, boolean defValue) {
		return Boolean.parseBoolean(getConfig(key, "" + defValue));
	}

	/**
	 * 根据Key获得配置
	 * 
	 * @param key
	 * @return
	 */
	protected final double getConfigAsDouble(String key, double defValue) {
		return Double.parseDouble(getConfig(key, "" + defValue));
	}
}
