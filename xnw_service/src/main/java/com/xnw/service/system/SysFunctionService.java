package com.xnw.service.system;

import com.xnw.persistence.dao.system.SysFunctionDao;
import com.xnw.persistence.model.system.SysFunction;
import com.xnw.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by BaoCai on 17/9/9.
 * Description:
 */
@Service
public class SysFunctionService extends BaseService<SysFunction>{
    @Autowired
    private SysFunctionDao sysFunctionDao;
    public SysFunctionService(){this.setBaseDao(sysFunctionDao);}
}
