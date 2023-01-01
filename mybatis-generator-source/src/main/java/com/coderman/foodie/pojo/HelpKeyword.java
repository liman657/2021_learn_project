package com.coderman.foodie.pojo;

import java.io.Serializable;

public class HelpKeyword implements Serializable {
    private Integer helpKeywordId;

    private String name;

    private static final long serialVersionUID = 1L;

    public Integer getHelpKeywordId() {
        return helpKeywordId;
    }

    public void setHelpKeywordId(Integer helpKeywordId) {
        this.helpKeywordId = helpKeywordId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", helpKeywordId=").append(helpKeywordId);
        sb.append(", name=").append(name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}