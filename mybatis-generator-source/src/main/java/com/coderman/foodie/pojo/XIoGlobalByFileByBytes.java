package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class XIoGlobalByFileByBytes implements Serializable {
    private String file;

    private Long countRead;

    private Long totalRead;

    private BigDecimal avgRead;

    private Long countWrite;

    private Long totalWritten;

    private BigDecimal avgWrite;

    private Long total;

    private BigDecimal writePct;

    private static final long serialVersionUID = 1L;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    public Long getCountRead() {
        return countRead;
    }

    public void setCountRead(Long countRead) {
        this.countRead = countRead;
    }

    public Long getTotalRead() {
        return totalRead;
    }

    public void setTotalRead(Long totalRead) {
        this.totalRead = totalRead;
    }

    public BigDecimal getAvgRead() {
        return avgRead;
    }

    public void setAvgRead(BigDecimal avgRead) {
        this.avgRead = avgRead;
    }

    public Long getCountWrite() {
        return countWrite;
    }

    public void setCountWrite(Long countWrite) {
        this.countWrite = countWrite;
    }

    public Long getTotalWritten() {
        return totalWritten;
    }

    public void setTotalWritten(Long totalWritten) {
        this.totalWritten = totalWritten;
    }

    public BigDecimal getAvgWrite() {
        return avgWrite;
    }

    public void setAvgWrite(BigDecimal avgWrite) {
        this.avgWrite = avgWrite;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public BigDecimal getWritePct() {
        return writePct;
    }

    public void setWritePct(BigDecimal writePct) {
        this.writePct = writePct;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", file=").append(file);
        sb.append(", countRead=").append(countRead);
        sb.append(", totalRead=").append(totalRead);
        sb.append(", avgRead=").append(avgRead);
        sb.append(", countWrite=").append(countWrite);
        sb.append(", totalWritten=").append(totalWritten);
        sb.append(", avgWrite=").append(avgWrite);
        sb.append(", total=").append(total);
        sb.append(", writePct=").append(writePct);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}