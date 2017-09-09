package com.xnw.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


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
