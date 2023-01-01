package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class BinaryLogTransactionCompressionStats implements Serializable {
    private String logType;

    private String compressionType;

    private Long transactionCounter;

    private Long compressedBytesCounter;

    private Long uncompressedBytesCounter;

    private Short compressionPercentage;

    private Long firstTransactionCompressedBytes;

    private Long firstTransactionUncompressedBytes;

    private Date firstTransactionTimestamp;

    private Long lastTransactionCompressedBytes;

    private Long lastTransactionUncompressedBytes;

    private Date lastTransactionTimestamp;

    private String firstTransactionId;

    private String lastTransactionId;

    private static final long serialVersionUID = 1L;

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    public String getCompressionType() {
        return compressionType;
    }

    public void setCompressionType(String compressionType) {
        this.compressionType = compressionType == null ? null : compressionType.trim();
    }

    public Long getTransactionCounter() {
        return transactionCounter;
    }

    public void setTransactionCounter(Long transactionCounter) {
        this.transactionCounter = transactionCounter;
    }

    public Long getCompressedBytesCounter() {
        return compressedBytesCounter;
    }

    public void setCompressedBytesCounter(Long compressedBytesCounter) {
        this.compressedBytesCounter = compressedBytesCounter;
    }

    public Long getUncompressedBytesCounter() {
        return uncompressedBytesCounter;
    }

    public void setUncompressedBytesCounter(Long uncompressedBytesCounter) {
        this.uncompressedBytesCounter = uncompressedBytesCounter;
    }

    public Short getCompressionPercentage() {
        return compressionPercentage;
    }

    public void setCompressionPercentage(Short compressionPercentage) {
        this.compressionPercentage = compressionPercentage;
    }

    public Long getFirstTransactionCompressedBytes() {
        return firstTransactionCompressedBytes;
    }

    public void setFirstTransactionCompressedBytes(Long firstTransactionCompressedBytes) {
        this.firstTransactionCompressedBytes = firstTransactionCompressedBytes;
    }

    public Long getFirstTransactionUncompressedBytes() {
        return firstTransactionUncompressedBytes;
    }

    public void setFirstTransactionUncompressedBytes(Long firstTransactionUncompressedBytes) {
        this.firstTransactionUncompressedBytes = firstTransactionUncompressedBytes;
    }

    public Date getFirstTransactionTimestamp() {
        return firstTransactionTimestamp;
    }

    public void setFirstTransactionTimestamp(Date firstTransactionTimestamp) {
        this.firstTransactionTimestamp = firstTransactionTimestamp;
    }

    public Long getLastTransactionCompressedBytes() {
        return lastTransactionCompressedBytes;
    }

    public void setLastTransactionCompressedBytes(Long lastTransactionCompressedBytes) {
        this.lastTransactionCompressedBytes = lastTransactionCompressedBytes;
    }

    public Long getLastTransactionUncompressedBytes() {
        return lastTransactionUncompressedBytes;
    }

    public void setLastTransactionUncompressedBytes(Long lastTransactionUncompressedBytes) {
        this.lastTransactionUncompressedBytes = lastTransactionUncompressedBytes;
    }

    public Date getLastTransactionTimestamp() {
        return lastTransactionTimestamp;
    }

    public void setLastTransactionTimestamp(Date lastTransactionTimestamp) {
        this.lastTransactionTimestamp = lastTransactionTimestamp;
    }

    public String getFirstTransactionId() {
        return firstTransactionId;
    }

    public void setFirstTransactionId(String firstTransactionId) {
        this.firstTransactionId = firstTransactionId == null ? null : firstTransactionId.trim();
    }

    public String getLastTransactionId() {
        return lastTransactionId;
    }

    public void setLastTransactionId(String lastTransactionId) {
        this.lastTransactionId = lastTransactionId == null ? null : lastTransactionId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", logType=").append(logType);
        sb.append(", compressionType=").append(compressionType);
        sb.append(", transactionCounter=").append(transactionCounter);
        sb.append(", compressedBytesCounter=").append(compressedBytesCounter);
        sb.append(", uncompressedBytesCounter=").append(uncompressedBytesCounter);
        sb.append(", compressionPercentage=").append(compressionPercentage);
        sb.append(", firstTransactionCompressedBytes=").append(firstTransactionCompressedBytes);
        sb.append(", firstTransactionUncompressedBytes=").append(firstTransactionUncompressedBytes);
        sb.append(", firstTransactionTimestamp=").append(firstTransactionTimestamp);
        sb.append(", lastTransactionCompressedBytes=").append(lastTransactionCompressedBytes);
        sb.append(", lastTransactionUncompressedBytes=").append(lastTransactionUncompressedBytes);
        sb.append(", lastTransactionTimestamp=").append(lastTransactionTimestamp);
        sb.append(", firstTransactionId=").append(firstTransactionId);
        sb.append(", lastTransactionId=").append(lastTransactionId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}