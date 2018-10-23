package org.tsrj.api.interceptor;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.tsrj.common.handler.RequestHandler;
import org.tsrj.common.handler.RequestHolder;
import org.tsrj.service.event.EventService;


/**
 * 操作事件发布
 */
public class AccessHandlerInterceptor extends HandlerInterceptorAdapter
{
    private static Logger accessLogger = LoggerFactory.getLogger(AccessHandlerInterceptor.class);
    private static final String SPILT = " | ";

    @Resource
    private EventService eventService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        RequestHandler.getInstance().createCurrentRequestHolder(request);
        RequestHolder holder = RequestHandler.currentRequestHolder();
        String ip = holder.getIp();
        long memberId = holder.getMemberId();
        String device = holder.getDevice();
        int deviceType = holder.getDeviceType();
        String appVer = holder.getAppVersion();
        return super.preHandle(request, response, handler);
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception
    {
        super.postHandle(request, response, handler, modelAndView);
        eventService.publishCurrentThreadOperateEvent();
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception
    {
        super.afterCompletion(request, response, handler, ex);
        RequestHandler.getInstance().removeRequestHolder();
    }

}
