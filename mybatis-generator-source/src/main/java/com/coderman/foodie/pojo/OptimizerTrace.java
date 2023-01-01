package com.coderman.foodie.pojo;

import java.io.Serializable;

public class OptimizerTrace implements Serializable {
    private String query;

    private String trace;

    private Integer missingBytesBeyondMaxMemSize;

    private Boolean insufficientPrivileges;

    private static final long serialVersionUID = 1L;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query == null ? null : query.trim();
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace == null ? null : trace.trim();
    }

    public Integer getMissingBytesBeyondMaxMemSize() {
        return missingBytesBeyondMaxMemSize;
    }

    public void setMissingBytesBeyondMaxMemSize(Integer missingBytesBeyondMaxMemSize) {
        this.missingBytesBeyondMaxMemSize = missingBytesBeyondMaxMemSize;
    }

    public Boolean getInsufficientPrivileges() {
        return insufficientPrivileges;
    }

    public void setInsufficientPrivileges(Boolean insufficientPrivileges) {
        this.insufficientPrivileges = insufficientPrivileges;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", query=").append(query);
        sb.append(", trace=").append(trace);
        sb.append(", missingBytesBeyondMaxMemSize=").append(missingBytesBeyondMaxMemSize);
        sb.append(", insufficientPrivileges=").append(insufficientPrivileges);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}