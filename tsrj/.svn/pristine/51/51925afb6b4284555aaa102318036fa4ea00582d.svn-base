package org.tsrj.common.redis;


import org.apache.commons.lang3.StringUtils;

/**
 * Created by huang_sq on 2017/12/26.
 * 存取request的token化值
 */
public class TokenizeRequestRedisUtil {

    /**
     * 缓存request的token值
     */
    public static void setTokenizeRequest(Long memberId, String token){
        RedisKey.Key key = RedisKey.Key.TOKENIZE_REQUEST;
        key.append(":").append(memberId);
        key.setSeconds(5 * 60);
        RedisClient.set(key, token);
    }

    public static String getTokenizeRequest(Long memberId){
        RedisKey.Key key = RedisKey.Key.TOKENIZE_REQUEST;
        key.append(":").append(memberId);
        String token = RedisClient.get(key);
        if(StringUtils.isEmpty(token)){
        	//防止客户端传递参数默认:空字符串
            return "123456";
        }
        return token;
    }

    public static void delTokenizeRequest(Long memberId){
        RedisKey.Key key = RedisKey.Key.TOKENIZE_REQUEST;
        key.append(":").append(memberId);
        RedisClient.del(key);
    }
}
