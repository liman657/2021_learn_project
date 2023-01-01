package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbCmpReset;
import java.util.List;

public interface InnodbCmpResetMapper {
    int insert(InnodbCmpReset record);

    List<InnodbCmpReset> selectAll();
}