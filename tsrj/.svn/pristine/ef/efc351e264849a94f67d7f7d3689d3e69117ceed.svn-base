package org.tsrj.common.encrypt;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.apache.commons.codec.binary.Base64;
import org.tsrj.common.ConfigUtil;
import org.tsrj.common.contants.Constants;


public class DESUtil {
	
	/**
	 * 密码加密
	 * @param pwd
	 * @return
	 */
	public static String encryptByPassword(String pwd, String mobile){
		try {
			String salt = mobile.substring(2,7)+"PWD";//取手机号的五位+PWD
			return encrypt(pwd, salt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 密码解密
	 * @param pwd
	 * @param mobile
	 * @return
	 */
	public static String decryptByPassword(String pwd, String mobile){
		try {
			String salt = mobile.substring(2,7)+"PWD";//取手机号的五位+PWD
			return decrypt(pwd, salt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 加密Token
	 * @param data
	 * @return
	 */
	public static String encryptTradeToken(String data){
		try {
			return encrypt(data, "KM20jr17");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 解密Token
	 * @param data
	 * @return      
	 * String
	 */
	public static String decryptTradeToken(String data){
		try {
			return decrypt(data, "KM20jr17");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 解密，再解码
	 * 
	 * @param data
	 * @return
	 */
	public static String decryptAftorURLDecoder(String data) {
		try {
			return URLDecoder.decode(decrypt(data, ConfigUtil.getInstance().getSysEncryptDES()), Constants.CHARSET_UTF8);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	

	/**
	 * 解密，再解码
	 * 
	 * @param data
	 * @return
	 */
	public static String decryptAftorURLDecoder(String data, String key) {
		try {
			return URLDecoder.decode(decrypt(data, key), Constants.CHARSET_UTF8);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 加密
	 * 
	 * @param data
	 * @return
	 */
	public static String encryptBeforeURLEncoder(String data) {
		try {
			return encrypt(URLEncoder.encode(data, Constants.CHARSET_UTF8), ConfigUtil.getInstance().getSysEncryptDES());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 加密
	 * 
	 * @param data
	 * @return
	 */
	public static String encryptBeforeURLEncoder(String data, String key) {
		try {
			return encrypt(URLEncoder.encode(data, Constants.CHARSET_UTF8), key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 加密
	 * 
	 * @param message
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String message, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(Constants.CHARSET_UTF8));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes(Constants.CHARSET_UTF8));
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
		return encodeBase64(cipher.doFinal(message.getBytes(Constants.CHARSET_UTF8)));
	}

	/**
	 * 加密
	 * 
	 * @param desKey
	 * @param encryptText
	 * @return
	 * @throws Exception
	 */
	public static String encryptSecureRandom(String desKey, String encryptText) throws Exception {
		SecureRandom sr = new SecureRandom();
		byte rawKeyData[] = desKey.getBytes();
		DESKeySpec dks = new DESKeySpec(rawKeyData);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		javax.crypto.SecretKey key = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(1, key, sr);
		byte data[] = encryptText.getBytes("UTF-8");
		byte encryptedData[] = cipher.doFinal(data);
		return encodeBase64(encryptedData);
	}

	/**
	 * 解密
	 * 
	 * @param message
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String message, String key) throws Exception {
		byte[] bytesrc = decodeBase64(message);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(Constants.CHARSET_UTF8));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes(Constants.CHARSET_UTF8));
		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
		byte[] retByte = cipher.doFinal(bytesrc);
		return new String(retByte);
	}

	/**
	 * 编码
	 * 
	 * @param b
	 * @return
	 */
	private static String encodeBase64(byte[] binaryData) {
		return Base64.encodeBase64String(binaryData);
	}

	/**
	 * 解码
	 * 
	 * @param base64String
	 * @return
	 */
	private static byte[] decodeBase64(String base64String) {
		return Base64.decodeBase64(base64String);
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException, Exception {
		try {
			System.out.println(encrypt("12345678", "11111111"));
			System.out.println(decrypt("nrfszjaxaNvB6kj+8M2rvQ==", "11111111"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}