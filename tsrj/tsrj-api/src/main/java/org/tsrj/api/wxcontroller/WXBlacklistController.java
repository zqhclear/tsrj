/**
 * 
 */
package org.tsrj.api.wxcontroller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tsrj.api.controller.BaseController;
import org.tsrj.common.domain.ResultBody;
import org.tsrj.common.enums.ResCodeEnums;
import org.tsrj.service.wxchat.WXBlacklistService;

import com.alibaba.fastjson.JSONObject;

/**
 * @desc 微信黑名单
 * @author zhongqionghua
 * @date 2018年2月9日
 */
@RestController
@RequestMapping(value = "/wxBlacklist", method = RequestMethod.POST)
public class WXBlacklistController extends BaseController {
	
	@Resource
	private WXBlacklistService wxBlacklistService;
	
	/**
	 * @desc 获取公众号的黑名单列表
	 * begin_openid 为空则表示从第一个开始
	 */
	@RequestMapping("/getAllBlackList")
	public ResultBody<JSONObject> getAllBlackList(HttpServletRequest request){
		String beginOpenId =ServletRequestUtils.getStringParameter(request, "beginOpenId", null);
		return wxBlacklistService.getAllBlackList(beginOpenId);
	}
	
	/**
	 * @desc 拉黑用户
	 * 公众号可通过该接口来拉黑一批用户，黑名单列表由一串 OpenID 
	 * （加密后的微信号，每个用户对每个公众号的OpenID是唯一的）组成。
	 * 格式：{"openid_list":["OPENID1”,”OPENID2”]}
	 */
	@RequestMapping("/addBlacklist")
	public ResultBody<JSONObject> addBlacklist(HttpServletRequest request){
		String openidList = ServletRequestUtils.getStringParameter(request, "openidList", null);
		ResultBody<JSONObject> result = ResCodeEnums.verifyParam(openidList);
		if(!result.isSuccess()){
			return result;
		}
		return wxBlacklistService.addBlacklist(openidList);
	}
	
	/**
	 * @desc 取消拉黑用户
	 */
	@RequestMapping("/cancelBlacklist")
	public ResultBody<JSONObject> cancelBlacklist(HttpServletRequest request){
		String openidList = ServletRequestUtils.getStringParameter(request, "openidList", null);
		ResultBody<JSONObject> result = ResCodeEnums.verifyParam(openidList);
		if(!result.isSuccess()){
			return result;
		}
		return wxBlacklistService.cancelBlacklist(openidList); 
	}
}
