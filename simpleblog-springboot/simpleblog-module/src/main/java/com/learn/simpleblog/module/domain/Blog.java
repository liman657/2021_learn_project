package com.learn.simpleblog.module.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@TableName("blog")
@Accessors(chain = true)
public class Blog implements Serializable{

    @TableId
    private Integer id;

    private String content;

    private Long userId;

    private Integer type;

    private Integer blogId;

    private Date createTime;

    private Integer isActive;

    private Integer isDelete;

    private Date deleteTime;

    private Date updateTime;

    private String memoA;

    @TableField(exist=false)
    private String userName;

    @TableField(exist=false)
    private String nickName;

    @TableField(exist=false)
    private String headerImg;

    @TableField(exist=false)
    private List<String> imgUrls;

    //转发的微博的存储
    @TableField(exist=false)
    private Map<String,Object> otherMap;


    //后端管理微博列表时需要使用到
    @TableField(exist=false)
    private Integer commentTotal=0;

    @TableField(exist=false)
    private Integer praiseTotal=0;

    @TableField(exist=false)
    private Integer collectTotal=0;


    //临时高亮显示的内容
    @TableField(exist=false)
    private String highContent;
}