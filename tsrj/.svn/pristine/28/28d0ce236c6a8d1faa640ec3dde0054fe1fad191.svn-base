package org.tsrj.common.shard.table.factory;

import org.tsrj.common.shard.table.ShardStrategy;
import org.tsrj.common.utils.ConstUtil.DataSource.ShardType;

public class ShardFactory {

	public static ShardStrategy createShardFactory(ShardType type) {
		ShardStrategy factory = null;

		switch (type) {
		case DATA:
			factory = new DataShardFactory();
			break;
		case MOD:
			factory = new ModShardFactory();
			break;
		default:
			break;
		}
		return factory;
	}
}
