package com.learn.simpleblog.service.pmp.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.simpleblog.api.utils.Constant;
import com.learn.simpleblog.api.utils.PageUtil;
import com.learn.simpleblog.api.utils.QueryUtil;
import com.learn.simpleblog.module.domain.SysDeptEntity;
import com.learn.simpleblog.module.domain.SysUserEntity;
import com.learn.simpleblog.module.domain.SysUserPostEntity;
import com.learn.simpleblog.module.domain.SysUserRoleEntity;
import com.learn.simpleblog.module.mapper.SysUserDao;
import com.learn.simpleblog.service.pmp.SysDeptService;
import com.learn.simpleblog.service.pmp.SysUserPostService;
import com.learn.simpleblog.service.pmp.SysUserRoleService;
import com.learn.simpleblog.service.pmp.SysUserService;
import com.learn.simpleblog.shiro.ShiroUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao,SysUserEntity> implements SysUserService {

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private SysUserPostService sysUserPostService;

    @Autowired
    private SysUserRoleService sysUserRoleService;



    //更新密码 ~ 借助于mybatis-plus的方法来实现
    @Override
    public boolean updatePassword(Long userId, String oldPassword, String newPassword) {
        SysUserEntity entity=new SysUserEntity();
        entity.setPassword(newPassword);

        Boolean res=this.update(entity,new QueryWrapper<SysUserEntity>().eq("user_id",userId).eq("password",oldPassword));

        //传统~开始记录日志

        return res;
    }

    //列表分页模糊查询
    @Override
    public PageUtil queryPage(Map<String, Object> map) {
        String search=(map.get("username")!=null)? (String) map.get("username") :"";

        IPage<SysUserEntity> iPage=new QueryUtil<SysUserEntity>().getQueryPage(map);

        QueryWrapper wrapper=new QueryWrapper<SysUserEntity>()
                .like(StringUtils.isNotBlank(search),"username",search.trim())
                .or(StringUtils.isNotBlank(search.trim()))
                .like(StringUtils.isNotBlank(search),"name",search.trim());
        IPage<SysUserEntity> resPage=this.page(iPage,wrapper);

        //获取用户所属的部门、用户的岗位信息
        SysDeptEntity dept;
        for (SysUserEntity user:resPage.getRecords()){
            try {
                dept=sysDeptService.getById(user.getDeptId());
                user.setDeptName((dept!=null && StringUtils.isNotBlank(dept.getName()))? dept.getName() : "");

                String postName=sysUserPostService.getPostNameByUserId(user.getUserId());
                user.setPostName(postName);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return new PageUtil(resPage);
    }

    //保存用户
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long saveUser(SysUserEntity entity) {
        if (this.getOne(new QueryWrapper<SysUserEntity>().eq("username",entity.getUsername())) !=null ){
            throw new RuntimeException("用户名已存在!");
        }
        entity.setCreateTime(new Date());

        //加密密码串
        //String salt= RandomStringUtils.randomAlphanumeric(20);
        String salt= RandomUtil.randomString(20);
        String password= ShiroUtil.sha256(entity.getPassword(),salt);
        entity.setPassword(password);
        entity.setSalt(salt);
        this.save(entity);

        //维护好用户~角色的关联关系
        sysUserRoleService.saveOrUpdate(entity.getUserId(),entity.getRoleIdList());
        //维护好用户~岗位的关联关系
        sysUserPostService.saveOrUpdate(entity.getUserId(),entity.getPostIdList());

        return entity.getUserId();
    }

    //获取用户详情~包括其分配的角色、岗位关联信息
    @Override
    public SysUserEntity getInfo(Long userId) {
        SysUserEntity entity=this.getById(userId);

        //获取用户分配的角色关联信息
        List<Long> roleIds=sysUserRoleService.queryRoleIdList(userId);
        entity.setRoleIdList(roleIds);

        //获取用户分配的岗位关联信息
        List<Long> postIds=sysUserPostService.queryPostIdList(userId);
        entity.setPostIdList(postIds);

        return entity;
    }

    //修改
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(SysUserEntity entity) {
        SysUserEntity old=this.getById(entity.getUserId());
        if (old==null){
            return;
        }
        if (!old.getUsername().equals(entity.getUsername())){
            if (this.getOne(new QueryWrapper<SysUserEntity>().eq("username",entity.getUsername())) !=null ){
                throw new RuntimeException("修改后的用户名已存在!");
            }
        }


        if (StringUtils.isNotBlank(entity.getPassword())){
            String password= ShiroUtil.sha256(entity.getPassword(),old.getSalt());
            entity.setPassword(password);
        }
        this.updateById(entity);

        //维护好用户~角色的关联关系
        sysUserRoleService.saveOrUpdate(entity.getUserId(),entity.getRoleIdList());

        //维护好用户~岗位的关联关系
        sysUserPostService.saveOrUpdate(entity.getUserId(),entity.getPostIdList());
    }

    //删除用户：除了删除 用户本身 信息之外，还需要删除用户~角色、用户~岗位 关联关系信息
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(Long[] ids) {
        if (ids!=null && ids.length>0){
            List<Long> userIds=Arrays.asList(ids);

            this.removeByIds(userIds);

            /*for (Long uId:userIds){
                sysUserRoleService.remove(new QueryWrapper<SysUserRoleEntity>().eq("user_id",uId));
                sysUserPostService.remove(new QueryWrapper<SysUserPostEntity>().eq("user_id",uId));
            }*/

            //java8的写法
            userIds.stream().forEach(uId -> sysUserRoleService.remove(new QueryWrapper<SysUserRoleEntity>().eq("user_id",uId)));
            userIds.stream().forEach(uId -> sysUserPostService.remove(new QueryWrapper<SysUserPostEntity>().eq("user_id",uId)));
        }
    }


    //重置密码
    @Override
    public void updatePsd(Long[] ids) {
        if (ids!=null && ids.length>0){
            SysUserEntity entity;
            for (Long uId:ids){
                entity=new SysUserEntity();

                //String salt= RandomStringUtils.randomAlphanumeric(20);
                String salt= RandomUtil.randomString(20);
                String newPsd= ShiroUtil.sha256(Constant.DefaultPassword,salt);
                entity.setPassword(newPsd);
                entity.setSalt(salt);

                this.update(entity,new QueryWrapper<SysUserEntity>().eq("user_id",uId));
            }
        }
    }
}















































