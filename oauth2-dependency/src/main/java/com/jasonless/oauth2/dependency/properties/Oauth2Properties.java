package com.jasonless.oauth2.dependency.properties;

import com.jasonless.oauth2.dependency.domain.TokenStoreType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiuShiZeng
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("oauth2")
public class Oauth2Properties {

    private TokenStoreType tokenStoreType = TokenStoreType.memory;

    private String loginProcessUrl ="/auth/authorize";

    private String tokenSigningKey = "123456123";

    @NestedConfigurationProperty
    private Oauth2LogLevelProperties logging = new Oauth2LogLevelProperties();

    @NestedConfigurationProperty
    private SmsCodeProperties smsCodeProperties = new SmsCodeProperties();


    public TokenStoreType getTokenStoreType() {
        return tokenStoreType;
    }

    public void setTokenStoreType(TokenStoreType tokenStoreType) {
        this.tokenStoreType = tokenStoreType;
    }

    public String getLoginProcessUrl() {
        return loginProcessUrl;
    }

    public void setLoginProcessUrl(String loginProcessUrl) {
        this.loginProcessUrl = loginProcessUrl;
    }

    public String getTokenSigningKey() {
        return tokenSigningKey;
    }

    public void setTokenSigningKey(String tokenSigningKey) {
        this.tokenSigningKey = tokenSigningKey;
    }

    public Oauth2LogLevelProperties getLogging() {
        return logging;
    }

    public void setLogging(Oauth2LogLevelProperties logging) {
        this.logging = logging;
    }

    public SmsCodeProperties getSmsCodeProperties() {
        return smsCodeProperties;
    }

    public void setSmsCodeProperties(SmsCodeProperties smsCodeProperties) {
        this.smsCodeProperties = smsCodeProperties;
    }
}
