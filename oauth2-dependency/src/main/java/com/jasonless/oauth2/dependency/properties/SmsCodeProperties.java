package com.jasonless.oauth2.dependency.properties;

/**
 * @author LiuShiZeng
 */

public class SmsCodeProperties {

    private Integer expirationTime = 240;
    private Integer length = 4;
    private String mobileParameter = "mobile";

    public Integer getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Integer expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getMobileParameter() {
        return mobileParameter;
    }

    public void setMobileParameter(String mobileParameter) {
        this.mobileParameter = mobileParameter;
    }
}
