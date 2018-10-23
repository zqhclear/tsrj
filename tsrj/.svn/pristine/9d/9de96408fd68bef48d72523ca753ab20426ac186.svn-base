package org.tsrj.service.wxchat.utils;

import java.security.MessageDigest;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tsrj.common.httpclient.HttpClientUtil;
import org.tsrj.common.httpclient.httpclient.builder.HCB;
import org.tsrj.common.httpclient.httpclient.common.HttpConfig;
import org.tsrj.common.httpclient.httpclient.exception.HttpProcessException;
import org.tsrj.common.redis.WXChatRedisUtil;
import org.tsrj.service.wxchat.enums.WXUrlEnums;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by zhongqionghua on 2018/02/02.
 *
 */
public class WXChatRequestUtil {

    private static final Logger logger = LoggerFactory.getLogger(WXChatRequestUtil.class);

    private WXChatRequestUtil(){}
    private static class SingleUtils{
        private static final WXChatRequestUtil instance = new WXChatRequestUtil();
    }
    public static final WXChatRequestUtil getInsatance(){
        return SingleUtils.instance;
    }
    
    public String getAccessToken() {
        try {
            String preToken = WXChatRedisUtil.getAccessToken();
            if (preToken != null) {
                return preToken;
            }
            String result = HttpClientUtil.get(HttpConfig.custom().client(HCB.custom().timeout(30000).build()).
                    url(WXUrlEnums.GET_ACCESS_TOKEN.getUrl()));
            JSONObject jsonObject = (JSONObject) JSONObject.parse(result);
            if (StringUtils.isEmpty((String) jsonObject.get("access_token"))) {
                return null;
            }
            String accessToken = (String) jsonObject.get("access_token");
            WXChatRedisUtil.setAccessToken(accessToken);
            return accessToken;
        } catch (HttpProcessException e) {
            logger.info("获取access_token失败，原因:", e);
        }
        return null;
    }

    public String getSha1(String str){
        if(str==null||str.length()==0){
            return null;
        }
        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9',
                'a','b','c','d','e','f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j*2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            return null;
        }
    }

    public String formatParamJson(Map<String, Object> map) {
        JSONObject jsonObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            JSONObject param = new JSONObject();
            param.put("value", entry.getValue());
            param.put("color", "#173177");
            jsonObject.put(entry.getKey(), param);
        }
        return jsonObject.toString();
    }

}
