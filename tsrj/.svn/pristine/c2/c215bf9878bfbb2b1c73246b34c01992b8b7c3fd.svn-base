package org.tsrj.common.web.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.tsrj.common.utils.StrUtils;


public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper{

	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}

  
    @Override  
    public String getHeader(String name) {  
        return StrUtils.htmlEncode(super.getHeader(name));  
    }  
  
    @Override  
    public String getQueryString() {  
        return StrUtils.htmlEncode(super.getQueryString());  
    }  
  
    @Override  
    public String getParameter(String name) {  
        return StrUtils.htmlEncode(super.getParameter(name));  
    }  
  
    @Override  
    public String[] getParameterValues(String name) {  
        String[] values = super.getParameterValues(name);  
        if(values != null) {  
            int length = values.length;  
            String[] escapseValues = new String[length];  
            for(int i = 0; i < length; i++){  
                escapseValues[i] = StrUtils.htmlEncode(values[i]);  
            }  
            return escapseValues;  
        }  
        return super.getParameterValues(name);  
    }  

    
	
}
