package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.IoGlobalByFileByBytes;
import java.util.List;

public interface IoGlobalByFileByBytesMapper {
    int insert(IoGlobalByFileByBytes record);

    List<IoGlobalByFileByBytes> selectAll();
}