package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Staff;
import java.util.List;

public interface StaffMapper {
    int deleteByPrimaryKey(Byte staffId);

    int insert(Staff record);

    Staff selectByPrimaryKey(Byte staffId);

    List<Staff> selectAll();

    int updateByPrimaryKey(Staff record);
}