package com.xnw.persistence.interceptors;

import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.sql.Connection;
import java.util.Properties;

/**
 * Created by BaoCai on 17/9/1.
 * Description:
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class ShardingInterceptor implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        //TODO  mybatis拦截器
        return invocation.proceed();
    }

    public Object plugin(Object o) {
        return o;
    }

    public void setProperties(Properties properties) {

    }
}
