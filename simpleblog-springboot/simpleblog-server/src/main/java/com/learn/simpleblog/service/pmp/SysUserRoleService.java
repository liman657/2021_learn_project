package com.learn.simpleblog.service.pmp;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.simpleblog.module.domain.SysUserRoleEntity;

import java.util.List;

public interface SysUserRoleService extends IService<SysUserRoleEntity> {

    void deleteBatch(List<Long> roleIds);

    void saveOrUpdate(Long userId, List<Long> roleIds);

    List<Long> queryRoleIdList(Long userId);
}
