package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class XInnodbBufferStatsByTable implements Serializable {
    private BigDecimal allocated;

    private BigDecimal data;

    private Long pages;

    private Long pagesHashed;

    private Long pagesOld;

    private BigDecimal rowsCached;

    private String objectSchema;

    private String objectName;

    private static final long serialVersionUID = 1L;

    public BigDecimal getAllocated() {
        return allocated;
    }

    public void setAllocated(BigDecimal allocated) {
        this.allocated = allocated;
    }

    public BigDecimal getData() {
        return data;
    }

    public void setData(BigDecimal data) {
        this.data = data;
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

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName == null ? null : objectName.trim();
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
        sb.append(", objectName=").append(objectName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}