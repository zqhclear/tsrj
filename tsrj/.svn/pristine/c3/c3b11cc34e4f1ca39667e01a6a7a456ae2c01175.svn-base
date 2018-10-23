package org.tsrj.service.event;

import org.tsrj.common.utils.StrUtils;

public class OperateEvent implements Event{

	private Integer type;
	private Long memberId;
	private String operateId;
	private Object operateArg;

	/**
	 * @return the memberId
	 */
	public Long getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId
	 *            the memberId to set
	 */
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the operateId
	 */
	public String getOperateId() {
		return operateId;
	}

	/**
	 * 返回Long类型的操作ID
	 * 
	 * @return
	 */
	public Long getOperateId2Long() {
		if (StrUtils.isBlank(operateId)) {
			return null;
		}
		return Long.parseLong(operateId);
	}

	/**
	 * @param operateId
	 *            the operateId to set
	 */
	public void setOperateId(String operateId) {
		this.operateId = operateId;
	}

	/**
	 * @return the operateArg
	 */
	@SuppressWarnings("unchecked")
	public <T> T getOperateArg() {
		return (T) operateArg;
	}

	/**
	 * @param operateArg
	 *            the operateArg to set
	 */
	public void setOperateArg(Object operateArg) {
		this.operateArg = operateArg;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}


	
	
}
