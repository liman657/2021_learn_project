package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.TimeZoneTransition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TimeZoneTransitionMapper {
    int deleteByPrimaryKey(@Param("timeZoneId") Integer timeZoneId, @Param("transitionTime") Long transitionTime);

    int insert(TimeZoneTransition record);

    TimeZoneTransition selectByPrimaryKey(@Param("timeZoneId") Integer timeZoneId, @Param("transitionTime") Long transitionTime);

    List<TimeZoneTransition> selectAll();

    int updateByPrimaryKey(TimeZoneTransition record);
}