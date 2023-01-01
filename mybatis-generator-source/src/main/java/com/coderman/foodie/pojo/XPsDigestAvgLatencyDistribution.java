package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class XPsDigestAvgLatencyDistribution implements Serializable {
    private Long cnt;

    private BigDecimal avgUs;

    private static final long serialVersionUID = 1L;

    public Long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }

    public BigDecimal getAvgUs() {
        return avgUs;
    }

    public void setAvgUs(BigDecimal avgUs) {
        this.avgUs = avgUs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cnt=").append(cnt);
        sb.append(", avgUs=").append(avgUs);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}