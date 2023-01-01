package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SessionSslStatus;
import java.util.List;

public interface SessionSslStatusMapper {
    int insert(SessionSslStatus record);

    List<SessionSslStatus> selectAll();
}