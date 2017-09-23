package com.xnw.persistence.dao.system;

import com.xnw.constant.StateConstant;
import com.xnw.persistence.dao.BaseDao;
import com.xnw.persistence.mapper.system.SysFunctionMapper;
import com.xnw.persistence.model.system.SysFunction;
import com.xnw.persistence.model.system.SysFunctionConditions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<SysFunction> findAllFunction() {
        SysFunctionConditions condition = new SysFunctionConditions();
        SysFunctionConditions.Criteria criteria = condition.createCriteria();
        criteria.andStateEqualTo(StateConstant.STATE_TRUE);
        return sysFunctionMapper.selectByExample(condition);
    }
}
