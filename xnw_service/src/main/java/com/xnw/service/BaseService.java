package com.xnw.service;

import com.xnw.persistence.dao.BaseDao;
import com.xnw.persistence.domain.BaseDomain;

/**
 * Created by BaoCai on 17/9/9.
 * Description:
 */
public class BaseService<T extends BaseDomain> {
    private BaseDao baseDao;

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    public T findById(Integer id){
        return (T)baseDao.findById(id);
    }

    public void deleteById(Integer id){
        baseDao.deleteById(id);
    }

    public void updateByModel(T model){
        baseDao.updateByModel(model);
    }

    public void insertModel(T model){
        baseDao.insertModel(model);
    }
}
