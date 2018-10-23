package org.tsrj.common.utils;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * 应用上下文工具
 *
 */
public final class ContextUtil {
	private final static ContextUtil instance = new ContextUtil();

	private final Logger logger = LoggerFactory.getLogger(ContextUtil.class);

	private ServletContext servletContext = null;

	private ApplicationContext springContext = null;

	private ContextUtil() {
	}

	public final static ContextUtil getInstance() {
		return instance;
	}

	public static ServletContext getServletContext() {
		return getInstance().servletContext;
	}

	public static Object getSpringBeanById(String beanId) {
		return getInstance().springContext.getBean(beanId);
	}

	public static ApplicationContext getSpringContext() {
		return getInstance().springContext;
	}
	
	public void setSpringContext(ApplicationContext act){
		this.springContext = act;
	}

	public void cleanup() {
		this.servletContext = null;
		this.springContext = null;
	}

	public long getStartupTime() {
		return this.springContext.getStartupDate();
	}

	public void init(ServletContext servletContext) {
		this.servletContext = servletContext;
		this.springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		logger.info("初始化应用上下文");
	}

	public boolean isFileExists(String relativeFilePath) {
		return new File(servletContext.getRealPath(relativeFilePath)).exists();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getServletContextRealPath(){
		return getServletContext().getRealPath("/");
	}
	

	/**
	 * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		return (T) getSpringContext().getBean(name);
	}

	/**
	 * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 */
	public static <T> T getBean(Class<T> requiredType) {
		return getSpringContext().getBean(requiredType);
	}
}
