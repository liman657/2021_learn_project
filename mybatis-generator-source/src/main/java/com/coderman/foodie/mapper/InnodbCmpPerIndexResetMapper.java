package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbCmpPerIndexReset;
import java.util.List;

public interface InnodbCmpPerIndexResetMapper {
    int insert(InnodbCmpPerIndexReset record);

    List<InnodbCmpPerIndexReset> selectAll();
}