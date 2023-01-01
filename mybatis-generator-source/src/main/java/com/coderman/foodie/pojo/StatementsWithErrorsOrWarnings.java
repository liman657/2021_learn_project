package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class StatementsWithErrorsOrWarnings implements Serializable {
    private String db;

    private Long execCount;

    private Long errors;

    private BigDecimal errorPct;

    private Long warnings;

    private BigDecimal warningPct;

    private Date firstSeen;

    private Date lastSeen;

    private String digest;

    private String query;

    private static final long serialVersionUID = 1L;

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db == null ? null : db.trim();
    }

    public Long getExecCount() {
        return execCount;
    }

    public void setExecCount(Long execCount) {
        this.execCount = execCount;
    }

    public Long getErrors() {
        return errors;
    }

    public void setErrors(Long errors) {
        this.errors = errors;
    }

    public BigDecimal getErrorPct() {
        return errorPct;
    }

    public void setErrorPct(BigDecimal errorPct) {
        this.errorPct = errorPct;
    }

    public Long getWarnings() {
        return warnings;
    }

    public void setWarnings(Long warnings) {
        this.warnings = warnings;
    }

    public BigDecimal getWarningPct() {
        return warningPct;
    }

    public void setWarningPct(BigDecimal warningPct) {
        this.warningPct = warningPct;
    }

    public Date getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(Date firstSeen) {
        this.firstSeen = firstSeen;
    }

    public Date getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest == null ? null : digest.trim();
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query == null ? null : query.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", db=").append(db);
        sb.append(", execCount=").append(execCount);
        sb.append(", errors=").append(errors);
        sb.append(", errorPct=").append(errorPct);
        sb.append(", warnings=").append(warnings);
        sb.append(", warningPct=").append(warningPct);
        sb.append(", firstSeen=").append(firstSeen);
        sb.append(", lastSeen=").append(lastSeen);
        sb.append(", digest=").append(digest);
        sb.append(", query=").append(query);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}