package com.xnw.service.system;

import com.xnw.persistence.dao.system.SysFunctionDao;
import com.xnw.persistence.model.system.SysFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by BaoCai on 17/9/9.
 * Description:
 */
@Service
public class SysFunctionService{
    @Autowired
    private SysFunctionDao sysFunctionDao;

    public void insert(SysFunction model){
        sysFunctionDao.insert(model);
    }

    public SysFunction findById(Integer id){
        return sysFunctionDao.findById(id);
    }
}
