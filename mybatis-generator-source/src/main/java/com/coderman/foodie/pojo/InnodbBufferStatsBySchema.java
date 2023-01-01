package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class InnodbBufferStatsBySchema implements Serializable {
    private String allocated;

    private String data;

    private Long pages;

    private Long pagesHashed;

    private Long pagesOld;

    private BigDecimal rowsCached;

    private String objectSchema;

    private static final long serialVersionUID = 1L;

    public String getAllocated() {
        return allocated;
    }

    public void setAllocated(String allocated) {
        this.allocated = allocated == null ? null : allocated.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Long getPagesHashed() {
        return pagesHashed;
    }

    public void setPagesHashed(Long pagesHashed) {
        this.pagesHashed = pagesHashed;
    }

    public Long getPagesOld() {
        return pagesOld;
    }

    public void setPagesOld(Long pagesOld) {
        this.pagesOld = pagesOld;
    }

    public BigDecimal getRowsCached() {
        return rowsCached;
    }

    public void setRowsCached(BigDecimal rowsCached) {
        this.rowsCached = rowsCached;
    }

    public String getObjectSchema() {
        return objectSchema;
    }

    public void setObjectSchema(String objectSchema) {
        this.objectSchema = objectSchema == null ? null : objectSchema.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", allocated=").append(allocated);
        sb.append(", data=").append(data);
        sb.append(", pages=").append(pages);
        sb.append(", pagesHashed=").append(pagesHashed);
        sb.append(", pagesOld=").append(pagesOld);
        sb.append(", rowsCached=").append(rowsCached);
        sb.append(", objectSchema=").append(objectSchema);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}