package com.coderman.learn.testmapper;

import com.coderman.learn.mybatisplus.MyBatisPlusThresholdApplication;
import com.coderman.learn.mybatisplus.entity.UserEntity;
import com.coderman.learn.mybatisplus.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * autor:liman
 * createtime:2021/12/22
 * comment:简单的查询测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = MyBatisPlusThresholdApplication.class)
@Slf4j
public class RetrieveTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectById(){
        UserEntity user = userMapper.selectById(1088248166370832385L);
        log.info("查询的用户数据为:{}",user);
    }

    @Test
    public void selectByIds(){
        //根据id批量查询
        List<Long> ids = Arrays.asList(1088248166370832385L,1088250446457389058L,1094590409767661570L);
        List<UserEntity> userList = userMapper.selectBatchIds(ids);
        log.info("userList info : {}",userList);
    }

    @Test
    public void selectByMapTest() {
        /**
         * key - value
         * key是数据库中的列名，不是实体中的属性名
         */
        Map<String, Object> params = new HashMap<>();
        params.put("name", "王天风");
        params.put("age", 25);
        List<UserEntity> userEntities = userMapper.selectByMap(params);
        log.info("map 查询结果为:{}", userEntities);
    }


}
