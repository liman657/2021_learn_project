package com.learn.simpleblog.service.pmp.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.simpleblog.api.utils.CommonUtil;
import com.learn.simpleblog.module.domain.SysRoleDeptEntity;
import com.learn.simpleblog.module.mapper.SysRoleDeptDao;
import com.learn.simpleblog.service.pmp.SysRoleDeptService;
import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 角色~部门 关联service
 * @Author:liman
 **/
@Service("sysRoleDeptService")
public class SysRoleDeptServiceImpl extends ServiceImpl<SysRoleDeptDao,SysRoleDeptEntity> implements SysRoleDeptService {

    private static final Logger log= LoggerFactory.getLogger(SysRoleDeptServiceImpl.class);

    //维护角色~部门关联信息
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(Long roleId, List<Long> deptIdList) {
        //需要先清除旧的关联数据，再插入新的关联信息
        deleteBatch(Arrays.asList(roleId));

        SysRoleDeptEntity entity;
        if (deptIdList!=null && !deptIdList.isEmpty()){
            for (Long dId:deptIdList){
                entity=new SysRoleDeptEntity();
                entity.setRoleId(roleId);
                entity.setDeptId(dId);
                this.save(entity);
            }
        }
    }


    //根据角色id批量删除
    @Override
    public void deleteBatch(List<Long> roleIds) {
        if (roleIds!=null && !roleIds.isEmpty()){
            String delIds= Joiner.on(",").join(roleIds);
            baseMapper.deleteBatch(CommonUtil.concatStrToInt(delIds,","));
        }
    }


    //根据角色ID获取部门ID列表
    @Override
    public List<Long> queryDeptIdList(Long roleId) {
        return baseMapper.queryDeptIdListByRoleId(roleId);
    }
}