package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.TableConstraints;
import java.util.List;

public interface TableConstraintsMapper {
    int insert(TableConstraints record);

    List<TableConstraints> selectAll();
}