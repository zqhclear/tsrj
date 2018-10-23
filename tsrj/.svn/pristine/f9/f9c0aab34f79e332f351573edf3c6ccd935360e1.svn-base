package org.tsrj.common.shard.database;

import org.tsrj.common.utils.StringUtils;

public final class PartitionContext {

	private static final ThreadLocal<String> DATABASE = new ThreadLocal<String>();

	public static void set(String partition) {
		setPartitionSeed(partition);
	}

	public static void clear() {
		clearPartitionSeed();
	}

	public static void setPartitionSeed(String partition) {
		if (StringUtils.isNotEmpty(partition)) {
			try {
				DATABASE.set(partition);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	public static String getPartitionKey() {
		String partition = DATABASE.get();
		return StringUtils.isNotEmpty(partition) ? partition : "default";
	}

	public static void clearPartitionSeed() {
		try {
			DATABASE.remove();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
