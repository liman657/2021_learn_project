package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class InnodbMetrics implements Serializable {
    private String name;

    private String subsystem;

    private Long count;

    private Long maxCount;

    private Long minCount;

    private Float avgCount;

    private Long countReset;

    private Long maxCountReset;

    private Long minCountReset;

    private Float avgCountReset;

    private Date timeEnabled;

    private Date timeDisabled;

    private Long timeElapsed;

    private Date timeReset;

    private String status;

    private String type;

    private String comment;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSubsystem() {
        return subsystem;
    }

    public void setSubsystem(String subsystem) {
        this.subsystem = subsystem == null ? null : subsystem.trim();
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Long maxCount) {
        this.maxCount = maxCount;
    }

    public Long getMinCount() {
        return minCount;
    }

    public void setMinCount(Long minCount) {
        this.minCount = minCount;
    }

    public Float getAvgCount() {
        return avgCount;
    }

    public void setAvgCount(Float avgCount) {
        this.avgCount = avgCount;
    }

    public Long getCountReset() {
        return countReset;
    }

    public void setCountReset(Long countReset) {
        this.countReset = countReset;
    }

    public Long getMaxCountReset() {
        return maxCountReset;
    }

    public void setMaxCountReset(Long maxCountReset) {
        this.maxCountReset = maxCountReset;
    }

    public Long getMinCountReset() {
        return minCountReset;
    }

    public void setMinCountReset(Long minCountReset) {
        this.minCountReset = minCountReset;
    }

    public Float getAvgCountReset() {
        return avgCountReset;
    }

    public void setAvgCountReset(Float avgCountReset) {
        this.avgCountReset = avgCountReset;
    }

    public Date getTimeEnabled() {
        return timeEnabled;
    }

    public void setTimeEnabled(Date timeEnabled) {
        this.timeEnabled = timeEnabled;
    }

    public Date getTimeDisabled() {
        return timeDisabled;
    }

    public void setTimeDisabled(Date timeDisabled) {
        this.timeDisabled = timeDisabled;
    }

    public Long getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(Long timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public Date getTimeReset() {
        return timeReset;
    }

    public void setTimeReset(Date timeReset) {
        this.timeReset = timeReset;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", name=").append(name);
        sb.append(", subsystem=").append(subsystem);
        sb.append(", count=").append(count);
        sb.append(", maxCount=").append(maxCount);
        sb.append(", minCount=").append(minCount);
        sb.append(", avgCount=").append(avgCount);
        sb.append(", countReset=").append(countReset);
        sb.append(", maxCountReset=").append(maxCountReset);
        sb.append(", minCountReset=").append(minCountReset);
        sb.append(", avgCountReset=").append(avgCountReset);
        sb.append(", timeEnabled=").append(timeEnabled);
        sb.append(", timeDisabled=").append(timeDisabled);
        sb.append(", timeElapsed=").append(timeElapsed);
        sb.append(", timeReset=").append(timeReset);
        sb.append(", status=").append(status);
        sb.append(", type=").append(type);
        sb.append(", comment=").append(comment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}