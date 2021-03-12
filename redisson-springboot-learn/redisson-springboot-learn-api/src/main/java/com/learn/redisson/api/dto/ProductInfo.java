package com.learn.redisson.api.dto;/**
 * Created by Administrator on 2020/1/13.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:debug (SteadyJack)
 * @Link: weixin-> debug0868 qq-> 1948831260
 * @Date: 2020/2/13 11:03
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo implements Serializable{

    private Integer id;

    private String prodCode;

    private Integer total;

    private Byte isActive;

    private Date createTime;


    //临时字段
    private String prodName;

}