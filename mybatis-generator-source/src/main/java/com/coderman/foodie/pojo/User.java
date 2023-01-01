package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String host;

    private String user;

    private String selectPriv;

    private String insertPriv;

    private String updatePriv;

    private String deletePriv;

    private String createPriv;

    private String dropPriv;

    private String reloadPriv;

    private String shutdownPriv;

    private String processPriv;

    private String filePriv;

    private String grantPriv;

    private String referencesPriv;

    private String indexPriv;

    private String alterPriv;

    private String showDbPriv;

    private String superPriv;

    private String createTmpTablePriv;

    private String lockTablesPriv;

    private String executePriv;

    private String replSlavePriv;

    private String replClientPriv;

    private String createViewPriv;

    private String showViewPriv;

    private String createRoutinePriv;

    private String alterRoutinePriv;

    private String createUserPriv;

    private String eventPriv;

    private String triggerPriv;

    private String createTablespacePriv;

    private String sslType;

    private Integer maxQuestions;

    private Integer maxUpdates;

    private Integer maxConnections;

    private Integer maxUserConnections;

    private String plugin;

    private String passwordExpired;

    private Date passwordLastChanged;

    private Short passwordLifetime;

    private String accountLocked;

    private String createRolePriv;

    private String dropRolePriv;

    private Short passwordReuseHistory;

    private Short passwordReuseTime;

    private String passwordRequireCurrent;

    private byte[] sslCipher;

    private byte[] x509Issuer;

    private byte[] x509Subject;

    private String authenticationString;

    private String userAttributes;

    private static final long serialVersionUID = 1L;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getSelectPriv() {
        return selectPriv;
    }

    public void setSelectPriv(String selectPriv) {
        this.selectPriv = selectPriv == null ? null : selectPriv.trim();
    }

    public String getInsertPriv() {
        return insertPriv;
    }

    public void setInsertPriv(String insertPriv) {
        this.insertPriv = insertPriv == null ? null : insertPriv.trim();
    }

    public String getUpdatePriv() {
        return updatePriv;
    }

    public void setUpdatePriv(String updatePriv) {
        this.updatePriv = updatePriv == null ? null : updatePriv.trim();
    }

    public String getDeletePriv() {
        return deletePriv;
    }

    public void setDeletePriv(String deletePriv) {
        this.deletePriv = deletePriv == null ? null : deletePriv.trim();
    }

    public String getCreatePriv() {
        return createPriv;
    }

    public void setCreatePriv(String createPriv) {
        this.createPriv = createPriv == null ? null : createPriv.trim();
    }

    public String getDropPriv() {
        return dropPriv;
    }

    public void setDropPriv(String dropPriv) {
        this.dropPriv = dropPriv == null ? null : dropPriv.trim();
    }

    public String getReloadPriv() {
        return reloadPriv;
    }

    public void setReloadPriv(String reloadPriv) {
        this.reloadPriv = reloadPriv == null ? null : reloadPriv.trim();
    }

    public String getShutdownPriv() {
        return shutdownPriv;
    }

    public void setShutdownPriv(String shutdownPriv) {
        this.shutdownPriv = shutdownPriv == null ? null : shutdownPriv.trim();
    }

    public String getProcessPriv() {
        return processPriv;
    }

    public void setProcessPriv(String processPriv) {
        this.processPriv = processPriv == null ? null : processPriv.trim();
    }

    public String getFilePriv() {
        return filePriv;
    }

    public void setFilePriv(String filePriv) {
        this.filePriv = filePriv == null ? null : filePriv.trim();
    }

    public String getGrantPriv() {
        return grantPriv;
    }

    public void setGrantPriv(String grantPriv) {
        this.grantPriv = grantPriv == null ? null : grantPriv.trim();
    }

    public String getReferencesPriv() {
        return referencesPriv;
    }

    public void setReferencesPriv(String referencesPriv) {
        this.referencesPriv = referencesPriv == null ? null : referencesPriv.trim();
    }

    public String getIndexPriv() {
        return indexPriv;
    }

    public void setIndexPriv(String indexPriv) {
        this.indexPriv = indexPriv == null ? null : indexPriv.trim();
    }

    public String getAlterPriv() {
        return alterPriv;
    }

    public void setAlterPriv(String alterPriv) {
        this.alterPriv = alterPriv == null ? null : alterPriv.trim();
    }

    public String getShowDbPriv() {
        return showDbPriv;
    }

    public void setShowDbPriv(String showDbPriv) {
        this.showDbPriv = showDbPriv == null ? null : showDbPriv.trim();
    }

    public String getSuperPriv() {
        return superPriv;
    }

    public void setSuperPriv(String superPriv) {
        this.superPriv = superPriv == null ? null : superPriv.trim();
    }

    public String getCreateTmpTablePriv() {
        return createTmpTablePriv;
    }

    public void setCreateTmpTablePriv(String createTmpTablePriv) {
        this.createTmpTablePriv = createTmpTablePriv == null ? null : createTmpTablePriv.trim();
    }

    public String getLockTablesPriv() {
        return lockTablesPriv;
    }

    public void setLockTablesPriv(String lockTablesPriv) {
        this.lockTablesPriv = lockTablesPriv == null ? null : lockTablesPriv.trim();
    }

    public String getExecutePriv() {
        return executePriv;
    }

    public void setExecutePriv(String executePriv) {
        this.executePriv = executePriv == null ? null : executePriv.trim();
    }

    public String getReplSlavePriv() {
        return replSlavePriv;
    }

    public void setReplSlavePriv(String replSlavePriv) {
        this.replSlavePriv = replSlavePriv == null ? null : replSlavePriv.trim();
    }

    public String getReplClientPriv() {
        return replClientPriv;
    }

    public void setReplClientPriv(String replClientPriv) {
        this.replClientPriv = replClientPriv == null ? null : replClientPriv.trim();
    }

    public String getCreateViewPriv() {
        return createViewPriv;
    }

    public void setCreateViewPriv(String createViewPriv) {
        this.createViewPriv = createViewPriv == null ? null : createViewPriv.trim();
    }

    public String getShowViewPriv() {
        return showViewPriv;
    }

    public void setShowViewPriv(String showViewPriv) {
        this.showViewPriv = showViewPriv == null ? null : showViewPriv.trim();
    }

    public String getCreateRoutinePriv() {
        return createRoutinePriv;
    }

    public void setCreateRoutinePriv(String createRoutinePriv) {
        this.createRoutinePriv = createRoutinePriv == null ? null : createRoutinePriv.trim();
    }

    public String getAlterRoutinePriv() {
        return alterRoutinePriv;
    }

    public void setAlterRoutinePriv(String alterRoutinePriv) {
        this.alterRoutinePriv = alterRoutinePriv == null ? null : alterRoutinePriv.trim();
    }

    public String getCreateUserPriv() {
        return createUserPriv;
    }

    public void setCreateUserPriv(String createUserPriv) {
        this.createUserPriv = createUserPriv == null ? null : createUserPriv.trim();
    }

    public String getEventPriv() {
        return eventPriv;
    }

    public void setEventPriv(String eventPriv) {
        this.eventPriv = eventPriv == null ? null : eventPriv.trim();
    }

    public String getTriggerPriv() {
        return triggerPriv;
    }

    public void setTriggerPriv(String triggerPriv) {
        this.triggerPriv = triggerPriv == null ? null : triggerPriv.trim();
    }

    public String getCreateTablespacePriv() {
        return createTablespacePriv;
    }

    public void setCreateTablespacePriv(String createTablespacePriv) {
        this.createTablespacePriv = createTablespacePriv == null ? null : createTablespacePriv.trim();
    }

    public String getSslType() {
        return sslType;
    }

    public void setSslType(String sslType) {
        this.sslType = sslType == null ? null : sslType.trim();
    }

    public Integer getMaxQuestions() {
        return maxQuestions;
    }

    public void setMaxQuestions(Integer maxQuestions) {
        this.maxQuestions = maxQuestions;
    }

    public Integer getMaxUpdates() {
        return maxUpdates;
    }

    public void setMaxUpdates(Integer maxUpdates) {
        this.maxUpdates = maxUpdates;
    }

    public Integer getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
    }

    public Integer getMaxUserConnections() {
        return maxUserConnections;
    }

    public void setMaxUserConnections(Integer maxUserConnections) {
        this.maxUserConnections = maxUserConnections;
    }

    public String getPlugin() {
        return plugin;
    }

    public void setPlugin(String plugin) {
        this.plugin = plugin == null ? null : plugin.trim();
    }

    public String getPasswordExpired() {
        return passwordExpired;
    }

    public void setPasswordExpired(String passwordExpired) {
        this.passwordExpired = passwordExpired == null ? null : passwordExpired.trim();
    }

    public Date getPasswordLastChanged() {
        return passwordLastChanged;
    }

    public void setPasswordLastChanged(Date passwordLastChanged) {
        this.passwordLastChanged = passwordLastChanged;
    }

    public Short getPasswordLifetime() {
        return passwordLifetime;
    }

    public void setPasswordLifetime(Short passwordLifetime) {
        this.passwordLifetime = passwordLifetime;
    }

    public String getAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(String accountLocked) {
        this.accountLocked = accountLocked == null ? null : accountLocked.trim();
    }

    public String getCreateRolePriv() {
        return createRolePriv;
    }

    public void setCreateRolePriv(String createRolePriv) {
        this.createRolePriv = createRolePriv == null ? null : createRolePriv.trim();
    }

    public String getDropRolePriv() {
        return dropRolePriv;
    }

    public void setDropRolePriv(String dropRolePriv) {
        this.dropRolePriv = dropRolePriv == null ? null : dropRolePriv.trim();
    }

    public Short getPasswordReuseHistory() {
        return passwordReuseHistory;
    }

    public void setPasswordReuseHistory(Short passwordReuseHistory) {
        this.passwordReuseHistory = passwordReuseHistory;
    }

    public Short getPasswordReuseTime() {
        return passwordReuseTime;
    }

    public void setPasswordReuseTime(Short passwordReuseTime) {
        this.passwordReuseTime = passwordReuseTime;
    }

    public String getPasswordRequireCurrent() {
        return passwordRequireCurrent;
    }

    public void setPasswordRequireCurrent(String passwordRequireCurrent) {
        this.passwordRequireCurrent = passwordRequireCurrent == null ? null : passwordRequireCurrent.trim();
    }

    public byte[] getSslCipher() {
        return sslCipher;
    }

    public void setSslCipher(byte[] sslCipher) {
        this.sslCipher = sslCipher;
    }

    public byte[] getX509Issuer() {
        return x509Issuer;
    }

    public void setX509Issuer(byte[] x509Issuer) {
        this.x509Issuer = x509Issuer;
    }

    public byte[] getX509Subject() {
        return x509Subject;
    }

    public void setX509Subject(byte[] x509Subject) {
        this.x509Subject = x509Subject;
    }

    public String getAuthenticationString() {
        return authenticationString;
    }

    public void setAuthenticationString(String authenticationString) {
        this.authenticationString = authenticationString == null ? null : authenticationString.trim();
    }

    public String getUserAttributes() {
        return userAttributes;
    }

    public void setUserAttributes(String userAttributes) {
        this.userAttributes = userAttributes == null ? null : userAttributes.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", host=").append(host);
        sb.append(", user=").append(user);
        sb.append(", selectPriv=").append(selectPriv);
        sb.append(", insertPriv=").append(insertPriv);
        sb.append(", updatePriv=").append(updatePriv);
        sb.append(", deletePriv=").append(deletePriv);
        sb.append(", createPriv=").append(createPriv);
        sb.append(", dropPriv=").append(dropPriv);
        sb.append(", reloadPriv=").append(reloadPriv);
        sb.append(", shutdownPriv=").append(shutdownPriv);
        sb.append(", processPriv=").append(processPriv);
        sb.append(", filePriv=").append(filePriv);
        sb.append(", grantPriv=").append(grantPriv);
        sb.append(", referencesPriv=").append(referencesPriv);
        sb.append(", indexPriv=").append(indexPriv);
        sb.append(", alterPriv=").append(alterPriv);
        sb.append(", showDbPriv=").append(showDbPriv);
        sb.append(", superPriv=").append(superPriv);
        sb.append(", createTmpTablePriv=").append(createTmpTablePriv);
        sb.append(", lockTablesPriv=").append(lockTablesPriv);
        sb.append(", executePriv=").append(executePriv);
        sb.append(", replSlavePriv=").append(replSlavePriv);
        sb.append(", replClientPriv=").append(replClientPriv);
        sb.append(", createViewPriv=").append(createViewPriv);
        sb.append(", showViewPriv=").append(showViewPriv);
        sb.append(", createRoutinePriv=").append(createRoutinePriv);
        sb.append(", alterRoutinePriv=").append(alterRoutinePriv);
        sb.append(", createUserPriv=").append(createUserPriv);
        sb.append(", eventPriv=").append(eventPriv);
        sb.append(", triggerPriv=").append(triggerPriv);
        sb.append(", createTablespacePriv=").append(createTablespacePriv);
        sb.append(", sslType=").append(sslType);
        sb.append(", maxQuestions=").append(maxQuestions);
        sb.append(", maxUpdates=").append(maxUpdates);
        sb.append(", maxConnections=").append(maxConnections);
        sb.append(", maxUserConnections=").append(maxUserConnections);
        sb.append(", plugin=").append(plugin);
        sb.append(", passwordExpired=").append(passwordExpired);
        sb.append(", passwordLastChanged=").append(passwordLastChanged);
        sb.append(", passwordLifetime=").append(passwordLifetime);
        sb.append(", accountLocked=").append(accountLocked);
        sb.append(", createRolePriv=").append(createRolePriv);
        sb.append(", dropRolePriv=").append(dropRolePriv);
        sb.append(", passwordReuseHistory=").append(passwordReuseHistory);
        sb.append(", passwordReuseTime=").append(passwordReuseTime);
        sb.append(", passwordRequireCurrent=").append(passwordRequireCurrent);
        sb.append(", sslCipher=").append(sslCipher);
        sb.append(", x509Issuer=").append(x509Issuer);
        sb.append(", x509Subject=").append(x509Subject);
        sb.append(", authenticationString=").append(authenticationString);
        sb.append(", userAttributes=").append(userAttributes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}