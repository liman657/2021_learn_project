package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Session;
import java.util.List;

public interface SessionMapper {
    int insert(Session record);

    List<Session> selectAll();
}