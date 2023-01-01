package com.coderman.foodie.pojo;

import java.io.Serializable;

public class HelpRelation implements Serializable {
    private Integer helpKeywordId;

    private Integer helpTopicId;

    private static final long serialVersionUID = 1L;

    public Integer getHelpKeywordId() {
        return helpKeywordId;
    }

    public void setHelpKeywordId(Integer helpKeywordId) {
        this.helpKeywordId = helpKeywordId;
    }

    public Integer getHelpTopicId() {
        return helpTopicId;
    }

    public void setHelpTopicId(Integer helpTopicId) {
        this.helpTopicId = helpTopicId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", helpKeywordId=").append(helpKeywordId);
        sb.append(", helpTopicId=").append(helpTopicId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}