package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.KeyringKeys;
import java.util.List;

public interface KeyringKeysMapper {
    int insert(KeyringKeys record);

    List<KeyringKeys> selectAll();
}