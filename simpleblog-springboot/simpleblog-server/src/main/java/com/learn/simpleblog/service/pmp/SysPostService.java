package com.learn.simpleblog.service.pmp;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.simpleblog.api.utils.PageUtil;
import com.learn.simpleblog.module.domain.SysPostEntity;

import java.util.Map;

public interface SysPostService extends IService<SysPostEntity> {

    PageUtil queryPage(Map<String, Object> params);

    void savePost(SysPostEntity entity);

    void updatePost(SysPostEntity entity);

    void deletePatch(Long[] ids);
}
