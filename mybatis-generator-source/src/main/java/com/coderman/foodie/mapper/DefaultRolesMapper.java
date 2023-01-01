package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.DefaultRoles;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DefaultRolesMapper {
    int deleteByPrimaryKey(@Param("host") String host, @Param("user") String user, @Param("defaultRoleHost") String defaultRoleHost, @Param("defaultRoleUser") String defaultRoleUser);

    int insert(DefaultRoles record);

    List<DefaultRoles> selectAll();
}