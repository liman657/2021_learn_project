package com.coderman.foodie.pojo;

import java.io.Serializable;

public class PerformanceTimers implements Serializable {
    private String timerName;

    private Long timerFrequency;

    private Long timerResolution;

    private Long timerOverhead;

    private static final long serialVersionUID = 1L;

    public String getTimerName() {
        return timerName;
    }

    public void setTimerName(String timerName) {
        this.timerName = timerName == null ? null : timerName.trim();
    }

    public Long getTimerFrequency() {
        return timerFrequency;
    }

    public void setTimerFrequency(Long timerFrequency) {
        this.timerFrequency = timerFrequency;
    }

    public Long getTimerResolution() {
        return timerResolution;
    }

    public void setTimerResolution(Long timerResolution) {
        this.timerResolution = timerResolution;
    }

    public Long getTimerOverhead() {
        return timerOverhead;
    }

    public void setTimerOverhead(Long timerOverhead) {
        this.timerOverhead = timerOverhead;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", timerName=").append(timerName);
        sb.append(", timerFrequency=").append(timerFrequency);
        sb.append(", timerResolution=").append(timerResolution);
        sb.append(", timerOverhead=").append(timerOverhead);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}