package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbTempTableInfo;
import java.util.List;

public interface InnodbTempTableInfoMapper {
    int insert(InnodbTempTableInfo record);

    List<InnodbTempTableInfo> selectAll();
}