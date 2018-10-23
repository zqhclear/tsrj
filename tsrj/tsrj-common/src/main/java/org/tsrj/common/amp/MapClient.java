package org.tsrj.common.amp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tsrj.common.amp.enums.MapUrlEnums;
import org.tsrj.common.httpclient.HttpClientUtil;
import org.tsrj.common.httpclient.httpclient.builder.HCB;
import org.tsrj.common.httpclient.httpclient.common.HttpConfig;

import java.util.Map;

/**
 * @Author: qh-zhong
 * @Date: 2018/5/8
 */
public class MapClient {
    private static Logger logger = LoggerFactory.getLogger(MapClient.class);

    public static String buildRequest(Map paramsMap, MapUrlEnums mapUrlEnums){
        String reqData = "";
        try{
            String wholeUrl = Md5ForAMap.initUrlWithGet(paramsMap, mapUrlEnums);
            String result = HttpClientUtil.get(HttpConfig.custom().client(HCB.custom().timeout(20000).build()).url(wholeUrl));
            return result;
        }catch(Exception ex){
            logger.error("[ASSETS]业务[{}]数据{}，处理异常{}", reqData, ex);
        }
        return null;
    }
}
