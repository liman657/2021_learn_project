package com.learn.simpleblog.service.pmp.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.simpleblog.module.domain.SysUserPostEntity;
import com.learn.simpleblog.module.mapper.SysUserPostDao;
import com.learn.simpleblog.service.pmp.SysUserPostService;
import com.google.common.base.Joiner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 用户~岗位服务service
 * @Author:debug (SteadyJack)
 **/
@Service("sysUserPostService")
public class SysUserPostServiceImpl extends ServiceImpl<SysUserPostDao, SysUserPostEntity> implements SysUserPostService {

    //根据用户id获取岗位:如果有多个，则采用 , 拼接
    @Override
    public String getPostNameByUserId(Long userId) {
        //第一种写法
        /*Set<String> set=baseMapper.getPostNamesByUserId(userId);
        if (set!=null && !set.isEmpty()){
            return Joiner.on(",").join(set);
        }else{
            return "";
        }*/

        //传统的写法
        /*StringBuilder sb=new StringBuilder("");
        List<SysUserPostEntity> list=baseMapper.getByUserId(userId);
        if (list!=null && !list.isEmpty()){
            for (SysUserPostEntity entity:list){
                sb.append(entity.getPostName()).append(",");
            }
        }
        String result=sb.toString();
        if (result.lastIndexOf(",")>=0){
            result=result.substring(0,result.lastIndexOf(","));
        }
        return result;*/

        String result="";

        List<SysUserPostEntity> list=baseMapper.getByUserId(userId);
        if (list!=null && !list.isEmpty()){
            //java8的stream api
            Set<String> set=list.stream().map(SysUserPostEntity::getPostName).collect(Collectors.toSet());
            result= Joiner.on(",").join(set);
        }
        return result;
    }

    //维护用户~岗位的关联关系
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(Long userId, List<Long> postIds) {
        //需要先清除旧的关联数据，再插入新的关联信息
        this.remove(new QueryWrapper<SysUserPostEntity>().eq("user_id",userId));

        if (postIds!=null && !postIds.isEmpty()){
            SysUserPostEntity entity;
            for (Long pId:postIds){
                entity=new SysUserPostEntity();
                entity.setPostId(pId);
                entity.setUserId(userId);
                this.save(entity);
            }
        }

    }

    //获取用户分配的岗位列表信息
    @Override
    public List<Long> queryPostIdList(Long userId) {
        return baseMapper.queryPostIdList(userId);
    }
}



































