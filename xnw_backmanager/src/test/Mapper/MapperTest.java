package Mapper;

import com.xnw.dao.mapper.test.StudentMapper;
import com.xnw.dao.model.test.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by BaoCai on 17/9/2.
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application.xml"})
public class MapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private SqlSessionFactoryBean sqlSessionFactory;

    @Test
    public void testMapper(){
        Student student = new Student();
        student.setName("nie datou");
        student.setSex(2);
        student.setCreatedAt(new Date());
        student.setUpdatedAt(new Date());
        studentMapper.insert(student);
    }
}
