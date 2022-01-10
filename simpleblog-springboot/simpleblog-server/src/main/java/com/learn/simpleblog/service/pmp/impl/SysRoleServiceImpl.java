package com.learn.simpleblog.service.pmp.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.simpleblog.api.utils.PageUtil;
import com.learn.simpleblog.api.utils.QueryUtil;
import com.learn.simpleblog.module.domain.SysRoleEntity;
import com.learn.simpleblog.module.mapper.SysRoleDao;
import com.learn.simpleblog.service.pmp.SysRoleDeptService;
import com.learn.simpleblog.service.pmp.SysRoleMenuService;
import com.learn.simpleblog.service.pmp.SysRoleService;
import com.learn.simpleblog.service.pmp.SysUserRoleService;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 角色 服务service
 * @Author:liman
 **/
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao,SysRoleEntity> implements SysRoleService {

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @Autowired
    private SysRoleDeptService sysRoleDeptService;

    @Autowired
    private SysUserRoleService sysUserRoleService;



    private static final Logger log= LoggerFactory.getLogger(SysRoleServiceImpl.class);

    //分页列表模糊查询
    @Override
    public PageUtil queryPage(Map<String, Object> map) {
        String search= (map.get("search")!=null)? (String) map.get("search") : "";

        IPage<SysRoleEntity> iPage=new QueryUtil<SysRoleEntity>().getQueryPage(map);

        QueryWrapper wrapper=new QueryWrapper<SysRoleEntity>()
                .like(StringUtils.isNotBlank(search),"role_name",search);

        IPage<SysRoleEntity> resPage=this.page(iPage,wrapper);
        return new PageUtil(resPage);
    }

    //新增
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRole(SysRoleEntity role) {
        role.setCreateTime(DateTime.now().toDate());
        this.save(role);

        //插入角色~菜单关联信息
        sysRoleMenuService.saveOrUpdate(role.getRoleId(),role.getMenuIdList());

        //插入角色~部门关联信息
        sysRoleDeptService.saveOrUpdate(role.getRoleId(),role.getDeptIdList());
    }

    //修改
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRole(SysRoleEntity role) {
        this.updateById(role);

        //更新角色~菜单关联信息
        sysRoleMenuService.saveOrUpdate(role.getRoleId(),role.getMenuIdList());

        //更新角色~部门关联信息
        sysRoleDeptService.saveOrUpdate(role.getRoleId(),role.getDeptIdList());
    }


    //批量删除
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] ids) {
        List<Long> roleIds=Arrays.asList(ids);
        this.removeByIds(roleIds);

        //删除角色~菜单关联数据
        sysRoleMenuService.deleteBatch(roleIds);

        //删除角色~部门关联数据
        sysRoleDeptService.deleteBatch(roleIds);

        //删除角色~用户关联数据
        sysUserRoleService.deleteBatch(roleIds);
    }
}
































