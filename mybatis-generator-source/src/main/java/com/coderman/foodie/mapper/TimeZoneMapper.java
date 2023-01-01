package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.TimeZone;
import java.util.List;

public interface TimeZoneMapper {
    int deleteByPrimaryKey(Integer timeZoneId);

    int insert(TimeZone record);

    TimeZone selectByPrimaryKey(Integer timeZoneId);

    List<TimeZone> selectAll();

    int updateByPrimaryKey(TimeZone record);
}