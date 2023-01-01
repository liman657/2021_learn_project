package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbCmpmem;
import java.util.List;

public interface InnodbCmpmemMapper {
    int insert(InnodbCmpmem record);

    List<InnodbCmpmem> selectAll();
}