package org.tsrj.common.shard.table;

import org.apache.ibatis.mapping.BoundSql;

public abstract class ShardStrategy {

	/**
	 * sql对象
	 */
	protected BoundSql boundSql;

	/**
	 * 分表对象
	 */
	protected SegmentTable segmentTable;

	public abstract String getRouteValue();

	public ShardStrategy boundSql(BoundSql value) {
		setBoundSql(value);
		return this;
	}

	public ShardStrategy segmentTable(SegmentTable value) {
		setSegmentTable(value);
		return this;
	}

	public BoundSql getBoundSql() {
		return boundSql;
	}

	public void setBoundSql(BoundSql boundSql) {
		this.boundSql = boundSql;
	}

	public SegmentTable getSegmentTable() {
		return segmentTable;
	}

	public void setSegmentTable(SegmentTable segmentTable) {
		this.segmentTable = segmentTable;
	}
}
