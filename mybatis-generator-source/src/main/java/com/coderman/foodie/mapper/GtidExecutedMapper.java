package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.GtidExecuted;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GtidExecutedMapper {
    int deleteByPrimaryKey(@Param("sourceUuid") String sourceUuid, @Param("intervalStart") Long intervalStart);

    int insert(GtidExecuted record);

    GtidExecuted selectByPrimaryKey(@Param("sourceUuid") String sourceUuid, @Param("intervalStart") Long intervalStart);

    List<GtidExecuted> selectAll();

    int updateByPrimaryKey(GtidExecuted record);
}