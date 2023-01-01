package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.UserSummaryByFileIo;
import java.util.List;

public interface UserSummaryByFileIoMapper {
    int insert(UserSummaryByFileIo record);

    List<UserSummaryByFileIo> selectAll();
}