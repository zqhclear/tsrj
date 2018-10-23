package org.tsrj.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.dozer.DozerBeanMapper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;

/**
 * 简单封装Dozer, 实现深度转换Bean<->Bean实现:
 * 
 * 1. 持有dozer的单例.
 * 2. 返回值类型转换.
 * 3. 批量转换Collection中的所有对象.
 * 4. 区分创建新的B对象与将对象A值复制到已存在的B对象两种函数. * 
 *
 */
public class BeanCopyUtil {

	/**
	 * 持有Dozer单例, 避免重复创建DozerMapper消耗资源.
	 */
	private static DozerBeanMapper dozer = new DozerBeanMapper();

	/**
	 * 基于Dozer转换对象的类型.
	 */
	public static <T> T map(Object source, Class<T> destinationClass) {
		if(source == null){
			return null;
		}
		return dozer.map(source, destinationClass);
	}

	/**
	 * 基于Dozer转换Collection中对象的类型.
	 */
	public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
		List<T> destinationList = Lists.newArrayList();
		for (Object sourceObject : sourceList) {
			T destinationObject = dozer.map(sourceObject, destinationClass);
			destinationList.add(destinationObject);
		}
		return destinationList;
	}
	/**
	 * 基于Dozer将对象A的值拷贝到对象B中.
	 */
	public static void copy(Object source, Object destinationObject) {
		dozer.map(source, destinationObject);
	}
	
	
	public static Map<String, Object> toMap(Object obj){
		Map<String, Object> resMap = new HashMap<String, Object>();
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			field.setAccessible(true);
			// 过滤内容为空的
			try {
				if (Modifier.isStatic(field.getModifiers()) || field.get(obj) == null) {
					continue;
				}
				resMap.put(field.getName(), field.get(obj));
			} catch (IllegalArgumentException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
		return resMap;
	}
	
	
	
	public static Map<String, String> toJsonMap(Object obj){
		Map<String, String> resMap = new HashMap<String, String>();
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			field.setAccessible(true);
			// 过滤内容为空的
			try {
				if (Modifier.isStatic(field.getModifiers()) || field.get(obj) == null) {
					continue;
				}
				Object value = field.get(obj);
				if(value!=null){
					resMap.put(field.getName(), JSON.toJSONString(value));
				}
			} catch (IllegalArgumentException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
		return resMap;
	}
	
	
	/**
	 * 转换成TreeMap
	 * @param obj
	 * @return      
	 * TreeMap<String,String>
	 */
	public static TreeMap<String, String> toTreeMap(Object obj){
		TreeMap<String, String> resMap = new TreeMap<String, String>();
		Field[] declaredFields = getAllField(obj.getClass());
		for (Field field : declaredFields) {
			field.setAccessible(true);
			// 过滤内容为空的
			try {
				if (Modifier.isStatic(field.getModifiers()) || field.get(obj) == null) {
					continue;
				}
				Object value = field.get(obj);
				if(value!=null){
					if(value instanceof String){
						resMap.put(field.getName(), value.toString());
					}else{
						resMap.put(field.getName(), JSON.toJSONString(value));
					}
				}
			} catch (IllegalArgumentException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
		return resMap;
	}
	
	
	
	/**
	 * 获取类clazz的所有Field，包括其父类的Field，如果重名，以子类Field为准。
	 * @param clazz
	 * @return Field数组
	 */
	public static Field[] getAllField(Class<?> clazz) {
		ArrayList<Field> fieldList = new ArrayList<Field>();
		Field[] dFields = clazz.getDeclaredFields();
		if (null != dFields && dFields.length > 0) {
			fieldList.addAll(Arrays.asList(dFields));
		}

		Class<?> superClass = clazz.getSuperclass();
		if (superClass != Object.class) {
			Field[] superFields = getAllField(superClass);
			if (null != superFields && superFields.length > 0) {
				for(Field field:superFields){
					if(!isContain(fieldList, field)){
						fieldList.add(field);
					}
				}
			}
		}
		Field[] result=new Field[fieldList.size()];
		fieldList.toArray(result);
		return result;
	}
	
	/**检测Field List中是否已经包含了目标field
	 * @param fieldList
	 * @param field 带检测field
	 * @return
	 */
	public static boolean isContain(ArrayList<Field> fieldList,Field field){
		for(Field temp:fieldList){
			if(temp.getName().equals(field.getName())){
				return true;
			}
		}
		return false;
	}
	
}