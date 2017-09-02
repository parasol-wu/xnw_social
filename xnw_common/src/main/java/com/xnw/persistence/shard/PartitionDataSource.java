package com.xnw.persistence.shard;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by BaoCai on 17/9/1.
 * Description: 动态数据源路由表
 */
public class PartitionDataSource extends AbstractRoutingDataSource {

    protected Object determineCurrentLookupKey() {
        return PartitionContext.getPartitionKey();
    }

}