package org.tsrj.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * MD5签名处理核心文件
 */

public class MD5
{

    /**
     * 签名字符串
     *
     * @param text    需要签名的字符串
     * @param key     密钥
     * @param charset 编码格式
     * @return 签名结果
     */
    public static String sign(String text, String key, String charset) throws Exception
    {
        text = text + key;
        return DigestUtils.md5Hex(getContentBytes(text, charset));
    }

    /**
     * 加密
     */
    public static String signByPHP(String password, String key)
    {
        if(key != null)
        {
            password = key + password;
        }
        return DigestUtils.md5Hex(getContentBytes(password, "UTF-8"));
    }

    /**
     * 签名字符串
     *
     * @param text    需要签名的字符串
     * @param sign    签名结果
     * @param key     密钥
     * @param charset 编码格式
     * @return 签名结果
     */
    public static boolean verify(String text, String sign, String key, String charset) throws Exception
    {
        text = text + key;
        String mysign = DigestUtils.md5Hex(getContentBytes(text, charset));
        return mysign.equals(sign);
    }

    private static byte[] getContentBytes(String content, String charset)
    {
        if(charset == null || charset.isEmpty())
        {
            return content.getBytes();
        }
        try
        {
            return content.getBytes(charset);
        }
        catch(UnsupportedEncodingException e)
        {
            throw new RuntimeException("签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }


    /**
     * md5加密
     */
    public static String md5(String inStr)
    {
        MessageDigest md5;
        try
        {
            md5 = MessageDigest.getInstance("MD5");
        }
        catch(Exception e)
        {
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for(int i = 0; i < charArray.length; i++)
        {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuilder hexValue = new StringBuilder();
        for(byte md5Byte : md5Bytes)
        {
            int val = (md5Byte) & 0xff;
            if(val < 16)
            {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }
}
