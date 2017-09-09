package com.xnw.persistence.interceptors;

import com.xnw.persistence.domain.BaseDomain;
import com.xnw.persistence.shard.PartitionContext;
import com.xnw.persistence.shard.PartitionedTable;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by BaoCai on 17/9/1.
 * Description:
 */
public class MapperInterceptor implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        Class<?> entityClass = method.getDeclaringClass();

        //TODO 封装数据库通用操作

        //切换数据源
        if (entityClass.isAnnotationPresent(PartitionedTable.class)) {
            PartitionedTable partitionedTable = entityClass.getAnnotation(PartitionedTable.class);
            if (partitionedTable != null) {
                PartitionContext.setPartitionKey(partitionedTable.value());
            }
        } else {
            PartitionContext.setPartitionKey("default");
        }
    }
}
