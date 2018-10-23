package org.tsrj.common.shard.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class PartitionDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return PartitionContext.getPartitionKey();
	}

}
