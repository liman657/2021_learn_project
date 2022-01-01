package com.learn.simpleblog.service.pmp;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.simpleblog.module.domain.SysRoleMenuEntity;

import java.util.List;

public interface SysRoleMenuService extends IService<SysRoleMenuEntity> {

    void saveOrUpdate(Long roleId, List<Long> menuIdList);

    void deleteBatch(List<Long> roleIds);

    List<Long> queryMenuIdList(Long roleId);
}
