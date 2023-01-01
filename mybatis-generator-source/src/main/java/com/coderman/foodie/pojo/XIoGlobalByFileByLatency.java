package com.coderman.foodie.pojo;

import java.io.Serializable;

public class XIoGlobalByFileByLatency implements Serializable {
    private String file;

    private Long total;

    private Long totalLatency;

    private Long countRead;

    private Long readLatency;

    private Long countWrite;

    private Long writeLatency;

    private Long countMisc;

    private Long miscLatency;

    private static final long serialVersionUID = 1L;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
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

    public Long getCountRead() {
        return countRead;
    }

    public void setCountRead(Long countRead) {
        this.countRead = countRead;
    }

    public Long getReadLatency() {
        return readLatency;
    }

    public void setReadLatency(Long readLatency) {
        this.readLatency = readLatency;
    }

    public Long getCountWrite() {
        return countWrite;
    }

    public void setCountWrite(Long countWrite) {
        this.countWrite = countWrite;
    }

    public Long getWriteLatency() {
        return writeLatency;
    }

    public void setWriteLatency(Long writeLatency) {
        this.writeLatency = writeLatency;
    }

    public Long getCountMisc() {
        return countMisc;
    }

    public void setCountMisc(Long countMisc) {
        this.countMisc = countMisc;
    }

    public Long getMiscLatency() {
        return miscLatency;
    }

    public void setMiscLatency(Long miscLatency) {
        this.miscLatency = miscLatency;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", file=").append(file);
        sb.append(", total=").append(total);
        sb.append(", totalLatency=").append(totalLatency);
        sb.append(", countRead=").append(countRead);
        sb.append(", readLatency=").append(readLatency);
        sb.append(", countWrite=").append(countWrite);
        sb.append(", writeLatency=").append(writeLatency);
        sb.append(", countMisc=").append(countMisc);
        sb.append(", miscLatency=").append(miscLatency);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}