package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XSession;
import java.util.List;

public interface XSessionMapper {
    int insert(XSession record);

    List<XSession> selectAll();
}