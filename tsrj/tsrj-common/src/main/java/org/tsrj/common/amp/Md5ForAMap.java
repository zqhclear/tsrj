package org.tsrj.common.amp;

import org.tsrj.common.amp.enums.MapUrlEnums;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * @Author: qh-zhong
 * @Date: 2018/5/8
 */
public class Md5ForAMap {

    public static String initUrlWithGet(Map<?, ?> paramsMap, MapUrlEnums urlEnum){
        /**
         * MD5(用按照请求参数排过顺序的请求串+用户私钥)生成签名 sig
         * sig = 3dbe13640b0fdb1d057ed5dd671362bf
         */
        String signStr = getMd5StandardString(paramsMap, MapConfig.SIG_KEY);
        /**
         * 调用下面的toEncodeQueryString方法，对TreeMap内所有value作utf8编码，拼接请求串
         * city=CHINA&enc=utf-8&filter=Province%3A53174EAC%2BPostCode%3A116031&key=%24%7Bkey%7D&keywords=%E9%85%92%E5%BA%97&limit=100&output=json&tableid=55adb0c7e4b0a76fce4c8dd6
         */
        StringBuffer paramsStr = new StringBuffer(toEncodeQueryString(paramsMap));
        //拼接签名参数
        paramsStr.append("&sig="+signStr);
        /**
         * 最终发起的请求串
         * http://yuntuapi.amap.com/${interface}?city=CHINA&enc=utf-8&filter=Province%3A53174EAC%2BPostCode%3A116031&key=%24%7Bkey%7D&keywords=%E9%85%92%E5%BA%97&limit=100&output=json&tableid=55adb0c7e4b0a76fce4c8dd6&sig=c926cd113c5bd7bc33291ed7c8ae5425
         */
        return urlEnum.getUrl() + paramsStr;
    }

    /**
     * 拼接原始请求串,对Map内所有value，拼接返回结果
     * @param data
     * @return
     */
    public static String toOldQueryString(Map<?, ?> data) {
        StringBuffer queryString = new StringBuffer();
        try {
            for (Map.Entry<?, ?> pair : data.entrySet()) {
                queryString.append(pair.getKey() + "=");
                queryString.append(pair.getValue()+"&");
            }
            if (queryString.length() > 0) {
                queryString.deleteCharAt(queryString.length() - 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryString.toString();
    }

    /**
     * 对Map内所有value作utf8编码，拼接返回结果
     * @param data
     * @return
     */
    public static String toEncodeQueryString(Map<?, ?> data) {
        StringBuffer queryString = new StringBuffer();
        try {
            for (Map.Entry<?, ?> pair : data.entrySet()) {
                queryString.append(pair.getKey() + "=");
                queryString.append(URLEncoder.encode((String) pair.getValue(),
                        "UTF-8") + "&");
            }
            if (queryString.length() > 0) {
                queryString.deleteCharAt(queryString.length() - 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryString.toString();
    }

    /**
     * MD5签名
     * @param paramMap
     * @return
     */
    public static String getMd5StandardString(Map<?, ?> paramMap, String key){
        String source = toOldQueryString(paramMap) + key;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            //不写，获取系统编码 现统一编码为UTF-8
            md.update(source.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte b[] = md.digest();
        return standardBytes2HexString(b);
    }

    public static String standardBytes2HexString(byte[] b) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret.append(hex);
        }
        return ret.toString();
    }
}
