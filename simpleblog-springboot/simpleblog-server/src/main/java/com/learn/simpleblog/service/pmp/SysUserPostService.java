package com.learn.simpleblog.service.pmp;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.simpleblog.module.domain.SysUserPostEntity;

import java.util.List;

public interface SysUserPostService extends IService<SysUserPostEntity> {

    String getPostNameByUserId(Long userId);

    void saveOrUpdate(Long userId, List<Long> postIds);

    List<Long> queryPostIdList(Long userId);
}
