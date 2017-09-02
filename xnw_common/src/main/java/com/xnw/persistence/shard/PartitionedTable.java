package com.xnw.persistence.shard;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PartitionedTable {
	/**
	 * 数据源
	 * 
	 * @return
	 */
	String value() default "default";
}
