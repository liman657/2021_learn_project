package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbTrx;
import java.util.List;

public interface InnodbTrxMapper {
    int insert(InnodbTrx record);

    List<InnodbTrx> selectAll();
}