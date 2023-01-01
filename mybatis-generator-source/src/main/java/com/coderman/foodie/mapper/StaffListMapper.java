package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.StaffList;
import java.util.List;

public interface StaffListMapper {
    int insert(StaffList record);

    List<StaffList> selectAll();
}