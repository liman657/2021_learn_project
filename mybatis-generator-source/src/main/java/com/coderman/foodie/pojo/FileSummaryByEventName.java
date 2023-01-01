package com.coderman.foodie.pojo;

import java.io.Serializable;

public class FileSummaryByEventName implements Serializable {
    private String eventName;

    private Long countStar;

    private Long sumTimerWait;

    private Long minTimerWait;

    private Long avgTimerWait;

    private Long maxTimerWait;

    private Long countRead;

    private Long sumTimerRead;

    private Long minTimerRead;

    private Long avgTimerRead;

    private Long maxTimerRead;

    private Long sumNumberOfBytesRead;

    private Long countWrite;

    private Long sumTimerWrite;

    private Long minTimerWrite;

    private Long avgTimerWrite;

    private Long maxTimerWrite;

    private Long sumNumberOfBytesWrite;

    private Long countMisc;

    private Long sumTimerMisc;

    private Long minTimerMisc;

    private Long avgTimerMisc;

    private Long maxTimerMisc;

    private static final long serialVersionUID = 1L;

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

    public Long getCountRead() {
        return countRead;
    }

    public void setCountRead(Long countRead) {
        this.countRead = countRead;
    }

    public Long getSumTimerRead() {
        return sumTimerRead;
    }

    public void setSumTimerRead(Long sumTimerRead) {
        this.sumTimerRead = sumTimerRead;
    }

    public Long getMinTimerRead() {
        return minTimerRead;
    }

    public void setMinTimerRead(Long minTimerRead) {
        this.minTimerRead = minTimerRead;
    }

    public Long getAvgTimerRead() {
        return avgTimerRead;
    }

    public void setAvgTimerRead(Long avgTimerRead) {
        this.avgTimerRead = avgTimerRead;
    }

    public Long getMaxTimerRead() {
        return maxTimerRead;
    }

    public void setMaxTimerRead(Long maxTimerRead) {
        this.maxTimerRead = maxTimerRead;
    }

    public Long getSumNumberOfBytesRead() {
        return sumNumberOfBytesRead;
    }

    public void setSumNumberOfBytesRead(Long sumNumberOfBytesRead) {
        this.sumNumberOfBytesRead = sumNumberOfBytesRead;
    }

    public Long getCountWrite() {
        return countWrite;
    }

    public void setCountWrite(Long countWrite) {
        this.countWrite = countWrite;
    }

    public Long getSumTimerWrite() {
        return sumTimerWrite;
    }

    public void setSumTimerWrite(Long sumTimerWrite) {
        this.sumTimerWrite = sumTimerWrite;
    }

    public Long getMinTimerWrite() {
        return minTimerWrite;
    }

    public void setMinTimerWrite(Long minTimerWrite) {
        this.minTimerWrite = minTimerWrite;
    }

    public Long getAvgTimerWrite() {
        return avgTimerWrite;
    }

    public void setAvgTimerWrite(Long avgTimerWrite) {
        this.avgTimerWrite = avgTimerWrite;
    }

    public Long getMaxTimerWrite() {
        return maxTimerWrite;
    }

    public void setMaxTimerWrite(Long maxTimerWrite) {
        this.maxTimerWrite = maxTimerWrite;
    }

    public Long getSumNumberOfBytesWrite() {
        return sumNumberOfBytesWrite;
    }

    public void setSumNumberOfBytesWrite(Long sumNumberOfBytesWrite) {
        this.sumNumberOfBytesWrite = sumNumberOfBytesWrite;
    }

    public Long getCountMisc() {
        return countMisc;
    }

    public void setCountMisc(Long countMisc) {
        this.countMisc = countMisc;
    }

    public Long getSumTimerMisc() {
        return sumTimerMisc;
    }

    public void setSumTimerMisc(Long sumTimerMisc) {
        this.sumTimerMisc = sumTimerMisc;
    }

    public Long getMinTimerMisc() {
        return minTimerMisc;
    }

    public void setMinTimerMisc(Long minTimerMisc) {
        this.minTimerMisc = minTimerMisc;
    }

    public Long getAvgTimerMisc() {
        return avgTimerMisc;
    }

    public void setAvgTimerMisc(Long avgTimerMisc) {
        this.avgTimerMisc = avgTimerMisc;
    }

    public Long getMaxTimerMisc() {
        return maxTimerMisc;
    }

    public void setMaxTimerMisc(Long maxTimerMisc) {
        this.maxTimerMisc = maxTimerMisc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eventName=").append(eventName);
        sb.append(", countStar=").append(countStar);
        sb.append(", sumTimerWait=").append(sumTimerWait);
        sb.append(", minTimerWait=").append(minTimerWait);
        sb.append(", avgTimerWait=").append(avgTimerWait);
        sb.append(", maxTimerWait=").append(maxTimerWait);
        sb.append(", countRead=").append(countRead);
        sb.append(", sumTimerRead=").append(sumTimerRead);
        sb.append(", minTimerRead=").append(minTimerRead);
        sb.append(", avgTimerRead=").append(avgTimerRead);
        sb.append(", maxTimerRead=").append(maxTimerRead);
        sb.append(", sumNumberOfBytesRead=").append(sumNumberOfBytesRead);
        sb.append(", countWrite=").append(countWrite);
        sb.append(", sumTimerWrite=").append(sumTimerWrite);
        sb.append(", minTimerWrite=").append(minTimerWrite);
        sb.append(", avgTimerWrite=").append(avgTimerWrite);
        sb.append(", maxTimerWrite=").append(maxTimerWrite);
        sb.append(", sumNumberOfBytesWrite=").append(sumNumberOfBytesWrite);
        sb.append(", countMisc=").append(countMisc);
        sb.append(", sumTimerMisc=").append(sumTimerMisc);
        sb.append(", minTimerMisc=").append(minTimerMisc);
        sb.append(", avgTimerMisc=").append(avgTimerMisc);
        sb.append(", maxTimerMisc=").append(maxTimerMisc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}