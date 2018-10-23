package org.tsrj.common.enums;

/**
 * 消息发送方式
 * @author Saleson Lee.
 * @date 2016年4月27日
 * @time 上午9:58:33
 */
public enum MsgSendWay {

	SMS(1, "短信消息"),
	APP_MSG(3, "APP个人消息"),
	PUSH(4,"推送消息");
	
	/**
	 * 值 Integer型
	 */
	private final Integer value;
	/**
	 * 描述 String型
	 */
	private final String description;

	MsgSendWay(Integer value, String description) {
		this.value = value;
		this.description = description;
	}
	
	public Integer getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}
	
	public static MsgSendWay valueO(Integer value){
		MsgSendWay[] values = values();
		for(MsgSendWay msw : values){
			if(msw.getValue()==value){
				return msw;
			}
		}
		return null;
	}
	
}
