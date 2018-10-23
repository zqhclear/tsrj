package org.tsrj.common.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.tsrj.common.enums.ResCodeEnums;
import org.tsrj.common.page.Page;
import org.tsrj.common.page.PageQuery;
import org.tsrj.common.utils.StrUtils;

import com.alibaba.fastjson.annotation.JSONField;

public class ResultBody<T> implements Serializable {
	
	private static final long serialVersionUID = 9022232228124274486L;

	/**
	 * 返回对象
	 */
	private T data;

	/**
	 * 返回消息
	 */
	private String resMsg;

	/**
	 * 返回代码
	 */
	private int resCode = 1;
	
	
	@JsonIgnore
	private ResCodeEnums resCodeEnums;

	public ResultBody(){}
	public ResultBody(T data){
		this.resCodeEnums = ResCodeEnums.SUCCESS;
		this.setResCode(ResCodeEnums.SUCCESS.getResCode());
		this.setResMsg(ResCodeEnums.SUCCESS.getResMsg());
		this.setData(data);
	}
	public ResultBody(int resCode, String resMsg, T data){
		this.setResCode(resCode);
		this.setResMsg(resMsg);
		this.setData(data);
	}

	/**
	 * 需要执行的Action
	 */
	private String action;


	@JsonIgnore
	private Page page;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		if(data instanceof PageQuery){
			PageQuery pageQuery =(PageQuery) data;
			this.data = (T)pageQuery.getResult();
			this.page = pageQuery.getPage();
		}else{
			this.data = data;
		}
	}

	public String getResMsg() {
		if(resCodeEnums != null){
			return resCodeEnums.getResMsg();
		}
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public int getResCode() {
		if(resCodeEnums != null){
			return resCodeEnums.getResCode();
		}
		if(resCode != 1){
			return resCode;
		}
		if(StrUtils.isNotEmpty(getResMsg())){
			return -1;
		}
		return resCode;
	}

	public void setResCode(int resCode) {
		this.resCode = resCode;
	}
	
	/**
	 * 是否成功
	 * @return
	 */
	@JsonIgnore
	public boolean isSuccess(){
		if(getResCode() < 0){
			return false;
		}
		return true;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
