package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class GeneralLog implements Serializable {
    private Date eventTime;

    private Long threadId;

    private Integer serverId;

    private String commandType;

    private String userHost;

    private byte[] argument;

    private static final long serialVersionUID = 1L;

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public Long getThreadId() {
        return threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public String getCommandType() {
        return commandType;
    }

    public void setCommandType(String commandType) {
        this.commandType = commandType == null ? null : commandType.trim();
    }

    public String getUserHost() {
        return userHost;
    }

    public void setUserHost(String userHost) {
        this.userHost = userHost == null ? null : userHost.trim();
    }

    public byte[] getArgument() {
        return argument;
    }

    public void setArgument(byte[] argument) {
        this.argument = argument;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eventTime=").append(eventTime);
        sb.append(", threadId=").append(threadId);
        sb.append(", serverId=").append(serverId);
        sb.append(", commandType=").append(commandType);
        sb.append(", userHost=").append(userHost);
        sb.append(", argument=").append(argument);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}