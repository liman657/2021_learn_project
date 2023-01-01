package com.coderman.foodie.pojo;

import java.io.Serializable;

public class InnodbCachedIndexes implements Serializable {
    private Integer spaceId;

    private Long indexId;

    private Long nCachedPages;

    private static final long serialVersionUID = 1L;

    public Integer getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }

    public Long getIndexId() {
        return indexId;
    }

    public void setIndexId(Long indexId) {
        this.indexId = indexId;
    }

    public Long getnCachedPages() {
        return nCachedPages;
    }

    public void setnCachedPages(Long nCachedPages) {
        this.nCachedPages = nCachedPages;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", spaceId=").append(spaceId);
        sb.append(", indexId=").append(indexId);
        sb.append(", nCachedPages=").append(nCachedPages);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}