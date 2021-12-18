package com.coderman.learn.testmapper;

import com.coderman.learn.mybatisplus.MyBatisPlusThresholdApplication;
import com.coderman.learn.mybatisplus.entity.UserEntity;
import com.coderman.learn.mybatisplus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
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

    @Test
    public void testInsert(){
        //INSERT INTO t_user ( id, name, age, manager_id, create_time ) VALUES ( ?, ?, ?, ?, ? )
        //没有设置email的值，insert语句中就不会出现对应的值
        UserEntity user = new UserEntity();
        user.setName("刘明强");
        user.setAge(12);
        user.setManagerId(1087982257332887553L);
        user.setCreateTime(LocalDateTime.now());
        int rows = userMapper.insert(user);
        System.out.println("插入记录数"+rows);
    }

}
