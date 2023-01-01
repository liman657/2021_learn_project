package com.coderman.foodie.pojo;

import java.io.Serializable;

public class InnodbCmpmemReset implements Serializable {
    private Integer pageSize;

    private Integer bufferPoolInstance;

    private Integer pagesUsed;

    private Integer pagesFree;

    private Long relocationOps;

    private Integer relocationTime;

    private static final long serialVersionUID = 1L;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getBufferPoolInstance() {
        return bufferPoolInstance;
    }

    public void setBufferPoolInstance(Integer bufferPoolInstance) {
        this.bufferPoolInstance = bufferPoolInstance;
    }

    public Integer getPagesUsed() {
        return pagesUsed;
    }

    public void setPagesUsed(Integer pagesUsed) {
        this.pagesUsed = pagesUsed;
    }

    public Integer getPagesFree() {
        return pagesFree;
    }

    public void setPagesFree(Integer pagesFree) {
        this.pagesFree = pagesFree;
    }

    public Long getRelocationOps() {
        return relocationOps;
    }

    public void setRelocationOps(Long relocationOps) {
        this.relocationOps = relocationOps;
    }

    public Integer getRelocationTime() {
        return relocationTime;
    }

    public void setRelocationTime(Integer relocationTime) {
        this.relocationTime = relocationTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pageSize=").append(pageSize);
        sb.append(", bufferPoolInstance=").append(bufferPoolInstance);
        sb.append(", pagesUsed=").append(pagesUsed);
        sb.append(", pagesFree=").append(pagesFree);
        sb.append(", relocationOps=").append(relocationOps);
        sb.append(", relocationTime=").append(relocationTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}