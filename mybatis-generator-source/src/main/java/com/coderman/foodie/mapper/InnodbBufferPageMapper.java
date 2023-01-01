package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbBufferPage;
import java.util.List;

public interface InnodbBufferPageMapper {
    int insert(InnodbBufferPage record);

    List<InnodbBufferPage> selectAll();
}