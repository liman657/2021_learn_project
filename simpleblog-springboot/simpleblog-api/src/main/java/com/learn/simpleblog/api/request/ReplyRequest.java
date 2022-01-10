package com.learn.simpleblog.api.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 回复
 * @Author:liman
 * @Link: weixin-> debug0868 qq-> 1948831260
 **/
@Data
public class ReplyRequest implements Serializable{

    @NotNull(message = "微博id不能为空！")
    private Integer blogId;

    @NotNull(message = "评论id不能为可！")
    private Integer commentId;

    @NotBlank(message = "回复内容不能为空！")
    private String content;

    //被恢复者的昵称
    //@NotBlank(message = "被恢复者的昵称不能为空！")
    private String replyTo;

    //被恢复者的用户id
    private Integer replyUId;
}



























