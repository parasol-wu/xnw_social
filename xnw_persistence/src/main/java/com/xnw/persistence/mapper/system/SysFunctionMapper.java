package com.xnw.persistence.mapper.system;

import com.xnw.constant.DataSourceConstant;
import com.xnw.persistence.model.system.SysFunction;
import com.xnw.persistence.model.system.SysFunctionConditions;
import com.xnw.persistence.shard.PartitionedTable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@PartitionedTable(DataSourceConstant.SYS)
public interface SysFunctionMapper {
    int countByExample(SysFunctionConditions example);

    int deleteByExample(SysFunctionConditions example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysFunction record);

    int insertSelective(SysFunction record);

    List<SysFunction> selectByExample(SysFunctionConditions example);

    SysFunction selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysFunction record, @Param("example") SysFunctionConditions example);

    int updateByExample(@Param("record") SysFunction record, @Param("example") SysFunctionConditions example);

    int updateByPrimaryKeySelective(SysFunction record);

    int updateByPrimaryKey(SysFunction record);
}