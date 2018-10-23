package org.tsrj.service.wxchat.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tsrj.common.domain.ResultBody;
import org.tsrj.common.httpclient.HttpClientUtil;
import org.tsrj.common.httpclient.httpclient.builder.HCB;
import org.tsrj.common.httpclient.httpclient.common.HttpConfig;
import org.tsrj.common.httpclient.httpclient.exception.HttpProcessException;
import org.tsrj.service.wxchat.WXTagForAttentionService;
import org.tsrj.service.wxchat.enums.WXUrlEnums;
import org.tsrj.service.wxchat.utils.WXUrlUtils;

import com.alibaba.fastjson.JSONObject;

@Service
public class WXTagForAttentionServiceImpl implements WXTagForAttentionService {

	private static Logger logger = LoggerFactory.getLogger(WXBlacklistServiceImpl.class);
	@Override
	public ResultBody<JSONObject> addTag(String tagName) {
		ResultBody<JSONObject> result = new ResultBody<>();
		try{
			String url = WXUrlUtils.getUrl(WXUrlEnums.ADD_TAG);
			JSONObject obj = new JSONObject();
			/*JSONObject obj1 = new JSONObject();
			obj1.put("name", "用户标签1");
			obj.put("tag", obj1);*/
			obj.put("tag", tagName);
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
	public ResultBody<JSONObject> updateTag(String tagDesc) {
		ResultBody<JSONObject> result = new ResultBody<>();
		try{
			String url = WXUrlUtils.getUrl(WXUrlEnums.UPDATE_TAGS);
			JSONObject obj = new JSONObject();
			/*JSONObject obj1 = new JSONObject();
			obj1.put("name", "用户标签1");
			obj.put("id", 123);
			obj.put("tag", obj1);*/
			obj.put("tag", tagDesc);
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
	public ResultBody<JSONObject> delTag(String tagDesc) {
		ResultBody<JSONObject> result = new ResultBody<>();
		try{
			String url = WXUrlUtils.getUrl(WXUrlEnums.DEL_TAG);
			JSONObject obj = new JSONObject();
			/*JSONObject obj1 = new JSONObject();
			obj.put("id", 123);
			obj.put("tag", obj1);*/
			obj.put("tag", tagDesc);
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
	public ResultBody<JSONObject> getAttentionByTag(String tagid, String nextOpenid) {
		ResultBody<JSONObject> result = new ResultBody<>();
		try{
			String url = WXUrlUtils.getUrl(WXUrlEnums.GET_USER_BYTAG);
			url = url + "&tagid=" + tagid +"&next_openid=" + nextOpenid;
			String resultJson = HttpClientUtil.get(HttpConfig.custom().client(HCB.custom()
					.timeout(3000).build()).url(url));
			result = WXUrlUtils.isSuccessWXRequest(resultJson, JSONObject.class);
		}catch(HttpProcessException e){
			logger.error("获取所有微信关注用户接口调用失败，失败原因：", e);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResultBody<JSONObject> addTagForAttention(String tagAttentions) {
		ResultBody<JSONObject> result = new ResultBody<>();
		try{
			String url = WXUrlUtils.getUrl(WXUrlEnums.STAMP_TAG_FOR_USER);
			/*JSONObject obj = new JSONObject();
			List<String> list = new ArrayList<>();
			list.add("openid1");
			list.add("openid2");
			list.add("openid3");
			obj.put("openid_list", list);
			obj.put("tagid", "123");
			String resultJson = HttpClientUtil.post(HttpConfig.custom().client(HCB.custom()
					.timeout(3000).build()).url(url).json(obj.toJSONString()));*/
			String resultJson = HttpClientUtil.post(HttpConfig.custom().client(HCB.custom()
					.timeout(3000).build()).url(url).json(tagAttentions));
			result = WXUrlUtils.isSuccessWXRequest(resultJson, JSONObject.class);
		}catch(HttpProcessException e){
			logger.error("获取所有微信关注用户接口调用失败，失败原因：", e);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResultBody<JSONObject> cancelTagForAttention(String cancelAttentions) {
		ResultBody<JSONObject> result = new ResultBody<>();
		try{
			String url = WXUrlUtils.getUrl(WXUrlEnums.CACEL_TAG_FRO_USER);
			/*JSONObject obj = new JSONObject();
			List<String> list = new ArrayList<>();
			list.add("openid1");
			list.add("openid2");
			list.add("openid3");
			obj.put("openid_list", list);
			obj.put("tagid", "123");
			String resultJson = HttpClientUtil.post(HttpConfig.custom().client(HCB.custom()
					.timeout(3000).build()).url(url).json(obj.toJSONString()));*/
			String resultJson = HttpClientUtil.post(HttpConfig.custom().client(HCB.custom()
					.timeout(3000).build()).url(url).json(cancelAttentions));
			result = WXUrlUtils.isSuccessWXRequest(resultJson, JSONObject.class);
		}catch(HttpProcessException e){
			logger.error("取消用户标签接口调用失败，失败原因：", e);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResultBody<JSONObject> getAllTagForAttention(String openId) {
		ResultBody<JSONObject> result = new ResultBody<>();
		try{
			String url = WXUrlUtils.getUrl(WXUrlEnums.UPDATE_TAGS);
			url = url + "&openid=" + openId;
			String resultJson = HttpClientUtil.get(HttpConfig.custom().client(HCB.custom()
					.timeout(3000).build()).url(url));
			result = WXUrlUtils.isSuccessWXRequest(resultJson, JSONObject.class);
		}catch(HttpProcessException e){
			logger.error("获取所有微信关注用户接口调用失败，失败原因：", e);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResultBody<JSONObject> getTags() {
		ResultBody<JSONObject> result = new ResultBody<>();
		try{
			String url = WXUrlUtils.getUrl(WXUrlEnums.GET_TAGS);
			String resultJson = HttpClientUtil.get(HttpConfig.custom().client(HCB.custom()
					.timeout(3000).build()).url(url));
			result = WXUrlUtils.isSuccessWXRequest(resultJson, JSONObject.class);
		}catch(HttpProcessException e){
			logger.error("获取所有微信关注用户接口调用失败，失败原因：", e);
			e.printStackTrace();
		}
		return result;
	}

}
