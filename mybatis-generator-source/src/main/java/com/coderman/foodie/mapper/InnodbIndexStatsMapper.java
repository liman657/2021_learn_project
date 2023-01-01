package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbIndexStats;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InnodbIndexStatsMapper {
    int deleteByPrimaryKey(@Param("databaseName") String databaseName, @Param("tableName") String tableName, @Param("indexName") String indexName, @Param("statName") String statName);

    int insert(InnodbIndexStats record);

    InnodbIndexStats selectByPrimaryKey(@Param("databaseName") String databaseName, @Param("tableName") String tableName, @Param("indexName") String indexName, @Param("statName") String statName);

    List<InnodbIndexStats> selectAll();

    int updateByPrimaryKey(InnodbIndexStats record);
}