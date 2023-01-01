package com.coderman.foodie.pojo;

import java.io.Serializable;

public class InnodbDatafiles implements Serializable {
    private String path;

    private byte[] space;

    private static final long serialVersionUID = 1L;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public byte[] getSpace() {
        return space;
    }

    public void setSpace(byte[] space) {
        this.space = space;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", path=").append(path);
        sb.append(", space=").append(space);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}