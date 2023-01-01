package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbFtDefaultStopword;
import java.util.List;

public interface InnodbFtDefaultStopwordMapper {
    int insert(InnodbFtDefaultStopword record);

    List<InnodbFtDefaultStopword> selectAll();
}