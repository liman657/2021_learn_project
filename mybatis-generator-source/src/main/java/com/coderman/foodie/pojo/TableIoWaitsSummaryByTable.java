package com.coderman.foodie.pojo;

import java.io.Serializable;

public class TableIoWaitsSummaryByTable implements Serializable {
    private String objectType;

    private String objectSchema;

    private String objectName;

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

    private Long countWrite;

    private Long sumTimerWrite;

    private Long minTimerWrite;

    private Long avgTimerWrite;

    private Long maxTimerWrite;

    private Long countFetch;

    private Long sumTimerFetch;

    private Long minTimerFetch;

    private Long avgTimerFetch;

    private Long maxTimerFetch;

    private Long countInsert;

    private Long sumTimerInsert;

    private Long minTimerInsert;

    private Long avgTimerInsert;

    private Long maxTimerInsert;

    private Long countUpdate;

    private Long sumTimerUpdate;

    private Long minTimerUpdate;

    private Long avgTimerUpdate;

    private Long maxTimerUpdate;

    private Long countDelete;

    private Long sumTimerDelete;

    private Long minTimerDelete;

    private Long avgTimerDelete;

    private Long maxTimerDelete;

    private static final long serialVersionUID = 1L;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType == null ? null : objectType.trim();
    }

    public String getObjectSchema() {
        return objectSchema;
    }

    public void setObjectSchema(String objectSchema) {
        this.objectSchema = objectSchema == null ? null : objectSchema.trim();
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName == null ? null : objectName.trim();
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

    public Long getCountFetch() {
        return countFetch;
    }

    public void setCountFetch(Long countFetch) {
        this.countFetch = countFetch;
    }

    public Long getSumTimerFetch() {
        return sumTimerFetch;
    }

    public void setSumTimerFetch(Long sumTimerFetch) {
        this.sumTimerFetch = sumTimerFetch;
    }

    public Long getMinTimerFetch() {
        return minTimerFetch;
    }

    public void setMinTimerFetch(Long minTimerFetch) {
        this.minTimerFetch = minTimerFetch;
    }

    public Long getAvgTimerFetch() {
        return avgTimerFetch;
    }

    public void setAvgTimerFetch(Long avgTimerFetch) {
        this.avgTimerFetch = avgTimerFetch;
    }

    public Long getMaxTimerFetch() {
        return maxTimerFetch;
    }

    public void setMaxTimerFetch(Long maxTimerFetch) {
        this.maxTimerFetch = maxTimerFetch;
    }

    public Long getCountInsert() {
        return countInsert;
    }

    public void setCountInsert(Long countInsert) {
        this.countInsert = countInsert;
    }

    public Long getSumTimerInsert() {
        return sumTimerInsert;
    }

    public void setSumTimerInsert(Long sumTimerInsert) {
        this.sumTimerInsert = sumTimerInsert;
    }

    public Long getMinTimerInsert() {
        return minTimerInsert;
    }

    public void setMinTimerInsert(Long minTimerInsert) {
        this.minTimerInsert = minTimerInsert;
    }

    public Long getAvgTimerInsert() {
        return avgTimerInsert;
    }

    public void setAvgTimerInsert(Long avgTimerInsert) {
        this.avgTimerInsert = avgTimerInsert;
    }

    public Long getMaxTimerInsert() {
        return maxTimerInsert;
    }

    public void setMaxTimerInsert(Long maxTimerInsert) {
        this.maxTimerInsert = maxTimerInsert;
    }

    public Long getCountUpdate() {
        return countUpdate;
    }

    public void setCountUpdate(Long countUpdate) {
        this.countUpdate = countUpdate;
    }

    public Long getSumTimerUpdate() {
        return sumTimerUpdate;
    }

    public void setSumTimerUpdate(Long sumTimerUpdate) {
        this.sumTimerUpdate = sumTimerUpdate;
    }

    public Long getMinTimerUpdate() {
        return minTimerUpdate;
    }

    public void setMinTimerUpdate(Long minTimerUpdate) {
        this.minTimerUpdate = minTimerUpdate;
    }

    public Long getAvgTimerUpdate() {
        return avgTimerUpdate;
    }

    public void setAvgTimerUpdate(Long avgTimerUpdate) {
        this.avgTimerUpdate = avgTimerUpdate;
    }

    public Long getMaxTimerUpdate() {
        return maxTimerUpdate;
    }

    public void setMaxTimerUpdate(Long maxTimerUpdate) {
        this.maxTimerUpdate = maxTimerUpdate;
    }

    public Long getCountDelete() {
        return countDelete;
    }

    public void setCountDelete(Long countDelete) {
        this.countDelete = countDelete;
    }

    public Long getSumTimerDelete() {
        return sumTimerDelete;
    }

    public void setSumTimerDelete(Long sumTimerDelete) {
        this.sumTimerDelete = sumTimerDelete;
    }

    public Long getMinTimerDelete() {
        return minTimerDelete;
    }

    public void setMinTimerDelete(Long minTimerDelete) {
        this.minTimerDelete = minTimerDelete;
    }

    public Long getAvgTimerDelete() {
        return avgTimerDelete;
    }

    public void setAvgTimerDelete(Long avgTimerDelete) {
        this.avgTimerDelete = avgTimerDelete;
    }

    public Long getMaxTimerDelete() {
        return maxTimerDelete;
    }

    public void setMaxTimerDelete(Long maxTimerDelete) {
        this.maxTimerDelete = maxTimerDelete;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", objectType=").append(objectType);
        sb.append(", objectSchema=").append(objectSchema);
        sb.append(", objectName=").append(objectName);
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
        sb.append(", countWrite=").append(countWrite);
        sb.append(", sumTimerWrite=").append(sumTimerWrite);
        sb.append(", minTimerWrite=").append(minTimerWrite);
        sb.append(", avgTimerWrite=").append(avgTimerWrite);
        sb.append(", maxTimerWrite=").append(maxTimerWrite);
        sb.append(", countFetch=").append(countFetch);
        sb.append(", sumTimerFetch=").append(sumTimerFetch);
        sb.append(", minTimerFetch=").append(minTimerFetch);
        sb.append(", avgTimerFetch=").append(avgTimerFetch);
        sb.append(", maxTimerFetch=").append(maxTimerFetch);
        sb.append(", countInsert=").append(countInsert);
        sb.append(", sumTimerInsert=").append(sumTimerInsert);
        sb.append(", minTimerInsert=").append(minTimerInsert);
        sb.append(", avgTimerInsert=").append(avgTimerInsert);
        sb.append(", maxTimerInsert=").append(maxTimerInsert);
        sb.append(", countUpdate=").append(countUpdate);
        sb.append(", sumTimerUpdate=").append(sumTimerUpdate);
        sb.append(", minTimerUpdate=").append(minTimerUpdate);
        sb.append(", avgTimerUpdate=").append(avgTimerUpdate);
        sb.append(", maxTimerUpdate=").append(maxTimerUpdate);
        sb.append(", countDelete=").append(countDelete);
        sb.append(", sumTimerDelete=").append(sumTimerDelete);
        sb.append(", minTimerDelete=").append(minTimerDelete);
        sb.append(", avgTimerDelete=").append(avgTimerDelete);
        sb.append(", maxTimerDelete=").append(maxTimerDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}