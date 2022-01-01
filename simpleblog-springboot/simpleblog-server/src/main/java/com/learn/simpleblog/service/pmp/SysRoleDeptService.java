package com.learn.simpleblog.service.pmp;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.simpleblog.module.domain.SysRoleDeptEntity;

import java.util.List;

public interface SysRoleDeptService extends IService<SysRoleDeptEntity> {


    void saveOrUpdate(Long roleId, List<Long> deptIdList);

    void deleteBatch(List<Long> roleIds);

    List<Long> queryDeptIdList(Long roleId);
}
