package org.tsrj.common.web.converter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import com.alibaba.fastjson.serializer.ValueFilter;

/**
 * json 序列化， 自定义过滤字段
 * @author: 
 * @date:   2017年3月9日 上午11:22:19   
 *
 */
public class CustomPropertyPreFilter implements PropertyPreFilter, ValueFilter {
	
    public CustomPropertyPreFilter() {
        super();
    }

	@Override
	public Object process(Object object, String name, Object value) {
		if(value == null){
			return value;
		}
		Class cla = object.getClass();
		try {
			if(cla.isInstance(Map.class) || name.equals("resCode") || name.equals("resMsg")  || name.equals("resTime")){
				if(name.equals("resMsg")){
					if(value != null && value.toString().indexOf("Exception") > 0){
						value = "系统出现了些问题，请稍候再试";
					}
				}
				return value;
			}
			return formatObjectValue(cla, name, value);
		} catch (NoSuchFieldException e) {
			// TODO 直接忽略吧
		} catch (SecurityException e) {
			// TODO 直接忽略吧
		}
		return value;
	}

	@Override
	public boolean apply(JSONSerializer serializer, Object object, String name) {
		return true;
	}

	/**
	 * 格式化值的输出
	 * @param cla
	 * @param name
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	private Object formatObjectValue(Class cla, String name, Object value) throws NoSuchFieldException, SecurityException{
		Field field = cla.getDeclaredField(name);
		if(field != null){
			Annotation[] annArray = field.getAnnotations();
			if(annArray != null && annArray.length > 0){
				for(Annotation an : annArray){
					Class annotation = an.annotationType();
					//此处可以自定义格式化输出
				}
			}else{
				if(field.getType().getName().equals("java.math.BigDecimal")){
					value = ((BigDecimal)value).setScale(2, RoundingMode.DOWN);
				}
			}
		}
		return value;
	}
   

}
