package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XProcesslist;
import java.util.List;

public interface XProcesslistMapper {
    int insert(XProcesslist record);

    List<XProcesslist> selectAll();
}