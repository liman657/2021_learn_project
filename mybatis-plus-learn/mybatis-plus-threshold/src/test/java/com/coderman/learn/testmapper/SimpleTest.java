package com.coderman.learn.testmapper;

import com.coderman.learn.mybatisplus.MyBatisPlusThresholdApplication;
import com.coderman.learn.mybatisplus.entity.UserEntity;
import com.coderman.learn.mybatisplus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * autor:liman
 * createtime:2021/12/18
 * comment:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = MyBatisPlusThresholdApplication.class)
public class SimpleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect(){
        List<UserEntity> userEntities = userMapper.selectList(null);
        System.out.println(userEntities);
    }

}
