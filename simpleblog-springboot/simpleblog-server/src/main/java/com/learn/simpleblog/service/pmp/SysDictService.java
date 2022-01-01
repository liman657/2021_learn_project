package com.learn.simpleblog.service.pmp;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.simpleblog.api.utils.PageUtil;
import com.learn.simpleblog.api.utils.PageUtil;
import com.learn.simpleblog.module.domain.SysDictEntity;

import java.util.Map;

//数据字典
public interface SysDictService extends IService<SysDictEntity> {

    PageUtil queryPage(Map<String, Object> params);
}

