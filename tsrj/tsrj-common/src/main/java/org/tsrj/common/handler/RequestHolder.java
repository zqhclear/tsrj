package org.tsrj.common.handler;

import javax.servlet.http.HttpServletRequest;


/**
 * 记录了APP访问服务端的Request Header信息
 * @author Saleson Lee.
 * @date 2016年7月12日
 * @time 下午3:19:25
 */
public class RequestHolder {

	private String device;
	private int deviceType;
	private String deviceSerialNumber;
	private String memberMobile;
	private String channelId;
	private long memberId;
	private String ip;
	private String acceptVersion;
	private String appVersion;
	private String requestTime;

	RequestHolder() {

	}

	/**
	 * 是否Android设备
	 * 
	 * @return
	 */
	public boolean isAndroid() {
		return deviceType == 1;
	}

	/**
	 * 是否IOS设备
	 * 
	 * @return
	 */
	public boolean isIOS(HttpServletRequest req) {
		return deviceType == 2;
	}


	
	
	/**
	 * @return the device
	 */
	public String getDevice() {
		return device;
	}

	/**
	 * @param device the device to set
	 */
	void setDevice(String device) {
		this.device = device;
	}

	/**
	 * @return the deviceType
	 */
	public int getDeviceType() {
		return deviceType;
	}

	/**
	 * @param deviceType
	 *            the deviceType to set
	 */
	void setDeviceType(int deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @return the deviceSerialNumber
	 */
	public String getDeviceSerialNumber() {
		return deviceSerialNumber;
	}

	/**
	 * @param deviceSerialNumber
	 *            the deviceSerialNumber to set
	 */
	void setDeviceSerialNumber(String deviceSerialNumber) {
		this.deviceSerialNumber = deviceSerialNumber;
	}

	/**
	 * @return the memberMobile
	 */
	public String getMemberMobile() {
		return memberMobile;
	}

	/**
	 * @param memberMobile
	 *            the memberMobile to set
	 */
	void setMemberMobile(String memberMobile) {
		this.memberMobile = memberMobile;
	}

	/**
	 * @return the channelId
	 */
	public String getChannelId() {
		return channelId;
	}

	/**
	 * @param channelId
	 *            the channelId to set
	 */
	void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	/**
	 * @return the memberId
	 */
	public long getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId
	 *            the memberId to set
	 */
	void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip
	 *            the ip to set
	 */
	void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the acceptVersion
	 */
	public String getAcceptVersion() {
		return acceptVersion;
	}

	/**
	 * @param acceptVersion
	 *            the acceptVersion to set
	 */
	void setAcceptVersion(String acceptVersion) {
		this.acceptVersion = acceptVersion;
	}

	/**
	 * @return the appVersion
	 */
	public String getAppVersion() {
		return appVersion;
	}

	/**
	 * @param appVersion
	 *            the appVersion to set
	 */
	void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	/**
	 * @return the requestTime
	 */
	public String getRequestTime() {
		return requestTime;
	}

	/**
	 * @param requestTime
	 *            the requestTime to set
	 */
	void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
}
