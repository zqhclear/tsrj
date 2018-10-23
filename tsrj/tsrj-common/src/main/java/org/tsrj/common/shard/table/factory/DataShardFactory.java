package org.tsrj.common.shard.table.factory;




import java.util.Date;
import java.util.Map;

import org.tsrj.common.shard.table.ShardStrategy;
import org.tsrj.common.utils.ReflectUtils;
import org.tsrj.common.utils.TimeUtils;

public class DataShardFactory extends ShardStrategy {

	@Override
	/**
	 * 按照日期分表，返回当前表路由
	 * 例如：_2014_10
	 */
	public String getRouteValue() {
		Object dateParamObject = getDateOfParameter();
		Date shardDate = (Date) dateParamObject;
		if (shardDate == null) {
			shardDate = new Date();
		}
		String data = TimeUtils.toString("yyyy_MM", shardDate);
		return "_" + data;
	}

	/**
	 * @param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Object getDateOfParameter() {
		Object dateParamObject = null;
		Object parameterObject = boundSql.getParameterObject();
		if (parameterObject != null) {
			if (Map.class.isAssignableFrom(parameterObject.getClass())) {
				for (Map.Entry<String, Object> entry : ((Map<String, Object>) parameterObject).entrySet()) {
					if ("shardDate".equals(entry.getKey())) {
						dateParamObject = entry.getValue();
					} else {
						dateParamObject = ReflectUtils.getFieldValue(entry.getValue(), "shardDate");
					}
					if (dateParamObject != null) {
						break;
					}
				}
			} else {
				dateParamObject = ReflectUtils.getFieldValue(parameterObject, "shardDate");
			}
		}
		return dateParamObject;
	}
}
