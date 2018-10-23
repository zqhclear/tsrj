/**
 * 
 */
package org.tsrj.service.wxchat;

import org.tsrj.common.domain.ResultBody;
import org.tsrj.service.wxchat.dto.TotalBlackListDto;

import com.alibaba.fastjson.JSONObject;

/**
 * @desc
 * @author zhongqionghua
 * @date 2018年2月9日
 */
public interface WXBlacklistService {
	
	public ResultBody<JSONObject> getAllBlackList(String beginOpenId);
	
	public ResultBody<JSONObject> addBlacklist(String openidList);
	
	public ResultBody<JSONObject> cancelBlacklist(String openidList);
}
