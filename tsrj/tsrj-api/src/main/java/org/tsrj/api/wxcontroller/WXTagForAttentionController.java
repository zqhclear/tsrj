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
import org.tsrj.service.wxchat.WXTagForAttentionService;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zhongiqonghua
 * @date 2018/02/09
 * @desc 用户标签管理
 */
@RestController
@RequestMapping(value = "/wxTagGorAttention", method = RequestMethod.POST)
public class WXTagForAttentionController extends BaseController {
	
	@Resource
	private WXTagForAttentionService wxTagForAttentionService;
	/**
	 * @desc 添加标签
	 * @param 标签名，UTF8编码
	 */
	@RequestMapping("/addTag")
	public ResultBody<JSONObject> addTag(HttpServletRequest request){
		String tagName = ServletRequestUtils.getStringParameter(request, "tagName", null);
		ResultBody<JSONObject> result = ResCodeEnums.verifyParam(tagName);
		if(!result.isSuccess()){
			return result;
		}
		return wxTagForAttentionService.addTag(tagName);
	}
	/**
	 * @desc 获取已添加的标签
	 */
	@RequestMapping("/getTags")
	public ResultBody<JSONObject> getTags(HttpServletRequest request){
		return wxTagForAttentionService.getTags();
	}
	/**
	 * @desc 编辑标签
	 * 标签格式：{   "tag" : {     "id" : 134,     "name" : "广东人"   } }
	 */
	@RequestMapping("/updateTag")
	public ResultBody<JSONObject> updateTag(HttpServletRequest request){
		String tagDesc = ServletRequestUtils.getStringParameter(request, "tagDesc", null);
		ResultBody<JSONObject> result = ResCodeEnums.verifyParam(tagDesc);
		if(!result.isSuccess()){
			return result;
		}
		return wxTagForAttentionService.updateTag(tagDesc);
	}
	/**
	 * @desc 删除标签
	 * 请注意，当某个标签下的粉丝超过10w时，后台不可直接删除标签。
	 * 此时，开发者可以对该标签下的openid列表，先进行取消标签的操作，
	 * 直到粉丝数不超过10w后，才可直接删除该标签。
	 * json格式：{   "tag":{        "id" : 134   } }
	 */
	@RequestMapping("/delTag")
	public ResultBody<JSONObject> delTag(HttpServletRequest request){
		String tagDesc = ServletRequestUtils.getStringParameter(request, "tagDesc", null);
		ResultBody<JSONObject> result = ResCodeEnums.verifyParam(tagDesc);
		if(!result.isSuccess()){
			return result;
		}
		return wxTagForAttentionService.delTag(tagDesc);
	}
	/**
	 * @desc 获取标签下的粉丝列表
	 * 格式：{   "tagid" : 134,   "next_openid":""//第一个拉取的OPENID，不填默认从头开始拉取 }
	 */
	@RequestMapping("/getAttentionByTag")
	public ResultBody<JSONObject> getAttentionByTag(HttpServletRequest request){
		String tagid = ServletRequestUtils.getStringParameter(request, "tagid", null);
		String nextOpenid = ServletRequestUtils.getStringParameter(request, "nextOpenid", null);
		ResultBody<JSONObject> result = ResCodeEnums.verifyParam(tagid, nextOpenid);
		if(!result.isSuccess()){
			return result;
		}
		return wxTagForAttentionService.getAttentionByTag(tagid, nextOpenid);
	}
	/**
	 * @desc 批量为用户打标签
	 * 格式：{"openid_list":["ocYxcuAEy30bX0NXmGn4ypqx3tI0","ocYxcuBt0mRugKZ7tGAHPnUaOW7Y"],"tagid":134}
	 */
	@RequestMapping("/addTagForAttention")
	public ResultBody<JSONObject> addTagForAttention(HttpServletRequest request){
		String tagAttentions = ServletRequestUtils.getStringParameter(request, "tagAttentions", null);
		ResultBody<JSONObject> result = ResCodeEnums.verifyParam(tagAttentions);
		if(!result.isSuccess()){
			return result;
		}
		return wxTagForAttentionService.addTagForAttention(tagAttentions);
	}
	/**
	 * @desc 批量为用户取消标签
	 * 格式;{"openid_list":["ocYxcuAEy30bX0NXmGn4ypqx3tI0","ocYxcuBt0mRugKZ7tGAHPnUaOW7Y"],"tagid":134}
	 */
	@RequestMapping("/cancelTagForAttention")
	public ResultBody<JSONObject> cancelTagForAttention(HttpServletRequest request){
		String cancelAttentions = ServletRequestUtils.getStringParameter(request, "tagAttentions", null);
		ResultBody<JSONObject> result = ResCodeEnums.verifyParam(cancelAttentions);
		if(!result.isSuccess()){
			return result;
		}
		return wxTagForAttentionService.cancelTagForAttention(cancelAttentions);
	}
	/**
	 * @desc 获取用户的所有标签
	 * 格式：{"openid":"ocYxcuBt0mRugKZ7tGAHPnUaOW7Y"}
	 */
	@RequestMapping("/getAllTagForAttention")
	public ResultBody<JSONObject> getAllTagForAttention(HttpServletRequest request){
		String openId = ServletRequestUtils.getStringParameter(request, "openId", null);
		ResultBody<JSONObject> result = ResCodeEnums.verifyParam(openId);
		if(!result.isSuccess()){
			return result;
		}
		return wxTagForAttentionService.getAllTagForAttention(openId);
	}
}
