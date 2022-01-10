package com.learn.simpleblog.api.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 点赞-收藏
 * @Author:liman
 * @Link: weixin-> debug0868 qq-> 1948831260
 **/
@Data
public class OperationRequest implements Serializable{

    @NotNull(message = "微博id不能为空！")
    private Integer blogId;

}