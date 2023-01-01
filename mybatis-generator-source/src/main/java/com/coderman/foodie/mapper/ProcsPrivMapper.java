package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ProcsPriv;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcsPrivMapper {
    int deleteByPrimaryKey(@Param("host") String host, @Param("db") String db, @Param("user") String user, @Param("routineName") String routineName, @Param("routineType") String routineType);

    int insert(ProcsPriv record);

    ProcsPriv selectByPrimaryKey(@Param("host") String host, @Param("db") String db, @Param("user") String user, @Param("routineName") String routineName, @Param("routineType") String routineType);

    List<ProcsPriv> selectAll();

    int updateByPrimaryKey(ProcsPriv record);
}