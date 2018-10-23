package org.tsrj.common.web;


import java.util.List;

import com.google.common.collect.Lists;

/**
 * 请求头参数
 * @author zhongqionghua
 * @date 2018年02月07日 下午5:23:30   
 *
 */
public enum RequestHeaderEnums {
	/** 设备型号 **/
	REQ_HEADER_DEVICE("req-header-device", true),
	/** 设备类型 **/
	REQ_HEADER_DEVICE_TYPE("req-header-device-type", true),
	/** App版本 **/
	REQ_HEADER_APP_VERSION("req-header-app-version", true),
	/** 设备ID **/
	REQ_HEADER_DEVICE_ID("req-header-device-id", false),
	/** Android 序列号 **/
	REQ_HEADER_ANDROID_SN("req-header-android-sn", false),
	/** API_REQUEST_TIME **/
	REQ_HEADER_REQUEST_TIME("req-header-request-time", false),
	/**推送ID**/
	REQ_HEADER_PUSH_ID("req-header-push-id", false),
	/**客户端版本**/
	REQ_HEADER_CLIENT_VERSION("req-header-client-version", false),
	/**请求token化-- php加了该属性，客户端未添加**/
	REQ_HEADER_TOKENIZE_REQUEST("req-header-tokenize-request", false),
	/**渠道**/
	REQ_HEADER_CHANNEL_SOURCE("req-header-channel-source", false);

	/**
	 * 请求头参数
	 */
	private String header;

	/**
	 * 是否需要参与签名
	 */
	private boolean isSign;

	/**
	 * @param header 请求头参数名称
	 * @param isSign 是否参与签名 
	 */
	RequestHeaderEnums(String header, boolean isSign) {
		this.header = header;
		this.isSign = isSign;
	}

	public String getHeader() {
		return header;
	}

	public boolean isSign() {
		return isSign;
	}
	
	/**
	 * 获得需要签名的请求头
	 * @return
	 */
	public static List<RequestHeaderEnums> getRequestSignHeader(){
		List<RequestHeaderEnums> headerList = Lists.newArrayList();
		RequestHeaderEnums headerEnums[] = values();
		for(RequestHeaderEnums enums : headerEnums){
			if(enums.isSign){
				headerList.add(enums);
			}
		}
		return headerList;
	}

	/**
	 * 根据请求头获取头信息
	 * @param header
	 * @return
	 */
	public static RequestHeaderEnums getRequestHeaderByHeader(String header){
		RequestHeaderEnums headerEnums[] = values();
		for(RequestHeaderEnums enums : headerEnums){
			if(enums.getHeader().equals(header)){
				return enums;
			}
		}
		return null;
	}
}
