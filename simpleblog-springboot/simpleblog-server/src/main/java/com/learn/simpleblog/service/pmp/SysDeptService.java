package com.learn.simpleblog.service.pmp;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.simpleblog.module.domain.SysDeptEntity;

import java.util.List;
import java.util.Map;

public interface SysDeptService extends IService<SysDeptEntity> {

    List<SysDeptEntity> queryAll(Map<String, Object> map);

    List<Long> queryDeptIds(Long parentId);

    List<Long> getSubDeptIdList(Long deptId);
}
