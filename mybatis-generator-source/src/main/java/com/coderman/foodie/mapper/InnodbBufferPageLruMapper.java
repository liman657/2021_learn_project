package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbBufferPageLru;
import java.util.List;

public interface InnodbBufferPageLruMapper {
    int insert(InnodbBufferPageLru record);

    List<InnodbBufferPageLru> selectAll();
}