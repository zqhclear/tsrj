package org.tsrj.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tsrj.common.ConfigUtil;

import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.model.ObjectMetadata;

/**
 * 阿里云文件上传工具
 * @author Administrator
 *
 */
public class OSSUtil {
	/**
	 * 日志对象
	 */
	private static Logger logger = LoggerFactory.getLogger(OSSUtil.class);
	
	/**
	 * 将附件上传到阿里云oss
	 * @param key 文件目录，可通过ossutil的getkey获取不同类型的key值
	 * @param content 需要上传的流
	 * @param expiration（可空） 失效的时间，如要到2099-10-01失效，则传2099-10-01的date格式日期
	 * @return 返回的文件url，包含完整url
	 */
	public static String uploadAttachmentToOSS(String key, InputStream content, Date expiration, String bucketName) {
		try {
			// 初始化一个OSSClient
			OSSClient client = new OSSClient(ConfigUtil.getInstance().getOssAccessKeyId(), ConfigUtil.getInstance().getOssAccessKeySecret());
			// 创建上传Object的Metadata
			ObjectMetadata meta = new ObjectMetadata();
			// 必须设置ContentLength
			meta.setContentLength(content.available());
			client.putObject(bucketName, key, content,meta);
			if(expiration==null) {
				expiration = DateUtils.formatDate(DateUtils.addDate(new Date(), 36500), "yyyy-MM-dd HH:mm:ss");
			}
			// 生成URL
			URL url = client.generatePresignedUrl(ConfigUtil.getInstance().getOssPicBucket(), key, expiration);
			return url.toString();
		} catch (IOException e) {
			logger.error("将附件上传到阿里云OSS出错, key = " + key, e);
		}
		return null;
	}
	

	/**
	 * 
	 * @param key 文件目录，可通过ossutil的getkey获取不同类型的key值
	 * @param filePath 需要上传的文件名
	 * @return 返回的文件url，包含完整url
	 */
	public static String uploadImageToOSS(String key, String filePath) {
		return uploadImageToOSS(key, filePath, null);
	}
	
	/**
	 * 
	 * @param key 文件目录，可通过ossutil的getkey获取不同类型的key值
	 * @param filePath 需要上传的文件名
	 * @param expiration （可空） 失效的时间，如要到2099-10-01失效，则传2099-10-01的date格式日期
	 * @return 返回的文件url，包含完整url
	 */
	public static String uploadImageToOSS(String key, String filePath, Date expiration) {
		try {
			File file = new File(filePath);
			InputStream content = new FileInputStream(file);
			return uploadAttachmentToOSS(key, content, expiration, ConfigUtil.getInstance().getOssPicBucket());
		} catch (IOException e) {
			logger.error("将附件上传到阿里云OSS出错, key = " + key, e);
		}
		return null;
	}
	
	/**
	 * 详情请看 {#link {@link #uploadImageToOSS(String, String, Date)}}
	 * @param key
	 * @param file
	 * @param expiration
	 * @return
	 */
	public static String uploadImageToOSS(String key, File file) {
		return uploadImageToOSS(key, file, null);
	}
	
	/**
	 * 详情请看 {#link {@link #uploadImageToOSS(String, String, Date)}}
	 * @param key
	 * @param file
	 * @param expiration
	 * @return
	 */
	public static String uploadImageToOSS(String key, File file, Date expiration) {
		try {
			InputStream content = new FileInputStream(file);
			return uploadAttachmentToOSS(key, content, expiration, ConfigUtil.getInstance().getOssPicBucket());
		} catch (IOException e) {
			logger.error("将附件上传到阿里云OSS出错, key = " + key, e);
		}
		return null;
	}

	
	/**
	 * 获取不包含前缀的url路径，用于存储到附件表
	 * @param url
	 */
	public static String getSimpleImageUrl(String url) {
		String tmpUrl = url.substring(url.indexOf(ConfigUtil.getInstance().getOssPicBucket())+ConfigUtil.getInstance().getOssPicBucket().length());
		return tmpUrl.substring(0, tmpUrl.indexOf("?"));
	}
	
	/**
	 * 获取包含前缀的url路径，用于页面展示
	 * @param url
	 */
	public static String getFullImageUrl(String simpleUrl) {
		return ConfigUtil.getInstance().getOssPicBucket()+simpleUrl;
	}
	
	
	public static void main(String[] args) throws Exception {
		
	}
}
