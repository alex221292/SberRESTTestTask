package com.altr.sber.web.pojo.response;

import java.math.BigInteger;

public class UserResponse extends AbstractResponse {
    private BigInteger userId;
    private String userName;

    public BigInteger getUserId() {
        return userId;
    }

    public UserResponse(String status, Integer code) {
        this.status = status;
        this.code = code;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
