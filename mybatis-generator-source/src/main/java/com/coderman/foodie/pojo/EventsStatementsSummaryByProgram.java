package com.coderman.foodie.pojo;

import java.io.Serializable;

public class EventsStatementsSummaryByProgram implements Serializable {
    private String objectType;

    private String objectSchema;

    private String objectName;

    private Long countStar;

    private Long sumTimerWait;

    private Long minTimerWait;

    private Long avgTimerWait;

    private Long maxTimerWait;

    private Long countStatements;

    private Long sumStatementsWait;

    private Long minStatementsWait;

    private Long avgStatementsWait;

    private Long maxStatementsWait;

    private Long sumLockTime;

    private Long sumErrors;

    private Long sumWarnings;

    private Long sumRowsAffected;

    private Long sumRowsSent;

    private Long sumRowsExamined;

    private Long sumCreatedTmpDiskTables;

    private Long sumCreatedTmpTables;

    private Long sumSelectFullJoin;

    private Long sumSelectFullRangeJoin;

    private Long sumSelectRange;

    private Long sumSelectRangeCheck;

    private Long sumSelectScan;

    private Long sumSortMergePasses;

    private Long sumSortRange;

    private Long sumSortRows;

    private Long sumSortScan;

    private Long sumNoIndexUsed;

    private Long sumNoGoodIndexUsed;

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

    public Long getCountStatements() {
        return countStatements;
    }

    public void setCountStatements(Long countStatements) {
        this.countStatements = countStatements;
    }

    public Long getSumStatementsWait() {
        return sumStatementsWait;
    }

    public void setSumStatementsWait(Long sumStatementsWait) {
        this.sumStatementsWait = sumStatementsWait;
    }

    public Long getMinStatementsWait() {
        return minStatementsWait;
    }

    public void setMinStatementsWait(Long minStatementsWait) {
        this.minStatementsWait = minStatementsWait;
    }

    public Long getAvgStatementsWait() {
        return avgStatementsWait;
    }

    public void setAvgStatementsWait(Long avgStatementsWait) {
        this.avgStatementsWait = avgStatementsWait;
    }

    public Long getMaxStatementsWait() {
        return maxStatementsWait;
    }

    public void setMaxStatementsWait(Long maxStatementsWait) {
        this.maxStatementsWait = maxStatementsWait;
    }

    public Long getSumLockTime() {
        return sumLockTime;
    }

    public void setSumLockTime(Long sumLockTime) {
        this.sumLockTime = sumLockTime;
    }

    public Long getSumErrors() {
        return sumErrors;
    }

    public void setSumErrors(Long sumErrors) {
        this.sumErrors = sumErrors;
    }

    public Long getSumWarnings() {
        return sumWarnings;
    }

    public void setSumWarnings(Long sumWarnings) {
        this.sumWarnings = sumWarnings;
    }

    public Long getSumRowsAffected() {
        return sumRowsAffected;
    }

    public void setSumRowsAffected(Long sumRowsAffected) {
        this.sumRowsAffected = sumRowsAffected;
    }

    public Long getSumRowsSent() {
        return sumRowsSent;
    }

    public void setSumRowsSent(Long sumRowsSent) {
        this.sumRowsSent = sumRowsSent;
    }

    public Long getSumRowsExamined() {
        return sumRowsExamined;
    }

    public void setSumRowsExamined(Long sumRowsExamined) {
        this.sumRowsExamined = sumRowsExamined;
    }

    public Long getSumCreatedTmpDiskTables() {
        return sumCreatedTmpDiskTables;
    }

    public void setSumCreatedTmpDiskTables(Long sumCreatedTmpDiskTables) {
        this.sumCreatedTmpDiskTables = sumCreatedTmpDiskTables;
    }

    public Long getSumCreatedTmpTables() {
        return sumCreatedTmpTables;
    }

    public void setSumCreatedTmpTables(Long sumCreatedTmpTables) {
        this.sumCreatedTmpTables = sumCreatedTmpTables;
    }

    public Long getSumSelectFullJoin() {
        return sumSelectFullJoin;
    }

    public void setSumSelectFullJoin(Long sumSelectFullJoin) {
        this.sumSelectFullJoin = sumSelectFullJoin;
    }

    public Long getSumSelectFullRangeJoin() {
        return sumSelectFullRangeJoin;
    }

    public void setSumSelectFullRangeJoin(Long sumSelectFullRangeJoin) {
        this.sumSelectFullRangeJoin = sumSelectFullRangeJoin;
    }

    public Long getSumSelectRange() {
        return sumSelectRange;
    }

    public void setSumSelectRange(Long sumSelectRange) {
        this.sumSelectRange = sumSelectRange;
    }

    public Long getSumSelectRangeCheck() {
        return sumSelectRangeCheck;
    }

    public void setSumSelectRangeCheck(Long sumSelectRangeCheck) {
        this.sumSelectRangeCheck = sumSelectRangeCheck;
    }

    public Long getSumSelectScan() {
        return sumSelectScan;
    }

    public void setSumSelectScan(Long sumSelectScan) {
        this.sumSelectScan = sumSelectScan;
    }

    public Long getSumSortMergePasses() {
        return sumSortMergePasses;
    }

    public void setSumSortMergePasses(Long sumSortMergePasses) {
        this.sumSortMergePasses = sumSortMergePasses;
    }

    public Long getSumSortRange() {
        return sumSortRange;
    }

    public void setSumSortRange(Long sumSortRange) {
        this.sumSortRange = sumSortRange;
    }

    public Long getSumSortRows() {
        return sumSortRows;
    }

    public void setSumSortRows(Long sumSortRows) {
        this.sumSortRows = sumSortRows;
    }

    public Long getSumSortScan() {
        return sumSortScan;
    }

    public void setSumSortScan(Long sumSortScan) {
        this.sumSortScan = sumSortScan;
    }

    public Long getSumNoIndexUsed() {
        return sumNoIndexUsed;
    }

    public void setSumNoIndexUsed(Long sumNoIndexUsed) {
        this.sumNoIndexUsed = sumNoIndexUsed;
    }

    public Long getSumNoGoodIndexUsed() {
        return sumNoGoodIndexUsed;
    }

    public void setSumNoGoodIndexUsed(Long sumNoGoodIndexUsed) {
        this.sumNoGoodIndexUsed = sumNoGoodIndexUsed;
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
        sb.append(", countStatements=").append(countStatements);
        sb.append(", sumStatementsWait=").append(sumStatementsWait);
        sb.append(", minStatementsWait=").append(minStatementsWait);
        sb.append(", avgStatementsWait=").append(avgStatementsWait);
        sb.append(", maxStatementsWait=").append(maxStatementsWait);
        sb.append(", sumLockTime=").append(sumLockTime);
        sb.append(", sumErrors=").append(sumErrors);
        sb.append(", sumWarnings=").append(sumWarnings);
        sb.append(", sumRowsAffected=").append(sumRowsAffected);
        sb.append(", sumRowsSent=").append(sumRowsSent);
        sb.append(", sumRowsExamined=").append(sumRowsExamined);
        sb.append(", sumCreatedTmpDiskTables=").append(sumCreatedTmpDiskTables);
        sb.append(", sumCreatedTmpTables=").append(sumCreatedTmpTables);
        sb.append(", sumSelectFullJoin=").append(sumSelectFullJoin);
        sb.append(", sumSelectFullRangeJoin=").append(sumSelectFullRangeJoin);
        sb.append(", sumSelectRange=").append(sumSelectRange);
        sb.append(", sumSelectRangeCheck=").append(sumSelectRangeCheck);
        sb.append(", sumSelectScan=").append(sumSelectScan);
        sb.append(", sumSortMergePasses=").append(sumSortMergePasses);
        sb.append(", sumSortRange=").append(sumSortRange);
        sb.append(", sumSortRows=").append(sumSortRows);
        sb.append(", sumSortScan=").append(sumSortScan);
        sb.append(", sumNoIndexUsed=").append(sumNoIndexUsed);
        sb.append(", sumNoGoodIndexUsed=").append(sumNoGoodIndexUsed);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}