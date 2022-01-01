package com.learn.simpleblog.service.pmp;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.simpleblog.api.utils.PageUtil;
import com.learn.simpleblog.module.domain.SysRoleEntity;

import java.util.Map;

public interface SysRoleService extends IService<SysRoleEntity> {

    PageUtil queryPage(Map<String, Object> map);

    void saveRole(SysRoleEntity role);

    void updateRole(SysRoleEntity role);

    void deleteBatch(Long[] ids);
}
