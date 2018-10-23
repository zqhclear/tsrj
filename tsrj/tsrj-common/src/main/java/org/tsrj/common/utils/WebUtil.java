package org.tsrj.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.tsrj.common.contants.Constants;

import com.alibaba.fastjson.JSON;

public class WebUtil {

	public static void renderMergedOutputModel(Object result, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
//		response.setContentType("application/json; charset="+Constants.CHARSET_UTF8);
		response.setContentType("text/html;charset=UTF-8");
		String jsonString = JSON.toJSONString(result);
		response.getWriter().write(jsonString);
	}
	
	
	
	/**
	 * 获取请求的IP
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (StringUtils.isNotBlank(ip) && ip.indexOf(",") > 0) {
			ip = ip.substring(0, ip.indexOf(","));
		}
		return ip;
	}
}
