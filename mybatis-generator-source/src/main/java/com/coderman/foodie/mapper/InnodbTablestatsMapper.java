package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbTableStats;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InnodbTableStatsMapper {
    int deleteByPrimaryKey(@Param("databaseName") String databaseName, @Param("tableName") String tableName);

    int insert(InnodbTableStats record);

    InnodbTableStats selectByPrimaryKey(@Param("databaseName") String databaseName, @Param("tableName") String tableName);

    List<InnodbTableStats> selectAll();

    int updateByPrimaryKey(InnodbTableStats record);
}