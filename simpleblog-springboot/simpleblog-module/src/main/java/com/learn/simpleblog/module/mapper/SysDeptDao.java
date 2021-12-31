package com.learn.simpleblog.module.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.simpleblog.module.domain.SysDeptEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

//部门管理
@Mapper
public interface SysDeptDao extends BaseMapper<SysDeptEntity> {

    List<SysDeptEntity> queryList(Map<String, Object> params);

    List<SysDeptEntity> queryListV2(Map<String, Object> params);


    //根据父级部门id查询子部门id列表
    List<Long> queryDeptIds(Long parentId);

    Set<Long> queryAllDeptIds();
}
