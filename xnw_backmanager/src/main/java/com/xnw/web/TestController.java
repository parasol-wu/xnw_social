package com.xnw.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by BaoCai on 17/8/26.
 * Description:
 */
@Controller
public class TestController {


    @RequestMapping("/")
    public String index(ModelMap modelMap) {
        return "index/index";
    }

}
