package com.coderman.foodie.pojo;

import java.io.Serializable;

public class InnodbColumns implements Serializable {
    private Long tableId;

    private String name;

    private Long pos;

    private Integer mtype;

    private Integer prtype;

    private Integer len;

    private Integer hasDefault;

    private String defaultValue;

    private static final long serialVersionUID = 1L;

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getPos() {
        return pos;
    }

    public void setPos(Long pos) {
        this.pos = pos;
    }

    public Integer getMtype() {
        return mtype;
    }

    public void setMtype(Integer mtype) {
        this.mtype = mtype;
    }

    public Integer getPrtype() {
        return prtype;
    }

    public void setPrtype(Integer prtype) {
        this.prtype = prtype;
    }

    public Integer getLen() {
        return len;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    public Integer getHasDefault() {
        return hasDefault;
    }

    public void setHasDefault(Integer hasDefault) {
        this.hasDefault = hasDefault;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tableId=").append(tableId);
        sb.append(", name=").append(name);
        sb.append(", pos=").append(pos);
        sb.append(", mtype=").append(mtype);
        sb.append(", prtype=").append(prtype);
        sb.append(", len=").append(len);
        sb.append(", hasDefault=").append(hasDefault);
        sb.append(", defaultValue=").append(defaultValue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}