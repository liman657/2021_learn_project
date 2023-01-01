package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SetupActors;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SetupActorsMapper {
    int deleteByPrimaryKey(@Param("host") String host, @Param("user") String user, @Param("role") String role);

    int insert(SetupActors record);

    SetupActors selectByPrimaryKey(@Param("host") String host, @Param("user") String user, @Param("role") String role);

    List<SetupActors> selectAll();

    int updateByPrimaryKey(SetupActors record);
}