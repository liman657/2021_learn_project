package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Db;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbMapper {
    int deleteByPrimaryKey(@Param("host") String host, @Param("db") String db, @Param("user") String user);

    int insert(Db record);

    Db selectByPrimaryKey(@Param("host") String host, @Param("db") String db, @Param("user") String user);

    List<Db> selectAll();

    int updateByPrimaryKey(Db record);
}