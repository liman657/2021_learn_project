package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ColumnsPriv;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ColumnsPrivMapper {
    int deleteByPrimaryKey(@Param("host") String host, @Param("db") String db, @Param("user") String user, @Param("tableName") String tableName, @Param("columnName") String columnName);

    int insert(ColumnsPriv record);

    ColumnsPriv selectByPrimaryKey(@Param("host") String host, @Param("db") String db, @Param("user") String user, @Param("tableName") String tableName, @Param("columnName") String columnName);

    List<ColumnsPriv> selectAll();

    int updateByPrimaryKey(ColumnsPriv record);
}