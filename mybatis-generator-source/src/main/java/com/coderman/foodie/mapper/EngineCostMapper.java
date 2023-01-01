package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EngineCost;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EngineCostMapper {
    int deleteByPrimaryKey(@Param("costName") String costName, @Param("engineName") String engineName, @Param("deviceType") Integer deviceType);

    int insert(EngineCost record);

    EngineCost selectByPrimaryKey(@Param("costName") String costName, @Param("engineName") String engineName, @Param("deviceType") Integer deviceType);

    List<EngineCost> selectAll();

    int updateByPrimaryKey(EngineCost record);
}