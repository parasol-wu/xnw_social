package com.xnw.persistence.mapper.system;

import com.xnw.constant.DataSourceConstant;
import com.xnw.persistence.model.system.SysRoleFunction;
import com.xnw.persistence.model.system.SysRoleFunctionConditions;
import com.xnw.persistence.shard.PartitionedTable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@PartitionedTable(DataSourceConstant.SYS)
public interface SysRoleFunctionMapper {
    int countByExample(SysRoleFunctionConditions example);

    int deleteByExample(SysRoleFunctionConditions example);

    int insert(SysRoleFunction record);

    int insertSelective(SysRoleFunction record);

    List<SysRoleFunction> selectByExample(SysRoleFunctionConditions example);

    int updateByExampleSelective(@Param("record") SysRoleFunction record, @Param("example") SysRoleFunctionConditions example);

    int updateByExample(@Param("record") SysRoleFunction record, @Param("example") SysRoleFunctionConditions example);
}