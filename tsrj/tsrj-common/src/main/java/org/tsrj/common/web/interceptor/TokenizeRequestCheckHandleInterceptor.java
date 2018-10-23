package org.tsrj.common.web.interceptor;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.tsrj.common.enums.ResCodeEnums;
import org.tsrj.common.redis.TokenizeRequestRedisUtil;
import org.tsrj.common.web.RequestHeaderEnums;
import org.tsrj.common.web.util.RequestParamsUtil;
import org.tsrj.common.web.vo.UserSessionData;

/**
 * 防止表单重复提交
 */
public class TokenizeRequestCheckHandleInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//取出缓存中的token
		UserSessionData userSessionData = RequestParamsUtil.getSessionData(request);
		Long memberId = userSessionData != null ? userSessionData.getId() : 0;
		String tokenSetBefore = TokenizeRequestRedisUtil.getTokenizeRequest(memberId);
		//request的token
		String tokenBring = request.getHeader(RequestHeaderEnums.REQ_HEADER_TOKENIZE_REQUEST.getHeader());
		//比较
		if (!Objects.equals(tokenBring, tokenSetBefore)) {
			RequestParamsUtil.resultData(response, ResCodeEnums.ACTIVITY_TOKENIZE_FAILED);
			return false;
		}
		TokenizeRequestRedisUtil.delTokenizeRequest(memberId);
		return super.preHandle(request, response, handler);
	}
}
