package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.UserSummaryByFileIoType;
import java.util.List;

public interface UserSummaryByFileIoTypeMapper {
    int insert(UserSummaryByFileIoType record);

    List<UserSummaryByFileIoType> selectAll();
}