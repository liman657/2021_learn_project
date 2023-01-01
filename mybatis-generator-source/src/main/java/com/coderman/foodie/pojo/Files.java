package com.coderman.foodie.pojo;

import java.io.Serializable;

public class Files implements Serializable {
    private Long fileId;

    private String fileType;

    private String tablespaceName;

    private String tableCatalog;

    private String logfileGroupName;

    private Long logfileGroupNumber;

    private String engine;

    private Long freeExtents;

    private Long totalExtents;

    private Long extentSize;

    private Long initialSize;

    private Long maximumSize;

    private Long autoextendSize;

    private Long version;

    private String rowFormat;

    private Long dataFree;

    private String status;

    private String extra;

    private String fileName;

    private byte[] tableSchema;

    private byte[] tableName;

    private byte[] fulltextKeys;

    private byte[] deletedRows;

    private byte[] updateCount;

    private byte[] creationTime;

    private byte[] lastUpdateTime;

    private byte[] lastAccessTime;

    private byte[] recoverTime;

    private byte[] transactionCounter;

    private byte[] tableRows;

    private byte[] avgRowLength;

    private byte[] dataLength;

    private byte[] maxDataLength;

    private byte[] indexLength;

    private byte[] createTime;

    private byte[] updateTime;

    private byte[] checkTime;

    private byte[] checksum;

    private static final long serialVersionUID = 1L;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getTablespaceName() {
        return tablespaceName;
    }

    public void setTablespaceName(String tablespaceName) {
        this.tablespaceName = tablespaceName == null ? null : tablespaceName.trim();
    }

    public String getTableCatalog() {
        return tableCatalog;
    }

    public void setTableCatalog(String tableCatalog) {
        this.tableCatalog = tableCatalog == null ? null : tableCatalog.trim();
    }

    public String getLogfileGroupName() {
        return logfileGroupName;
    }

    public void setLogfileGroupName(String logfileGroupName) {
        this.logfileGroupName = logfileGroupName == null ? null : logfileGroupName.trim();
    }

    public Long getLogfileGroupNumber() {
        return logfileGroupNumber;
    }

    public void setLogfileGroupNumber(Long logfileGroupNumber) {
        this.logfileGroupNumber = logfileGroupNumber;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine == null ? null : engine.trim();
    }

    public Long getFreeExtents() {
        return freeExtents;
    }

    public void setFreeExtents(Long freeExtents) {
        this.freeExtents = freeExtents;
    }

    public Long getTotalExtents() {
        return totalExtents;
    }

    public void setTotalExtents(Long totalExtents) {
        this.totalExtents = totalExtents;
    }

    public Long getExtentSize() {
        return extentSize;
    }

    public void setExtentSize(Long extentSize) {
        this.extentSize = extentSize;
    }

    public Long getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(Long initialSize) {
        this.initialSize = initialSize;
    }

    public Long getMaximumSize() {
        return maximumSize;
    }

    public void setMaximumSize(Long maximumSize) {
        this.maximumSize = maximumSize;
    }

    public Long getAutoextendSize() {
        return autoextendSize;
    }

    public void setAutoextendSize(Long autoextendSize) {
        this.autoextendSize = autoextendSize;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getRowFormat() {
        return rowFormat;
    }

    public void setRowFormat(String rowFormat) {
        this.rowFormat = rowFormat == null ? null : rowFormat.trim();
    }

    public Long getDataFree() {
        return dataFree;
    }

    public void setDataFree(Long dataFree) {
        this.dataFree = dataFree;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra == null ? null : extra.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public byte[] getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(byte[] tableSchema) {
        this.tableSchema = tableSchema;
    }

    public byte[] getTableName() {
        return tableName;
    }

    public void setTableName(byte[] tableName) {
        this.tableName = tableName;
    }

    public byte[] getFulltextKeys() {
        return fulltextKeys;
    }

    public void setFulltextKeys(byte[] fulltextKeys) {
        this.fulltextKeys = fulltextKeys;
    }

    public byte[] getDeletedRows() {
        return deletedRows;
    }

    public void setDeletedRows(byte[] deletedRows) {
        this.deletedRows = deletedRows;
    }

    public byte[] getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(byte[] updateCount) {
        this.updateCount = updateCount;
    }

    public byte[] getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(byte[] creationTime) {
        this.creationTime = creationTime;
    }

    public byte[] getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(byte[] lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public byte[] getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(byte[] lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public byte[] getRecoverTime() {
        return recoverTime;
    }

    public void setRecoverTime(byte[] recoverTime) {
        this.recoverTime = recoverTime;
    }

    public byte[] getTransactionCounter() {
        return transactionCounter;
    }

    public void setTransactionCounter(byte[] transactionCounter) {
        this.transactionCounter = transactionCounter;
    }

    public byte[] getTableRows() {
        return tableRows;
    }

    public void setTableRows(byte[] tableRows) {
        this.tableRows = tableRows;
    }

    public byte[] getAvgRowLength() {
        return avgRowLength;
    }

    public void setAvgRowLength(byte[] avgRowLength) {
        this.avgRowLength = avgRowLength;
    }

    public byte[] getDataLength() {
        return dataLength;
    }

    public void setDataLength(byte[] dataLength) {
        this.dataLength = dataLength;
    }

    public byte[] getMaxDataLength() {
        return maxDataLength;
    }

    public void setMaxDataLength(byte[] maxDataLength) {
        this.maxDataLength = maxDataLength;
    }

    public byte[] getIndexLength() {
        return indexLength;
    }

    public void setIndexLength(byte[] indexLength) {
        this.indexLength = indexLength;
    }

    public byte[] getCreateTime() {
        return createTime;
    }

    public void setCreateTime(byte[] createTime) {
        this.createTime = createTime;
    }

    public byte[] getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(byte[] updateTime) {
        this.updateTime = updateTime;
    }

    public byte[] getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(byte[] checkTime) {
        this.checkTime = checkTime;
    }

    public byte[] getChecksum() {
        return checksum;
    }

    public void setChecksum(byte[] checksum) {
        this.checksum = checksum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fileId=").append(fileId);
        sb.append(", fileType=").append(fileType);
        sb.append(", tablespaceName=").append(tablespaceName);
        sb.append(", tableCatalog=").append(tableCatalog);
        sb.append(", logfileGroupName=").append(logfileGroupName);
        sb.append(", logfileGroupNumber=").append(logfileGroupNumber);
        sb.append(", engine=").append(engine);
        sb.append(", freeExtents=").append(freeExtents);
        sb.append(", totalExtents=").append(totalExtents);
        sb.append(", extentSize=").append(extentSize);
        sb.append(", initialSize=").append(initialSize);
        sb.append(", maximumSize=").append(maximumSize);
        sb.append(", autoextendSize=").append(autoextendSize);
        sb.append(", version=").append(version);
        sb.append(", rowFormat=").append(rowFormat);
        sb.append(", dataFree=").append(dataFree);
        sb.append(", status=").append(status);
        sb.append(", extra=").append(extra);
        sb.append(", fileName=").append(fileName);
        sb.append(", tableSchema=").append(tableSchema);
        sb.append(", tableName=").append(tableName);
        sb.append(", fulltextKeys=").append(fulltextKeys);
        sb.append(", deletedRows=").append(deletedRows);
        sb.append(", updateCount=").append(updateCount);
        sb.append(", creationTime=").append(creationTime);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", recoverTime=").append(recoverTime);
        sb.append(", transactionCounter=").append(transactionCounter);
        sb.append(", tableRows=").append(tableRows);
        sb.append(", avgRowLength=").append(avgRowLength);
        sb.append(", dataLength=").append(dataLength);
        sb.append(", maxDataLength=").append(maxDataLength);
        sb.append(", indexLength=").append(indexLength);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", checkTime=").append(checkTime);
        sb.append(", checksum=").append(checksum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}