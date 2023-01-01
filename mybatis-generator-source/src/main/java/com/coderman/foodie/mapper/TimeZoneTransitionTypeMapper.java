package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.TimeZoneTransitionType;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TimeZoneTransitionTypeMapper {
    int deleteByPrimaryKey(@Param("timeZoneId") Integer timeZoneId, @Param("transitionTypeId") Integer transitionTypeId);

    int insert(TimeZoneTransitionType record);

    TimeZoneTransitionType selectByPrimaryKey(@Param("timeZoneId") Integer timeZoneId, @Param("transitionTypeId") Integer transitionTypeId);

    List<TimeZoneTransitionType> selectAll();

    int updateByPrimaryKey(TimeZoneTransitionType record);
}