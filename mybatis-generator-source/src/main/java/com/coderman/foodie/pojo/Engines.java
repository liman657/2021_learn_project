package com.coderman.foodie.pojo;

import java.io.Serializable;

public class Engines implements Serializable {
    private String engine;

    private String support;

    private String comment;

    private String transactions;

    private String xa;

    private String savepoints;

    private static final long serialVersionUID = 1L;

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine == null ? null : engine.trim();
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support == null ? null : support.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getTransactions() {
        return transactions;
    }

    public void setTransactions(String transactions) {
        this.transactions = transactions == null ? null : transactions.trim();
    }

    public String getXa() {
        return xa;
    }

    public void setXa(String xa) {
        this.xa = xa == null ? null : xa.trim();
    }

    public String getSavepoints() {
        return savepoints;
    }

    public void setSavepoints(String savepoints) {
        this.savepoints = savepoints == null ? null : savepoints.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", engine=").append(engine);
        sb.append(", support=").append(support);
        sb.append(", comment=").append(comment);
        sb.append(", transactions=").append(transactions);
        sb.append(", xa=").append(xa);
        sb.append(", savepoints=").append(savepoints);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}