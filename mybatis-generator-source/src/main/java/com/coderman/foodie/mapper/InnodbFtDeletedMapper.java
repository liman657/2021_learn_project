package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbFtDeleted;
import java.util.List;

public interface InnodbFtDeletedMapper {
    int insert(InnodbFtDeleted record);

    List<InnodbFtDeleted> selectAll();
}