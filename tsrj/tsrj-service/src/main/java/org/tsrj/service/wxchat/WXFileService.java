package org.tsrj.service.wxchat;

import org.tsrj.common.domain.ResultBody;

import com.alibaba.fastjson.JSONObject;

public interface WXFileService {
	public ResultBody<JSONObject> uploadTemporaryFile(String type, String media);
	
	public ResultBody<JSONObject> downloadTemporaryFile(String mediaId);
}
