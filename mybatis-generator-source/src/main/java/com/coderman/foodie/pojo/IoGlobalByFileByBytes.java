package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class IoGlobalByFileByBytes implements Serializable {
    private String file;

    private Long countRead;

    private String totalRead;

    private String avgRead;

    private Long countWrite;

    private String totalWritten;

    private String avgWrite;

    private String total;

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

    public String getTotalRead() {
        return totalRead;
    }

    public void setTotalRead(String totalRead) {
        this.totalRead = totalRead == null ? null : totalRead.trim();
    }

    public String getAvgRead() {
        return avgRead;
    }

    public void setAvgRead(String avgRead) {
        this.avgRead = avgRead == null ? null : avgRead.trim();
    }

    public Long getCountWrite() {
        return countWrite;
    }

    public void setCountWrite(Long countWrite) {
        this.countWrite = countWrite;
    }

    public String getTotalWritten() {
        return totalWritten;
    }

    public void setTotalWritten(String totalWritten) {
        this.totalWritten = totalWritten == null ? null : totalWritten.trim();
    }

    public String getAvgWrite() {
        return avgWrite;
    }

    public void setAvgWrite(String avgWrite) {
        this.avgWrite = avgWrite == null ? null : avgWrite.trim();
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total == null ? null : total.trim();
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