package com.coderman.foodie.pojo;

import java.io.Serializable;

public class IoGlobalByWaitByBytes implements Serializable {
    private String eventName;

    private Long total;

    private String totalLatency;

    private String minLatency;

    private String avgLatency;

    private String maxLatency;

    private Long countRead;

    private String totalRead;

    private String avgRead;

    private Long countWrite;

    private String totalWritten;

    private String avgWritten;

    private String totalRequested;

    private static final long serialVersionUID = 1L;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName == null ? null : eventName.trim();
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getTotalLatency() {
        return totalLatency;
    }

    public void setTotalLatency(String totalLatency) {
        this.totalLatency = totalLatency == null ? null : totalLatency.trim();
    }

    public String getMinLatency() {
        return minLatency;
    }

    public void setMinLatency(String minLatency) {
        this.minLatency = minLatency == null ? null : minLatency.trim();
    }

    public String getAvgLatency() {
        return avgLatency;
    }

    public void setAvgLatency(String avgLatency) {
        this.avgLatency = avgLatency == null ? null : avgLatency.trim();
    }

    public String getMaxLatency() {
        return maxLatency;
    }

    public void setMaxLatency(String maxLatency) {
        this.maxLatency = maxLatency == null ? null : maxLatency.trim();
    }

    public Long getCountRead() {
        return countRead;
    }

    public void setCountRead(Long countRead) {
        this.countRead = countRead;
    }

    public String getTotalRead() {
        return totalRead;
    }

    public void setTotalRead(String totalRead) {
        this.totalRead = totalRead == null ? null : totalRead.trim();
    }

    public String getAvgRead() {
        return avgRead;
    }

    public void setAvgRead(String avgRead) {
        this.avgRead = avgRead == null ? null : avgRead.trim();
    }

    public Long getCountWrite() {
        return countWrite;
    }

    public void setCountWrite(Long countWrite) {
        this.countWrite = countWrite;
    }

    public String getTotalWritten() {
        return totalWritten;
    }

    public void setTotalWritten(String totalWritten) {
        this.totalWritten = totalWritten == null ? null : totalWritten.trim();
    }

    public String getAvgWritten() {
        return avgWritten;
    }

    public void setAvgWritten(String avgWritten) {
        this.avgWritten = avgWritten == null ? null : avgWritten.trim();
    }

    public String getTotalRequested() {
        return totalRequested;
    }

    public void setTotalRequested(String totalRequested) {
        this.totalRequested = totalRequested == null ? null : totalRequested.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eventName=").append(eventName);
        sb.append(", total=").append(total);
        sb.append(", totalLatency=").append(totalLatency);
        sb.append(", minLatency=").append(minLatency);
        sb.append(", avgLatency=").append(avgLatency);
        sb.append(", maxLatency=").append(maxLatency);
        sb.append(", countRead=").append(countRead);
        sb.append(", totalRead=").append(totalRead);
        sb.append(", avgRead=").append(avgRead);
        sb.append(", countWrite=").append(countWrite);
        sb.append(", totalWritten=").append(totalWritten);
        sb.append(", avgWritten=").append(avgWritten);
        sb.append(", totalRequested=").append(totalRequested);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}