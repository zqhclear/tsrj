/**
 * 
 */
package org.tsrj.service.wxchat.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tsrj.common.domain.ResultBody;
import org.tsrj.common.httpclient.HttpClientUtil;
import org.tsrj.common.httpclient.httpclient.builder.HCB;
import org.tsrj.common.httpclient.httpclient.common.HttpConfig;
import org.tsrj.common.httpclient.httpclient.exception.HttpProcessException;
import org.tsrj.common.utils.StringUtil;
import org.tsrj.service.wxchat.WXAttenionService;
import org.tsrj.service.wxchat.enums.WXUrlEnums;
import org.tsrj.service.wxchat.utils.WXUrlUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * @desc
 * @author zhongqionghua
 * @date 2018年2月9日
 */
@Service
public class WXAttenionServiceImpl implements WXAttenionService {

	private static Logger logger = LoggerFactory.getLogger(WXAttenionServiceImpl.class);
	@Override
	public ResultBody<JSONObject> getAllAttentioner(String nextOpenId) {
		ResultBody<JSONObject> result = new ResultBody<>();
		try{
			String url = WXUrlUtils.getUrl(WXUrlEnums.ATTENTION_LIST);
			if(StringUtil.isEmpty(nextOpenId)){
				url = url.substring(0, url.indexOf("&next_openid"));
			}else{
				url = url.replace("NEXT_OPENID", nextOpenId);
			}
			String attentionList = HttpClientUtil.get(HttpConfig.custom().client(HCB.custom()
					.timeout(3000).build()).url(url));
			JSONObject json = JSONObject.parseObject(attentionList);
			result.setData(json);
		}catch(HttpProcessException e){
			logger.error("获取所有微信关注用户接口调用失败，失败原因：", e);
		}
		return result;
	}

	@Override
	public ResultBody<JSONObject> getAttentionerByOpenId(String openId, String lang) {
		ResultBody<JSONObject> result = new ResultBody<>();
		try{
			String url = WXUrlUtils.getUrl(WXUrlEnums.ATTENTION_BY_OPENID);
			url = url.replace("OPENID", openId);
			url = url.replace("zh_CN", lang);
			String attentionList = HttpClientUtil.get(HttpConfig.custom().client(HCB.custom()
					.timeout(3000).build()).url(url));
			JSONObject json = JSONObject.parseObject(attentionList);
			result.setData(json);
		}catch(HttpProcessException e){
			logger.error("获取所有用户信息接口调用失败，失败原因：", e);
		}
		return result;
	}

	@Override
	public ResultBody<JSONObject> getAttentionerListByOpenId(String userList) {
		ResultBody<JSONObject> result = new ResultBody<>();
		try{
			String url = WXUrlUtils.getUrl(WXUrlEnums.ATTENTIONLIST_BY_OPENIDS);
			/*List<AttentionerVO> list = new ArrayList<>();
			AttentionerVO vo1 = new AttentionerVO();
			vo1.setLang("zh_CN");
			vo1.setOpenid("omti90kcWqnKIHzRTNZSV0pYWfOY");
			org.tsrj.service.wxchat.vo.AttentionerVO vo2 = new AttentionerVO();
			vo2.setLang("zh_CN");
			vo2.setOpenid("omti90pf6DvyTmgi1VAW_xF2M5vM");
			list.add(vo2);
			list.add(vo1);
			JSONObject obj = new JSONObject();
			obj.put("user_list", list);
			String attentionList = HttpClientUtil.post(HttpConfig.custom().client(HCB.custom()
					.timeout(3000).build()).url(url).json(obj.toJSONString()));*/
			String attentionList = HttpClientUtil.post(HttpConfig.custom().client(HCB.custom()
					.timeout(3000).build()).url(url).json(userList));
			JSONObject json = JSONObject.parseObject(attentionList);
			result.setData(json);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResultBody<JSONObject> remarkAttention(String openId, String remark) {
		ResultBody<JSONObject> result = new ResultBody<>();
		try{
			String url = WXUrlUtils.getUrl(WXUrlEnums.ATTENTION_REMARK);
			JSONObject obj = new JSONObject();
			obj.put("openid", openId);
			obj.put("remark", remark);
			String attentionList = HttpClientUtil.post(HttpConfig.custom().client(HCB.custom()
					.timeout(3000).build()).url(url).json(obj.toJSONString()));
			JSONObject json = JSONObject.parseObject(attentionList);
			result.setData(json);
		}catch(HttpProcessException e){
			logger.error("修改用户备注接口调用失败，失败原因：", e);
			e.printStackTrace();
		}
		return result;
	}
}
