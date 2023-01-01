package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SysMenu;
import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Long menuId);

    int insert(SysMenu record);

    SysMenu selectByPrimaryKey(Long menuId);

    List<SysMenu> selectAll();

    int updateByPrimaryKey(SysMenu record);
}