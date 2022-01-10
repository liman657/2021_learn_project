package com.learn.simpleblog.api.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 评论
 * @Author:liman
 * @Link: weixin-> debug0868 qq-> 1948831260
 **/
@Data
public class CommentRequest implements Serializable{

    @NotNull(message = "微博id不能为空！")
    private Integer blogId;

    @NotBlank(message = "评论内容不能为空！")
    private String content;

}