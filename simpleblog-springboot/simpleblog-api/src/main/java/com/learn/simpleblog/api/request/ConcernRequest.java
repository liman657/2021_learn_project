package com.learn.simpleblog.api.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 关注request
 * @Author:debug (SteadyJack)
 * @Link: weixin-> debug0868 qq-> 1948831260
 **/
@Data
public class ConcernRequest implements Serializable{

    @NotNull(message = "被关注者的用户id不能为空！")
    private Integer beConcernUserId;
}

















