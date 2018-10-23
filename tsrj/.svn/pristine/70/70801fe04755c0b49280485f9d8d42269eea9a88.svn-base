package org.tsrj.common.shard.table.factory;




import java.util.List;
import java.util.Map;

import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.tsrj.common.shard.table.ShardStrategy;
import org.tsrj.common.utils.CamelCaseUtils;
import org.tsrj.common.utils.CollectionUtils;
import org.tsrj.common.utils.JsonUtils;
import org.tsrj.common.utils.StringUtils;

public class ModShardFactory extends ShardStrategy {

	@Override
	/**
	 * 按照特定字段取余数分表
	 * 策略：字段值为15，分表数量为5，进行15%5操作
	 * 返回"_0"
	 */
	public String getRouteValue() {
		if (boundSql != null) {
			// 获取sql参数列表
			List<ParameterMapping> maps = boundSql.getParameterMappings();
			if (CollectionUtils.isNotEmpty(maps)) {
				Object value = null;
				for (ParameterMapping mapping : maps) {
					if (mapping != null && mapping.getMode() != ParameterMode.OUT) {
						PropertyTokenizer prop = new PropertyTokenizer(mapping.getProperty());
						// condition 条件下数据库操作对应参数处理
						if (mapping.getProperty().startsWith(ForEachSqlNode.ITEM_PREFIX)
								&& boundSql.hasAdditionalParameter(prop.getName())) {
							Map<String, Object> map = JsonUtils.toMap(JsonUtils.toString(boundSql
                                    .getAdditionalParameter(prop.getName())));
							if (CollectionUtils.isNotEmpty(map)) {
								String key = (String) map.get("condition");
								if (StringUtils.isNotEmpty(key)) {
									key = key.replaceAll(" ", "").replaceAll("=", "");
									if (key.equals(segmentTable.shardBy())) {
										value = map.get("value");
										break;
									}
								}
							}
						}
						// insertBatch 相关sql操作处理
						else if (boundSql.hasAdditionalParameter(mapping.getProperty())) {
							// 将驼峰表示的字段名改为下划线 例如：shareBy -> share_by
							String key = CamelCaseUtils.camelName(segmentTable.shardBy());
							if (mapping.getProperty().equals(key)) {
								value = boundSql.getAdditionalParameter(mapping.getProperty());
								break;
							}
						}
					}
				}

				// 字段值取余获得表路由
				if (value != null && value instanceof Integer) {
					int num = (Integer) value % segmentTable.tableNum();

					if (segmentTable.tableNum() >= 10 && segmentTable.tableNum() < 100 && num < 10) {
						return "_0" + num;
					} else if (segmentTable.tableNum() >= 100) {
						if (num < 10) {
							return "_00" + num;
						} else if (num >= 10 && num < 100) {
							return "_0" + num;
						} else {
							return "_" + num;
						}
					} else {
						return "_" + num;
					}
				}
			}
		}
		return "";
	}
}
