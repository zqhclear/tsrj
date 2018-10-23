package org.tsrj.service.wxchat.enums;

public enum WXRequestStatusEnums {
	ERROR("调用失败", "successcode", "success"),
	SUCCESS("接口调用成功", "errcode", "errmsg");
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private WXRequestStatusEnums(String desc, String status, String message) {
		this.desc = desc;
		this.status = status;
		this.message = message;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String desc;
	private String status;
	private String message;
}
