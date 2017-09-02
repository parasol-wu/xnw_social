package Mapper;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xnw.dao.mapper.test.StudentMapper;
import com.xnw.dao.model.test.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by BaoCai on 17/9/2.
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application.xml"})
public class MapperTest {

    @Resource
    private StudentMapper studentMapper;

    @Test
    public void testMapper() throws Exception {
        Student student = new Student();
        student.setName("nie datou");
        student.setSex(2);
        student.setCreatedAt(new Date());
        student.setUpdatedAt(new Date());

        studentMapper.insert(student);
    }
}
