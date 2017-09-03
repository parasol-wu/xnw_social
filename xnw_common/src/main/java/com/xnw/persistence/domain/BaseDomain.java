package com.xnw.persistence.domain;

import java.time.LocalDateTime;
import java.util.Date;

public abstract class BaseDomain<T>  {
    /**
     * 数据库主键id获取
     *
     * @return
     */
    public abstract T getId();

    /**
     * 设置数据库主键id
     *
     * @param id
     */
    public abstract void setId(T id);

    /**
     * 设置创建时间
     *
     * @param createdAt
     */
    public abstract void setCreatedAt(LocalDateTime createdAt);

    /**
     * 设置修改时间
     *
     * @param updatedAt
     */
    public abstract void setUpdatedAt(LocalDateTime updatedAt);
}

