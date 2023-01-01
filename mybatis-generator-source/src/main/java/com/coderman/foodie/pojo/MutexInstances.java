package com.coderman.foodie.pojo;

import java.io.Serializable;

public class MutexInstances implements Serializable {
    private Long objectInstanceBegin;

    private String name;

    private Long lockedByThreadId;

    private static final long serialVersionUID = 1L;

    public Long getObjectInstanceBegin() {
        return objectInstanceBegin;
    }

    public void setObjectInstanceBegin(Long objectInstanceBegin) {
        this.objectInstanceBegin = objectInstanceBegin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getLockedByThreadId() {
        return lockedByThreadId;
    }

    public void setLockedByThreadId(Long lockedByThreadId) {
        this.lockedByThreadId = lockedByThreadId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", objectInstanceBegin=").append(objectInstanceBegin);
        sb.append(", name=").append(name);
        sb.append(", lockedByThreadId=").append(lockedByThreadId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}