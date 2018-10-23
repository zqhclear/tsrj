package org.tsrj.common.message;

import org.tsrj.common.enums.MsgSendWay;

public class SendMessageBiz {

	private Long memberId;
	private String mobile;
	private Integer notifyType;
	private String title;
	private String content;
	private Long templateId;
	private MsgSendWay msgSendWay;
	private String action;

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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the msgSendWay
	 */
	public MsgSendWay getMsgSendWay() {
		return msgSendWay;
	}

	/**
	 * @param msgSendWay
	 *            the msgSendWay to set
	 */
	public void setMsgSendWay(MsgSendWay msgSendWay) {
		this.msgSendWay = msgSendWay;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the notifyType
	 */
	public Integer getNotifyType() {
		return notifyType;
	}

	/**
	 * @param notifyType
	 *            the notifyType to set
	 */
	public void setNotifyType(Integer notifyType) {
		this.notifyType = notifyType;
	}

	/**
	 * @return the templateId
	 */
	public Long getTemplateId() {
		return templateId;
	}

	/**
	 * @param templateId the templateId to set
	 */
	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	
	
}
