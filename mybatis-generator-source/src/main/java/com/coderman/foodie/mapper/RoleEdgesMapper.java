package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.RoleEdges;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleEdgesMapper {
    int deleteByPrimaryKey(@Param("fromHost") String fromHost, @Param("fromUser") String fromUser, @Param("toHost") String toHost, @Param("toUser") String toUser);

    int insert(RoleEdges record);

    RoleEdges selectByPrimaryKey(@Param("fromHost") String fromHost, @Param("fromUser") String fromUser, @Param("toHost") String toHost, @Param("toUser") String toUser);

    List<RoleEdges> selectAll();

    int updateByPrimaryKey(RoleEdges record);
}