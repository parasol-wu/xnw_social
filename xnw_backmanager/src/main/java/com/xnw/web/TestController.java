package com.xnw.web;

import com.xnw.dao.mapper.test.StudentMapper;
import com.xnw.dao.model.test.Student;
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

    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/index")
    public String index(ModelMap modelMap){
        modelMap.put("hello","hello");
        Student student = new Student();
        student.setName("nie datou");
        student.setSex(2);
        student.setCreatedAt(new Date());
        student.setUpdatedAt(new Date());
        studentMapper.insert(student);
        return "hello";
    }

}
