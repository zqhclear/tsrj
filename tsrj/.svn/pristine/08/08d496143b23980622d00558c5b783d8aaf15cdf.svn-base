/**
 * 
 */
package org.tsrj.service.wxchat;

import org.tsrj.common.domain.ResultBody;

import com.alibaba.fastjson.JSONObject;

/**
 * @desc 
 * @author zhongqionghua
 * @date 2018年2月9日
 */
public interface WXAttenionService {
	
	public ResultBody<JSONObject> getAllAttentioner(String nextOpenId);
	
	public ResultBody<JSONObject> getAttentionerByOpenId(String openId, String lang);
	
	public ResultBody<JSONObject> getAttentionerListByOpenId(String userList);
	
	public ResultBody<JSONObject> remarkAttention(String openId, String remark);
}
