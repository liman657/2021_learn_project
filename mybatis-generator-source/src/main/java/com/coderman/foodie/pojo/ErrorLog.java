package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class ErrorLog implements Serializable {
    private Date logged;

    private Long threadId;

    private String prio;

    private String errorCode;

    private String subsystem;

    private String data;

    private static final long serialVersionUID = 1L;

    public Date getLogged() {
        return logged;
    }

    public void setLogged(Date logged) {
        this.logged = logged;
    }

    public Long getThreadId() {
        return threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    public String getPrio() {
        return prio;
    }

    public void setPrio(String prio) {
        this.prio = prio == null ? null : prio.trim();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode == null ? null : errorCode.trim();
    }

    public String getSubsystem() {
        return subsystem;
    }

    public void setSubsystem(String subsystem) {
        this.subsystem = subsystem == null ? null : subsystem.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", logged=").append(logged);
        sb.append(", threadId=").append(threadId);
        sb.append(", prio=").append(prio);
        sb.append(", errorCode=").append(errorCode);
        sb.append(", subsystem=").append(subsystem);
        sb.append(", data=").append(data);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}