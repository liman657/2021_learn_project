package com.coderman.foodie.pojo;

import java.io.Serializable;

public class TableLockWaitsSummaryByTable implements Serializable {
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

    private Long countReadNormal;

    private Long sumTimerReadNormal;

    private Long minTimerReadNormal;

    private Long avgTimerReadNormal;

    private Long maxTimerReadNormal;

    private Long countReadWithSharedLocks;

    private Long sumTimerReadWithSharedLocks;

    private Long minTimerReadWithSharedLocks;

    private Long avgTimerReadWithSharedLocks;

    private Long maxTimerReadWithSharedLocks;

    private Long countReadHighPriority;

    private Long sumTimerReadHighPriority;

    private Long minTimerReadHighPriority;

    private Long avgTimerReadHighPriority;

    private Long maxTimerReadHighPriority;

    private Long countReadNoInsert;

    private Long sumTimerReadNoInsert;

    private Long minTimerReadNoInsert;

    private Long avgTimerReadNoInsert;

    private Long maxTimerReadNoInsert;

    private Long countReadExternal;

    private Long sumTimerReadExternal;

    private Long minTimerReadExternal;

    private Long avgTimerReadExternal;

    private Long maxTimerReadExternal;

    private Long countWriteAllowWrite;

    private Long sumTimerWriteAllowWrite;

    private Long minTimerWriteAllowWrite;

    private Long avgTimerWriteAllowWrite;

    private Long maxTimerWriteAllowWrite;

    private Long countWriteConcurrentInsert;

    private Long sumTimerWriteConcurrentInsert;

    private Long minTimerWriteConcurrentInsert;

    private Long avgTimerWriteConcurrentInsert;

    private Long maxTimerWriteConcurrentInsert;

    private Long countWriteLowPriority;

    private Long sumTimerWriteLowPriority;

    private Long minTimerWriteLowPriority;

    private Long avgTimerWriteLowPriority;

    private Long maxTimerWriteLowPriority;

    private Long countWriteNormal;

    private Long sumTimerWriteNormal;

    private Long minTimerWriteNormal;

    private Long avgTimerWriteNormal;

    private Long maxTimerWriteNormal;

    private Long countWriteExternal;

    private Long sumTimerWriteExternal;

    private Long minTimerWriteExternal;

    private Long avgTimerWriteExternal;

    private Long maxTimerWriteExternal;

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

    public Long getCountReadNormal() {
        return countReadNormal;
    }

    public void setCountReadNormal(Long countReadNormal) {
        this.countReadNormal = countReadNormal;
    }

    public Long getSumTimerReadNormal() {
        return sumTimerReadNormal;
    }

    public void setSumTimerReadNormal(Long sumTimerReadNormal) {
        this.sumTimerReadNormal = sumTimerReadNormal;
    }

    public Long getMinTimerReadNormal() {
        return minTimerReadNormal;
    }

    public void setMinTimerReadNormal(Long minTimerReadNormal) {
        this.minTimerReadNormal = minTimerReadNormal;
    }

    public Long getAvgTimerReadNormal() {
        return avgTimerReadNormal;
    }

    public void setAvgTimerReadNormal(Long avgTimerReadNormal) {
        this.avgTimerReadNormal = avgTimerReadNormal;
    }

    public Long getMaxTimerReadNormal() {
        return maxTimerReadNormal;
    }

    public void setMaxTimerReadNormal(Long maxTimerReadNormal) {
        this.maxTimerReadNormal = maxTimerReadNormal;
    }

    public Long getCountReadWithSharedLocks() {
        return countReadWithSharedLocks;
    }

    public void setCountReadWithSharedLocks(Long countReadWithSharedLocks) {
        this.countReadWithSharedLocks = countReadWithSharedLocks;
    }

    public Long getSumTimerReadWithSharedLocks() {
        return sumTimerReadWithSharedLocks;
    }

    public void setSumTimerReadWithSharedLocks(Long sumTimerReadWithSharedLocks) {
        this.sumTimerReadWithSharedLocks = sumTimerReadWithSharedLocks;
    }

    public Long getMinTimerReadWithSharedLocks() {
        return minTimerReadWithSharedLocks;
    }

    public void setMinTimerReadWithSharedLocks(Long minTimerReadWithSharedLocks) {
        this.minTimerReadWithSharedLocks = minTimerReadWithSharedLocks;
    }

    public Long getAvgTimerReadWithSharedLocks() {
        return avgTimerReadWithSharedLocks;
    }

    public void setAvgTimerReadWithSharedLocks(Long avgTimerReadWithSharedLocks) {
        this.avgTimerReadWithSharedLocks = avgTimerReadWithSharedLocks;
    }

    public Long getMaxTimerReadWithSharedLocks() {
        return maxTimerReadWithSharedLocks;
    }

    public void setMaxTimerReadWithSharedLocks(Long maxTimerReadWithSharedLocks) {
        this.maxTimerReadWithSharedLocks = maxTimerReadWithSharedLocks;
    }

    public Long getCountReadHighPriority() {
        return countReadHighPriority;
    }

    public void setCountReadHighPriority(Long countReadHighPriority) {
        this.countReadHighPriority = countReadHighPriority;
    }

    public Long getSumTimerReadHighPriority() {
        return sumTimerReadHighPriority;
    }

    public void setSumTimerReadHighPriority(Long sumTimerReadHighPriority) {
        this.sumTimerReadHighPriority = sumTimerReadHighPriority;
    }

    public Long getMinTimerReadHighPriority() {
        return minTimerReadHighPriority;
    }

    public void setMinTimerReadHighPriority(Long minTimerReadHighPriority) {
        this.minTimerReadHighPriority = minTimerReadHighPriority;
    }

    public Long getAvgTimerReadHighPriority() {
        return avgTimerReadHighPriority;
    }

    public void setAvgTimerReadHighPriority(Long avgTimerReadHighPriority) {
        this.avgTimerReadHighPriority = avgTimerReadHighPriority;
    }

    public Long getMaxTimerReadHighPriority() {
        return maxTimerReadHighPriority;
    }

    public void setMaxTimerReadHighPriority(Long maxTimerReadHighPriority) {
        this.maxTimerReadHighPriority = maxTimerReadHighPriority;
    }

    public Long getCountReadNoInsert() {
        return countReadNoInsert;
    }

    public void setCountReadNoInsert(Long countReadNoInsert) {
        this.countReadNoInsert = countReadNoInsert;
    }

    public Long getSumTimerReadNoInsert() {
        return sumTimerReadNoInsert;
    }

    public void setSumTimerReadNoInsert(Long sumTimerReadNoInsert) {
        this.sumTimerReadNoInsert = sumTimerReadNoInsert;
    }

    public Long getMinTimerReadNoInsert() {
        return minTimerReadNoInsert;
    }

    public void setMinTimerReadNoInsert(Long minTimerReadNoInsert) {
        this.minTimerReadNoInsert = minTimerReadNoInsert;
    }

    public Long getAvgTimerReadNoInsert() {
        return avgTimerReadNoInsert;
    }

    public void setAvgTimerReadNoInsert(Long avgTimerReadNoInsert) {
        this.avgTimerReadNoInsert = avgTimerReadNoInsert;
    }

    public Long getMaxTimerReadNoInsert() {
        return maxTimerReadNoInsert;
    }

    public void setMaxTimerReadNoInsert(Long maxTimerReadNoInsert) {
        this.maxTimerReadNoInsert = maxTimerReadNoInsert;
    }

    public Long getCountReadExternal() {
        return countReadExternal;
    }

    public void setCountReadExternal(Long countReadExternal) {
        this.countReadExternal = countReadExternal;
    }

    public Long getSumTimerReadExternal() {
        return sumTimerReadExternal;
    }

    public void setSumTimerReadExternal(Long sumTimerReadExternal) {
        this.sumTimerReadExternal = sumTimerReadExternal;
    }

    public Long getMinTimerReadExternal() {
        return minTimerReadExternal;
    }

    public void setMinTimerReadExternal(Long minTimerReadExternal) {
        this.minTimerReadExternal = minTimerReadExternal;
    }

    public Long getAvgTimerReadExternal() {
        return avgTimerReadExternal;
    }

    public void setAvgTimerReadExternal(Long avgTimerReadExternal) {
        this.avgTimerReadExternal = avgTimerReadExternal;
    }

    public Long getMaxTimerReadExternal() {
        return maxTimerReadExternal;
    }

    public void setMaxTimerReadExternal(Long maxTimerReadExternal) {
        this.maxTimerReadExternal = maxTimerReadExternal;
    }

    public Long getCountWriteAllowWrite() {
        return countWriteAllowWrite;
    }

    public void setCountWriteAllowWrite(Long countWriteAllowWrite) {
        this.countWriteAllowWrite = countWriteAllowWrite;
    }

    public Long getSumTimerWriteAllowWrite() {
        return sumTimerWriteAllowWrite;
    }

    public void setSumTimerWriteAllowWrite(Long sumTimerWriteAllowWrite) {
        this.sumTimerWriteAllowWrite = sumTimerWriteAllowWrite;
    }

    public Long getMinTimerWriteAllowWrite() {
        return minTimerWriteAllowWrite;
    }

    public void setMinTimerWriteAllowWrite(Long minTimerWriteAllowWrite) {
        this.minTimerWriteAllowWrite = minTimerWriteAllowWrite;
    }

    public Long getAvgTimerWriteAllowWrite() {
        return avgTimerWriteAllowWrite;
    }

    public void setAvgTimerWriteAllowWrite(Long avgTimerWriteAllowWrite) {
        this.avgTimerWriteAllowWrite = avgTimerWriteAllowWrite;
    }

    public Long getMaxTimerWriteAllowWrite() {
        return maxTimerWriteAllowWrite;
    }

    public void setMaxTimerWriteAllowWrite(Long maxTimerWriteAllowWrite) {
        this.maxTimerWriteAllowWrite = maxTimerWriteAllowWrite;
    }

    public Long getCountWriteConcurrentInsert() {
        return countWriteConcurrentInsert;
    }

    public void setCountWriteConcurrentInsert(Long countWriteConcurrentInsert) {
        this.countWriteConcurrentInsert = countWriteConcurrentInsert;
    }

    public Long getSumTimerWriteConcurrentInsert() {
        return sumTimerWriteConcurrentInsert;
    }

    public void setSumTimerWriteConcurrentInsert(Long sumTimerWriteConcurrentInsert) {
        this.sumTimerWriteConcurrentInsert = sumTimerWriteConcurrentInsert;
    }

    public Long getMinTimerWriteConcurrentInsert() {
        return minTimerWriteConcurrentInsert;
    }

    public void setMinTimerWriteConcurrentInsert(Long minTimerWriteConcurrentInsert) {
        this.minTimerWriteConcurrentInsert = minTimerWriteConcurrentInsert;
    }

    public Long getAvgTimerWriteConcurrentInsert() {
        return avgTimerWriteConcurrentInsert;
    }

    public void setAvgTimerWriteConcurrentInsert(Long avgTimerWriteConcurrentInsert) {
        this.avgTimerWriteConcurrentInsert = avgTimerWriteConcurrentInsert;
    }

    public Long getMaxTimerWriteConcurrentInsert() {
        return maxTimerWriteConcurrentInsert;
    }

    public void setMaxTimerWriteConcurrentInsert(Long maxTimerWriteConcurrentInsert) {
        this.maxTimerWriteConcurrentInsert = maxTimerWriteConcurrentInsert;
    }

    public Long getCountWriteLowPriority() {
        return countWriteLowPriority;
    }

    public void setCountWriteLowPriority(Long countWriteLowPriority) {
        this.countWriteLowPriority = countWriteLowPriority;
    }

    public Long getSumTimerWriteLowPriority() {
        return sumTimerWriteLowPriority;
    }

    public void setSumTimerWriteLowPriority(Long sumTimerWriteLowPriority) {
        this.sumTimerWriteLowPriority = sumTimerWriteLowPriority;
    }

    public Long getMinTimerWriteLowPriority() {
        return minTimerWriteLowPriority;
    }

    public void setMinTimerWriteLowPriority(Long minTimerWriteLowPriority) {
        this.minTimerWriteLowPriority = minTimerWriteLowPriority;
    }

    public Long getAvgTimerWriteLowPriority() {
        return avgTimerWriteLowPriority;
    }

    public void setAvgTimerWriteLowPriority(Long avgTimerWriteLowPriority) {
        this.avgTimerWriteLowPriority = avgTimerWriteLowPriority;
    }

    public Long getMaxTimerWriteLowPriority() {
        return maxTimerWriteLowPriority;
    }

    public void setMaxTimerWriteLowPriority(Long maxTimerWriteLowPriority) {
        this.maxTimerWriteLowPriority = maxTimerWriteLowPriority;
    }

    public Long getCountWriteNormal() {
        return countWriteNormal;
    }

    public void setCountWriteNormal(Long countWriteNormal) {
        this.countWriteNormal = countWriteNormal;
    }

    public Long getSumTimerWriteNormal() {
        return sumTimerWriteNormal;
    }

    public void setSumTimerWriteNormal(Long sumTimerWriteNormal) {
        this.sumTimerWriteNormal = sumTimerWriteNormal;
    }

    public Long getMinTimerWriteNormal() {
        return minTimerWriteNormal;
    }

    public void setMinTimerWriteNormal(Long minTimerWriteNormal) {
        this.minTimerWriteNormal = minTimerWriteNormal;
    }

    public Long getAvgTimerWriteNormal() {
        return avgTimerWriteNormal;
    }

    public void setAvgTimerWriteNormal(Long avgTimerWriteNormal) {
        this.avgTimerWriteNormal = avgTimerWriteNormal;
    }

    public Long getMaxTimerWriteNormal() {
        return maxTimerWriteNormal;
    }

    public void setMaxTimerWriteNormal(Long maxTimerWriteNormal) {
        this.maxTimerWriteNormal = maxTimerWriteNormal;
    }

    public Long getCountWriteExternal() {
        return countWriteExternal;
    }

    public void setCountWriteExternal(Long countWriteExternal) {
        this.countWriteExternal = countWriteExternal;
    }

    public Long getSumTimerWriteExternal() {
        return sumTimerWriteExternal;
    }

    public void setSumTimerWriteExternal(Long sumTimerWriteExternal) {
        this.sumTimerWriteExternal = sumTimerWriteExternal;
    }

    public Long getMinTimerWriteExternal() {
        return minTimerWriteExternal;
    }

    public void setMinTimerWriteExternal(Long minTimerWriteExternal) {
        this.minTimerWriteExternal = minTimerWriteExternal;
    }

    public Long getAvgTimerWriteExternal() {
        return avgTimerWriteExternal;
    }

    public void setAvgTimerWriteExternal(Long avgTimerWriteExternal) {
        this.avgTimerWriteExternal = avgTimerWriteExternal;
    }

    public Long getMaxTimerWriteExternal() {
        return maxTimerWriteExternal;
    }

    public void setMaxTimerWriteExternal(Long maxTimerWriteExternal) {
        this.maxTimerWriteExternal = maxTimerWriteExternal;
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
        sb.append(", countReadNormal=").append(countReadNormal);
        sb.append(", sumTimerReadNormal=").append(sumTimerReadNormal);
        sb.append(", minTimerReadNormal=").append(minTimerReadNormal);
        sb.append(", avgTimerReadNormal=").append(avgTimerReadNormal);
        sb.append(", maxTimerReadNormal=").append(maxTimerReadNormal);
        sb.append(", countReadWithSharedLocks=").append(countReadWithSharedLocks);
        sb.append(", sumTimerReadWithSharedLocks=").append(sumTimerReadWithSharedLocks);
        sb.append(", minTimerReadWithSharedLocks=").append(minTimerReadWithSharedLocks);
        sb.append(", avgTimerReadWithSharedLocks=").append(avgTimerReadWithSharedLocks);
        sb.append(", maxTimerReadWithSharedLocks=").append(maxTimerReadWithSharedLocks);
        sb.append(", countReadHighPriority=").append(countReadHighPriority);
        sb.append(", sumTimerReadHighPriority=").append(sumTimerReadHighPriority);
        sb.append(", minTimerReadHighPriority=").append(minTimerReadHighPriority);
        sb.append(", avgTimerReadHighPriority=").append(avgTimerReadHighPriority);
        sb.append(", maxTimerReadHighPriority=").append(maxTimerReadHighPriority);
        sb.append(", countReadNoInsert=").append(countReadNoInsert);
        sb.append(", sumTimerReadNoInsert=").append(sumTimerReadNoInsert);
        sb.append(", minTimerReadNoInsert=").append(minTimerReadNoInsert);
        sb.append(", avgTimerReadNoInsert=").append(avgTimerReadNoInsert);
        sb.append(", maxTimerReadNoInsert=").append(maxTimerReadNoInsert);
        sb.append(", countReadExternal=").append(countReadExternal);
        sb.append(", sumTimerReadExternal=").append(sumTimerReadExternal);
        sb.append(", minTimerReadExternal=").append(minTimerReadExternal);
        sb.append(", avgTimerReadExternal=").append(avgTimerReadExternal);
        sb.append(", maxTimerReadExternal=").append(maxTimerReadExternal);
        sb.append(", countWriteAllowWrite=").append(countWriteAllowWrite);
        sb.append(", sumTimerWriteAllowWrite=").append(sumTimerWriteAllowWrite);
        sb.append(", minTimerWriteAllowWrite=").append(minTimerWriteAllowWrite);
        sb.append(", avgTimerWriteAllowWrite=").append(avgTimerWriteAllowWrite);
        sb.append(", maxTimerWriteAllowWrite=").append(maxTimerWriteAllowWrite);
        sb.append(", countWriteConcurrentInsert=").append(countWriteConcurrentInsert);
        sb.append(", sumTimerWriteConcurrentInsert=").append(sumTimerWriteConcurrentInsert);
        sb.append(", minTimerWriteConcurrentInsert=").append(minTimerWriteConcurrentInsert);
        sb.append(", avgTimerWriteConcurrentInsert=").append(avgTimerWriteConcurrentInsert);
        sb.append(", maxTimerWriteConcurrentInsert=").append(maxTimerWriteConcurrentInsert);
        sb.append(", countWriteLowPriority=").append(countWriteLowPriority);
        sb.append(", sumTimerWriteLowPriority=").append(sumTimerWriteLowPriority);
        sb.append(", minTimerWriteLowPriority=").append(minTimerWriteLowPriority);
        sb.append(", avgTimerWriteLowPriority=").append(avgTimerWriteLowPriority);
        sb.append(", maxTimerWriteLowPriority=").append(maxTimerWriteLowPriority);
        sb.append(", countWriteNormal=").append(countWriteNormal);
        sb.append(", sumTimerWriteNormal=").append(sumTimerWriteNormal);
        sb.append(", minTimerWriteNormal=").append(minTimerWriteNormal);
        sb.append(", avgTimerWriteNormal=").append(avgTimerWriteNormal);
        sb.append(", maxTimerWriteNormal=").append(maxTimerWriteNormal);
        sb.append(", countWriteExternal=").append(countWriteExternal);
        sb.append(", sumTimerWriteExternal=").append(sumTimerWriteExternal);
        sb.append(", minTimerWriteExternal=").append(minTimerWriteExternal);
        sb.append(", avgTimerWriteExternal=").append(avgTimerWriteExternal);
        sb.append(", maxTimerWriteExternal=").append(maxTimerWriteExternal);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}