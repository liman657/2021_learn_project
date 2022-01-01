package com.learn.simpleblog.service.pmp;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.simpleblog.module.domain.SysMenuEntity;

import java.util.List;

public interface SysMenuService extends IService<SysMenuEntity> {

    List<SysMenuEntity> queryAll();

    List<SysMenuEntity> queryNotButtonList();

    List<SysMenuEntity> queryByParentId(Long menuId);

    void delete(Long menuId);

    List<SysMenuEntity> getUserMenuList(Long currUserId);
}
