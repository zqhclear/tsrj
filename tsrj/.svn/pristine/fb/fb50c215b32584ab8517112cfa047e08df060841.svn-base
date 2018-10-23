package org.tsrj.common.handler;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.tsrj.common.contants.Constants;
import org.tsrj.common.utils.WebUtil;


/**
 * App 请求服务端的处理类
 * @author Saleson Lee.
 * @date 2016年7月12日
 * @time 下午3:21:55
 */
public class RequestHandler {

	private static RequestHandler handler = null;

	private RequestHolderThreadLocal holderThreadLocal = new RequestHolderThreadLocal();

	/**
	 * 不对外开放
	 */
	private RequestHandler() {

	}

	/**
	 * 返回实例对象
	 * 
	 * @return
	 */
	public static RequestHandler getInstance() {
		if (handler == null) {
			synchronized (RequestHandler.class) {
				if (handler == null) {
					handler = new RequestHandler();
				}
			}
		}
		return handler;
	}

	
	/**
	 * 创建当前请求的RequestHolder对象并赋值
	 * @param request
	 */
	public void createCurrentRequestHolder(HttpServletRequest request) {
		RequestHolder holder = holderThreadLocal.get();
		holder.setChannelId(request.getHeader(Constants.API_CHANNEL_ID));
		holder.setDeviceSerialNumber(request.getHeader(Constants.API_DEVICE_SERIAL_NUMBER));
		String deviceType = request.getHeader(Constants.API_DEVICE_TYPE);
		holder.setDeviceType(StringUtils.isNotEmpty(deviceType) ? Integer.valueOf(deviceType) : 0);
		holder.setDevice(request.getHeader(Constants.API_DEVICE));
		String memberId = (String) request.getAttribute(Constants.API_MEMBER_ID);
		holder.setMemberId(StringUtils.isNotEmpty(memberId) ? Long.valueOf(memberId) : 0L);
		holder.setMemberMobile((String) request.getAttribute(Constants.API_MEMBER_MOBILE));
		holder.setAppVersion(request.getHeader(Constants.APP_VERSION));
		holder.setAcceptVersion(request.getHeader(Constants.API_ACCEPT_VERSION));
		holder.setRequestTime(request.getHeader(Constants.API_REQUEST_TIME));
		String ip = "";
		if(holder.getDeviceType() == Constants.API_DEVICE_TYPE_WAP){
			ip = request.getHeader(Constants.API_IP);
			if(StringUtils.isEmpty(ip)){
				ip = request.getParameter("ip");
			}
			if(StringUtils.isEmpty(ip)){
				ip = WebUtil.getIp(request);
			}
		}else{
			ip = WebUtil.getIp(request);
		}
		holder.setIp(ip);
	}
	
	/**
	 * 返回当前线程中的RequestHolder对象
	 * @return
	 */
	public static RequestHolder currentRequestHolder(){
		return getInstance().holderThreadLocal.get();
	}
	

	private static class RequestHolderThreadLocal extends
			ThreadLocal<RequestHolder> {

		@Override
		protected RequestHolder initialValue() {
			return new RequestHolder();
		}
	}
	
	/**
	 * 删除当前线程中的RequestHolder对象
	 */
	public void removeRequestHolder(){
		holderThreadLocal.remove();
	}
}
