package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbFtConfig;
import java.util.List;

public interface InnodbFtConfigMapper {
    int insert(InnodbFtConfig record);

    List<InnodbFtConfig> selectAll();
}