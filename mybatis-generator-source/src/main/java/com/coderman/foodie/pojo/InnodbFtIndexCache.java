package com.coderman.foodie.pojo;

import java.io.Serializable;

public class InnodbFtIndexCache implements Serializable {
    private String word;

    private Long firstDocId;

    private Long lastDocId;

    private Long docCount;

    private Long docId;

    private Long position;

    private static final long serialVersionUID = 1L;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word == null ? null : word.trim();
    }

    public Long getFirstDocId() {
        return firstDocId;
    }

    public void setFirstDocId(Long firstDocId) {
        this.firstDocId = firstDocId;
    }

    public Long getLastDocId() {
        return lastDocId;
    }

    public void setLastDocId(Long lastDocId) {
        this.lastDocId = lastDocId;
    }

    public Long getDocCount() {
        return docCount;
    }

    public void setDocCount(Long docCount) {
        this.docCount = docCount;
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", word=").append(word);
        sb.append(", firstDocId=").append(firstDocId);
        sb.append(", lastDocId=").append(lastDocId);
        sb.append(", docCount=").append(docCount);
        sb.append(", docId=").append(docId);
        sb.append(", position=").append(position);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}