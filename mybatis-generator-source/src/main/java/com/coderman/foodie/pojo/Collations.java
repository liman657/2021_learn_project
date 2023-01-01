package com.coderman.foodie.pojo;

import java.io.Serializable;

public class Collations implements Serializable {
    private String collationName;

    private String characterSetName;

    private Long id;

    private String isDefault;

    private String isCompiled;

    private Integer sortlen;

    private String padAttribute;

    private static final long serialVersionUID = 1L;

    public String getCollationName() {
        return collationName;
    }

    public void setCollationName(String collationName) {
        this.collationName = collationName == null ? null : collationName.trim();
    }

    public String getCharacterSetName() {
        return characterSetName;
    }

    public void setCharacterSetName(String characterSetName) {
        this.characterSetName = characterSetName == null ? null : characterSetName.trim();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }

    public String getIsCompiled() {
        return isCompiled;
    }

    public void setIsCompiled(String isCompiled) {
        this.isCompiled = isCompiled == null ? null : isCompiled.trim();
    }

    public Integer getSortlen() {
        return sortlen;
    }

    public void setSortlen(Integer sortlen) {
        this.sortlen = sortlen;
    }

    public String getPadAttribute() {
        return padAttribute;
    }

    public void setPadAttribute(String padAttribute) {
        this.padAttribute = padAttribute == null ? null : padAttribute.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", collationName=").append(collationName);
        sb.append(", characterSetName=").append(characterSetName);
        sb.append(", id=").append(id);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", isCompiled=").append(isCompiled);
        sb.append(", sortlen=").append(sortlen);
        sb.append(", padAttribute=").append(padAttribute);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}