package com.learn.redisson.config;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

/**
 * autor:liman
 * createtime:2021/3/24
 * comment:OkHttp的配置类
 */
@Configuration
public class OkHttpConfig {

    @Bean
    public X509TrustManager x509TrustManager(){
        return new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
    }

    @Bean
    public SSLSocketFactory sslSocketFactory(){
        //信任任何链接
        SSLContext sslContext= null;
        try {
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null,new TrustManager[]{x509TrustManager()},new SecureRandom());
            return sslContext.getSocketFactory();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return null;
    }

    //TODO：允许所有连接到同一个主机地址的请求共享同一个socket连接(http/tcp)；连接池减少请求延时
    @Bean
    public ConnectionPool pool(){
        return new ConnectionPool(200,5, TimeUnit.MINUTES);
    }

    //TODO:采用构造器Builders设计模式
    @Bean("okHttpClient")
    public OkHttpClient okHttpClient(){
        return new OkHttpClient.Builder()
                .sslSocketFactory(sslSocketFactory(),x509TrustManager())
                .retryOnConnectionFailure(false)
                .connectionPool(pool())
                .connectTimeout(10L,TimeUnit.SECONDS)
                .readTimeout(10L,TimeUnit.SECONDS)
                .build();
    }

}
