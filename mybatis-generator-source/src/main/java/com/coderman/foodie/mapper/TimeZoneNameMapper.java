package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.TimeZoneName;
import java.util.List;

public interface TimeZoneNameMapper {
    int deleteByPrimaryKey(String name);

    int insert(TimeZoneName record);

    TimeZoneName selectByPrimaryKey(String name);

    List<TimeZoneName> selectAll();

    int updateByPrimaryKey(TimeZoneName record);
}