package com.xnw.persistence.shard;

import org.apache.commons.lang.StringUtils;

/**
 * Created by BaoCai on 17/9/1.
 * Description: 切换数据元
 */
public class PartitionContext {

    /**
     * 本地线程缓存
     */
    private static final ThreadLocal<String> DATABASE = new ThreadLocal();

    private static String DEFAULT = "default";

    public static String getPartitionKey(){
        String partitionKey = DATABASE.get();
        return StringUtils.isNotEmpty(partitionKey)?partitionKey:DEFAULT;
    }

    public static void setPartitionKey(String partitionKey){
        DATABASE.set(partitionKey);
    }

}
