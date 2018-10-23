package org.tsrj.common.enums;

import org.tsrj.common.domain.ResultBody;
import org.tsrj.common.utils.StringUtil;

import com.alibaba.fastjson.JSONObject;

public enum ResCodeEnums {

	RRAJD_PARAMS_NULL("token参数不可为空", -201),
	RRAJD_PARSE("token解析异常", -202),
	RRAJD_TOKEN_ERROR("token解析异常", -203),

	SUCCESS("返回成功",1),
	ERROR("操作异常，请稍后再试", -1),
	SIGN_ERROR("签名异常，请检查请求参数", -101),
	NO_LOGIN_ERROR("请先登录", -1001),

	ACTIVITY_TOKENIZE_FAILED("抽奖异常,请稍后重试", 400003),
	ACTIVITY_DRAW_FAILED("数据异常，请稍后重试或联系客服人员处理。", 400005),
	
	PARAM_ERROR("参数异常，请校检参数后重试", -301);

	private String resMsg;
	private int resCode;

	ResCodeEnums(String resMsg, int resCode) {
		this.resMsg = resMsg;
		this.resCode = resCode;
	}

	public String getResMsg() {
		return resMsg;
	}

	public int getResCode() {
		return resCode;
	}

	public static ResultBody<JSONObject> verifyParam(String...verifyStrs){
		ResultBody<JSONObject> result = new ResultBody<>();
		for(String str : verifyStrs){
			if(StringUtil.isEmpty(str)){
				result.setResMsg(ResCodeEnums.PARAM_ERROR.getResMsg());
				result.setResCode(ResCodeEnums.PARAM_ERROR.getResCode());
				return result;
			}
		}
		return result;
	}
}
