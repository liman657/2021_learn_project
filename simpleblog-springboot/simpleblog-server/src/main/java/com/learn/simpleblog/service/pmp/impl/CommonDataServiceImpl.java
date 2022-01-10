package com.learn.simpleblog.service.pmp.impl;

import com.google.common.base.Joiner;
import com.google.common.collect.Sets;
import com.learn.simpleblog.api.utils.CommonUtil;
import com.learn.simpleblog.api.utils.Constant;
import com.learn.simpleblog.module.domain.SysUserEntity;
import com.learn.simpleblog.module.mapper.SysDeptDao;
import com.learn.simpleblog.module.mapper.SysUserDao;
import com.learn.simpleblog.service.pmp.CommonDataService;
import com.learn.simpleblog.service.pmp.SysDeptService;
import com.learn.simpleblog.shiro.ShiroUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 通用化的部门数据权限控制service
 * @Author:liman
 **/
@Service
public class CommonDataServiceImpl implements CommonDataService {

    private static final Logger log= LoggerFactory.getLogger(CommonDataServiceImpl.class);

    @Autowired
    private SysDeptDao sysDeptDao;

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysDeptService sysDeptService;


    //获取当前登录用户的部门数据Id列表
    @Override
    public Set<Long> getCurrUserDataDeptIds() {
        Set<Long> dataIds= Sets.newHashSet();

        SysUserEntity currUser= ShiroUtil.getUserEntity();
        if (Objects.equals(Constant.SUPER_ADMIN, currUser.getUserId())){
            dataIds=sysDeptDao.queryAllDeptIds();

        }else{
            //分配给用户的部门数据权限id列表
            Set<Long> userDeptDataIds=sysUserDao.queryDeptIdsByUserId(currUser.getUserId());
            if (userDeptDataIds!=null && !userDeptDataIds.isEmpty()){
                dataIds.addAll(userDeptDataIds);
            }

            //用户所在的部门及其子部门Id列表 ~ 递归实现
            dataIds.add(currUser.getDeptId());

            List<Long> subDeptIdList=sysDeptService.getSubDeptIdList(currUser.getDeptId());
            dataIds.addAll(Sets.newHashSet(subDeptIdList));
        }
        return dataIds;
    }

    //将 部门数据Id列表 转化为 id拼接 的字符串
    @Override
    public String getCurrUserDataDeptIdsStr() {
        String result=null;

        Set<Long> dataSet=this.getCurrUserDataDeptIds();
        if (dataSet!=null && !dataSet.isEmpty()){
            result= CommonUtil.concatStrToInt(Joiner.on(",").join(dataSet),",");
        }

        return result;
    }
}



































