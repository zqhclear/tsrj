package org.tsrj.common.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;

public class MapUtils extends org.apache.commons.collections.MapUtils{

	
	
	/**
	 * 转换
	 * @param map
	 * @return
	 */
	public static Map<String, String> toStringMap(Map<?, ?> map){
		Map<String, String> retMap = new HashMap<String, String>();
		if(map!=null){
			for(Map.Entry<?, ?> entry : map.entrySet()){
				String key = ObjectUtils.defaultIfNull(entry.getKey(), "").toString();
				String value = ObjectUtils.defaultIfNull(entry.getValue(), "").toString();
				retMap.put(key, value);
			}
		}
		return retMap;
	}
}
