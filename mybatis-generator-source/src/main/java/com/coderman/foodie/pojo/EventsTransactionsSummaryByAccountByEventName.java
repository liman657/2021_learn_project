package com.coderman.foodie.pojo;

import java.io.Serializable;

public class EventsTransactionsSummaryByAccountByEventName implements Serializable {
    private String user;

    private String host;

    private String eventName;

    private Long countStar;

    private Long sumTimerWait;

    private Long minTimerWait;

    private Long avgTimerWait;

    private Long maxTimerWait;

    private Long countReadWrite;

    private Long sumTimerReadWrite;

    private Long minTimerReadWrite;

    private Long avgTimerReadWrite;

    private Long maxTimerReadWrite;

    private Long countReadOnly;

    private Long sumTimerReadOnly;

    private Long minTimerReadOnly;

    private Long avgTimerReadOnly;

    private Long maxTimerReadOnly;

    private static final long serialVersionUID = 1L;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName == null ? null : eventName.trim();
    }

    public Long getCountStar() {
        return countStar;
    }

    public void setCountStar(Long countStar) {
        this.countStar = countStar;
    }

    public Long getSumTimerWait() {
        return sumTimerWait;
    }

    public void setSumTimerWait(Long sumTimerWait) {
        this.sumTimerWait = sumTimerWait;
    }

    public Long getMinTimerWait() {
        return minTimerWait;
    }

    public void setMinTimerWait(Long minTimerWait) {
        this.minTimerWait = minTimerWait;
    }

    public Long getAvgTimerWait() {
        return avgTimerWait;
    }

    public void setAvgTimerWait(Long avgTimerWait) {
        this.avgTimerWait = avgTimerWait;
    }

    public Long getMaxTimerWait() {
        return maxTimerWait;
    }

    public void setMaxTimerWait(Long maxTimerWait) {
        this.maxTimerWait = maxTimerWait;
    }

    public Long getCountReadWrite() {
        return countReadWrite;
    }

    public void setCountReadWrite(Long countReadWrite) {
        this.countReadWrite = countReadWrite;
    }

    public Long getSumTimerReadWrite() {
        return sumTimerReadWrite;
    }

    public void setSumTimerReadWrite(Long sumTimerReadWrite) {
        this.sumTimerReadWrite = sumTimerReadWrite;
    }

    public Long getMinTimerReadWrite() {
        return minTimerReadWrite;
    }

    public void setMinTimerReadWrite(Long minTimerReadWrite) {
        this.minTimerReadWrite = minTimerReadWrite;
    }

    public Long getAvgTimerReadWrite() {
        return avgTimerReadWrite;
    }

    public void setAvgTimerReadWrite(Long avgTimerReadWrite) {
        this.avgTimerReadWrite = avgTimerReadWrite;
    }

    public Long getMaxTimerReadWrite() {
        return maxTimerReadWrite;
    }

    public void setMaxTimerReadWrite(Long maxTimerReadWrite) {
        this.maxTimerReadWrite = maxTimerReadWrite;
    }

    public Long getCountReadOnly() {
        return countReadOnly;
    }

    public void setCountReadOnly(Long countReadOnly) {
        this.countReadOnly = countReadOnly;
    }

    public Long getSumTimerReadOnly() {
        return sumTimerReadOnly;
    }

    public void setSumTimerReadOnly(Long sumTimerReadOnly) {
        this.sumTimerReadOnly = sumTimerReadOnly;
    }

    public Long getMinTimerReadOnly() {
        return minTimerReadOnly;
    }

    public void setMinTimerReadOnly(Long minTimerReadOnly) {
        this.minTimerReadOnly = minTimerReadOnly;
    }

    public Long getAvgTimerReadOnly() {
        return avgTimerReadOnly;
    }

    public void setAvgTimerReadOnly(Long avgTimerReadOnly) {
        this.avgTimerReadOnly = avgTimerReadOnly;
    }

    public Long getMaxTimerReadOnly() {
        return maxTimerReadOnly;
    }

    public void setMaxTimerReadOnly(Long maxTimerReadOnly) {
        this.maxTimerReadOnly = maxTimerReadOnly;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", user=").append(user);
        sb.append(", host=").append(host);
        sb.append(", eventName=").append(eventName);
        sb.append(", countStar=").append(countStar);
        sb.append(", sumTimerWait=").append(sumTimerWait);
        sb.append(", minTimerWait=").append(minTimerWait);
        sb.append(", avgTimerWait=").append(avgTimerWait);
        sb.append(", maxTimerWait=").append(maxTimerWait);
        sb.append(", countReadWrite=").append(countReadWrite);
        sb.append(", sumTimerReadWrite=").append(sumTimerReadWrite);
        sb.append(", minTimerReadWrite=").append(minTimerReadWrite);
        sb.append(", avgTimerReadWrite=").append(avgTimerReadWrite);
        sb.append(", maxTimerReadWrite=").append(maxTimerReadWrite);
        sb.append(", countReadOnly=").append(countReadOnly);
        sb.append(", sumTimerReadOnly=").append(sumTimerReadOnly);
        sb.append(", minTimerReadOnly=").append(minTimerReadOnly);
        sb.append(", avgTimerReadOnly=").append(avgTimerReadOnly);
        sb.append(", maxTimerReadOnly=").append(maxTimerReadOnly);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}