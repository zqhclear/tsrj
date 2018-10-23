package org.tsrj.service.wxchat.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tsrj.common.domain.ResultBody;
import org.tsrj.common.httpclient.HttpClientUtil;
import org.tsrj.common.httpclient.httpclient.builder.HCB;
import org.tsrj.common.httpclient.httpclient.common.HttpConfig;
import org.tsrj.common.httpclient.httpclient.exception.HttpProcessException;
import org.tsrj.service.wxchat.WXFileService;
import org.tsrj.service.wxchat.enums.WXUrlEnums;
import org.tsrj.service.wxchat.utils.WXUrlUtils;

import com.alibaba.fastjson.JSONObject;

@Service
public class WXFileServiceImpl implements WXFileService {

	private static Logger logger = LoggerFactory.getLogger(WXFileServiceImpl.class);
	
	@Override
	public ResultBody<JSONObject> uploadTemporaryFile(String type, String media) {
		ResultBody<JSONObject> result = new ResultBody<>();
		try{
			String url = WXUrlUtils.getUrl(WXUrlEnums.ADD_TEMPORARY_MEDIA);
			JSONObject obj = new JSONObject();
			obj.put("type", type);
			obj.put("media", media);
			String resultJson = HttpClientUtil.post(HttpConfig.custom().client(HCB.custom()
					.timeout(3000).build()).url(url).json(obj.toJSONString()));
			result = WXUrlUtils.isSuccessWXRequest(resultJson, JSONObject.class);
		}catch(HttpProcessException e){
			logger.error("获取所有微信关注用户接口调用失败，失败原因：", e);
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	

	@Override
	public ResultBody<JSONObject> downloadTemporaryFile(String mediaId) {
		return null;
	}

}
