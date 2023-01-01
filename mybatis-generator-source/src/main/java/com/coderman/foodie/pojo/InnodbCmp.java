package com.coderman.foodie.pojo;

import java.io.Serializable;

public class InnodbCmp implements Serializable {
    private Integer pageSize;

    private Integer compressOps;

    private Integer compressOpsOk;

    private Integer compressTime;

    private Integer uncompressOps;

    private Integer uncompressTime;

    private static final long serialVersionUID = 1L;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCompressOps() {
        return compressOps;
    }

    public void setCompressOps(Integer compressOps) {
        this.compressOps = compressOps;
    }

    public Integer getCompressOpsOk() {
        return compressOpsOk;
    }

    public void setCompressOpsOk(Integer compressOpsOk) {
        this.compressOpsOk = compressOpsOk;
    }

    public Integer getCompressTime() {
        return compressTime;
    }

    public void setCompressTime(Integer compressTime) {
        this.compressTime = compressTime;
    }

    public Integer getUncompressOps() {
        return uncompressOps;
    }

    public void setUncompressOps(Integer uncompressOps) {
        this.uncompressOps = uncompressOps;
    }

    public Integer getUncompressTime() {
        return uncompressTime;
    }

    public void setUncompressTime(Integer uncompressTime) {
        this.uncompressTime = uncompressTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pageSize=").append(pageSize);
        sb.append(", compressOps=").append(compressOps);
        sb.append(", compressOpsOk=").append(compressOpsOk);
        sb.append(", compressTime=").append(compressTime);
        sb.append(", uncompressOps=").append(uncompressOps);
        sb.append(", uncompressTime=").append(uncompressTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}