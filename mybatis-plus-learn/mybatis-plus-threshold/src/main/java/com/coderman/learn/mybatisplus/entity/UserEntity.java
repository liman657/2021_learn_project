package com.coderman.learn.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * autor:liman
 * createtime:2021/12/18
 * comment:实体类
 */
@Data
@ToString
@TableName("t_user")//这里映射数据库中的表名
public class UserEntity {

    //主键id
    private Long id;

    //姓名
    private String name;

    //年龄
    private Integer age;

    //邮箱
    private String email;

    //直属上级ID
    private Long managerId;

    //创建时间
    private LocalDateTime createTime;
}

