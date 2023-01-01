package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbCmpmemReset;
import java.util.List;

public interface InnodbCmpmemResetMapper {
    int insert(InnodbCmpmemReset record);

    List<InnodbCmpmemReset> selectAll();
}