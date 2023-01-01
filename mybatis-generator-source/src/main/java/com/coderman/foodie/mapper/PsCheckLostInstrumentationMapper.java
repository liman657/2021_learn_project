package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.PsCheckLostInstrumentation;
import java.util.List;

public interface PsCheckLostInstrumentationMapper {
    int insert(PsCheckLostInstrumentation record);

    List<PsCheckLostInstrumentation> selectAll();
}