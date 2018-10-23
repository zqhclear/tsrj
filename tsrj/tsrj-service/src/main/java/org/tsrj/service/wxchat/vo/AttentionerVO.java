package org.tsrj.service.wxchat.vo;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class AttentionerVO {
	private String openid;
	private String lang;
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	
	@Override
	public String toString() {
		return "AttentionerVO [openid=" + openid + ", lang=" + lang + "]";
	}
	public static void main(String[] args){
		List<AttentionerVO> list = new ArrayList<>();
		AttentionerVO vo1 = new AttentionerVO();
		vo1.setLang("zh_CN");
		vo1.setOpenid("omti90kcWqnKIHzRTNZSV0pYWfOY");
		AttentionerVO vo2 = new AttentionerVO();
		vo2.setLang("zh_CN");
		vo2.setOpenid("omti90pf6DvyTmgi1VAW_xF2M5vM");
		list.add(vo2);
		list.add(vo1);
		System.out.println(JSONObject.toJSONString(list));
		System.out.println(URLDecoder.decode(JSONObject.toJSONString(list)));
	}
	
}
