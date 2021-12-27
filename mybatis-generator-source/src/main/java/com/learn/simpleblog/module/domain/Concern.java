package com.learn.simpleblog.module.domain;

import java.io.Serializable;
import java.util.Date;

public class Concern implements Serializable {
    private Integer id;

    private Integer concernId;

    private Integer concernBeId;

    private Date concernTime;

    private Byte isActive;

    private Date updateTime;

    private String memo;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConcernId() {
        return concernId;
    }

    public void setConcernId(Integer concernId) {
        this.concernId = concernId;
    }

    public Integer getConcernBeId() {
        return concernBeId;
    }

    public void setConcernBeId(Integer concernBeId) {
        this.concernBeId = concernBeId;
    }

    public Date getConcernTime() {
        return concernTime;
    }

    public void setConcernTime(Date concernTime) {
        this.concernTime = concernTime;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", concernId=").append(concernId);
        sb.append(", concernBeId=").append(concernBeId);
        sb.append(", concernTime=").append(concernTime);
        sb.append(", isActive=").append(isActive);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", memo=").append(memo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}