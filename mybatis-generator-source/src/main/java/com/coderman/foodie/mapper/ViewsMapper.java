package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Views;
import java.util.List;

public interface ViewsMapper {
    int insert(Views record);

    List<Views> selectAll();
}