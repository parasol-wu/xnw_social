package com.xnw.persistence.dao.system;

import com.xnw.persistence.dao.BaseDao;
import com.xnw.persistence.mapper.system.SysFunctionMapper;
import com.xnw.persistence.model.system.SysFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by BaoCai on 17/9/9.
 * Description:
 */
@Repository
public class SysFunctionDao{
    @Autowired
    private SysFunctionMapper sysFunctionMapper;

    public void insert(SysFunction  model){
        sysFunctionMapper.insert(model);
    }

    public SysFunction findById(Integer id) {
        return sysFunctionMapper.selectByPrimaryKey(id);
    }
}
