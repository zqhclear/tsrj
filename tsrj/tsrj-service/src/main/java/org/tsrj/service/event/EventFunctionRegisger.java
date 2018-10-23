package org.tsrj.service.event;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.collections.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.tsrj.common.httpclient.httpclient.common.util.PropertiesUtil;
import org.tsrj.common.utils.StrUtils;
import org.tsrj.service.event.function.MemberRegisterFunction;


@Component
public class EventFunctionRegisger implements ApplicationContextAware {
	private static final Logger LOG = LoggerFactory.getLogger(EventFunctionRegisger.class);

	private ApplicationContext ctx = null;
	@SuppressWarnings("rawtypes")
	static Map<Class<? extends Event>, EventFunctionMemorizer> mapping = new HashMap<>();
	
	/**
	 * 注册事件
	 */
	protected void registerEventFunction(){
		register(EventType.MemberRegisted, MemberRegisterFunction.class);
	}
	
	/**
	 * 注册事件函数
	 * @param et
	 * @param function
	 */
	@SuppressWarnings("unchecked")
	protected <E extends Event> void register(EventType et, Class<? extends EventFunction<E>> cls){
		LOG.info("[Event]注册{}事件-->{}", et.getDescribe(), cls);
		try {
			EventFunction<E> function = ctx.getBean(
					StrUtils.firstLowerCase(cls.getSimpleName()),
					EventFunction.class);
			if (function == null) {
				LOG.error("[Event]没有找到"+ StrUtils.firstLowerCase(cls.getSimpleName()));
				throw new RuntimeException("没有找到"
						+ StrUtils.firstLowerCase(cls.getSimpleName()));
				
			}
			register(et.getType(), function, cls);
		} catch (Exception e) {
			LOG.error("[Event]{}事件注入{}类型时出错:{}", et, cls, e.getMessage());
			if (PropertiesUtil.isDev()) {
				throw e;
			}
		}
	}
		
	/**
	 * 注册事件函数
	 * @param type
	 * @param function
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected static <E extends Event> void register(Integer type, EventFunction<E> function, Class<? extends EventFunction<E>> functionCls){
		Class<? extends Event> cls = getInterfaceParameterizedType(functionCls);
		EventFunctionMemorizer memorizer = mapping.get(cls);
		if(memorizer==null){
			memorizer = new EventFunctionMemorizer<E>();
			mapping.put(cls, memorizer);
		}
		memorizer.register(type, function);
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	@SuppressWarnings({"unchecked", "rawtypes" })
	public static Iterator<EventFunction<Event>> interatorEventFunction(Event event){
		Class<? extends Event> cls = event.getClass();
		EventFunctionMemorizer memorizer = mapping.get(cls);
		if(memorizer==null){
			return IteratorUtils.EMPTY_LIST_ITERATOR;
		}
		return memorizer.interatorEventFunction(event.getType());
	}
		
	@SuppressWarnings("unchecked")
	private static <E extends Event> Class<? extends Event> getInterfaceParameterizedType(Class<? extends EventFunction<E>> functionCls){
		Type t = functionCls.getGenericInterfaces()[0];
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			return (Class<? extends Event>) p[0];
		}
		return null;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ctx = applicationContext;
		registerEventFunction();
	}

}
