package com.learn.simpleblog.service.pmp;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.simpleblog.api.utils.PageUtil;
import com.learn.simpleblog.module.domain.SysLogEntity;

import java.util.Map;

public interface SysLogService extends IService<SysLogEntity> {

    PageUtil queryPage(Map<String, Object> params);

    void truncate();

}
