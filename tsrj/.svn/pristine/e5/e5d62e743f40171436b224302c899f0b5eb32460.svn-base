package org.tsrj.common.web.intercept;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.tsrj.common.enums.ResCodeEnums;
import org.tsrj.common.utils.StrUtils;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;

/**
 * 异常拦截
 * @author zhongqionghua
 *
 */
public class DefaultExceptionHandler implements HandlerExceptionResolver {

	private static Logger log = LoggerFactory.getLogger(DefaultExceptionHandler.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv = new ModelAndView();  
        FastJsonJsonView view = new FastJsonJsonView();  
        Map<String, Object> attributes = new HashMap<String, Object>();  
        attributes.put("resCode", ResCodeEnums.ERROR.getResCode()); 
        String msg = ex.getMessage();
        if(isContainChinese(msg)){
        	attributes.put("resMsg", msg);  
        }else{
        	attributes.put("resMsg", ResCodeEnums.ERROR.getResMsg()); 
        }
        attributes.put("resCode", -1);
        view.setAttributesMap(attributes);  
        mv.setView(view);   
        log.warn("系统异常:" + ex.getMessage(), ex);  
        return mv;  
	}
	
	public static boolean isContainChinese(String str) {
		if(StrUtils.isNotBlank(str)){
			Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
			Matcher m = p.matcher(str);
			if (m.find()) {
				return true;
			}
		}
        return false;
    }
	
}
