package org.tsrj.common.web.interceptor;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.tsrj.common.contants.Constants;
import org.tsrj.common.domain.ResultBody;
import org.tsrj.common.web.util.RequestParamsUtil;
import org.tsrj.common.web.vo.UserSessionData;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class UserHandleInterceptor extends HandlerInterceptorAdapter {
	
	private Logger logger = LoggerFactory.getLogger(UserHandleInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod method = (HandlerMethod) handler;
		String name = method.getMethod().getName();
		UserSessionData usd = RequestParamsUtil.getSessionData(request);
		return super.preHandle(request, response, handler);
	}

	/**
	 * 是否在维护
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public boolean isMaintainace(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ResultBody result = new ResultBody<>();
		result.setResCode(-9999);
		JSONObject jb = new JSONObject();
		jb.put("msg", "系统正在维护");
		jb.put("title", "系统维护");
		result.setResMsg(jb.toJSONString());
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
		response.setContentType("application/json; charset=" + Constants.CHARSET_UTF8);
		String jsonString = JSON.toJSONString(result);
		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(jsonString.getBytes(Constants.CHARSET_UTF8));
		return true;
	}
}
