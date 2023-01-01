package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XIoGlobalByFileByBytes;
import java.util.List;

public interface XIoGlobalByFileByBytesMapper {
    int insert(XIoGlobalByFileByBytes record);

    List<XIoGlobalByFileByBytes> selectAll();
}