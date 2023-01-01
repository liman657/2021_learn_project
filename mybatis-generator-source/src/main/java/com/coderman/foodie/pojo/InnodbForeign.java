package com.coderman.foodie.pojo;

import java.io.Serializable;

public class InnodbForeign implements Serializable {
    private String id;

    private String forName;

    private String refName;

    private Long nCols;

    private Long type;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getForName() {
        return forName;
    }

    public void setForName(String forName) {
        this.forName = forName == null ? null : forName.trim();
    }

    public String getRefName() {
        return refName;
    }

    public void setRefName(String refName) {
        this.refName = refName == null ? null : refName.trim();
    }

    public Long getnCols() {
        return nCols;
    }

    public void setnCols(Long nCols) {
        this.nCols = nCols;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", forName=").append(forName);
        sb.append(", refName=").append(refName);
        sb.append(", nCols=").append(nCols);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}