package org.tsrj.service.wxchat.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tsrj.common.domain.ResultBody;
import org.tsrj.common.httpclient.HttpClientUtil;
import org.tsrj.common.httpclient.httpclient.builder.HCB;
import org.tsrj.common.httpclient.httpclient.common.HttpConfig;
import org.tsrj.common.httpclient.httpclient.exception.HttpProcessException;
import org.tsrj.service.wxchat.WXBlacklistService;
import org.tsrj.service.wxchat.enums.WXUrlEnums;
import org.tsrj.service.wxchat.utils.WXUrlUtils;

import com.alibaba.fastjson.JSONObject;

@Service
public class WXBlacklistServiceImpl implements WXBlacklistService {
	
	private static Logger logger = LoggerFactory.getLogger(WXBlacklistServiceImpl.class);
	
	@Override
	public ResultBody<JSONObject> getAllBlackList(String beginOpenId) {
		ResultBody<JSONObject> result = new ResultBody<>();
		try{
			String url = WXUrlUtils.getUrl(WXUrlEnums.BLACKLIST_GET);
			JSONObject obj = new JSONObject();
			obj.put("begin_openid", beginOpenId);
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
	public ResultBody<JSONObject> addBlacklist(String openidList) {
		ResultBody<JSONObject> result = new ResultBody<>();
		try{
			String url = WXUrlUtils.getUrl(WXUrlEnums.BLACKLIST_ADD);
			JSONObject obj = new JSONObject();
			/*List<String> list = new ArrayList<>();
			list.add("omti90kcWqnKIHzRTNZSV0pYWfOY");
			list.add("omti90pf6DvyTmgi1VAW_xF2M5vM");
			obj.put("openid_list", list);*/
			obj.put("openid_list", openidList);
			String resultJson = HttpClientUtil.post(HttpConfig.custom().client(HCB.custom()
					.timeout(3000).build()).url(url).json(obj.toJSONString()));
			result = WXUrlUtils.isSuccessWXRequest(resultJson, JSONObject.class);
		}catch(HttpProcessException e){
			logger.error("获取所有微信关注用户接口调用失败，失败原因：", e);
		}
		return result;
	}

	@Override
	public ResultBody cancelBlacklist(String openidList) {
		ResultBody result = new ResultBody<>();
		try{
			String url = WXUrlUtils.getUrl(WXUrlEnums.BLACKLIST_DEL);
			JSONObject obj = new JSONObject();
			/*List<String> list = new ArrayList<>();
			list.add("omti90kcWqnKIHzRTNZSV0pYWfOY");
			list.add("omti90pf6DvyTmgi1VAW_xF2M5vM");
			obj.put("openid_list", list);*/
			obj.put("openid_list", openidList);
			String resultJson = HttpClientUtil.post(HttpConfig.custom().client(HCB.custom()
					.timeout(3000).build()).url(url).json(obj.toJSONString()));
			result = WXUrlUtils.isSuccessWXRequest(resultJson, JSONObject.class);
		}catch(HttpProcessException e){
			logger.error("获取所有微信关注用户接口调用失败，失败原因：", e);
		}
		return result;
	}

}
