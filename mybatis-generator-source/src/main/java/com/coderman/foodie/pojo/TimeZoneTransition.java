package com.coderman.foodie.pojo;

import java.io.Serializable;

public class TimeZoneTransition implements Serializable {
    private Integer timeZoneId;

    private Long transitionTime;

    private Integer transitionTypeId;

    private static final long serialVersionUID = 1L;

    public Integer getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(Integer timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public Long getTransitionTime() {
        return transitionTime;
    }

    public void setTransitionTime(Long transitionTime) {
        this.transitionTime = transitionTime;
    }

    public Integer getTransitionTypeId() {
        return transitionTypeId;
    }

    public void setTransitionTypeId(Integer transitionTypeId) {
        this.transitionTypeId = transitionTypeId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", timeZoneId=").append(timeZoneId);
        sb.append(", transitionTime=").append(transitionTime);
        sb.append(", transitionTypeId=").append(transitionTypeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}