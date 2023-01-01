package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbFtBeingDeleted;
import java.util.List;

public interface InnodbFtBeingDeletedMapper {
    int insert(InnodbFtBeingDeleted record);

    List<InnodbFtBeingDeleted> selectAll();
}