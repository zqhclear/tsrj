package org.tsrj.common.redis;

/**
 * Created by zhongqionghua on 2017/8/22.
 *
 */
public class WXChatRedisUtil {

    /**
     * 设置accessToken
     */
    public static void setAccessToken(String accessToken) {
        RedisKey.Key key = RedisKey.Key.SYS_CONFIG;
        key.append(":wxChat:access_token");
        key.setSeconds(60 * 80); //小于两个小时过期
        RedisClient.set(key, accessToken);
    }

    /**
     * 取accessToken
     */
    public static String getAccessToken() {
        RedisKey.Key key = RedisKey.Key.SYS_CONFIG;
        key.append(":wxChat:access_token");
        return RedisClient.get(key);
    }
    
}
