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
public class SysFunctionDao extends BaseDao<SysFunction>{
    @Autowired
    private SysFunctionMapper sysFunctionMapper;
    public SysFunctionDao(){this.setBaseMapper(sysFunctionMapper);}
}
