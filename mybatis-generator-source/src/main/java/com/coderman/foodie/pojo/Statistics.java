package com.coderman.foodie.pojo;

import java.io.Serializable;

public class Statistics implements Serializable {
    private String tableCatalog;

    private String tableSchema;

    private String tableName;

    private Integer nonUnique;

    private String indexSchema;

    private String indexName;

    private Integer seqInIndex;

    private String columnName;

    private String collation;

    private Long cardinality;

    private Long subPart;

    private String nullable;

    private String indexType;

    private String comment;

    private String indexComment;

    private String isVisible;

    private byte[] packed;

    private String expression;

    private static final long serialVersionUID = 1L;

    public String getTableCatalog() {
        return tableCatalog;
    }

    public void setTableCatalog(String tableCatalog) {
        this.tableCatalog = tableCatalog == null ? null : tableCatalog.trim();
    }

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema == null ? null : tableSchema.trim();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public Integer getNonUnique() {
        return nonUnique;
    }

    public void setNonUnique(Integer nonUnique) {
        this.nonUnique = nonUnique;
    }

    public String getIndexSchema() {
        return indexSchema;
    }

    public void setIndexSchema(String indexSchema) {
        this.indexSchema = indexSchema == null ? null : indexSchema.trim();
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName == null ? null : indexName.trim();
    }

    public Integer getSeqInIndex() {
        return seqInIndex;
    }

    public void setSeqInIndex(Integer seqInIndex) {
        this.seqInIndex = seqInIndex;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    public String getCollation() {
        return collation;
    }

    public void setCollation(String collation) {
        this.collation = collation == null ? null : collation.trim();
    }

    public Long getCardinality() {
        return cardinality;
    }

    public void setCardinality(Long cardinality) {
        this.cardinality = cardinality;
    }

    public Long getSubPart() {
        return subPart;
    }

    public void setSubPart(Long subPart) {
        this.subPart = subPart;
    }

    public String getNullable() {
        return nullable;
    }

    public void setNullable(String nullable) {
        this.nullable = nullable == null ? null : nullable.trim();
    }

    public String getIndexType() {
        return indexType;
    }

    public void setIndexType(String indexType) {
        this.indexType = indexType == null ? null : indexType.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getIndexComment() {
        return indexComment;
    }

    public void setIndexComment(String indexComment) {
        this.indexComment = indexComment == null ? null : indexComment.trim();
    }

    public String getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(String isVisible) {
        this.isVisible = isVisible == null ? null : isVisible.trim();
    }

    public byte[] getPacked() {
        return packed;
    }

    public void setPacked(byte[] packed) {
        this.packed = packed;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression == null ? null : expression.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tableCatalog=").append(tableCatalog);
        sb.append(", tableSchema=").append(tableSchema);
        sb.append(", tableName=").append(tableName);
        sb.append(", nonUnique=").append(nonUnique);
        sb.append(", indexSchema=").append(indexSchema);
        sb.append(", indexName=").append(indexName);
        sb.append(", seqInIndex=").append(seqInIndex);
        sb.append(", columnName=").append(columnName);
        sb.append(", collation=").append(collation);
        sb.append(", cardinality=").append(cardinality);
        sb.append(", subPart=").append(subPart);
        sb.append(", nullable=").append(nullable);
        sb.append(", indexType=").append(indexType);
        sb.append(", comment=").append(comment);
        sb.append(", indexComment=").append(indexComment);
        sb.append(", isVisible=").append(isVisible);
        sb.append(", packed=").append(packed);
        sb.append(", expression=").append(expression);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}