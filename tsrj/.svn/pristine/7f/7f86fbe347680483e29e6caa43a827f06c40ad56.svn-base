package org.tsrj.common.encrypt;

import org.apache.commons.codec.digest.DigestUtils;
import org.tsrj.common.contants.Constants;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;


/**
 * 
 * @author xiaohaizi
 * @date 2017年3月7日 下午5:18:06   
 *
 */
public class MD5 {

	/**
	 * 签名字符串
	 *
	 * @param text
	 *            需要签名的字符串
	 * @param key
	 *            密钥
	 * @param charset
	 *            编码格式
	 * @return 签名结果
	 */
	public static String sign(String text, String key, String charset) throws Exception {
		text = text + key;
		return DigestUtils.md5Hex(getContentBytes(text, charset));
	}
	
	/**
	 * 签名字符串
	 *
	 * @param text
	 *            需要签名的字符串
	 * @return 签名结果
	 */
	public static String sign(String text) throws Exception {
		return DigestUtils.md5Hex(getContentBytes(text, Constants.CHARSET_UTF8));
	}

	/**
	 * 密码加密
	 * 
	 * @param pwd
	 * @param salt
	 * @param key
	 * @return
	 */
	public static String encrypt(String pwd, String salt, String key) {
		pwd = pwd + salt + key;
		return DigestUtils.md5Hex(getContentBytes(pwd, Constants.CHARSET_UTF8));
	}

	/**
	 * 签名字符串
	 *
	 * @param text
	 *            需要签名的字符串
	 * @param sign
	 *            签名结果
	 * @param key
	 *            密钥
	 * @param charset
	 *            编码格式
	 * @return 签名结果
	 */
	public static boolean verify(String text, String sign, String key, String charset) throws Exception {
		text = text + key;
		String mysign = DigestUtils.md5Hex(getContentBytes(text, charset));
		return mysign.equals(sign);
	}

	private static byte[] getContentBytes(String content, String charset) {
		if (charset == null || charset.isEmpty()) {
			return content.getBytes();
		}
		try {
			return content.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
		}
	}

	/**
	 * md5加密
	 */
	public static String md5(String inStr) {
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++) {
			byteArray[i] = (byte) charArray[i];
		}
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuilder hexValue = new StringBuilder();
		for (byte md5Byte : md5Bytes) {
			int val = ((int) md5Byte) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();

	}

	/**
	 * 密码加密16位
	 * 
	 * @param pwd
	 * @param salt
	 * @param key
	 * @return
	 */
	public static String encrypt16(String uid, String key) {
		uid = uid + key;
		return DigestUtils.md5Hex(getContentBytes(uid, "UTF-8")).substring(8, 24);
	}
	
	public static void main(String[] args) {
		System.out.println(md5("67568479"));
	}
}
