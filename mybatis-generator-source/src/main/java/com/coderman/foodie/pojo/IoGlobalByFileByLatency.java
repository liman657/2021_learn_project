package com.coderman.foodie.pojo;

import java.io.Serializable;

public class IoGlobalByFileByLatency implements Serializable {
    private String file;

    private Long total;

    private String totalLatency;

    private Long countRead;

    private String readLatency;

    private Long countWrite;

    private String writeLatency;

    private Long countMisc;

    private String miscLatency;

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

    public String getTotalLatency() {
        return totalLatency;
    }

    public void setTotalLatency(String totalLatency) {
        this.totalLatency = totalLatency == null ? null : totalLatency.trim();
    }

    public Long getCountRead() {
        return countRead;
    }

    public void setCountRead(Long countRead) {
        this.countRead = countRead;
    }

    public String getReadLatency() {
        return readLatency;
    }

    public void setReadLatency(String readLatency) {
        this.readLatency = readLatency == null ? null : readLatency.trim();
    }

    public Long getCountWrite() {
        return countWrite;
    }

    public void setCountWrite(Long countWrite) {
        this.countWrite = countWrite;
    }

    public String getWriteLatency() {
        return writeLatency;
    }

    public void setWriteLatency(String writeLatency) {
        this.writeLatency = writeLatency == null ? null : writeLatency.trim();
    }

    public Long getCountMisc() {
        return countMisc;
    }

    public void setCountMisc(Long countMisc) {
        this.countMisc = countMisc;
    }

    public String getMiscLatency() {
        return miscLatency;
    }

    public void setMiscLatency(String miscLatency) {
        this.miscLatency = miscLatency == null ? null : miscLatency.trim();
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