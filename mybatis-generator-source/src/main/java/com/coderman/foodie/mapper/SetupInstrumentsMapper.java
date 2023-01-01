package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SetupInstruments;
import java.util.List;

public interface SetupInstrumentsMapper {
    int deleteByPrimaryKey(String name);

    int insert(SetupInstruments record);

    SetupInstruments selectByPrimaryKey(String name);

    List<SetupInstruments> selectAll();

    int updateByPrimaryKey(SetupInstruments record);
}