package com.coderman.foodie.pojo;

import java.io.Serializable;

public class EventsStatementsHistogramGlobal implements Serializable {
    private Integer bucketNumber;

    private Long bucketTimerLow;

    private Long bucketTimerHigh;

    private Long countBucket;

    private Long countBucketAndLower;

    private Double bucketQuantile;

    private static final long serialVersionUID = 1L;

    public Integer getBucketNumber() {
        return bucketNumber;
    }

    public void setBucketNumber(Integer bucketNumber) {
        this.bucketNumber = bucketNumber;
    }

    public Long getBucketTimerLow() {
        return bucketTimerLow;
    }

    public void setBucketTimerLow(Long bucketTimerLow) {
        this.bucketTimerLow = bucketTimerLow;
    }

    public Long getBucketTimerHigh() {
        return bucketTimerHigh;
    }

    public void setBucketTimerHigh(Long bucketTimerHigh) {
        this.bucketTimerHigh = bucketTimerHigh;
    }

    public Long getCountBucket() {
        return countBucket;
    }

    public void setCountBucket(Long countBucket) {
        this.countBucket = countBucket;
    }

    public Long getCountBucketAndLower() {
        return countBucketAndLower;
    }

    public void setCountBucketAndLower(Long countBucketAndLower) {
        this.countBucketAndLower = countBucketAndLower;
    }

    public Double getBucketQuantile() {
        return bucketQuantile;
    }

    public void setBucketQuantile(Double bucketQuantile) {
        this.bucketQuantile = bucketQuantile;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bucketNumber=").append(bucketNumber);
        sb.append(", bucketTimerLow=").append(bucketTimerLow);
        sb.append(", bucketTimerHigh=").append(bucketTimerHigh);
        sb.append(", countBucket=").append(countBucket);
        sb.append(", countBucketAndLower=").append(countBucketAndLower);
        sb.append(", bucketQuantile=").append(bucketQuantile);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}