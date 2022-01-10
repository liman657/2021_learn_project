package com.learn.simpleblog.api.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 只包含主键id的实体
 * @Author:liman
 * @Link: weixin-> debug0868 qq-> 1948831260
 **/
@Data
public class IdRequest implements Serializable{

    @NotNull(message = "id不能为空！")
    private Integer id;

}