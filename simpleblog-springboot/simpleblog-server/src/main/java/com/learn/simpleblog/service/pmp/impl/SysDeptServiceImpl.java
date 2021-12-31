package com.learn.simpleblog.service.pmp.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.simpleblog.api.utils.Constant;
import com.learn.simpleblog.module.domain.SysDeptEntity;
import com.learn.simpleblog.module.mapper.SysDeptDao;
import com.learn.simpleblog.module.mapper.SysDeptDao;
import com.google.common.collect.Lists;
import com.learn.simpleblog.service.pmp.CommonDataService;
import com.learn.simpleblog.service.pmp.SysDeptService;
import com.learn.simpleblog.shiro.ShiroUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service("sysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptDao,SysDeptEntity> implements SysDeptService {

    private static final Logger log= LoggerFactory.getLogger(SysDeptServiceImpl.class);

    @Autowired
    private CommonDataService commonDataService;

    //查询所有部门列表 ~ 涉及到 部门数据权限 的控制
    @Override
    public List<SysDeptEntity> queryAll(Map<String, Object> map) {
        //return baseMapper.queryList(map);

        if (!Objects.equals(ShiroUtil.getUserId(), Constant.SUPER_ADMIN)){
            String deptDataIds=commonDataService.getCurrUserDataDeptIdsStr();
            map.put("deptDataIds",(StringUtils.isNotBlank(deptDataIds))?deptDataIds:null);
        }
        return baseMapper.queryListV2(map);
    }

    //根据父级部门id查询子部门id列表
    @Override
    public List<Long> queryDeptIds(Long parentId) {
        return baseMapper.queryDeptIds(parentId);
    }

    //获取当前部门的子部门id列表
    @Override
    public List<Long> getSubDeptIdList(Long deptId) {
        List<Long> deptIdList= Lists.newLinkedList();

        //第一级部门Id列表
        List<Long> subIdList=baseMapper.queryDeptIds(deptId);
        getDeptTreeList(subIdList,deptIdList);

        return deptIdList;
    }

    /**
     * 递归
     * @param subIdList 第一级部门数据Id列表
     * @param deptIdList 每次递归时循环存储的结果数据Id列表
     */
    private void getDeptTreeList(List<Long> subIdList,List<Long> deptIdList){
        List<Long> list;
        for (Long subId:subIdList){
            list=baseMapper.queryDeptIds(subId);
            if (list!=null && !list.isEmpty()){
                //调用递归之处
                getDeptTreeList(list,deptIdList);
            }

            //执行到这里时，就表示当前递归结束
            deptIdList.add(subId);
        }
    }

}

























