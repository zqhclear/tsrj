package org.tsrj.service.event;


public enum EventType {

	MemberRegisted(1, "用户进入index事件");
	
	private String describe;
	private Integer type;
	
	EventType(Integer type, String describe){
		this.type = type;
		this.describe = describe;
	}
	
	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @return the describe
	 */
	public String getDescribe() {
		return describe;
	}
	
	
	/**
	 * 根据type返回enum类型
	 * @param type
	 * @return
	 */
	public EventType typeOf(Integer type){
		EventType[] values = values();
		for(EventType et : values){
			if(et.type==type){
				return et;
			}
		}
		return null;
	}
}
