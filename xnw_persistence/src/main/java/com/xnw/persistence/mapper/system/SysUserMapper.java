package com.xnw.persistence.mapper.system;

import com.xnw.constant.DataSourceConstant;
import com.xnw.persistence.model.system.SysUser;
import com.xnw.persistence.model.system.SysUserConditions;
import com.xnw.persistence.shard.PartitionedTable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@PartitionedTable(DataSourceConstant.SYS)
public interface SysUserMapper {
    int countByExample(SysUserConditions example);

    int deleteByExample(SysUserConditions example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserConditions example);

    SysUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserConditions example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserConditions example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}