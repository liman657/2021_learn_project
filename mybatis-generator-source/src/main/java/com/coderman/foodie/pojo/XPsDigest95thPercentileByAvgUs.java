package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class XPsDigest95thPercentileByAvgUs implements Serializable {
    private BigDecimal avgUs;

    private BigDecimal percentile;

    private static final long serialVersionUID = 1L;

    public BigDecimal getAvgUs() {
        return avgUs;
    }

    public void setAvgUs(BigDecimal avgUs) {
        this.avgUs = avgUs;
    }

    public BigDecimal getPercentile() {
        return percentile;
    }

    public void setPercentile(BigDecimal percentile) {
        this.percentile = percentile;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", avgUs=").append(avgUs);
        sb.append(", percentile=").append(percentile);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}