package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XStatementsWithErrorsOrWarnings;
import java.util.List;

public interface XStatementsWithErrorsOrWarningsMapper {
    int insert(XStatementsWithErrorsOrWarnings record);

    List<XStatementsWithErrorsOrWarnings> selectAll();
}