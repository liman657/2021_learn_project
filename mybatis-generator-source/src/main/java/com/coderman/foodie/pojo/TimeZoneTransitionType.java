package com.coderman.foodie.pojo;

import java.io.Serializable;

public class TimeZoneTransitionType implements Serializable {
    private Integer timeZoneId;

    private Integer transitionTypeId;

    private Integer offset;

    private Byte isDst;

    private String abbreviation;

    private static final long serialVersionUID = 1L;

    public Integer getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(Integer timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public Integer getTransitionTypeId() {
        return transitionTypeId;
    }

    public void setTransitionTypeId(Integer transitionTypeId) {
        this.transitionTypeId = transitionTypeId;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Byte getIsDst() {
        return isDst;
    }

    public void setIsDst(Byte isDst) {
        this.isDst = isDst;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation == null ? null : abbreviation.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", timeZoneId=").append(timeZoneId);
        sb.append(", transitionTypeId=").append(transitionTypeId);
        sb.append(", offset=").append(offset);
        sb.append(", isDst=").append(isDst);
        sb.append(", abbreviation=").append(abbreviation);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}