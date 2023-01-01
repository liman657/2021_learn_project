package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class EventsStatementsSummaryByDigest implements Serializable {
    private String schemaName;

    private String digest;

    private Long countStar;

    private Long sumTimerWait;

    private Long minTimerWait;

    private Long avgTimerWait;

    private Long maxTimerWait;

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

    private Date firstSeen;

    private Date lastSeen;

    private Long quantile95;

    private Long quantile99;

    private Long quantile999;

    private Date querySampleSeen;

    private Long querySampleTimerWait;

    private String digestText;

    private String querySampleText;

    private static final long serialVersionUID = 1L;

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName == null ? null : schemaName.trim();
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest == null ? null : digest.trim();
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

    public Date getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(Date firstSeen) {
        this.firstSeen = firstSeen;
    }

    public Date getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }

    public Long getQuantile95() {
        return quantile95;
    }

    public void setQuantile95(Long quantile95) {
        this.quantile95 = quantile95;
    }

    public Long getQuantile99() {
        return quantile99;
    }

    public void setQuantile99(Long quantile99) {
        this.quantile99 = quantile99;
    }

    public Long getQuantile999() {
        return quantile999;
    }

    public void setQuantile999(Long quantile999) {
        this.quantile999 = quantile999;
    }

    public Date getQuerySampleSeen() {
        return querySampleSeen;
    }

    public void setQuerySampleSeen(Date querySampleSeen) {
        this.querySampleSeen = querySampleSeen;
    }

    public Long getQuerySampleTimerWait() {
        return querySampleTimerWait;
    }

    public void setQuerySampleTimerWait(Long querySampleTimerWait) {
        this.querySampleTimerWait = querySampleTimerWait;
    }

    public String getDigestText() {
        return digestText;
    }

    public void setDigestText(String digestText) {
        this.digestText = digestText == null ? null : digestText.trim();
    }

    public String getQuerySampleText() {
        return querySampleText;
    }

    public void setQuerySampleText(String querySampleText) {
        this.querySampleText = querySampleText == null ? null : querySampleText.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", schemaName=").append(schemaName);
        sb.append(", digest=").append(digest);
        sb.append(", countStar=").append(countStar);
        sb.append(", sumTimerWait=").append(sumTimerWait);
        sb.append(", minTimerWait=").append(minTimerWait);
        sb.append(", avgTimerWait=").append(avgTimerWait);
        sb.append(", maxTimerWait=").append(maxTimerWait);
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
        sb.append(", firstSeen=").append(firstSeen);
        sb.append(", lastSeen=").append(lastSeen);
        sb.append(", quantile95=").append(quantile95);
        sb.append(", quantile99=").append(quantile99);
        sb.append(", quantile999=").append(quantile999);
        sb.append(", querySampleSeen=").append(querySampleSeen);
        sb.append(", querySampleTimerWait=").append(querySampleTimerWait);
        sb.append(", digestText=").append(digestText);
        sb.append(", querySampleText=").append(querySampleText);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}