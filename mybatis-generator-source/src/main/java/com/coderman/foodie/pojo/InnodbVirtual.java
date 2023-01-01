package com.coderman.foodie.pojo;

import java.io.Serializable;

public class InnodbVirtual implements Serializable {
    private Long tableId;

    private Integer pos;

    private Integer basePos;

    private static final long serialVersionUID = 1L;

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public Integer getBasePos() {
        return basePos;
    }

    public void setBasePos(Integer basePos) {
        this.basePos = basePos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tableId=").append(tableId);
        sb.append(", pos=").append(pos);
        sb.append(", basePos=").append(basePos);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}