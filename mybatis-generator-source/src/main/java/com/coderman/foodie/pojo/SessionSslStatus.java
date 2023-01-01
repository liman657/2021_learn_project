package com.coderman.foodie.pojo;

import java.io.Serializable;

public class SessionSslStatus implements Serializable {
    private Long threadId;

    private String sslVersion;

    private String sslCipher;

    private String sslSessionsReused;

    private static final long serialVersionUID = 1L;

    public Long getThreadId() {
        return threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    public String getSslVersion() {
        return sslVersion;
    }

    public void setSslVersion(String sslVersion) {
        this.sslVersion = sslVersion == null ? null : sslVersion.trim();
    }

    public String getSslCipher() {
        return sslCipher;
    }

    public void setSslCipher(String sslCipher) {
        this.sslCipher = sslCipher == null ? null : sslCipher.trim();
    }

    public String getSslSessionsReused() {
        return sslSessionsReused;
    }

    public void setSslSessionsReused(String sslSessionsReused) {
        this.sslSessionsReused = sslSessionsReused == null ? null : sslSessionsReused.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", threadId=").append(threadId);
        sb.append(", sslVersion=").append(sslVersion);
        sb.append(", sslCipher=").append(sslCipher);
        sb.append(", sslSessionsReused=").append(sslSessionsReused);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}