package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XIoGlobalByWaitByBytes;
import java.util.List;

public interface XIoGlobalByWaitByBytesMapper {
    int insert(XIoGlobalByWaitByBytes record);

    List<XIoGlobalByWaitByBytes> selectAll();
}