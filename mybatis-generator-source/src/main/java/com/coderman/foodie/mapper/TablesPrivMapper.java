package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.TablesPriv;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TablesPrivMapper {
    int deleteByPrimaryKey(@Param("host") String host, @Param("db") String db, @Param("user") String user, @Param("tableName") String tableName);

    int insert(TablesPriv record);

    TablesPriv selectByPrimaryKey(@Param("host") String host, @Param("db") String db, @Param("user") String user, @Param("tableName") String tableName);

    List<TablesPriv> selectAll();

    int updateByPrimaryKey(TablesPriv record);
}