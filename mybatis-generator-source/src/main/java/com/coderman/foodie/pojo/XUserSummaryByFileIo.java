package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class XUserSummaryByFileIo implements Serializable {
    private String user;

    private BigDecimal ios;

    private BigDecimal ioLatency;

    private static final long serialVersionUID = 1L;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public BigDecimal getIos() {
        return ios;
    }

    public void setIos(BigDecimal ios) {
        this.ios = ios;
    }

    public BigDecimal getIoLatency() {
        return ioLatency;
    }

    public void setIoLatency(BigDecimal ioLatency) {
        this.ioLatency = ioLatency;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", user=").append(user);
        sb.append(", ios=").append(ios);
        sb.append(", ioLatency=").append(ioLatency);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}