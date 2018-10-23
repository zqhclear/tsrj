package org.tsrj.common.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.tsrj.common.enums.ResCodeEnums;
import org.tsrj.common.web.util.RequestParamsUtil;
import org.tsrj.common.web.vo.UserSessionData;

/**
 * 用户身份校验
 * @author zhognqionghua
 * @date   2018年02月09日 下午1:42:46
 */
public class TokenHandleInterceptor extends HandlerInterceptorAdapter {
	
	private Logger logger = LoggerFactory.getLogger(TokenHandleInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		UserSessionData sessionData = RequestParamsUtil.getSessionData(request);
		if(sessionData == null){
			RequestParamsUtil.resultData(response, ResCodeEnums.NO_LOGIN_ERROR);
			return false;
		}
		return super.preHandle(request, response, handler);
	}
}
