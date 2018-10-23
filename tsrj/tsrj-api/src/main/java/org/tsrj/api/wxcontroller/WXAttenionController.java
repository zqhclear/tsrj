package org.tsrj.api.wxcontroller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tsrj.common.domain.ResultBody;
import org.tsrj.common.enums.ResCodeEnums;
import org.tsrj.common.utils.StringUtil;
import org.tsrj.service.wxchat.WXAttenionService;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zhognqionghua
 * @data 2018/02/09
 * @des 微信公众号关注者管理
 */
@RestController
@RequestMapping(value = "/WXAttenion", method = RequestMethod.POST)
public class WXAttenionController {
	
	@Resource
	private WXAttenionService wxAttenionService;
	
	/**
	 * @des 获取用户列表，请求为https
	 * 当公众号关注者数量超过10000时，可通过填写next_openid的值，
	 * 从而多次拉取列表的方式来满足需求。
	 * 具体而言，就是在调用接口时，
	 * 将上一次调用得到的返回中的next_openid值，作为下一次调用中的next_openid值。
	 */
	@RequestMapping("/getAllAttentioner")
	public ResultBody<JSONObject> getAllAttentioner(HttpServletRequest request){
		String nextOpenId = ServletRequestUtils.getStringParameter(request, "nextOpenId", null);
		return wxAttenionService.getAllAttentioner(nextOpenId);
	}
	
	/**
	 * @des 获取用户基本信息
	 * 请求为https请求
	 */
	@RequestMapping("/getAttentionerByOpenId")
	public ResultBody<JSONObject> getAttentionerByOpenId(HttpServletRequest request){
		String openId = ServletRequestUtils.getStringParameter(request, "openId", null);
		String lang = ServletRequestUtils.getStringParameter(request, "lang", "zh_CN");//语言版本，默认简体
		ResultBody<JSONObject> result = ResCodeEnums.verifyParam(openId, lang);
		if(!result.isSuccess()){
			return result;
		}
		return wxAttenionService.getAttentionerByOpenId(openId, lang);
	}
	
	/**
	 * @throws UnsupportedEncodingException 
	 * @desc 批量获取用户基本信息
	 * 最多支持一次拉取100条。
	 * 格式：{"user_list":[{"openid": "otvxTs4dckWG7imySrJd6jSi0CWE", "lang": "zh_CN"}, 
	 * {"openid": "otvxTs_JZ6SEiP0imdhpi50fuSZg", "lang": "zh_CN"}]}
	 */
	@RequestMapping("/getAttentionerListByOpenId")
	public ResultBody<JSONObject> getAttentionerListByOpenId(HttpServletRequest request) throws UnsupportedEncodingException{
		String userList = ServletRequestUtils.getStringParameter(request, "userList", null);
		ResultBody<JSONObject> result = ResCodeEnums.verifyParam(userList);
		if(!result.isSuccess()){
			return result;
		}
		return wxAttenionService.getAttentionerListByOpenId(userList);
	}
	
	/**
	 * @desc 给用户添加备注
	 */
	@RequestMapping("/remarkAttention")
	public ResultBody<JSONObject> remarkAttention(HttpServletRequest request){
		ResultBody<JSONObject> result = new ResultBody<>();
		String openId = ServletRequestUtils.getStringParameter(request, "openId", null);
		String remark = ServletRequestUtils.getStringParameter(request, "remark", null);
		if(StringUtil.isEmpty(openId) || StringUtil.isEmpty(remark)){
			result.setResMsg(ResCodeEnums.PARAM_ERROR.getResMsg());
			result.setResCode(ResCodeEnums.PARAM_ERROR.getResCode());
			return result;
		}
		return wxAttenionService.remarkAttention(openId, remark);
	}
	
	/**
	 * @desc 获取用户地理位置
	 * 开通了上报地理位置接口的公众号，用户在关注后进入公众号会话时，
	 * 会弹框让用户确认是否允许公众号使用其地理位置。
	 * 弹框只在关注后出现一次，用户以后可以在公众号详情页面进行操作。
	 * 第三方在收到地理位置上报信息之后，只需要回复success表明收到即可，是不允许回复消息给粉丝的
	 */
	@RequestMapping("getPlaceForAttetion")
	public ResultBody<JSONObject> getPlaceForAttetion(HttpServletRequest request){
		String placeXml = ServletRequestUtils.getStringParameter(request, "placeXml", null);
		return null;
	}
	
}
