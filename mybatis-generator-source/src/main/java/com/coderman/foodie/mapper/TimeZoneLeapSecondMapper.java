package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.TimeZoneLeapSecond;
import java.util.List;

public interface TimeZoneLeapSecondMapper {
    int deleteByPrimaryKey(Long transitionTime);

    int insert(TimeZoneLeapSecond record);

    TimeZoneLeapSecond selectByPrimaryKey(Long transitionTime);

    List<TimeZoneLeapSecond> selectAll();

    int updateByPrimaryKey(TimeZoneLeapSecond record);
}