package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.IoGlobalByWaitByBytes;
import java.util.List;

public interface IoGlobalByWaitByBytesMapper {
    int insert(IoGlobalByWaitByBytes record);

    List<IoGlobalByWaitByBytes> selectAll();
}