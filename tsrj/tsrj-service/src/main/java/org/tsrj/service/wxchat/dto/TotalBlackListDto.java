package org.tsrj.service.wxchat.dto;

import java.io.Serializable;
import java.util.List;

public class TotalBlackListDto implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -3983182106178984046L;
	private Integer total;
	private Integer count;
	private Object data;
	private List<String> openid;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public List<String> getOpenid() {
		return openid;
	}
	public void setOpenid(List<String> openid) {
		this.openid = openid;
	}

}
