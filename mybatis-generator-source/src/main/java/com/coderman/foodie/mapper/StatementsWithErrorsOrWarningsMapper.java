package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.StatementsWithErrorsOrWarnings;
import java.util.List;

public interface StatementsWithErrorsOrWarningsMapper {
    int insert(StatementsWithErrorsOrWarnings record);

    List<StatementsWithErrorsOrWarnings> selectAll();
}