package org.tsrj.common.shard.table;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.tsrj.common.shard.table.factory.ShardFactory;
import org.tsrj.common.utils.ReflectUtils;
import org.tsrj.common.utils.StringUtils;

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class ShardingInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// 拦截器拦截点对象获取
		RoutingStatementHandler routingStatementHandler = (RoutingStatementHandler) invocation.getTarget();
		if (routingStatementHandler != null) {
			// 通过反射获取预处理对象
			StatementHandler statementHandler = (StatementHandler) ReflectUtils.getFieldValue(routingStatementHandler,
                    "delegate");
			if (statementHandler != null) {
				// 通过MappedStatement获取id从而获得方法从属对象
				MappedStatement mappedStatement = (MappedStatement) ReflectUtils.getFieldValue(statementHandler,
                        "mappedStatement");
				if (mappedStatement != null) {
					// 或者相关mapper类
					Class<?> classObj = Class.forName(StringUtils.substring(mappedStatement.getId(), mappedStatement
                            .getId().lastIndexOf(".")));
					if (classObj != null) {
						BoundSql boundSql = statementHandler.getBoundSql();
						if (boundSql != null) {
							String sql = boundSql.getSql();
							if (classObj.isAnnotationPresent(SegmentTable.class)) {
								SegmentTable segmentTable = classObj.getAnnotation(SegmentTable.class);

								String routeKey = getShardRoute(boundSql, segmentTable);
								if (StringUtils.isNotEmpty(routeKey)) {
									sql = sql.replaceAll(segmentTable.table(), segmentTable.table() + routeKey);
								}
							}
							ReflectUtils.setFieldValue(boundSql, "sql", sql.replaceAll(" key,", " `key`,").replaceAll(" key ", " `key` "));
						}
					}
				}
			}
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		if (target instanceof StatementHandler) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}

	@Override
	public void setProperties(Properties properties) {

	}

	/**
	 * 获取分表的路由key
	 *
	 * @param boundSql
	 *            sql对象
	 * @param segmentTable
	 *            分表对象
	 * @return
	 */
	private String getShardRoute(BoundSql boundSql, SegmentTable segmentTable) {
		if (boundSql != null && segmentTable != null) {
			return ShardFactory.createShardFactory(segmentTable.shardType()).boundSql(boundSql)
					.segmentTable(segmentTable).getRouteValue();
		}
		return "";
	}

}
