package com.xnw.persistence.mapper;

import com.xnw.persistence.domain.BaseDomain;

/**
 * Created by BaoCai on 17/9/9.
 * Description:
 */
public interface BaseMapper<T extends BaseDomain> {

    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

}
