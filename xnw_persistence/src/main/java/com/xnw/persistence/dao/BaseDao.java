package com.xnw.persistence.dao;

import com.xnw.persistence.domain.BaseDomain;
import com.xnw.persistence.mapper.BaseMapper;

/**
 * Created by BaoCai on 17/9/9.
 * Description:baseDao：嵌入Dao编程，不完美
 */
public class BaseDao<T extends BaseDomain> {
    private BaseMapper baseMapper;

    public void setBaseMapper(BaseMapper baseMapper) {
        this.baseMapper = baseMapper;
    }

    public T findById(Integer id){
        return (T)baseMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id){
        baseMapper.deleteByPrimaryKey(id);
    }

    public void updateByModel(T model){
        baseMapper.updateByPrimaryKey(model);
    }

    public void insertModel(T model){
        baseMapper.insert(model);
    }
}
