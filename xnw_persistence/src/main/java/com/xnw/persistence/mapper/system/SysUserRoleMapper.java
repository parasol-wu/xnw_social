package com.xnw.persistence.mapper.system;

import com.xnw.constant.DataSourceConstant;
import com.xnw.persistence.model.system.SysUserRole;
import com.xnw.persistence.model.system.SysUserRoleConditions;
import com.xnw.persistence.shard.PartitionedTable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@PartitionedTable(DataSourceConstant.SYS)
public interface SysUserRoleMapper {
    int countByExample(SysUserRoleConditions example);

    int deleteByExample(SysUserRoleConditions example);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    List<SysUserRole> selectByExample(SysUserRoleConditions example);

    int updateByExampleSelective(@Param("record") SysUserRole record, @Param("example") SysUserRoleConditions example);

    int updateByExample(@Param("record") SysUserRole record, @Param("example") SysUserRoleConditions example);
}