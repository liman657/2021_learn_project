package com.learn.simpleblog.module.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class Concern implements Serializable{
    private Integer id;

    private Integer concernId;

    private Integer concernBeId;

    private Date concernTime;

    private Byte isActive=1;

    private Date updateTime;

    private String memo;

    public Concern(Integer concernId, Integer concernBeId, Date concernTime) {
        this.concernId = concernId;
        this.concernBeId = concernBeId;
        this.concernTime = concernTime;
    }
}