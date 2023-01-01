package com.coderman.foodie.pojo;

import java.io.Serializable;

public class ReplicationConnectionConfiguration implements Serializable {
    private String channelName;

    private String host;

    private Integer port;

    private String user;

    private String networkInterface;

    private String autoPosition;

    private String sslAllowed;

    private String sslCaFile;

    private String sslCaPath;

    private String sslCertificate;

    private String sslCipher;

    private String sslKey;

    private String sslVerifyServerCertificate;

    private String sslCrlFile;

    private String sslCrlPath;

    private Integer connectionRetryInterval;

    private Long connectionRetryCount;

    private Double heartbeatInterval;

    private String tlsVersion;

    private String publicKeyPath;

    private String getPublicKey;

    private String networkNamespace;

    private String compressionAlgorithm;

    private Integer zstdCompressionLevel;

    private String sourceConnectionAutoFailover;

    private String gtidOnly;

    private String tlsCiphersuites;

    private static final long serialVersionUID = 1L;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getNetworkInterface() {
        return networkInterface;
    }

    public void setNetworkInterface(String networkInterface) {
        this.networkInterface = networkInterface == null ? null : networkInterface.trim();
    }

    public String getAutoPosition() {
        return autoPosition;
    }

    public void setAutoPosition(String autoPosition) {
        this.autoPosition = autoPosition == null ? null : autoPosition.trim();
    }

    public String getSslAllowed() {
        return sslAllowed;
    }

    public void setSslAllowed(String sslAllowed) {
        this.sslAllowed = sslAllowed == null ? null : sslAllowed.trim();
    }

    public String getSslCaFile() {
        return sslCaFile;
    }

    public void setSslCaFile(String sslCaFile) {
        this.sslCaFile = sslCaFile == null ? null : sslCaFile.trim();
    }

    public String getSslCaPath() {
        return sslCaPath;
    }

    public void setSslCaPath(String sslCaPath) {
        this.sslCaPath = sslCaPath == null ? null : sslCaPath.trim();
    }

    public String getSslCertificate() {
        return sslCertificate;
    }

    public void setSslCertificate(String sslCertificate) {
        this.sslCertificate = sslCertificate == null ? null : sslCertificate.trim();
    }

    public String getSslCipher() {
        return sslCipher;
    }

    public void setSslCipher(String sslCipher) {
        this.sslCipher = sslCipher == null ? null : sslCipher.trim();
    }

    public String getSslKey() {
        return sslKey;
    }

    public void setSslKey(String sslKey) {
        this.sslKey = sslKey == null ? null : sslKey.trim();
    }

    public String getSslVerifyServerCertificate() {
        return sslVerifyServerCertificate;
    }

    public void setSslVerifyServerCertificate(String sslVerifyServerCertificate) {
        this.sslVerifyServerCertificate = sslVerifyServerCertificate == null ? null : sslVerifyServerCertificate.trim();
    }

    public String getSslCrlFile() {
        return sslCrlFile;
    }

    public void setSslCrlFile(String sslCrlFile) {
        this.sslCrlFile = sslCrlFile == null ? null : sslCrlFile.trim();
    }

    public String getSslCrlPath() {
        return sslCrlPath;
    }

    public void setSslCrlPath(String sslCrlPath) {
        this.sslCrlPath = sslCrlPath == null ? null : sslCrlPath.trim();
    }

    public Integer getConnectionRetryInterval() {
        return connectionRetryInterval;
    }

    public void setConnectionRetryInterval(Integer connectionRetryInterval) {
        this.connectionRetryInterval = connectionRetryInterval;
    }

    public Long getConnectionRetryCount() {
        return connectionRetryCount;
    }

    public void setConnectionRetryCount(Long connectionRetryCount) {
        this.connectionRetryCount = connectionRetryCount;
    }

    public Double getHeartbeatInterval() {
        return heartbeatInterval;
    }

    public void setHeartbeatInterval(Double heartbeatInterval) {
        this.heartbeatInterval = heartbeatInterval;
    }

    public String getTlsVersion() {
        return tlsVersion;
    }

    public void setTlsVersion(String tlsVersion) {
        this.tlsVersion = tlsVersion == null ? null : tlsVersion.trim();
    }

    public String getPublicKeyPath() {
        return publicKeyPath;
    }

    public void setPublicKeyPath(String publicKeyPath) {
        this.publicKeyPath = publicKeyPath == null ? null : publicKeyPath.trim();
    }

    public String getGetPublicKey() {
        return getPublicKey;
    }

    public void setGetPublicKey(String getPublicKey) {
        this.getPublicKey = getPublicKey == null ? null : getPublicKey.trim();
    }

    public String getNetworkNamespace() {
        return networkNamespace;
    }

    public void setNetworkNamespace(String networkNamespace) {
        this.networkNamespace = networkNamespace == null ? null : networkNamespace.trim();
    }

    public String getCompressionAlgorithm() {
        return compressionAlgorithm;
    }

    public void setCompressionAlgorithm(String compressionAlgorithm) {
        this.compressionAlgorithm = compressionAlgorithm == null ? null : compressionAlgorithm.trim();
    }

    public Integer getZstdCompressionLevel() {
        return zstdCompressionLevel;
    }

    public void setZstdCompressionLevel(Integer zstdCompressionLevel) {
        this.zstdCompressionLevel = zstdCompressionLevel;
    }

    public String getSourceConnectionAutoFailover() {
        return sourceConnectionAutoFailover;
    }

    public void setSourceConnectionAutoFailover(String sourceConnectionAutoFailover) {
        this.sourceConnectionAutoFailover = sourceConnectionAutoFailover == null ? null : sourceConnectionAutoFailover.trim();
    }

    public String getGtidOnly() {
        return gtidOnly;
    }

    public void setGtidOnly(String gtidOnly) {
        this.gtidOnly = gtidOnly == null ? null : gtidOnly.trim();
    }

    public String getTlsCiphersuites() {
        return tlsCiphersuites;
    }

    public void setTlsCiphersuites(String tlsCiphersuites) {
        this.tlsCiphersuites = tlsCiphersuites == null ? null : tlsCiphersuites.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", channelName=").append(channelName);
        sb.append(", host=").append(host);
        sb.append(", port=").append(port);
        sb.append(", user=").append(user);
        sb.append(", networkInterface=").append(networkInterface);
        sb.append(", autoPosition=").append(autoPosition);
        sb.append(", sslAllowed=").append(sslAllowed);
        sb.append(", sslCaFile=").append(sslCaFile);
        sb.append(", sslCaPath=").append(sslCaPath);
        sb.append(", sslCertificate=").append(sslCertificate);
        sb.append(", sslCipher=").append(sslCipher);
        sb.append(", sslKey=").append(sslKey);
        sb.append(", sslVerifyServerCertificate=").append(sslVerifyServerCertificate);
        sb.append(", sslCrlFile=").append(sslCrlFile);
        sb.append(", sslCrlPath=").append(sslCrlPath);
        sb.append(", connectionRetryInterval=").append(connectionRetryInterval);
        sb.append(", connectionRetryCount=").append(connectionRetryCount);
        sb.append(", heartbeatInterval=").append(heartbeatInterval);
        sb.append(", tlsVersion=").append(tlsVersion);
        sb.append(", publicKeyPath=").append(publicKeyPath);
        sb.append(", getPublicKey=").append(getPublicKey);
        sb.append(", networkNamespace=").append(networkNamespace);
        sb.append(", compressionAlgorithm=").append(compressionAlgorithm);
        sb.append(", zstdCompressionLevel=").append(zstdCompressionLevel);
        sb.append(", sourceConnectionAutoFailover=").append(sourceConnectionAutoFailover);
        sb.append(", gtidOnly=").append(gtidOnly);
        sb.append(", tlsCiphersuites=").append(tlsCiphersuites);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}