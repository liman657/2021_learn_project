package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.KeyringComponentStatus;
import java.util.List;

public interface KeyringComponentStatusMapper {
    int insert(KeyringComponentStatus record);

    List<KeyringComponentStatus> selectAll();
}