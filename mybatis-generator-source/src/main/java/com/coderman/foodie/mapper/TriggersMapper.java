package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Triggers;
import java.util.List;

public interface TriggersMapper {
    int insert(Triggers record);

    List<Triggers> selectAll();
}