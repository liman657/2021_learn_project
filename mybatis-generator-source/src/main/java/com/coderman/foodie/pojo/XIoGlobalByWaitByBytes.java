package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class XIoGlobalByWaitByBytes implements Serializable {
    private String eventName;

    private Long total;

    private Long totalLatency;

    private Long minLatency;

    private Long avgLatency;

    private Long maxLatency;

    private Long countRead;

    private Long totalRead;

    private BigDecimal avgRead;

    private Long countWrite;

    private Long totalWritten;

    private BigDecimal avgWritten;

    private Long totalRequested;

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

    public Long getTotalLatency() {
        return totalLatency;
    }

    public void setTotalLatency(Long totalLatency) {
        this.totalLatency = totalLatency;
    }

    public Long getMinLatency() {
        return minLatency;
    }

    public void setMinLatency(Long minLatency) {
        this.minLatency = minLatency;
    }

    public Long getAvgLatency() {
        return avgLatency;
    }

    public void setAvgLatency(Long avgLatency) {
        this.avgLatency = avgLatency;
    }

    public Long getMaxLatency() {
        return maxLatency;
    }

    public void setMaxLatency(Long maxLatency) {
        this.maxLatency = maxLatency;
    }

    public Long getCountRead() {
        return countRead;
    }

    public void setCountRead(Long countRead) {
        this.countRead = countRead;
    }

    public Long getTotalRead() {
        return totalRead;
    }

    public void setTotalRead(Long totalRead) {
        this.totalRead = totalRead;
    }

    public BigDecimal getAvgRead() {
        return avgRead;
    }

    public void setAvgRead(BigDecimal avgRead) {
        this.avgRead = avgRead;
    }

    public Long getCountWrite() {
        return countWrite;
    }

    public void setCountWrite(Long countWrite) {
        this.countWrite = countWrite;
    }

    public Long getTotalWritten() {
        return totalWritten;
    }

    public void setTotalWritten(Long totalWritten) {
        this.totalWritten = totalWritten;
    }

    public BigDecimal getAvgWritten() {
        return avgWritten;
    }

    public void setAvgWritten(BigDecimal avgWritten) {
        this.avgWritten = avgWritten;
    }

    public Long getTotalRequested() {
        return totalRequested;
    }

    public void setTotalRequested(Long totalRequested) {
        this.totalRequested = totalRequested;
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