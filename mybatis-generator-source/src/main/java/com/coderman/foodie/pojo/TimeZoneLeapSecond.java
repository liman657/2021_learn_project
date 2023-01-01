package com.coderman.foodie.pojo;

import java.io.Serializable;

public class TimeZoneLeapSecond implements Serializable {
    private Long transitionTime;

    private Integer correction;

    private static final long serialVersionUID = 1L;

    public Long getTransitionTime() {
        return transitionTime;
    }

    public void setTransitionTime(Long transitionTime) {
        this.transitionTime = transitionTime;
    }

    public Integer getCorrection() {
        return correction;
    }

    public void setCorrection(Integer correction) {
        this.correction = correction;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", transitionTime=").append(transitionTime);
        sb.append(", correction=").append(correction);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}