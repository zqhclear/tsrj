package org.tsrj.service.wxchat;

import org.tsrj.common.domain.ResultBody;

import com.alibaba.fastjson.JSONObject;

public interface WXTagForAttentionService {
	
	public ResultBody<JSONObject> addTag(String tagName);
	
	public ResultBody<JSONObject> updateTag(String tagDesc);
	
	public ResultBody<JSONObject> delTag(String tagDesc);
	
	public ResultBody<JSONObject> getAttentionByTag(String tagid, String nextOpenid);
	
	public ResultBody<JSONObject> addTagForAttention(String tagAttentions);
	
	public ResultBody<JSONObject> cancelTagForAttention(String cancelAttentions);
	
	public ResultBody<JSONObject> getAllTagForAttention(String openId);
	
	public ResultBody<JSONObject> getTags();
	
}
