package org.tsrj.common.utils;

/**
 * 
 * @author jared
 * 
 * @Description: String工具类
 * 
 * @date Nov 5, 2014 3:36:54 PM
 * 
 */
public class StringUtil {

	/**
	 * 字符串是否不为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !StringUtil.isEmpty(str);
	}

	/**
	 * 字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}
	
	public static String toQqueryLikeStr(String src){
		return "%"+src+"%";
	}
	
	public static boolean isStringLengthBetween(String str, int i, int j) {
		if(str==null||str.length()<i||str.length()>j){
			return false;
		}
		return true;
	}
}
