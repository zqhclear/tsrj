package org.tsrj.common.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tsrj.common.ConfigUtil;
import org.tsrj.common.web.wrapper.XssHttpServletRequestWrapper;


public class SafetyFilter implements Filter{

	private Logger logger = LoggerFactory.getLogger(SafetyFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if(ConfigUtil.getInstance().isDev()){
			System.out.println(((HttpServletRequest) request).getRequestURL());
		}
		chain.doFilter(new XssHttpServletRequestWrapper((HttpServletRequest) request), response);
	}

	@Override
	public void destroy() {
	}

}
