package com.xnw.persistence.mapper.system;

import com.xnw.constant.DataSourceConstant;
import com.xnw.persistence.model.system.SysRole;
import com.xnw.persistence.model.system.SysRoleConditions;
import com.xnw.persistence.shard.PartitionedTable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@PartitionedTable(DataSourceConstant.SYS)
public interface SysRoleMapper {
    int countByExample(SysRoleConditions example);

    int deleteByExample(SysRoleConditions example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleConditions example);

    SysRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleConditions example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleConditions example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}