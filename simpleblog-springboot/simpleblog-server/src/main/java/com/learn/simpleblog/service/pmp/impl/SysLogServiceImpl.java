package com.learn.simpleblog.service.pmp.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.simpleblog.api.utils.PageUtil;
import com.learn.simpleblog.api.utils.QueryUtil;
import com.learn.simpleblog.module.domain.SysLogEntity;
import com.learn.simpleblog.module.mapper.SysLogDao;
import com.learn.simpleblog.service.pmp.SysLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogDao,SysLogEntity> implements SysLogService {

    @Override
    public PageUtil queryPage(Map<String, Object> params) {
        String key = (String)params.get("key");

        IPage queryPage=new QueryUtil<SysLogEntity>().getQueryPage(params);

        QueryWrapper<SysLogEntity> wrapper=new QueryWrapper<SysLogEntity>()
                .like(StringUtils.isNotBlank(key),"username", key)
                .or(StringUtils.isNotBlank(key))
                .like(StringUtils.isNotBlank(key),"operation", key);
        IPage<SysLogEntity> page=this.page(queryPage,wrapper);

        return new PageUtil(page);
    }

    @Override
    public void truncate() {
        baseMapper.truncate();
    }

}