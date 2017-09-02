package com.xnw.dao.mapper.test;

import com.xnw.dao.model.test.Student;
import com.xnw.dao.model.test.StudentConditions;
import com.xnw.persistence.shard.PartitionedTable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@PartitionedTable()
public interface StudentMapper {
    int countByExample(StudentConditions example);

    int deleteByExample(StudentConditions example);

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentConditions example);

    Student selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentConditions example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentConditions example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}