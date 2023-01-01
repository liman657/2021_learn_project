package com.coderman.foodie.pojo;

import java.io.Serializable;

public class InnodbForeignCols implements Serializable {
    private String id;

    private String forColName;

    private String refColName;

    private Integer pos;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getForColName() {
        return forColName;
    }

    public void setForColName(String forColName) {
        this.forColName = forColName == null ? null : forColName.trim();
    }

    public String getRefColName() {
        return refColName;
    }

    public void setRefColName(String refColName) {
        this.refColName = refColName == null ? null : refColName.trim();
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", forColName=").append(forColName);
        sb.append(", refColName=").append(refColName);
        sb.append(", pos=").append(pos);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}