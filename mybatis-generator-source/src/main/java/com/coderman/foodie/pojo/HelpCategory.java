package com.coderman.foodie.pojo;

import java.io.Serializable;

public class HelpCategory implements Serializable {
    private Short helpCategoryId;

    private String name;

    private Short parentCategoryId;

    private String url;

    private static final long serialVersionUID = 1L;

    public Short getHelpCategoryId() {
        return helpCategoryId;
    }

    public void setHelpCategoryId(Short helpCategoryId) {
        this.helpCategoryId = helpCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Short parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", helpCategoryId=").append(helpCategoryId);
        sb.append(", name=").append(name);
        sb.append(", parentCategoryId=").append(parentCategoryId);
        sb.append(", url=").append(url);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}