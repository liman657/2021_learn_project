package com.coderman.foodie.pojo;

import java.io.Serializable;

public class LatestFileIo implements Serializable {
    private String thread;

    private String file;

    private String latency;

    private String operation;

    private String requested;

    private static final long serialVersionUID = 1L;

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread == null ? null : thread.trim();
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    public String getLatency() {
        return latency;
    }

    public void setLatency(String latency) {
        this.latency = latency == null ? null : latency.trim();
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    public String getRequested() {
        return requested;
    }

    public void setRequested(String requested) {
        this.requested = requested == null ? null : requested.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", thread=").append(thread);
        sb.append(", file=").append(file);
        sb.append(", latency=").append(latency);
        sb.append(", operation=").append(operation);
        sb.append(", requested=").append(requested);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}