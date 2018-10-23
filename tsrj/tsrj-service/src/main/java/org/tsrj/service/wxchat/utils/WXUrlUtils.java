package org.tsrj.service.wxchat.utils;

import org.tsrj.common.domain.ResultBody;
import org.tsrj.common.utils.BeanCopyUtil;
import org.tsrj.service.wxchat.enums.WXRequestStatusEnums;
import org.tsrj.service.wxchat.enums.WXUrlEnums;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;

public class WXUrlUtils {
	
	public static String getUrl(WXUrlEnums enums){
		String accessToken = WXChatRequestUtil.getInsatance().getAccessToken();
		if(StringUtils.isEmpty(accessToken)){
			return null;
		}
		String url = enums.getUrl();
		//如果需要access_token的话，则替换
		url = url.replace("ACCESS_TOKEN", accessToken);
		return url;
	}
	
	public static ResultBody isSuccessWXRequest(String resultJson, Class clazz){
		ResultBody result = new ResultBody<>();
		JSONObject obj = JSONObject.parseObject(resultJson);
		if(obj != null  && (!obj.containsKey(WXRequestStatusEnums.ERROR.getStatus()) //请求失败
				|| (obj.containsKey(WXRequestStatusEnums.ERROR.getStatus()) && obj.getInteger(WXRequestStatusEnums.ERROR.getStatus()) == 0))){
			result.setData(BeanCopyUtil.map(obj, clazz));
			return result;
		}
		result.setResMsg(obj.getString(WXRequestStatusEnums.ERROR.getMessage()));
		return result;
	}
}
