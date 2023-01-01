package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.FileInstances;
import java.util.List;

public interface FileInstancesMapper {
    int deleteByPrimaryKey(String fileName);

    int insert(FileInstances record);

    FileInstances selectByPrimaryKey(String fileName);

    List<FileInstances> selectAll();

    int updateByPrimaryKey(FileInstances record);
}