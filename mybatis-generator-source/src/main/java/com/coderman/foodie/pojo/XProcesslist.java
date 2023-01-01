package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class XProcesslist implements Serializable {
    private Long thdId;

    private Long connId;

    private String user;

    private String db;

    private String command;

    private String state;

    private Long time;

    private Long statementLatency;

    private BigDecimal progress;

    private Long lockLatency;

    private Long rowsExamined;

    private Long rowsSent;

    private Long rowsAffected;

    private Long tmpTables;

    private Long tmpDiskTables;

    private String fullScan;

    private Long lastStatementLatency;

    private BigDecimal currentMemory;

    private String lastWait;

    private String lastWaitLatency;

    private String source;

    private Long trxLatency;

    private String trxState;

    private String trxAutocommit;

    private String pid;

    private String programName;

    private String currentStatement;

    private String lastStatement;

    private static final long serialVersionUID = 1L;

    public Long getThdId() {
        return thdId;
    }

    public void setThdId(Long thdId) {
        this.thdId = thdId;
    }

    public Long getConnId() {
        return connId;
    }

    public void setConnId(Long connId) {
        this.connId = connId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db == null ? null : db.trim();
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command == null ? null : command.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getStatementLatency() {
        return statementLatency;
    }

    public void setStatementLatency(Long statementLatency) {
        this.statementLatency = statementLatency;
    }

    public BigDecimal getProgress() {
        return progress;
    }

    public void setProgress(BigDecimal progress) {
        this.progress = progress;
    }

    public Long getLockLatency() {
        return lockLatency;
    }

    public void setLockLatency(Long lockLatency) {
        this.lockLatency = lockLatency;
    }

    public Long getRowsExamined() {
        return rowsExamined;
    }

    public void setRowsExamined(Long rowsExamined) {
        this.rowsExamined = rowsExamined;
    }

    public Long getRowsSent() {
        return rowsSent;
    }

    public void setRowsSent(Long rowsSent) {
        this.rowsSent = rowsSent;
    }

    public Long getRowsAffected() {
        return rowsAffected;
    }

    public void setRowsAffected(Long rowsAffected) {
        this.rowsAffected = rowsAffected;
    }

    public Long getTmpTables() {
        return tmpTables;
    }

    public void setTmpTables(Long tmpTables) {
        this.tmpTables = tmpTables;
    }

    public Long getTmpDiskTables() {
        return tmpDiskTables;
    }

    public void setTmpDiskTables(Long tmpDiskTables) {
        this.tmpDiskTables = tmpDiskTables;
    }

    public String getFullScan() {
        return fullScan;
    }

    public void setFullScan(String fullScan) {
        this.fullScan = fullScan == null ? null : fullScan.trim();
    }

    public Long getLastStatementLatency() {
        return lastStatementLatency;
    }

    public void setLastStatementLatency(Long lastStatementLatency) {
        this.lastStatementLatency = lastStatementLatency;
    }

    public BigDecimal getCurrentMemory() {
        return currentMemory;
    }

    public void setCurrentMemory(BigDecimal currentMemory) {
        this.currentMemory = currentMemory;
    }

    public String getLastWait() {
        return lastWait;
    }

    public void setLastWait(String lastWait) {
        this.lastWait = lastWait == null ? null : lastWait.trim();
    }

    public String getLastWaitLatency() {
        return lastWaitLatency;
    }

    public void setLastWaitLatency(String lastWaitLatency) {
        this.lastWaitLatency = lastWaitLatency == null ? null : lastWaitLatency.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Long getTrxLatency() {
        return trxLatency;
    }

    public void setTrxLatency(Long trxLatency) {
        this.trxLatency = trxLatency;
    }

    public String getTrxState() {
        return trxState;
    }

    public void setTrxState(String trxState) {
        this.trxState = trxState == null ? null : trxState.trim();
    }

    public String getTrxAutocommit() {
        return trxAutocommit;
    }

    public void setTrxAutocommit(String trxAutocommit) {
        this.trxAutocommit = trxAutocommit == null ? null : trxAutocommit.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName == null ? null : programName.trim();
    }

    public String getCurrentStatement() {
        return currentStatement;
    }

    public void setCurrentStatement(String currentStatement) {
        this.currentStatement = currentStatement == null ? null : currentStatement.trim();
    }

    public String getLastStatement() {
        return lastStatement;
    }

    public void setLastStatement(String lastStatement) {
        this.lastStatement = lastStatement == null ? null : lastStatement.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", thdId=").append(thdId);
        sb.append(", connId=").append(connId);
        sb.append(", user=").append(user);
        sb.append(", db=").append(db);
        sb.append(", command=").append(command);
        sb.append(", state=").append(state);
        sb.append(", time=").append(time);
        sb.append(", statementLatency=").append(statementLatency);
        sb.append(", progress=").append(progress);
        sb.append(", lockLatency=").append(lockLatency);
        sb.append(", rowsExamined=").append(rowsExamined);
        sb.append(", rowsSent=").append(rowsSent);
        sb.append(", rowsAffected=").append(rowsAffected);
        sb.append(", tmpTables=").append(tmpTables);
        sb.append(", tmpDiskTables=").append(tmpDiskTables);
        sb.append(", fullScan=").append(fullScan);
        sb.append(", lastStatementLatency=").append(lastStatementLatency);
        sb.append(", currentMemory=").append(currentMemory);
        sb.append(", lastWait=").append(lastWait);
        sb.append(", lastWaitLatency=").append(lastWaitLatency);
        sb.append(", source=").append(source);
        sb.append(", trxLatency=").append(trxLatency);
        sb.append(", trxState=").append(trxState);
        sb.append(", trxAutocommit=").append(trxAutocommit);
        sb.append(", pid=").append(pid);
        sb.append(", programName=").append(programName);
        sb.append(", currentStatement=").append(currentStatement);
        sb.append(", lastStatement=").append(lastStatement);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}