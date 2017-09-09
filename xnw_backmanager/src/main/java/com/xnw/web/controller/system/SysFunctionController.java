package com.xnw.web.controller.system;

import com.xnw.persistence.model.system.SysFunction;
import com.xnw.service.system.SysFunctionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by BaoCai on 17/9/9.
 * Description:
 */
@Controller
public class SysFunctionController {

    @Autowired
    private SysFunctionService sysFunctionService;

    @RequestMapping(value = "/sys_function/insert",method = RequestMethod.POST)
    @ResponseBody
    public String insertFunction(SysFunction sysFunction){
        sysFunctionService.insert(sysFunction);
        return " 终于不乱吗了！";
    }
}
