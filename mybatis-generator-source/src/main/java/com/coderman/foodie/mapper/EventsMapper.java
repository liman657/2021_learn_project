package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Events;
import java.util.List;

public interface EventsMapper {
    int insert(Events record);

    List<Events> selectAll();
}