package com.coderman.foodie.pojo;

import java.io.Serializable;

public class InnodbBufferPoolStats implements Serializable {
    private Long poolId;

    private Long poolSize;

    private Long freeBuffers;

    private Long databasePages;

    private Long oldDatabasePages;

    private Long modifiedDatabasePages;

    private Long pendingDecompress;

    private Long pendingReads;

    private Long pendingFlushLru;

    private Long pendingFlushList;

    private Long pagesMadeYoung;

    private Long pagesNotMadeYoung;

    private Float pagesMadeYoungRate;

    private Float pagesMadeNotYoungRate;

    private Long numberPagesRead;

    private Long numberPagesCreated;

    private Long numberPagesWritten;

    private Float pagesReadRate;

    private Float pagesCreateRate;

    private Float pagesWrittenRate;

    private Long numberPagesGet;

    private Long hitRate;

    private Long youngMakePerThousandGets;

    private Long notYoungMakePerThousandGets;

    private Long numberPagesReadAhead;

    private Long numberReadAheadEvicted;

    private Float readAheadRate;

    private Float readAheadEvictedRate;

    private Long lruIoTotal;

    private Long lruIoCurrent;

    private Long uncompressTotal;

    private Long uncompressCurrent;

    private static final long serialVersionUID = 1L;

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public Long getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(Long poolSize) {
        this.poolSize = poolSize;
    }

    public Long getFreeBuffers() {
        return freeBuffers;
    }

    public void setFreeBuffers(Long freeBuffers) {
        this.freeBuffers = freeBuffers;
    }

    public Long getDatabasePages() {
        return databasePages;
    }

    public void setDatabasePages(Long databasePages) {
        this.databasePages = databasePages;
    }

    public Long getOldDatabasePages() {
        return oldDatabasePages;
    }

    public void setOldDatabasePages(Long oldDatabasePages) {
        this.oldDatabasePages = oldDatabasePages;
    }

    public Long getModifiedDatabasePages() {
        return modifiedDatabasePages;
    }

    public void setModifiedDatabasePages(Long modifiedDatabasePages) {
        this.modifiedDatabasePages = modifiedDatabasePages;
    }

    public Long getPendingDecompress() {
        return pendingDecompress;
    }

    public void setPendingDecompress(Long pendingDecompress) {
        this.pendingDecompress = pendingDecompress;
    }

    public Long getPendingReads() {
        return pendingReads;
    }

    public void setPendingReads(Long pendingReads) {
        this.pendingReads = pendingReads;
    }

    public Long getPendingFlushLru() {
        return pendingFlushLru;
    }

    public void setPendingFlushLru(Long pendingFlushLru) {
        this.pendingFlushLru = pendingFlushLru;
    }

    public Long getPendingFlushList() {
        return pendingFlushList;
    }

    public void setPendingFlushList(Long pendingFlushList) {
        this.pendingFlushList = pendingFlushList;
    }

    public Long getPagesMadeYoung() {
        return pagesMadeYoung;
    }

    public void setPagesMadeYoung(Long pagesMadeYoung) {
        this.pagesMadeYoung = pagesMadeYoung;
    }

    public Long getPagesNotMadeYoung() {
        return pagesNotMadeYoung;
    }

    public void setPagesNotMadeYoung(Long pagesNotMadeYoung) {
        this.pagesNotMadeYoung = pagesNotMadeYoung;
    }

    public Float getPagesMadeYoungRate() {
        return pagesMadeYoungRate;
    }

    public void setPagesMadeYoungRate(Float pagesMadeYoungRate) {
        this.pagesMadeYoungRate = pagesMadeYoungRate;
    }

    public Float getPagesMadeNotYoungRate() {
        return pagesMadeNotYoungRate;
    }

    public void setPagesMadeNotYoungRate(Float pagesMadeNotYoungRate) {
        this.pagesMadeNotYoungRate = pagesMadeNotYoungRate;
    }

    public Long getNumberPagesRead() {
        return numberPagesRead;
    }

    public void setNumberPagesRead(Long numberPagesRead) {
        this.numberPagesRead = numberPagesRead;
    }

    public Long getNumberPagesCreated() {
        return numberPagesCreated;
    }

    public void setNumberPagesCreated(Long numberPagesCreated) {
        this.numberPagesCreated = numberPagesCreated;
    }

    public Long getNumberPagesWritten() {
        return numberPagesWritten;
    }

    public void setNumberPagesWritten(Long numberPagesWritten) {
        this.numberPagesWritten = numberPagesWritten;
    }

    public Float getPagesReadRate() {
        return pagesReadRate;
    }

    public void setPagesReadRate(Float pagesReadRate) {
        this.pagesReadRate = pagesReadRate;
    }

    public Float getPagesCreateRate() {
        return pagesCreateRate;
    }

    public void setPagesCreateRate(Float pagesCreateRate) {
        this.pagesCreateRate = pagesCreateRate;
    }

    public Float getPagesWrittenRate() {
        return pagesWrittenRate;
    }

    public void setPagesWrittenRate(Float pagesWrittenRate) {
        this.pagesWrittenRate = pagesWrittenRate;
    }

    public Long getNumberPagesGet() {
        return numberPagesGet;
    }

    public void setNumberPagesGet(Long numberPagesGet) {
        this.numberPagesGet = numberPagesGet;
    }

    public Long getHitRate() {
        return hitRate;
    }

    public void setHitRate(Long hitRate) {
        this.hitRate = hitRate;
    }

    public Long getYoungMakePerThousandGets() {
        return youngMakePerThousandGets;
    }

    public void setYoungMakePerThousandGets(Long youngMakePerThousandGets) {
        this.youngMakePerThousandGets = youngMakePerThousandGets;
    }

    public Long getNotYoungMakePerThousandGets() {
        return notYoungMakePerThousandGets;
    }

    public void setNotYoungMakePerThousandGets(Long notYoungMakePerThousandGets) {
        this.notYoungMakePerThousandGets = notYoungMakePerThousandGets;
    }

    public Long getNumberPagesReadAhead() {
        return numberPagesReadAhead;
    }

    public void setNumberPagesReadAhead(Long numberPagesReadAhead) {
        this.numberPagesReadAhead = numberPagesReadAhead;
    }

    public Long getNumberReadAheadEvicted() {
        return numberReadAheadEvicted;
    }

    public void setNumberReadAheadEvicted(Long numberReadAheadEvicted) {
        this.numberReadAheadEvicted = numberReadAheadEvicted;
    }

    public Float getReadAheadRate() {
        return readAheadRate;
    }

    public void setReadAheadRate(Float readAheadRate) {
        this.readAheadRate = readAheadRate;
    }

    public Float getReadAheadEvictedRate() {
        return readAheadEvictedRate;
    }

    public void setReadAheadEvictedRate(Float readAheadEvictedRate) {
        this.readAheadEvictedRate = readAheadEvictedRate;
    }

    public Long getLruIoTotal() {
        return lruIoTotal;
    }

    public void setLruIoTotal(Long lruIoTotal) {
        this.lruIoTotal = lruIoTotal;
    }

    public Long getLruIoCurrent() {
        return lruIoCurrent;
    }

    public void setLruIoCurrent(Long lruIoCurrent) {
        this.lruIoCurrent = lruIoCurrent;
    }

    public Long getUncompressTotal() {
        return uncompressTotal;
    }

    public void setUncompressTotal(Long uncompressTotal) {
        this.uncompressTotal = uncompressTotal;
    }

    public Long getUncompressCurrent() {
        return uncompressCurrent;
    }

    public void setUncompressCurrent(Long uncompressCurrent) {
        this.uncompressCurrent = uncompressCurrent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", poolId=").append(poolId);
        sb.append(", poolSize=").append(poolSize);
        sb.append(", freeBuffers=").append(freeBuffers);
        sb.append(", databasePages=").append(databasePages);
        sb.append(", oldDatabasePages=").append(oldDatabasePages);
        sb.append(", modifiedDatabasePages=").append(modifiedDatabasePages);
        sb.append(", pendingDecompress=").append(pendingDecompress);
        sb.append(", pendingReads=").append(pendingReads);
        sb.append(", pendingFlushLru=").append(pendingFlushLru);
        sb.append(", pendingFlushList=").append(pendingFlushList);
        sb.append(", pagesMadeYoung=").append(pagesMadeYoung);
        sb.append(", pagesNotMadeYoung=").append(pagesNotMadeYoung);
        sb.append(", pagesMadeYoungRate=").append(pagesMadeYoungRate);
        sb.append(", pagesMadeNotYoungRate=").append(pagesMadeNotYoungRate);
        sb.append(", numberPagesRead=").append(numberPagesRead);
        sb.append(", numberPagesCreated=").append(numberPagesCreated);
        sb.append(", numberPagesWritten=").append(numberPagesWritten);
        sb.append(", pagesReadRate=").append(pagesReadRate);
        sb.append(", pagesCreateRate=").append(pagesCreateRate);
        sb.append(", pagesWrittenRate=").append(pagesWrittenRate);
        sb.append(", numberPagesGet=").append(numberPagesGet);
        sb.append(", hitRate=").append(hitRate);
        sb.append(", youngMakePerThousandGets=").append(youngMakePerThousandGets);
        sb.append(", notYoungMakePerThousandGets=").append(notYoungMakePerThousandGets);
        sb.append(", numberPagesReadAhead=").append(numberPagesReadAhead);
        sb.append(", numberReadAheadEvicted=").append(numberReadAheadEvicted);
        sb.append(", readAheadRate=").append(readAheadRate);
        sb.append(", readAheadEvictedRate=").append(readAheadEvictedRate);
        sb.append(", lruIoTotal=").append(lruIoTotal);
        sb.append(", lruIoCurrent=").append(lruIoCurrent);
        sb.append(", uncompressTotal=").append(uncompressTotal);
        sb.append(", uncompressCurrent=").append(uncompressCurrent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}