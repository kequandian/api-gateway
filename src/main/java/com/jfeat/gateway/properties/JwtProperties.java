package com.jfeat.gateway.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created on 2020/5/25.
 *
 * @author Wen Hao
 */

@Component
@ConfigurationProperties(
        prefix = "jwt"
)
public class JwtProperties {

    public static final String PREFIX = "jwt";
    private String encodedKey;
    private String normalEncodedKey;
    private long ttlMillis = 259200000L;
    private String tokenType = "Bearer";
    private Boolean enableAttemptLogin = true;
    private Boolean nonShiroPermissionCheck = false;

    public JwtProperties() {
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getEncodedKey() {
        return this.encodedKey;
    }

    public void setEncodedKey(String encodedKey) {
        this.encodedKey = encodedKey;
    }

    public String getNormalEncodedKey() {
        return this.normalEncodedKey;
    }

    public void setNormalEncodedKey(String normalEncodedKey) {
        this.normalEncodedKey = normalEncodedKey;
    }

    public long getTtlMillis() {
        return this.ttlMillis;
    }

    public void setTtlMillis(long ttlMillis) {
        this.ttlMillis = ttlMillis;
    }

    public Boolean getNonShiroPermissionCheck() {
        return this.nonShiroPermissionCheck;
    }

    public JwtProperties setNonShiroPermissionCheck(Boolean nonShiroPermissionCheck) {
        this.nonShiroPermissionCheck = nonShiroPermissionCheck;
        return this;
    }

    public Boolean getEnableAttemptLogin() {
        return this.enableAttemptLogin;
    }

    public void setEnableAttemptLogin(Boolean enableAttemptLogin) {
        this.enableAttemptLogin = enableAttemptLogin;
    }
}
