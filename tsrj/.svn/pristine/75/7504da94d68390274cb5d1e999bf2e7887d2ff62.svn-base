package org.tsrj.common.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;
import org.tsrj.common.utils.ContextUtil;

import ch.qos.logback.ext.spring.web.WebLogbackConfigurer;

/**
 * 
 * @author xiaohaizi
 * @date   2017年4月9日 下午2:39:18
 */
public class StartupListener extends ContextLoaderListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		initLogging(servletContext);
		Logger logger = LoggerFactory.getLogger(StartupListener.class);
		logger.info("Starting application");
		super.contextInitialized(event);
		ContextUtil.getInstance().init(servletContext);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		WebLogbackConfigurer.shutdownLogging(event.getServletContext());
		super.contextDestroyed(event);
	}
	
	private void initLogging(ServletContext servletContext){
		String appName = servletContext.getInitParameter("appName");
		System.setProperty("appName", appName);
		System.setProperty("logHome", "/tsrj/"+appName);
	}
}
