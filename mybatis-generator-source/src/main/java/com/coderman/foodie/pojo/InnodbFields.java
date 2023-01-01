package com.coderman.foodie.pojo;

import java.io.Serializable;

public class InnodbFields implements Serializable {
    private String name;

    private Long pos;

    private byte[] indexId;

    private static final long serialVersionUID = 1L;

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

    public byte[] getIndexId() {
        return indexId;
    }

    public void setIndexId(byte[] indexId) {
        this.indexId = indexId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", name=").append(name);
        sb.append(", pos=").append(pos);
        sb.append(", indexId=").append(indexId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}