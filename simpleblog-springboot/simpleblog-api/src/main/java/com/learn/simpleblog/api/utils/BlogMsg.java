package com.learn.simpleblog.api.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

/**
 *
 */
@Data
public class BlogMsg extends ApplicationEvent implements Serializable{
    private Integer blogId;

    private Integer type;

    public BlogMsg(Object source, Integer blogId, Integer type) {
        super(source);
        this.blogId = blogId;
        this.type = type;
    }
}